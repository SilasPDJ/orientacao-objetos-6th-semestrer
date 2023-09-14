import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

// quem manipula os atrivutos de uma clase é a propria classse, nao outras, as outras só pegam o get
// encapsulamento
class ImpostosTest {
    Impostos impostosObj;

    @BeforeEach
    void setUp() {
        impostosObj = new Impostos();
    }

    @Test
    void deveValidar27EstadosComBaseNoArrayEstadosPermitidos() {
        assertEquals(27, impostosObj.getQuantidadeDeEstadosPermitidos());
        // testa uma coisa por vez
    }
    @Test
    void deveRetornarEstadoInvalidoComBaseNoMetodoSetEstado() {
        try {
            impostosObj.setEstado("SPFC");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("estado deve ser preenchido contendo 2 caracteres",
                    e.getMessage());
        }
    }

    @Test
    void deveRetornarEstadoDeveSerPreenchidoEconter2Caracteres() {
        try {
            impostosObj.setEstado("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("estado deve ser preenchido contendo 2 caracteres",
                    e.getMessage());
        }

    }

    //

    @Test
    void deveRetornarValorDeveSerMaiorQueZero() {
        try {
            impostosObj.setValor(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("valor deve ser maior do que 0", e.getMessage());
        }
    }

    @Test
    void deveNaoRetornarErroPoisValorEhMaiorQue0() {
        assertDoesNotThrow(() -> {
            impostosObj.setValor(1);
        });
    }


    // Testando o resultado dos cálculos da alíquota.
    // Os estados, que devem ser 27 e pertencer ao Brasil...
    //...e os valores de suas respectativas aliquotas ja foram testados
    @Test
    void deveRetornarCalcularImpostoComValorCorretoDaAliquota18() {
        impostosObj.setEstado("SP");
        impostosObj.setValor(200.0f);

        double imposto = impostosObj.calcularImposto();
        assertEquals(36.0f, imposto);
    }

    @Test
    void deveRetornarCalcularImpostoComValorCorretoDaAliquota17eMeio() {
        impostosObj.setEstado("RO");
        impostosObj.setValor(2000.0f);

        double imposto = impostosObj.calcularImposto();
        // assertEquals(2000 * 0.175, 350);
        assertEquals(350, imposto);
    }

    @Test
    void deveRetornarCalcularImpostoComValorCorretoDaAliquota17() {
        impostosObj.setEstado("MS");
        impostosObj.setValor(1000.0f);

        double imposto = impostosObj.calcularImposto();
        assertEquals(170, imposto);
    }


}