package Characters;

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
}
