package br.fatec.we_can_teach_you.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Eventos")
public class Evento extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Evento")
    private String titulo;

    @Column(name="ds_Evento")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_InicioEvento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar inicioEvento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_FimEvento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar fimEvento;
}
