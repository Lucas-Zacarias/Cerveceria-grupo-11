package cerveceria;

public abstract class EmpleadoNoEnfocadoAlPublico extends Empleado {

	@Override
	public String enfocado_o_no_al_cliente() {
		String area = "No enfocado al cliente";
		return area;
	}

}
