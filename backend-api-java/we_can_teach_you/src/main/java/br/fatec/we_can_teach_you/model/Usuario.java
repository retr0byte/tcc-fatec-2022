package br.fatec.we_can_teach_you.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
    
    /// utilizado para logar
    @Column(name="ds_Email", length=60, unique=true)
    private String email;

    @Column(name="ds_Senha")
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Perfis")
    private Set<Integer> perfis = new HashSet<>();

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

    public Set<TipoPerfil> getPerfis() {
		return perfis.stream().map(x -> TipoPerfil.toEnum(x))
				.collect(Collectors.toSet());
	}

    public Set<Integer> getPerfisAsInteger() {
		return perfis;
	}

    public void addPerfil(TipoPerfil perfil) {
		this.perfis.add(perfil.getCod());
	}
}
