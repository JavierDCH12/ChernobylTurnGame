package Characters;

import General.Celda;
import General.CentralNuclear;
import General.Constantes;

import java.io.PrintWriter;
import java.util.ArrayList;

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



    public void mover(PrintWriter escribidor) {
        CentralNuclear central = CentralNuclear.getInstancia();


        int posicion_actual = this.idCeldaActual;
        int posicion_siguiente = calcularSiguienteIdCelda();

        if (central.hayCamino(posicion_actual, posicion_siguiente)) {
            Celda celdaActual = central.getCelda(Utilidad.calcularFila(posicion_actual), Utilidad.calcularColumna(posicion_actual));
            Celda celdaSiguiente = central.getCelda(Utilidad.calcularFila(posicion_siguiente), Utilidad.calcularColumna(posicion_siguiente));

            celdaActual.borrarPersonajePorNombre(this.getNombre());

            setIdCeldaActual(posicion_siguiente);

            celdaSiguiente.insPersonaje(this);


        }else {
            escribidor.println(this.getNombre() + Constantes.NO_PUEDO + Constantes.PARENTESIS1 + (this.lRuta.get(0)) + Constantes.PARENTESIS2);


        }
        borrarPrimerMovimiento();

    }

    public void cargarMovimientos(char[] movimientos) {
        for (char movimiento : movimientos) {
            lRuta.add(movimiento);

        }
    }

    public void borrarPrimerMovimiento() {
        try {
            lRuta.remove(0);
        }
        catch(IndexOutOfBoundsException e) {

        }
    }

    public void añadirMovimiento(char movimiento) {
        lRuta.add(movimiento);
    }

    public boolean estaVacia() {
        return lRuta.isEmpty();

    }

    public int calcularSiguienteIdCelda() {
        int siguienteCelda = -1;



        if(!estaVacia()) {
            char primerMovimiento = lRuta.get(0);
            if (primerMovimiento == 'N') {
                siguienteCelda = idCeldaActual - 8;
            } else if (primerMovimiento == 'S') {
                siguienteCelda = idCeldaActual + 8;
            } else if (primerMovimiento == 'E') {
                siguienteCelda = idCeldaActual + 1;
            } else if (primerMovimiento == 'O') {
                siguienteCelda = idCeldaActual - 1;
            }

        }

        return siguienteCelda;


    }



    @Override
    public String toString() {
        return nombre+ Constantes.ESTA_EN_CELDA + idCeldaActual + Constantes.ES_TURNO+ turno+ Constantes.LA_MARCA+ marca ;
    }





}
