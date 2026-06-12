
package com.pradamx.calculofidelitypradamx.service;

import com.pradamx.calculofidelitypradamx.entity.NivelFidelityhistorico;
import com.pradamx.calculofidelitypradamx.repository.NivelFidelityhistoricoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author analistabi2
 */
@Service("NivelFidelityhistoricoService")
public class NivelFidelityhistoricoService {

    @Autowired
    private NivelFidelityhistoricoRepository NivelFidelityhistoricoRepository;

    public NivelFidelityhistorico save(NivelFidelityhistorico nivelFidelityhistorico) {
        return this.NivelFidelityhistoricoRepository.save(nivelFidelityhistorico);
    }

    public List<NivelFidelityhistorico> BuscarTodos() {
        return this.NivelFidelityhistoricoRepository.findAll();
    }

    public List<NivelFidelityhistorico> BuscarCustomerid(String ACustomerid) {
        return this.NivelFidelityhistoricoRepository.findByCustomerid(ACustomerid);
    }

    public NivelFidelityhistorico BuscarCustomeridNoticket(String ACustomerid, String ANoticket) {
        return this.NivelFidelityhistoricoRepository.findByCustomeridAndNoticket(ACustomerid, ANoticket);
    }

    public List<NivelFidelityhistorico> BuscarNivel(String ANivel) {
        return this.NivelFidelityhistoricoRepository.findByNivel(ANivel);
    }

    public void GuardarNivelFidelityhistorico(
            String Acustomerid,
            String Anoticket,
            String Afechainscripcionfidelity,
            String Afechaasignacioncompra,
            String Afechavencimiento,
            String Amonto,
            String Acomprasacumuladas,
            String Anivel,
            String Amontoparamantener,
            String Amontoparaascender,
            String Aticketorigen) {

        NivelFidelityhistorico cliente = new NivelFidelityhistorico();

        
        cliente.setCustomerid(Acustomerid);
        cliente.setNoticket(Anoticket);
        cliente.setFechainscripcionfidelity(Afechainscripcionfidelity);
        cliente.setFechaasignacioncompra(Afechaasignacioncompra);
        cliente.setFechavencimiento(Afechavencimiento);
        cliente.setMonto(Amonto);
        cliente.setComprasacumuladas(Acomprasacumuladas);
        cliente.setNivel(Anivel);
        cliente.setMontoparamantener(Amontoparamantener);
        cliente.setMontoparaascender(Amontoparaascender);
        cliente.setTicketorigen(Aticketorigen);

        save(cliente);
    }
}