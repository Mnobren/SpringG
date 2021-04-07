package com.atividades.atividadeprojeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividades.atividadeprojeto.model.Produto;
import com.atividades.atividadeprojeto.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public List<Usuario> findAllByUsuarioContainingIgnoreCase (String usuario);
}