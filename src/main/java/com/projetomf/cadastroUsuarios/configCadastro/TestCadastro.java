package com.projetomf.cadastroUsuarios.configCadastro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetomf.cadastroUsuarios.entities.Usuario;
import com.projetomf.cadastroUsuarios.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestCadastro implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuarioUm = new Usuario(null, "Arthur Dent", "arthurdent@email.com", "123456");
		Usuario usuarioDois = new Usuario(null, "Tricia Mcmillian", "triciamcmillian@email.com", "654321");
		
		repository.saveAll(Arrays.asList(usuarioUm, usuarioDois));
	}

}
