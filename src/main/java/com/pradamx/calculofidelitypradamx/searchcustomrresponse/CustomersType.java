/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.searchcustomrresponse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RecCreated",
    "RecModified",
    "CustomerNo",
    "CustomerId",
    "IsDeleted",
    "FirstName",
    "LastName",
    "Address1",
    "Address2",
    "City",
    "State",
    "PostalCode",
    "Phone1",
    "Gender",
    "CreateEmployee",
    "EditEmployee",
    "Email1",
    "TaxExempt",
    "CountryIdentifier",
    "IsCompany",
    "CustomFlag4",
    "CustomDecimal1",
    "CustomDecimal2",
    "BdDay",
    "BdMonth",
    "BdYear",
    "MembershipCode",
    "WholesaleCustomer",
    "TradingPartner",
    "Type",
    "Active",
    "UniversalCustomerType",
    "CreateDateTime",
    "EditDateTime",
    "AcceptMarketing",
    "Employee",
    "AcceptMarketing1",
    "AcceptMarketing2",
    "MembershipType",
    "Contacts",
    "CustomerMarketing",
    "AVSPerformed",
    "RegisteredAsGuest",
    "FiscalZones",
    "RecCreated",
    "RecModified",
    "CustomerNo",
    "CustomerId",
    "IsDeleted",
    "FirstName",
    "LastName",
    "Address1",
    "Address2",
    "Address3",
    "Address4",
    "Address5",
    "City",
    "State",
    "PostalCode",
    "FiscalCode",
    "Phone1",
    "Phone2",
    "Phone3",
    "Phone4",
    "Gender",
    "CreateEmployee",
    "EditEmployee",
    "Email1",
    "Email2",
    "TaxExempt",
    "CountryIdentifier",
    "IsCompany",
    "CustomFlag1",
    "CustomFlag2",
    "CustomFlag3",
    "CustomFlag4",
    "CustomLookup1",
    "CustomLookup2",
    "CustomLookup3",
    "CustomLookup4",
    "CustomLookup5",
    "CustomLookup6",
    "CustomLookup11",
    "CustomText1",
    "BdDay",
    "BdMonth",
    "BdYear",
    "MembershipEndDate",
    "MembershipCode",
    "MembershipDays",
    "WholesaleCustomer",
    "TradingPartner",
    "MembershipLevelIdentifier",
    "Type",
    "Active",
    "UniversalCustomerType",
    "CreateDateTime",
    "EditDateTime",
    "AcceptMarketing",
    "Employee",
    "AcceptMarketing1",
    "AcceptMarketing2",
    "MembershipType",
    "Contacts",
    "CustomerMarketing",
    "AVSPerformed",
    "RegisteredAsGuest",
    "Title",
    "MultiselectLookup1s",
    "FiscalZones",
    "CustomText5",
    "CustomText4",
    "CustomLookup9",
    "CustomText3",
    "CustomDate2",
    "CustomDecimal3",
    "PreferredLocationCode",
    "DefaultLocationIdentifier"
})
@Generated("jsonschema2pojo")
public class CustomersType {

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
    private Double customDecimal3;
    @JsonProperty("PreferredLocationCode")
    private String preferredLocationCode;
    @JsonProperty("DefaultLocationIdentifier")
    private String defaultLocationIdentifier;

    @JsonProperty("RecCreated")
    private Date recCreated;
    @JsonProperty("RecModified")
    private Date recModified;
    @JsonProperty("CustomerNo")
    private String customerNo;
    @JsonProperty("CustomerId")
    private String customerId;
    @JsonProperty("IsDeleted")
    private Boolean isDeleted;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Address1")
    private String address1;
    @JsonProperty("Address2")
    private String address2;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Phone1")
    private String phone1;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("CreateEmployee")
    private String createEmployee;
    @JsonProperty("EditEmployee")
    private String editEmployee;
    @JsonProperty("Email1")
    private String email1;
    @JsonProperty("TaxExempt")
    private Boolean taxExempt;
    @JsonProperty("CountryIdentifier")
    private String countryIdentifier;
    @JsonProperty("IsCompany")
    private Boolean isCompany;
    @JsonProperty("CustomFlag4")
    private Boolean customFlag4;
    @JsonProperty("CustomDecimal1")
    private Double customDecimal1;
    @JsonProperty("CustomDecimal2")
    private Double customDecimal2;
    @JsonProperty("BdDay")
    private Integer bdDay;
    @JsonProperty("BdMonth")
    private Integer bdMonth;
    @JsonProperty("BdYear")
    private Integer bdYear;
    @JsonProperty("MembershipCode")
    private String membershipCode;
    @JsonProperty("WholesaleCustomer")
    private Boolean wholesaleCustomer;
    @JsonProperty("TradingPartner")
    private Boolean tradingPartner;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Active")
    private Boolean active;
    @JsonProperty("UniversalCustomerType")
    private String universalCustomerType;
    @JsonProperty("CreateDateTime")
    private String createDateTime;
    @JsonProperty("EditDateTime")
    private String editDateTime;
    @JsonProperty("AcceptMarketing")
    private Boolean acceptMarketing;
    @JsonProperty("Employee")
    private Boolean employee;
    @JsonProperty("AcceptMarketing1")
    private Boolean acceptMarketing1;
    @JsonProperty("AcceptMarketing2")
    private Boolean acceptMarketing2;
    @JsonProperty("MembershipType")
    private String membershipType;
    @JsonProperty("Contacts")
    @Valid
    private Contacts contacts;
    @JsonProperty("CustomerMarketing")
    @Valid
    private CustomerMarketing customerMarketing;
    @JsonProperty("AVSPerformed")
    private Integer aVSPerformed;
    @JsonProperty("RegisteredAsGuest")
    private Boolean registeredAsGuest;
    @JsonProperty("FiscalZones")
    @Valid
    private List<FiscalZone> fiscalZones;

    @JsonProperty("Address3")
    private String address3;
    @JsonProperty("Address4")
    private String address4;
    @JsonProperty("Address5")
    private String address5;
    @JsonProperty("FiscalCode")
    private String fiscalCode;
    @JsonProperty("Phone2")
    private String phone2;
    @JsonProperty("Phone3")
    private String phone3;
    @JsonProperty("Phone4")
    private String phone4;
    @JsonProperty("Email2")
    private String email2;
    @JsonProperty("CustomFlag1")
    private Boolean customFlag1;
    @JsonProperty("CustomFlag2")
    private Boolean customFlag2;
    @JsonProperty("CustomFlag3")
    private Boolean customFlag3;

    @JsonProperty("CustomLookup1")
    private String customLookup1;
    @JsonProperty("CustomLookup2")
    private String customLookup2;
    @JsonProperty("CustomLookup3")
    private String customLookup3;
    @JsonProperty("CustomLookup4")
    private String customLookup4;
    @JsonProperty("CustomLookup5")
    private String customLookup5;
    @JsonProperty("CustomLookup6")
    private String customLookup6;
    @JsonProperty("CustomLookup11")
    private String customLookup11;
    @JsonProperty("MembershipEndDate")
    private String membershipEndDate;
    @JsonProperty("MembershipCode")
    private Integer membershipDays;

    @JsonProperty("MembershipLevelIdentifier")
    private String membershipLevelIdentifier;
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("MultiselectLookup1s")
    private List<MultiselectLookup1> multiselectLookup1s;
    @JsonProperty("MultiselectLookup2s")
    private List<MultiselectLookup1> multiselectLookup2s;
    @JsonProperty("MultiselectLookup3s")
    private List<MultiselectLookup1> multiselectLookup3s;
    @JsonProperty("MultiselectLookup4s")
    private List<MultiselectLookup1> multiselectLookup4s;
    @JsonProperty("MultiselectLookup5s")
    private List<MultiselectLookup1> multiselectLookup5s;
    @JsonProperty("MultiselectLookup6s")
    private List<MultiselectLookup1> multiselectLookup6s;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("RecCreated")
    public Date getRecCreated() {
        return recCreated;
    }

    @JsonProperty("RecCreated")
    public void setRecCreated(Date recCreated) {
        this.recCreated = recCreated;
    }

    @JsonProperty("RecModified")
    public Date getRecModified() {
        return recModified;
    }

    @JsonProperty("RecModified")
    public void setRecModified(Date recModified) {
        this.recModified = recModified;
    }

    @JsonProperty("CustomerNo")
    public String getCustomerNo() {
        return customerNo;
    }

    @JsonProperty("CustomerNo")
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @JsonProperty("CustomerId")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("CustomerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("IsDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("IsDeleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    @JsonProperty("Address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("Address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("Address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("Address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("Phone1")
    public String getPhone1() {
        return phone1;
    }

    @JsonProperty("Phone1")
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    @JsonProperty("Gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("CreateEmployee")
    public String getCreateEmployee() {
        return createEmployee;
    }

    @JsonProperty("CreateEmployee")
    public void setCreateEmployee(String createEmployee) {
        this.createEmployee = createEmployee;
    }

    @JsonProperty("EditEmployee")
    public String getEditEmployee() {
        return editEmployee;
    }

    @JsonProperty("EditEmployee")
    public void setEditEmployee(String editEmployee) {
        this.editEmployee = editEmployee;
    }

    @JsonProperty("Email1")
    public String getEmail1() {
        return email1;
    }

    @JsonProperty("Email1")
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    @JsonProperty("TaxExempt")
    public Boolean getTaxExempt() {
        return taxExempt;
    }

    @JsonProperty("TaxExempt")
    public void setTaxExempt(Boolean taxExempt) {
        this.taxExempt = taxExempt;
    }

    @JsonProperty("CountryIdentifier")
    public String getCountryIdentifier() {
        return countryIdentifier;
    }

    @JsonProperty("CountryIdentifier")
    public void setCountryIdentifier(String countryIdentifier) {
        this.countryIdentifier = countryIdentifier;
    }

    @JsonProperty("IsCompany")
    public Boolean getIsCompany() {
        return isCompany;
    }

    @JsonProperty("IsCompany")
    public void setIsCompany(Boolean isCompany) {
        this.isCompany = isCompany;
    }

    @JsonProperty("CustomFlag4")
    public Boolean getCustomFlag4() {
        return customFlag4;
    }

    @JsonProperty("CustomFlag4")
    public void setCustomFlag4(Boolean customFlag4) {
        this.customFlag4 = customFlag4;
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

    @JsonProperty("BdDay")
    public Integer getBdDay() {
        return bdDay;
    }

    @JsonProperty("BdDay")
    public void setBdDay(Integer bdDay) {
        this.bdDay = bdDay;
    }

    @JsonProperty("BdMonth")
    public Integer getBdMonth() {
        return bdMonth;
    }

    @JsonProperty("BdMonth")
    public void setBdMonth(Integer bdMonth) {
        this.bdMonth = bdMonth;
    }

    @JsonProperty("BdYear")
    public Integer getBdYear() {
        return bdYear;
    }

    @JsonProperty("BdYear")
    public void setBdYear(Integer bdYear) {
        this.bdYear = bdYear;
    }

    @JsonProperty("MembershipCode")
    public String getMembershipCode() {
        return membershipCode;
    }

    @JsonProperty("MembershipCode")
    public void setMembershipCode(String membershipCode) {
        this.membershipCode = membershipCode;
    }

    @JsonProperty("WholesaleCustomer")
    public Boolean getWholesaleCustomer() {
        return wholesaleCustomer;
    }

    @JsonProperty("WholesaleCustomer")
    public void setWholesaleCustomer(Boolean wholesaleCustomer) {
        this.wholesaleCustomer = wholesaleCustomer;
    }

    @JsonProperty("TradingPartner")
    public Boolean getTradingPartner() {
        return tradingPartner;
    }

    @JsonProperty("TradingPartner")
    public void setTradingPartner(Boolean tradingPartner) {
        this.tradingPartner = tradingPartner;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("Active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("UniversalCustomerType")
    public String getUniversalCustomerType() {
        return universalCustomerType;
    }

    @JsonProperty("UniversalCustomerType")
    public void setUniversalCustomerType(String universalCustomerType) {
        this.universalCustomerType = universalCustomerType;
    }

    @JsonProperty("CreateDateTime")
    public String getCreateDateTime() {
        return createDateTime;
    }

    @JsonProperty("CreateDateTime")
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    @JsonProperty("EditDateTime")
    public String getEditDateTime() {
        return editDateTime;
    }

    @JsonProperty("EditDateTime")
    public void setEditDateTime(String editDateTime) {
        this.editDateTime = editDateTime;
    }

    @JsonProperty("AcceptMarketing")
    public Boolean getAcceptMarketing() {
        return acceptMarketing;
    }

    @JsonProperty("AcceptMarketing")
    public void setAcceptMarketing(Boolean acceptMarketing) {
        this.acceptMarketing = acceptMarketing;
    }

    @JsonProperty("Employee")
    public Boolean getEmployee() {
        return employee;
    }

    @JsonProperty("Employee")
    public void setEmployee(Boolean employee) {
        this.employee = employee;
    }

    @JsonProperty("AcceptMarketing1")
    public Boolean getAcceptMarketing1() {
        return acceptMarketing1;
    }

    @JsonProperty("AcceptMarketing1")
    public void setAcceptMarketing1(Boolean acceptMarketing1) {
        this.acceptMarketing1 = acceptMarketing1;
    }

    @JsonProperty("AcceptMarketing2")
    public Boolean getAcceptMarketing2() {
        return acceptMarketing2;
    }

    @JsonProperty("AcceptMarketing2")
    public void setAcceptMarketing2(Boolean acceptMarketing2) {
        this.acceptMarketing2 = acceptMarketing2;
    }

    @JsonProperty("MembershipType")
    public String getMembershipType() {
        return membershipType;
    }

    @JsonProperty("MembershipType")
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    @JsonProperty("Contacts")
    public Contacts getContacts() {
        return contacts;
    }

    @JsonProperty("Contacts")
    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    @JsonProperty("CustomerMarketing")
    public CustomerMarketing getCustomerMarketing() {
        return customerMarketing;
    }

    @JsonProperty("CustomerMarketing")
    public void setCustomerMarketing(CustomerMarketing customerMarketing) {
        this.customerMarketing = customerMarketing;
    }

    @JsonProperty("AVSPerformed")
    public Integer getAVSPerformed() {
        return aVSPerformed;
    }

    @JsonProperty("AVSPerformed")
    public void setAVSPerformed(Integer aVSPerformed) {
        this.aVSPerformed = aVSPerformed;
    }

    @JsonProperty("RegisteredAsGuest")
    public Boolean getRegisteredAsGuest() {
        return registeredAsGuest;
    }

    @JsonProperty("RegisteredAsGuest")
    public void setRegisteredAsGuest(Boolean registeredAsGuest) {
        this.registeredAsGuest = registeredAsGuest;
    }

    @JsonProperty("FiscalZones")
    public List<FiscalZone> getFiscalZones() {
        return fiscalZones;
    }

    @JsonProperty("FiscalZones")
    public void setFiscalZones(List<FiscalZone> fiscalZones) {
        this.fiscalZones = fiscalZones;
    }

    public Integer getaVSPerformed() {
        return aVSPerformed;
    }

    public void setaVSPerformed(Integer aVSPerformed) {
        this.aVSPerformed = aVSPerformed;
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

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getPhone4() {
        return phone4;
    }

    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
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

    public Boolean getCustomFlag3() {
        return customFlag3;
    }

    public void setCustomFlag3(Boolean customFlag3) {
        this.customFlag3 = customFlag3;
    }

    public String getCustomLookup1() {
        return customLookup1;
    }

    public void setCustomLookup1(String customLookup1) {
        this.customLookup1 = customLookup1;
    }

    public String getCustomLookup2() {
        return customLookup2;
    }

    public void setCustomLookup2(String customLookup2) {
        this.customLookup2 = customLookup2;
    }

    public String getCustomLookup3() {
        return customLookup3;
    }

    public void setCustomLookup3(String customLookup3) {
        this.customLookup3 = customLookup3;
    }

    public String getCustomLookup4() {
        return customLookup4;
    }

    public void setCustomLookup4(String customLookup4) {
        this.customLookup4 = customLookup4;
    }

    public String getCustomLookup5() {
        return customLookup5;
    }

    public void setCustomLookup5(String customLookup5) {
        this.customLookup5 = customLookup5;
    }

    public String getCustomLookup6() {
        return customLookup6;
    }

    public void setCustomLookup6(String customLookup6) {
        this.customLookup6 = customLookup6;
    }

    public String getCustomLookup11() {
        return customLookup11;
    }

    public void setCustomLookup11(String customLookup11) {
        this.customLookup11 = customLookup11;
    }

    public String getMembershipEndDate() {
        return membershipEndDate;
    }

    public void setMembershipEndDate(String membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

    public Integer getMembershipDays() {
        return membershipDays;
    }

    public void setMembershipDays(Integer membershipDays) {
        this.membershipDays = membershipDays;
    }

    public String getMembershipLevelIdentifier() {
        return membershipLevelIdentifier;
    }

    public void setMembershipLevelIdentifier(String membershipLevelIdentifier) {
        this.membershipLevelIdentifier = membershipLevelIdentifier;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public List<MultiselectLookup1> getMultiselectLookup1s() {
        return multiselectLookup1s;
    }

    public void setMultiselectLookup1s(List<MultiselectLookup1> multiselectLookup1s) {
        this.multiselectLookup1s = multiselectLookup1s;
    }

    public List<MultiselectLookup1> getMultiselectLookup2s() {
        return multiselectLookup2s;
    }

    public void setMultiselectLookup2s(List<MultiselectLookup1> multiselectLookup2s) {
        this.multiselectLookup2s = multiselectLookup2s;
    }

    public List<MultiselectLookup1> getMultiselectLookup3s() {
        return multiselectLookup3s;
    }

    public void setMultiselectLookup3s(List<MultiselectLookup1> multiselectLookup3s) {
        this.multiselectLookup3s = multiselectLookup3s;
    }

    public List<MultiselectLookup1> getMultiselectLookup4s() {
        return multiselectLookup4s;
    }

    public void setMultiselectLookup4s(List<MultiselectLookup1> multiselectLookup4s) {
        this.multiselectLookup4s = multiselectLookup4s;
    }

    public List<MultiselectLookup1> getMultiselectLookup5s() {
        return multiselectLookup5s;
    }

    public void setMultiselectLookup5s(List<MultiselectLookup1> multiselectLookup5s) {
        this.multiselectLookup5s = multiselectLookup5s;
    }

    public List<MultiselectLookup1> getMultiselectLookup6s() {
        return multiselectLookup6s;
    }

    public void setMultiselectLookup6s(List<MultiselectLookup1> multiselectLookup6s) {
        this.multiselectLookup6s = multiselectLookup6s;
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

    public Double getCustomDecimal3() {
        return customDecimal3;
    }

    public void setCustomDecimal3(Double customDecimal3) {
        this.customDecimal3 = customDecimal3;
    }

    public String getPreferredLocationCode() {
        return preferredLocationCode;
    }

    public void setPreferredLocationCode(String preferredLocationCode) {
        this.preferredLocationCode = preferredLocationCode;
    }

    public String getDefaultLocationIdentifier() {
        return defaultLocationIdentifier;
    }

    public void setDefaultLocationIdentifier(String defaultLocationIdentifier) {
        this.defaultLocationIdentifier = defaultLocationIdentifier;
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

