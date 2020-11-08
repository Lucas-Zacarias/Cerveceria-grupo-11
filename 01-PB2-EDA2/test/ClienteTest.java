import static org.junit.Assert.*;

import org.junit.Test;

import cerveceria.Cliente;

public class ClienteTest {

	@Test
	public void testQueSePuedaCrearUnCliente() {
		Cliente cliente = new Cliente("Alejandro", 18);
		
		assertNotNull(cliente);
	}

	@Test
	public void queLosDatosDeUnClienteSeanLosEsperados() {
		Cliente cliente = new Cliente("Alejandro", 18);
		
		String nombreEsperado = "Alejandro";
		String nombreObtenido = cliente.getNombre();
		
		assertEquals(nombreEsperado, nombreObtenido);
		
		Integer edadEsperada = 18;
		Integer edadObtenida = cliente.getEdad();
		
		assertEquals(edadEsperada, edadObtenida);
	}
	
}
