/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.service;

import com.pradamx.calculofidelitypradamx.entity.ClientesFidelityFinal;
import com.pradamx.calculofidelitypradamx.repository.ClientesFidelityFinalRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EduardoZuñigaHerrema
 */
@Service("ClientesFidelityFinalService")
public class ClientesFidelityFinalService {

    @Autowired
    private ClientesFidelityFinalRepository ClientesFidelityFinalRepository;

    public List<ClientesFidelityFinal> findAll() {
        return this.ClientesFidelityFinalRepository.findAll();
    }

    public ClientesFidelityFinal save(ClientesFidelityFinal id_tabla) {
        return this.ClientesFidelityFinalRepository.save(id_tabla);
    }

    public List<ClientesFidelityFinal> BuscarXNivel(String ANivel) {
        return this.ClientesFidelityFinalRepository.BuscarXNivel(ANivel);
    }

    public List<ClientesFidelityFinal> BuscarActualizar(Integer AEstatus) {
        return this.ClientesFidelityFinalRepository.BuscarActualizar(AEstatus);
    }
    
    public List<ClientesFidelityFinal> buscarPorCustomerIds(List<String> ACustomerList) {
        return this.ClientesFidelityFinalRepository.buscarPorCustomerIds(ACustomerList);
    }
    public ClientesFidelityFinal buscarCustomerId(String ACustomer) {
        return this.ClientesFidelityFinalRepository.buscarCustomerId(ACustomer);
    }

    public void GuardarClienteFidelity(String ACustomerID, Date AFechaFidelizacion, Date AFechaVencimineto, Double ComprasAcumuladas, String ANivel, Double AMontoMantener, Double MontoAscender, Integer Actualizar){
        ClientesFidelityFinal cliente = new ClientesFidelityFinal();
        
        cliente.setCustomerId(ACustomerID);
        cliente.setFechaFidelizacion(AFechaFidelizacion);
        cliente.setFechaVencimiento(AFechaVencimineto);
        cliente.setComprasAcumuladas(ComprasAcumuladas);
        cliente.setNivel(ANivel);
        cliente.setMontoMantener(AMontoMantener);
        cliente.setMontoAscender(MontoAscender);
        cliente.setActualizar(Actualizar);
        
        save(cliente);       
    }
}
