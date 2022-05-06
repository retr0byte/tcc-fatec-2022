package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.fatec.we_can_teach_you.model.Aluno;
import br.fatec.we_can_teach_you.model.Aula;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MarcacaoDTO {
    
    private Long id;
    
    private String nome;
    
    private String descricao;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Calendar momentoMarcacao;
    
    private Aluno aluno;
    
    private Aula aula;
}
