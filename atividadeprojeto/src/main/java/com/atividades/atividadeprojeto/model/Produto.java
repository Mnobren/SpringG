package com.atividades.atividadeprojeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "produto")
public class Produto
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idProduto;
	
	@NotNull
	private String tituloProduto;
	
	@NotNull
	private float valor;
	
	@NotNull
	@Size (min = 0, max = 200)
	private String urlImagem;
	
	@ManyToOne
	@JsonIgnoreProperties("fk_idProduto")
	private Usuario fk_idUsuario;
	
	@ManyToOne
	@JsonIgnoreProperties("fk_idProduto")
	private Loja fk_idLoja;
	
	public long getIdProduto() {
		return idProduto;
	}

	public String getTituloProduto() {
		return tituloProduto;
	}

	public void setTituloProduto(String tituloProduto) {
		this.tituloProduto = tituloProduto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Usuario getFk_idUsuario() {
		return fk_idUsuario;
	}

	public void setFk_idUsuario(Usuario fk_idUsuario) {
		this.fk_idUsuario = fk_idUsuario;
	}

	public Loja getFk_idLoja() {
		return fk_idLoja;
	}

	public void setFk_idLoja(Loja fk_idLoja) {
		this.fk_idLoja = fk_idLoja;
	}
}