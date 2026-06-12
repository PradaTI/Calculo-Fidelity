/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.hubspot.teamwork.requestgeneral;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Field", "Operator", "Value"})
public class Filter {

    @JsonProperty("Field")
    private String field;
    @JsonProperty("Operator")
    private String operator;
    @JsonProperty("Value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Field")
    public String getField() {
        return field;
    }

    @JsonProperty("Field")
    public void setField(String field) {
        this.field = field;
    }

    @JsonProperty("Operator")
    public String getOperator() {
        return operator;
    }

    @JsonProperty("Operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
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
