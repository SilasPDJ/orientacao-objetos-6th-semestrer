import java.util.HashMap;
import java.util.Map;

public class impostosSetters {
    Map<String, String> estadosMap = new HashMap<>();
    Map<String, String> estadosReversedMap = new HashMap<>();

    Map<String, Float> aliquotaPorEstado = new HashMap<>();

    public impostosSetters(){
        // map estados
        estadosMap.put("AC", "Acre".toUpperCase());
        estadosMap.put("AL", "Alagoas".toUpperCase());
        estadosMap.put("AP", "Amapá".toUpperCase());
        estadosMap.put("AM", "Amazonas".toUpperCase());
        estadosMap.put("BA", "Bahia".toUpperCase());
        estadosMap.put("CE", "Ceará".toUpperCase());
        estadosMap.put("DF", "Distrito Federal".toUpperCase());
        estadosMap.put("ES", "Espírito Santo".toUpperCase());
        estadosMap.put("GO", "Goiás".toUpperCase());
        estadosMap.put("MA", "Maranhão".toUpperCase());
        estadosMap.put("MT", "Mato Grosso".toUpperCase());
        estadosMap.put("MS", "Mato Grosso do Sul".toUpperCase());
        estadosMap.put("MG", "Minas Gerais".toUpperCase());
        estadosMap.put("PA", "Pará".toUpperCase());
        estadosMap.put("PB", "Paraíba".toUpperCase());
        estadosMap.put("PR", "Paraná".toUpperCase());
        estadosMap.put("PE", "Pernambuco".toUpperCase());
        estadosMap.put("PI", "Piauí".toUpperCase());
        estadosMap.put("RJ", "Rio de Janeiro".toUpperCase());
        estadosMap.put("RN", "Rio Grande do Norte".toUpperCase());
        estadosMap.put("RS", "Rio Grande do Sul".toUpperCase());
        estadosMap.put("RO", "Rondônia".toUpperCase());
        estadosMap.put("RR", "Roraima".toUpperCase());
        estadosMap.put("SC", "Santa Catarina".toUpperCase());
        estadosMap.put("SP", "São Paulo".toUpperCase());
        estadosMap.put("SE", "Sergipe".toUpperCase());
        estadosMap.put("TO", "Tocantins".toUpperCase());

        // set reversedMap
        for (Map.Entry<String, String> entry : estadosMap.entrySet()) {
            estadosReversedMap.put(entry.getValue(), entry.getKey());
        }

        // declare aliquotas dynamic variables
        String[] aliquotas17porcent = {"AC", "AL", "ES", "GO", "MT", "MS", "PA", "RR", "SC"};
        String[] aliquotas175porcent = {"RO"};
        String[] aliquotas18porcent = {"AM", "AP", "BA", "CE", "DF", "MA", "MG", "PB", "PR", "PE", "PI", "RN", "RS", "RJ", "SP", "SE", "TO"};

        // mapping aliquotas
        for (String estado : aliquotas17porcent) {
            aliquotaPorEstado.put(estado, 17.0f);
        }
        for (String estado : aliquotas175porcent) {
            aliquotaPorEstado.put(estado, 17.5f);
        }
        for (String estado : aliquotas18porcent) {
            aliquotaPorEstado.put(estado, 18.0f);
        }
    }
}
