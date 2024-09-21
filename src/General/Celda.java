package General;

public class Celda {

    private int identificador_celda;

    private ArrayList<Personaje> lista_personajes;

    private boolean refrigerada;

    private int escombros;

    private Puerta puerta;

    private Llave llave;


    public Celda() {
        identificador_celda = 0;
        lista_personajes = new ArrayList<Personaje>();
        refrigerada = false;
        escombros = 0;
        puerta = null;
        llave = null;
    }


    public Celda(int identificador_celda) {
        this.identificador_celda = identificador_celda;
        lista_personajes = new ArrayList<Personaje>();
        refrigerada = false;
        escombros = 0;
        puerta = null;
        llave = null;
    }


    public Celda(int identificador_celda, boolean refrigerada, int escombros) {
        this.identificador_celda = identificador_celda;
        this.lista_personajes = new ArrayList<>();
        this.refrigerada = refrigerada;
        this.escombros = escombros;
        this.puerta = puerta;
        this.llave = llave;


    }

}
