package General;

public class Llave {

    private int idLlave;
    private int celdaActual;

    //Creamos los constructores de la clase: por defecto y parametrizado
    public Llave(){
        idLlave = 0;
        celdaActual = 0;

    }

    public Llave(int idLlave, int celdaActual){
        this.idLlave = idLlave;
        this.celdaActual = celdaActual;

    }

    public void setIdLlave (int idLlave) {
        this.idLlave = idLlave;
    }

    public void setCeldaActual (int celdaActual) {
        this.celdaActual = celdaActual;
    }

    public int getIdLlave () {
        return idLlave;
    }

    public int getCeldaActual () {
        return celdaActual;
    }


    @Override
    public String toString() {
        return Constantes.LLAVE_IDLLAVE + idLlave + Constantes.CELDA_ACT + celdaActual + "}";
    }
}
