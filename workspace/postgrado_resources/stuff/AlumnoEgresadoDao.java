package persistencia.iface;

import java.util.List;
import java.util.Map;
import dominio.negocio.AlumnoEgresado;
import dominio.negocio.Facultad;
import dominio.negocio.TpIdioma;
import dominio.negocio.TpPostgrado;

public interface AlumnoEgresadoDao {
	
	/**
	 * @param params parametros de:facultad_codigo,tpPostgrado_codigo,nombres,apellidoPaterno,apellidoMaterno
	 * @return Lista de objetos AlumnoEgresado
	 */
	List getAlumnoEgresadoList (Map params);
	
	AlumnoEgresado getAlumnoEgresado (int id);
	
	void insertAlumnoEgresado (AlumnoEgresado a);
	
	void updateAlumnoEgresado (AlumnoEgresado aNew, AlumnoEgresado aOld);
	
	void deleteAlumnoEgresado (int id);
	
	void deleteAlumnoEgresado (AlumnoEgresado a);
	
	Facultad getFacultad (String codigo);
	
	List getFacultadList ();
	
	TpPostgrado getTpPostgrado (String codigo);
	
	List getTpPostgradoList ();

}