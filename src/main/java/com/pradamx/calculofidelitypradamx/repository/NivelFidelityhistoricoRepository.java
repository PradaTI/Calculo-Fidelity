/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.repository;

/**
 *
 * @author OmarMartínezGómez
 */

import com.pradamx.calculofidelitypradamx.entity.NivelFidelityhistorico;
import com.pradamx.calculofidelitypradamx.entity.NivelFidelityhistoricoPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelFidelityhistoricoRepository extends JpaRepository<NivelFidelityhistorico, NivelFidelityhistoricoPK> {

    public List<NivelFidelityhistorico> findByCustomerid(String customerid);

    public NivelFidelityhistorico findByCustomeridAndNoticket(String customerid, String noticket);

    public List<NivelFidelityhistorico> findByNivel(String nivel);
}