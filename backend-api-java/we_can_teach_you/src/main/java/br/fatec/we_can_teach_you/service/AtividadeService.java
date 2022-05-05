package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.AtividadeDTO;
import br.fatec.we_can_teach_you.mapper.AtividadeMapper;
import br.fatec.we_can_teach_you.model.Atividade;
import br.fatec.we_can_teach_you.repository.AtividadeRepository;

@Service
public class AtividadeService implements ServiceInterface<AtividadeDTO>{

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private AtividadeMapper mapper;

    @Override
    public AtividadeDTO create(AtividadeDTO obj) {
        Atividade at = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(at);
    }

    @Override
    public AtividadeDTO findById(Long id) {
        Optional<Atividade> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<AtividadeDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(AtividadeDTO obj) {
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
};


