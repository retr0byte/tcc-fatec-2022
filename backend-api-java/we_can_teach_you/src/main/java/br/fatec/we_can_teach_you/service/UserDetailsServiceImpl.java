package br.fatec.we_can_teach_you.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.fatec.we_can_teach_you.model.Usuario;
import br.fatec.we_can_teach_you.repository.UsuarioRepository;
import br.fatec.we_can_teach_you.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository repository;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(usuario.getId(), usuario.getEmail(),
				usuario.getSenha(), usuario.getPerfis());
	}
}
