/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.searchcustomrresponse;

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
"ApiDocumentId",
"Status",
"ApiRequestType",
"TotalRecords",
"RecordsCount",
"ElapsedTime",
"StartDateTime",
"EndDateTime",
"Response"
})
@Generated("jsonschema2pojo")
public class ApiDocumentTypeCustomer {

@JsonProperty("ApiDocumentId")
private String apiDocumentId;
@JsonProperty("Status")
private String status;
@JsonProperty("ApiRequestType")
private String apiRequestType;
@JsonProperty("TotalRecords")
private Integer totalRecords;
@JsonProperty("RecordsCount")
private Integer recordsCount;
@JsonProperty("ElapsedTime")
private String elapsedTime;
@JsonProperty("StartDateTime")
private String startDateTime;
@JsonProperty("EndDateTime")
private String endDateTime;
@JsonProperty("Response")
@Valid
private ResponseTypeCustomer response;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("ApiDocumentId")
public String getApiDocumentId() {
return apiDocumentId;
}

@JsonProperty("ApiDocumentId")
public void setApiDocumentId(String apiDocumentId) {
this.apiDocumentId = apiDocumentId;
}

@JsonProperty("Status")
public String getStatus() {
return status;
}

@JsonProperty("Status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("ApiRequestType")
public String getApiRequestType() {
return apiRequestType;
}

@JsonProperty("ApiRequestType")
public void setApiRequestType(String apiRequestType) {
this.apiRequestType = apiRequestType;
}

@JsonProperty("TotalRecords")
public Integer getTotalRecords() {
return totalRecords;
}

@JsonProperty("TotalRecords")
public void setTotalRecords(Integer totalRecords) {
this.totalRecords = totalRecords;
}

@JsonProperty("RecordsCount")
public Integer getRecordsCount() {
return recordsCount;
}

@JsonProperty("RecordsCount")
public void setRecordsCount(Integer recordsCount) {
this.recordsCount = recordsCount;
}

@JsonProperty("ElapsedTime")
public String getElapsedTime() {
return elapsedTime;
}

@JsonProperty("ElapsedTime")
public void setElapsedTime(String elapsedTime) {
this.elapsedTime = elapsedTime;
}

@JsonProperty("StartDateTime")
public String getStartDateTime() {
return startDateTime;
}

@JsonProperty("StartDateTime")
public void setStartDateTime(String startDateTime) {
this.startDateTime = startDateTime;
}

@JsonProperty("EndDateTime")
public String getEndDateTime() {
return endDateTime;
}

@JsonProperty("EndDateTime")
public void setEndDateTime(String endDateTime) {
this.endDateTime = endDateTime;
}

@JsonProperty("Response")
public ResponseTypeCustomer getResponse() {
return response;
}

@JsonProperty("Response")
public void setResponse(ResponseTypeCustomer response) {
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