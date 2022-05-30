package br.fatec.we_can_teach_you.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.we_can_teach_you.dto.MarcacaoDTO;
import br.fatec.we_can_teach_you.exception.AuthorizationException;
import br.fatec.we_can_teach_you.service.MarcacaoService;

@RestController
@RequestMapping("/marcacoes")
public class MarcacaoController implements ControllerInterface<MarcacaoDTO>{
    
    @Autowired
    private MarcacaoService service;

    @Override
	@GetMapping
	public ResponseEntity<List<MarcacaoDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        MarcacaoDTO obj = service.findById(id);
        if (obj != null){
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/aula/{aulaId}/aluno/{alunoId}")
    public ResponseEntity<List<MarcacaoDTO>> getByAlunoAndAula(@PathVariable Long aulaId, @PathVariable Long alunoId) {
		try {
            return ResponseEntity.ok(service.findByAlunoAndAula(aulaId, alunoId));
        } catch (AuthorizationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
	}

    @Override
    @PostMapping
    public ResponseEntity<MarcacaoDTO> post(@RequestBody MarcacaoDTO obj) throws URISyntaxException {
        MarcacaoDTO dto = service.create(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody MarcacaoDTO obj) {
        if (service.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/{id}/aluno/{alunoId}")
    public ResponseEntity<?> deleteFromStudent(@PathVariable("id") Long id, @PathVariable("alunoId") Long alunoId) {
        try {
            if (service.deleteFromStudent(id, alunoId)) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (AuthorizationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
