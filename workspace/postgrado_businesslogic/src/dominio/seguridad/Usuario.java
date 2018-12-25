package dominio.seguridad;

import java.util.Date;

public class Usuario {
	int id;
	GrupoUsuarios grupo;
	String usuario;
	
	String claveNew;
	String claveOld;
	
	String nombre;
	String apellidoPaterno;
	String apellidoMaterno;
	String tpDoc;
	String nroDoc;
	Date fechaRegistro;
	Date fechaUltimoAcceso;
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}
	
	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNroDoc() {
		return nroDoc;
	}
	
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	
	public String getTpDoc() {
		return tpDoc;
	}
	
	public void setTpDoc(String tpDoc) {
		this.tpDoc = tpDoc;
	}
	
	public GrupoUsuarios getGrupo() {
		return grupo;
	}
	
	public void setGrupo (GrupoUsuarios gp) {
		this.grupo = gp;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
