package eda1.practicas.auxiliar;

import java.util.Locale;

public class Format {
	
	public static String formatDouble(double v) { //Formatea una cadena de caracteres y deja 2 decimales
		return String.format(Locale.US, "%.2f", v);
	}

	public static String formatInt(int v) { //Toma un valor y llena de ceros hasta ser 3 digitos; v=1, 001
		return formatInt(v,3);
	}

	public static String formatInt(int v, int len) { //v=3, len=4; 0003
		return String.format(Locale.US, "%0" + len + "d", v);
	}
	
	public static String formatDouble(double v, int len) {
		return String.format(Locale.US, "%." + len + "f", v);
	}

}
