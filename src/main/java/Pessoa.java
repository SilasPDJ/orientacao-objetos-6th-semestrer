public class Pessoa {
    private String sexo;

    public String getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    private double altura;
    private double peso;

    public void setSexo(String sexo) {
        if (!(sexo.equals("F") || sexo.equals("M"))){
            throw new IllegalArgumentException("Sexo invalido");
        }
            this.sexo = sexo;
    }

    public void setAltura(double altura) {
        if(altura <= 0){
            throw new IllegalArgumentException("Altura invalida");
        }
        this.altura = altura;
    }

    public void setPeso(double peso) {
        if(peso <= 0){
            throw new IllegalArgumentException("Peso invalido");
        }
        this.peso = peso;
    }
    public String calcularImc() {
        double imc = peso / (altura * altura);
        String imcCategory = "";

        if ("F".equalsIgnoreCase(sexo)) {
            if (imc < 19.1) {
                imcCategory = "abaixo do peso";
            } else if (imc < 25.8) {
                imcCategory = "no peso normal";
            } else if (imc < 27.3) {
                imcCategory = "marginalmente acima do peso";
            } else if (imc < 32.3) {
                imcCategory = "acima do peso ideal";
            } else {
                imcCategory = "obeso";
            }
        } else if ("M".equalsIgnoreCase(sexo)) {
            if (imc < 20.1) {
                imcCategory = "abaixo do peso";
            } else if (imc < 25.8) {
                imcCategory = "no peso normal";
            } else if (imc < 27.8) {
                imcCategory = "marginalmente acima do peso";
            } else if (imc < 31.1) {
                imcCategory = "acima do peso ideal";
            } else {
                imcCategory = "obeso";
            }
        }

        return imcCategory;
    }



}
