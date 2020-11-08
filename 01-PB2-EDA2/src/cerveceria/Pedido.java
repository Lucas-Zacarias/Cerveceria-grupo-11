package cerveceria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private Integer nroDePedido;
	private String aliasDeEmpleadoDeAtencionAlCliente;
	private List<Item> listaDePedidos;


	public Pedido(Integer nroDePedido) {
		this.nroDePedido = nroDePedido;
		this.aliasDeEmpleadoDeAtencionAlCliente = new String();
		this.listaDePedidos = new ArrayList<Item>();
	}

	public Boolean agregarItemALaListaDePedidosConCondicionDeEdad(Integer edadCliente, Item itemNuevo) {
		Boolean resultadoDeAgregado = false;
		if(itemNuevo != null) {
		if (itemNuevo instanceof Trago) {
			if (edadCliente >= 18) {
				resultadoDeAgregado = this.listaDePedidos.add(itemNuevo);
			}
		}else {
		resultadoDeAgregado = this.listaDePedidos.add(itemNuevo);
		}
		}
		return resultadoDeAgregado;
	}

	public Item buscaItemPorNombre(String nombre) {
		Item itemBuscado = null;
		for (Item item : this.listaDePedidos) {
			if (item.getNombre().equals(nombre)) {
				itemBuscado = item;
			}
		}
		return itemBuscado;
	}

	public List<Item> obtenerListaDeItemsDeTipoPlatillo() {
		List<Item> listaDePlatillos = new ArrayList<Item>();
		for (Item platilloActual : listaDePedidos) {
			if (platilloActual instanceof Platillo) {
				listaDePlatillos.add(platilloActual);
			}
		}
		return listaDePlatillos;
	}

	public List<Item> obtenerListaDeItemsDeTipoTrago() {
		List<Item> listaDeTragos = new ArrayList<Item>();
		for (Item tragoActual : listaDePedidos) {
			if (tragoActual instanceof Trago) {
				listaDeTragos.add(tragoActual);
			}
		}
		return listaDeTragos;
	}

	public Integer obtenerCantidadDeItemsDeUnPedido() {
		return this.listaDePedidos.size();
	}
	
	public List<Item> getListaDePedidos() {
		return listaDePedidos;
	}

	public void setListaDePedidos(List<Item> listaDePedidos) {
		this.listaDePedidos = listaDePedidos;
	}

	public Integer getNroDePedido() {
		return nroDePedido;
	}

	public void setNroDePedido(Integer nroDePedido) {
		this.nroDePedido = nroDePedido;
	}

	public String getAliasDeEmpleadoDeAtencionAlCliente() {
		return aliasDeEmpleadoDeAtencionAlCliente;
	}

	public void setAliasDeEmpleadoDeAtencionAlCliente(String aliasDeEmpleadoDeAtencionAlCliente) {
		this.aliasDeEmpleadoDeAtencionAlCliente = aliasDeEmpleadoDeAtencionAlCliente;
	}
}
