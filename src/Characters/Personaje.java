package Characters;

public abstract class Personaje {
    private String nombre;
    private int turno;
    private int idCeldaActual;
    private char marca;
    private ArrayList<Character> lRuta;

    public Personaje(){

        nombre = "";
        turno = 0;
        idCeldaActual = 0;
        marca = 'a';
        lRuta = new ArrayList<Character>();
    }

    public Personaje(String nombre, int turno, int idCeldaActual, char marca){

        this.nombre = nombre;
        this.turno = turno;
        this.idCeldaActual = idCeldaActual;
        this.marca = marca;
        this.lRuta = new ArrayList<Character>();
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public void setTurno(int turno) {
        this.turno=turno;
    }

    public ArrayList<Character> getlRuta() {
        return this.lRuta;
    }

    public void setlRuta(ArrayList<Character> lRuta) {
        this.lRuta = lRuta;
    }


    public void setIdCeldaActual(int idCeldaActual) {
        this.idCeldaActual=idCeldaActual;
    }

    public void setMarca(char marca) {
        this.marca=marca;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTurno() {
        return turno;
    }

    public int getIdCeldaActual() {
        return idCeldaActual;
    }

    public char getMarca() {
        return marca;
    }


    public abstract void realizarAcciones(PrintWriter escribidor);


}
