package com.projetomf.cadastroUsuarios.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetomf.cadastroUsuarios.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	//Criando findAll sem a lógica correta
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> list = new ArrayList<>();
		return ResponseEntity.ok().body(list);
	}
	
	//Criando findById sem a lógica correta
	public ResponseEntity<Usuario> findById(Long id){
		Usuario user = new Usuario();
		return ResponseEntity.ok().body(user);
	}
	
	//Criando insert sem a lógica correta
	public ResponseEntity<Usuario> insert(){
		Usuario user = new Usuario();
		return ResponseEntity.ok().body(user);
	}
	
	//Criando delete sem a lógica correta
	public ResponseEntity<Void> delete(Long id){
		return ResponseEntity.noContent().build();
	}
	
	//Criando update sem a lógica correta
	public ResponseEntity<Usuario> update(Long id, Usuario user){
		return ResponseEntity.ok().body(user);
	}
}
