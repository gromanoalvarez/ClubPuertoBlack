package ar.edu.unlam.pb2;

public class Yate {
	private String nombre;
	private String due�o;
	private Double mangaAncho;
	private Double calado;
	private Double esloraLargo;
	private Integer tripulaci�n;
	private Integer peso;
	private Integer precioDeAmarre;
	
	public Yate (String nombre,
		String due�o,
		Double mangaAncho,
		Double calado,
		Double esloraLargo,
		Integer tripulaci�n,
		Integer peso) {
		this.nombre=nombre;
		this.due�o=due�o;
		this.mangaAncho=mangaAncho;
		this.calado=calado;
		this.esloraLargo=esloraLargo;
		this.tripulaci�n=tripulaci�n;
		this.peso=peso;
		precioDeAmarre=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDue�o() {
		return due�o;
	}

	public void setDue�o(String due�o) {
		this.due�o = due�o;
	}

	public Double getMangaAncho() {
		return mangaAncho;
	}

	public void setMangaAncho(Double mangaAncho) {
		this.mangaAncho = mangaAncho;
	}

	public Double getCalado() {
		return calado;
	}

	public void setCalado(Double calado) {
		this.calado = calado;
	}

	public Double getEsloraLargo() {
		return esloraLargo;
	}

	public void setEsloraLargo(Double esloraLargo) {
		this.esloraLargo = esloraLargo;
	}

	public Integer getTripulaci�n() {
		return tripulaci�n;
	}

	public void setTripulaci�n(Integer tripulaci�n) {
		this.tripulaci�n = tripulaci�n;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Yate [nombre=" + nombre + ", due�o=" + due�o + "]";
	}

	public Integer setPrecioDeAmarre(Integer precioDeAmarre) {
		this.precioDeAmarre=precioDeAmarre;
		return this.precioDeAmarre;
	}

	public Integer getPrecioDeAmarre() {
		return precioDeAmarre;
	}

	
	
}
