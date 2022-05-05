package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.EventoDTO;
import br.fatec.we_can_teach_you.mapper.EventoMapper;
import br.fatec.we_can_teach_you.model.Evento;
import br.fatec.we_can_teach_you.repository.EventoRepository;

@Service
public class EventoService implements ServiceInterface<EventoDTO>{
    
    @Autowired
    private EventoRepository repository;

    @Autowired
    private EventoMapper mapper;

    @Override
    public EventoDTO create(EventoDTO obj) {
        Evento ev = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(ev);
    }

    @Override
    public EventoDTO findById(Long id) {
        Optional<Evento> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<EventoDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(EventoDTO obj) {
        if (repository.existsById(obj.getId())) {
            repository.save(mapper.toEntity(obj));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
