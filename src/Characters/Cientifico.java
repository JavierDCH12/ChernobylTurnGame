package Characters;

public class Cientifico {

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



}
