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

/**
 *
 * @author analistabi2
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CustomerNo",
    "Phone1",
    "EMail1",
    "FirstName",
    "LastName",
    "BDDay",
    "BDMonth",
    "BDYear",
    "PreferredLocationCode",
    "DefaultLocationIdentifier",
    "Membership",
    "ExtIdentifiers",
    "CustomFields"

})
public class CustomerCreateUpdateCustomer {

       @JsonProperty("CustomerNo")
    private String customerNo;
    @JsonProperty("Phone1")
    private String phone1;
    @JsonProperty("EMail1")
    private String eMail1;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("BDDay")
    private Integer bDDay;
    @JsonProperty("BDMonth")
    private Integer bDMonth;
    @JsonProperty("BDYear")
    private Integer bDYear;
    @JsonProperty("PreferredLocationCode")
    private String preferredLocationCode;
    @JsonProperty("DefaultLocationIdentifier")
    private String defaultLocationIdentifier;
    @JsonProperty("Membership")
    private MembershipCreateUpdateCustomer membership;
    @JsonProperty("ExtIdentifiers")
    private List<ExtIdentifier> extIdentifiers;
    @JsonProperty("CustomFields")
    private CustomFieldsCreateUpdateeCustomer customFields;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("CustomerNo")
    public String getCustomerNo() {
        return customerNo;
    }

    @JsonProperty("CustomerNo")
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @JsonProperty("Phone1")
    public String getPhone1() {
        return phone1;
    }

    @JsonProperty("Phone1")
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    @JsonProperty("EMail1")
    public String getEMail1() {
        return eMail1;
    }

    @JsonProperty("EMail1")
    public void setEMail1(String eMail1) {
        this.eMail1 = eMail1;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("BDDay")
    public Integer getBDDay() {
        return bDDay;
    }

    @JsonProperty("BDDay")
    public void setBDDay(Integer bDDay) {
        this.bDDay = bDDay;
    }

    @JsonProperty("BDMonth")
    public Integer getBDMonth() {
        return bDMonth;
    }

    @JsonProperty("BDMonth")
    public void setBDMonth(Integer bDMonth) {
        this.bDMonth = bDMonth;
    }

    @JsonProperty("BDYear")
    public Integer getBDYear() {
        return bDYear;
    }

    @JsonProperty("BDYear")
    public void setBDYear(Integer bDYear) {
        this.bDYear = bDYear;
    }

    @JsonProperty("PreferredLocationCode")
    public String getPreferredLocationCode() {
        return preferredLocationCode;
    }

    @JsonProperty("PreferredLocationCode")
    public void setPreferredLocationCode(String preferredLocationCode) {
        this.preferredLocationCode = preferredLocationCode;
    }

    @JsonProperty("DefaultLocationIdentifier")
    public String getDefaultLocationIdentifier() {
        return defaultLocationIdentifier;
    }

    @JsonProperty("DefaultLocationIdentifier")
    public void setDefaultLocationIdentifier(String defaultLocationIdentifier) {
        this.defaultLocationIdentifier = defaultLocationIdentifier;
    }

    @JsonProperty("Membership")
    public MembershipCreateUpdateCustomer getMembership() {
        return membership;
    }

    @JsonProperty("Membership")
    public void setMembership(MembershipCreateUpdateCustomer membership) {
        this.membership = membership;
    }

    @JsonProperty("ExtIdentifiers")
    public List<ExtIdentifier> getExtIdentifiers() {
        return extIdentifiers;
    }

    @JsonProperty("ExtIdentifiers")
    public void setExtIdentifiers(List<ExtIdentifier> extIdentifiers) {
        this.extIdentifiers = extIdentifiers;
    }

    @JsonProperty("CustomFields")
    public CustomFieldsCreateUpdateeCustomer getCustomFields() {
        return customFields;
    }

    @JsonProperty("CustomFields")
    public void setCustomFields(CustomFieldsCreateUpdateeCustomer customFields) {
        this.customFields = customFields;
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

