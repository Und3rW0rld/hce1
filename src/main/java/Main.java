import model.*;

public class Main {
    public static void main(String[] args) {
        Paciente paciente1 = new Paciente(1L, "María Agudelo Zapata");
        ProfesionalSalud profesional1 = new ProfesionalSalud(2L, "Pedro Perez");
        Paraclinico paraclinico = new Paraclinico(1L, paciente1, profesional1, Tipos.HEMOGRAMA);

    }
}
