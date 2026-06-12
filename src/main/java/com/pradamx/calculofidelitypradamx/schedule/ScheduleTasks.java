/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.schedule;

import com.pradamx.calculofidelitypradamx.Calculo.Calculo;
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author analistabi2
 */
@Component
public class ScheduleTasks {

    @Autowired
    private Calculo Calculo;

    private final AtomicBoolean ejecutandoDiario = new AtomicBoolean(false);
    private final AtomicBoolean ejecutandoAutomatico = new AtomicBoolean(false);

    //@Scheduled(cron = "0 */15 * * * *") // Cada 30 minutos
//    public void ProcesoDiario() {
//        if (ejecutandoDiario.get()) {
//            System.out.println("Proceso Diario aún en ejecución. Se omite esta ronda.");
//            return;
//        }
//
//        ejecutandoDiario.set(true);
//        try {
//            System.out.println("Inicia proceso Diario Fidelity");
//            Calculo.ProcesoDiario();
//            System.out.println("Finaliza proceso Diario Fidelity");
//        } catch (ParseException error) {
//            System.err.println("Error en tarea programada de proceso Diario Fidelity: " + error.getMessage());
//        } finally {
//            ejecutandoDiario.set(false);
//        }
//    }
    @Scheduled(cron = "0 */1 * * * *")
    public void ProcesoMasivoV2() {
        if (ejecutandoDiario.get()) {
            System.out.println("Proceso Diario aún en ejecución. Se omite esta ronda.");
            return;
        }
        ejecutandoDiario.set(true);
        try {
            System.out.println("Inicia proceso Diario Fidelity");
            Calculo.ProcesoMasivo();
            System.out.println("Finaliza proceso Diario Fidelity");
        } catch (ParseException error) {
            System.err.println("Error en tarea programada de proceso Diario Fidelity: " + error.getMessage());
        } finally {
            ejecutandoDiario.set(false);
        }
    }

//    @Scheduled(cron = "0 */1 * * * *") // Cada minuto
//    public void ProcesoAutomatico() {
//        if (ejecutandoAutomatico.get()) {
//            System.out.println("Proceso Automático aún en ejecución. Se omite esta ronda.");
//            return;
//        }
//
//        ejecutandoAutomatico.set(true);
//        try {
//            System.out.println("Inicia proceso Automático Fidelity");
//            Calculo.ProcesoAutomatico();
//            System.out.println("Finaliza proceso Automático Fidelity");
//        } catch (ParseException error) {
//            System.err.println("Error en tarea programada de proceso Automático Fidelity: " + error.getMessage());
//        } finally {
//            ejecutandoAutomatico.set(false);
//        }
//    }

}

