package Characters;

public class Oficial extends KGB {

    public Oficial() {
        super();
    }

    public Oficial(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
    }

    @Override
    public void realizarAcciones(PrintWriter escribidor) {
        if(!estaVacia()) {
            mover(escribidor);
            catalogar(escribidor);
            destruirLlave(escribidor);

        }

    }
}
