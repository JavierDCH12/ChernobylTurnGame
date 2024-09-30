package Characters;

public class Cientifico extends Operador {

    private HashSet<Llave> set_llaves;

    // Constructor por defecto
    public Cientifico(){
        super();
        set_llaves = new HashSet<Llave>();

    }


    public Cientifico(String nombre, int turno, int idCeldaActual, char marca){
        super(nombre, turno, idCeldaActual, marca);
        this.set_llaves = new HashSet<Llave>();
    }

    public HashSet<Llave> getSet_llaves() {
        return set_llaves;
    }

    public void setSet_llaves(HashSet<Llave> set_llaves) {
        this.set_llaves = set_llaves;
    }

    public void incluirLlaveSet() {
        CentralNuclear central = CentralNuclear.getInstancia();
        int posicion_actual = this.getIdCeldaActual();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));

        Llave llave_cogida = celdaActual.getLlave();
        if (llave_cogida != null) {
            set_llaves.add(llave_cogida);
            celdaActual.setLlave(null);
        }
    }

    public void mostrarLlaves(PrintWriter escribidor) {
        for(Llave cada : set_llaves) {
            escribidor.println(cada.toString());
        }
    }

    public boolean buscarLlave(Llave llaveBuscada) {
        return set_llaves.contains(llaveBuscada);
    }


    public void cogerLlave(PrintWriter escribidor) {
        CentralNuclear central = CentralNuclear.getInstancia();
        int posicion_actual = this.getIdCeldaActual();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));
        if (celdaActual.getLlave() != null) {
            escribidor.println(getNombre() + Constantes.LLAVE_RECOGIDA + celdaActual.getIdentificador_celda() + Constantes.PUNTO);
            set_llaves.add(celdaActual.getLlave());
            celdaActual.setLlave(null);
        }
    }

    @Override
    public String toString() {
        return Constantes.CIENTIFICO + super.toString()+'}';
    }






    @Override
    public void realizarAcciones(PrintWriter escribidor) {
        boolean puerta_salida;
        puerta_salida = this.comprobarPuertaSalida();
        if(!puerta_salida) {
            mover(escribidor);
            cogerLlave(escribidor);
            abrirPuerta(escribidor);

        }

    }

    public boolean abrirPuerta(PrintWriter escribidor) {
        int fila = Utilidad.calcularFila(getIdCeldaActual());
        int columna = Utilidad.calcularColumna(getIdCeldaActual());
        CentralNuclear central = CentralNuclear.getInstancia();
        Celda celda_actual = central.getCelda(fila, columna);
        boolean enc = false;

        if (celda_actual.getPuerta() != null) {
            Iterator<Llave> it = this.set_llaves.iterator();
            while (it.hasNext() && !enc) {
                Llave clave = it.next();
                if (celda_actual.getPuerta().getId_llave() == clave.getIdLlave()) {
                    enc = true;
                    celda_actual.getPuerta().setAbierta(enc);
                    escribidor.println(getNombre() + Constantes.PUERTA_ABIERTA);
                }
            }
        }
        return enc;
    }



}
