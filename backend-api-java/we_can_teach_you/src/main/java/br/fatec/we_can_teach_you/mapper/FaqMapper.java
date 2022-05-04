package br.fatec.we_can_teach_you.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.fatec.we_can_teach_you.dto.FaqDTO;
import br.fatec.we_can_teach_you.model.Faq;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class FaqMapper {
    
    public Faq toEntity(FaqDTO obj) {
        Faq faq = new Faq();
        faq.setId(obj.getId());
        faq.setTituloPergunta(obj.getTituloPergunta());
        faq.setRespostaPergunta(obj.getRespostaPergunta());
        faq.setFuncionario(obj.getFuncionario());
        return faq;
    }

    public FaqDTO toDTO(Faq obj) {
        FaqDTO faqDTO = new FaqDTO();
        faqDTO.setId(obj.getId());
        faqDTO.setTituloPergunta(obj.getTituloPergunta());
        faqDTO.setRespostaPergunta(obj.getRespostaPergunta());
        faqDTO.setFuncionario(obj.getFuncionario());
        return faqDTO;
    }

    public List<Faq> toEntity(List<FaqDTO> list) {
        List<Faq> lista = new ArrayList<>();
        for (FaqDTO a : list) {
            lista.add(toEntity(a));
        }
        return lista;
    }

    public List<FaqDTO> toDTO(List<Faq> list){
        List<FaqDTO> lista = new ArrayList<>();
        for(Faq a : list) {
            lista.add(toDTO(a));
        }
        return lista;
    }
}
