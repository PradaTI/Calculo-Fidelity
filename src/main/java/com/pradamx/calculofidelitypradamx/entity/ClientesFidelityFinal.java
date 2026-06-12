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

/**
 *
 * @author EduardoZuñigaHerrema
 */
@Entity
@Table(name = "ClientesFidelityFinal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientesFidelityFinal.findAll", query = "SELECT cff FROM ClientesFidelityFinal cff"),
    @NamedQuery(name = "ClientesFidelityFinal.findByCustomerId", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.CustomerId = :CustomerId"),
    @NamedQuery(name = "ClientesFidelityFinal.findByFechaFidelizacion", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.FechaFidelizacion = :FechaFidelizacion"),
    @NamedQuery(name = "ClientesFidelityFinal.findByFechaVencimiento", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.FechaVencimiento = :FechaVencimiento"),
    @NamedQuery(name = "ClientesFidelityFinal.findByComprasAcumuladas", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.ComprasAcumuladas = :ComprasAcumuladas"),
    @NamedQuery(name = "ClientesFidelityFinal.findByNivel", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.Nivel = :Nivel"),
    @NamedQuery(name = "ClientesFidelityFinal.findByMontoMantener", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.MontoMantener = :MontoMantener"),
    @NamedQuery(name = "ClientesFidelityFinal.findByMontoAscender", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.MontoAscender = :MontoAscender"),
    @NamedQuery(name = "ClientesFidelityFinal.findByActualizar", query = "SELECT cff FROM ClientesFidelityFinal cff WHERE cff.Actualizar = :Actualizar")
})
public class ClientesFidelityFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CustomerId")
    private String CustomerId;

    @Basic(optional = true)
    @Column(name = "FechaFidelizacion")
    @Temporal(TemporalType.DATE)
    private Date FechaFidelizacion;

    @Basic(optional = true)
    @Column(name = "FechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date FechaVencimiento;

    @Basic(optional = false)
    @Column(name = "ComprasAcumuladas")
    private Double ComprasAcumuladas;

    @Basic(optional = false)
    @Column(name = "Nivel")
    private String Nivel;

    @Basic(optional = false)
    @Column(name = "MontoMantener")
    private Double MontoMantener;

    @Basic(optional = false)
    @Column(name = "MontoAscender")
    private Double MontoAscender;
    
    @Basic(optional = false)
    @Column(name = "Actualizar")
    private Integer Actualizar;

    public String  getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String  CustomerId) {
        this.CustomerId = CustomerId;
    }

    public Date getFechaFidelizacion() {
        return FechaFidelizacion;
    }

    public void setFechaFidelizacion(Date FechaFidelizacion) {
        this.FechaFidelizacion = FechaFidelizacion;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public Double getComprasAcumuladas() {
        return ComprasAcumuladas;
    }

    public void setComprasAcumuladas(Double ComprasAcumuladas) {
        this.ComprasAcumuladas = ComprasAcumuladas;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    public Double getMontoMantener() {
        return MontoMantener;
    }

    public void setMontoMantener(Double MontoMantener) {
        this.MontoMantener = MontoMantener;
    }

    public Double getMontoAscender() {
        return MontoAscender;
    }

    public void setMontoAscender(Double MontoAscender) {
        this.MontoAscender = MontoAscender;
    }

    public Integer getActualizar() {
        return Actualizar;
    }

    public void setActualizar(Integer Actualizar) {
        this.Actualizar = Actualizar;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (CustomerId != null ? CustomerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesFidelityFinal)) {
            return false;
        }
        ClientesFidelityFinal other = (ClientesFidelityFinal) object;
        return !((this.CustomerId == null && other.CustomerId != null) || (this.CustomerId != null && !this.CustomerId.equals(other.CustomerId)));
    }

    @Override
    public String toString() {
        return "mx.prada.entidadesprada.ClientesFidelityFinal[ CustomerId=" + CustomerId + " ]";
    }
}
