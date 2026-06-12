/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.teamwork.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradamx.calculofidelitypradamx.entity.ClientesFidelityFinal;
import com.pradamx.calculofidelitypradamx.entity.clientesDiscriminarBaseFinal;
import com.pradamx.calculofidelitypradamx.searchcustomrresponse.CustomersType;
import com.pradamx.calculofidelitypradamx.service.ClientesFidelityFinalService;
import com.pradamx.calculofidelitypradamx.service.clientesDiscriminarBaseFinalService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author analistabi2
 */
@Service("EnviarClientesTWR")
public class EnviarClientesTWR {

    @Autowired
    private clientesDiscriminarBaseFinalService clientesDiscriminarBaseFinalService;

    @Autowired
    private ClientesFidelityFinalService ClientesFidelityFinalService;

    public void IniciarProceso(List<ClientesFidelityFinal> ATabla) {
        List<ClientesFidelityFinal> Clientes = this.FiltrarDatos(ATabla);
        if (Clientes != null) {
            System.out.println("Total de clientes a modificar en Teamwork: " + Clientes.size());
            List<String> listaDepura = ObtenerCustomerIDparaBuscar(Clientes);
            List<CustomersType> listaCleitnesModificados = this.buscarCustomerTWR(listaDepura);
            RequestCreateUpdateCustomer requestFinal = GeneraJSON(listaCleitnesModificados, Clientes);
            String validar = this.enviarDatosCHQ(requestFinal);
            if (validar != null) {
                System.out.println("No se actualizo el nivel de membresia");
            } else {
                System.out.println("Se actualizo el nivel de membresia de forma correcta");
            }

        } else {
            System.out.println("No se encontro clientes o todos eran duplicados");
        }

    }

    public RequestCreateUpdateCustomer GeneraJSON(List<CustomersType> AListaCustomerTWR, List<ClientesFidelityFinal> ATabla) {
        RequestCreateUpdateCustomer request = new RequestCreateUpdateCustomer();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        request.setSource("Prada");
        DataCreateUpdateCustomer data = new DataCreateUpdateCustomer();
        Request requestData = new Request();
        SettingsCreateUpdateCustomer setings = new SettingsCreateUpdateCustomer();
        setings.setKeyField("MembershipCode");
        setings.setEmployeeSetting("TeamworkId");
        setings.setIgnoreCustomRequiredFields(Boolean.TRUE);
        requestData.setSettings(setings);

        Map<String, ClientesFidelityFinal> mapaNiveles = new HashMap<>();
        for (ClientesFidelityFinal nivel : ATabla) {
            mapaNiveles.put(nivel.getCustomerId(), nivel);
        }

        List<CustomerCreateUpdateCustomer> customer = new ArrayList<>();
        for (CustomersType clienteMod : AListaCustomerTWR) {
            ClientesFidelityFinal nivel = mapaNiveles.get(clienteMod.getCustomerId());
            if (nivel != null) {
                CustomerCreateUpdateCustomer cliente = new CustomerCreateUpdateCustomer();
                cliente.setCustomerNo(clienteMod.getCustomerNo());
                cliente.setPhone1(clienteMod.getPhone1());
                cliente.setFirstName(clienteMod.getFirstName());
                cliente.setLastName(clienteMod.getLastName());
                MembershipCreateUpdateCustomer membresia = new MembershipCreateUpdateCustomer();
                membresia.setMembershipCode(clienteMod.getMembershipCode());
                switch (nivel.getNivel()) {
                    case "Fidelity":
                        membresia.setMembershipLevelName("FIDELITY");
                        membresia.setMembershipEndDate(formato.format(nivel.getFechaVencimiento()));
                        break;
                    case "Elite":
                        membresia.setMembershipLevelName("ELITE");
                        membresia.setMembershipEndDate(formato.format(nivel.getFechaVencimiento()));
                        break;
                    case "Sin membresia":
                        membresia.setMembershipLevelName("SINMEMBRESIA");
                        membresia.setMembershipEndDate("");
                        break;
                    case "Premier":
                        membresia.setMembershipLevelName("PREMIER");
                        membresia.setMembershipEndDate(formato.format(nivel.getFechaVencimiento()));
                        break;
                }

                membresia.setMembershipType("Permanent");
                cliente.setMembership(membresia);
                List<ExtIdentifier> ExtIdentifierList = new ArrayList<>();
                ExtIdentifier ExtIdentifier = new ExtIdentifier();
                ExtIdentifier.setType("EID");
                ExtIdentifier.setEid(clienteMod.getCustomerId());
                ExtIdentifierList.add(ExtIdentifier);
                cliente.setExtIdentifiers(ExtIdentifierList);

                CustomFieldsCreateUpdateeCustomer custom = new CustomFieldsCreateUpdateeCustomer();

                custom.setCustomdecimal1(BigDecimal.valueOf(nivel.getMontoMantener()));
                custom.setCustomdecimal2(BigDecimal.valueOf(nivel.getMontoAscender()));

                cliente.setCustomFields(custom);
                customer.add(cliente);

            } else {
                System.out.println("No se encuentro Customer ID: " + clienteMod.getCustomerId());
            }
        }
        requestData.setCustomers(customer);
        data.setRequest(requestData);
        request.setData(data);
        return request;

    }

    public List<ClientesFidelityFinal> FiltrarDatos(List<ClientesFidelityFinal> ATabla) {
        if (ATabla == null || ATabla.isEmpty()) {
            System.out.println("La tabla recibida está vacía o es nula.");
            return Collections.emptyList();
        }

        List<ClientesFidelityFinal> clientesFinal = new ArrayList<>();

        for (ClientesFidelityFinal registro : ATabla) {
            try {
                clientesDiscriminarBaseFinal clienteDiscriminado
                        = clientesDiscriminarBaseFinalService.BuscarCustomerId(registro.getCustomerId());

                // Solo agregar si NO está discriminado
                if (clienteDiscriminado == null) {
                    ClientesFidelityFinal clienteValido
                            = ClientesFidelityFinalService.buscarCustomerId(registro.getCustomerId());

                    if (clienteValido != null) {
                        clientesFinal.add(clienteValido);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error procesando el cliente ID: " + registro.getCustomerId() + " - " + e.getMessage());
                // Continúa con el siguiente
            }
        }

        if (clientesFinal.isEmpty()) {
            System.out.println("No se encontraron clientes para modificar.");
            return Collections.emptyList();
        }

        System.out.println("Clientes totales a modificar: " + clientesFinal.size());
        return clientesFinal;
    }

    public List<String> ObtenerCustomerIDparaBuscar(List<ClientesFidelityFinal> ATabla) {
        List<String> listaDepura = ATabla.stream()
                .map(ClientesFidelityFinal::getCustomerId)
                .collect(Collectors.toList());
        return listaDepura;
    }

    private List<CustomersType> buscarCustomerTWR(List<String> ALista) {

        try {
            System.out.println("Lista Total de clietnes a buscar: " + ALista.size());
            String ACustomerID = String.join(",", ALista);
            Conexion requestClientes = new Conexion();
            List<CustomersType> listResponse = new ArrayList<>();
            int chunkSize = 1000;
            int count = 0;

            List<CustomersType> listcustomer = requestClientes.buscarporCustomerId("https://prada-prod-mx-chq.teamworkinsight.com/chqapi/export/customer", ACustomerID, chunkSize, count);
            System.out.println("JSON RESPONSE LIST ALL CLIENTES: " + listcustomer);
            if (listcustomer != null) {
                listResponse.addAll(listcustomer);
            }
            int size = listcustomer != null ? listcustomer.size() : 0;
            count = count + size;
            while (size > 0 && size == chunkSize) {
                listcustomer = requestClientes.buscarporCustomerId("https://prada-prod-mx-chq.teamworkinsight.com/chqapi/export/customer", ACustomerID, chunkSize, count);
                System.out.println("JSON RESPONSE LIST ALL CLIENTES: " + listcustomer);
                if (listcustomer != null) {
                    listResponse.addAll(listcustomer);
                }
                size = listcustomer != null ? listcustomer.size() : 0;
                count = count + size;
            }
            return listResponse;
        } catch (IOException error) {
            Logger.getLogger(EnviarClientesTWR.class.getName()).log(Level.SEVERE, "Error al buscar clientes en Teamwork: ", error);
            return null;
        }
    }

    private String enviarDatosCHQ(RequestCreateUpdateCustomer AJSON) {
        ObjectMapper mapper = new ObjectMapper();
        Conexion httpChqUtil = new Conexion();
        try {
            String jsonRequest = mapper.writeValueAsString(AJSON);
            System.out.println(jsonRequest);
            String responseString = httpChqUtil.CreateUpdateCustomer(jsonRequest);
            System.out.println(responseString);
            if (responseString != null) {
                ResponseGenerico _response = mapper.readValue(responseString, ResponseGenerico.class);
                String checkStatus = this.validarEstatus(_response.getId());
                return checkStatus;
            } else {
                return null;
            }
        } catch (IOException error) {
            return null;
        }
    }

    private String validarEstatus(String _id) {
        try {
            Conexion httpChqUtil = new Conexion();
            ResponseGenerico _repsonseStatus = httpChqUtil.checkStatus(_id);
            while ("InProcess".equals(_repsonseStatus.getStatus())) {
                _repsonseStatus = httpChqUtil.checkStatus(_id);
                TimeUnit.SECONDS.sleep(5);
            }
            return _repsonseStatus.getStatus();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(EnviarClientesTWR.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";
        }
    }
}
