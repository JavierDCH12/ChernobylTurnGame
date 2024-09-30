package Characters;


import General.Celda;
import General.CentralNuclear;
import General.Constantes;
import General.Utilidad;

import java.io.PrintWriter;

public class Voluntario extends KGB {

    public Voluntario() {
        super();
    }

    public Voluntario(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
    }

    @Override
    public void realizarAcciones(PrintWriter escribidor) {
        mover(escribidor);
        catalogar(escribidor);
    }


    @Override
    public String toString() {
        return "Voluntario" + super.toString();
    }

    public void catalogar(PrintWriter escribidor) {
        int posicion_actual = getIdCeldaActual();
        CentralNuclear central = CentralNuclear.getInstancia();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));

        for (Personaje cadapersonaje : celdaActual.getLista_personajes()) {
            if (cadapersonaje instanceof Operador && !((Operador) cadapersonaje).isCatalogado()) {
                String tipoOperador = "";
                if (cadapersonaje instanceof Cientifico) {
                    tipoOperador = "CIENTIFICO";
                } else if (cadapersonaje instanceof Minero) {
                    tipoOperador = "MINERO";
                } else if (cadapersonaje instanceof Bombero) {
                    tipoOperador = "BOMBERO";
                } else if (cadapersonaje instanceof Oficial) {
                    tipoOperador = "OFICIAL";
                } else if (cadapersonaje instanceof Voluntario) {
                    tipoOperador = "VOLUNTARIO";
                } else if (cadapersonaje instanceof Robot) {
                    tipoOperador = "ROBOT";
                }

                escribidor.println(getNombre() + Constantes.DOS_PUNTOS + tipoOperador + Constantes.ALMOHADILLA + cadapersonaje.getNombre() + Constantes.ALMOHADILLA + cadapersonaje.getIdCeldaActual() + Constantes.ALMOHADILLA + cadapersonaje.getMarca());
                ((Operador) cadapersonaje).setCatalogado(true);
            }
        }
    }
}