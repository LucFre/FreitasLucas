package fecha;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Permite el guardado de fecha
 * @version 1.0
 * @author Lucas
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    /**
     * @param dia
     * @param mes
     * @param anio
     */
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Comprueba si la fecha es válida o no.
     * @return true si la fecha es válida
     */
    public boolean valida() {
        if (dia < 1 || dia > 31)
            return false;
        if (mes < 1 || mes > 12)
            return false;
        if (anio < 0)
            return false;
        // determinamos la cantidad de días del mes:
        int diasMes = diasMes();
        if (dia > diasMes)
            return false;
        else
            return true;
    }

    /**
     * Devuelve el número de días que tiene el mes.
     * @return entero correspondiente al número de días que tiene el mes.
     */
	private int diasMes() {
		int diasMes = 0;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diasMes = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasMes = 30;
                break;
            case 2: // verificación de año bisiesto
                if (bisiesto())
                    diasMes = 29;
                else
                    diasMes = 28;
                break;
        }
		return diasMes;
	}

	/**
	 * Comprueba si es un año bisiesto o no.
	 * @return true si es un año bisiesto
	 */
	private boolean bisiesto() {
		return (anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0));
	}
}
