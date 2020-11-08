import static org.junit.Assert.*;

import org.junit.Test;

import cerveceria.Cliente;
import cerveceria.Item;
import cerveceria.Pedido;
import cerveceria.Platillo;
import cerveceria.Ticket;
import cerveceria.Trago;

public class TicketTest {

	@Test
	public void testQueSePuedaCrearUnTicket() {
		Integer numeroTicket = 10;
		Ticket ticket = new Ticket(numeroTicket);

		assertNotNull(ticket);
	}

	@Test
	public void queSePuedaGenerarUnTicketAPartirDeUnPedido() {
		Integer numeroTicket = 10;
		Ticket ticket = new Ticket(numeroTicket);

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

		String ticketGenerado = ticket.generarTicket(pedido);

		assertNotNull(ticketGenerado);
	}

	@Test
	public void queNoSePuedaGenerarUnTicketDeUnPedidoInexistente() {
		Integer numeroTicket = 10;
		Ticket ticket = new Ticket(numeroTicket);

		String mensajeDePedidoInexistenteEsperado = "No existe un pedido hecho para generar el ticket";
		String mensajeDePedidoInexistenteObtenido = ticket.generarTicket(null);

		assertEquals(mensajeDePedidoInexistenteEsperado, mensajeDePedidoInexistenteObtenido);
	}
}
