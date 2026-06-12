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
    "CustomerMarketingId",
    "CustomerId",
    "OptInPhoneCall",
    "OptInPhone2Call",
    "OptInPhone3Call",
    "OptInPhone4Call",
    "OptInPhoneSms",
    "OptInPhone2Sms",
    "OptInPhone3Sms",
    "OptInPhone4Sms",
    "OptInPostalAdress",
    "OptInLoyaltyProgram",
    "PrimaryEmailValidation",
    "PostalAdressValidation",
    "PhoneValidation",
    "Phone2Validation",
    "Phone3Validation",
    "Phone4Validation",
    "Email2Validation"
})
@Generated("jsonschema2pojo")
public class CustomerMarketing {

    @JsonProperty("RecCreated")
    private String recCreated;
    @JsonProperty("RecModified")
    private String recModified;
    @JsonProperty("CustomerMarketingId")
    private String customerMarketingId;
    @JsonProperty("CustomerId")
    private String customerId;
    @JsonProperty("OptInPhoneCall")
    private Boolean optInPhoneCall;
    @JsonProperty("OptInPhone2Call")
    private Boolean optInPhone2Call;
    @JsonProperty("OptInPhone3Call")
    private Boolean optInPhone3Call;
    @JsonProperty("OptInPhone4Call")
    private Boolean optInPhone4Call;
    @JsonProperty("OptInPhoneSms")
    private Boolean optInPhoneSms;
    @JsonProperty("OptInPhone2Sms")
    private Boolean optInPhone2Sms;
    @JsonProperty("OptInPhone3Sms")
    private Boolean optInPhone3Sms;
    @JsonProperty("OptInPhone4Sms")
    private Boolean optInPhone4Sms;
    @JsonProperty("OptInPostalAdress")
    private Boolean optInPostalAdress;
    @JsonProperty("OptInLoyaltyProgram")
    private Integer optInLoyaltyProgram;
    @JsonProperty("PrimaryEmailValidation")
    private Integer primaryEmailValidation;
    @JsonProperty("PostalAdressValidation")
    private Integer postalAdressValidation;
    @JsonProperty("PhoneValidation")
    private Integer phoneValidation;
    @JsonProperty("Phone2Validation")
    private Integer phone2Validation;
    @JsonProperty("Phone3Validation")
    private Integer phone3Validation;
    @JsonProperty("Phone4Validation")
    private Integer phone4Validation;
    @JsonProperty("Email2Validation")
    private Integer email2Validation;
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

    @JsonProperty("CustomerMarketingId")
    public String getCustomerMarketingId() {
        return customerMarketingId;
    }

    @JsonProperty("CustomerMarketingId")
    public void setCustomerMarketingId(String customerMarketingId) {
        this.customerMarketingId = customerMarketingId;
    }

    @JsonProperty("CustomerId")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("CustomerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("OptInPhoneCall")
    public Boolean getOptInPhoneCall() {
        return optInPhoneCall;
    }

    @JsonProperty("OptInPhoneCall")
    public void setOptInPhoneCall(Boolean optInPhoneCall) {
        this.optInPhoneCall = optInPhoneCall;
    }

    @JsonProperty("OptInPhone2Call")
    public Boolean getOptInPhone2Call() {
        return optInPhone2Call;
    }

    @JsonProperty("OptInPhone2Call")
    public void setOptInPhone2Call(Boolean optInPhone2Call) {
        this.optInPhone2Call = optInPhone2Call;
    }

    @JsonProperty("OptInPhone3Call")
    public Boolean getOptInPhone3Call() {
        return optInPhone3Call;
    }

    @JsonProperty("OptInPhone3Call")
    public void setOptInPhone3Call(Boolean optInPhone3Call) {
        this.optInPhone3Call = optInPhone3Call;
    }

    @JsonProperty("OptInPhone4Call")
    public Boolean getOptInPhone4Call() {
        return optInPhone4Call;
    }

    @JsonProperty("OptInPhone4Call")
    public void setOptInPhone4Call(Boolean optInPhone4Call) {
        this.optInPhone4Call = optInPhone4Call;
    }

    @JsonProperty("OptInPhoneSms")
    public Boolean getOptInPhoneSms() {
        return optInPhoneSms;
    }

    @JsonProperty("OptInPhoneSms")
    public void setOptInPhoneSms(Boolean optInPhoneSms) {
        this.optInPhoneSms = optInPhoneSms;
    }

    @JsonProperty("OptInPhone2Sms")
    public Boolean getOptInPhone2Sms() {
        return optInPhone2Sms;
    }

    @JsonProperty("OptInPhone2Sms")
    public void setOptInPhone2Sms(Boolean optInPhone2Sms) {
        this.optInPhone2Sms = optInPhone2Sms;
    }

    @JsonProperty("OptInPhone3Sms")
    public Boolean getOptInPhone3Sms() {
        return optInPhone3Sms;
    }

    @JsonProperty("OptInPhone3Sms")
    public void setOptInPhone3Sms(Boolean optInPhone3Sms) {
        this.optInPhone3Sms = optInPhone3Sms;
    }

    @JsonProperty("OptInPhone4Sms")
    public Boolean getOptInPhone4Sms() {
        return optInPhone4Sms;
    }

    @JsonProperty("OptInPhone4Sms")
    public void setOptInPhone4Sms(Boolean optInPhone4Sms) {
        this.optInPhone4Sms = optInPhone4Sms;
    }

    @JsonProperty("OptInPostalAdress")
    public Boolean getOptInPostalAdress() {
        return optInPostalAdress;
    }

    @JsonProperty("OptInPostalAdress")
    public void setOptInPostalAdress(Boolean optInPostalAdress) {
        this.optInPostalAdress = optInPostalAdress;
    }

    @JsonProperty("OptInLoyaltyProgram")
    public Integer getOptInLoyaltyProgram() {
        return optInLoyaltyProgram;
    }

    @JsonProperty("OptInLoyaltyProgram")
    public void setOptInLoyaltyProgram(Integer optInLoyaltyProgram) {
        this.optInLoyaltyProgram = optInLoyaltyProgram;
    }

    @JsonProperty("PrimaryEmailValidation")
    public Integer getPrimaryEmailValidation() {
        return primaryEmailValidation;
    }

    @JsonProperty("PrimaryEmailValidation")
    public void setPrimaryEmailValidation(Integer primaryEmailValidation) {
        this.primaryEmailValidation = primaryEmailValidation;
    }

    @JsonProperty("PostalAdressValidation")
    public Integer getPostalAdressValidation() {
        return postalAdressValidation;
    }

    @JsonProperty("PostalAdressValidation")
    public void setPostalAdressValidation(Integer postalAdressValidation) {
        this.postalAdressValidation = postalAdressValidation;
    }

    @JsonProperty("PhoneValidation")
    public Integer getPhoneValidation() {
        return phoneValidation;
    }

    @JsonProperty("PhoneValidation")
    public void setPhoneValidation(Integer phoneValidation) {
        this.phoneValidation = phoneValidation;
    }

    @JsonProperty("Phone2Validation")
    public Integer getPhone2Validation() {
        return phone2Validation;
    }

    @JsonProperty("Phone2Validation")
    public void setPhone2Validation(Integer phone2Validation) {
        this.phone2Validation = phone2Validation;
    }

    @JsonProperty("Phone3Validation")
    public Integer getPhone3Validation() {
        return phone3Validation;
    }

    @JsonProperty("Phone3Validation")
    public void setPhone3Validation(Integer phone3Validation) {
        this.phone3Validation = phone3Validation;
    }

    @JsonProperty("Phone4Validation")
    public Integer getPhone4Validation() {
        return phone4Validation;
    }

    @JsonProperty("Phone4Validation")
    public void setPhone4Validation(Integer phone4Validation) {
        this.phone4Validation = phone4Validation;
    }

    @JsonProperty("Email2Validation")
    public Integer getEmail2Validation() {
        return email2Validation;
    }

    @JsonProperty("Email2Validation")
    public void setEmail2Validation(Integer email2Validation) {
        this.email2Validation = email2Validation;
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
