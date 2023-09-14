public class Impostos extends ImpostosSetters {
    String estado;
    double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("valor deve ser maior do que 0");
        }
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String messageErrorPertencer;

        // Contemplando tanto siglas quanto nomes por extenso
        if (estado.length() != 2) {
            // System.out.println("Dica: seguir o seguinte modelo: \"SP\".");
            throw new IllegalArgumentException("estado deve ser preenchido contendo 2 caracteres");

        } else if (!estadoExiste(estado)) {
            messageErrorPertencer = "estado deve ser da republica federativa brasileira";
            throw new IllegalArgumentException(messageErrorPertencer);
        }


        this.estado = estado;

    }
    int getQuantidadeDeEstadosPermitidos(){
        return getStatesAndAliquotas().size();
    }

    double calcularImposto() {
        double calculo;
        calculo = this.getValor() * getAliquota();

        return calculo;
    }
    private double getAliquota() {
        double aliquota = getAliquotaPorEstado(this.getEstado());
        return aliquota / 100;
    }
}
