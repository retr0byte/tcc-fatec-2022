package br.fatec.we_can_teach_you.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name="Atividades")
public class Atividade extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Atividade")
    private String titulo;

    @Column(name="ds_Atividade")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_EntregaAtividade")
    private Calendar dataEntrega;

    @ManyToOne()
    private Aula aula;

}
