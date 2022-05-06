package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.fatec.we_can_teach_you.model.Aluno;
import br.fatec.we_can_teach_you.model.Funcionario;
import br.fatec.we_can_teach_you.model.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketDTO {
    
    private Long id;

    private String titulo;

    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar aberturaTicket;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar fechamentoTicket;

    private String respostaTicket;

    private List<Funcionario> funcionarios;

    private Professor professor;

    private Aluno aluno;
}
