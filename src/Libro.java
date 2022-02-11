public class Libro {
		private String isbn;
		private String titulo;
		private double precio;
		private int cantidad;

		public Libro(String isbn, String titulo, double precio, int cantidad) {
			this.isbn = isbn;
			this.titulo = titulo;
			this.precio = precio;
			this.cantidad = cantidad;
		}
		public Libro() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.isbn + " <> " + this.titulo + " <> " + this.cantidad + " <> $" + this.precio;
		} 
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Libro l = (Libro)obj;
			return this.isbn.equals(l.isbn);
		}
	}

