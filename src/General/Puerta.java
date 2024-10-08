package General;

public class Puerta {


    private int identificador_celda;
    private boolean abierta;
    private int id_llave;


    public Puerta() {
        identificador_celda = 0;
        abierta = false;
        id_llave=0;
    }

    public Puerta(int identificador_celda) {
        this.identificador_celda = identificador_celda;
        this.abierta = false;
    }

    public Puerta(int identificador_celda, int id_llave ) {
        this.identificador_celda = identificador_celda;
        this.abierta = false;
        this.id_llave=id_llave;
    }

    public int getIdentificador_celda() {
        return identificador_celda;
    }

    public void setIdentificador_celda(int identificador_celda) {
        this.identificador_celda = identificador_celda;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public int getId_llave() {
        return id_llave;
    }

    public void setId_llave(int id_llave) {
        this.id_llave = id_llave;
    }



    @Override
    public String toString() {
        return Constantes.PUERTA_IDCELDA + identificador_celda + Constantes.ABIERTA + abierta + Constantes.ID_LLAVE + id_llave
                + "]";
    }



}
