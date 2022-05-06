package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.fatec.we_can_teach_you.model.Aluno;
import br.fatec.we_can_teach_you.model.Atividade;
import br.fatec.we_can_teach_you.model.Aula;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventoDTO {
    
    private Long id;
    
    private String titulo;
    
    private String descricao;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar inicioEvento;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar fimEvento;
    
    @Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
    private Atividade atividade;
    
    @Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
    private Aluno aluno;
    
    @Getter(onMethod = @__(@JsonIgnore))
    @Setter(onMethod = @__(@JsonProperty))
    private Aula aula;
}
