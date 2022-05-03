package br.fatec.we_can_teach_you.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Funcionarios")
public class Funcionario extends Usuario {
    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name="ds_Cargo")
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    @Column(name="ds_Setor")
    private Setor setor;

}
