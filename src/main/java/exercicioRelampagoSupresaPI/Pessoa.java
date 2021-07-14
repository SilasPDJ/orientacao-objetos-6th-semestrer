package exercicioRelampagoSupresaPI;

public class Pessoa {

    private Escolaridade escolaridade;
    private Cidade naturalidade;

    public Pessoa(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        if (escolaridade != null) {
            this.escolaridade = escolaridade;
        }
    }

    public String getDescricaoEscolaridade() {
        return escolaridade.getDescricao();
    }

    public Cidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Cidade naturalidade) {
        if (naturalidade != null) {
            this.naturalidade = naturalidade;
        }
    }

    public String getEstadoCidade() {
        if (naturalidade == null){
            throw new IllegalArgumentException("Naturalidade obrigatoria");
        }
        return this.naturalidade.getNomeEstado();
    }


}