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
import java.util.Map;
import javax.validation.Valid;

/**
 *
 * @author analistabi2
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "KeyField",
    "EmployeeSetting",
    "IgnoreCustomRequiredFields"
})
public class SettingsCreateUpdateCustomer {

    @JsonProperty("KeyField")
    private String keyField;
    @JsonProperty("EmployeeSetting")
    private String employeeSetting;
    @JsonProperty("IgnoreCustomRequiredFields")
    private Boolean ignoreCustomRequiredFields;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("KeyField")
    public String getKeyField() {
        return keyField;
    }

    @JsonProperty("KeyField")
    public void setKeyField(String keyField) {
        this.keyField = keyField;
    }

    @JsonProperty("EmployeeSetting")
    public String getEmployeeSetting() {
        return employeeSetting;
    }

    @JsonProperty("EmployeeSetting")
    public void setEmployeeSetting(String employeeSetting) {
        this.employeeSetting = employeeSetting;
    }

    @JsonProperty("IgnoreCustomRequiredFields")
    public Boolean getIgnoreCustomRequiredFields() {
        return ignoreCustomRequiredFields;
    }

    @JsonProperty("IgnoreCustomRequiredFields")
    public void setIgnoreCustomRequiredFields(Boolean ignoreCustomRequiredFields) {
        this.ignoreCustomRequiredFields = ignoreCustomRequiredFields;
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
