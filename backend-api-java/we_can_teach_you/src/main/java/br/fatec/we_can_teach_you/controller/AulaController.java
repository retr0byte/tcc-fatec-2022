package br.fatec.we_can_teach_you.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.we_can_teach_you.dto.AulaDTO;
import br.fatec.we_can_teach_you.exception.AuthorizationException;
import br.fatec.we_can_teach_you.service.AulaService;

@RestController
@RequestMapping("/aulas")
public class AulaController implements ControllerInterface<AulaDTO>{
    
    @Autowired
    private AulaService service;

    @Override
	@GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<List<AulaDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        AulaDTO obj = service.findById(id);
        if (obj != null){
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @GetMapping("/aluno/{alunoId}")
    @PreAuthorize("hasAnyRole('[ ADMIN, ALUNO ]')")
	public ResponseEntity<List<AulaDTO>> getAulasByAluno(@PathVariable("alunoId") Long alunoId) {
		try {
            return ResponseEntity.ok(service.findAulasByAluno(alunoId));
        } catch (AuthorizationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
    
    @GetMapping("{aulaId}/aluno/{alunoId}")
    @PreAuthorize("hasAnyRole('[ ADMIN, ALUNO ]')")
	public ResponseEntity<AulaDTO> getAulaByAluno(@PathVariable("aulaId") Long aulaId, @PathVariable("alunoId") Long alunoId) {
		try {
            return ResponseEntity.ok(service.findAulaByAluno(alunoId, aulaId));
        } catch (AuthorizationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('[ ADMIN, PROFESSOR ]')")
    public ResponseEntity<AulaDTO> post(@RequestBody AulaDTO obj) throws URISyntaxException {
        AulaDTO dto = service.create(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> put(@RequestBody AulaDTO obj) {
        if (service.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
