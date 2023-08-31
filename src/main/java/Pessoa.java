public class Pessoa {
    private String sexo;
    private double altura;
    private double peso;

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String calcularImc() {
        double imc = peso / (altura * altura);
        String imcCategory = "";

        if ("feminino".equalsIgnoreCase(sexo)) {
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
        } else if ("masculino".equalsIgnoreCase(sexo)) {
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
