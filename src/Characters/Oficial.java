package Characters;

import General.Celda;
import General.CentralNuclear;
import General.Constantes;
import General.Utilidad;

import java.io.PrintWriter;

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

    @Override
    public String toString() {
        return Constantes.OFICIAL + super.toString();
    }

    public void catalogar(PrintWriter escribidor) {
        int posicion_actual = getIdCeldaActual();
        CentralNuclear central = CentralNuclear.getInstancia();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));

        for (Personaje cadapersonaje : celdaActual.getLista_personajes()) {
            if (cadapersonaje instanceof Operador && !((Operador) cadapersonaje).isCatalogado()) {
                String tipoOperador = "";
                if (cadapersonaje instanceof Cientifico) {
                    tipoOperador = Constantes.CIENTIFICO;
                } else if (cadapersonaje instanceof Minero) {
                    tipoOperador = Constantes.MINERO;
                } else if (cadapersonaje instanceof Bombero) {
                    tipoOperador = Constantes.BOMBERO;
                } else if (cadapersonaje instanceof Oficial) {
                    tipoOperador = Constantes.OFICIAL;
                } else if (cadapersonaje instanceof Voluntario) {
                    tipoOperador = Constantes.VOLUNTARIO;
                } else if (cadapersonaje instanceof Robot) {
                    tipoOperador = Constantes.ROBOT;
                }

                escribidor.println(getNombre() + Constantes.DOS_PUNTOS + tipoOperador + Constantes.ALMOHADILLA + cadapersonaje.getNombre() + Constantes.ALMOHADILLA + cadapersonaje.getIdCeldaActual() + Constantes.ALMOHADILLA + cadapersonaje.getMarca());
                ((Operador) cadapersonaje).setCatalogado(true);
            }
        }
    }

    public void destruirLlave(PrintWriter escribidor) {
        CentralNuclear central = CentralNuclear.getInstancia();
        int fila = Utilidad.calcularFila(getIdCeldaActual());
        int columna = Utilidad.calcularColumna(getIdCeldaActual());
        Celda celdaActual;
        celdaActual = central.getCelda(fila, columna);
        if (celdaActual.getLlave() != null) {
            escribidor.println(getNombre() + Constantes.LLAVE_DESTRUIDA + celdaActual.getIdentificador_celda() + Constantes.PUNTO);

            celdaActual.setLlave(null);
        }
    }










}
