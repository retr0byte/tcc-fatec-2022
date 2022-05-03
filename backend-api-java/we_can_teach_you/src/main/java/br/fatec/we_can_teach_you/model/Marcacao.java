package br.fatec.we_can_teach_you.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Marcacoes")
public class Marcacao extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Marcacao")
    private String nome;

    @Column(name="ds_Marcacao")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar dataMarcacao;

	@Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;

    @Getter(onMethod = @__(@JsonIgnore))
    @Setter(onMethod = @__(@JsonProperty))
    @ManyToOne(fetch = FetchType.LAZY)
    private Aula aula;
    
}
