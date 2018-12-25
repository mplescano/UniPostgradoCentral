package persistencia.iface;

import java.util.List;
import java.util.Map;
import dominio.negocio.Alumno;
import dominio.negocio.Facultad;
import dominio.negocio.ImpresionCertificadoAlumno;
import dominio.negocio.TpModalidadIngreso;
import dominio.negocio.TpPostgrado;

public interface AlumnoDao {
	
	/**
	 * @param params parametros de:facultad_codigo,tpPostgrado_codigo,nombres,apellidoPaterno,apellidoMaterno
	 * @return Lista de objetos Alumno
	 */
	List getAlumnoList (Map params);
	
	Alumno getAlumno (int id);
	
	void insertAlumno (Alumno a);
	
	void updateAlumno (Alumno aNew, Alumno aOld);
	
	void deleteAlumno (int id);
	
	void deleteAlumno (Alumno a);
	
	Facultad getFacultad (String codigo);
	
	List getFacultadList ();
	
	TpPostgrado getTpPostgrado (String codigo);
	
	List getTpPostgradoList ();
	
	TpModalidadIngreso getTpModalidadIngreso (String codigo);
	
	List getTpModalidadIngresoList ();
	
	void insertImpresionCertificadoAlumno (ImpresionCertificadoAlumno ica);

}