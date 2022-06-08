package br.fatec.we_can_teach_you.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.we_can_teach_you.security.JWTUtil;
import br.fatec.we_can_teach_you.security.UserDetailsImpl;
import br.fatec.we_can_teach_you.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
	private JWTUtil jwtUtil;

	@PostMapping(value = "/refresh_token")
	public ResponseEntity<String> refreshToken(HttpServletResponse response) {
		UserDetailsImpl user = UsuarioService.authenticated();
		if (user != null) {
			String token = jwtUtil.generateToken(user.getUsername());
			response.addHeader("Authorization", "Bearer " + token);

            String responseBody = "{\"newToken\": \" " + token + "\"}";
			return ResponseEntity.ok(responseBody);
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}
