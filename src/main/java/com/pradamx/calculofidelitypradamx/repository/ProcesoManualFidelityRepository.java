/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.repository;

import com.pradamx.calculofidelitypradamx.entity.ProcesoManualFidelity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author analistabi2
 */
@Repository("ProcesoManualFidelityRepository")
public interface ProcesoManualFidelityRepository extends JpaRepository<ProcesoManualFidelity, Serializable> {
    @Query("SELECT PMF FROM ProcesoManualFidelity PMF WHERE PMF.Estatus = :AEstatus")
        public  List<ProcesoManualFidelity>  BuscarActualizar(@Param("AEstatus") Integer AEstatus);
        
    @Query("SELECT PMF FROM ProcesoManualFidelity PMF WHERE PMF.CustomerId = :ACustomerId")
        public  ProcesoManualFidelity  BuscarCustomerId(@Param("ACustomerId") String ACustomerId);
    
}
