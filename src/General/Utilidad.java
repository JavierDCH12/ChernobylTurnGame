package General;

import java.util.Calendar;

public class Utilidad {

    public static int calcularFila(int identificador_celda) {

        return identificador_celda / Constantes.COLUMNAS;
    }


    public static int calcularColumna(int identificador_celda) {

        return identificador_celda % Constantes.COLUMNAS;
    }

    public static String generarNombreArchivo(String tipoArchivo) {
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;

        String nombreArchivo = tipoArchivo + "_" + dia + mes+ ".log";
        return nombreArchivo;
    }
}
