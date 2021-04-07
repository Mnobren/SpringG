package com.atividades.atividadeprojeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atividades.atividadeprojeto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>
{

	@Query
	(
		value = "SELECT * FROM produto WHERE produto.valor < :param",
		nativeQuery = true
	)
	List<Produto> findAllByValorLess(@Param("param") String nome);

	@Query
	(
		value = "SELECT * FROM produto WHERE produto.valor >= :param",
		nativeQuery = true
	)
	List<Produto> findAllByValorGreat(@Param("param") String nome);
	
	@Query
	(
		value = "SELECT * FROM produto WHERE produto.titulo_produto LIKE %:nome%",
		nativeQuery = true
	)
	List<Produto> findAllByNomeContainingString(@Param("nome") String nome);
}