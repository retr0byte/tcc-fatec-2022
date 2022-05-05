package br.fatec.we_can_teach_you.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.dto.MarcacaoDTO;
import br.fatec.we_can_teach_you.mapper.MarcacaoMapper;
import br.fatec.we_can_teach_you.model.Marcacao;
import br.fatec.we_can_teach_you.repository.MarcacaoRepository;

@Service
public class MarcacaoService  implements ServiceInterface<MarcacaoDTO>{
    @Autowired
    private MarcacaoRepository repository;

    @Autowired
    private MarcacaoMapper mapper;

    @Override
    public MarcacaoDTO create(MarcacaoDTO obj) {
        Marcacao at = repository.save(mapper.toEntity(obj));
        return mapper.toDTO(at);
    }

    @Override
    public MarcacaoDTO findById(Long id) {
        Optional<Marcacao> obj = repository.findById(id);
        if(obj.isPresent()) {
            return mapper.toDTO(obj.get());
        }
        return null;
    }

    @Override
    public List<MarcacaoDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public boolean update(MarcacaoDTO obj) {
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
