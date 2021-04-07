package com.atividades.atividadeprojeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "loja")
public class Loja
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idLoja;
	
	@NotNull
	@Size (min = 0, max = 45)
	private String nome;
	
	@NotNull
	@Size (min = 0, max = 100)
	private String descricao;

	@OneToMany(mappedBy = "fk_idLoja", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fk_idLoja")
	private List<Produto> fk_idProduto;

	@ManyToMany
	@JoinTable
	(
		name = "LojaJoinUsuario",
		joinColumns = @JoinColumn(name = "loja"),
		inverseJoinColumns = @JoinColumn(name = "usuario")
	)
	//@JsonIgnoreProperties("fk_idLoja")
	private List<Usuario> fk_idUsuario;
	
	public long getIdLoja() {
		return idLoja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getFk_idProduto() {
		return fk_idProduto;
	}

	public void setFk_idProduto(List<Produto> fk_idProduto) {
		this.fk_idProduto = fk_idProduto;
	}

	public List<Usuario> getFk_idUsuario() {
		return fk_idUsuario;
	}

	public void setFk_idUsuario(List<Usuario> fk_idUsuario) {
		this.fk_idUsuario = fk_idUsuario;
	}
}