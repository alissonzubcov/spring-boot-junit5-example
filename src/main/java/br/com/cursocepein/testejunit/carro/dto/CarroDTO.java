package br.com.cursocepein.testejunit.carro.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cursocepein.testejunit.carro.model.Carro;

public class CarroDTO {

    private Long id;
    private String proprietario;
    private String marca;
    private String modelo;
    private String cor;
    private Double valorDeMercado;
    private Boolean isRoubado;

    public CarroDTO() { }

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.proprietario = carro.getProprietario();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.cor = carro.getCor();
        this.valorDeMercado = carro.getValorDeMercado();
        this.isRoubado = carro.getIsRoubado();
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

    public static List<CarroDTO> convertToDTO(List<Carro> listaCarro) {
        return listaCarro.stream().map(CarroDTO::new).collect(Collectors.toList());
    }

}
