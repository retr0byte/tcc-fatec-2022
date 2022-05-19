package br.fatec.we_can_teach_you.dto;


import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.fatec.we_can_teach_you.model.Categoria;
import br.fatec.we_can_teach_you.model.GrauInstrucao;
import br.fatec.we_can_teach_you.model.Sexo;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AlunoDTO {
    
    private Long id;

    @NotBlank
    @Length(min = 3, max = 60)
    private String nome;

    @Email
    private String email;

    @Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
    private String senha;

    private Set<Integer> perfis;

    @Length(min = 1, max = 2)
    private Sexo sexo;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar dataNascimento;

    private String numeroCelular;

    @CPF
    private String cpf;

    @Length(min = 2, max = 6)
    private GrauInstrucao nivelEscolaridade;

    private List<Categoria> categorias;
}
