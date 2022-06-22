package ar.edu.unlam.pb2;

public class Vela extends Yate {

	private Double alturaMastil;
	private Integer superficieVelicaMayor;
	private Integer superficieTotal;

	public Vela(String nombre, String due�o, Double mangaAncho, Double calado, Double esloraLargo, Integer tripulaci�n,
			Integer peso, Double alturaMastil, Integer superficieVelicaMayor, Integer superficieTotal) {
		super(nombre, due�o, mangaAncho, calado, esloraLargo, tripulaci�n, peso);
		this.alturaMastil=alturaMastil;
		this.superficieVelicaMayor=superficieVelicaMayor;
		this.superficieTotal=superficieTotal;
	}

	public Double getAlturaMastil() {
		return alturaMastil;
	}

	public void setAlturaMastil(Double alturaMastil) {
		this.alturaMastil = alturaMastil;
	}

	public Integer getSuperficieVelicaMayor() {
		return superficieVelicaMayor;
	}

	public void setSuperficieVelicaMayor(Integer superficieVelicaMayor) {
		this.superficieVelicaMayor = superficieVelicaMayor;
	}

	public Integer getSuperficieTotal() {
		return superficieTotal;
	}

	public void setSuperficieTotal(Integer superficieTotal) {
		this.superficieTotal = superficieTotal;
	}

	@Override
	public String toString() {
		return "Yate a Vela \n Nombre: " + super.getNombre() + " Due�o: " + super.getDue�o();
	}

	
}
