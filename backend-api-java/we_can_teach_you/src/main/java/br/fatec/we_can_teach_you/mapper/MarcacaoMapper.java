package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import br.fatec.we_can_teach_you.dto.MarcacaoDTO;
import br.fatec.we_can_teach_you.model.Marcacao;

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
        for (MarcacaoDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<MarcacaoDTO> toDTO(List<Marcacao> list){
        List<MarcacaoDTO> lista = new ArrayList<>();
        for(Marcacao a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }
}
