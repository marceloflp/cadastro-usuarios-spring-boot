package com.projetomf.cadastroUsuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetomf.cadastroUsuarios.entities.Usuario;
import com.projetomf.cadastroUsuarios.repositories.UsuarioRepository;
import com.projetomf.cadastroUsuarios.services.exceptions.DataBaseException;
import com.projetomf.cadastroUsuarios.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario>findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj =repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());	
	}

}
