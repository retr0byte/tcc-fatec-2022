package br.fatec.we_can_teach_you.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name="Usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Usuario", length=60)
    private String nome;
    
    @Column(name="ds_Email", length=60)
    private String email;

    @Column(name="ds_Senha", length=24)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name="ds_Sexo")
    private Sexo sexo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_Nascimento")
    private Calendar dataNascimento;

    @Column(name="cd_NumeroCelular")
    private String numeroCelular;

    @Column(name="cd_CPF", length=11)
    private String cpf;

}
