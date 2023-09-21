public class ContaBancaria {
    private String titular;
    private double saldo;


    public void setTitular(String titular) {
        if (titular.length() <= 2) {
            throw new IllegalArgumentException("titular deve conter mais de 2 caracteres");
        } else if (titular.length() > 55) {
            throw new IllegalArgumentException("titular deve conter no maximo 72 caracteres");

        }
        this.titular = titular;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo + getSaldo();
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("valor de deposito menor ou igual a 0 nao permitido");

        } else {
            saldo += valor;
            System.out.println("Depósito de $" + valor + " realizado com sucesso.");
        }
    }

    public void sacar(double valor) {
        if (valor >= 0) {
            throw new IllegalArgumentException("valor deve ser negativo");
        } else if (valor + this.saldo < 0) {
            throw new IllegalArgumentException("saldo indisponivel");
        }
        System.out.printf("Saque de $%.2f realizado com sucesso!\n", valor);
        setSaldo(valor);
    }


    public String obterCategoriaDeBeneficios() {
        // Complexidade ciclomática >= 10

        // Retorna categorias de empréstimos especial
        String categoria;
        if (saldo >= 0 && saldo <= 299.0) {
            categoria = "bronze";
        } else if (saldo <= 500) {
            categoria = "prata";
        } else if (saldo <= 1000) {
            categoria = "ouro";
        } else if (saldo <= 2000) {
            categoria = "platina";
        } else if (saldo <= 3300) {
            categoria = "diamante";
        } else if (saldo <= 5000) {
            categoria = "safira";
        } else if (saldo <= 7500) {
            categoria = "esmeralda";
        } else if (saldo <= 9999) {
            categoria = "rubi";
        } else if (saldo <= 19999) {
            categoria = "agata";
        } else if (saldo >= 20000) {
            categoria = "jade";
        } else {
            categoria = "não possui";
        }
        return categoria;
    }

}
