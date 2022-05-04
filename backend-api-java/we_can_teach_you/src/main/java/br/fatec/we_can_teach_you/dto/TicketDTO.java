package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;

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

    private Calendar aberturaTicket;

    private Calendar fechamentoTicket;
}
