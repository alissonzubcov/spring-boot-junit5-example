package br.com.cursocepein.testejunit.carro.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cursocepein.testejunit.carro.dto.CarroDTO;
import br.com.cursocepein.testejunit.carro.form.CarroFORM;
import br.com.cursocepein.testejunit.carro.service.CarroService;

@RequestMapping("/carro")
@RestController
public class CarroResource {
	
	@Autowired
	private CarroService carroService;
	
	
	@GetMapping
	public ResponseEntity<List<CarroDTO>> buscarTodosCarros(){
		return ResponseEntity.ok(carroService.buscarTodosCarros());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarroDTO> buscarCarroPorId(@PathVariable Long id){
		CarroDTO carro = carroService.buscarCarroPorId(id);
		return carro !=null ? ResponseEntity.ok(carro): ResponseEntity.notFound().build();
	}
	
	@PostMapping()
	public ResponseEntity<CarroDTO> cadastrarCarro(@RequestBody CarroFORM carroFORM, UriComponentsBuilder uriBuilder){
		CarroDTO carro = carroService.cadastrarCarro(carroFORM);
		URI uri = uriBuilder.path("/carro/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(carro);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CarroDTO> atualizarProduto(@PathVariable Long id, @RequestBody CarroFORM carroFORM ){
		CarroDTO carro = carroService.atualizarCarro(id, carroFORM);
		return carro != null ? ResponseEntity.ok(carro): ResponseEntity.notFound().build();
	}
	
	

}
