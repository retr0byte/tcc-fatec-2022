package br.fatec.we_can_teach_you.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.fatec.we_can_teach_you.dto.CredenciaisDTO;
import br.fatec.we_can_teach_you.model.Usuario;
import br.fatec.we_can_teach_you.repository.UsuarioRepository;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
	private JWTUtil jwtUtil;
    private UsuarioRepository usuRepo;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UsuarioRepository usuRepo) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuRepo = usuRepo;
    }

    @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			CredenciaisDTO creds = new ObjectMapper().readValue(request.getInputStream(), CredenciaisDTO.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

    @Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		String username = ((UserDetailsImpl) authResult.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		response.addHeader("Authentication", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
        Usuario usu = usuRepo.findByEmail(username);
        response.getWriter().append(jsonAuth(token, usu));
	}

    @Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws java.io.IOException, javax.servlet.ServletException {
		response.setStatus(401);
		response.setContentType("application/json");
		response.getWriter().append(jsonError());
	}

    private String jsonError() {
		return "{\"timestamp\": " + new Date().getTime() + ", " + "\"status\": 401, "
				+ "\"error\": \"Não autorizado\", " + "\"message\": \"Email ou senha inválidos\", "
				+ "\"path\": \"/login\"}";
	}
    
    private String jsonAuth(String token, Usuario usuario) {
		return "{\"token\": \"" + token + "\"" + ", " +
		       "\"userId\": \"" + usuario.getId() + "\", " +
		       "\"username\": \"" + usuario.getNome() + "\", " +
		       "\"profile\": " + usuario.getPerfis().stream()
		                                .map(x -> "\"" + x + "\"")
		                                .collect(Collectors.toList()) + "}";
	}
    
}
