import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private String nombre;
    private List<Materia> materias;

    public Carrera() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Carrera(String nombre, List<Materia> materias) {
        this.nombre = nombre;
        this.materias = materias != null ? materias : new ArrayList<>();
    }

    public Materia buscarMateria(String nombreMateria) {
        for (Materia materia : this.materias) {
            if (materia.getNombre().equals(nombreMateria)) {
                return materia;
            }
        }
        return null;
    }

}
