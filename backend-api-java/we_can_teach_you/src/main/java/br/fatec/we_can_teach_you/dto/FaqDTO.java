package br.fatec.we_can_teach_you.dto;

import br.fatec.we_can_teach_you.model.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FaqDTO {
    
    private Long id;    

    private String tituloPergunta;

    private String respostaPergunta;

    private Funcionario funcionario;
}
