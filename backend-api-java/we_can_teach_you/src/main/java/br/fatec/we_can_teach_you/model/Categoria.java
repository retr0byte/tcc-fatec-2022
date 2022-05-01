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
@Table(name="Categorias")
public class Categoria extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Categoria")
    private String nome;
    
    @Column(name="ds_Categoria")
    private String descricao;

}
