package dominio.negocio;

public class TpIdioma implements Cloneable {
	int id;
	int idAlumnoEgresado;
	String nombreIdioma;
	String nivelIdioma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAlumnoEgresado() {
		return idAlumnoEgresado;
	}
	public void setIdAlumnoEgresado(int idAlumnoEgresado) {
		this.idAlumnoEgresado = idAlumnoEgresado;
	}
	public String getNivelIdioma() {
		return nivelIdioma;
	}
	public void setNivelIdioma(String nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}
	public String getNombreIdioma() {
		return nombreIdioma;
	}
	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		TpIdioma idm = (TpIdioma) o;
		if (idm.idAlumnoEgresado == this.idAlumnoEgresado &&
				idm.nombreIdioma.equals(this.nombreIdioma)) {
			return true;
		}
		return super.equals(o);
	}
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
