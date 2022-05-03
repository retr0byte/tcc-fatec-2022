package br.fatec.we_can_teach_you.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Sexo {
    F("FEMININO"),
    M("MASCULINO"),
    OT("OUTROS");

    private String sexoCompleto;

    public String getSexoCompleto() {
        return this.sexoCompleto;
    }
}
