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
        double imc;

        imc = peso / (altura * altura);

        if ("feminino".equalsIgnoreCase(sexo)) {
            if (imc < 19.1) {
                return "abaixo do peso";
            } else if (19.1 <= imc && imc < 25.8) {
                return "peso normal";
            } else if (25.8 <= imc && imc < 27.3) {
                return "marginalmente acima do peso";
            } else if (27.3 <= imc && imc < 32.3) {
                return "acima do peso ideal";
            } else if (imc >= 32.3) {
                return "obeso";
            }
        } else if ("masculino".equalsIgnoreCase(sexo)) {
            if (imc < 20.1) {
                return "abaixo do peso";
            } else if (20.7 <= imc && imc < 26.4) {
                return "peso normal";
            } else if (26.4 <= imc && imc < 27.8) {
                return "marginalmente acima do peso";
            } else if (27.8 <= imc && imc < 31.1) {
                return "acima do peso ideal";
            } else if (imc >= 31.1) {
                return "obeso";
            }
        }
        return "";
    }


}
