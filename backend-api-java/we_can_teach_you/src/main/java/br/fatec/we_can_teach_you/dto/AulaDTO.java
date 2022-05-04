package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;

import br.fatec.we_can_teach_you.model.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AulaDTO {
    
    private Long id;

    private String linkReuniao;

    private Calendar dataAula;

    private Calendar duracaoAula;

    private Float valorAula;

    private Categoria categoria;
}
