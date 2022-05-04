package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.FaqDTO;
import br.fatec.we_can_teach_you.mapper.FaqMapper;
import br.fatec.we_can_teach_you.model.Faq;
import br.fatec.we_can_teach_you.repository.FaqRepository;

@Service
public class FaqService implements ServiceInterface<FaqDTO>{

    @Autowired
    private FaqRepository repository;

    @Autowired
    private FaqMapper mapper;

    @Override
    public FaqDTO create(FaqDTO obj) {
        Faq f = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(f);
    }

    @Override
    public FaqDTO findById(Long id) {
        Optional<Faq> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<FaqDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(FaqDTO obj) {
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
