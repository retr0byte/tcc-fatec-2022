package br.fatec.we_can_teach_you.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.we_can_teach_you.model.Marcacao;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long>{
    
}
