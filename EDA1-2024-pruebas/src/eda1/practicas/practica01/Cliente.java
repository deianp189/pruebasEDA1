package eda1.practicas.practica01;

import eda1.practicas.auxiliar.Format;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	private static int numClientes = 0;
	private final String nombre;
	private final ArrayList<Mascota> mascotas;

	public static void inicializaNumClientes() {
		numClientes = 0;
	}

	public Cliente(String nombre) {
		this.nombre = Format.formatInt(++numClientes, 5) + ".- "
				+ (nombre == null || nombre.isEmpty() ? "sinNombre" : nombre);
		this.mascotas = new ArrayList<>();
	}

	// Devolvemos false si la mascota ya existe en this.mascotas; en caso contrario,
	// se añade y fin (true)
	// Hacemos uso de indexOf()
	// 4 líneas
	// if(this.mascotas.contains(new Mascota(nombre, null)) return false;
	public boolean addMascota(String nombre, String especie) {
		if (this.mascotas.indexOf(new Mascota(nombre.trim().toLowerCase(), especie.trim().toLowerCase())) != -1)
			return false;
		this.mascotas.add(new Mascota(nombre.trim(), especie.toLowerCase()));
		return true;
	}

	// Se añade una nueva cita (devolviendo su referencia)
	// Si este cliente no tiene la mascota con clave (nombre, especie) --> se
	// devuelve null
	// 2 líneas

	public Cita addCita(String nombre, String especie) {

		int index = this.mascotas.indexOf(new Mascota(nombre.trim().toLowerCase(), especie.trim().toLowerCase()));
		return (index != -1) ? this.mascotas.get(index).addCita() : null;

	}

	public void clear() {
		for (Mascota mascota : mascotas) {
			mascota.clear();
		}
		this.mascotas.clear();
	}

	public int size() {
		return this.mascotas.size();
	}
	// Hacemos uso de estas dos variables locales
	// 2 for() anidados tipo forEach
	// En el primer for() se itera sobre las mascotas y, para cada mascota, se itera
	// sobre las citas

	public ArrayList<ArrayList<Integer>> getCitasId() {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> aux;

		for (Mascota m : this.mascotas) {
			aux = new ArrayList<Integer>();
			for (Cita c : m) {
				aux.add(c.getCitaId());
			}
			result.add(aux);
		}
		return result;
	}

	// Hacemos uso de estas dos variables locales
	// 2 for() anidados tipo forEach
	// Muy similar al anterior, solo que en este caso queremos únicamente las citas
	// que incluyan entre sus valoraciones la palabra que se indica como parámetro
	// de entrada
	public ArrayList<ArrayList<Integer>> getCitasId(String palabra) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> aux;

		String palabraTransformada = palabra.trim().toLowerCase();
		for (Mascota m : this.mascotas) {
			aux = new ArrayList<Integer>();
			for (Cita c : m) {
				if (c.contienePalabra(palabraTransformada))
					aux.add(c.getCitaId());
			}
			result.add(aux);
		}
		return result;
	}

	// Si la mascota con clave (nombre, especie) no existe, se devuelve null;
	public ArrayList<Integer> getCitasId(String nombre, String especie) {

		ArrayList<Integer> result = new ArrayList<>();

		if (nombre == null && especie == null) {
			return null;
		}
		int pos = mascotas.indexOf(new Mascota(nombre, especie));
		if (pos == -1)
			return null;
		// 1 for() tipo forEach
		for (Cita c : this.mascotas.get(pos)) {
			result.add(c.getCitaId());
		}

		return result;
	}

	// 1 for()
	// Interesa el uso de break, ¿verdad?
	public Cita getCita(int citaId) {
		Cita result = null;

		for (Mascota m : this.mascotas) {
			for (Cita c : m) {
				if (c.getCitaId() == citaId) {
					result = c;
					break;
				}
			}
			if (result != null) {
				break;
			}
		}
		return result;
	}

	// 1 for() con 1 único if
	public Mascota getMascota(int citaId) {

		Mascota result = null;
		for (Mascota m : this.mascotas) {
			for (Cita c : m) {
				if (c.getCitaId() == citaId) {
					result = m;
					break;
				}
			}
			if (result != null) {
				break;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return this.nombre + " -> " + this.mascotas.toString();
	}

	// 1 for() tipo forEach
	// Hacemos uso del método toStringExtended() de mascota
	// Cuidado con la última coma...

	public String toStringExtended() {
		String result = this.nombre + " -> {";

		for (Mascota m : this.mascotas) {
			result += m.toStringExtended() + ", ";
		}
		result = result.substring(0, result.length() - 2);

		return result + "}";
	}

	// Repasa el código que se proporciona; es esencial que lo entiendas a la
	// perfección, línea a línea...
	public boolean load(String nombreArchivo) {

		Scanner scan;
		try {
			scan = new Scanner(new File(nombreArchivo));
		} catch (Exception e) {
			return false;
		}
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			if (linea.isEmpty())
				continue;
			if (linea.startsWith("%"))
				continue;
			String[] items = linea.split("[ ]+");
			int posInicial = items[0].isEmpty() ? 1 : 0;
			Mascota mascota = new Mascota(items[posInicial], items[posInicial + 1]);
			if (this.mascotas.indexOf(mascota) != -1)
				continue;
			this.mascotas.add(mascota);
			for (int i = 0; i < Integer.valueOf(items[posInicial + 2]); i++) {
				mascota.addCita();
			}
		}

		scan.close();
		return true;
	}
}