package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.MarcacaoDTO;
import br.fatec.we_can_teach_you.model.Marcacao;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class MarcacaoMapper {
    public Marcacao toEntity(MarcacaoDTO obj){
        Marcacao marcacao = new Marcacao();
        marcacao.setId(obj.getId());
        marcacao.setNome(obj.getNome());
        marcacao.setDescricao(obj.getDescricao());
        marcacao.setDataMarcacao(obj.getDataMarcacao());
        marcacao.setAluno(obj.getAluno());
        marcacao.setAula(obj.getAula());
        
        return marcacao;
    };

    public MarcacaoDTO toDTO(Marcacao obj){
        MarcacaoDTO marcacaoDTO = new MarcacaoDTO();
        marcacaoDTO.setId(obj.getId());
        marcacaoDTO.setNome(obj.getNome());
        marcacaoDTO.setDescricao(obj.getDescricao());
        marcacaoDTO.setDataMarcacao(obj.getDataMarcacao());
        marcacaoDTO.setAluno(obj.getAluno());
        marcacaoDTO.setAula(obj.getAula());

        return marcacaoDTO;
    };

    public List<Marcacao> toEntity(List<MarcacaoDTO> list) {
        List<Marcacao> lista = new ArrayList<>();
        for (MarcacaoDTO mar : list) {
            lista.add(toEntity(mar));
        }
        return lista;
    }

    public List<MarcacaoDTO> toDTO(List<Marcacao> list){
        List<MarcacaoDTO> lista = new ArrayList<>();
        for(Marcacao mar : list) {
            lista.add(toDTO(mar));
        }
        return lista;
    }
}
