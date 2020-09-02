package br.com.cursocepein.testejunit.carro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String proprietario;
	private String marca;
	private String modelo;
	private String cor;
	@Column(name = "valor_mercado")
	private Double valorDeMercado;
	@Column(name = "roubado")
	private Boolean isRoubado;
	
	public Carro() {}

	public Carro(String proprietario, String marca, String modelo, String cor, Double valorDeMercado,
			Boolean isRoubado) {
		super();
		this.proprietario = proprietario;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.valorDeMercado = valorDeMercado;
		this.isRoubado = isRoubado;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Double getValorDeMercado() {
		return valorDeMercado;
	}
	public void setValorDeMercado(Double valorDeMercado) {
		this.valorDeMercado = valorDeMercado;
	}
	public Boolean getIsRoubado() {
		return isRoubado;
	}
	public void setIsRoubado(Boolean isRoubado) {
		this.isRoubado = isRoubado;
	}

}
