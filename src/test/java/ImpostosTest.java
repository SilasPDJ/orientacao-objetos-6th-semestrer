import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void deveRetornarEstadoInvalidoComBaseNoMetodoSetEstado() {
        try {
            impostosObj.setEstado("SPFC");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("estado deve ser da republica federativa brasileira",
                    e.getMessage());
        }

    }


}