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
@Table(name = "clientesDiscriminarBaseFinal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findAll", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf"),
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findByCustomerId", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf WHERE cdbf.CustomerId = :CustomerId"),
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findByCampoDuplicado", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf WHERE cdbf.CampoDuplicado = :CampoDuplicado"),
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findByCorreoDuplicado", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf WHERE cdbf.CorreoDuplicado = :CorreoDuplicado"),
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findByTelefono1Duplicado", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf WHERE cdbf.Telefono1Duplicado = :Telefono1Duplicado"),
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findByTelefono2Duplicado", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf WHERE cdbf.Telefono2Duplicado = :Telefono2Duplicado"),
    @NamedQuery(name = "clientesDiscriminarBaseFinal.findByTelefono_en_Telefono2", query = "SELECT cdbf FROM clientesDiscriminarBaseFinal cdbf WHERE cdbf.Telefono_en_Telefono2 = :Telefono_en_Telefono2")
})
public class clientesDiscriminarBaseFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CustomerId")
    private String CustomerId;

    @Basic(optional = false)
    @Column(name = "CampoDuplicado")
    private String CampoDuplicado;

    @Basic(optional = false)
    @Column(name = "CorreoDuplicado")
    private String CorreoDuplicado;

    @Basic(optional = false)
    @Column(name = "Telefono1Duplicado")
    private String Telefono1Duplicado;

    @Basic(optional = false)
    @Column(name = "Telefono2Duplicado")
    private String Telefono2Duplicado;

    @Basic(optional = false)
    @Column(name = "Telefono_en_Telefono2")
    private String Telefono_en_Telefono2;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getCampoDuplicado() {
        return CampoDuplicado;
    }

    public void setCampoDuplicado(String CampoDuplicado) {
        this.CampoDuplicado = CampoDuplicado;
    }

    public String getCorreoDuplicado() {
        return CorreoDuplicado;
    }

    public void setCorreoDuplicado(String CorreoDuplicado) {
        this.CorreoDuplicado = CorreoDuplicado;
    }

    public String getTelefono1Duplicado() {
        return Telefono1Duplicado;
    }

    public void setTelefono1Duplicado(String Telefono1Duplicado) {
        this.Telefono1Duplicado = Telefono1Duplicado;
    }

    public String getTelefono2Duplicado() {
        return Telefono2Duplicado;
    }

    public void setTelefono2Duplicado(String Telefono2Duplicado) {
        this.Telefono2Duplicado = Telefono2Duplicado;
    }

    public String getTelefono_en_Telefono2() {
        return Telefono_en_Telefono2;
    }

    public void setTelefono_en_Telefono2(String Telefono_en_Telefono2) {
        this.Telefono_en_Telefono2 = Telefono_en_Telefono2;
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
        if (!(object instanceof clientesDiscriminarBaseFinal)) {
            return false;
        }
        clientesDiscriminarBaseFinal other = (clientesDiscriminarBaseFinal) object;
        return !((this.CustomerId == null && other.CustomerId != null) || (this.CustomerId != null && !this.CustomerId.equals(other.CustomerId)));
    }

    @Override
    public String toString() {
        return "mx.prada.entidadesprada.clientesDiscriminarBaseFinal[ CustomerId=" + CustomerId + " ]";
    }

}
