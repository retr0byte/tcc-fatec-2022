package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.EventoDTO;
import br.fatec.we_can_teach_you.model.Evento;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class EventoMapper {
    public Evento toEntity(EventoDTO obj){
        Evento evento = new Evento();
        evento.setId(obj.getId());
        evento.setTitulo(obj.getTitulo());
        evento.setDescricao(obj.getDescricao());
        evento.setInicioEvento(obj.getInicioEvento());
        evento.setFimEvento(obj.getFimEvento());
        evento.setAtividade(obj.getAtividade());
        evento.setAluno(obj.getAluno());
        evento.setAula(obj.getAula());

        return evento;
    };

    public EventoDTO toDTO(Evento obj){
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(obj.getId());
        eventoDTO.setTitulo(obj.getTitulo());
        eventoDTO.setDescricao(obj.getDescricao());
        eventoDTO.setInicioEvento(obj.getInicioEvento());
        eventoDTO.setFimEvento(obj.getFimEvento());
        eventoDTO.setAtividade(obj.getAtividade());
        eventoDTO.setAluno(obj.getAluno());
        eventoDTO.setAula(obj.getAula());

        return eventoDTO;
    };

    public List<Evento> toEntity(List<EventoDTO> list) {
        List<Evento> lista = new ArrayList<>();
        for (EventoDTO ev : list) {
            lista.add(toEntity(ev));
        }
        return lista;
    }

    public List<EventoDTO> toDTO(List<Evento> list){
        List<EventoDTO> lista = new ArrayList<>();
        for(Evento ev : list) {
            lista.add(toDTO(ev));
        }
        return lista;
    }
}
