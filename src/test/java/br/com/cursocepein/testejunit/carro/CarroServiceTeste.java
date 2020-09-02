package br.com.cursocepein.testejunit.carro;


//import static org.junit.Assert.assertThat;;
//import static org.hamcrest.CoreMatchers.is;

import br.com.cursocepein.testejunit.carro.dto.CarroDTO;
import br.com.cursocepein.testejunit.carro.form.CarroFORM;
import br.com.cursocepein.testejunit.carro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest // full
//@RunWith(SpringRunner.class) // @Autowire V4
//@ExtendWith(SpringExtension.class)// @Autowire V5
//@DataJpaTest
public class CarroServiceTeste {

    private Long idCarro = 1l;
    @Autowired
    private CarroService carroService;
    
    @BeforeEach
    /** Define as configurações quando necessitar. Antes de lançar o projeto, o metetodo setup é executado */
    public void setup() {
    }

    @AfterEach
    /** Reseta as configurações quando a execução for finalizada. depois de finalizar o projeto, o metetodo setdown é executado */
    public void setdown() {
    }

    @Test
    @DisplayName("Verificar se está salvando novo Carro")
    /** quando um novo carro é salvo, testa se está salvando no banco de dados*/
    public void cadastrarCarroTeste() {
        CarroFORM carroFORM = new CarroFORM("Alisson Richardy", "VW", "V15", "Branco", 50000D, false);
        CarroDTO carroSalvo = carroService.cadastrarCarro(carroFORM);
        System.out.println("Proprietário: ".concat(carroSalvo.getProprietario()));
        CarroDTO carroDTO = carroService.buscarCarroPorId(carroSalvo.getId());
        assertThat(carroDTO).isNotNull();
    }

    @Test
    @DisplayName("Verificar se está salvando novo Carro")
    /** Busca um carro por id e checa se objeto retornado é diferente de nullo */
    public void buscarCarroPorIdCarroTeste() {
        //CarroDTO carroDTO = carroService.buscarCarroPorId(idCarro);
        //assertThat(carroDTO).isNotNull();

        assertThat(carroService.buscarCarroPorId(idCarro)).isNotNull();
    }

    @Test
    @DisplayName("Verificar as propriedades")
    public void checarPropriedasCarroQuandoBuscarCarroPorIdTeste() {
        CarroDTO carroDTO = carroService.buscarCarroPorId(idCarro);

        //assertThat(carroDTO.getId().getClass()).isEqualTo(Integer.class); // case error
        assertThat(carroDTO.getId().getClass()).isEqualTo(Long.class);
        assertThat(carroDTO.getId()).isNotNegative();

        assertThat(carroDTO.getCor()).isNotNull();
        assertThat(carroDTO.getCor()).isNotEmpty();

        assertThat(carroDTO.getIsRoubado()).isNotNull();

        assertThat(carroDTO.getValorDeMercado()).isGreaterThan(1d);
        assertThat(carroDTO.getValorDeMercado()).isNotNegative();

        //assertThat(carroDTO.getId(), is(1l));
    }

    @Test
    @DisplayName("Verificar valorImposto igual 1500")
    public void checarCalculoImpostoSobrePropriedadeQuandoValorCarroIgualMilQuinhentos() {
        Double valorImposto = carroService.calcularValorImpostoSobrePropriedade(1500D);
        assertThat(valorImposto).isEqualTo(1500D);
    }

    @Test
    @DisplayName("Verificar valorImposto maior 1500")
    public void checarCalculoImpostoSobrePropriedadeQuandoValorCarroMaiorMilQuinhentos() {
        Double valorImposto = carroService.calcularValorImpostoSobrePropriedade(2000D);
        assertThat(valorImposto).isEqualTo(3000D);
        
    }

    @Test
    @DisplayName("Verificar valorImposto menor 1500")
    public void checarCalculoImpostoSobrePropriedadeQuandoValorCarroMenorMilQuinhentos() {
        Double valorImposto = carroService.calcularValorImpostoSobrePropriedade(1000D);
        assertThat(valorImposto).isEqualTo(500D);
    }


}
