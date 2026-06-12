/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author analistabi2
 */

@Entity
@Table(name = "ProcesoManualFidelity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoManualFidelity.findAll", query = "SELECT pmf FROM ProcesoManualFidelity pmf"),
    @NamedQuery(name = "ProcesoManualFidelity.findByCustomerId", query = "SELECT pmf FROM ProcesoManualFidelity pmf WHERE pmf.CustomerId = :CustomerId"),
    @NamedQuery(name = "ProcesoManualFidelity.findByEstatus", query = "SELECT pmf FROM ProcesoManualFidelity pmf WHERE pmf.Estatus = :Estatus"),
    @NamedQuery(name = "ProcesoManualFidelity.findByMensaje", query = "SELECT pmf FROM ProcesoManualFidelity pmf WHERE pmf.Mensaje = :Mensaje")
})
public class ProcesoManualFidelity implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CustomerId")
    private String CustomerId;
    
    @Basic(optional = false)
    @Column(name = "Estatus")
    private Integer Estatus;
    
    @Basic(optional = false)
    @Column(name = "Mensaje")
    private String Mensaje;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public Integer getEstatus() {
        return Estatus;
    }

    public void setEstatus(Integer Estatus) {
        this.Estatus = Estatus;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
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
        ProcesoManualFidelity other = (ProcesoManualFidelity) object;
        return !((this.CustomerId == null && other.CustomerId != null) || (this.CustomerId != null && !this.CustomerId.equals(other.CustomerId)));
    }

    @Override
    public String toString() {
        return "mx.prada.entidadesprada.ProcesoManualFidelity[ CustomerId=" + CustomerId + " ]";
    }
}
