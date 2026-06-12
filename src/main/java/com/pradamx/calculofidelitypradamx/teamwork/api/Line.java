/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.teamwork.api;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EntityNo",
    "EntityId",
    "Error",
    "Status"
})
@Generated("jsonschema2pojo")
public class Line {

    @JsonProperty("EntityNo")
    private String entityNo;
    @JsonProperty("EntityId")
    private String entityId;
    @JsonProperty("Error")
    private Object error;
    @JsonProperty("Status")
    private String status;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("EntityNo")
    public String getEntityNo() {
        return entityNo;
    }

    @JsonProperty("EntityNo")
    public void setEntityNo(String entityNo) {
        this.entityNo = entityNo;
    }

    @JsonProperty("EntityId")
    public String getEntityId() {
        return entityId;
    }

    @JsonProperty("EntityId")
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @JsonProperty("Error")
    public Object getError() {
        return error;
    }

    @JsonProperty("Error")
    public void setError(Object error) {
        this.error = error;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
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
