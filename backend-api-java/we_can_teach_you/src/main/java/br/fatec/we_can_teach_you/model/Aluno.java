package br.fatec.we_can_teach_you.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Alunos")
public class Aluno extends Usuario {
    private static final long serialVersionUID = 1L;

    @Column(name="ds_NivelEscolaridade")
    private String nivelEscolaridade;
    
    @ManyToMany
    @JoinTable(name = "AlunosCategorias",
        joinColumns=@JoinColumn(name="cd_Aluno"),
        inverseJoinColumns=@JoinColumn(name="cd_Categoria") )
    private List<Categoria> categorias;
}
