public class Main {
    public static void main(String[] args) {
        Telefono telefonoTutor = new Telefono("México", "+52", "981 000 0000");
        Tutor tutor = new Tutor("Juan Calderón", 45, telefonoTutor);

        Alumno alumno = new Alumno("Juan José", "ISC", "71086", 3, "Grupo B", tutor);

        // Acceso a los atributos
        System.out.println("Nombre del alumno: " + alumno.getNombre());
        System.out.println("Carrera del alumno: " + alumno.getCarrera());
        System.out.println("Matrícula del alumno: " + alumno.getMatricula());
        System.out.println("Grado del alumno: " + alumno.getGrado());
        System.out.println("Grupo del alumno: " + alumno.getGrupo());
        System.out.println("Nombre del tutor: " + alumno.getTutor().getNombre());
        System.out.println("Edad del tutor: " + alumno.getTutor().getEdad());
        System.out.println("Teléfono del tutor: " + alumno.getTutor().getTelefono().getNumero());
    }
}
