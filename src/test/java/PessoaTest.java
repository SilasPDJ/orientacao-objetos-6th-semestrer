import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    Pessoa pessoa;

    @BeforeEach
    void setUp(){
        pessoa = new Pessoa();
    }

    @Test
    void deveRetornarMulherAbaixoDoPeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(19.0);
        pessoa.setSexo("feminino");
        assertEquals("abaixo do peso", pessoa.calcularImc());
    }

    @Test
    void deveRetornarMulherNoPesoNormal() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(19.1);
        pessoa.setSexo("feminino");
        assertEquals("no peso normal", pessoa.calcularImc());
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
    void deveRetornarHomemObeso() {
        pessoa.setAltura(1.0f);
        pessoa.setPeso(32);
        pessoa.setSexo("masculino");
        assertEquals("obeso", pessoa.calcularImc());
    }
}