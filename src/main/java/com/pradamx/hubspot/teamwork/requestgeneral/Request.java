/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.hubspot.teamwork.requestgeneral;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Settings", "Filters", "SortDescriptions", "Top", "Skip" })
public class Request{

	@JsonProperty("Settings")
	private List<Setting> settings = null;
	@JsonProperty("Filters")
	private List<Filter> filters = null;
	@JsonProperty("SortDescriptions")
	private List<SortDescription> sortDescriptions = null;
	@JsonProperty("Top")
	private Integer top;
	@JsonProperty("Skip")
	private Integer skip;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Settings")
	public List<Setting> getSettings() {
		return settings;
	}

	@JsonProperty("Settings")
	public void setSettings(List<Setting> settings) {
		this.settings = settings;
	}

	@JsonProperty("Filters")
	public List<Filter> getFilters() {
		return filters;
	}

	@JsonProperty("Filters")
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	@JsonProperty("SortDescriptions")
	public List<SortDescription> getSortDescriptions() {
		return sortDescriptions;
	}

	@JsonProperty("SortDescriptions")
	public void setSortDescriptions(List<SortDescription> sortDescriptions) {
		this.sortDescriptions = sortDescriptions;
	}

	@JsonProperty("Top")
	public Integer getTop() {
		return top;
	}

	@JsonProperty("Top")
	public void setTop(Integer top) {
		this.top = top;
	}

	@JsonProperty("Skip")
	public Integer getSkip() {
		return skip;
	}

	@JsonProperty("Skip")
	public void setSkip(Integer skip) {
		this.skip = skip;
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