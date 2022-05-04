package br.fatec.we_can_teach_you.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GrauInstrucao {
    ZERO("Ignorado"),
    UM("Analfabeto"),
    DOIS("Até 5º Ano Incompleto"),
    TRES("5º Ano Completo"),
    QUATRO("6º ao 9º Ano do Fundamental"),
    CINCO("Fundamental Completo"),
    SEIS("Médio Incompleto"),
    SETE("Médio Completo"),
    OITO("Superior Incompleto"),
    NOVE("Superior Completo"),
    DEZ("Mestrado"),
    ONZE("Doutorado");
    
    private String nivelEscolaridade;

    public String getNivelEscolaridade() {
        return this.nivelEscolaridade;
    }
}
