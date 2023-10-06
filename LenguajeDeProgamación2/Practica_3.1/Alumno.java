public class Alumno {
        private String nombre;
        private String carrera;
        private String matricula;
        private int grado;
        private String grupo;
        private Tutor tutor;

        public Alumno(String nombre, String carrera, String matricula, int grado, String grupo, Tutor tutor) {
            this.nombre = nombre;
            this.carrera = carrera;
            this.matricula = matricula;
            this.grado = grado;
            this.grupo = grupo;
            this.tutor = tutor;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public int getGrado() {
            return grado;
        }

        public void setGrado(int grado) {
            this.grado = grado;
        }

        public String getGrupo() {
            return grupo;
        }

        public void setGrupo(String grupo) {
            this.grupo = grupo;
        }

        public Tutor getTutor() {
            return tutor;
        }

        public void setTutor(Tutor tutor) {
            this.tutor = tutor;
        }
    }