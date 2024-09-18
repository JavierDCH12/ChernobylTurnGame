package Characters;

public abstract class KGB extends Personaje{

    // Constructor por defecto
    public KGB() {
        super();
    }

    // Constructor parametrizado
    public KGB(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
    }


    public abstract void realizarAcciones(PrintWriter escribidor);

    public abstract void catalogar(PrintWriter escribidor);

    @Override
    public String toString() {
        return "{" +
                Constantes.NOMBRE + getNombre() +
                Constantes.TURNO_ + getTurno() +
                Constantes.ID_CELDA_ACTUAL + getIdCeldaActual() +
                Constantes.MARCA + getMarca() +
                '}';
    }



}