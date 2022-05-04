package br.fatec.we_can_teach_you.dto;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.fatec.we_can_teach_you.model.Categoria;
import br.fatec.we_can_teach_you.model.GrauInstrucao;
import br.fatec.we_can_teach_you.model.Sexo;
import br.fatec.we_can_teach_you.model.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorDTO {
    
    private Long id;

    @NotBlank
    @Length(min = 3, max = 60)
    private String nome;

    @Email
    private String email;

    @Getter(onMethod = @__(@JsonIgnore))
	@Setter(onMethod = @__(@JsonProperty))
    @Length(min = 6, max = 24)
    private String senha;

    @Length(min = 1, max = 2)
    private Sexo sexo;

    @Past
    private Calendar dataNascimento;

    private String numeroCelular;

    @CPF
    private String cpf;

    private List<Ticket> tickets;

    private String certificado;

    private Boolean liberado;

    private GrauInstrucao nivelEscolaridade;

    private List<Categoria> categorias;
}
