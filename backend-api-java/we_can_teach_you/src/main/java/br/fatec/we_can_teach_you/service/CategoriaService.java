package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.CategoriaDTO;
import br.fatec.we_can_teach_you.mapper.CategoriaMapper;
import br.fatec.we_can_teach_you.model.Categoria;
import br.fatec.we_can_teach_you.repository.CategoriaRepository;

@Service
public class CategoriaService implements ServiceInterface<CategoriaDTO>{
    
    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaMapper mapper;

    @Override
    public CategoriaDTO create(CategoriaDTO obj) {
        Categoria cat = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(cat);
    }

    @Override
    public CategoriaDTO findById(Long id) {
        Optional<Categoria> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<CategoriaDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(CategoriaDTO obj) {
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
