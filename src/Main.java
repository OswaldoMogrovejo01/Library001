
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	private static ArrayList<Libro> librosAltos = new ArrayList<Libro>();
	
	private static Scanner leer = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\n***jjjjMENU DE OPCIONES***\n");
		System.out.println("<1> INGRESAR LIBRO\n"+"<2> BUSCAR LIBRO POR ISNB\n"+
		"<3> VENTA DE LIBRO\n"+"<4> MOSTRAR LOS TRES LIBROS MAS CAROS\n"+
		"<5> MOSTRAR TODOS LOS LIBROS\n"+"<6> SALIR DEL MENU");
		menu();
	}

	public static void menu() {
		System.out.print("INGRESE UNA OPCION: \n");
		int opcion = leer.nextInt();
		switch(opcion)
		{
		   case 1 :
			   insertarLibros();
			   menu();
		      break;
		   case 2 :
			   leer = new Scanner(System.in);
			   System.out.println("Ingrese codigo del Libro");
			   String codigo = leer.nextLine();
			   Libro encontrado= GetLibrobyIsbn(codigo);
			   System.out.println(encontrado);
			   menu();
		      break;
		   
		   case 3 :
			   leer = new Scanner(System.in);
			   System.out.println("Ingrese codigo del Libro");
			   String codigoI = leer.nextLine();
			   System.out.println("Ingrese el precio del libro");
			   int cantidad = leer.nextInt();
			   venderLibros(codigoI,cantidad);
			   menu();
		      break;
		      
		   case 4 :
			   ordenarPrecios();
			   for (int i = 0; i < 3; i++) {
				   System.out.println(ObtenerlibrosAltos().get(i));
			   }
			   menu();
		      break;
		   case 5 :
			   ListaTemporal();
			   menu();
		      break;
		     
		   case 6 :
			   System.out.println("Salio DEL MENU");
		      break;
		   default : 
		      
		}	
	}
	
	public static void insertarLibros() {
		ArrayList<Libro> libros = ListaTemporal();
        Libro nuevolibro = new Libro();
		System.out.println("Digite el código del libro:\n");
		leer.nextLine();
		
        nuevolibro.setIsbn(leer.nextLine());
		System.out.println("Digite el titulo del libro:\n");
		nuevolibro.setTitulo(leer.nextLine());		
		System.out.println("Digite el precio del libro:\n");
		nuevolibro.setPrecio(leer.nextDouble());		
		System.out.println("Digite la cantidad de libros:");
		nuevolibro.setCantidad(leer.nextInt());
		boolean activo = false;
		for (Libro l: libros) {			
			if(l.getIsbn().equals(nuevolibro.getIsbn())) {
				System.out.println("Ya esta ingresado su libro");
				activo = true;
			}		
		}
		if(activo == false) {
			nuevolibro = new Libro(nuevolibro.getIsbn(), nuevolibro.getTitulo(), nuevolibro.getPrecio(), nuevolibro.getCantidad());
			libros.add(nuevolibro);
			for (Libro l: libros) {			
				System.out.println(l);
			}
		}
	}
	
	/*CREO CATALOGO DE LIBROS*/
	
	public static ArrayList<Libro> ListaTemporal() {
		Libro l1 = new Libro("001", "titulo 1", 10, 3);
		Libro l2 = new Libro("002", "titulo 2", 24, 4);
		Libro l3 = new Libro("003", "titulo 3", 21, 2);
		Libro l4 = new Libro("004", "titulo 4", 4, 1);
		Libro l5 = new Libro("005", "titulo 5", 5, 1);
		libros.add(l1);
		libros.add(l2);
		libros.add(l3);
		libros.add(l4);
		libros.add(l5);
		return libros;
	} 
	
	
	public static Libro GetLibrobyIsbn(String isbn) {
		ListaTemporal();
		for (Libro l : libros) {
			if (l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}

	public static void venderLibros(String isbn, int cantidad) {
		if (GetLibrobyIsbn(isbn) == null) {
			System.out.println("\nEl codigo ingresado no existe\n");
		} else if (GetLibrobyIsbn(isbn).getCantidad() >= cantidad) {
			System.out.println("\nVenta del libro: " + GetLibrobyIsbn(isbn).getTitulo());
			System.out.println("Total a pagar: $" + GetLibrobyIsbn(isbn).getPrecio() * cantidad);
			GetLibrobyIsbn(isbn).setCantidad((GetLibrobyIsbn(isbn).getCantidad() - cantidad));
			if (GetLibrobyIsbn(isbn).getCantidad() == 0) {
				System.out.println("Con esta venta se agota el libro");
				libros.remove(libros.indexOf(GetLibrobyIsbn(isbn)));
			}
		} else if (GetLibrobyIsbn(isbn).getCantidad() < cantidad) {
			System.out.println("\nSolo hay " + GetLibrobyIsbn(isbn).getCantidad() + " unidades\n");
		}
	}

	public static void ordenarPrecios() {
		ListaTemporal();
		librosAltos = new ArrayList<Libro>();
		for(int i=0; i<libros.size(); i++) {
			librosAltos.add(libros.get(i));
		}
		Collections.sort(librosAltos, new PrecioMayor());
	}
	public static ArrayList<Libro> ObtenerlibrosAltos() {
		ArrayList<Libro> resultado = new ArrayList<Libro>();
		for(int i=0; i<3; i++) {
			resultado.add(librosAltos.get(i));
		}
		return resultado;
	}

}
