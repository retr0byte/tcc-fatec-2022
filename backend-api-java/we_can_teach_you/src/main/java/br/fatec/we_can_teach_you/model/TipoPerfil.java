package br.fatec.we_can_teach_you.model;

import lombok.Getter;

@Getter
public enum TipoPerfil {
	ADMIN(1, "ROLE_ADMIN"),
    FUNCIONARIO(2, "ROLE_FUNCIONARIO"),
    ALUNO(3, "ROLE_ALUNO"),
    PROFESSOR(4, "ROLE_PROFESSOR");

	private Integer cod;
	private String descricao;

	private TipoPerfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static TipoPerfil toEnum(Integer cod) {
		if (cod == null)
			return null;
		for (TipoPerfil x : TipoPerfil.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
