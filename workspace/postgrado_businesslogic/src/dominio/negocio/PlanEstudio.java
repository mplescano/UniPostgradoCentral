package dominio.negocio;

import java.math.BigDecimal;
import java.util.Date;

public class PlanEstudio implements Cloneable {
	int id;
	int idAlumnoEgresado;
	String codigoCurso;
	String nombreCurso;
	int creditoCurso;
	BigDecimal notaCurso;
	String docenteCurso;
	String periodoCurso;
	Date fechaIniCurso;
	
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public int getCreditoCurso() {
		return creditoCurso;
	}
	public void setCreditoCurso(int creditoCurso) {
		this.creditoCurso = creditoCurso;
	}
	public String getDocenteCurso() {
		return docenteCurso;
	}
	public void setDocenteCurso(String docenteCurso) {
		this.docenteCurso = docenteCurso;
	}
	public Date getFechaIniCurso() {
		return fechaIniCurso;
	}
	public void setFechaIniCurso(Date fechaIniCurso) {
		this.fechaIniCurso = fechaIniCurso;
	}
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
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public BigDecimal getNotaCurso() {
		return notaCurso;
	}
	public void setNotaCurso(BigDecimal notaCurso) {
		this.notaCurso = notaCurso;
	}
	public String getPeriodoCurso() {
		return periodoCurso;
	}
	public void setPeriodoCurso(String periodoCurso) {
		this.periodoCurso = periodoCurso;
	}
	
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		PlanEstudio peClone;
		peClone = (PlanEstudio) super.clone();
		if (this.fechaIniCurso != null) {
			peClone.fechaIniCurso = (Date) this.fechaIniCurso.clone();
		}
		else {
			peClone.fechaIniCurso = null;
		}
		if (this.notaCurso != null) {
			peClone.notaCurso = new BigDecimal(this.notaCurso.toString());
		}
		else {
			peClone.notaCurso = null;
		}
		return peClone;
	}
}
