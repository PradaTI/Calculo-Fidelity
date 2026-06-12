/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.teamwork.api;

/**
 *
 * @author analistabi2
 */
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "Status",
    "Progress",
    "TotalRecords",
    "AcceptedRecords",
    "ErrorRecords",
    "ElapsedTime",
    "ErrorMessage",
    "Lines",
    "ApiType",
    "Source",
    "Response"
})
public class ResponseGenerico {
    
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Progress")
    private String progress;
    @JsonProperty("TotalRecords")
    private String totalRecords;
    @JsonProperty("AcceptedRecords")
    private String acceptedRecords;
    @JsonProperty("ErrorRecords")
    private String errorRecords;
    @JsonProperty("ElapsedTime")
    private String elapsedTime;
    @JsonProperty("ErrorMessage")
    private String errorMessage;
    @JsonProperty("Lines")
    @Valid
    private List<Line> lines;
    @JsonProperty("ApiType")
    private String apiType;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Response")
    private String response;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Progress")
    public String getProgress() {
        return progress;
    }

    @JsonProperty("Progress")
    public void setProgress(String progress) {
        this.progress = progress;
    }

    @JsonProperty("TotalRecords")
    public String getTotalRecords() {
        return totalRecords;
    }

    @JsonProperty("TotalRecords")
    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    @JsonProperty("AcceptedRecords")
    public String getAcceptedRecords() {
        return acceptedRecords;
    }

    @JsonProperty("AcceptedRecords")
    public void setAcceptedRecords(String acceptedRecords) {
        this.acceptedRecords = acceptedRecords;
    }

    @JsonProperty("ErrorRecords")
    public String getErrorRecords() {
        return errorRecords;
    }

    @JsonProperty("ErrorRecords")
    public void setErrorRecords(String errorRecords) {
        this.errorRecords = errorRecords;
    }

    @JsonProperty("ElapsedTime")
    public String getElapsedTime() {
        return elapsedTime;
    }

    @JsonProperty("ElapsedTime")
    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @JsonProperty("ErrorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("ErrorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("Lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @JsonProperty("ApiType")
    public String getApiType() {
        return apiType;
    }

    @JsonProperty("ApiType")
    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("Response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = response;
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
