import java.util.HashMap;
import java.util.Map;

public class ImpostosSetters {

    final private Map<String, Float> statesAndAliquotas = new HashMap<>();
    public Map<String, Float> getStatesAndAliquotas() {
        return statesAndAliquotas;
    }

    public ImpostosSetters() {
        setStatesAndAliquotas();
    }
    private void setStatesAndAliquotas() {
        statesAndAliquotas.put("AC", 17.0f);
        statesAndAliquotas.put("AL", 17.0f);
        statesAndAliquotas.put("ES", 17.0f);
        statesAndAliquotas.put("GO", 17.0f);
        statesAndAliquotas.put("MT", 17.0f);
        statesAndAliquotas.put("MS", 17.0f);
        statesAndAliquotas.put("PA", 17.0f);
        statesAndAliquotas.put("RR", 17.0f);
        statesAndAliquotas.put("SC", 17.0f);
        statesAndAliquotas.put("RO", 17.5f);
        statesAndAliquotas.put("AM", 18.0f);
        statesAndAliquotas.put("AP", 18.0f);
        statesAndAliquotas.put("BA", 18.0f);
        statesAndAliquotas.put("CE", 18.0f);
        statesAndAliquotas.put("DF", 18.0f);
        statesAndAliquotas.put("MA", 18.0f);
        statesAndAliquotas.put("MG", 18.0f);
        statesAndAliquotas.put("PB", 18.0f);
        statesAndAliquotas.put("PR", 18.0f);
        statesAndAliquotas.put("PE", 18.0f);
        statesAndAliquotas.put("PI", 18.0f);
        statesAndAliquotas.put("RN", 18.0f);
        statesAndAliquotas.put("RS", 18.0f);
        statesAndAliquotas.put("RJ", 18.0f);
        statesAndAliquotas.put("SP", 18.0f);
        statesAndAliquotas.put("SE", 18.0f);
        statesAndAliquotas.put("TO", 18.0f);
    }

    public boolean estadoExiste(String estado) {
        return statesAndAliquotas.containsKey(estado.strip().toUpperCase());
    }

    public float getAliquotaPorEstado(String estado) {
        return statesAndAliquotas.getOrDefault(estado.strip().toUpperCase(), 0.0f);
    }


}
