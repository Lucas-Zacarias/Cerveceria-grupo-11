package cerveceria;

public class Cocinero extends EmpleadoNoAtencionAlPublico {

	public Cocinero(String nombre, Integer dni, Integer legajo, Double sueldo) {
		super(nombre, dni, legajo, sueldo);
	}

	@Override
	public void prepararPedido(Pedido pedido) {
		for (Item itemActual : pedido.obtenerListaDeItemsDeTipoPlatillo()) {
			System.out.println("El cocinero preparará el platillo: " + itemActual.getNombre());
		}
	}

}
