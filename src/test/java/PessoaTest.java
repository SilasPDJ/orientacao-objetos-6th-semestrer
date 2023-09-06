import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    Pessoa pessoa;

    @BeforeEach
    void setUp(){
        pessoa = new Pessoa();
    }

    void testarMulher(double altura, double peso, String resultadoEsperado){
        pessoa.setAltura(altura);
        pessoa.setPeso(peso);
        pessoa.setSexo("feminino");
        assertEquals(resultadoEsperado, pessoa.calcularImc());
    }
    void testarHomem(double altura, double peso, String resultadoEsperado){
        pessoa.setAltura(altura);
        pessoa.setPeso(peso);
        pessoa.setSexo("masculino");
        assertEquals(resultadoEsperado, pessoa.calcularImc());

    }

    @Test
    void deveRetornarMulherAbaixoDoPeso() {
        testarMulher(1.0f, 19.0, "abaixo do peso");
    }

    @Test
    void deveRetornarMulherNoPesoNormal() {
        testarMulher(1.0f, 19.1, "no peso normal");

    }

    @Test
    void deveRetornarMulherMarginalmenteAcimaDoPeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(25.8);
        pessoa.setSexo("feminino");
        assertEquals("marginalmente acima do peso", pessoa.calcularImc());
    }

    @Test
    void deveRetornarMulherAcimaDoPeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(27.3);
        pessoa.setSexo("feminino");
        assertEquals("acima do peso ideal", pessoa.calcularImc());
    }

    @Test
    void deveRetornarMulherAcimaDoPesoIdeal() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(32.3);
        pessoa.setSexo("feminino");
        assertEquals("obeso", pessoa.calcularImc());
    }

    @Test
    void deveRetornarMulherObeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(33.5);
        pessoa.setSexo("feminino");
        assertEquals("obeso", pessoa.calcularImc());
    }
    @Test
    void deveRetornarHomemAbaixoDoPeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(20.09);
        pessoa.setSexo("masculino");
        assertEquals("abaixo do peso", pessoa.calcularImc());
    }
    @Test
    void deveRetornarHomemNoPesoNormal() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(25.79);
        pessoa.setSexo("masculino");
        assertEquals("no peso normal", pessoa.calcularImc());
    }
    @Test
    void deveRetornarHomemMarginalmenteAcimaDoPeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(27.7);
        pessoa.setSexo("masculino");
        assertEquals("marginalmente acima do peso", pessoa.calcularImc());
    }

    @Test
    void deveRetornarHomemAcimaDoPesoIdeal() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(31.09);
        pessoa.setSexo("masculino");
        assertEquals("acima do peso ideal", pessoa.calcularImc());
    }
    @Test
    void deveRetornarHomemObeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(32);
        pessoa.setSexo("masculino");
        assertEquals("obeso", pessoa.calcularImc());
    }

    @Test
    void devRetornarSexoMasculino(){
        pessoa.setSexo("M");
        assertEquals("M", pessoa.getSexo());
    }
    @Test
    void devRetornarSexoFeminino(){
        pessoa.setSexo("F");
        assertEquals("F", pessoa.getSexo());
    }
    @Test
    void deveRetornarSexoInvalido(){
        try{
        pessoa.setSexo("A");

        }catch (IllegalArgumentException e){
            assertEquals("Sexo invalido", e.getMessage());
        }
    }
}