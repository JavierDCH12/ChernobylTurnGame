package Characters;

public class Minero extends Operador {

    private ArrayList<Integer> lEscombros;


    // Constructor por defecto
    public Minero() {
        super();
        lEscombros = new ArrayList<Integer>();
    }

    // Constructor parametrizado
    public Minero(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
        lEscombros = new ArrayList<Integer>();
    }

    // Método para añadir peso de escombros a la lista
    public void agregarEscombro(int peso) {
        lEscombros.add(peso);
    }

    // Método para obtener la cantidad total de escombros recogidos
    public int obtenerTotalEscombros() {
        int totalEscombros = 0;
        for (int peso : lEscombros) {
            totalEscombros += peso;
        }
        return totalEscombros;
    }

    public void mostrarTotalEscombros(PrintWriter escribidor) {
        int total = obtenerTotalEscombros();
        escribidor.println(getNombre() + Constantes.ESCOMBROS_RECOGIDOS + total);
    }

    // Método para vaciar la lista de escombros
    public void vaciarEscombros() {
        lEscombros.clear();
    }

    @Override
    public void realizarAcciones(PrintWriter escribidor) {

        if(!comprobarPuertaSalida()) {
            mover(escribidor);
            desescombrar(escribidor);
        }
    }



}
