import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class impostosSetters {
    Map<String, Float> aliquotaPorEstado = new HashMap<>();
    String[] aliquotas17porcent = {"AC", "AL", "ES", "GO", "MT", "MS", "PA", "RR", "SC"};
    String[] aliquotas175porcent = {"RO"};
    String[] aliquotas18porcent = {"AM", "AP", "BA", "CE", "DF", "MA", "MG", "PB", "PR", "PE", "PI", "RN", "RS", "RJ", "SP", "SE", "TO"};
    String[] estadosPermitidos =  concatenateArrays(aliquotas17porcent, aliquotas175porcent, aliquotas18porcent);;
    float[] aliquotasPermitidas = {17, 17.5f, 18};
    String hi;



    public impostosSetters() {
        // map estados

        // declare aliquotas dynamic variables

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
