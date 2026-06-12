/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pradamx.calculofidelitypradamx.entity;

import java.io.Serializable;
import java.util.Objects;

public class NivelFidelityhistoricoPK implements Serializable {

    private String customerid;
    private String noticket;

    public NivelFidelityhistoricoPK() {
    }

    public NivelFidelityhistoricoPK(String customerid, String noticket) {
        this.customerid = customerid;
        this.noticket = noticket;
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

    @Override
    public int hashCode() {
        return Objects.hash(customerid, noticket);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        NivelFidelityhistoricoPK other = (NivelFidelityhistoricoPK) obj;

        return Objects.equals(this.customerid, other.customerid)
                && Objects.equals(this.noticket, other.noticket);
    }

}