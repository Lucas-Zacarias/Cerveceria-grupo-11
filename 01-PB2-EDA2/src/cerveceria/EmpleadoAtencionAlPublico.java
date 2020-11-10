package cerveceria;

public abstract class EmpleadoAtencionAlPublico extends Empleado {

	protected String alias;

	public EmpleadoAtencionAlPublico(String nombre, Integer dni, Double sueldo, String alias) {
		super(nombre, dni, sueldo);
		this.alias = alias;
	}

	public Boolean tomarPedido(Pedido pedido) {
		Boolean tomaExitosa = false;
		if (pedido != null) {
			System.out.println("El empleado de atención al público toma el pedido");
			tomaExitosa = true;
		}
		return tomaExitosa;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoAtencionAlPublico other = (EmpleadoAtencionAlPublico) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		return true;
	}

}
