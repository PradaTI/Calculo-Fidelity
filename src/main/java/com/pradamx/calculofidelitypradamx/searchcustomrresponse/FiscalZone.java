/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.searchcustomrresponse;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author analistabi2
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "FiscalZoneId",
                     "Name" })
public class FiscalZone {

    @JsonProperty("FiscalZoneId")
    private String fiscalZoneId;
    @JsonProperty("Name")
    private String Name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FiscalZoneId")
    public String getFiscalZoneId() {
        return fiscalZoneId;
    }

    @JsonProperty("FiscalZoneId")
    public void setFiscalZoneId(String fiscalZoneId) {
        this.fiscalZoneId = fiscalZoneId;
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
