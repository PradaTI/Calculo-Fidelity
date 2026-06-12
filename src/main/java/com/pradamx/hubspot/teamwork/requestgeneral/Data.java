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
@JsonPropertyOrder({ "ApiDocumentId", "Request" })
public class Data {

	@JsonProperty("ApiDocumentId")
	private String apiDocumentId;
	@JsonProperty("Request")
	private Request request;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ApiDocumentId")
	public String getApiDocumentId() {
		return apiDocumentId;
	}

	@JsonProperty("ApiDocumentId")
	public void setApiDocumentId(String apiDocumentId) {
		this.apiDocumentId = apiDocumentId;
	}

	@JsonProperty("Request")
	public Request getRequest() {
		return request;
	}

	@JsonProperty("Request")
	public void setRequest(Request request) {
		this.request = request;
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