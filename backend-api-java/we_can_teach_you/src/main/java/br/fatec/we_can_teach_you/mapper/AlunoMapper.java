package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.AlunoDTO;
import br.fatec.we_can_teach_you.model.Aluno;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class AlunoMapper {
    
    public Aluno toEntity(AlunoDTO obj) {
        Aluno aluno = new Aluno();
        aluno.setId(obj.getId());
        aluno.setNome(obj.getNome());
        aluno.setEmail(obj.getEmail());
        aluno.setSenha(obj.getSenha());
        aluno.setPerfis(obj.getPerfis());
        aluno.setSexo(obj.getSexo());
        aluno.setDataNascimento(obj.getDataNascimento());
        aluno.setNumeroCelular(obj.getNumeroCelular());
        aluno.setCpf(obj.getCpf());
        aluno.setNivelEscolaridade(obj.getNivelEscolaridade());
        aluno.setCategorias(obj.getCategorias());
        return aluno;
    }
    
    public AlunoDTO toDTO(Aluno obj) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(obj.getId());
        alunoDTO.setNome(obj.getNome());
        alunoDTO.setEmail(obj.getEmail());
        alunoDTO.setSenha(obj.getSenha());
        alunoDTO.setPerfis(obj.getPerfisAsInteger());
        alunoDTO.setSexo(obj.getSexo());
        alunoDTO.setDataNascimento(obj.getDataNascimento());
        alunoDTO.setNumeroCelular(obj.getNumeroCelular());
        alunoDTO.setCpf(obj.getCpf());
        alunoDTO.setNivelEscolaridade(obj.getNivelEscolaridade());
        alunoDTO.setCategorias(obj.getCategorias());
        return alunoDTO;
    }

    public List<Aluno> toEntity(List<AlunoDTO> list) {
        List<Aluno> lista = new ArrayList<>();
        for (AlunoDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<AlunoDTO> toDTO(List<Aluno> list){
        List<AlunoDTO> lista = new ArrayList<>();
        for(Aluno a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }

}
