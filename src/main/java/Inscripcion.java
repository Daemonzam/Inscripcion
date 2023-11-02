import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    public static void main(String[] args) {
        Carrera carrera = cargarCarreraDesdeArchivo("src/main/resources/CONTADOR PUBLICO NACIONAL.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del alumno: ");
        String nombreAlumno = scanner.nextLine();
        Alumno alumno = cargarMateriasAprobadas("src/main/resources/" + nombreAlumno.toUpperCase()+".txt", nombreAlumno);

        System.out.print("Ingrese el nombre de la materia a la que desea inscribirse: ");
        String nombreMateria = scanner.nextLine();

        Materia materia;
        materia = carrera.buscarMateria(nombreMateria);

        if (materia != null) {
            if (alumno.puedeInscribirse(materia)) {
                System.out.println("El alumno puede inscribirse en " + nombreMateria);
            } else if (alumno.getMateriasAprobadas().contains(nombreMateria)) {
                System.out.println("El alumno ya tiene aprobada la materia " + nombreMateria);
            } else {
                System.out.println("El alumno no cumple con los requisitos para inscribirse en " + nombreMateria);
            }
        } else {
            System.out.println("La materia especificada no está en el plan de estudios.");
        }

        scanner.close();
    }
    private static Carrera cargarCarreraDesdeArchivo(String nombreArchivo) {
        List<Materia> materias = new ArrayList<>();
        try {
            File file = new File(nombreArchivo);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(";");
                String nombreMateria = datos[0];
                if (nombreMateria != null && !nombreMateria.isEmpty()) {
                    List<String> correlativas = Arrays.asList(datos).subList(1, datos.length);
                    Materia materia = new Materia(nombreMateria, correlativas);
                    materias.add(materia);
                } else {
                    System.out.println("Nombre de materia nulo o vacío");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Carrera("CONTADOR PUBLICO NACIONAL", materias);
    }


    private static Alumno cargarMateriasAprobadas(String nombreArchivo, String nombreAlumno) {
        List<String> materiasAprobadas = new ArrayList<>();
        try {
            File file = new File(nombreArchivo);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                materiasAprobadas.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Alumno( nombreAlumno, materiasAprobadas);
    }

}