package dominio.negocio;

import java.util.List;

public class EstudioPostgrado {
	int id;
	TpPostgrado tpPostgrado;
	Facultad facultad;
	String especialidad;
	String descripcion;
	
	List menciones;
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public Facultad getFacultad() {
		return facultad;
	}
	
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public TpPostgrado getTpPostgrado() {
		return tpPostgrado;
	}
	
	public void setTpPostgrado(TpPostgrado postgrado) {
		this.tpPostgrado = postgrado;
	}

	public List getMenciones() {
		return menciones;
	}

	public void setMenciones(List menciones) {
		this.menciones = menciones;
	}

	public boolean equals (Object o) {
		EstudioPostgrado ep = (EstudioPostgrado) o;
		if (ep != null && (this.id == ep.id)) {
			return true;
		}
		else {
			return super.equals(o);
		}
	}
}