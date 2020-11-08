import static org.junit.Assert.*;

import org.junit.Test;

import cerveceria.Item;
import cerveceria.Platillo;
import cerveceria.Trago;

public class ItemTest {

	@Test
	public void testQueSePuedaCrearUnItemUsandoPolimorfismo() {
		Item platillo = new Platillo("Hamburguesa doble", 350.45);
		Item trago = new Trago("Margarita", 500.70);
		
		assertNotNull(platillo);
		assertNotNull(trago);
	}
	
	@Test
	public void queLosDatosCargadosAUnTipoDeItemSeanLosEsperado() {
		Item platillo = new Platillo("Hamburguesa doble", 350.45);
		
		String nombreEsperado = "Hamburguesa doble";
		String nombreObtenido = platillo.getNombre();
		
		assertEquals(nombreEsperado, nombreObtenido);
		
		Double precioEsperado = 350.45;
		Double precioObtenido = platillo.getPrecio();
		
		assertEquals(precioEsperado, precioObtenido);
	}
	
	@Test
	public void queLosTiposDeItemsPertenezcanALaClaseEnLaQueSeLoInstanció() {
		Item platillo = new Platillo("Hamburguesa doble", 350.45);
		
		String claseEsperada = "Platillo";
		String claseObtenida = platillo.getClass().getSimpleName();
		
		assertEquals(claseEsperada, claseObtenida);
		
		Item trago = new Trago("Margarita", 500.70);
		
		String claseEsperadaTrago = "Trago";
		String claseObtenidaTrago = trago.getClass().getSimpleName();
		
		assertEquals(claseEsperadaTrago, claseObtenidaTrago);
	}
}
