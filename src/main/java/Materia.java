import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<String> correlativas;

    public Materia(String nombreMateria, List<String> correlativas) {
        this.nombre = nombreMateria;
        this.correlativas = new ArrayList<>(correlativas);
    }
    public String getNombre() {
        return nombre;
    }
    public List<String> getCorrelativas() {
        if (correlativas == null) {
            correlativas = new ArrayList<>();
        }
        List<String> filteredCorrelativas = new ArrayList<>();
        for (String correlativa : correlativas) {
            if (!correlativa.equals("Sin correlativa")) {
                filteredCorrelativas.add(correlativa);
            }
        }
        return filteredCorrelativas;
    }
}