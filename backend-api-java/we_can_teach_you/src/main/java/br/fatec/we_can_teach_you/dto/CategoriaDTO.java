package br.fatec.we_can_teach_you.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;

    private String nome;
    
    private String descricao;
}
