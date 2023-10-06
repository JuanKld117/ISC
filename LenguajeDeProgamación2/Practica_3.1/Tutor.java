public class Tutor {
        private String nombre;
        private int edad;
        private Telefono telefono;

        public Tutor(String nombre, int edad, Telefono telefono) {
            this.nombre = nombre;
            this.edad = edad;
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public Telefono getTelefono() {
            return telefono;
        }

        public void setTelefono(Telefono telefono) {
            this.telefono = telefono;
        }
    }
