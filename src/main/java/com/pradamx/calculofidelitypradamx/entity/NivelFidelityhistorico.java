/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author analistabi2
 */

@Entity
@Table(name = "NivelFidelityhistorico")
@XmlRootElement
@IdClass(NivelFidelityhistoricoPK.class)
@NamedQueries({
    @NamedQuery(name = "NivelFidelityhistorico.findAll", query = "SELECT nfh FROM NivelFidelityhistorico nfh"),
    @NamedQuery(name = "NivelFidelityhistorico.findByCustomerid", query = "SELECT nfh FROM NivelFidelityhistorico nfh WHERE nfh.customerid = :customerid"),
    @NamedQuery(name = "NivelFidelityhistorico.findByNoticket", query = "SELECT nfh FROM NivelFidelityhistorico nfh WHERE nfh.noticket = :noticket")
})
public class NivelFidelityhistorico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "customerid")
    private String customerid;

    @Id
    @Basic(optional = false)
    @Column(name = "noticket")
    private String noticket;
    
    @Column(name = "fechainscripcionfidelity")
    private String fechainscripcionfidelity;

    @Column(name = "fechaasignacioncompra")
    private String fechaasignacioncompra;

    @Column(name = "fechavencimiento")
    private String fechavencimiento;

    @Column(name = "monto")
    private String monto;

    @Column(name = "comprasacumuladas")
    private String comprasacumuladas;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "montoparamantener")
    private String montoparamantener;

    @Column(name = "montoparaascender")
    private String montoparaascender;

    @Column(name = "ticketorigen")
    private String ticketorigen;

    public NivelFidelityhistorico() {
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getNoticket() {
        return noticket;
    }

    public void setNoticket(String noticket) {
        this.noticket = noticket;
    }

    public String getFechainscripcionfidelity() {
        return fechainscripcionfidelity;
    }

    public void setFechainscripcionfidelity(String fechainscripcionfidelity) {
        this.fechainscripcionfidelity = fechainscripcionfidelity;
    }

    public String getFechaasignacioncompra() {
        return fechaasignacioncompra;
    }

    public void setFechaasignacioncompra(String fechaasignacioncompra) {
        this.fechaasignacioncompra = fechaasignacioncompra;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getComprasacumuladas() {
        return comprasacumuladas;
    }

    public void setComprasacumuladas(String comprasacumuladas) {
        this.comprasacumuladas = comprasacumuladas;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getMontoparamantener() {
        return montoparamantener;
    }

    public void setMontoparamantener(String montoparamantener) {
        this.montoparamantener = montoparamantener;
    }

    public String getMontoparaascender() {
        return montoparaascender;
    }

    public void setMontoparaascender(String montoparaascender) {
        this.montoparaascender = montoparaascender;
    }

    public String getTicketorigen() {
        return ticketorigen;
    }

    public void setTicketorigen(String ticketorigen) {
        this.ticketorigen = ticketorigen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerid, noticket);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof NivelFidelityhistorico)) {
            return false;
        }

        NivelFidelityhistorico other = (NivelFidelityhistorico) object;

        return Objects.equals(this.customerid, other.customerid)
                && Objects.equals(this.noticket, other.noticket);
    }

    @Override
    public String toString() {
        return "NivelFidelityhistorico[ customerid=" + customerid
                + ", noticket=" + noticket + " ]";
    }

}