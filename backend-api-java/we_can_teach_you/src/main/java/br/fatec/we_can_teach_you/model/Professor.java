package br.fatec.we_can_teach_you.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Professores")
public class Professor extends Usuario {
    private static final long serialVersionUID = 1L;

    @Column(name="ds_Certificado")
    private String certificado;
    
    /// se liberado: OK pode dar aulas.
    /// se não liberado: terá que fazer o teste (formulário)
    @Column(name="ic_Liberado")
    private Boolean liberado;

    @Column(name="ds_NivelEscolaridade")
    private String nivelEscolaridade;

    @ManyToMany
    @JoinTable(name = "ProfessoresCategorias",
        joinColumns=@JoinColumn(name="cd_Professor"),
        inverseJoinColumns=@JoinColumn(name="cd_Categoria") )
    private List<Categoria> categorias;

}
