/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.repository;
import com.pradamx.calculofidelitypradamx.entity.ClientesFidelityFinal;
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
@Repository("ClientesFidelityFinalRepository")
public interface ClientesFidelityFinalRepository extends JpaRepository<ClientesFidelityFinal, Serializable> {
    
        @Query("SELECT CFF FROM ClientesFidelityFinal CFF WHERE CFF.Nivel = :ANivel")
        public  List<ClientesFidelityFinal>  BuscarXNivel(@Param("ANivel") String ANivel);
        
        @Query("SELECT CFF FROM ClientesFidelityFinal CFF WHERE CFF.Actualizar = :AEstatus")
        public  List<ClientesFidelityFinal>  BuscarActualizar(@Param("AEstatus") Integer AEstatus);
        
        @Query("SELECT CFF FROM ClientesFidelityFinal CFF WHERE CFF.CustomerId IN :customerIds")
         List<ClientesFidelityFinal> buscarPorCustomerIds(@Param("customerIds") List<String> customerIds);
         
        @Query("SELECT CFF FROM ClientesFidelityFinal CFF WHERE CFF.CustomerId = :customerIds")
         ClientesFidelityFinal buscarCustomerId(@Param("customerIds") String customerIds);

}