import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnyClassTest {

    @Test
    void testaNumeroMaiorQue2() {
        AnyClass ac = new AnyClass();
        ac.setNumeroQualquer(2);

        assertEquals(ac.getNumeroQualquer(), 2);
    }
}
