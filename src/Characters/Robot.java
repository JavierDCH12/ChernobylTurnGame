package Characters;


public class Robot extends Personaje {

    private ArrayList<Integer> lista_id_celda;

    public Robot() {
        super();
        lista_id_celda= new ArrayList<Integer>();
    }

    public Robot(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
        this.lista_id_celda= new ArrayList<Integer>();
    }



    public ArrayList<Integer> getLista_id_celda() {
        return lista_id_celda;
    }

    public void setLista_id_celda(ArrayList<Integer> lista_id_celda) {
        this.lista_id_celda = lista_id_celda;
    }


    public void descifrar(String rutaCifrada) {
        for (char movimiento : rutaCifrada.toCharArray()) {
            if (movimiento == 'N' || movimiento == 'S' || movimiento == 'E' || movimiento == 'O') {
                añadirMovimiento(movimiento);
            }
        }
    }


    public void escanear(PrintWriter escribidor) {
        CentralNuclear central = CentralNuclear.getInstancia();
        int filaActual = Utilidad.calcularFila(getIdCeldaActual());
        int columnaActual = Utilidad.calcularColumna(getIdCeldaActual());
        int personajesEnZonaInfluencia = 0;
        ArrayList<Integer> array_adyacentes = central.getAdyacentes(filaActual, columnaActual);

        for (int idCelda : array_adyacentes) {
            Celda celdaVecina = central.getCeldaPorId(idCelda);
            personajesEnZonaInfluencia += celdaVecina.longitudListaPersonajesCelda();
        }

        if (personajesEnZonaInfluencia > 0) {
            escribidor.println(getNombre() + Constantes.DETECTADA + personajesEnZonaInfluencia + Constantes.ZONA_INFLUENCIA);
        }
    }



    public void registrarMovimiento() {
        CentralNuclear central = CentralNuclear.getInstancia();
        int posicion_actual = this.getIdCeldaActual();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));
        lista_id_celda.add(celdaActual.getIdentificador_celda());
    }



    public void mostrarCeldasvisitadas(PrintWriter escribidor) {
        escribidor.println(Constantes.INFORME + getNombre());
        int i;
        for (i = 0; i < lista_id_celda.size(); i++) {
            escribidor.print("[" + lista_id_celda.get(i) + "]");
        }
        escribidor.println();
    }




    @Override
    public void realizarAcciones(PrintWriter escribidor) {


        mover(escribidor);
        registrarMovimiento();
        escanear(escribidor);

    }




}