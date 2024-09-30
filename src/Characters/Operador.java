package Characters;

import General.Celda;
import General.CentralNuclear;
import General.Utilidad;

import java.io.PrintWriter;

public abstract class Operador extends Personaje {

    private boolean catalogado;
    private boolean enPuertaSalida;

    // Constructor por defecto
    public Operador() {
        super();
        catalogado=false;
        enPuertaSalida=false;
    }

    // Constructor parametrizado
    public Operador(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
        this.catalogado=false;
        this.enPuertaSalida=false;
    }


    public boolean isCatalogado() {
        return catalogado;
    }

    public void setCatalogado(boolean catalogado) {
        this.catalogado = catalogado;
    }

    public boolean isEnPuertaSalida() {
        return enPuertaSalida;
    }

    public void setEnPuertaSalida(boolean enPuertaSalida) {
        this.enPuertaSalida = enPuertaSalida;
    }



    public abstract void realizarAcciones(PrintWriter escribidor);


    public boolean comprobarPuertaSalida() {
        int celda_actual, fila, columna;
        CentralNuclear central;
        Celda objeto_celda;
        central = CentralNuclear.getInstancia();
        celda_actual = this.getIdCeldaActual();
        fila = Utilidad.calcularFila(celda_actual);
        columna = Utilidad.calcularColumna(celda_actual);
        objeto_celda = central.getCelda(fila, columna);

        if(objeto_celda.getPuerta()!=null) {
            this.enPuertaSalida=true;
            return true;

        }else {
            this.enPuertaSalida=false;
            return false;
        }



    }

    public abstract void realizarAcciones(PrintWriter escribidor);

    @Override
    public String toString() {
        return Constantes.OPERADOR_CAT + catalogado + Constantes.EN_PUERTA + enPuertaSalida + "]";
    }






}
