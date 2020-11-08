import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cerveceria.Cliente;
import cerveceria.Item;
import cerveceria.Pedido;
import cerveceria.Platillo;
import cerveceria.Trago;

public class PedidoTest {

	@Test
	public void testQueSePuedaCrearUnPedido() {
		Integer nroPedido = 20;
		Pedido pedido = new Pedido(nroPedido);

		assertNotNull(pedido);
	}

	@Test
	public void queSePuedanAgregarItemsAlPedido() {
		Integer nroPedido = 20;
		Pedido pedido = new Pedido(nroPedido);

		Item hamburguesa = new Platillo("Hamburguesa doble", 350.05);

		Cliente cliente = new Cliente("Alejandro", 18);

		Boolean pedidoCreado = pedido.agregarItemALaListaDePedidosConCondicionDeEdad(cliente.getEdad(), hamburguesa);

		assertTrue(pedidoCreado);
	}

	@Test
	public void queNoSePuedanAgregarItemsInexistentesAlPedido() {
		Integer nroPedido = 20;
		Pedido pedido = new Pedido(nroPedido);

		Cliente cliente = new Cliente("Alejandro", 18);

		Boolean pedidoCreado = pedido.agregarItemALaListaDePedidosConCondicionDeEdad(cliente.getEdad(), null);

		assertFalse(pedidoCreado);
	}

	@Test
	public void queNoSePuedanAgregarItemsDeTipoBebidaALPedidoDeLosMenoresDe18Años() {
		Integer nroPedido = 20;
		Pedido pedido = new Pedido(nroPedido);

		Cliente cliente = new Cliente("Alejandro", 17);

		Item hamburguesa = new Platillo("Hamburguesa doble", 350.45);
		Item pizza = new Platillo("Pizza mediana de muzzarella", 250.50);
		Item margarita = new Trago("Margarita", 500.70);
		Item cerveza = new Trago("Cerveza rubia marca Quilmes de 500 ml", 150.20);

		pedido.agregarItemALaListaDePedidosConCondicionDeEdad(cliente.getEdad(), hamburguesa);
		pedido.agregarItemALaListaDePedidosConCondicionDeEdad(cliente.getEdad(), pizza);
		pedido.agregarItemALaListaDePedidosConCondicionDeEdad(cliente.getEdad(), margarita);
		pedido.agregarItemALaListaDePedidosConCondicionDeEdad(cliente.getEdad(), cerveza);

		Integer valorEsperadoEnLaCantidadDeItemsEnElPedido = 2;
		Integer valorObtenidoEnLaCantidadDeItemsEnElPedido = pedido.obtenerCantidadDeItemsDeUnPedido();

		assertEquals(valorEsperadoEnLaCantidadDeItemsEnElPedido, valorObtenidoEnLaCantidadDeItemsEnElPedido);

		Integer cantidadEsperadaDeItemsTipoTrago = 0;
		List<Item> listaDeTragosEnUnPedido = pedido.obtenerListaDeItemsDeTipoTrago();
		Integer cantidadObtenidaDeItemsTipoTrago = listaDeTragosEnUnPedido.size();

		assertEquals(cantidadEsperadaDeItemsTipoTrago, cantidadObtenidaDeItemsTipoTrago);

		Integer valorEsperadoEnLaCantidadDeItemsTipoPlatillo = 2;
		List<Item> listaDePlatillosDeUnPedido = pedido.obtenerListaDeItemsDeTipoPlatillo();
		Integer cantidadObtenidaDeItemsTipoPlatillo = listaDePlatillosDeUnPedido.size();

		assertEquals(valorEsperadoEnLaCantidadDeItemsTipoPlatillo, cantidadObtenidaDeItemsTipoPlatillo);
	}

}
