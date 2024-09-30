package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import General.CentralNuclear;
import General.Llave;
import General.Puerta;
import Characters.Bombero;
import Characters.Cientifico;
import Characters.Minero;
import Characters.Oficial;
import Characters.Robot;
import Characters.Voluntario;

public class Lectura {

    public static boolean cargarFichero() throws IOException, FileNotFoundException {
        FileReader arch_leer = null;
        BufferedReader lector = null;
        boolean todo_ok = true;
        String cadalin;
        int tipo;

        try {
            arch_leer = new FileReader("C:/Users/javie/JAVIER12/DAM/fp_programacion/inicio.txt");
            lector = new BufferedReader(arch_leer);

            cadalin = lector.readLine();
            if (cadalin == null) {
                todo_ok = false;
                System.out.println("El archivo está vacío.");
            } else {
                while (cadalin != null) {
                    if (!cadalin.startsWith("--")) {
                        tipo = queElemento(cadalin);
                        if (!crearObjeto(tipo, cadalin)) {
                            todo_ok = false;
                        }
                    }
                    cadalin = lector.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            todo_ok = false;
            System.out.println(e.getMessage());
        } catch (IOException e) {
            todo_ok = false;
            System.out.println(e.getMessage());
        } finally {
            if (lector != null) {
                lector.close();
            }
            if (arch_leer != null) {
                arch_leer.close();
            }
        }

        return todo_ok;
    }

    private static int queElemento(String linea) {
        String[] vector_tokens = linea.split("#");
        String tipo_de_Objeto = vector_tokens[0];

        switch (tipo_de_Objeto) {
            case "CENTRAL":
                return 0;
            case "CIENTIFICO":
                return 1;
            case "MINERO":
                return 2;
            case "BOMBERO":
                return 3;
            case "OFICIAL":
                return 4;
            case "VOLUNTARIO":
                return 5;
            case "ROBOT":
                return 6;
            case "LLAVE":
                return 7;
            case "PUERTA":
                return 8;
            default:
                return -1;
        }
    }

    private static boolean crearObjeto(int tipoElemento, String linea) {
        String[] vector_tokens = linea.split("#");


        switch (tipoElemento) {
            case 0:
                CentralNuclear.getInstancia().setTurnosNecesarios(Integer.parseInt(vector_tokens[1]));
                break;
            case 1:  // CIENTIFICO
                Cientifico cientifico = new Cientifico(vector_tokens[1], Integer.parseInt(vector_tokens[2]), Integer.parseInt(vector_tokens[3]), vector_tokens[4].charAt(0));
                cientifico.cargarMovimientos(vector_tokens[5].toCharArray());
                CentralNuclear.getInstancia().insPersonaje(cientifico);
                CentralNuclear.getInstancia().getListaPersonajes().add(cientifico);
                break;
            case 2: // MINERO
                Minero minero = new Minero(vector_tokens[1], Integer.parseInt(vector_tokens[2]), Integer.parseInt(vector_tokens[3]), vector_tokens[4].charAt(0));
                minero.cargarMovimientos(vector_tokens[5].toCharArray());
                CentralNuclear.getInstancia().insPersonaje(minero);
                CentralNuclear.getInstancia().getListaPersonajes().add(minero);
                break;
            case 3: // BOMBERO
                Bombero bombero = new Bombero(vector_tokens[1], Integer.parseInt(vector_tokens[2]), Integer.parseInt(vector_tokens[3]), vector_tokens[4].charAt(0));
                bombero.cargarMovimientos(vector_tokens[5].toCharArray());
                CentralNuclear.getInstancia().insPersonaje(bombero);
                CentralNuclear.getInstancia().getListaPersonajes().add(bombero);
                break;
            case 4:  // OFICIAL
                Oficial oficial = new Oficial(vector_tokens[1], Integer.parseInt(vector_tokens[2]), Integer.parseInt(vector_tokens[3]), vector_tokens[4].charAt(0));
                oficial.cargarMovimientos(vector_tokens[5].toCharArray());
                CentralNuclear.getInstancia().insPersonaje(oficial);
                CentralNuclear.getInstancia().getListaPersonajes().add(oficial);
                break;
            case 5:  // VOLUNTARIO
                Voluntario voluntario = new Voluntario(vector_tokens[1], Integer.parseInt(vector_tokens[2]), Integer.parseInt(vector_tokens[3]), vector_tokens[4].charAt(0));
                voluntario.cargarMovimientos(vector_tokens[5].toCharArray());
                CentralNuclear.getInstancia().insPersonaje(voluntario);
                CentralNuclear.getInstancia().getListaPersonajes().add(voluntario);
                break;
            case 6:  // ROBOT
                Robot robot = new Robot(vector_tokens[1], Integer.parseInt(vector_tokens[2]), Integer.parseInt(vector_tokens[3]), vector_tokens[4].charAt(0));
                CentralNuclear.getInstancia().insPersonaje(robot);
                CentralNuclear.getInstancia().getListaPersonajes().add(robot);
                robot.descifrar(vector_tokens[5]);;
                break;

            case 7:  // LLAVE
                Llave llave = new Llave(Integer.parseInt(vector_tokens[1]), Integer.parseInt(vector_tokens[2]));
                CentralNuclear.getInstancia().insLlave(llave);
                break;
            case 8:  // PUERTA
                Puerta puerta = new Puerta(Integer.parseInt(vector_tokens[1]), Integer.parseInt(vector_tokens[2]));
                CentralNuclear.getInstancia().insPuertaSalida(puerta);
                break;
            default:
                return false;
        }

        return true;
    }
}
