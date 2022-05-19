package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.FuncionarioDTO;
import br.fatec.we_can_teach_you.model.Funcionario;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class FuncionarioMapper {
    
    public Funcionario toEntity(FuncionarioDTO obj) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(obj.getId());
        funcionario.setNome(obj.getNome());
        funcionario.setEmail(obj.getEmail());
        funcionario.setSenha(obj.getSenha());
        funcionario.setPerfis(obj.getPerfis());
        funcionario.setSexo(obj.getSexo());
        funcionario.setDataNascimento(obj.getDataNascimento());
        funcionario.setNumeroCelular(obj.getNumeroCelular());
        funcionario.setCpf(obj.getCpf());
        funcionario.setCargo(obj.getCargo());
        funcionario.setSetor(obj.getSetor());
        return funcionario;
    }

    public FuncionarioDTO toDTO(Funcionario obj) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(obj.getId());
        funcionarioDTO.setNome(obj.getNome());
        funcionarioDTO.setEmail(obj.getEmail());
        funcionarioDTO.setSenha(obj.getSenha());
        funcionarioDTO.setPerfis(obj.getPerfisAsInteger());
        funcionarioDTO.setSexo(obj.getSexo());
        funcionarioDTO.setDataNascimento(obj.getDataNascimento());
        funcionarioDTO.setNumeroCelular(obj.getNumeroCelular());
        funcionarioDTO.setCpf(obj.getCpf());
        funcionarioDTO.setCargo(obj.getCargo());
        funcionarioDTO.setSetor(obj.getSetor());
        return funcionarioDTO;
    }

    public List<Funcionario> toEntity(List<FuncionarioDTO> list) {
        List<Funcionario> lista = new ArrayList<>();
        for (FuncionarioDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<FuncionarioDTO> toDTO(List<Funcionario> list){
        List<FuncionarioDTO> lista = new ArrayList<>();
        for(Funcionario a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }
}
