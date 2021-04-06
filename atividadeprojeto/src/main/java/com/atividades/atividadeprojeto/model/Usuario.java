package com.atividades.atividadeprojeto.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "usuario")
public class Usuario
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotNull
	@Size (max = 45)
	private String nome;
	
	@NotNull
	@Size (max = 45)
	private String usuario;
	
	@NotNull
	@Size (max = 45)
	private String senha;

	@OneToMany(mappedBy = "fk_idUsuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fk_idUsuario")
	private List<Produto> fk_idProduto;
	
	@ManyToOne
	@JsonIgnoreProperties("fk_idUsuario")
	private Loja fk_idLoja;

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getFk_idProduto() {
		return fk_idProduto;
	}

	public void setFk_idProduto(List<Produto> fk_idProduto) {
		this.fk_idProduto = fk_idProduto;
	}

	public Loja getFk_idLoja() {
		return fk_idLoja;
	}

	public void setFk_idLoja(Loja fk_idLoja) {
		this.fk_idLoja = fk_idLoja;
	}
}