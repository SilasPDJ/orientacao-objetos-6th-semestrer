package funcionario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioMensalistaTest {

    @Test
    void deveRetornarNomeFuncionario() {
        FuncionarioMensalista funcionarioMensalista = new FuncionarioMensalista();
        funcionarioMensalista.setNome("Marco");
        assertEquals("Marco", funcionarioMensalista.getNome());
    }

    @Test
    void deveCalcularSalario() {
        FuncionarioMensalista funcionarioMensalista = new FuncionarioMensalista();
        funcionarioMensalista.setValorMes(14000.0f);
        assertEquals(14000.0f, funcionarioMensalista.calcularSalario());
    }

    @Test
    void deveCalcularValeRefeicao() {
        FuncionarioMensalista funcionarioMensalista = new FuncionarioMensalista();
        assertEquals(500.0f, funcionarioMensalista.calcularValeRefeicao());
    }

}