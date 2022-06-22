package ar.edu.unlam.pb2;

public class Yate {
	private String nombre;
	private String dueño;
	private Double mangaAncho;
	private Double calado;
	private Double esloraLargo;
	private Integer tripulación;
	private Integer peso;
	private Integer precioDeAmarre;
	
	public Yate (String nombre,
		String dueño,
		Double mangaAncho,
		Double calado,
		Double esloraLargo,
		Integer tripulación,
		Integer peso) {
		this.nombre=nombre;
		this.dueño=dueño;
		this.mangaAncho=mangaAncho;
		this.calado=calado;
		this.esloraLargo=esloraLargo;
		this.tripulación=tripulación;
		this.peso=peso;
		precioDeAmarre=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDueño() {
		return dueño;
	}

	public void setDueño(String dueño) {
		this.dueño = dueño;
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

	public Integer getTripulación() {
		return tripulación;
	}

	public void setTripulación(Integer tripulación) {
		this.tripulación = tripulación;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Yate [nombre=" + nombre + ", dueño=" + dueño + "]";
	}

	public Integer setPrecioDeAmarre(Integer precioDeAmarre) {
		this.precioDeAmarre=precioDeAmarre;
		return this.precioDeAmarre;
	}

	public Integer getPrecioDeAmarre() {
		return precioDeAmarre;
	}

	
	
}
