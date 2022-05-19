package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.ProfessorDTO;
import br.fatec.we_can_teach_you.exception.AuthorizationException;
import br.fatec.we_can_teach_you.mapper.ProfessorMapper;
import br.fatec.we_can_teach_you.model.Professor;
import br.fatec.we_can_teach_you.repository.ProfessorRepository;
import br.fatec.we_can_teach_you.security.JWTUtil;

@Service
public class ProfessorService implements ServiceInterface<ProfessorDTO> {
    
    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public ProfessorDTO create(ProfessorDTO obj) {
        obj.setSenha(passwordEncoder.encode(obj.getSenha()));
        Professor p = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(p);
    }

    @Override
    public ProfessorDTO findById(Long id) throws AuthorizationException {
		if (!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
        Optional<Professor> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<ProfessorDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(ProfessorDTO obj) {
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
