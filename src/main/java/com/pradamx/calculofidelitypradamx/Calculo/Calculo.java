/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.Calculo;

import com.pradamx.calculofidelitypradamx.teamwork.api.EnviarClientesTWR;
import com.pradamx.calculofidelitypradamx.contenedor.DataCalculo;
import com.pradamx.calculofidelitypradamx.entity.ClientesFidelityFinal;
import com.pradamx.calculofidelitypradamx.entity.DevolucionesNormalesDTO;
import com.pradamx.calculofidelitypradamx.entity.NivelFidelityhistorico;
import com.pradamx.calculofidelitypradamx.entity.ProcesoManualFidelity;
import com.pradamx.calculofidelitypradamx.entity.vAcumuladoVentasFidelity;
import com.pradamx.calculofidelitypradamx.service.ClientesFidelityFinalService;
import com.pradamx.calculofidelitypradamx.service.NivelFidelityhistoricoService;
import com.pradamx.calculofidelitypradamx.service.ProcesoManualFidelityService;
import com.pradamx.calculofidelitypradamx.service.vAcumuladoVentasFidelityService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Calculo")
public class Calculo {

    @Autowired
    private vAcumuladoVentasFidelityService vAcumuladoVentasFidelityService;

    @Autowired
    private ProcesoManualFidelityService ProcesoManualFidelityService;

    @Autowired
    private ClientesFidelityFinalService ClientesFidelityFinalService;

    @Autowired
    private GeneraArchivoExcel GeneraArchivoExcel;
    @Autowired
    private EnviarClientesTWR enviarTWR;
    @Autowired
    private NivelFidelityhistoricoService NivelFidelityhistoricoService;

    public void ProcesoDiario() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<ClientesFidelityFinal> TodosClientes = ClientesFidelityFinalService.BuscarActualizar(1);
        //List<ClientesFidelityFinal> TodosClientes = ClientesFidelityFinalService.findAll();
        //List<ClientesFidelityFinal> TodosClientes = ClientesFidelityFinalService.BuscarXNivel("");
        if (TodosClientes != null && !TodosClientes.isEmpty()) {
            for (ClientesFidelityFinal UnoCliente : TodosClientes) {
                // Extraer la informacion
                List<vAcumuladoVentasFidelity> RegistrosSQL = vAcumuladoVentasFidelityService.buscarPorCustomerId(UnoCliente.getCustomerId());
                System.out.println("CustomerId: " + UnoCliente.getCustomerId());
                if (RegistrosSQL != null && !RegistrosSQL.isEmpty()) {
                    System.out.println("Total de registros Obtenidos del Customer: " + UnoCliente.getCustomerId() + " son: " + RegistrosSQL.size());

                    List<DataCalculo> RegistrosExcel = new ArrayList<>();
                    Double Acumulado = 0.00;
                    Double MontoMantener = 0.00;
                    int index = 0;
                    String UltimoNivel = null;
                    String fechaVencimientoActual = null;
                    Date fechaRegistroFidelity = null;

                    for (vAcumuladoVentasFidelity Registro : RegistrosSQL) {
                        fechaRegistroFidelity = Registro.getFecha_inscripción_Fidelity();

                        if (Registro.getUniversalNo() == 0 & Registro.getFecha_Asignacion() == null) {
                            DataCalculo RegistroExcelSinCompras = CalculaFechaVencimientoSinCompras(Registro);
                            RegistrosExcel.add(RegistroExcelSinCompras);

                        } else {
                            DataCalculo RegistroExcel = this.ValoresGenerales(Registro);

                            Acumulado = Registro.getMonto() + Acumulado;
                            //System.out.println("Ticket: " + Registro.getUniversalNo() + " Monto Venta: " + Registro.getMonto() + " Acumulado: " + Acumulado);

                            if (index == 0) {
                                RegistroExcel = CalcularPrimeraLinea(RegistroExcel, Acumulado, Registro);
                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());
                                RegistroExcel = CalcularMontosAscensoDescenso(RegistroExcel, Acumulado);
                                RegistrosExcel.add(RegistroExcel);
                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                UltimoNivel = RegistroExcel.getNivel();
                                index++;

                            } else {
                                Boolean venta = ValidarFechasMoviminetos(Registro.getFecha_Asignacion(), formato.parse(fechaVencimientoActual));
                                if (venta == true) {
                                    if (MontoMantener == 0) {
                                        DataCalculo RegistroVencimineto = GeneraLineaReseteo(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), UltimoNivel, "Se mantiene");
                                        RegistrosExcel.add(RegistroVencimineto);
                                        Acumulado = Registro.getMonto();
                                        MontoMantener = 0.00;
                                        fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                        UltimoNivel = RegistroVencimineto.getNivel();
                                        RegistroExcel = this.ValoresGenerales(Registro);

                                    } else {
                                        if ("Premier".equals(UltimoNivel) && Acumulado >= 60001) {
                                            DataCalculo RegistroVencimineto = GeneraLineaReseteo(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), "Elite", "Desciende");
                                            RegistrosExcel.add(RegistroVencimineto);
                                            Acumulado = Registro.getMonto();
                                            MontoMantener = 0.00;
                                            fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                            UltimoNivel = RegistroVencimineto.getNivel();
                                            RegistroExcel = this.ValoresGenerales(Registro);
                                        } else {
                                            DataCalculo RegistroVencimineto = GeneraLineaReseteo(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), "Fidelity", "Desciende");
                                            RegistrosExcel.add(RegistroVencimineto);
                                            Acumulado = Registro.getMonto();
                                            MontoMantener = 0.00;
                                            fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                            UltimoNivel = RegistroVencimineto.getNivel();
                                            RegistroExcel = this.ValoresGenerales(Registro);

                                        }
                                    }
                                }
                                if (Registro.getMonto() >= 0) {
                                    switch (UltimoNivel) {
                                        case "Fidelity":
                                            RegistroExcel = CalcularFidelity(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            break;

                                        case "Elite":
                                            RegistroExcel = CalcularElite(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            break;
                                        case "Premier":
                                            RegistroExcel = CalcularPremier(RegistroExcel, Acumulado, fechaVencimientoActual);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            break;
                                    }
                                } else {
                                    Date fechaTicketOrigen = ObtenerFechaTicketOrigen(RegistrosExcel, Registro.getTicketOrigen().toString());
                                    Boolean DevolucionEspecial = ValidarDevolucion(fechaTicketOrigen, RegistrosExcel, Registro.getTicketOrigen().toString());
                                    if (DevolucionEspecial == true) {
                                        DevolucionesNormalesDTO DevNormal = this.ObtenerNuevasDevolucinesEspeciales(RegistrosSQL, index, Restar365ParaDevoluciones(Registro.getFecha_Asignacion()), FechaDevolucion(Registro.getFecha_Asignacion()));
                                        if (DevNormal != null) {
                                            System.out.println("Fecha: " + DevNormal.getFecha_Asignacion().toString());
                                            fechaVencimientoActual = SumarParaFechaVencimiento(DevNormal.getFecha_Asignacion(), 365);
                                            Acumulado = DevNormal.getMonto();
                                            RegistroExcel = CalcularDevolucion(RegistroExcel, Acumulado, fechaVencimientoActual, UltimoNivel);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());
                                            RegistroExcel = CalcularMontosAscensoDescenso(RegistroExcel, Acumulado);
                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                        }

                                    } else {
                                        switch (UltimoNivel) {
                                            case "Fidelity":
                                                RegistroExcel = CalcularFidelity(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                break;
                                            case "Elite":
                                                RegistroExcel = CalcularElite(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                break;
                                            case "Premier":
                                                RegistroExcel = CalcularPremier(RegistroExcel, Acumulado, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                break;
                                        }
                                    }

                                }
                            }
                        }

                    }
                    List<DataCalculo> RegistrosExcelSuperFinal = ActualizaRegistrosActuales(RegistrosExcel);
                    //generarCSV(RegistrosExcel, ACustomerId);
                    DataCalculo UltimoRegistro = RegistrosExcelSuperFinal.get(RegistrosExcelSuperFinal.size() - 1);

                    ClientesFidelityFinalService.GuardarClienteFidelity(UltimoRegistro.getCustomerId(),
                            fechaRegistroFidelity,
                            formato.parse(UltimoRegistro.getFecha_Vencimiento()),
                            Double.valueOf(UltimoRegistro.getComprasAcumuladas()),
                            UltimoRegistro.getNivel(),
                            Double.valueOf(UltimoRegistro.getMontoMantener()),
                            Double.valueOf(UltimoRegistro.getMontoAscender()),
                            0);

                } else {
                    System.out.println("Cliente no es fidelity");
                    ClientesFidelityFinalService.GuardarClienteFidelity(UnoCliente.getCustomerId(), null, null, 0.00, "Sin membresia", 0.00, 0.00, 0);
                }
            }
            System.out.println("Inicia envio de información a Teamwork");
            enviarTWR.IniciarProceso(TodosClientes);
        } else {
            System.out.println("No hay datos nuevos");
        }

    }

    public void ProcesoMasivo() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        List<ClientesFidelityFinal> TodosClientes = ClientesFidelityFinalService.BuscarActualizar(7);
        //List<ClientesFidelityFinal> TodosClientes = ClientesFidelityFinalService.findAll();
        //List<ClientesFidelityFinal> TodosClientes = ClientesFidelityFinalService.BuscarXNivel("");
        if (TodosClientes != null && !TodosClientes.isEmpty()) {
            for (ClientesFidelityFinal UnoCliente : TodosClientes) {
                // Extraer la informacion
                List<vAcumuladoVentasFidelity> RegistrosSQL = vAcumuladoVentasFidelityService.buscarPorCustomerId(UnoCliente.getCustomerId());
                System.out.println("CustomerId: " + UnoCliente.getCustomerId());
                if (RegistrosSQL != null && !RegistrosSQL.isEmpty()) {
                    System.out.println("Total de registros Obtenidos del Customer: " + UnoCliente.getCustomerId() + " son: " + RegistrosSQL.size());

                    List<DataCalculo> RegistrosExcel = new ArrayList<>();
                    Double Acumulado = 0.00;
                    Double MontoMantener = 0.00;
                    int index = 0;
                    String UltimoNivel = null;
                    String fechaVencimientoActual = null;
                    Date fechaRegistroFidelity = null;
                   

                    for (vAcumuladoVentasFidelity Registro : RegistrosSQL) {
                        fechaRegistroFidelity = Registro.getFecha_inscripción_Fidelity();

                        if (Registro.getUniversalNo() == 0 & Registro.getFecha_Asignacion() == null) {
                            DataCalculo RegistroExcelSinCompras = CalculaFechaVencimientoSinCompras(Registro);
                            RegistrosExcel.add(RegistroExcelSinCompras);
                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                    RegistroExcelSinCompras.getCustomerId(),
                                    RegistroExcelSinCompras.getUniversalNo(),
                                    RegistroExcelSinCompras.getFecha_Fidelizacion(),
                                    RegistroExcelSinCompras.getFecha_Asignacion(),
                                    RegistroExcelSinCompras.getFecha_Vencimiento(),
                                    RegistroExcelSinCompras.getMonto(),
                                    RegistroExcelSinCompras.getComprasAcumuladas(),
                                    RegistroExcelSinCompras.getNivel(),
                                    RegistroExcelSinCompras.getMontoMantener(),
                                    RegistroExcelSinCompras.getMontoAscender(),
                                    RegistroExcelSinCompras.getTicketDevolucion());
                            System.out.print("Ya se guardo la primera linea");
                        } else {
                            DataCalculo RegistroExcel = this.ValoresGenerales(Registro);

                            Acumulado = Registro.getMonto() + Acumulado;
                            //System.out.println("Ticket: " + Registro.getUniversalNo() + " Monto Venta: " + Registro.getMonto() + " Acumulado: " + Acumulado);

                            if (index == 0) {
                                RegistroExcel = CalcularPrimeraLinea(RegistroExcel, Acumulado, Registro);
                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());
                                RegistroExcel = CalcularMontosAscensoDescenso(RegistroExcel, Acumulado);
                                RegistrosExcel.add(RegistroExcel);
                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                UltimoNivel = RegistroExcel.getNivel();
                                index++;
                                NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                        RegistroExcel.getCustomerId(),
                                        RegistroExcel.getUniversalNo(),
                                        RegistroExcel.getFecha_Fidelizacion(),
                                        RegistroExcel.getFecha_Asignacion(),
                                        RegistroExcel.getFecha_Vencimiento(),
                                        RegistroExcel.getMonto(),
                                        RegistroExcel.getComprasAcumuladas(),
                                        RegistroExcel.getNivel(),
                                        RegistroExcel.getMontoMantener(),
                                        RegistroExcel.getMontoAscender(),
                                        RegistroExcel.getTicketDevolucion());
                                System.out.print("Ya se guardo la primera linea");

                            } else {
                                Boolean venta = ValidarFechasMoviminetos(Registro.getFecha_Asignacion(), formato.parse(fechaVencimientoActual));
                                if (venta == true) {
                                    if (MontoMantener == 0) {

                                        DataCalculo RegistroVencimineto = GeneraLineaReseteoexcel(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), UltimoNivel, "Se mantiene");
                                        RegistrosExcel.add(RegistroVencimineto);
                                        Acumulado = Registro.getMonto();
                                        MontoMantener = 0.00;
                                        fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                        UltimoNivel = RegistroVencimineto.getNivel();
                                        RegistroExcel = this.ValoresGenerales(Registro);
                                        
                                        NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                RegistroVencimineto.getCustomerId(),
                                                RegistroVencimineto.getUniversalNo(),
                                                RegistroVencimineto.getFecha_Fidelizacion(),
                                                RegistroVencimineto.getFecha_Asignacion(),
                                                RegistroVencimineto.getFecha_Vencimiento(),
                                                RegistroVencimineto.getMonto(),
                                                RegistroVencimineto.getComprasAcumuladas(),
                                                RegistroVencimineto.getNivel(),
                                                RegistroVencimineto.getMontoMantener(),
                                                RegistroVencimineto.getMontoAscender(),
                                                RegistroVencimineto.getTicketDevolucion());
                                        System.out.print("Ya se guardo la primera linea");

                                    } else {
                                        if ("Premier".equals(UltimoNivel) && Acumulado >= 60001) {

                                            DataCalculo RegistroVencimineto = GeneraLineaReseteoexcel(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), "Elite", "Desciende", "Reseteo " + res);
                                            RegistrosExcel.add(RegistroVencimineto);
                                            Acumulado = Registro.getMonto();
                                            MontoMantener = 0.00;
                                            fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                            UltimoNivel = RegistroVencimineto.getNivel();
                                            RegistroExcel = this.ValoresGenerales(Registro);
                                           
                                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                    RegistroVencimineto.getCustomerId(),
                                                    RegistroVencimineto.getUniversalNo(),
                                                    RegistroVencimineto.getFecha_Fidelizacion(),
                                                    RegistroVencimineto.getFecha_Asignacion(),
                                                    RegistroVencimineto.getFecha_Vencimiento(),
                                                    RegistroVencimineto.getMonto(),
                                                    RegistroVencimineto.getComprasAcumuladas(),
                                                    RegistroVencimineto.getNivel(),
                                                    RegistroVencimineto.getMontoMantener(),
                                                    RegistroVencimineto.getMontoAscender(),
                                                    RegistroVencimineto.getTicketDevolucion());
                                            System.out.print("Ya se guardo la primera linea");
                                        } else {
                                            DataCalculo RegistroVencimineto = GeneraLineaReseteoexcel(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), "Fidelity", "Desciende", "Reseteo " + res);
                                            RegistrosExcel.add(RegistroVencimineto);
                                            Acumulado = Registro.getMonto();
                                            MontoMantener = 0.00;
                                            fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                            UltimoNivel = RegistroVencimineto.getNivel();
                                            RegistroExcel = this.ValoresGenerales(Registro);
                                           
                                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                    RegistroVencimineto.getCustomerId(),
                                                    RegistroVencimineto.getUniversalNo(),
                                                    RegistroVencimineto.getFecha_Fidelizacion(),
                                                    RegistroVencimineto.getFecha_Asignacion(),
                                                    RegistroVencimineto.getFecha_Vencimiento(),
                                                    RegistroVencimineto.getMonto(),
                                                    RegistroVencimineto.getComprasAcumuladas(),
                                                    RegistroVencimineto.getNivel(),
                                                    RegistroVencimineto.getMontoMantener(),
                                                    RegistroVencimineto.getMontoAscender(),
                                                    RegistroVencimineto.getTicketDevolucion());
                                            System.out.print("Ya se guardo la primera linea");

                                        }
                                    }
                                }
                                if (Registro.getMonto() >= 0) {
                                    switch (UltimoNivel) {
                                        case "Fidelity":
                                            RegistroExcel = CalcularFidelity(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                    RegistroExcel.getCustomerId(),
                                                    RegistroExcel.getUniversalNo(),
                                                    RegistroExcel.getFecha_Fidelizacion(),
                                                    RegistroExcel.getFecha_Asignacion(),
                                                    RegistroExcel.getFecha_Vencimiento(),
                                                    RegistroExcel.getMonto(),
                                                    RegistroExcel.getComprasAcumuladas(),
                                                    RegistroExcel.getNivel(),
                                                    RegistroExcel.getMontoMantener(),
                                                    RegistroExcel.getMontoAscender(),
                                                    RegistroExcel.getTicketDevolucion());
                                            System.out.print("Ya se guardo la primera linea");
                                            break;

                                        case "Elite":
                                            RegistroExcel = CalcularElite(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                    RegistroExcel.getCustomerId(),
                                                    RegistroExcel.getUniversalNo(),
                                                    RegistroExcel.getFecha_Fidelizacion(),
                                                    RegistroExcel.getFecha_Asignacion(),
                                                    RegistroExcel.getFecha_Vencimiento(),
                                                    RegistroExcel.getMonto(),
                                                    RegistroExcel.getComprasAcumuladas(),
                                                    RegistroExcel.getNivel(),
                                                    RegistroExcel.getMontoMantener(),
                                                    RegistroExcel.getMontoAscender(),
                                                    RegistroExcel.getTicketDevolucion());
                                            System.out.print("Ya se guardo la primera linea");
                                            break;
                                        case "Premier":
                                            RegistroExcel = CalcularPremier(RegistroExcel, Acumulado, fechaVencimientoActual);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                    RegistroExcel.getCustomerId(),
                                                    RegistroExcel.getUniversalNo(),
                                                    RegistroExcel.getFecha_Fidelizacion(),
                                                    RegistroExcel.getFecha_Asignacion(),
                                                    RegistroExcel.getFecha_Vencimiento(),
                                                    RegistroExcel.getMonto(),
                                                    RegistroExcel.getComprasAcumuladas(),
                                                    RegistroExcel.getNivel(),
                                                    RegistroExcel.getMontoMantener(),
                                                    RegistroExcel.getMontoAscender(),
                                                    RegistroExcel.getTicketDevolucion());
                                            System.out.print("Ya se guardo la primera linea");
                                            break;
                                    }
                                } else {
                                    Date fechaTicketOrigen = ObtenerFechaTicketOrigen(RegistrosExcel, Registro.getTicketOrigen().toString());
                                    Boolean DevolucionEspecial = ValidarDevolucion(fechaTicketOrigen, RegistrosExcel, Registro.getTicketOrigen().toString());
                                    if (DevolucionEspecial == true) {
                                        DevolucionesNormalesDTO DevNormal = this.ObtenerNuevasDevolucinesEspeciales(RegistrosSQL, index, Restar365ParaDevoluciones(Registro.getFecha_Asignacion()), FechaDevolucion(Registro.getFecha_Asignacion()));
                                        if (DevNormal != null) {
                                            System.out.println("Fecha: " + DevNormal.getFecha_Asignacion().toString());
                                            fechaVencimientoActual = SumarParaFechaVencimiento(DevNormal.getFecha_Asignacion(), 365);
                                            Acumulado = DevNormal.getMonto();
                                            RegistroExcel = CalcularDevolucion(RegistroExcel, Acumulado, fechaVencimientoActual, UltimoNivel);
                                            Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                            MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());
                                            RegistroExcel = CalcularMontosAscensoDescenso(RegistroExcel, Acumulado);
                                            RegistrosExcel.add(RegistroExcel);
                                            fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                            UltimoNivel = RegistroExcel.getNivel();
                                            index++;
                                            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                    RegistroExcel.getCustomerId(),
                                                    RegistroExcel.getUniversalNo(),
                                                    RegistroExcel.getFecha_Fidelizacion(),
                                                    RegistroExcel.getFecha_Asignacion(),
                                                    RegistroExcel.getFecha_Vencimiento(),
                                                    RegistroExcel.getMonto(),
                                                    RegistroExcel.getComprasAcumuladas(),
                                                    RegistroExcel.getNivel(),
                                                    RegistroExcel.getMontoMantener(),
                                                    RegistroExcel.getMontoAscender(),
                                                    RegistroExcel.getTicketDevolucion());
                                            System.out.print("Ya se guardo la primera linea");
                                        }

                                    } else {
                                        switch (UltimoNivel) {
                                            case "Fidelity":
                                                RegistroExcel = CalcularFidelity(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                        RegistroExcel.getCustomerId(),
                                                        RegistroExcel.getUniversalNo(),
                                                        RegistroExcel.getFecha_Fidelizacion(),
                                                        RegistroExcel.getFecha_Asignacion(),
                                                        RegistroExcel.getFecha_Vencimiento(),
                                                        RegistroExcel.getMonto(),
                                                        RegistroExcel.getComprasAcumuladas(),
                                                        RegistroExcel.getNivel(),
                                                        RegistroExcel.getMontoMantener(),
                                                        RegistroExcel.getMontoAscender(),
                                                        RegistroExcel.getTicketDevolucion());
                                                System.out.print("Ya se guardo la primera linea");
                                                break;
                                            case "Elite":
                                                RegistroExcel = CalcularElite(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                        RegistroExcel.getCustomerId(),
                                                        RegistroExcel.getUniversalNo(),
                                                        RegistroExcel.getFecha_Fidelizacion(),
                                                        RegistroExcel.getFecha_Asignacion(),
                                                        RegistroExcel.getFecha_Vencimiento(),
                                                        RegistroExcel.getMonto(),
                                                        RegistroExcel.getComprasAcumuladas(),
                                                        RegistroExcel.getNivel(),
                                                        RegistroExcel.getMontoMantener(),
                                                        RegistroExcel.getMontoAscender(),
                                                        RegistroExcel.getTicketDevolucion());
                                                System.out.print("Ya se guardo la primera linea");
                                                break;
                                            case "Premier":
                                                RegistroExcel = CalcularPremier(RegistroExcel, Acumulado, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                                                        RegistroExcel.getCustomerId(),
                                                        RegistroExcel.getUniversalNo(),
                                                        RegistroExcel.getFecha_Fidelizacion(),
                                                        RegistroExcel.getFecha_Asignacion(),
                                                        RegistroExcel.getFecha_Vencimiento(),
                                                        RegistroExcel.getMonto(),
                                                        RegistroExcel.getComprasAcumuladas(),
                                                        RegistroExcel.getNivel(),
                                                        RegistroExcel.getMontoMantener(),
                                                        RegistroExcel.getMontoAscender(),
                                                        RegistroExcel.getTicketDevolucion());
                                                System.out.print("Ya se guardo la primera linea");
                                                break;
                                        }
                                    }

                                }
                            }
                        }

                    }
                    List<DataCalculo> RegistrosExcelSuperFinal = ActualizaRegistrosActuales(RegistrosExcel);

                    //generarCSV(RegistrosExcel, ACustomerId);
                    DataCalculo UltimoRegistro = RegistrosExcelSuperFinal.get(RegistrosExcelSuperFinal.size() - 1);

                    ClientesFidelityFinalService.GuardarClienteFidelity(UltimoRegistro.getCustomerId(),
                            fechaRegistroFidelity,
                            formato.parse(UltimoRegistro.getFecha_Vencimiento()),
                            Double.valueOf(UltimoRegistro.getComprasAcumuladas()),
                            UltimoRegistro.getNivel(),
                            

                } else {
                    System.out.println("Cliente no es fidelity");
                    ClientesFidelityFinalService.GuardarClienteFidelity(UnoCliente.getCustomerId(), null, null, 0.00, "Sin membresia", 0.00, 0.00, 0);
                }
            }

            System.out.println("Inicia envio de información a Teamwork");
            enviarTWR.IniciarProceso(TodosClientes);
        } else {
            System.out.println("No hay datos nuevos");
        }

    }

    public void ProcesoAutomatico() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        List<ProcesoManualFidelity> TodosClientes = ProcesoManualFidelityService.BuscarActualizar(0);
        if (TodosClientes != null && !TodosClientes.isEmpty()) {
            for (ProcesoManualFidelity UnoCliente : TodosClientes) {
                try {
                    // Extraer la informacion
                    List<vAcumuladoVentasFidelity> RegistrosSQL = vAcumuladoVentasFidelityService.buscarPorCustomerId(UnoCliente.getCustomerId());
                    System.out.println("CustomerId: " + UnoCliente.getCustomerId());
                    if (RegistrosSQL != null && !RegistrosSQL.isEmpty()) {
                        System.out.println("Total de registros Obtenidos del Customer: " + UnoCliente.getCustomerId() + " son: " + RegistrosSQL.size());

                        List<DataCalculo> RegistrosExcel = new ArrayList<>();
                        Double Acumulado = 0.00;
                        Double MontoMantener = 0.00;
                        int index = 0;
                        String UltimoNivel = null;
                        String fechaVencimientoActual = null;
                        for (vAcumuladoVentasFidelity Registro : RegistrosSQL) {
                            if (Registro.getUniversalNo() == 0 & Registro.getFecha_Asignacion() == null) {
                                DataCalculo RegistroExcelSinCompras = CalculaFechaVencimientoSinCompras(Registro);
                                RegistrosExcel.add(RegistroExcelSinCompras);
                            } else {
                                DataCalculo RegistroExcel = this.ValoresGenerales(Registro);

                                Acumulado = Registro.getMonto() + Acumulado;
                                //System.out.println("Ticket: " + Registro.getUniversalNo() + " Monto Venta: " + Registro.getMonto() + " Acumulado: " + Acumulado);

                                if (index == 0) {
                                    RegistroExcel = CalcularPrimeraLinea(RegistroExcel, Acumulado, Registro);
                                    Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                    MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());
                                    RegistroExcel = CalcularMontosAscensoDescenso(RegistroExcel, Acumulado);
                                    RegistrosExcel.add(RegistroExcel);
                                    fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                    UltimoNivel = RegistroExcel.getNivel();
                                    index++;

                                } else {
                                    Boolean venta = ValidarFechasMoviminetos(Registro.getFecha_Asignacion(), formato.parse(fechaVencimientoActual));
                                    if (venta == true) {
                                        if (MontoMantener == 0) {
                                            DataCalculo RegistroVencimineto = GeneraLineaReseteo(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), UltimoNivel, "Se mantiene");
                                            RegistrosExcel.add(RegistroVencimineto);
                                            Acumulado = Registro.getMonto();
                                            MontoMantener = 0.00;
                                            fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                            UltimoNivel = RegistroVencimineto.getNivel();
                                            RegistroExcel = this.ValoresGenerales(Registro);

                                        } else {
                                            if ("Premier".equals(UltimoNivel) && Acumulado >= 60001) {
                                                DataCalculo RegistroVencimineto = GeneraLineaReseteo(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), "Elite", "Desciende");
                                                RegistrosExcel.add(RegistroVencimineto);
                                                Acumulado = Registro.getMonto();
                                                MontoMantener = 0.00;
                                                fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                                UltimoNivel = RegistroVencimineto.getNivel();
                                                RegistroExcel = this.ValoresGenerales(Registro);
                                            } else {
                                                DataCalculo RegistroVencimineto = GeneraLineaReseteo(RegistroExcel, formato.parse(fechaVencimientoActual), Registro.getSellToCustomerId(), "Fidelity", "Desciende");
                                                RegistrosExcel.add(RegistroVencimineto);
                                                Acumulado = Registro.getMonto();
                                                MontoMantener = 0.00;
                                                fechaVencimientoActual = RegistroVencimineto.getFecha_Vencimiento();
                                                UltimoNivel = RegistroVencimineto.getNivel();
                                                RegistroExcel = this.ValoresGenerales(Registro);

                                            }
                                        }
                                    }
                                    if (Registro.getMonto() >= 0) {
                                        switch (UltimoNivel) {
                                            case "Fidelity":
                                                RegistroExcel = CalcularFidelity(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                break;

                                            case "Elite":
                                                RegistroExcel = CalcularElite(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                break;
                                            case "Premier":
                                                RegistroExcel = CalcularPremier(RegistroExcel, Acumulado, fechaVencimientoActual);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                                break;
                                        }
                                    } else {
                                        Date fechaTicketOrigen = ObtenerFechaTicketOrigen(RegistrosExcel, Registro.getTicketOrigen().toString());
                                        Boolean DevolucionEspecial = ValidarDevolucion(fechaTicketOrigen, RegistrosExcel, Registro.getTicketOrigen().toString());
                                        if (DevolucionEspecial == true) {
                                            DevolucionesNormalesDTO DevNormal = this.ObtenerNuevasDevolucinesEspeciales(RegistrosSQL, index, Restar365ParaDevoluciones(Registro.getFecha_Asignacion()), FechaDevolucion(Registro.getFecha_Asignacion()));
                                            if (DevNormal != null) {
                                                System.out.println("Fecha: " + DevNormal.getFecha_Asignacion().toString());
                                                fechaVencimientoActual = SumarParaFechaVencimiento(DevNormal.getFecha_Asignacion(), 365);
                                                Acumulado = DevNormal.getMonto();
                                                RegistroExcel = CalcularDevolucion(RegistroExcel, Acumulado, fechaVencimientoActual, UltimoNivel);
                                                Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());
                                                RegistroExcel = CalcularMontosAscensoDescenso(RegistroExcel, Acumulado);
                                                RegistrosExcel.add(RegistroExcel);
                                                fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                UltimoNivel = RegistroExcel.getNivel();
                                                index++;
                                            }

                                        } else {
                                            switch (UltimoNivel) {
                                                case "Fidelity":
                                                    RegistroExcel = CalcularFidelity(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                    Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                    MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                    RegistrosExcel.add(RegistroExcel);
                                                    fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                    UltimoNivel = RegistroExcel.getNivel();
                                                    index++;
                                                    break;
                                                case "Elite":
                                                    RegistroExcel = CalcularElite(RegistroExcel, Acumulado, Registro, fechaVencimientoActual);
                                                    Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                    MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                    RegistrosExcel.add(RegistroExcel);
                                                    fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                    UltimoNivel = RegistroExcel.getNivel();
                                                    index++;
                                                    break;
                                                case "Premier":
                                                    RegistroExcel = CalcularPremier(RegistroExcel, Acumulado, fechaVencimientoActual);
                                                    Acumulado = Double.valueOf(RegistroExcel.getComprasAcumuladas());
                                                    MontoMantener = Double.valueOf(RegistroExcel.getMontoMantener());

                                                    RegistrosExcel.add(RegistroExcel);
                                                    fechaVencimientoActual = RegistroExcel.getFecha_Vencimiento();
                                                    UltimoNivel = RegistroExcel.getNivel();
                                                    index++;
                                                    break;
                                            }
                                        }

                                    }
                                }
                            }

                        }
                        List<DataCalculo> RegistrosExcelSuperFinal = ActualizaRegistrosActuales(RegistrosExcel);
                        //generarCSV(RegistrosExcel, ACustomerId);
                        GeneraArchivoExcel.generarCSV(RegistrosExcelSuperFinal, UnoCliente.getCustomerId());

                    } else {
                        System.out.println("Cliente no es fidelity");
                        ProcesoManualFidelityService.GuardarProcesoManualFidelity(UnoCliente.getCustomerId(), 1, "Cliente Sin membresia No se genera archivo");
                    }
                } catch (NumberFormatException | ParseException Error) {
                    ProcesoManualFidelityService.GuardarProcesoManualFidelity(UnoCliente.getCustomerId(), 2, "Error al momento de Generar el archivo");
                }

            }
        } else {
            System.out.println("No se encontro datos para generar");
        }

    }

    private Boolean ValidarFechasMoviminetos(Date AFechaAsignacion, Date AFechaVencimineto) {
        return AFechaAsignacion.after(AFechaVencimineto);
    }

//    private Boolean ValidarDevolucion(Date AFechaAsignacion, List<DataCalculo> AData) throws ParseException {
//        Date FechaUltimoAsignacion = ObtenerUltimaFechaAsignacion(AData);
//        if (FechaUltimoAsignacion != null && AFechaAsignacion != null) {
//            return AFechaAsignacion.compareTo(FechaUltimoAsignacion) <= 0;
//        } else {
//            return true;
//        }
//    }
    private Boolean ValidarDevolucion(Date AFechaAsignacion, List<DataCalculo> AData, String ATicketDevolucion) throws ParseException {
        DataCalculo RegistroUltimoAscenso = ObtenerUltimaFechaAsignacion(AData);
        if (RegistroUltimoAscenso != null && AFechaAsignacion != null) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date FechaUltimoAsignacion = formatoFecha.parse(RegistroUltimoAscenso.getFecha_Asignacion());
            //Ticket igual a el ticket que asciende
            if (AFechaAsignacion.compareTo(FechaUltimoAsignacion) == 0) {
                return RegistroUltimoAscenso.getUniversalNo().equals(ATicketDevolucion);
            } else {
                return AFechaAsignacion.compareTo(FechaUltimoAsignacion) < 0;
            }
        } else {
            return true;
        }
    }

    private String CalcularNivelMembresia(String ANivelActual, String ANivelAnterior) {
        if (ANivelActual.equals(ANivelAnterior)) {
            return "Se mantiene";
        }

        if (ANivelAnterior.equals("Premier")) {
            if (ANivelActual.equals("Elite") || ANivelActual.equals("Fidelity")) {
                return "Desciende";
            }
        }

        if (ANivelAnterior.equals("Elite")) {
            if (ANivelActual.equals("Fidelity")) {
                return "Desciende";
            }
            if (ANivelActual.equals("Premier")) {
                return "Asciende";
            }
        }

        if (ANivelAnterior.equals("Fidelity")) {
            if (ANivelActual.equals("Elite") || ANivelActual.equals("Premier")) {
                return "Asciende";
            }
        }

        return null;
    }

    private DataCalculo ObtenerUltimaFechaAsignacion(List<DataCalculo> AData) throws ParseException {
        DataCalculo Resultado = null;
        for (DataCalculo Data : AData) {
            if (Data.getMovimiento().equals("Asciende")) {
                Resultado = Data;
            }
        }
        return Resultado;
    }
//    private Date ObtenerUltimaFechaAsignacion(List<DataCalculo> AData) throws ParseException {
//        Date Resultado = null;
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
//
//        for (DataCalculo Data : AData) {
//            if (Data.getMovimiento().equals("Asciende")) {
//                Resultado = formatoFecha.parse(Data.getFecha_Asignacion());
//            }
//        }
//        return Resultado;
//    }

    private Date ObtenerFechaTicketOrigen(List<DataCalculo> AData, String ATicketOrigen) throws ParseException {
        Date Resultado = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        for (DataCalculo Data : AData) {
            if (Data.getUniversalNo().equals(ATicketOrigen)) {
                Resultado = formatoFecha.parse(Data.getFecha_Asignacion());
            }
        }
        return Resultado;
    }

    private DataCalculo GeneraLineaReseteo(DataCalculo AData, Date AFechaVencimiento, String ACustomerId, String ANivel, String AMovimiento) {
        AData.setCustomerId(ACustomerId);
        AData.setUniversalNo("");
        AData.setFecha_Fidelizacion("");
        AData.setFecha_Asignacion(SumarParaFechaVencimiento(AFechaVencimiento, 1));
        AData.setFecha_Vencimiento(SumarParaFechaVencimiento(AFechaVencimiento, 366));
        AData.setMonto("0.00");
        AData.setComprasAcumuladas("0.00");
        AData.setNivel(ANivel);
        AData = this.CalcularMontosAscensoDescenso(AData, Double.valueOf(AData.getMonto()));
        AData.setTicketDevolucion("");
        AData.setMovimiento(AMovimiento);
        return AData;
    }

    private DataCalculo GeneraLineaReseteoexcel(DataCalculo AData, Date AFechaVencimiento, String ACustomerId, String ANivel, String AMovimiento, String aticket) {
        AData.setCustomerId(ACustomerId);
        AData.setUniversalNo(aticket);
        AData.setFecha_Fidelizacion("");
        AData.setFecha_Asignacion(SumarParaFechaVencimiento(AFechaVencimiento, 1));
        AData.setFecha_Vencimiento(SumarParaFechaVencimiento(AFechaVencimiento, 366));
        AData.setMonto("0.00");
        AData.setComprasAcumuladas("0.00");
        AData.setNivel(ANivel);
        AData = this.CalcularMontosAscensoDescenso(AData, Double.valueOf(AData.getMonto()));
        AData.setTicketDevolucion("");
        AData.setMovimiento(AMovimiento);
        return AData;
    }

    private DataCalculo CalcularDevolucion(DataCalculo AData, Double AMontoAcumulado, String AFechaVencimientoDev, String AUltimoNivel) {

        //Premier
        if (AMontoAcumulado >= 120001) {
            AData.setComprasAcumuladas(AMontoAcumulado.toString());
            AData.setNivel("Premier");
            AData.setFecha_Vencimiento(AFechaVencimientoDev);
            AData = this.CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
            AData.setMovimiento(CalcularNivelMembresia("Premier", AUltimoNivel));
            return AData;
        }
        //Elite
        if (AMontoAcumulado >= 60001) {
            AData.setComprasAcumuladas(AMontoAcumulado.toString());
            AData.setNivel("Elite");
            AData.setFecha_Vencimiento(AFechaVencimientoDev);
            AData = this.CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
            AData.setMovimiento(CalcularNivelMembresia("Elite", AUltimoNivel));
            return AData;

        }
        //Fidelity
        AData.setComprasAcumuladas(AMontoAcumulado.toString());
        AData.setNivel("Fidelity");
        AData.setFecha_Vencimiento(AFechaVencimientoDev);
        AData = this.CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
        AData.setMovimiento(CalcularNivelMembresia("Fidelity", AUltimoNivel));
        return AData;

    }

    private DataCalculo CalcularPrimeraLinea(DataCalculo AData, Double AMontoAcumulado, vAcumuladoVentasFidelity ATabla) {

        //Premier
        if (AMontoAcumulado >= 120001) {
            AData.setComprasAcumuladas(AMontoAcumulado.toString());
            AData.setNivel("Premier");
            AData.setFecha_Vencimiento(SumarParaFechaVencimiento(ATabla.getFecha_Asignacion(), 365));
            AData = this.CalcularMontosAscensoDescenso(AData, ATabla.getMonto());
            AData.setMovimiento("Asciende");
            return AData;
        }
        //Elite
        if (AMontoAcumulado >= 60001) {
            AData.setComprasAcumuladas(AMontoAcumulado.toString());
            AData.setNivel("Elite");
            AData.setFecha_Vencimiento(SumarParaFechaVencimiento(ATabla.getFecha_Asignacion(), 365));
            AData = CalcularMontosAscensoDescenso(AData, ATabla.getMonto());
            AData.setMovimiento("Asciende");
            return AData;

        }
        //Fidelity
        AData.setComprasAcumuladas(AMontoAcumulado.toString());
        AData.setNivel("Fidelity");
        AData.setFecha_Fidelizacion(ATabla.getFecha_inscripción_Fidelity().toString());
        AData.setFecha_Vencimiento(SumarParaFechaVencimiento(ATabla.getFecha_inscripción_Fidelity(), 365));
        AData = this.CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
        AData.setMovimiento("Asciende");
        return AData;

    }

    private DataCalculo CalcularFidelity(DataCalculo AData, Double AMontoAcumulado, vAcumuladoVentasFidelity ATabla, String AFechaVencimineto) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        //Premier
        if (AMontoAcumulado >= 120001) {
            AData.setComprasAcumuladas(ATabla.getMonto().toString());
            AData.setFecha_Vencimiento(SumarParaFechaVencimiento(formatoFecha.parse(AData.getFecha_Asignacion()), 365));
            AData.setNivel("Premier");
            AData = this.CalcularMontosAscensoDescenso(AData, ATabla.getMonto());
            AData.setMovimiento("Asciende");
            return AData;

        }

        //Elite
        if (AMontoAcumulado >= 60001) {
            AData.setComprasAcumuladas(ATabla.getMonto().toString());
            AData.setFecha_Vencimiento(SumarParaFechaVencimiento(formatoFecha.parse(AData.getFecha_Asignacion()), 365));
            AData.setNivel("Elite");
            AData = this.CalcularMontosAscensoDescenso(AData, ATabla.getMonto());
            AData.setMovimiento("Asciende");
            return AData;

        }

        //Fidelity
        AData.setComprasAcumuladas(AMontoAcumulado.toString());
        AData.setNivel("Fidelity");
        AData.setFecha_Vencimiento(AFechaVencimineto);
        AData = CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
        AData.setMovimiento("Se mantiene");
        return AData;

    }

    private DataCalculo CalcularElite(DataCalculo AData, Double AMontoAcumulado, vAcumuladoVentasFidelity ATabla, String AFechaVencimineto) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        //Premier
        if (AMontoAcumulado >= 120001) {
            AData.setComprasAcumuladas(ATabla.getMonto().toString());
            AData.setFecha_Vencimiento(SumarParaFechaVencimiento(formatoFecha.parse(AData.getFecha_Asignacion()), 365));
            AData.setNivel("Premier");
            AData = this.CalcularMontosAscensoDescenso(AData, ATabla.getMonto());
            AData.setMovimiento("Asciende");

            return AData;

        }
        AData.setComprasAcumuladas(AMontoAcumulado.toString());
        AData.setFecha_Vencimiento(AFechaVencimineto);
        AData.setNivel("Elite");
        AData = this.CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
        AData.setMovimiento("Se mantiene");

        return AData;
    }

    private DataCalculo CalcularPremier(DataCalculo AData, Double AMontoAcumulado, String AFechaVencimineto) throws ParseException {

        AData.setComprasAcumuladas(AMontoAcumulado.toString());
        AData.setFecha_Vencimiento(AFechaVencimineto);
        AData.setNivel("Premier");
        AData = this.CalcularMontosAscensoDescenso(AData, AMontoAcumulado);
        AData.setMovimiento("Se mantiene");

        return AData;

    }

    private DataCalculo CalcularMontosAscensoDescenso(DataCalculo AData, Double AACumuladoActual) {
        Double MontoMantener;
        Double MontoAscender;

        switch (AData.getNivel()) {
            case "Fidelity":
                AData.setMontoMantener("0.00");
                MontoAscender = 60001 - AACumuladoActual;
                AData.setMontoAscender(MontoAscender > 0 ? MontoAscender.toString() : "0.00");
                break;
            case "Elite":
                MontoMantener = 60000 - AACumuladoActual;
                AData.setMontoMantener(MontoMantener >= 0 ? MontoMantener.toString() : "0.00");
                MontoAscender = 120001 - AACumuladoActual;
                AData.setMontoAscender(MontoAscender > 0 ? MontoAscender.toString() : "0.00");
                break;
            case "Premier":
                MontoMantener = 120000 - AACumuladoActual;
                AData.setMontoMantener(MontoMantener > 0 ? MontoMantener.toString() : "0.00");
                AData.setMontoAscender("0.00");
                break;

            default:
                AData.setMontoMantener("0.00");
                AData.setMontoAscender("0.00");
                break;
        }

        return AData;

    }

    private String SumarParaFechaVencimiento(Date AFecha, int ADias) {
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        calendario.setTime(AFecha);
        calendario.add(Calendar.DAY_OF_YEAR, ADias);
        return formatoFecha.format(calendario.getTime());
    }

    private Date Restar365ParaDevoluciones(Date AFecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(AFecha);
        calendar.add(Calendar.DAY_OF_YEAR, -365);

        // Convertir a LocalDate primero
        java.time.LocalDate localDate = calendar.getTime()
                .toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();

        // Ahora sí usar valueOf
        java.sql.Date resultado = java.sql.Date.valueOf(localDate);
        return resultado;

    }

    private Date FechaDevolucion(Date AFecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(AFecha);

        // Convertir a LocalDate primero
        java.time.LocalDate localDate = calendar.getTime()
                .toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();

        // Ahora sí usar valueOf
        java.sql.Date resultado = java.sql.Date.valueOf(localDate);
        return resultado;

    }

    private DataCalculo RegistroSinCompras(vAcumuladoVentasFidelity ATabla) {
        DataCalculo Regreso = new DataCalculo();

        Regreso.setCustomerId(ATabla.getSellToCustomerId());
        Regreso.setUniversalNo("");
        Regreso.setFecha_Fidelizacion(ATabla.getFecha_inscripción_Fidelity().toString());
        Regreso.setMonto("0");
        Regreso.setComprasAcumuladas("0");
        Regreso.setNivel("Fidelity");
        Regreso.setMontoMantener("0");
        Regreso.setMontoAscender("60001");
        Regreso.setTicketDevolucion("");

        return Regreso;

    }

    private DataCalculo ValoresGenerales(vAcumuladoVentasFidelity ATabla) {
        DataCalculo Regreso = new DataCalculo();

        Regreso.setCustomerId(ATabla.getSellToCustomerId());
        Regreso.setUniversalNo(ATabla.getUniversalNo().toString());
        Regreso.setFecha_Fidelizacion("");
        Regreso.setFecha_Asignacion(ATabla.getFecha_Asignacion().toString());
        Regreso.setMonto(ATabla.getMonto().toString());
        Regreso.setTicketDevolucion(ATabla.getTicketOrigen() != 0 ? ATabla.getTicketOrigen().toString() : "");

        return Regreso;

    }

    private List<DataCalculo> ActualizaRegistrosActuales(List<DataCalculo> ARegistros) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        // Tomamos el último registro actual
        DataCalculo ultimoRegistro = ARegistros.get(ARegistros.size() - 1);
        Date ultimaFechaVencimiento = formato.parse(ultimoRegistro.getFecha_Vencimiento());
        Date hoy = new Date();

        // Mientras la fecha de vencimiento sea menor que hoy, se genera una nueva línea
        while (ultimaFechaVencimiento.before(hoy)) {
            double montoMantener = Double.parseDouble(ultimoRegistro.getMontoMantener());
            DataCalculo nuevoRegistro;

            if (montoMantener == 0) {
                nuevoRegistro = GeneraLineaReseteo(
                        new DataCalculo(ultimoRegistro), // constructor copia (si tienes uno)
                        ultimaFechaVencimiento,
                        ultimoRegistro.getCustomerId(),
                        ultimoRegistro.getNivel(),
                        "Se mantiene"
                );
            } else {
                if ("Premier".equals(ultimoRegistro.getNivel()) && Double.parseDouble(ultimoRegistro.getComprasAcumuladas()) >= 60001) {
                    nuevoRegistro = GeneraLineaReseteo(
                            new DataCalculo(ultimoRegistro),
                            ultimaFechaVencimiento,
                            ultimoRegistro.getCustomerId(),
                            "Elite",
                            "Desciende"
                    );
                } else {
                    nuevoRegistro = GeneraLineaReseteo(
                            new DataCalculo(ultimoRegistro),
                            ultimaFechaVencimiento,
                            ultimoRegistro.getCustomerId(),
                            "Fidelity",
                            "Desciende"
                    );

                }
            }

            ARegistros.add(nuevoRegistro);
            NivelFidelityhistoricoService.GuardarNivelFidelityhistorico(
                    nuevoRegistro.getCustomerId(),
                    nuevoRegistro.getUniversalNo(),
                    nuevoRegistro.getFecha_Fidelizacion(),
                    nuevoRegistro.getFecha_Asignacion(),
                    nuevoRegistro.getFecha_Vencimiento(),
                    nuevoRegistro.getMonto(),
                    nuevoRegistro.getComprasAcumuladas(),
                    nuevoRegistro.getNivel(),
                    nuevoRegistro.getMontoMantener(),
                    nuevoRegistro.getMontoAscender(),
                    nuevoRegistro.getTicketDevolucion());
            System.out.print("Ya se guardo la primera linea");

            // Actualizamos el último registro y su nueva fecha de vencimiento
            ultimoRegistro = ARegistros.get(ARegistros.size() - 1);
            ultimaFechaVencimiento = formato.parse(ultimoRegistro.getFecha_Vencimiento());
        }

        return ARegistros;
    }

    private DataCalculo CalculaFechaVencimientoSinCompras(vAcumuladoVentasFidelity ATabla) throws ParseException {
        DataCalculo RegistroSinCompra = new DataCalculo();
        RegistroSinCompra = RegistroSinCompras(ATabla);
        RegistroSinCompra.setFecha_Asignacion(ATabla.getFecha_inscripción_Fidelity().toString());
        RegistroSinCompra.setFecha_Vencimiento(SumarParaFechaVencimiento(ATabla.getFecha_inscripción_Fidelity(), 365));
        return RegistroSinCompra;

    }

    public DevolucionesNormalesDTO ObtenerNuevasDevolucinesEspeciales(
            List<vAcumuladoVentasFidelity> ARegistros,
            int ASize,
            Date fechaInicio,
            Date fechaFin
    ) {
        Double MontoAcumulado = 0.00;

        if (ARegistros != null && !ARegistros.isEmpty() && ASize > 0) {
            ASize++;
            // Filtrar hasta el índice actual
            List<vAcumuladoVentasFidelity> ListaHastaRegistroActual = ARegistros.stream()
                    .limit(ASize)
                    .collect(Collectors.toList());

            // Filtrar los registros que estén dentro del periodo
            List<vAcumuladoVentasFidelity> ListaPeriodoUnAnio = ListaHastaRegistroActual.stream()
                    .filter(c -> c.getFecha_Asignacion() != null
                    && !c.getFecha_Asignacion().before(fechaInicio)
                    && !c.getFecha_Asignacion().after(fechaFin))
                    .collect(Collectors.toList());

            for (vAcumuladoVentasFidelity venta : ListaPeriodoUnAnio) {
                MontoAcumulado += venta.getMonto();
            }

            Date fechaMasVieja = ListaPeriodoUnAnio.stream()
                    .map(vAcumuladoVentasFidelity::getFecha_Asignacion)
                    .filter(Objects::nonNull)
                    .min(Date::compareTo)
                    .orElse(null);

            return new DevolucionesNormalesDTO(fechaMasVieja, MontoAcumulado);
        } else {
            return null;
        }
    }

}
