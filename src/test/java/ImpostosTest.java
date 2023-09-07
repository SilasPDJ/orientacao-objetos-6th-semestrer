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
    void deveValidarQueTodosOsEstadosSaoDiferentes(){

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
    void deveRetornarEstadoDeveSerPreenchidoEconter2Caracteres(){
    try {
            impostosObj.setEstado("");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("estado deve ser preenchido contendo 2 caracteres",
                    e.getMessage());
        }

    }

    @Test
    void deveRetornarAliquotaValida(){
        AtomicBoolean estadoAliquotaIsValid = new AtomicBoolean(false);
        for (String estado : impostosObj.estadosPermitidos) {
            estadoAliquotaIsValid.set(false);

            assertDoesNotThrow(() -> {
                impostosObj.setEstado(estado);
                float aliquota = impostosObj.aliquotaPorEstado.get(impostosObj.estado);
                // aliquota = 16;
                // Verfica se a alíquota pertence às alíquotas permitidas
                for(float validAliquota: impostosObj.aliquotasPermitidas){
                    if (validAliquota == aliquota){
                        estadoAliquotaIsValid.set(true);
                    }
                }
                assertTrue(estadoAliquotaIsValid.get());
            });
        }
    }

    @Test
    void deveRetornarValorDeveSerMaiorQueZero(){
        try{
            impostosObj.setValor(0);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("valor deve ser maior do que 0", e.getMessage());
        }
        try{
            impostosObj.setValor(-1);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("valor deve ser maior do que 0", e.getMessage());
        }
    }
    @Test
    void deveNaoRetornarErroPoisValorEhMaiorQue0(){
        assertDoesNotThrow(() -> {
            impostosObj.setValor(1);
            System.out.println("Verdadeiro");
        });
    }

    @Test
    void calcularImpostoDeveRetornarUmValorMenorOuIgualAoAtributoValor(){
        // Pois não faz sentido a alíquota ser maior do que 100% ...
        // TODO Alíquotas permitidas já foram valdiadas... Continuar com esse caso?
        String[] estadosTest = {"SP", "RO", "SC"};

        for(String estado: estadosTest){
            impostosObj.setEstado(estado);
            impostosObj.setValor(100);

            double impostoCalculado = impostosObj.calcularImposto();
            System.out.println(impostoCalculado);

            assertTrue(impostoCalculado <= impostosObj.valor);
        }

    }


}