package br.fatec.we_can_teach_you.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Getter(onMethod = @__(@JsonIgnore))
    @Setter(onMethod = @__(@JsonProperty))
    @OneToMany()
    private List<Faq> perguntasFrequentes;
}
