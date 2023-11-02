import java.util.List;

public class Alumno {
    private String nombre;
    private List<String> materiasAprobadas;

    public Alumno(String nombreAlumno, List<String> materiasAprobadas) {
        this.nombre = nombreAlumno;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<String> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public boolean puedeInscribirse(Materia materia) {
        List<String> correlativas = materia.getCorrelativas();
        if (correlativas.isEmpty() || materiasAprobadas.isEmpty()) {
            return false;
        }
        for (String correlativa : correlativas) {
            if (!materiasAprobadas.contains(correlativa)) {
                return false;
            }
        }
        return true;
    }
}