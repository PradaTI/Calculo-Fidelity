/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.repository;

import com.pradamx.calculofidelitypradamx.entity.clientesDiscriminarBaseFinal;
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
@Repository("clientesDiscriminarBaseFinalRepository")
public interface clientesDiscriminarBaseFinalRepository extends JpaRepository<clientesDiscriminarBaseFinal, Serializable> {

    @Query("SELECT CDBF FROM clientesDiscriminarBaseFinal CDBF WHERE CDBF.CustomerId = :ACustomerId")
    public clientesDiscriminarBaseFinal BuscarCustomerId(@Param("ACustomerId") String ACustomerId);
    
    @Query("SELECT CDBF FROM clientesDiscriminarBaseFinal CDBF WHERE CDBF.CustomerId IN :customerIds")
    List<clientesDiscriminarBaseFinal> buscarPorCustomerIds(@Param("customerIds") List<String> customerIds);
}
