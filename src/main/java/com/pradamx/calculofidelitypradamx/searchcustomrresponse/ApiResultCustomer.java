/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.searchcustomrresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author analistabi2
 */
public class ApiResultCustomer {
    @JsonProperty("ApiDocument")
	private ApiDocumentTypeCustomer apiDocument;

	@JsonProperty("ApiDocument")
	public ApiDocumentTypeCustomer getApiDocument() {
		return apiDocument;
	}

	@JsonProperty("ApiDocument")
	public void setApiDocument(ApiDocumentTypeCustomer apiDocument) {
		this.apiDocument = apiDocument;
	}
    
}