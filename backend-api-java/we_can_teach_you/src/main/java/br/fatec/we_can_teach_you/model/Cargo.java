package br.fatec.we_can_teach_you.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Cargo {
    TR("TRAINEE"),
    JR("JUNIOR"),
    PL("PLENO"),
    SR("SENIOR"),
    MT("MASTER");

    private String cargoCompleto;

    public String getCargoCompleto() {
        return this.cargoCompleto;
    }
}
