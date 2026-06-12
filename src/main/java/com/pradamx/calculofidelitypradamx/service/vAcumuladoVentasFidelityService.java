/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.service;

import com.pradamx.calculofidelitypradamx.entity.DevolucionesNormalesDTO;
import com.pradamx.calculofidelitypradamx.entity.vAcumuladoVentasFidelity;
import com.pradamx.calculofidelitypradamx.repository.vAcumuladoVentasFidelityRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EduardoZuñigaHerrema
 */
@Service("vAcumuladoVentasFidelityService")
public class vAcumuladoVentasFidelityService {

    @Autowired
    private vAcumuladoVentasFidelityRepository vAcumuladoVentasFidelityRepository;

    public List<vAcumuladoVentasFidelity> buscarPorCustomerId(String SellToCustomerId) {
        return this.vAcumuladoVentasFidelityRepository.buscarPorCustomerId(SellToCustomerId);
    }

    public DevolucionesNormalesDTO ObtenerDevolucionesEspeciales(String customerID, Date fechaInicio, Date fechaFin, Long universalNo) {
        return this.vAcumuladoVentasFidelityRepository.ObtenerDevolucionesEspeciales(customerID, fechaInicio, fechaFin, universalNo);
    }

    public List<vAcumuladoVentasFidelity> findAll() {
        return this.vAcumuladoVentasFidelityRepository.findAll();
    }

}
