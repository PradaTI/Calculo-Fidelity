/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.repository;

import com.pradamx.calculofidelitypradamx.entity.DevolucionesNormalesDTO;
import com.pradamx.calculofidelitypradamx.entity.vAcumuladoVentasFidelity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EduardoZuñigaHerrema
 */
@Repository("vAcumuladoVentasFidelityRepository")
public interface vAcumuladoVentasFidelityRepository extends JpaRepository<vAcumuladoVentasFidelity, Serializable> {

    @Query("SELECT VAVF FROM vAcumuladoVentasFidelity VAVF WHERE VAVF.SellToCustomerId = :SellToCustomerId ORDER BY Fecha_Asignacion ASC, UniversalNo ASC")
    public List<vAcumuladoVentasFidelity> buscarPorCustomerId(@Param("SellToCustomerId") String SellToCustomerId);

    @Query("SELECT new com.pradamx.calculofidelitypradamx.entity.DevolucionesNormalesDTO(MIN(VAVF.Fecha_Asignacion), SUM(VAVF.Monto)) "
            + "FROM vAcumuladoVentasFidelity VAVF "
            + "WHERE VAVF.SellToCustomerId = :customerID "
            + "AND VAVF.Fecha_Asignacion BETWEEN :fechaInicio AND :fechaFin "
            + "AND VAVF.UniversalNo <= :universalNo")
    DevolucionesNormalesDTO ObtenerDevolucionesEspeciales(
            @Param("customerID") String customerID,
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin,
            @Param("universalNo") Long universalNo
    );

}
