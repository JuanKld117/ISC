public class Telefono {
        private String pais;
        private String lada;
        private String numero;

        public Telefono(String pais, String lada, String numero) {
            this.pais = pais;
            this.lada = lada;
            this.numero = numero;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getLada() {
            return lada;
        }

        public void setLada(String lada) {
            this.lada = lada;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }
    }