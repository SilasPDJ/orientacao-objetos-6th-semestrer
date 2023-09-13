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
        String estadoAtual;
        estadoAtual = "SP";
        int contEstadosIguais = 0;
        for(String estado: impostosObj.estadosPermitidos){
            if(estado.equals(estadoAtual)){
                contEstadosIguais++;
                estadoAtual = estado;
            }
        }
        assertEquals(1, contEstadosIguais);

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
        });
    }

    // Testes para saber se os arrays de alíquotas foram mapeados corretamente
    // objeto <Map> aliquotaPorEstado
    @Test
    void aliquotaDeveSer17EdeveExibirEstados() {
        System.out.print("Atributo de Alíquota 17 %   | Estados: ");
        for (String estado : impostosObj.estadosAliquotas17porcent) {
            System.out.printf("%s ", estado);
            impostosObj.setEstado(estado);
            assertEquals(17.0f, impostosObj.aliquotaPorEstado.get(impostosObj.estado));
        }
        System.out.println("");
    }

    @Test
    void aliquotaDeveSer17emeioEdeveExibirEstados() {
        System.out.print("Atributo de Alíquota 17.5 % | Estados: ");
        for (String estado : impostosObj.estadosAliquotas175porcent) {
            System.out.printf("%s ", estado);
            impostosObj.setEstado(estado);
            assertEquals(17.5f, impostosObj.aliquotaPorEstado.get(impostosObj.estado));
        }
        System.out.println("");


    }

    @Test
    void aliquotaDeveSer18EdeveExibirEstados() {
        System.out.print("Atributo de Alíquota 18 %   | Estados: ");
        for (String estado : impostosObj.estadosAliquotas18porcent) {
            System.out.printf("%s ", estado);
            impostosObj.setEstado(estado);
            assertEquals(18.0f, impostosObj.aliquotaPorEstado.get(impostosObj.estado));
        }
        System.out.println("");

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