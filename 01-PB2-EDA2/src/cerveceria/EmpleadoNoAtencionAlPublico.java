package cerveceria;

public abstract class EmpleadoNoAtencionAlPublico extends Empleado {

	public EmpleadoNoAtencionAlPublico(String nombre, Integer dni, Integer legajo, Double sueldo) {
		super(nombre, dni, legajo, sueldo);
	}

	public abstract void prepararPedido(Pedido pedido);
}
