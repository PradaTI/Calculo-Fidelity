/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.entity;

import java.util.Date;

/**
 *
 * @author EduardoZuñigaHerrema
 */
public class DevolucionesNormalesDTO {

    private Date fecha_Asignacion;
    private Double monto;

    public DevolucionesNormalesDTO(Date fecha_Asignacion, Double monto) {
        this.fecha_Asignacion = fecha_Asignacion;
        this.monto = monto;
    }

    public Date getFecha_Asignacion() {
        return fecha_Asignacion;
    }

    public Double getMonto() {
        return monto;
    }
}

