/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.teamwork.api;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

/**
 *
 * @author analistabi2
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Settings",
    "Customers"
})
public class Request {
    
    @JsonProperty("Settings")
    @Valid
    private SettingsCreateUpdateCustomer settings;
    @JsonProperty("Customers")
    @Valid
    private List<CustomerCreateUpdateCustomer> customers;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Settings")
    public SettingsCreateUpdateCustomer getSettings() {
        return settings;
    }

    @JsonProperty("Settings")
    public void setSettings(SettingsCreateUpdateCustomer settings) {
        this.settings = settings;
    }

    @JsonProperty("Customers")
    public List<CustomerCreateUpdateCustomer> getCustomers() {
        return customers;
    }

    @JsonProperty("Customers")
    public void setCustomers(List<CustomerCreateUpdateCustomer> customers) {
        this.customers = customers;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
