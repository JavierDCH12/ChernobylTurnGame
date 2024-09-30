package Characters;

import General.Celda;
import General.CentralNuclear;
import General.Constantes;
import General.Utilidad;

import java.io.PrintWriter;

public class Bombero extends Operador {
    private int bateriaRefrigerador;

    public Bombero() {
        super();
        bateriaRefrigerador =5;
    }


    public Bombero(String nombre, int turno, int idCeldaActual, char marca) {
        super(nombre, turno, idCeldaActual, marca);
        this.bateriaRefrigerador = 5 ;
    }

    public void setBateriaRefrigerador(int bateriaRefrigerador) {
        this.bateriaRefrigerador=bateriaRefrigerador;
    }

    public int getBateriaRefrigerador() {
        return bateriaRefrigerador;
    }



    private void recargarRefrigerador() {
        this.bateriaRefrigerador = 5 ;
    }

    public void refrigerar() {
        CentralNuclear central = CentralNuclear.getInstancia();


        int posicion_actual = getIdCeldaActual();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));
        celdaActual.setRefrigerada(true);

    }



    @Override
    public void realizarAcciones(PrintWriter escribidor) {

        if(!comprobarPuertaSalida()) {
            if(this.bateriaRefrigerador>0) {
                this.mover(escribidor);
                this.refrigerar();
                this.bateriaRefrigerador--;
            }else {
                escribidor.println(getNombre() + Constantes.RECARGANDO_BATERIA);
                this.recargarRefrigerador();

            }


        }
    }



    @Override
    public String toString() {
        return Constantes.BOMBERO + super.toString() +
                Constantes.CARGA_REFRIGERADOR + bateriaRefrigerador +
                '}';
    }


    @Override
    public boolean comprobarPuertaSalida() {
        CentralNuclear central = CentralNuclear.getInstancia();
        int posicion_actual = this.getIdCeldaActual();
        Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));

        if(celdaActual.getPuerta()!= null) {
            return true;

        }
        return false;
    }





}
