package cerveceria;

public class Mesero extends EmpleadoAtencionAlPublico implements LlevarPedido {

	public Mesero(String nombre, Integer dni, Integer legajo, Double sueldo, String alias) {
		super(nombre, dni, legajo, sueldo, alias);
	}

	@Override
	public void llevandoPedido() {
		System.out.println("El/la mesero/a " + nombre + "lleva el pedido al cliente");
	}

}
