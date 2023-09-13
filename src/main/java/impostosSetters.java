import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class impostosSetters {
    Map<String, Float> aliquotaPorEstado = new HashMap<>();
    String[] estadosAliquotas17porcent = {"AC", "AL", "ES", "GO", "MT", "MS", "PA", "RR", "SC"};
    String[] estadosAliquotas175porcent = {"RO"};
    String[] estadosAliquotas18porcent = {"AM", "AP", "BA", "CE", "DF", "MA", "MG", "PB", "PR", "PE", "PI", "RN", "RS", "RJ", "SP", "SE", "TO"};
    String[] estadosPermitidos =  concatenateArrays(estadosAliquotas17porcent, estadosAliquotas175porcent, estadosAliquotas18porcent);;
    float[] aliquotasPermitidas = {17, 17.5f, 18};


    public impostosSetters() {
        // map estados

        // declare aliquotas dynamic variables

        // mapping aliquotas
        for (String estado : estadosAliquotas17porcent) {
            aliquotaPorEstado.put(estado, 17.0f);
        }
        for (String estado : estadosAliquotas175porcent) {
            aliquotaPorEstado.put(estado, 17.5f);
        }
        for (String estado : estadosAliquotas18porcent) {
            aliquotaPorEstado.put(estado, 18.0f);
        }
    }

    private static String[] concatenateArrays(String[]... arrays) {
        return Stream.of(arrays)
                .flatMap(Stream::of)        // or, use `Arrays::stream`
                .toArray(String[]::new);
    }

    boolean estadoExiste(String estado) {
        for (String _estado : this.estadosPermitidos) {
            if (_estado.equals(estado.strip().toUpperCase())) {
                return true;
            }
        }
        return false;

    }


}
