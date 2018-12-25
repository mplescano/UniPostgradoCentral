package persistencia.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import persistencia.iface.AlumnoDao;
import com.ibatis.dao.client.DaoManager;
import dominio.negocio.Alumno;
import dominio.negocio.Facultad;
import dominio.negocio.GradoTitulo;
import dominio.negocio.ImpresionCertificadoAlumno;
import dominio.negocio.TpIdioma;
import dominio.negocio.TpModalidadIngreso;
import dominio.negocio.TpPostgrado;

public class AlumnoImpDao extends BaseSqlMapDao implements
		AlumnoDao {

	public AlumnoImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getAlumnoList(Map params) {
		// TODO Auto-generated method stub
		List l;
		if (params != null) {
			String facultad = prepareStringSafe((String) params.get("facultad_codigo"));
			String tpPg = prepareStringSafe((String) params.get("tpPostgrado"));
			
			String nombres = prepareForSearh((String) params.get("nombres"));
			String appPaterno = prepareForSearh((String) params.get("apellidoPaterno"));
			String appMaterno = prepareForSearh((String) params.get("apellidoMaterno"));
			String mencion = prepareForSearh((String) params.get("mencion_nombre"));
			
			params.put("facultad_codigo", facultad);
			params.put("tpPostgrado", tpPg);
			params.put("nombres", nombres);
			params.put("apellidoPaterno", appPaterno);
			params.put("apellidoMaterno", appMaterno);
			params.put("mencion_nombre", mencion);
		}
		l = queryForList("alumnoSqlMap.getAlumnoList", params);
		for (int i = 0; i < l.size(); i++) {
			Alumno ae = (Alumno) l.get(i);
			Map param = new HashMap();
			param.put("idAlumnoEgresado", new Integer(ae.getId()));
			ae.setGradosYTitulos(queryForList("gradoTituloSqlMap.getGradoTituloList", param));
			ae.setIdiomas(queryForList("tpIdiomaSqlMap.getTpIdiomaList", param));
			ae.setPlanDeEstudios(queryForList("planEstudioSqlMap.getPlanEstudioList", param));
		}
		return l; 
	}

	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		Alumno ae = (Alumno) queryForObject("alumnoSqlMap.getAlumno", new Integer(id));
		Map param = new HashMap();
		param.put("idAlumnoEgresado", new Integer(ae.getId()));
		ae.setGradosYTitulos(queryForList("gradoTituloSqlMap.getGradoTituloList", param));
		ae.setIdiomas(queryForList("tpIdiomaSqlMap.getTpIdiomaList", param));
		ae.setPlanDeEstudios(queryForList("planEstudioSqlMap.getPlanEstudioList", param));
		return ae;
	}

	public void insertAlumno(Alumno a) {
		// TODO Auto-generated method stub
		a.setFechaRegistro(new Date());
		insert("alumnoSqlMap.insertAlumno", a);
	}

	public void updateAlumno(Alumno aNew, Alumno aOld) {
		// TODO Auto-generated method stub
		update("alumnoSqlMap.updateAlumno", aNew);
	}

	public void deleteAlumno(int id) {
		// TODO Auto-generated method stub
		delete("alumnoSqlMap.deleteAlumno", new Integer(id));
	}

	public void deleteAlumno(Alumno a) {
		// TODO Auto-generated method stub
		deleteAlumno(a.getId());
	}

	public Facultad getFacultad(String codigo) {
		// TODO Auto-generated method stub
		return (Facultad) queryForObject("alumnoSqlMap.getFacultad", codigo);
	}

	public List getFacultadList() {
		// TODO Auto-generated method stub
		return queryForList("alumnoSqlMap.getFacultadList", null);
	}

	public TpPostgrado getTpPostgrado(String codigo) {
		// TODO Auto-generated method stub
		return (TpPostgrado) queryForObject("alumnoSqlMap.getTpPostgrado", codigo);
	}

	public List getTpPostgradoList() {
		// TODO Auto-generated method stub
		return queryForList("alumnoSqlMap.getTpPostgradoList", null);
	}

	public TpModalidadIngreso getTpModalidadIngreso(String codigo) {
		// TODO Auto-generated method stub
		return (TpModalidadIngreso) queryForObject("alumnoSqlMap.getTpModalidadIngreso", codigo);
	}

	public List getTpModalidadIngresoList() {
		// TODO Auto-generated method stub
		return queryForList("alumnoSqlMap.getTpModalidadIngresoList", null);
	}

	public void insertImpresionCertificadoAlumno(ImpresionCertificadoAlumno ica) {
		// TODO Auto-generated method stub
		if (ica.getFechaReg() == null) {
			ica.setFechaReg(new Date());
		}
		if (ica.getEstado() == null || ica.getEstado().length() <= 0) {
			ica.setEstado(ImpresionCertificadoAlumno.IMPRESO);
		}
		insert("alumnoSqlMap.insertImpresionCertificadoAlumno", ica);
		
	}
}