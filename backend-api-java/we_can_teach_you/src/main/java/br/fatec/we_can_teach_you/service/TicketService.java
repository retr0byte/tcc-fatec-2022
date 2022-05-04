package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.TicketDTO;
import br.fatec.we_can_teach_you.mapper.TicketMapper;
import br.fatec.we_can_teach_you.model.Ticket;
import br.fatec.we_can_teach_you.repository.TicketRepository;

@Service
public class TicketService implements ServiceInterface<TicketDTO> {
    
    @Autowired
    private TicketRepository repository;

    @Autowired
    private TicketMapper mapper;

    @Override
    public TicketDTO create(TicketDTO obj) {
        Ticket t = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(t);
    }

    @Override
    public TicketDTO findById(Long id) {
        Optional<Ticket> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<TicketDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(TicketDTO obj) {
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
