package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import General.CentralNuclear;
import General.Constantes;
import General.Utilidad;
import Characters.Minero;
import Characters.Personaje;
import Characters.Robot;

public class Escritura {

    public static FileWriter abrirArchivoEscritura(String tipoArchivo) throws IOException {
        String nombre = Utilidad.generarNombreArchivo(tipoArchivo);
        return new FileWriter(nombre);
    }

    public static PrintWriter abrirFlujoEscritura(FileWriter arch_escribir) {
        return new PrintWriter(arch_escribir);
    }

    public static void cerrarFlujos(FileWriter arch_escribir, PrintWriter escribidor) {
        try {
            if (escribidor != null) {
                escribidor.close();
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar el flujo de PrintWriter: " + e.getMessage());
        }

        try {
            if (arch_escribir != null) {
                arch_escribir.close();
            }
        } catch (IOException e) {
            System.err.println("Error al cerrar el flujo de FileWriter: " + e.getMessage());
        }
    }

    public static void generarInformeMineros(PrintWriter escribidor) {
        CentralNuclear central = CentralNuclear.getInstancia();
        ArrayList<Personaje> listaPersonajes = central.getListaPersonajes();
        Minero minero;
        escribidor.println(Constantes.INFORMEMINEROS);
        for (Personaje personaje : listaPersonajes) {
            if (personaje instanceof Minero) {
                minero = (Minero) personaje;
                minero.mostrarTotalEscombros(escribidor);
            }
        }
    }

    public static void generarInformeRobots(PrintWriter escribidor) {
        CentralNuclear central = CentralNuclear.getInstancia();
        ArrayList<Personaje> listaPersonajes = central.getListaPersonajes();
        Robot robot;
        escribidor.println(Constantes.INFORMEROBOTS);
        for (Personaje personaje : listaPersonajes) {
            if (personaje instanceof Robot) {
                robot = (Robot) personaje;
                robot.mostrarCeldasvisitadas(escribidor);
            }
        }
        escribidor.println();

    }

    public static void escribirInformesEnFicheroLog() {
        CentralNuclear central = CentralNuclear.getInstancia();

        FileWriter arch_escribir = null;
        PrintWriter escribidor = null;

        try {
            arch_escribir = abrirArchivoEscritura(Constantes.INFORMES);
            escribidor = abrirFlujoEscritura(arch_escribir);

            escribidor.println(Constantes.INFORMEBOMBEROS);
            central.mostrarCeldasRefrigeradas(escribidor);  // Informe celdas refrigeradas
            generarInformeMineros(escribidor); // Informe de Mineros
            generarInformeRobots(escribidor); // Informe de Robots

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrarFlujos(arch_escribir, escribidor);
        }
    }
}
