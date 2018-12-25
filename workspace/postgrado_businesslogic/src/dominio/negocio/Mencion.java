package dominio.negocio;

public class Mencion implements Cloneable {
	int codigo;
	int idEstudioPostgrado;
	String nombre;
	String descripcion;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getIdEstudioPostgrado() {
		return idEstudioPostgrado;
	}
	
	public void setIdEstudioPostgrado(int idEstudioPostgrado) {
		this.idEstudioPostgrado = idEstudioPostgrado;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Mencion mn = (Mencion) o;
		if (mn != null && mn.codigo == this.codigo) {
			return true;
		}
		return super.equals(o);
	}

	//@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}