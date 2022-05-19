package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.AlunoDTO;
import br.fatec.we_can_teach_you.exception.AuthorizationException;
import br.fatec.we_can_teach_you.mapper.AlunoMapper;
import br.fatec.we_can_teach_you.model.Aluno;
import br.fatec.we_can_teach_you.repository.AlunoRepository;
import br.fatec.we_can_teach_you.security.JWTUtil;

@Service
public class AlunoService implements ServiceInterface<AlunoDTO> {
    
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
	private JWTUtil jwtUtil;

    @Override
    public AlunoDTO create(AlunoDTO obj) {
        obj.setSenha(passwordEncoder.encode(obj.getSenha()));
        Aluno a = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(a);
    }

    @Override
    public AlunoDTO findById(Long id) throws AuthorizationException {
		if (!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
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
