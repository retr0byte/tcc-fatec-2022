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
@Table(name="Alunos")
public class Aluno extends Usuario {
    private static final long serialVersionUID = 1L;
    
}
