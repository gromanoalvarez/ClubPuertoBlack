package ar.edu.unlam.pb2;

public class Fondeadero {

	private Integer cantidadMaximaDeAmarras, cantidadDeAmarrasOcupadas;
	private Yate[] amarras;

	public Fondeadero(Integer cantidadMaximaDeAmarras) {
		this.cantidadMaximaDeAmarras = cantidadMaximaDeAmarras;
		amarras= new Yate[cantidadMaximaDeAmarras];
		cantidadDeAmarrasOcupadas=0;
	}

	public Boolean amarrarYate(Yate yate) throws noExisteAmarraDisponible{
		for(int i=0; i<amarras.length;i++) {
			if(amarras[i] == null) {
				amarras[i]=yate;
				cantidadDeAmarrasOcupadas++;
				return true;
			}
		}
		throw new noExisteAmarraDisponible();
	}

	public Boolean desamarrarYate(Yate yate) {
		for (int i = 0; i < amarras.length; i++) {
			if(amarras[i].getNombre().equals(yate.getNombre())) {
				amarras[i]=null;
				cantidadDeAmarrasOcupadas--;
				return true;
			}
		}
		return false;
	}

	public Integer getCantidadDeAmarrasOcupadas() {
		return cantidadDeAmarrasOcupadas;
	}

	public Integer getCantidadDeAmarrasDisponibles() {
		return (cantidadMaximaDeAmarras-cantidadDeAmarrasOcupadas);
	}

	public Integer obtenerPrecioDeAmarre(Yate yate) {
		if(yate instanceof Vela && yate.getEsloraLargo()<=20.0) return yate.setPrecioDeAmarre(9000+2000);
		else if(yate instanceof Vela && yate.getEsloraLargo()>20.0) return yate.setPrecioDeAmarre(9000+3000);
		else if(yate instanceof Motor && yate.getEsloraLargo()<=20.0) return yate.setPrecioDeAmarre(10000+2000);
		else if(yate instanceof Motor && yate.getEsloraLargo()>20.0) return yate.setPrecioDeAmarre(10000+3000);
		return 0;		
	}

	public Integer getRecaudacionTotal() {
		Integer recaudacionTotal=0;
		for(int i=0; i<amarras.length;i++) {
			if(amarras[i] != null) {
				recaudacionTotal+=obtenerPrecioDeAmarre(amarras[i]);
			}
		}
		return recaudacionTotal;		
	}
	
	
	
}
