package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;
import br.fatec.we_can_teach_you.model.Aula;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AtividadeDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Calendar dataEntrega;
    private Aula aula;
}
