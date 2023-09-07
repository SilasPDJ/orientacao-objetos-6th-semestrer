import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpostosTest {
    Impostos impostosObj;
    @BeforeEach
    void setUp(){
        impostosObj = new Impostos();
    }
    @Test
    void TestAleatorio(){
        impostosObj.setValor(200);
        impostosObj.setEstado("SP");
        double b = impostosObj.calcularImposto();

        System.out.println(b);


    }


}