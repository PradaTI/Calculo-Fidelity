/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.contenedor;

public class DataCalculo {

    private String CustomerId;
    private String UniversalNo;
    private String Fecha_Fidelizacion;
    private String Fecha_Asignacion;
    private String Fecha_Vencimiento;
    private String Monto;
    private String ComprasAcumuladas;
    private String Nivel;
    private String MontoMantener;
    private String MontoAscender;
    private String TicketDevolucion;
    private String Movimiento;

    // Constructor vacío
    public DataCalculo() {
    }

    // ✅ Constructor copia
    public DataCalculo(DataCalculo original) {
        this.CustomerId = original.CustomerId;
        this.UniversalNo = original.UniversalNo;
        this.Fecha_Fidelizacion = original.Fecha_Fidelizacion;
        this.Fecha_Asignacion = original.Fecha_Asignacion;
        this.Fecha_Vencimiento = original.Fecha_Vencimiento;
        this.Monto = original.Monto;
        this.ComprasAcumuladas = original.ComprasAcumuladas;
        this.Nivel = original.Nivel;
        this.MontoMantener = original.MontoMantener;
        this.MontoAscender = original.MontoAscender;
        this.TicketDevolucion = original.TicketDevolucion;
        this.Movimiento = original.Movimiento;
    }

    // Getters y Setters
    public String getFecha_Fidelizacion() {
        return Fecha_Fidelizacion;
    }

    public void setFecha_Fidelizacion(String Fecha_Fidelizacion) {
        this.Fecha_Fidelizacion = Fecha_Fidelizacion;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getUniversalNo() {
        return UniversalNo;
    }

    public void setUniversalNo(String UniversalNo) {
        this.UniversalNo = UniversalNo;
    }

    public String getFecha_Asignacion() {
        return Fecha_Asignacion;
    }

    public void setFecha_Asignacion(String Fecha_Asignacion) {
        this.Fecha_Asignacion = Fecha_Asignacion;
    }

    public String getFecha_Vencimiento() {
        return Fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(String Fecha_Vencimiento) {
        this.Fecha_Vencimiento = Fecha_Vencimiento;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getComprasAcumuladas() {
        return ComprasAcumuladas;
    }

    public void setComprasAcumuladas(String ComprasAcumuladas) {
        this.ComprasAcumuladas = ComprasAcumuladas;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    public String getMontoMantener() {
        return MontoMantener;
    }

    public void setMontoMantener(String MontoMantener) {
        this.MontoMantener = MontoMantener;
    }

    public String getMontoAscender() {
        return MontoAscender;
    }

    public void setMontoAscender(String MontoAscender) {
        this.MontoAscender = MontoAscender;
    }

    public String getTicketDevolucion() {
        return TicketDevolucion;
    }

    public void setTicketDevolucion(String TicketDevolucion) {
        this.TicketDevolucion = TicketDevolucion;
    }

    public String getMovimiento() {
        return Movimiento;
    }

    public void setMovimiento(String Movimiento) {
        this.Movimiento = Movimiento;
    }
}
