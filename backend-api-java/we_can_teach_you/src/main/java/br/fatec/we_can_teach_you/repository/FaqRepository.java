package br.fatec.we_can_teach_you.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fatec.we_can_teach_you.model.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long>{
    
    @Query("SELECT f FROM Faq f WHERE f.tituloPergunta LIKE %?1%")
    List<Faq> findByTituloPergunta(String tituloPergunta);

}
