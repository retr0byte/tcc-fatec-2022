package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.TicketDTO;
import br.fatec.we_can_teach_you.model.Ticket;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class TicketMapper {
    
    public Ticket toEntity(TicketDTO obj) {
        Ticket ticket = new Ticket();
        ticket.setId(obj.getId());
        ticket.setTitulo(obj.getTitulo());
        ticket.setDescricao(obj.getDescricao());
        ticket.setAberturaTicket(obj.getAberturaTicket());
        ticket.setFechamentoTicket(obj.getFechamentoTicket());
        return ticket;
    }

    public TicketDTO toDTO(Ticket obj) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(obj.getId());
        ticketDTO.setTitulo(obj.getTitulo());
        ticketDTO.setDescricao(obj.getDescricao());
        ticketDTO.setAberturaTicket(obj.getAberturaTicket());
        ticketDTO.setFechamentoTicket(obj.getFechamentoTicket());
        return ticketDTO;
    }

    public List<Ticket> toEntity(List<TicketDTO> list) {
        List<Ticket> lista = new ArrayList<>();
        for (TicketDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<TicketDTO> toDTO(List<Ticket> list){
        List<TicketDTO> lista = new ArrayList<>();
        for(Ticket a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }
}
