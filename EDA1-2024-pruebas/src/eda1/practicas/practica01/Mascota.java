package eda1.practicas.practica01;

import java.util.Iterator;
import java.util.LinkedList;

public class Mascota implements Comparable<Mascota>, Iterable<Cita> {
    private final String nombre;
    private final String especie;
    private final LinkedList<Cita> historial;

    public Mascota(String nombre, String especie) {
        //Si nombre es nulo o está vacío, la mascota se llamará "sinNombre"; igual con el atributo especie
        //Atención a las mayúsculas, minúsculas y espacios en blanco (delante y detrás del texto)
        //3 líneas
    	this.nombre = (nombre == null || nombre.isEmpty() ? "sinNombre" : nombre.trim().toLowerCase());
    	this.especie = (especie == null || nombre.isEmpty() ? "sinNombre" : especie.trim().toLowerCase());
    	this.historial=new LinkedList<Cita>();
    }	

    public Cita addCita() {
        //Creamos una nueva cita y, por comodidad, devolvemos su referencia para poder añadir valoraciones
        //3 líneas
    	Cita nuevaCita = new Cita();
    	this.historial.add(nuevaCita);
    	return nuevaCita;
    	
    }

    public Cita getCita(int citaId) {
        //Si el parámetro citaId es menor que cero, se devuelve null
    	//Tendremos que buscar la cita con identificador citaId en la colección historial.
        //Para buscar un elemento en una colección tipo LinkedList<T> hacemos uso del método indexOf(), ¿verdad? (nada de iterar para buscar un elemento, ¡uf!)
        //3 líneas
    	if(citaId<0) return null;
    	int index = historial.indexOf(new Cita());
    	return index==-1 ? null : historial.get(index);
    }

    public void clear() {
        //1 for() tipo forEach
        this.historial.clear();
    }

    public int size() {
        return this.historial.size();
    }
    
//    Mascota mascota02 = new Mascota("loLO", "perro");
//    assertNotNull(mascota02.addCita());
//    assertEquals("lolo <perro> [1 cita]", mascota02.toString());

    @Override
    public String toString() {
        //Habría que tener en cuenta que solo se escribe "cita" (sin s) si el tamaño del historial es igual a 1; en caso contrario, se escribe "citas"
        //0 citas, 2 citas, etc. etc.
        //Completa la siguiente línea
        return this.nombre + " <" + this.especie + "> [" +  historial.size() + (historial.size() == 1 ? " cita]" : " citas]");
    }

    public String toStringExtended() {
        return this.toString() + ": " + this.historial.toString();
    }

    @Override
    public int compareTo(Mascota other) {
        //Orden natural: clave principal -> nombre (ascendente); clave secundaria -> especie (ascendente)
        //2 líneas
    	//...
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (!(other instanceof Mascota)) return false;
        return this.compareTo((Mascota)other) == 0; //Hacemos uso del método compareTo()
    }

    @Override
    public Iterator<Cita> iterator() {
        //Iterar sobre 1 mascota equivale a iterar sobre la colección this.historial (sus citas)
        return //...
    }
}