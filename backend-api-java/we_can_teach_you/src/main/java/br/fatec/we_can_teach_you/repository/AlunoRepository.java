package br.fatec.we_can_teach_you.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.we_can_teach_you.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
