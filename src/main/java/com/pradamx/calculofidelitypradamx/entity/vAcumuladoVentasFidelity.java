/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "vAcumuladoVentasFidelity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "vAcumuladoVentasFidelity.findAll", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findByIdTabla", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.IdTabla = :IdTabla"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findBySellToCustomerId", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.SellToCustomerId = :SellToCustomerId"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findByUniversalNo", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.UniversalNo = :UniversalNo"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findByFecha_inscripción_Fidelity", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.Fecha_inscripción_Fidelity = :Fecha_inscripción_Fidelity"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findByFecha_Asignacion/compra", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.Fecha_Asignacion/compra = :Fecha_Asignacion"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findByMonto", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.Monto = :Monto"),
    @NamedQuery(name = "vAcumuladoVentasFidelity.findByTicketOrigen", query = "SELECT vavf FROM vAcumuladoVentasFidelity vavf WHERE vavf.TicketOrigen = :TicketOrigen")
})
public class vAcumuladoVentasFidelity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IdTabla")
    private String IdTabla;

    @Basic(optional = false)
    @Column(name = "SellToCustomerId")
    private String SellToCustomerId;

    @Basic(optional = false)
    @Column(name = "UniversalNo")
    private Long UniversalNo;

    @Basic(optional = false)
    @Column(name = "Fecha_inscripción_Fidelity")
    @Temporal(TemporalType.DATE)
    private Date Fecha_inscripción_Fidelity;

    @Basic(optional = false)
    @Column(name = "Fecha_Asignacion/compra")
    @Temporal(TemporalType.DATE)
    private Date Fecha_Asignacion;

    @Basic(optional = false)
    @Column(name = "Monto")
    private Double Monto;

    @Basic(optional = false)
    @Column(name = "TicketOrigen")
    private Long TicketOrigen;

    public String getIdTabla() {
        return IdTabla;
    }

    public void setIdTabla(String IdTabla) {
        this.IdTabla = IdTabla;
    }

    public String getSellToCustomerId() {
        return SellToCustomerId;
    }

    public void setSellToCustomerId(String SellToCustomerId) {
        this.SellToCustomerId = SellToCustomerId;
    }

    public Long getUniversalNo() {
        return UniversalNo;
    }

    public void setUniversalNo(Long UniversalNo) {
        this.UniversalNo = UniversalNo;
    }

    public Date getFecha_inscripción_Fidelity() {
        return Fecha_inscripción_Fidelity;
    }

    public void setFecha_inscripción_Fidelity(Date Fecha_inscripción_Fidelity) {
        this.Fecha_inscripción_Fidelity = Fecha_inscripción_Fidelity;
    }

    public Date getFecha_Asignacion() {
        return Fecha_Asignacion;
    }

    public void setFecha_Asignacion(Date Fecha_Asignacion) {
        this.Fecha_Asignacion = Fecha_Asignacion;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public Long getTicketOrigen() {
        return TicketOrigen;
    }

    public void setTicketOrigen(Long TicketOrigen) {
        this.TicketOrigen = TicketOrigen;
    }

}
