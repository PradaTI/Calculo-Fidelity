/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.teamwork.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;

/**
 *
 * @author analistabi2
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CustomFlag4",
    "CustomText5",
    "CustomText4",
    "CustomLookup9",
    "CustomText3",
    "CustomDate2",
    "CustomDecimal3",
    "CustomDecimal1",
    "CustomDecimal2",})
public class CustomFieldsCreateUpdateeCustomer {

    @JsonProperty("CustomFlag4")
    private Boolean customflag4;
    @JsonProperty("CustomText5")
    private String customText5;
    @JsonProperty("CustomText4")
    private String customText4;
    @JsonProperty("CustomText3")
    private String customText3;
    @JsonProperty("CustomLookup9")
    private String customLookup9;
    @JsonProperty("CustomDate2")
    private String customDate2;
    @JsonProperty("CustomDecimal3")
    private BigDecimal customdecimal3;
    @JsonProperty("CustomDecimal1")
    private BigDecimal customdecimal1;
    @JsonProperty("CustomDecimal2")
    private BigDecimal customdecimal2;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getCustomflag4() {
        return customflag4;
    }

    public void setCustomflag4(Boolean customflag4) {
        this.customflag4 = customflag4;
    }

    public String getCustomText5() {
        return customText5;
    }

    public void setCustomText5(String customText5) {
        this.customText5 = customText5;
    }

    public String getCustomText4() {
        return customText4;
    }

    public void setCustomText4(String customText4) {
        this.customText4 = customText4;
    }

    public String getCustomText3() {
        return customText3;
    }

    public void setCustomText3(String customText3) {
        this.customText3 = customText3;
    }

    public String getCustomLookup9() {
        return customLookup9;
    }

    public void setCustomLookup9(String customLookup9) {
        this.customLookup9 = customLookup9;
    }

    public String getCustomDate2() {
        return customDate2;
    }

    public void setCustomDate2(String customDate2) {
        this.customDate2 = customDate2;
    }

    public BigDecimal getCustomdecimal3() {
        return customdecimal3;
    }

    public void setCustomdecimal3(BigDecimal customdecimal3) {
        this.customdecimal3 = customdecimal3;
    }

    public BigDecimal getCustomdecimal1() {
        return customdecimal1;
    }

    public void setCustomdecimal1(BigDecimal customdecimal1) {
        this.customdecimal1 = customdecimal1;
    }

    public BigDecimal getCustomdecimal2() {
        return customdecimal2;
    }

    public void setCustomdecimal2(BigDecimal customdecimal2) {
        this.customdecimal2 = customdecimal2;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
