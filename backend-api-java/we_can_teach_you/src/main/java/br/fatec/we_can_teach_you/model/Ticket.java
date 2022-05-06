package br.fatec.we_can_teach_you.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="Tickets")
public class Ticket extends AbstractEntity{
    private static final long serialVersionUID = 1L;

    @Column(name="nm_Ticket")
    private String titulo;

    @Column(name="ds_Ticket")
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_AberturaTicket")
    private Calendar aberturaTicket; 

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dt_FechamentoTicket")
    private Calendar fechamentoTicket;
    
    @Column(name="ds_RespostaTicket")
    private String respostaTicket;

    @ManyToMany
    @JoinTable(name = "TicketsFuncionarios",
        joinColumns=@JoinColumn(name="cd_Ticket"),
        inverseJoinColumns=@JoinColumn(name="cd_Funcionario"))
    private List<Funcionario> funcionarios;

    @ManyToOne()
    private Professor professor;

    @ManyToOne()
    private Aluno aluno;
}
