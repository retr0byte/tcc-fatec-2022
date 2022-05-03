package br.fatec.we_can_teach_you.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Aulas")
public class Aula extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="ds_LinkReuniao")
    private String linkReuniao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_Aula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Calendar dataAula;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="qt_DuracaoAula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Calendar duracaoAula;

    @Column(name="vl_Aula")
    private Float valorAula;

    @Getter(onMethod = @__(@JsonIgnore))
    @Setter(onMethod = @__(@JsonProperty))
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
}
