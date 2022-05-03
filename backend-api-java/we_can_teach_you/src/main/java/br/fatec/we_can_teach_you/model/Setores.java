package br.fatec.we_can_teach_you.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Setores {
    ADM("ADMINISTRATIVO"),
    RH("RECURSOS HUMANOS"),
    FIN("FINANCEIRO"),
    COM("COMERCIAL"),
    OP("OPERACIONAL"),
    TI("TECNOLOGIA DA INFORMAÇÃO");

    private String setorCompleto;

    public String getSetorCompleto() {
        return this.setorCompleto;
    }
}
