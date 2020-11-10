package cerveceria;

public abstract class EmpleadoNoAtencionAlPublico extends Empleado {

	public EmpleadoNoAtencionAlPublico(String nombre, Integer dni, Double sueldo) {
		super(nombre, dni, sueldo);
	}

	public abstract void prepararPedido(Pedido pedido);
}
