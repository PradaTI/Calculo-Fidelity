/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.searchcustomrresponse;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Name"
})
@Generated("jsonschema2pojo")
public class MultiselectLookup1 {

@JsonProperty("Name")
private String name;

@JsonProperty("Name")
public String getName() {
return name;
}

@JsonProperty("Name")
public void setName(String name) {
this.name = name;
}

}