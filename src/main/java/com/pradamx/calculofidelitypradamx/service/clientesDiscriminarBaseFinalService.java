/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.service;

import com.pradamx.calculofidelitypradamx.entity.clientesDiscriminarBaseFinal;
import com.pradamx.calculofidelitypradamx.repository.clientesDiscriminarBaseFinalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author analistabi2
 */
@Service("clientesDiscriminarBaseFinalService")
public class clientesDiscriminarBaseFinalService {
    @Autowired
    private clientesDiscriminarBaseFinalRepository clientesDiscriminarBaseFinalRepository;

    public List<clientesDiscriminarBaseFinal> findAll() {
        return this.clientesDiscriminarBaseFinalRepository.findAll();
    }
    public clientesDiscriminarBaseFinal BuscarCustomerId(String ACustomerId) {
        return this.clientesDiscriminarBaseFinalRepository.BuscarCustomerId(ACustomerId);
    }
    public List<clientesDiscriminarBaseFinal> buscarPorCustomerIds(List<String> ACustomerList) {
        return this.clientesDiscriminarBaseFinalRepository.buscarPorCustomerIds(ACustomerList);
    }
    
}
