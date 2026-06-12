/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author analistabi2
 */
@SpringBootApplication
@EnableScheduling
//public class CalculoFidelityApplication extends SpringBootServletInitializer{
public class CalculoFidelityApplication{
     public static void main(String[] args) {
        SpringApplication.run(CalculoFidelityApplication.class, args);
    }
     
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(CalculoFidelityApplication.class);
//    }
}
