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
    "RecCreated",
    "RecModified",
    "Active",
    "ContactNo",
    "IsPrimary",
    "CustomDecimal1",
    "CustomDecimal2",
    "Type",
    "ContactType",
    "RecCreated",
    "RecModified",
    "Active",
    "ContactNo",
    "IsPrimary",
    "Address1",
    "Address2",
    "Address3",
    "Address4",
    "Address5",
    "City",
    "Phone",
    "CountryIdentifier",
    "Fax",
    "PostalCode",
    "FiscalCode",
    "CustomFlag1",
    "CustomFlag2",
    "Type",
    "ContactType"

})
@Generated("jsonschema2pojo")
public class Contacts {

    @JsonProperty("RecCreated")
    private String recCreated;
    @JsonProperty("RecModified")
    private String recModified;
    @JsonProperty("Active")
    private Boolean active;
    @JsonProperty("ContactNo")
    private String contactNo;
    @JsonProperty("IsPrimary")
    private Boolean isPrimary;
    @JsonProperty("CustomDecimal1")
    private Double customDecimal1;
    @JsonProperty("CustomDecimal2")
    private Double customDecimal2;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("ContactType")
    private String contactType;

    @JsonProperty("Address1")
    private String address1;
    @JsonProperty("Address2")
    private String address2;
    @JsonProperty("Address3")
    private String address3;
    @JsonProperty("Address4")
    private String address4;
    @JsonProperty("Address5")
    private String address5;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("CountryIdentifier")
    private String countryIdentifier;
    @JsonProperty("Fax")
    private String fax;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("FiscalCode")
    private String fiscalCode;
    @JsonProperty("CustomFlag1")
    private Boolean customFlag1;
    @JsonProperty("CustomFlag2")
    private Boolean customFlag2;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("RecCreated")
    public String getRecCreated() {
        return recCreated;
    }

    @JsonProperty("RecCreated")
    public void setRecCreated(String recCreated) {
        this.recCreated = recCreated;
    }

    @JsonProperty("RecModified")
    public String getRecModified() {
        return recModified;
    }

    @JsonProperty("RecModified")
    public void setRecModified(String recModified) {
        this.recModified = recModified;
    }

    @JsonProperty("Active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("ContactNo")
    public String getContactNo() {
        return contactNo;
    }

    @JsonProperty("ContactNo")
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @JsonProperty("IsPrimary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("IsPrimary")
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    @JsonProperty("CustomDecimal1")
    public Double getCustomDecimal1() {
        return customDecimal1;
    }

    @JsonProperty("CustomDecimal1")
    public void setCustomDecimal1(Double customDecimal1) {
        this.customDecimal1 = customDecimal1;
    }

    @JsonProperty("CustomDecimal2")
    public Double getCustomDecimal2() {
        return customDecimal2;
    }

    @JsonProperty("CustomDecimal2")
    public void setCustomDecimal2(Double customDecimal2) {
        this.customDecimal2 = customDecimal2;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("ContactType")
    public String getContactType() {
        return contactType;
    }

    @JsonProperty("ContactType")
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryIdentifier() {
        return countryIdentifier;
    }

    public void setCountryIdentifier(String countryIdentifier) {
        this.countryIdentifier = countryIdentifier;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Boolean getCustomFlag1() {
        return customFlag1;
    }

    public void setCustomFlag1(Boolean customFlag1) {
        this.customFlag1 = customFlag1;
    }

    public Boolean getCustomFlag2() {
        return customFlag2;
    }

    public void setCustomFlag2(Boolean customFlag2) {
        this.customFlag2 = customFlag2;
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
