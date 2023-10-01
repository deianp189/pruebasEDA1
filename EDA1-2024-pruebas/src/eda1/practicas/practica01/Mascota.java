package eda1.practicas.practica01;

import java.util.Iterator;
import java.util.LinkedList;

public class Mascota implements Comparable<Mascota>, Iterable<Cita> {
	private final String nombre;
	private final String especie;
	private final LinkedList<Cita> historial;

	// Si nombre es nulo o está vacío, la mascota se llamará "sinNombre"; igual con
	// el atributo especie
	// Atención a las mayúsculas, minúsculas y espacios en blanco (delante y detrás
	// del texto)
	// 3 líneas
	public Mascota(String nombre, String especie) {
		this.nombre = (nombre == null || nombre.isEmpty() ? "sinNombre" : nombre.trim().toLowerCase());
		this.especie = (especie == null || especie.isEmpty() ? "sinEspecie" : especie.trim().toLowerCase());
		this.historial = new LinkedList<Cita>();
	}

	// Creamos una nueva cita y, por comodidad, devolvemos su referencia para poder
	// añadir valoraciones
	// 3 líneas
	public Cita addCita() {		
		this.historial.add(new Cita());
		return this.historial.getLast();
	}

	// Si el parámetro citaId es menor que cero, se devuelve null
	// Tendremos que buscar la cita con identificador citaId en la colección
	// historial.
	// Para buscar un elemento en una colección tipo LinkedList<T> hacemos uso del
	// método indexOf(), ¿verdad? (nada de iterar para buscar un elemento, ¡uf!)
	// 3 líneas
	public Cita getCita(int citaId) {
		if (citaId < 0)
			return null;
		int index = historial.indexOf(new Cita(citaId));
		return index == -1 ? null : this.historial.get(index);
	}

	// 1 for() tipo forEach
	public void clear() {
		for (Cita cita : historial) {
			cita.clear();
		}
		this.historial.clear();
	}

	public int size() {
		return this.historial.size();
	}

	// Habría que tener en cuenta que solo se escribe "cita" (sin s) si el tamaño
	// del historial es igual a 1; en caso contrario, se escribe "citas"
	// 0 citas, 2 citas, etc. etc.
	// Completa la siguiente línea
	@Override
	public String toString() {
		return this.nombre + " <" + this.especie + "> [" + historial.size()
				+ (historial.size() == 1 ? " cita]" : " citas]");
	}

	public String toStringExtended() {
		return this.toString() + ": " + this.historial.toString();
	}

	// Orden natural: clave principal -> nombre (ascendente); clave secundaria ->
	// especie (ascendente)
	// 2 líneas
	@Override
	public int compareTo(Mascota other) {
		int cmp = this.nombre.compareTo(other.nombre);
		return cmp != 0 ? cmp : this.especie.compareTo(other.especie);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Mascota))
			return false;
		return this.compareTo((Mascota) other) == 0;
	}

	// Iterar sobre 1 mascota equivale a iterar sobre la colección this.historial
	// (sus citas)
	@Override
	public Iterator<Cita> iterator() {
		return this.historial.iterator();
	}
}