package dominio.negocio;

public class GradoTitulo implements Cloneable {
	int id;
	int idAlumnoEgresado;
	String nombreGradoTitulo;
	String orgProcedencia;
	String periodoEgreso;
	
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
	public String getNombreGradoTitulo() {
		return nombreGradoTitulo;
	}
	public void setNombreGradoTitulo(String nombreGradoTitulo) {
		this.nombreGradoTitulo = nombreGradoTitulo;
	}
	public String getOrgProcedencia() {
		return orgProcedencia;
	}
	public void setOrgProcedencia(String orgProcedencia) {
		this.orgProcedencia = orgProcedencia;
	}
	public String getPeriodoEgreso() {
		return periodoEgreso;
	}
	public void setPeriodoEgreso(String periodoEgreso) {
		this.periodoEgreso = periodoEgreso;
	}
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
	}
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
