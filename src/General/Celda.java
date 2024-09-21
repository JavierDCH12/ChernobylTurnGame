package General;

public class Celda {

    private int identificador_celda;

    private ArrayList<Personaje> lista_personajes;

    private boolean refrigerada;

    private int escombros;

    private Puerta puerta;

    private Llave llave;


    public Celda() {
        identificador_celda = 0;
        lista_personajes = new ArrayList<Personaje>();
        refrigerada = false;
        escombros = 0;
        puerta = null;
        llave = null;
    }


    public Celda(int identificador_celda) {
        this.identificador_celda = identificador_celda;
        lista_personajes = new ArrayList<Personaje>();
        refrigerada = false;
        escombros = 0;
        puerta = null;
        llave = null;
    }


    public Celda(int identificador_celda, boolean refrigerada, int escombros) {
        this.identificador_celda = identificador_celda;
        this.lista_personajes = new ArrayList<>();
        this.refrigerada = refrigerada;
        this.escombros = escombros;
        this.puerta = puerta;
        this.llave = llave;


    }


    public int getIdentificador_celda() {
        return identificador_celda;
    }


    public void setIdentificador_celda(int identificador_celda) {
        this.identificador_celda = identificador_celda;
    }


    public ArrayList<Personaje> getLista_personajes() {
        return lista_personajes;
    }


    public void setLista_personajes(ArrayList<Personaje> lista_personajes) {
        this.lista_personajes = lista_personajes;
    }

    public boolean getRefrigerada() {
        return refrigerada;
    }

    public boolean isRefrigerada() {
        return refrigerada;
    }


    public void setRefrigerada(boolean refrigerada) {
        this.refrigerada = refrigerada;
    }


    public int getEscombros() {
        return escombros;
    }


    public void setEscombros(int escombros) {
        this.escombros = escombros;
    }


    public Puerta getPuerta() {
        return puerta;
    }


    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }


    public Llave getLlave() {
        return llave;
    }


    public void setLlave(Llave llave) {
        this.llave = llave;
    }

    public boolean isLlave() {
        return llave != null;
    }



    public void insPersonaje(Personaje personaje) {
        lista_personajes.add(personaje);
    }



    public Personaje buscarPersonajePorNombre(String nombre, PrintWriter escribidor) {
        int i = 0;
        boolean encontrado = false;

        if (!lista_personajes.isEmpty()) {
            while (!encontrado && i < lista_personajes.size()) {
                Personaje personaje = lista_personajes.get(i);

                if (personaje.getNombre().equalsIgnoreCase(nombre)) {
                    encontrado = true;
                    escribidor.println("Se encontró el personaje " + nombre + " en la celda " + identificador_celda);
                    return personaje;
                }

                escribidor.println("No se encontró el personaje " + nombre + " en la celda " + identificador_celda);
                i++;
            }
        } else {
            escribidor.println("La lista de personajes en la celda " + identificador_celda + " está vacía.");
        }

        return null;
    }






    public boolean borrarPersonajePorNombre(String nombre) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado && i < lista_personajes.size()) {
            Personaje personaje = lista_personajes.get(i);

            if (personaje.getNombre().equalsIgnoreCase(nombre)) {
                lista_personajes.remove(personaje);
                encontrado = true;
            }

            i++;
        }

        return encontrado;
    }






    public boolean isOperadorEnCelda() {
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < lista_personajes.size()) {
            Personaje personaje = lista_personajes.get(i);

            if (personaje instanceof Operador) {
                encontrado = true;
            }

            i++;
        }

        return encontrado;
    }



    public Personaje getPersonajeSegunCelda(int posicion) {
        if(posicion >=0 && posicion < lista_personajes.size()) {
            return lista_personajes.get(posicion);

        }else {
            return null;
        }

    }

    public int longitudListaPersonajesCelda() {
        return lista_personajes.size();
    }



¡


    @Override
    public String toString() {
        if (this.lista_personajes.size() > 0) {
            if (this.lista_personajes.size() == 1) {
                // Convierte a String el char recibido por parámetro
                return String.valueOf(this.lista_personajes.get(0).getMarca());
            } else {
                return String.valueOf(this.lista_personajes.size());
            }
        } else if (this.llave != null) {
            return "?";
        } else {
            return Constantes.CERO;
        }
    }






}
