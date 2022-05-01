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
@Table(name="Professores")
public class Professor extends Usuario {
    private static final long serialVersionUID = 1L;

    @Column(name="ds_Certificado")
    private String certificado;
    
    /// se liberado: OK pode dar aulas.
    /// se não liberado: terá que fazer o teste (formulário)
    @Column(name="ic_Liberado")
    private Boolean liberado;


}
