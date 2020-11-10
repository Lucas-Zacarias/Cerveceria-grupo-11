import static org.junit.Assert.*;

import org.junit.Test;

import cerveceria.Barman;
import cerveceria.Cajero;
import cerveceria.Cocinero;
import cerveceria.Empleado;
import cerveceria.EmpleadoAtencionAlPublico;
import cerveceria.LlevarPedido;
import cerveceria.Mesero;
import cerveceria.Pedido;

public class EmpleadoTest {

	@Test
	public void testQueSePuedanCrearEmpleadosDeCadaAreaEnEspecificoUsandoPolimorfismo() {
		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		assertNotNull(barman);
		assertNotNull(cocinero);
		assertNotNull(cajero);
		assertNotNull(mesero);
	}

	@Test
	public void queLosDatosDeUnEmpleadoSeanLosEsperados() {
		Empleado barman = new Barman("Francisco", 40123654, 17000.89);

		String nombreEsperado = "Francisco";
		String nombreObtenido = barman.getNombre();

		assertEquals(nombreEsperado, nombreObtenido);

		Integer dniEsperado = 40123654;
		Integer dniObtenido = barman.getDni();

		assertEquals(dniEsperado, dniObtenido);

		Double sueldoEsperado = 17000.89;
		Double sueldoObtenido = barman.getSueldo();

		assertEquals(sueldoEsperado, sueldoObtenido);

		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");

		String aliasEsperado = "cash";
		String aliasObtenido = ((EmpleadoAtencionAlPublico) cajero).getAlias();

		assertEquals(aliasEsperado, aliasObtenido);
	}

	@Test
	public void queUnEmpleadoDeAtencionAlPublicoPuedaTomarUnPedidoExistente() {
		Pedido pedido = new Pedido(12);

		EmpleadoAtencionAlPublico cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");

		Boolean resultado = cajero.tomarPedido(pedido);

		assertTrue(resultado);
	}

	@Test
	public void queUnEmpleadoDeAtencionAlPublicoNoPuedaTomarUnPedidoInexistente() {

		EmpleadoAtencionAlPublico cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");

		Boolean resultado = cajero.tomarPedido(null);

		assertFalse(resultado);
	}

	@Test
	public void queUnEmpleadoSeaDelAreaDondeSeLoInstanció() {
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);

		String areaEsperada = "Cocinero";
		String areaObtenida = cocinero.getClass().getSimpleName();

		assertEquals(areaEsperada, areaObtenida);

		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		String areaEsperadaMesero = "Mesero";
		String areaObtenidaMesero = mesero.getClass().getSimpleName();

		assertEquals(areaEsperadaMesero, areaObtenidaMesero);
	}

	@Test
	public void queSoloLosEmpleadosTipoMeseroYBarmanPuedanLlevarPedidos() {
		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Boolean valorObtenidoDeBarman;
		if (barman instanceof LlevarPedido) {
			valorObtenidoDeBarman = true;
		} else {
			valorObtenidoDeBarman = false;
		}

		assertTrue(valorObtenidoDeBarman);

		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		Boolean valorObtenidoDeMesero;
		if (mesero instanceof LlevarPedido) {
			valorObtenidoDeMesero = true;
		} else {
			valorObtenidoDeMesero = false;
		}

		assertTrue(valorObtenidoDeMesero);

	}

	@Test
	public void queLosEmpleadosTipoCocineroOCajeroNoPuedanEntregarPedidos() {
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Boolean valorObtenidoCocinero;
		if (cocinero instanceof LlevarPedido) {
			valorObtenidoCocinero = true;
		} else {
			valorObtenidoCocinero = false;
		}

		assertFalse(valorObtenidoCocinero);

		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Boolean valorObtenidoCajero;
		if (cajero instanceof LlevarPedido) {
			valorObtenidoCajero = true;
		} else {
			valorObtenidoCajero = false;
		}

		assertFalse(valorObtenidoCajero);
	}

}
