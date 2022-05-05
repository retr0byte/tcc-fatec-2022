package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import br.fatec.we_can_teach_you.dto.AtividadeDTO;
import br.fatec.we_can_teach_you.model.Atividade;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class AtividadeMapper {
    public Atividade toEntity(AtividadeDTO obj){
        Atividade atividade = new Atividade();
        atividade.setId(obj.getId());
        atividade.setTitulo(obj.getTitulo());
        atividade.setDescricao(obj.getDescricao());
        atividade.setDataEntrega(obj.getDataEntrega());
        atividade.setAula(obj.getAula());

        return atividade;
    };

    public AtividadeDTO toDTO(Atividade obj){
        AtividadeDTO atividadeDTO = new AtividadeDTO();
        atividadeDTO.setId(obj.getId());
        atividadeDTO.setTitulo(obj.getTitulo());
        atividadeDTO.setDescricao(obj.getDescricao());
        atividadeDTO.setDataEntrega(obj.getDataEntrega());
        atividadeDTO.setAula(obj.getAula());

        return atividadeDTO;
    };

    public List<Atividade> toEntity(List<AtividadeDTO> list) {
        List<Atividade> lista = new ArrayList<>();
        for (AtividadeDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<AtividadeDTO> toDTO(List<Atividade> list){
        List<AtividadeDTO> lista = new ArrayList<>();
        for(Atividade a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }
}
