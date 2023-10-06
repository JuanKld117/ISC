
    // Clase derivada para Pokémon de tipo Agua
    class PokemonAgua extends Pokemon {
        public PokemonAgua(String nombre, int nivel) {
            super(nombre, nivel);
        }

        @Override
        public void atacar() {
            System.out.println(getNombre() + " está usando un ataque de agua.");
        }

        private boolean getNombre() {
            return false;
        }
    }
