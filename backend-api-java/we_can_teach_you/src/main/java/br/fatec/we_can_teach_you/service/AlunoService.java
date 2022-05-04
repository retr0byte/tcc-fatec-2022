package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.AlunoDTO;
import br.fatec.we_can_teach_you.mapper.AlunoMapper;
import br.fatec.we_can_teach_you.model.Aluno;
import br.fatec.we_can_teach_you.repository.AlunoRepository;

@Service
public class AlunoService implements ServiceInterface<AlunoDTO> {
    
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoMapper mapper;

    @Override
    public AlunoDTO create(AlunoDTO obj) {
        Aluno a = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(a);
    }

    @Override
    public AlunoDTO findById(Long id) {
        Optional<Aluno> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<AlunoDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(AlunoDTO obj) {
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
