package Characters;

import General.Celda;
import General.CentralNuclear;
import General.Constantes;
import General.Utilidad;

import java.io.PrintWriter;

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


    public void desescombrar(PrintWriter escribidor) {
        int posicion_actual = getIdCeldaActual();
        CentralNuclear central = CentralNuclear.getInstancia();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));
        int cant_escombros_esta_celda = celdaActual.getEscombros();

        if (cant_escombros_esta_celda > 0) {
            celdaActual.setEscombros(0);

            for (Personaje personaje : celdaActual.getLista_personajes()) {
                if (personaje instanceof Minero) {
                    Minero minero = (Minero) personaje;
                    this.agregarEscombro(cant_escombros_esta_celda);
                    escribidor.println(minero.getNombre() + Constantes.LLEVAR + minero.obtenerTotalEscombros() + Constantes.KILOS);
                }
            }
        }
    }



    @Override
    public String toString() {
        return Constantes.MINERO + super.toString() + '}';
    }

    @Override
    public boolean comprobarPuertaSalida() {
        CentralNuclear central = CentralNuclear.getInstancia();
        int posicion_actual = this.getIdCeldaActual();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));

        return celdaActual.getPuerta() != null;
    }

    @Override
    public void realizarAcciones(PrintWriter escribidor) {

        if(!comprobarPuertaSalida()) {
            mover(escribidor);
            desescombrar(escribidor);
        }
    }


}
