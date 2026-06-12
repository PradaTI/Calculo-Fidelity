/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.service;

import com.pradamx.calculofidelitypradamx.entity.ClientesFidelityFinal;
import com.pradamx.calculofidelitypradamx.entity.ProcesoManualFidelity;
import com.pradamx.calculofidelitypradamx.repository.ProcesoManualFidelityRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author analistabi2
 */
@Service("ProcesoManualFidelityService")
public class ProcesoManualFidelityService {
    
    @Autowired
    private ProcesoManualFidelityRepository ProcesoManualFidelityRepository;
    
    public ProcesoManualFidelity save(ProcesoManualFidelity id_tabla) {
        return this.ProcesoManualFidelityRepository.save(id_tabla);
    }
    
    public List<ProcesoManualFidelity> BuscarActualizar(Integer AEstatus) {
        return this.ProcesoManualFidelityRepository.BuscarActualizar(AEstatus);
    }
    
    public ProcesoManualFidelity BuscarCustomerId(String ACustomer) {
        return this.ProcesoManualFidelityRepository.BuscarCustomerId(ACustomer);
    }
    
     public void GuardarProcesoManualFidelity(String ACustomerID, Integer AEstatus, String AMensaje){
        ProcesoManualFidelity cliente = new ProcesoManualFidelity();
        
        cliente.setCustomerId(ACustomerID);
        cliente.setEstatus(AEstatus);
        cliente.setMensaje(AMensaje);
        save(cliente);
        
        
    }
    
}
