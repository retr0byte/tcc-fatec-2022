package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.FuncionarioDTO;
import br.fatec.we_can_teach_you.exception.AuthorizationException;
import br.fatec.we_can_teach_you.mapper.FuncionarioMapper;
import br.fatec.we_can_teach_you.model.Funcionario;
import br.fatec.we_can_teach_you.repository.FuncionarioRepository;
import br.fatec.we_can_teach_you.security.JWTUtil;

@Service
public class FuncionarioService implements ServiceInterface<FuncionarioDTO> {
    
    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public FuncionarioDTO create(FuncionarioDTO obj) {
        obj.setSenha(passwordEncoder.encode(obj.getSenha()));
        Funcionario fu = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(fu);
    }

    @Override
    public FuncionarioDTO findById(Long id) throws AuthorizationException {
		if (!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
        Optional<Funcionario> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<FuncionarioDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(FuncionarioDTO obj) {
        obj.setSenha(passwordEncoder.encode(obj.getSenha()));
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
