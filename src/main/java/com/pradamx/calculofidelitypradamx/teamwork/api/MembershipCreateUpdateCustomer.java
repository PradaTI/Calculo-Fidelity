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
    "MembershipEndDate",
    "MembershipLevelName",
    "MembershipType",
    "MembershipCode"
})
public class MembershipCreateUpdateCustomer {

    @JsonProperty("MembershipEndDate")
    private String membershipEndDate;
    @JsonProperty("MembershipLevelName")
    private String membershipLevelName;
    @JsonProperty("MembershipType")
    private String membershipType;
    @JsonProperty("MembershipCode")
    private String membershipCode;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("MembershipEndDate")
    public String getMembershipEndDate() {
        return membershipEndDate;
    }

    @JsonProperty("MembershipEndDate")
    public void setMembershipEndDate(String membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

    @JsonProperty("MembershipLevelName")
    public String getMembershipLevelName() {
        return membershipLevelName;
    }

    @JsonProperty("MembershipLevelName")
    public void setMembershipLevelName(String membershipLevelName) {
        this.membershipLevelName = membershipLevelName;
    }

    @JsonProperty("MembershipType")
    public String getMembershipType() {
        return membershipType;
    }

    @JsonProperty("MembershipType")
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    @JsonProperty("MembershipCode")
    public String getMembershipCode() {
        return membershipCode;
    }

    @JsonProperty("MembershipCode")
    public void setMembershipCode(String membershipCode) {
        this.membershipCode = membershipCode;
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
