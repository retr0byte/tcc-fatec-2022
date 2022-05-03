package br.fatec.we_can_teach_you.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Faq")
public class Faq extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Pergunta")
    private String tituloPergunta;

    @Column(name="ds_RepostaPergunta")
    private String respostaPergunta;

    @Getter(onMethod = @__(@JsonIgnore))
    @Setter(onMethod = @__(@JsonProperty))
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;
}
