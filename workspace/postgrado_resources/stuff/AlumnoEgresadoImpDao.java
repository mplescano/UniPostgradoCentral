package persistencia.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import persistencia.iface.AlumnoEgresadoDao;
import com.ibatis.dao.client.DaoManager;
import dominio.negocio.AlumnoEgresado;
import dominio.negocio.Facultad;
import dominio.negocio.GradoTitulo;
import dominio.negocio.TpIdioma;
import dominio.negocio.TpPostgrado;

public class AlumnoEgresadoImpDao extends BaseSqlMapDao implements
		AlumnoEgresadoDao {

	public AlumnoEgresadoImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getAlumnoEgresadoList(Map params) {
		// TODO Auto-generated method stub
		List l;
		if (params != null) {
			String facultad = prepareStringSafe((String) params.get("facultad_codigo"));
			String tpPg = prepareStringSafe((String) params.get("tpPostgrado"));
			
			String nombres = prepareForSearh((String) params.get("nombres"));
			String appPaterno = prepareForSearh((String) params.get("apellidoPaterno"));
			String appMaterno = prepareForSearh((String) params.get("apellidoMaterno"));
			
			params.put("facultad_codigo", facultad);
			params.put("tpPostgrado", tpPg);
			
			params.put("nombres", nombres);
			params.put("apellidoPaterno", appPaterno);
			params.put("apellidoMaterno", appMaterno);
		}
		l = queryForList("alumnoEgresadoSqlMap.getAlumnoEgresadoList", params);
		for (int i = 0; i < l.size(); i++) {
			AlumnoEgresado ae = (AlumnoEgresado) l.get(i);
			Map param = new HashMap();
			param.put("idAlumnoEgresado", new Integer(ae.getId()));
			ae.setGradosYTitulos(queryForList("gradoTituloSqlMap.getGradoTituloList", param));
			ae.setIdiomas(queryForList("tpIdiomaSqlMap.getTpIdiomaList", param));
			ae.setPlanDeEstudios(queryForList("planEstudioSqlMap.getPlanEstudioList", param));
		}
		return l; 
	}

	public AlumnoEgresado getAlumnoEgresado(int id) {
		// TODO Auto-generated method stub
		AlumnoEgresado ae = (AlumnoEgresado) queryForObject("alumnoEgresadoSqlMap.getAlumnoEgresado", new Integer(id));
		Map param = new HashMap();
		param.put("idAlumnoEgresado", new Integer(ae.getId()));
		ae.setGradosYTitulos(queryForList("gradoTituloSqlMap.getGradoTituloList", param));
		ae.setIdiomas(queryForList("tpIdiomaSqlMap.getTpIdiomaList", param));
		ae.setPlanDeEstudios(queryForList("planEstudioSqlMap.getPlanEstudioList", param));
		return ae;
	}

	public void insertAlumnoEgresado(AlumnoEgresado a) {
		// TODO Auto-generated method stub
		a.setFechaRegistro(new Date());
		insert("alumnoEgresadoSqlMap.insertAlumnoEgresado", a);
	}

	public void updateAlumnoEgresado(AlumnoEgresado aNew, AlumnoEgresado aOld) {
		// TODO Auto-generated method stub
		update("alumnoEgresadoSqlMap.updateAlumnoEgresado", aNew);
	}

	public void deleteAlumnoEgresado(int id) {
		// TODO Auto-generated method stub
		delete("alumnoEgresadoSqlMap.deleteAlumnoEgresado", new Integer(id));
	}

	public void deleteAlumnoEgresado(AlumnoEgresado a) {
		// TODO Auto-generated method stub
		deleteAlumnoEgresado(a.getId());
	}

	public Facultad getFacultad(String codigo) {
		// TODO Auto-generated method stub
		return (Facultad) queryForObject("alumnoEgresadoSqlMap.getFacultad", codigo);
	}

	public List getFacultadList() {
		// TODO Auto-generated method stub
		return queryForList("alumnoEgresadoSqlMap.getFacultadList", null);
	}
	

	public TpPostgrado getTpPostgrado(String codigo) {
		// TODO Auto-generated method stub
		return (TpPostgrado) queryForObject("alumnoEgresadoSqlMap.getTpPostgrado", codigo);
	}

	public List getTpPostgradoList() {
		// TODO Auto-generated method stub
		return queryForList("alumnoEgresadoSqlMap.getTpPostgrado", null);
	}
}