import java.util.ArrayList;
import java.util.Collections;

public class Inventario {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	public String getLibros() {
		for(int i=0; i<libros.size(); i++) {
			System.out.println(libros.get(i));}
		return null;
	}
	public void almacenar(Libro libro) {
		libros.add(libro);}
	
	
}