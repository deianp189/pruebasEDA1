package eda1.practicas.practica01;

import eda1.practicas.auxiliar.Format;

import java.util.ArrayList;

public class Cita {
	private static int numCitas = 0;
	private final int citaId;
	private final ArrayList<String> valoraciones;

	public static void inicializaNumCitas() {
		numCitas = 0;
	}

	// Inicializamos los atributos this.citaId (cada vez que se crea una cita
	// incrementamos
	// en 1 el atributo estático numCitas, empezando por 1) y this.valoraciones
	// 2 líneas
	public Cita() {
		this.citaId = ++numCitas;
		this.valoraciones = new ArrayList<String>();

	}

	// Igual que el anterior, aunque tenemos en cuenta que el identificador de cita
	// se pasa como parámetro;
	// En este caso no hay que asignar espacio a this.valoraciones (== null)
	// 2 líneas
	public Cita(int citaId) {
		this.citaId = citaId;
		this.valoraciones = null;
	}

	public int getCitaId() {
		return this.citaId;
	}

	// Devolvemos false si el parámetro valoracion es nulo o está vacío
	// En caso contrario añadimos la valoración a nuestra colección (cuidado con las
	// mayúsculas y minúsculas, así como los espacios iniciales y finales de la
	// cadena)
	// Consulta el uso de los métodos toLowerCase() y trim()
	public boolean addValoracion(String valoracion) {
		if (valoracion == null || valoracion.isEmpty())
			return false;
		valoraciones.add(valoracion.trim().toLowerCase());
		return true;
	}

	// Devolvemos false si el parámetro palabra es nulo o está vacío
	// Cuidado con las mayúsculas y minúsculas, así como los espacios iniciales y
	// finales de la cadena
	// 1 for() tipo forEach ¿+ break?
	public boolean contienePalabra(String palabra) {
		if (palabra == null || palabra.isEmpty())
			return false;
		String palabraTransormada = palabra.trim().toLowerCase();
		for (String s : valoraciones) {
			if (s.contains(palabraTransormada)) {
				return true;
			}

		}
		return false;
	}

	public void clear() {
		this.valoraciones.clear();
	}

	// Observad el formato de salida que muestra el test: #0001, #0002. Se le añaden
	// tantos ceros a la izquierda como sean necesarios hasta rellenar una cadena
	// con 4 dígitos
	// Para temas de formato vamos a hacer uso de los métodos de la clase Format que
	// encontraréis en la carpeta auxiliar;
	// Escribe correctamente la siguiente línea
	@Override
	public String toString() {
		return "Cita #" + Format.formatInt(this.citaId, 4) + " -> "
				+ (this.valoraciones == null || this.valoraciones.isEmpty() ? "<sin texto>"
						: this.valoraciones.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Cita))
			return false;
		return this.citaId == ((Cita) o).citaId;
	}
}