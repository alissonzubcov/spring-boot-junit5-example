package br.com.cursocepein.testejunit.carro.form;

import br.com.cursocepein.testejunit.carro.model.Carro;

public class CarroFORM {

    private String proprietario;
    private String marca;
    private String modelo;
    private String cor;
    private Double valorDeMercado;
    private Boolean isRoubado;

    public Carro converterToCarro(Carro carro) {
        carro.setProprietario(proprietario);
        carro.setMarca(marca);
        carro.setMarca(marca);
        carro.setCor(cor);
        carro.setValorDeMercado(valorDeMercado);
        carro.setIsRoubado(isRoubado);
        return carro;
    }

    public CarroFORM(String proprietario, String marca, String modelo, String cor, Double valorDeMercado,
                     Boolean isRoubado) {
        super();
        this.proprietario = proprietario;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.valorDeMercado = valorDeMercado;
        this.isRoubado = isRoubado;
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
