package dominio.negocio;

public class TpModalidadIngreso implements Cloneable {
	private String codigo;
	private String nombre;
	private String descripcion;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		TpModalidadIngreso mi = (TpModalidadIngreso) o;
		if (mi.codigo.equals(this.codigo)) {
			return true;
		}
		return super.equals(o);
	}
}