package cerveceria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cerveceria {
	private String nombre;
	private Set<Empleado> nominaEmpleados;
	private Set<Item> menu;
	private Set<Pedido> pedidos;
	private Set<String> tickets;

	public Cerveceria() {
		this.nombre = "Bar de Silas";
		this.nominaEmpleados = new HashSet<Empleado>();
		this.menu = new HashSet<Item>();
		this.pedidos = new HashSet<Pedido>();
		this.tickets = new HashSet<String>();
	}

	public Boolean agregarEmpleado(Empleado nuevoEmpleado) {
		return this.nominaEmpleados.add(nuevoEmpleado);
	}

	public Empleado buscarEmpleadoPorDNI(Integer numero) {
		Empleado empleadoEncontrado = null;
		for (Empleado empleado : this.nominaEmpleados) {
			if (empleado.getDni() == numero) {
				empleadoEncontrado = empleado;
			}
		}
		return empleadoEncontrado;
	}

	public EmpleadoAtencionAlPublico buscarEmpleadoDeAtencionAlPublico(String alias) {
		Empleado empleadoBuscado = null;
		for (Empleado empleado : this.nominaEmpleados) {
			if (empleado instanceof EmpleadoAtencionAlPublico
					&& ((EmpleadoAtencionAlPublico) empleado).getAlias().equals(alias)) {
				empleadoBuscado = empleado;
			}
		}
		return (EmpleadoAtencionAlPublico)empleadoBuscado;
	}

	public Boolean eliminarEmpleadoPorDNI(Integer nro) {
		Boolean eliminacionExitosa = false;
		Empleado empleadoAEliminar = buscarEmpleadoPorDNI(nro);
		if (empleadoAEliminar != null) {
			this.nominaEmpleados.remove(empleadoAEliminar);
			eliminacionExitosa = true;
		}
		return eliminacionExitosa;
	}

	public Set<Empleado> listarNominaDeEmpleadosDeAtencionAlPublico() {
		Set<Empleado> empleadosDeAtencionAlPublico = new HashSet<Empleado>();
		for (Empleado empleado : this.nominaEmpleados) {
			if (empleado instanceof EmpleadoAtencionAlPublico) {
				empleadosDeAtencionAlPublico.add(empleado);
			}
		}
		return empleadosDeAtencionAlPublico;
	}

	public Set<Empleado> listarNominaDeEmpleadosDeNoAtencionAlPublico() {
		Set<Empleado> empleadosDeNoAtencionAlPublico = new HashSet<Empleado>();
		for (Empleado empleado : this.nominaEmpleados) {
			if (empleado instanceof EmpleadoNoAtencionAlPublico) {
				empleadosDeNoAtencionAlPublico.add(empleado);
			}
		}
		return empleadosDeNoAtencionAlPublico;
	}
	
	public void eliminarATodosLosEmpleados() {
		this.nominaEmpleados.clear();
	}
	

	public Boolean agregarItemsAlMenu(Item nuevo) {
		return this.menu.add(nuevo);
	}

	public Item buscarUnItemDelMenuPorSuNombre(String nombre) {
		Item alimentoBuscado = null;
		for (Item alimento : this.menu) {
			if (alimento.getNombre().equals(nombre)) {
				alimentoBuscado = alimento;
			}
		}
		return alimentoBuscado;
	}

	public Boolean eliminarUnItemDelMenuPorSuNombre(String nombre) {
		Boolean eliminacionExitosa = false;
		Item itemAEliminar = buscarUnItemDelMenuPorSuNombre(nombre);
		if (itemAEliminar != null) {
			eliminacionExitosa = this.menu.remove(itemAEliminar);
		}
		return eliminacionExitosa;
	}

	public Set<Item> listarLosPlatillosDelMenu() {
		Set<Item> platillos = new HashSet<Item>();
		for (Item item : this.menu) {
			if (item instanceof Platillo) {
				platillos.add(item);
			}
		}
		return platillos;
	}

	public Set<Item> listarLosTragosDelMenu() {
		Set<Item> tragos = new HashSet<Item>();
		for (Item item : this.menu) {
			if (item instanceof Trago) {
				tragos.add(item);
			}
		}
		return tragos;
	}

	public Boolean clienteRealizaUnPedido(Integer edadCliente, List<String> listaDeItemsXNombre,
			String aliasDeEmpleadoAtencionAlCliente, Integer nroPedido) {
		Boolean pedidoRealizadoExitosamente = false;
		Pedido pedido = new Pedido(nroPedido);
		for (String nombreDelItem : listaDeItemsXNombre) {
			Item itemAAgregarAlPedido = buscarUnItemDelMenuPorSuNombre(nombreDelItem);
			if (itemAAgregarAlPedido != null
					&& buscarEmpleadoDeAtencionAlPublico(aliasDeEmpleadoAtencionAlCliente) != null) {
				pedido.agregarItemALaListaDePedidosConCondicionDeEdad(edadCliente, itemAAgregarAlPedido);
				pedido.setAliasDeEmpleadoDeAtencionAlCliente(aliasDeEmpleadoAtencionAlCliente);
				this.pedidos.add(pedido);
				pedidoRealizadoExitosamente = true;
			}
		}
		return pedidoRealizadoExitosamente;
	}
	
	public Boolean ticketGenerado(Pedido pedido, Integer nroTicket) {
		Boolean ticketGenerado = false;
		Ticket ticket = new Ticket(nroTicket);
		ticketGenerado = this.tickets.add(ticket.generarTicket(pedido));
		return ticketGenerado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Set<Empleado> getNominaEmpleados() {
		return nominaEmpleados;
	}

	public void setNominaEmpleados(Set<Empleado> nominaEmpleados) {
		this.nominaEmpleados = nominaEmpleados;
	}

	public Set<Item> getMenu() {
		return menu;
	}

	public void setMenu(Set<Item> menu) {
		this.menu = menu;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<String> getTickets() {
		return tickets;
	}

	public void setTickets(Set<String> tickets) {
		this.tickets = tickets;
	}
}
