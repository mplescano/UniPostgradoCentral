package dominio.negocio;

public class Facultad implements Cloneable {
	String codigo;
	String nombre;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Facultad f = (Facultad) o;
		if (f != null && f.codigo.equals(this.codigo)) {
			return true;
		}
		return super.equals(o);
	}

}
