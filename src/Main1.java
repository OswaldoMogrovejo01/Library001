import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	private static ArrayList<Libro> librosAltos = new ArrayList<Libro>();
	
	private static Scanner leer = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\n***MENU DE OPCIONES***\n");
		System.out.println("<1> INGRESAR LIBRO\n"+"<2> BUSCAR LIBRO POR ISNB\n"+
		"<3> VENTA DE LIBRO\n"+"<4> MOSTRAR LOS TRES LIBROS MAS CAROS\n"+
		"<5> MOSTRAR TODOS LOS LIBROS\n"+"<6> SALIR DEL MENU");
		//menu();
	}

}
