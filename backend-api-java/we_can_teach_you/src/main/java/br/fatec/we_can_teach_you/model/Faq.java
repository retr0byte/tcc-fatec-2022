package br.fatec.we_can_teach_you.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
