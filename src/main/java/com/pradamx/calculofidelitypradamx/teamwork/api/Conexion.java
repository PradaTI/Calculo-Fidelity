/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.teamwork.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradamx.calculofidelitypradamx.searchcustomrresponse.ApiResultCustomer;
import com.pradamx.calculofidelitypradamx.searchcustomrresponse.CustomersType;
import com.pradamx.calculofidelitypradamx.teamwork.api.ResponseGenerico;
import com.pradamx.hubspot.teamwork.requestgeneral.Data;
import com.pradamx.hubspot.teamwork.requestgeneral.Filter;
import com.pradamx.hubspot.teamwork.requestgeneral.Request;
import com.pradamx.hubspot.teamwork.requestgeneral.RequestGeneral;
import com.pradamx.hubspot.teamwork.requestgeneral.Setting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author analistabi2
 */
public class Conexion {
    public List<CustomersType> buscarporCustomerId (String _url, String AListaCustomerId, Integer ATop, Integer ASkip) throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost p = new HttpPost(_url); //V6 

        RequestGeneral customer = new RequestGeneral();
        Data data = new Data();
        Request _customer = new Request();

        List<Filter> filters = new ArrayList<>();

        Filter filter = new Filter();
        filter.setField("CustomerId");
        filter.setOperator("Contains");
        filter.setValue(AListaCustomerId);

        filters.add(filter);
        _customer.setFilters(filters);

        List<Setting> settings = new ArrayList<>();

        Setting setting1 = new Setting();
        setting1.setKey("CountryIdentifierSetting");
        setting1.setValue("Code");
        settings.add(setting1);

        Setting setting2 = new Setting();
        setting2.setKey("EmployeeIdentifierSetting");
        //setting2.setValue("LoginName");
        setting2.setValue("TeamworkId");
        settings.add(setting2);

        Setting setting3 = new Setting();
        setting3.setKey("LocationIdentifierSetting");
        setting3.setValue("ExternalIdCode");
        settings.add(setting3);

        Setting setting4 = new Setting();
        setting4.setKey("ShippingMethodIdentifierSetting");
        setting4.setValue("Code");
        settings.add(setting4);

        Setting setting5 = new Setting();
        setting5.setKey("MembershipLevelIdentifierSetting");
        setting5.setValue("Name");
        settings.add(setting5);

        Setting setting6 = new Setting();
        setting6.setKey("PriceLevelIdentifierSetting");
        setting6.setValue("Code");
        settings.add(setting6);

        Setting setting7 = new Setting();
        setting7.setKey("CustomerStatusIdentifierSetting");
        setting7.setValue("Name");
        settings.add(setting7);

        Setting setting8 = new Setting();
        setting8.setKey("TaxZoneIdentifierSetting");
        setting8.setValue("Code");
        settings.add(setting8);

        Setting setting9 = new Setting();
        setting9.setKey("DeviceIdentifierSetting");
        setting9.setValue("DeviceName");
        settings.add(setting9);

        _customer.setSettings(settings);

        _customer.setTop(ATop);
        _customer.setSkip(ASkip);

        data.setRequest(_customer);
        customer.setData(data);

        customer.setSource("Prada");

        ObjectMapper mapperCustomerId = new ObjectMapper();

        String json = mapperCustomerId.writeValueAsString(customer);
        System.out.println("JSON REQUEST GetCustomerByCustomerID CRM: " + json);

        p.setHeader("Content-Type", "application/json");
        p.setHeader("ApiKey", "19b6d377-28d6-4e1f-a0b7-cec47bb7682d"); //V6 
        p.setEntity(new StringEntity(json, StandardCharsets.UTF_8));

        CloseableHttpResponse response = client.execute(p);
        if (null != response && null != response.getEntity() && null != response.getEntity().getContent()) {

            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            try ( BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent(), Charset.forName("UTF-8")))) {
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }
            String respuesta = stringBuilder.toString();
            mapperCustomerId = new ObjectMapper();
            ApiResultCustomer root = mapperCustomerId.readValue(respuesta, ApiResultCustomer.class);
            try {
                if (root.getApiDocument().getResponse().getCustomers() != null && root.getApiDocument().getResponse().getCustomers().size() > 0) {
                    return root.getApiDocument().getResponse().getCustomers();
                }
            } catch (Exception e) {

            }
        } else {
        }
        return null;
    }

    public String CreateUpdateCustomer (String _body) throws IOException {
        HttpClient c = HttpClients.createDefault();
        HttpPost p = new HttpPost("https://prada-prod-mx-chq.teamworkinsight.com/chqapi/import/secure-customers"); //V6 
        p.setEntity(new StringEntity(_body, StandardCharsets.UTF_8));
        p.setHeader("Content-Type", "application/json");
        p.setHeader("Accept", "application/json");
        p.setHeader("ApiKey", "19b6d377-28d6-4e1f-a0b7-cec47bb7682d");
        System.out.println(p);
        org.apache.http.HttpResponse response = c.execute(p);

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        if (response.getEntity() != null && response.getEntity().getContent() != null) {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()))) {
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }
            String respuesta = stringBuilder.toString();
            System.out.println("CreateUpdateCustomer Response: " + respuesta);
            return respuesta;
        }
        return null;
    }
    
      public ResponseGenerico checkStatus(String _id) throws IOException {
        HttpClient c = HttpClients.createDefault();
        HttpPost p = new HttpPost("https://prada-prod-mx-chq.teamworkinsight.com/chqapi/status"); //V6 
        String body = "\""+_id+"\"";
        p.setEntity(new StringEntity(body, StandardCharsets.UTF_8));
        p.setHeader("Content-Type", "application/json");
        p.setHeader("Accept", "application/json");
        p.setHeader("ApiKey", "19b6d377-28d6-4e1f-a0b7-cec47bb7682d");
        System.out.println(p);
        org.apache.http.HttpResponse response = c.execute(p);

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        if (response.getEntity() != null && response.getEntity().getContent() != null) {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()))) {
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }
            String respuesta = stringBuilder.toString();
            ObjectMapper mapper = new ObjectMapper();
            ResponseGenerico _response = mapper.readValue(respuesta, ResponseGenerico.class);
            return _response;
        }
        return null;
    }
}
