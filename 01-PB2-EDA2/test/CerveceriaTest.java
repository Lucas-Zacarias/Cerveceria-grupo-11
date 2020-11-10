import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cerveceria.Barman;
import cerveceria.Cajero;
import cerveceria.Cerveceria;
import cerveceria.Cliente;
import cerveceria.Cocinero;
import cerveceria.Empleado;
import cerveceria.EmpleadoAtencionAlPublico;
import cerveceria.Item;
import cerveceria.Mesero;
import cerveceria.Platillo;
import cerveceria.Trago;

public class CerveceriaTest {

	@Test
	public void testQueSePuedeCrearUnaCerveceria() {
		Cerveceria cerveceria = new Cerveceria();

		assertNotNull(cerveceria);
	}

	@Test
	public void queSePuedanAgregarEmpleadosALaNominaDeLaCerveceria() {
		Cerveceria cerveceria = new Cerveceria();

		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		assertTrue(cerveceria.agregarEmpleado(barman));
		assertTrue(cerveceria.agregarEmpleado(cocinero));
		assertTrue(cerveceria.agregarEmpleado(cajero));
		assertTrue(cerveceria.agregarEmpleado(mesero));

		Integer cantidadDeEmpleadosEsperadosEnLaNomina = 4;
		Integer cantidadDeEmpleadosObtenidosEnLaNomina = cerveceria.getNominaEmpleados().size();

		assertEquals(cantidadDeEmpleadosEsperadosEnLaNomina, cantidadDeEmpleadosObtenidosEnLaNomina);
	}

	@Test
	public void queNoSePuedanAgregarEmpleadosDelMismoAreaConElMismoDNI() {
		Cerveceria cerveceria = new Cerveceria();

		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Empleado barman2 = new Barman("Jose", 40123654, 20010.50);

		assertTrue(cerveceria.agregarEmpleado(barman));
		assertFalse(cerveceria.agregarEmpleado(barman2));

		Integer cantidadEsperadaDeEmpleados = 1;
		Integer cantidadObtenidaDeEmpleados = cerveceria.getNominaEmpleados().size();

		assertEquals(cantidadEsperadaDeEmpleados, cantidadObtenidaDeEmpleados);
	}

	@Test
	public void queSePuedaBuscarUnEmpleadoExistentePorSuDNI() {
		Cerveceria cerveceria = new Cerveceria();

		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		cerveceria.agregarEmpleado(barman);
		cerveceria.agregarEmpleado(cocinero);
		cerveceria.agregarEmpleado(cajero);
		cerveceria.agregarEmpleado(mesero);

		Empleado empleadoObtenido = cerveceria.buscarEmpleadoPorDNI(barman.getDni());

		assertEquals(barman, empleadoObtenido);
	}

	@Test
	public void queSePuedaBuscarUnEmpleadoDeAtencionAlClientePorSuAlias() {
		Cerveceria cerveceria = new Cerveceria();

		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		cerveceria.agregarEmpleado(barman);
		cerveceria.agregarEmpleado(cocinero);
		cerveceria.agregarEmpleado(cajero);
		cerveceria.agregarEmpleado(mesero);

		EmpleadoAtencionAlPublico empleadoObtenido = cerveceria.buscarEmpleadoDeAtencionAlPublico("cash");

		assertEquals(cajero, empleadoObtenido);
	}

	@Test
	public void queNoSePuedaBuscarUnEmpleadoInexistente() {
		Cerveceria cerveceria = new Cerveceria();

		assertNull(cerveceria.buscarEmpleadoPorDNI(null));
	}

	@Test
	public void queSeElimineUnEmpleadoPorSuDNI() {
		Cerveceria cerveceria = new Cerveceria();

		Empleado barman = new Barman("Francisco", 40123654, 17000.89);
		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		cerveceria.agregarEmpleado(barman);
		cerveceria.agregarEmpleado(cocinero);
		cerveceria.agregarEmpleado(cajero);
		cerveceria.agregarEmpleado(mesero);

		assertTrue(cerveceria.eliminarEmpleadoPorDNI(barman.getDni()));

		Integer cantidadEsperadaDeEmpleadosActual = 3;
		Integer cantidadObtenidaDeEmpleadosActual = cerveceria.getNominaEmpleados().size();

		assertEquals(cantidadEsperadaDeEmpleadosActual, cantidadObtenidaDeEmpleadosActual);
	}

	@Test
	public void queSeEliminenATodosLosEmpleados() {
		Cerveceria cerveceria = new Cerveceria();

		Empleado cocinero = new Cocinero("Alvaro", 38789456, 20010.50);
		Empleado cajero = new Cajero("Sergio", 39159753, 19785.36, "cash");
		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		cerveceria.agregarEmpleado(cocinero);
		cerveceria.agregarEmpleado(cajero);
		cerveceria.agregarEmpleado(mesero);

		cerveceria.eliminarATodosLosEmpleados();

		Integer cantidadDeEmpleadosEsperada = 0;
		Integer cantidadDeEmpleadosObtenida = cerveceria.getNominaEmpleados().size();

		assertEquals(cantidadDeEmpleadosEsperada, cantidadDeEmpleadosObtenida);
	}

	@Test
	public void queSePuedanAgregarItemsAlMenu() {
		Cerveceria cerveceria = new Cerveceria();

		Item platillo = new Platillo("Hamburguesa doble", 350.45);

		assertTrue(cerveceria.agregarItemsAlMenu(platillo));

		Integer cantidadDeItemsEsperada = 1;
		Integer cantidadDeItemsObtenido = cerveceria.getMenu().size();

		assertEquals(cantidadDeItemsEsperada, cantidadDeItemsObtenido);
	}

	@Test
	public void queSePuedaEliminarUnItemDelMenuPorSuNombre() {
		Cerveceria cerveceria = new Cerveceria();

		Item platillo = new Platillo("Hamburguesa doble", 350.45);
		Item trago = new Trago("Margarita", 500.70);

		cerveceria.agregarItemsAlMenu(platillo);
		cerveceria.agregarItemsAlMenu(trago);

		assertTrue(cerveceria.eliminarUnItemDelMenuPorSuNombre(trago.getNombre()));

		Integer cantidadEsperadaDeItemsEnElMenu = 1;
		Integer cantidadObtenidaDeItemsEnElMenu = cerveceria.getMenu().size();

		assertEquals(cantidadEsperadaDeItemsEnElMenu, cantidadObtenidaDeItemsEnElMenu);
	}

	@Test
	public void queUnClientePuedaRealizarUnPedido() {
		Cerveceria cerveceria = new Cerveceria();

		Integer nroPedido = 20;

		Item hamburguesa = new Platillo("Hamburguesa doble", 350.45);
		Item pizza = new Platillo("Pizza mediana de muzzarella", 250.50);
		Item margarita = new Trago("Margarita", 500.70);
		Item cerveza = new Trago("Cerveza rubia marca Quilmes de 500 ml", 150.20);

		cerveceria.agregarItemsAlMenu(hamburguesa);
		cerveceria.agregarItemsAlMenu(pizza);
		cerveceria.agregarItemsAlMenu(margarita);
		cerveceria.agregarItemsAlMenu(cerveza);

		Cliente cliente = new Cliente("Alejandro", 19);
		List<String> pedido = new ArrayList<String>();
		pedido.add(pizza.getNombre());
		pedido.add(cerveza.getNombre());

		Empleado mesero = new Mesero("Martin", 25741369, 18754.30, "tupper");

		cerveceria.agregarEmpleado(mesero);

		assertTrue(cerveceria.clienteRealizaUnPedido(cliente.getEdad(), pedido, "tupper", nroPedido));

		Integer cantidadEsperadaDePedidosHechos = 1;
		Integer cantidadObtenidaDePedidosHechos = cerveceria.getPedidos().size();

		assertEquals(cantidadEsperadaDePedidosHechos, cantidadObtenidaDePedidosHechos);
	}

}
