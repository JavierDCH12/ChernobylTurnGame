package General;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Files.Escritura;
import Files.Lectura;
import Characters.Bombero;
import Characters.Cientifico;
import Characters.Minero;
import Characters.Oficial;
import Characters.Personaje;
import Characters.Robot;
import Characters.Voluntario;

public class TestMain {

    public static void tratamientoPersonaje(Personaje personaje, PrintWriter pw) {
        CentralNuclear central = CentralNuclear.getInstancia();
        int turnoP = personaje.getTurno();
        if (turnoP == central.getTurno()) {
            personaje.realizarAcciones(pw);
            personaje.setTurno(turnoP + 1);
        }
    }

    public static void simulacion() throws IOException{
        Personaje personajeEnTratamiento;
        CentralNuclear central = CentralNuclear.getInstancia();

        //Abrimos flujos para escritura de fichero simulación
        FileWriter arch_escribir = Escritura.abrirArchivoEscritura(Constantes.SIMULACION);
        PrintWriter escribidor = Escritura.abrirFlujoEscritura(arch_escribir);

        //ESCOMBROS
        central.inicializarEscombros();

        escribidor.println(Constantes.TURNO_SIMUL+central.getTurno());
        central.pintarMatriz(escribidor);
        //SIMULACIÖN
        for(int i = 0;i < central.getTurnosNecesarios();i++){
            central.setTurno(central.getTurno()+1);

            escribidor.println(Constantes.TURNO_SIMUL+central.getTurno());

            for(int j = 0;j < central.longitudListaPersonajesCentral();j++){
                personajeEnTratamiento = central.getPersonajeCentral(j);
                tratamientoPersonaje(personajeEnTratamiento, escribidor);
            }

            central.pintarMatriz(escribidor);
        }
        Escritura.cerrarFlujos(arch_escribir, escribidor);
        Escritura.escribirInformesEnFicheroLog();
    }

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        boolean cargado;
        cargado = Lectura.cargarFichero();
        if  (cargado){
            simulacion();
            System.out.println(Constantes.MENSAJEOK);
        }
    }


}

