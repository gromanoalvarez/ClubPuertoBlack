package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClubPuertoBlack {

	@Test
	public void queSePuedaInstanciarUnYateAVela() {
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		assertNotNull(yateVela);
	}
	
	@Test
	public void queSePuedaInstanciarUnYateAMotor() {
		Yate yateMotor = new Motor("AZ1", "Adrés Borgeat", 18.87, 5.15, 119.0, 37, 5500, 5959, "2 × motores diésel MAN RK2805", 9000,23,6500);
		assertNotNull(yateMotor);
	}
	
	@Test
	public void queSePuedaCrearElFondeaderoConParametro() {
		Fondeadero nuevoFondeadero = new Fondeadero(70);
		assertNotNull(nuevoFondeadero);
	}
	
	@Test
	public void queSePuedaAmarrarYateEnFondeadero() throws noExisteAmarraDisponible{
		Fondeadero nuevoFondeadero = new Fondeadero(70);
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		try {
		assertTrue(nuevoFondeadero.amarrarYate(yateVela));
		}catch(noExisteAmarraDisponible sa) {
			System.err.println("No hay amarras disponibles");
		}
	}
	
	@Test (expected = noExisteAmarraDisponible.class)
	public void queNoSePuedaAmarrarYateYLanceExcepcion() throws noExisteAmarraDisponible{
		Fondeadero nuevoFondeadero = new Fondeadero(2);
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		Yate yateVela2 = new Vela("XXR2", "German", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		Yate yateMotor = new Motor("AZ1", "Adrés Borgeat", 18.87, 5.15, 119.0, 37, 5500, 5959, "2 × motores diésel MAN RK2805", 9000,23,6500);
		
		assertTrue(nuevoFondeadero.amarrarYate(yateVela));
		assertTrue(nuevoFondeadero.amarrarYate(yateVela2));
		assertFalse(nuevoFondeadero.amarrarYate(yateMotor));
	}
	
	@Test
	public void queSePuedaDesamarrarYate() throws noExisteAmarraDisponible{
		Fondeadero nuevoFondeadero = new Fondeadero(70);
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		
		try {
		assertTrue(nuevoFondeadero.amarrarYate(yateVela));
		}catch(noExisteAmarraDisponible sa) {
			System.err.println("No hay amarras disponibles");
		}
		
		assertTrue(nuevoFondeadero.desamarrarYate(yateVela));
	}
	
	@Test //4. obtenerCantidadDeYatesAmarrados: devuelve el total de amarras ocupadas.
	public void obtenerCantidadDeYatesAmarrados() {
		Fondeadero nuevoFondeadero = new Fondeadero(5);
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		Yate yateVela2 = new Vela("XXR2", "German", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		Yate yateMotor = new Motor("AZ1", "Adrés Borgeat", 18.87, 5.15, 119.0, 37, 5500, 5959, "2 × motores diésel MAN RK2805", 9000,23,6500);
		final Integer CANTIDAD_YATES_ESPERADOS=3;
		
		try {
		assertTrue(nuevoFondeadero.amarrarYate(yateVela));
		assertTrue(nuevoFondeadero.amarrarYate(yateVela2));
		assertTrue(nuevoFondeadero.amarrarYate(yateMotor));
		}catch(noExisteAmarraDisponible sa) {
			System.err.println("Sin Amarras disponibles");
		}finally {
			assertEquals(CANTIDAD_YATES_ESPERADOS, nuevoFondeadero.getCantidadDeAmarrasOcupadas());
		}
	}
	
	//5. obtenerCantidadDeAmarrasDisponibles: devuelve el total de amarras libres.
	@Test
	public void obtenerCantidadDeAmarrasDisponibles() {
		Fondeadero nuevoFondeadero = new Fondeadero(10);
		final Integer CANTIDAD_AMARRAS_DISPONIBLES=10;
		assertEquals(CANTIDAD_AMARRAS_DISPONIBLES, nuevoFondeadero.getCantidadDeAmarrasDisponibles());
		
		final Integer CANTIDAD_AMARRAS_DISPONIBLES_DOS=8;
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		Yate yateMotor = new Motor("AZ1", "Adrés Borgeat", 18.87, 5.15, 119.0, 37, 5500, 5959, "2 × motores diésel MAN RK2805", 9000,23,6500);
		try {
		assertTrue(nuevoFondeadero.amarrarYate(yateVela));
		assertTrue(nuevoFondeadero.amarrarYate(yateMotor));
		}catch(noExisteAmarraDisponible sa) {
			System.err.println("Sin Amarras disponibles");
		}
		assertEquals(CANTIDAD_AMARRAS_DISPONIBLES_DOS, nuevoFondeadero.getCantidadDeAmarrasDisponibles());
	}
	
	/*
	 * 			6. obtenerPrecioDeAmarre(Yate yate): 
	 * devuelve el importe en PESOS que debe abonar por la amarra mensualmente el dueño. 
	 * El costo mensual estará dado dos parámetros: tipo (Motor: $ 10.000 / Vela $ 9000) y Eslora (hasta 20 mts.: $2.000 y
		mayores a 20 mts.: $3.000).
	 */
	@Test
	public void obtenerPrecioDeAmarre() {
		Fondeadero nuevoFondeadero = new Fondeadero(10);
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		final Integer VALOR_ESPERADO_POR_VELA_ESLORA_MENOR_A_20_M=11000;
		Yate yateMotor = new Motor("AZ1", "Adrés Borgeat", 18.87, 5.15, 119.0, 37, 5500, 5959, "2 × motores diésel MAN RK2805", 9000,23,6500);
		final Integer VALOR_ESPERADO_POR_MOTOR_ESLORA_MENOR_A_20_M=13000;

		assertEquals(VALOR_ESPERADO_POR_VELA_ESLORA_MENOR_A_20_M, nuevoFondeadero.obtenerPrecioDeAmarre(yateVela));
		assertEquals(VALOR_ESPERADO_POR_MOTOR_ESLORA_MENOR_A_20_M, nuevoFondeadero.obtenerPrecioDeAmarre(yateMotor));
	}
	
	/*7. obtenerRecaudacionTotal: devuelve el total recaudado por la ocupación de amarras
	actual. */
	@Test 
	public void obtenerRecaudacionTotal() {
		Fondeadero nuevoFondeadero = new Fondeadero(10);
		Yate yateVela = new Vela("XXR", "Sebastián Pardo", 6.9, 2.7, 13.45, 5, 1400, 21.5, 85, 133);
		Yate yateMotor = new Motor("AZ1", "Adrés Borgeat", 18.87, 5.15, 119.0, 37, 5500, 5959, "2 × motores diésel MAN RK2805", 9000,23,6500);
		final Integer VALOR_TOTAL_ESPERADO=24000;
		
		try {
		assertTrue(nuevoFondeadero.amarrarYate(yateVela));
		assertTrue(nuevoFondeadero.amarrarYate(yateMotor));
		}catch(noExisteAmarraDisponible sa) {
			System.err.println("Sin Amarras disponibles");
		}
		
		assertEquals(VALOR_TOTAL_ESPERADO, nuevoFondeadero.getRecaudacionTotal());
	}

}
