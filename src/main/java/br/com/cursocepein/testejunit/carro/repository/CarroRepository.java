package br.com.cursocepein.testejunit.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursocepein.testejunit.carro.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
