package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.AulaDTO;
import br.fatec.we_can_teach_you.mapper.AulaMapper;
import br.fatec.we_can_teach_you.model.Aula;
import br.fatec.we_can_teach_you.repository.AulaRepository;

@Service
public class AulaService implements ServiceInterface<AulaDTO>{
    
    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaMapper mapper;

    @Override
    public AulaDTO create(AulaDTO obj) {
        Aula au = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(au);
    }

    @Override
    public AulaDTO findById(Long id) {
        Optional<Aula> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<AulaDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(AulaDTO obj) {
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
