package dominio.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Alumno implements Cloneable {
	int id;
	Facultad facultad;
	TpPostgrado tpPostgrado;
	String periodoAcademico;
	String codigoAlumno;
	String codigoDocente;
	String apellidoPaterno;
	String apellidoMaterno;
	String nombres;
	String email;
	String telefono;
	String cell;
	
	/**
	 * Comment for <code>tpEstadoCivil</code> SL SOLTERO CS casado, VD viudo, DV divorciado, SP separado
	 */
	String tpEstadoCivil;
	String tpSexo;
	String nacionalidad;
	String tpDoc;
	String nroDoc;
	Date fechaNac;
	String observaciones;
	Date fechaRegistro;
	String direccion;
	Ubigeo ubigeoDomicilio;
	Ubigeo ubigeoNac;
	
	Date fechaInscripcion;
	boolean esIngreso;
	
	
	/**
	 * Debe cargarse el valor de esIngreso para despues asignar el valor de tpModalidadIngreso
	 */
	TpModalidadIngreso tpModalidadIngreso;
	
	/**
	 * Debe cargarse el valor de esIngreso para despues asignar el valor de descripcionModalidadIngreso
	 */
	String descripcionModalidadIngreso;
	
	/**
	 * Listado de objectos GradoTitulo
	 * Composicion
	 */
	List gradosYTitulos;
	
	/**
	 * Listado de objectos TpIdioma
	 * Composicion
	 */
	List idiomas;
	
	/**
	 * Listado de objetos PlanEstudio
	 * Agregación
	 */
	List planDeEstudios;
	
	Mencion mencion;
	
	String periodoEgreso;
	
	Date fechaSustentacion;
	
	String tesis01;
	
	String tesis02;
	
	int estudioPostgrado;

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

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public String getCodigoDocente() {
		return codigoDocente;
	}

	public void setCodigoDocente(String codigoDocente) {
		this.codigoDocente = codigoDocente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List getGradosYTitulos() {
		return gradosYTitulos;
	}

	public void setGradosYTitulos(List gradosYTitulos) {
		this.gradosYTitulos = gradosYTitulos;
		if (this.gradosYTitulos != null) {
			for (Iterator it = this.gradosYTitulos.iterator(); it.hasNext();) {
				GradoTitulo gt = (GradoTitulo) it.next();
				gt.setIdAlumnoEgresado(this.id);
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		if (this.idiomas != null) {
			for (Iterator it = this.idiomas.iterator(); it.hasNext();) {
				TpIdioma idm = (TpIdioma) it.next();
				idm.setIdAlumnoEgresado(this.id);
			}
		}
		if (this.gradosYTitulos != null) {
			for (Iterator it = this.gradosYTitulos.iterator(); it.hasNext();) {
				GradoTitulo gt = (GradoTitulo) it.next();
				gt.setIdAlumnoEgresado(this.id);
			}
		}
		if (this.planDeEstudios != null) {
			for (Iterator it = this.planDeEstudios.iterator(); it.hasNext();) {
				PlanEstudio pe = (PlanEstudio) it.next();
				pe.setIdAlumnoEgresado(this.id);
			}
		}	
	}

	public List getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List idiomas) {
		this.idiomas = idiomas;
		if (this.idiomas != null) {
			for (Iterator it = this.idiomas.iterator(); it.hasNext();) {
				TpIdioma idm = (TpIdioma) it.next();
				idm.setIdAlumnoEgresado(this.id);
			}
		}
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPeriodoAcademico() {
		return periodoAcademico;
	}

	public void setPeriodoAcademico(String periodoAcademico) {
		this.periodoAcademico = periodoAcademico;
	}

	public List getPlanDeEstudios() {
		return planDeEstudios;
	}

	public void setPlanDeEstudios(List planDeEstudios) {
		this.planDeEstudios = planDeEstudios;
		if (this.planDeEstudios != null) {
			for (Iterator it = this.planDeEstudios.iterator(); it.hasNext();) {
				PlanEstudio pe = (PlanEstudio) it.next();
				pe.setIdAlumnoEgresado(this.id);
			}
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTpDoc() {
		return tpDoc;
	}

	public void setTpDoc(String tpDoc) {
		this.tpDoc = tpDoc;
	}

	public String getTpEstadoCivil() {
		return tpEstadoCivil;
	}

	public void setTpEstadoCivil(String tpEstadoCivil) {
		this.tpEstadoCivil = tpEstadoCivil;
	}

	public TpPostgrado getTpPostgrado() {
		return tpPostgrado;
	}

	public void setTpPostgrado(TpPostgrado tpPostgrado) {
		this.tpPostgrado = tpPostgrado;
	}

	public String getTpSexo() {
		return tpSexo;
	}

	public void setTpSexo(String tpSexo) {
		this.tpSexo = tpSexo;
	}

	public Ubigeo getUbigeoDomicilio() {
		return ubigeoDomicilio;
	}

	public void setUbigeoDomicilio(Ubigeo ubigeoDomicilio) {
		this.ubigeoDomicilio = ubigeoDomicilio;
	}

	public Ubigeo getUbigeoNac() {
		return ubigeoNac;
	}

	public void setUbigeoNac(Ubigeo ubigeoNac) {
		this.ubigeoNac = ubigeoNac;
	}

	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Alumno aeClone = (Alumno) super.clone();
		
		if (this.facultad != null) {
			aeClone.facultad = (Facultad) this.facultad.clone();
		}
		if (this.tpPostgrado != null) {
			aeClone.tpPostgrado = (TpPostgrado) this.tpPostgrado.clone();	
		}
		if (this.fechaNac != null) {
			aeClone.fechaNac = (Date) this.fechaNac.clone();
		}
		if (this.fechaRegistro != null) {
			aeClone.fechaRegistro = (Date) this.fechaRegistro.clone();			
		}
		if (this.gradosYTitulos != null) {
			aeClone.gradosYTitulos = null;
			aeClone.gradosYTitulos = new ArrayList();
			for (int i = 0; i < this.gradosYTitulos.size(); i++) {
				aeClone.gradosYTitulos.add(i, ((GradoTitulo)this.gradosYTitulos.get(i)).clone());
			}
		}
		if (this.idiomas != null) {
			aeClone.idiomas = null;
			aeClone.idiomas = new ArrayList();
			for (int i = 0; i < this.idiomas.size(); i++) {
				aeClone.idiomas.add(i, ((TpIdioma)this.idiomas.get(i)).clone());
			}
		}
		if (this.planDeEstudios != null) {
			aeClone.planDeEstudios = null;
			aeClone.planDeEstudios = new ArrayList();
			for (int i = 0; i < this.planDeEstudios.size(); i++) {
				aeClone.planDeEstudios.add(i, ((PlanEstudio)this.planDeEstudios.get(i)).clone());
			}
		}
		if (this.ubigeoDomicilio != null) {
			aeClone.ubigeoDomicilio = (Ubigeo) this.ubigeoDomicilio.clone();
		}
		if (this.ubigeoNac != null) {
			aeClone.ubigeoNac = (Ubigeo) this.ubigeoNac.clone();
		}
		if (this.fechaInscripcion != null) {
			aeClone.fechaInscripcion = (Date) this.fechaInscripcion.clone();
		}
		if (this.tpModalidadIngreso != null) {
			aeClone.tpModalidadIngreso = (TpModalidadIngreso) this.tpModalidadIngreso.clone();
		}
		if (this.mencion != null) {
			aeClone.mencion = (Mencion) this.mencion.clone();
		}
		if (this.fechaSustentacion != null) {
			aeClone.fechaSustentacion = (Date) this.fechaSustentacion.clone();
		}
		return aeClone;
	}

	public String getDescripcionModalidadIngreso() {
		return descripcionModalidadIngreso;
	}
	

	public boolean isEsIngreso() {
		return esIngreso;
	}
	

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	

	public TpModalidadIngreso getTpModalidadIngreso() {
		return tpModalidadIngreso;
	}

	public void setDescripcionModalidadIngreso(String descripcionModalidadIngreso) {
		if (this.esIngreso) {
			this.descripcionModalidadIngreso = descripcionModalidadIngreso;
		}
		else {
			this.descripcionModalidadIngreso = null;
		}
	}

	public void setEsIngreso(boolean esIngreso) {
		this.esIngreso = esIngreso;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public void setTpModalidadIngreso(TpModalidadIngreso tpModalidadIngreso) {
		if (this.esIngreso) {
			this.tpModalidadIngreso = tpModalidadIngreso;
		}
		else {
			this.tpModalidadIngreso = null;
		}
	}

	public Mencion getMencion() {
		return mencion;
	}
	
	public void setMencion(Mencion mencion) {
		this.mencion = mencion;
	}

	public Date getFechaSustentacion() {
		return fechaSustentacion;
	}
	

	public void setFechaSustentacion(Date fechaSustentacion) {
		this.fechaSustentacion = fechaSustentacion;
	}

	public String getPeriodoEgreso() {
		return periodoEgreso;
	}
	

	public void setPeriodoEgreso(String periodoEgreso) {
		this.periodoEgreso = periodoEgreso;
	}

	public String getTesis01() {
		return tesis01;
	}
	

	public void setTesis01(String tesis01) {
		this.tesis01 = tesis01;
	}

	public String getTesis02() {
		return tesis02;
	}


	public void setTesis02(String tesis02) {
		this.tesis02 = tesis02;
	}

	public int getEstudioPostgrado() {
		return estudioPostgrado;
	}

	public void setEstudioPostgrado(int estudioPostgrado) {
		this.estudioPostgrado = estudioPostgrado;
	}
	
//	public void setEstudioPostgrado(Object o) {
//		System.out.print("hola"+o);
//		//this.estudioPostgrado = estudioPostgrado;
//	}
}