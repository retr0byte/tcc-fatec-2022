package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.ProfessorDTO;
import br.fatec.we_can_teach_you.model.Professor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class ProfessorMapper {
    
    public Professor toEntity(ProfessorDTO obj) {
        Professor professor = new Professor();
        professor.setId(obj.getId());
        professor.setNome(obj.getNome());
        professor.setEmail(obj.getEmail());
        professor.setSenha(obj.getSenha());
        professor.setSexo(obj.getSexo());
        professor.setDataNascimento(obj.getDataNascimento());
        professor.setNumeroCelular(obj.getNumeroCelular());
        professor.setCpf(obj.getCpf());
        professor.setCertificado(obj.getCertificado());
        professor.setLiberado(obj.getLiberado());
        professor.setNivelEscolaridade(obj.getNivelEscolaridade());
        professor.setCategorias(obj.getCategorias());
        return professor;
    }
    
    public ProfessorDTO toDTO(Professor obj) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(obj.getId());
        professorDTO.setNome(obj.getNome());
        professorDTO.setEmail(obj.getEmail());
        professorDTO.setSenha(obj.getSenha());
        professorDTO.setSexo(obj.getSexo());
        professorDTO.setDataNascimento(obj.getDataNascimento());
        professorDTO.setNumeroCelular(obj.getNumeroCelular());
        professorDTO.setCpf(obj.getCpf());
        professorDTO.setCertificado(obj.getCertificado());
        professorDTO.setLiberado(obj.getLiberado());
        professorDTO.setNivelEscolaridade(obj.getNivelEscolaridade());
        professorDTO.setCategorias(obj.getCategorias());
        return professorDTO;
    }

    public List<Professor> toEntity(List<ProfessorDTO> list) {
        List<Professor> lista = new ArrayList<>();
        for (ProfessorDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<ProfessorDTO> toDTO(List<Professor> list){
        List<ProfessorDTO> lista = new ArrayList<>();
        for(Professor a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }

}
