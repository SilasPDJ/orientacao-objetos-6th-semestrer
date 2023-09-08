import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class ImpostosTest {
    Impostos impostosObj;

    @BeforeEach
    void setUp() {
        impostosObj = new Impostos();
    }

    @Test
    void deveValidar27EstadosComBaseNoArrayEstadosPermitidos() {
        assertEquals(27, impostosObj.estadosPermitidos.length);
        for (String estado : impostosObj.estadosPermitidos) {
            assertDoesNotThrow(() -> {
                impostosObj.setEstado(estado);
            });
        }

    }

    @Test
    void deveValidarQueTodosOsEstadosSaoDiferentes() {

    }

    @Test
    void deveRetornarEstadoInvalidoComBaseNoMetodoSetEstado() {
        try {
            impostosObj.setEstado("SPFC");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("estado deve ser da republica federativa brasileira",
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

    @Test
    void deveRetornarAliquotaValida() {
        AtomicBoolean estadoAliquotaIsValid = new AtomicBoolean(false);
        for (String estado : impostosObj.estadosPermitidos) {
            estadoAliquotaIsValid.set(false);

            assertDoesNotThrow(() -> {
                impostosObj.setEstado(estado);
                float aliquota = impostosObj.aliquotaPorEstado.get(impostosObj.estado);
                // aliquota = 16;
                // Verfica se a alíquota pertence às alíquotas permitidas
                for (float validAliquota : impostosObj.aliquotasPermitidas) {
                    if (validAliquota == aliquota) {
                        estadoAliquotaIsValid.set(true);
                    }
                }
                assertTrue(estadoAliquotaIsValid.get());
            });
        }
    }

    @Test
    void deveRetornarValorDeveSerMaiorQueZero() {
        try {
            impostosObj.setValor(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("valor deve ser maior do que 0", e.getMessage());
        }
        try {
            impostosObj.setValor(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("valor deve ser maior do que 0", e.getMessage());
        }
    }

    @Test
    void deveNaoRetornarErroPoisValorEhMaiorQue0() {
        assertDoesNotThrow(() -> {
            impostosObj.setValor(1);
            System.out.println("Verdadeiro");
        });
    }

    // Testes para saber se os arrays de alíquotas foram mapeados corretamente
    // objeto <Map> aliquotaPorEstado
    @Test
    void aliquotaDeveSer17() {
        for (String estado : impostosObj.estadosAliquotas17porcent) {
            impostosObj.setEstado(estado);
            assertEquals(17.0f, impostosObj.aliquotaPorEstado.get(impostosObj.estado));
        }
    }

    @Test
    void aliquotaDeveSer17emeio() {
        for (String estado : impostosObj.estadosAliquotas175porcent) {
            impostosObj.setEstado(estado);
            assertEquals(17.5f, impostosObj.aliquotaPorEstado.get(impostosObj.estado));
        }


    }
    @Test
    void aliquotaDeveSer18() {
        for (String estado : impostosObj.estadosAliquotas18porcent) {
            impostosObj.setEstado(estado);
            assertEquals(18.0f, impostosObj.aliquotaPorEstado.get(impostosObj.estado));
        }


    }


}