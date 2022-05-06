package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.fatec.we_can_teach_you.model.Aluno;
import br.fatec.we_can_teach_you.model.Categoria;
import br.fatec.we_can_teach_you.model.Professor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AulaDTO {
    
    private Long id;

    private String linkReuniao;

    private String nome;

    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar dataAula;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Calendar duracaoAula;

    private Float valorAula;

    private Categoria categoria;
    
    private List<Aluno> alunos;

    private Professor professor;
}
