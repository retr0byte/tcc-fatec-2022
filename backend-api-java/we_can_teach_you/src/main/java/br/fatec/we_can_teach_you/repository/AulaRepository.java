package br.fatec.we_can_teach_you.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fatec.we_can_teach_you.model.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    
    @Query("SELECT a FROM Aula a JOIN FETCH a.alunos aluno WHERE aluno.id = ?1")
    List<Aula> findAulasByAluno(Long alunoId);
    
    @Query("SELECT a FROM Aula a JOIN FETCH a.alunos aluno WHERE aluno.id = ?1 AND a.id = ?2")
    Aula findAulaByAluno(Long alunoId, Long aulaId);

}
