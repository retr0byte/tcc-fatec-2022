package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.AulaDTO;
import br.fatec.we_can_teach_you.model.Aula;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class AulaMapper {
    
    public Aula toEntity(AulaDTO obj) {
        Aula aula = new Aula();
        aula.setId(obj.getId());
        aula.setLinkReuniao(obj.getLinkReuniao());
        aula.setDataAula(obj.getDataAula());
        aula.setDuracaoAula(obj.getDuracaoAula());
        aula.setValorAula(obj.getValorAula());
        aula.setCategoria(obj.getCategoria());
        return aula;
    }
    
    public AulaDTO toDTO(Aula obj) {
        AulaDTO aulaDTO = new AulaDTO();
        aulaDTO.setId(obj.getId());
        aulaDTO.setLinkReuniao(obj.getLinkReuniao());
        aulaDTO.setDataAula(obj.getDataAula());
        aulaDTO.setDuracaoAula(obj.getDuracaoAula());
        aulaDTO.setValorAula(obj.getValorAula());
        aulaDTO.setCategoria(obj.getCategoria());
        return aulaDTO;
    }

    public List<Aula> toEntity(List<AulaDTO> list) {
        List<Aula> lista = new ArrayList<>();
        for (AulaDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<AulaDTO> toDTO(List<Aula> list){
        List<AulaDTO> lista = new ArrayList<>();
        for(Aula a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }
}
