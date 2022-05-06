package br.fatec.we_can_teach_you.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name="dt_MomentoMarcacao")
    private Calendar momentoMarcacao;

    @ManyToOne()
    private Aluno aluno;

    @ManyToOne()
    private Aula aula;
    
}
