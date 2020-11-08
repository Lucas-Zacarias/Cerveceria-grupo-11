package cerveceria;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private String nombreCerveceria;
	private Integer nro;

	public Ticket(Integer nro) {
		this.nombreCerveceria = "Bar de Silas";
		this.nro = nro;
	}

	public String generarTicket(Pedido pedido) {
		Double totalAPagar = 0.0;
		List<String> descripcion = new ArrayList<String>();
		String ticket = "No existe un pedido hecho para generar el ticket";
		if (pedido != null) {
			ticket = this.nro + "\t" + this.nombreCerveceria + "\n" + descripcion + "\n" + totalAPagar;
			for (Item itemActual : pedido.getListaDePedidos()) {
				descripcion.add(itemActual.getNombre() + "\t" + itemActual.getPrecio().toString());
				totalAPagar += itemActual.getPrecio();
			}
		}
		return ticket;
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public String getNombre() {
		return this.nombreCerveceria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nro == null) ? 0 : nro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (nro == null) {
			if (other.nro != null)
				return false;
		} else if (!nro.equals(other.nro))
			return false;
		return true;
	}

}
