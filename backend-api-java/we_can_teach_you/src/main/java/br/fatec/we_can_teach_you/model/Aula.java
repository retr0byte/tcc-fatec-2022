package br.fatec.we_can_teach_you.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="Aulas")
public class Aula extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="ds_LinkReuniao")
    private String linkReuniao;

    @Column(name="nm_Aula")
    private String nome;

    @Column(name="ds_Aula")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_Aula")
    private Calendar dataAula;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="qt_DuracaoAula")
    private Calendar duracaoAula;

    @Column(name="vl_Aula")
    private Float valorAula;

    @ManyToOne()
    private Categoria categoria;

    @ManyToMany
    @JoinTable(name = "AulasAlunos",
        joinColumns=@JoinColumn(name="cd_Aula"),
        inverseJoinColumns=@JoinColumn(name="cd_Aluno") )
    private List<Aluno> alunos;

    @ManyToOne()
    private Professor professor;
}
