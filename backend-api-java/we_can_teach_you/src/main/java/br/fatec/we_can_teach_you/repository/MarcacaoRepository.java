package br.fatec.we_can_teach_you.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fatec.we_can_teach_you.model.Marcacao;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long>{

    @Query("SELECT m FROM Marcacao m JOIN m.aluno al ON al.id = ?1 JOIN m.aula au ON au.id = ?2")
    List<Marcacao>findByAlunoAndAula(Long alunoId, Long aulaId);
    
}
