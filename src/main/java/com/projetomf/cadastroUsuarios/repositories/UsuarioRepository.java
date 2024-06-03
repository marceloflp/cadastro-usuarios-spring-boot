package com.projetomf.cadastroUsuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetomf.cadastroUsuarios.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
