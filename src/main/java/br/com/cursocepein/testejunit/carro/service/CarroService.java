package br.com.cursocepein.testejunit.carro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cursocepein.testejunit.carro.dto.CarroDTO;
import br.com.cursocepein.testejunit.carro.form.CarroFORM;
import br.com.cursocepein.testejunit.carro.model.Carro;
import br.com.cursocepein.testejunit.carro.repository.CarroRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroDTO> buscarTodosCarros() {
        return CarroDTO.convertToDTO(carroRepository.findAll());
    }

    public CarroDTO buscarCarroPorId(Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.isPresent() ? new CarroDTO(carro.get()) : null;
    }

    public CarroDTO cadastrarCarro(CarroFORM carroFORM) {
        Carro novoCarro = new Carro();
        return salvarCarro(carroFORM, novoCarro);
    }

    public CarroDTO atualizarCarro(Long id, CarroFORM carroFORM) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.isPresent() ? salvarCarro(carroFORM, carro.get()) : null;
    }

    public Double calcularValorImpostoSobrePropriedade(Double valor) {
        return valor == 1500 ? valor : valor < 1500 ? valor * .5 : valor * 1.5;
    }

    private CarroDTO salvarCarro(CarroFORM carroFORM, Carro carro) {
        Carro nCarro = carroFORM.converterToCarro(carro);
        carroRepository.save(nCarro);
        return new CarroDTO(nCarro);
    }
    
    public ResponseEntity<String> retorno(){
    	return ResponseEntity.ok("hahaha");
    }


}
