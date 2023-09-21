import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {
    ContaBancaria minhaConta;

    @BeforeEach
    void setUp() {
        minhaConta = new ContaBancaria();
    }

    @Test
    void deveRetornarTitularDeveConterMaisDe2caracteres() {
        try {
            minhaConta.setTitular("");
        } catch (IllegalArgumentException e) {
            assertEquals("titular deve conter mais de 2 caracteres", e.getMessage());
        }
    }

    @Test
    void deveRetornarTitularDeveConterNoMaximo55caCaracteres() {
        try {
            minhaConta.setTitular("Ate aqui eu tenho 32 caracteres. Ate aqui eu tenho 32 caracteres. Tenho agora 81.");
        } catch (IllegalArgumentException e) {
            assertEquals("titular deve conter no maximo 72 caracteres", e.getMessage());
        }
    }

    @Test
    void deveRetornarValorDepositoNaoPermitido() {
        try {
            minhaConta.depositar(0);
        } catch (IllegalArgumentException e) {
            assertEquals("valor de deposito menor ou igual a 0 nao permitido", e.getMessage());
        }

    }

    @Test
    void deveRetornarSaldoIndisponivel() {
        try {
            minhaConta.depositar(5000);
            minhaConta.sacar(-5001);
        } catch (IllegalArgumentException e) {
            assertEquals("saldo indisponivel", e.getMessage());
        }
    }

    @Test
    void deveRetornarValorDeveSerNegativo() {
        try {
            minhaConta.depositar(5000);
            minhaConta.sacar(300);
        } catch (IllegalArgumentException e) {
            assertEquals("valor deve ser negativo", e.getMessage());
        }
    }

    @Test
    void deveRetornarOperacoesSaqueDepositoRealizadasComSucesso() {
        minhaConta.setTitular("SBF 333044");
        minhaConta.depositar(1000);
        minhaConta.sacar(-500);
        minhaConta.depositar(250);
        minhaConta.sacar(-500);
        minhaConta.setTitular(minhaConta.getTitular() + " FINALIZADO");
    }

    @Test
    void deveRetornarCategoriaDeBeneficiosEqualsToBronze() {
        minhaConta.setTitular("SBF 333044");
        minhaConta.depositar(299);
        assertEquals("bronze", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaPrataQuandoSaldoEntre300E500() {
        minhaConta.depositar(350.0);
        assertEquals("prata", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaOuroQuandoSaldoEntre501E1000() {
        minhaConta.depositar(800.0);
        assertEquals("ouro", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaPlatinaQuandoSaldoEntre1001E2000() {
        minhaConta.depositar(1500.0);
        assertEquals("platina", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaDiamanteQuandoSaldoEntre2001E3300() {
        minhaConta.depositar(2500.0);
        assertEquals("diamante", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaSafiraQuandoSaldoEntre3301E5000() {
        minhaConta.depositar(4000.0);
        assertEquals("safira", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaEsmeraldaQuandoSaldoEntre5001E7500() {
        minhaConta.depositar(6000.0);
        assertEquals("esmeralda", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaRubiQuandoSaldoEntre7501E9999() {
        minhaConta.depositar(8500.0);
        assertEquals("rubi", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaAgataQuandoSaldoEntre10000E19999() {
        minhaConta.depositar(15000.0);
        assertEquals("agata", minhaConta.obterCategoriaDeBeneficios());
    }

    @Test
    void deveRetornarCategoriaJadeQuandoSaldoMaiorOuIgualA20000() {
        minhaConta.depositar(25000.0);
        assertEquals("jade", minhaConta.obterCategoriaDeBeneficios());
    }
}