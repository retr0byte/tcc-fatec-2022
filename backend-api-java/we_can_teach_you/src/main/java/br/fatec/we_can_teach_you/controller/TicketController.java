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

import br.fatec.we_can_teach_you.dto.TicketDTO;
import br.fatec.we_can_teach_you.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController implements ControllerInterface<TicketDTO>{
    
    @Autowired
    private TicketService service;

    @Override
	@GetMapping
    @PreAuthorize("hasAnyRole('[ ADMIN, FUNCIONARIO ]')")
	public ResponseEntity<List<TicketDTO>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('[ ADMIN, FUNCIONARIO ]')")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        TicketDTO obj = service.findById(id);
        if (obj != null){
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAnyRole('[ ADMIN, ALUNO, PROFESSOR ]')")
    public ResponseEntity<TicketDTO> post(@RequestBody TicketDTO obj) throws URISyntaxException {
        TicketDTO dto = service.create(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAnyRole('[ ADMIN, FUNCIONARIO, ALUNO, PROFESSOR ]')")
    public ResponseEntity<?> put(@RequestBody TicketDTO obj) {
        if (service.update(obj)) {
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole(' ADMIN ')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
