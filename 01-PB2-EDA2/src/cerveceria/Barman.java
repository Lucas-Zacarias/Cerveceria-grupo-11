package cerveceria;

public class Barman extends EmpleadoNoAtencionAlPublico implements LlevarPedido {

	public Barman(String nombre, Integer dni, Double sueldo) {
		super(nombre, dni, sueldo);
	}

	@Override
	public void prepararPedido(Pedido pedido) {
		for (Item itemActual : pedido.obtenerListaDeItemsDeTipoTrago()) {
			System.out.println("El barman preparar� el trago: " + itemActual.getNombre());
		}
	}

	@Override
	public void llevandoPedido() {
		System.out.println("El/la barman " + nombre + "asiste al equipo de meseros con la entrega de los pedidos");
	}

}
