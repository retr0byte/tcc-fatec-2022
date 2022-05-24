package br.fatec.we_can_teach_you.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fatec.we_can_teach_you.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
    @Query("SELECT p FROM Professor p JOIN FETCH p.categorias categoria WHERE categoria.nome LIKE %?1%")
    List<Professor>findByCategory(String category);

}
