package com.lojajogos.atividadeloja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojajogos.atividadeloja.model.Categoria;
import com.lojajogos.atividadeloja.model.Desenvolvedor;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long>
{
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
}
