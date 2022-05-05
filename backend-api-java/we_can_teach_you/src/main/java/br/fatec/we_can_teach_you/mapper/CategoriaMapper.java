package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.CategoriaDTO;
import br.fatec.we_can_teach_you.model.Categoria;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class CategoriaMapper {
    public Categoria toEntity(CategoriaDTO obj){
        Categoria categoria = new Categoria();
        categoria.setId(obj.getId());
        categoria.setNome(obj.getNome());
        categoria.setDescricao(obj.getDescricao());

        return categoria;
    };

    public CategoriaDTO toDTO(Categoria obj){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(obj.getId());
        categoriaDTO.setNome(obj.getNome());
        categoriaDTO.setDescricao(obj.getDescricao());

        return categoriaDTO;
    };

    public List<Categoria> toEntity(List<CategoriaDTO> list) {
        List<Categoria> lista = new ArrayList<>();
        for (CategoriaDTO cat : list) {
            lista.add(toEntity(cat));
        }
        return lista;
    }

    public List<CategoriaDTO> toDTO(List<Categoria> list){
        List<CategoriaDTO> lista = new ArrayList<>();
        for(Categoria cat : list) {
            lista.add(toDTO(cat));
        }
        return lista;
    }
}
