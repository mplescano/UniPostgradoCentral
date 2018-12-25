package persistencia.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.dao.client.DaoManager;
import dominio.negocio.EstudioPostgrado;
import dominio.negocio.Facultad;
import dominio.negocio.Mencion;
import dominio.negocio.TpPostgrado;
import persistencia.iface.EstudioPostgradoDao;

public class EstudioPostgradoImpDao extends BaseSqlMapDao implements EstudioPostgradoDao {

	public EstudioPostgradoImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getEstudioPostgradoList(Map params) {
		// TODO Auto-generated method stub
		if (params != null) {
			String facultad_codigo = (String) params.get("facultad_codigo");
			String tpPostgrado_codigo = (String) params.get("tpPostgrado_codigo");
			params.put("facultad_codigo", prepareStringSafe(facultad_codigo));
			params.put("tpPostgrado_codigo", prepareStringSafe(tpPostgrado_codigo));
		}
		return queryForList("estudioPostgradoSqlMap.getEstudioPostgradoList", params);
	}

	public EstudioPostgrado getEstudioPostgrado(int codigo) {
		// TODO Auto-generated method stub
		return (EstudioPostgrado) queryForObject("estudioPostgradoSqlMap.getEstudioPostgrado", new Integer(codigo));
	}

	public List getMencionList(Map params) {
		// TODO Auto-generated method stub
		if (params != null) {
			String idEstudioPostgrado = (String) params.get("idEstudioPostgrado");
			String facultad_codigo = (String) params.get("facultad_codigo");
			String tpPostgrado_codigo = (String) params.get("tpPostgrado_codigo");
			params.put("idEstudioPostgrado", prepareStringSafe(idEstudioPostgrado));
			params.put("facultad_codigo", prepareStringSafe(facultad_codigo));
			params.put("tpPostgrado_codigo", prepareStringSafe(tpPostgrado_codigo));
		}
		return queryForList("estudioPostgradoSqlMap.getMencionList", params);
	}

	public Mencion getMencion(String codigo) {
		// TODO Auto-generated method stub
		codigo = prepareStringSafe(codigo);
		return (Mencion) queryForObject("estudioPostgradoSqlMap.getMencion", codigo);
	}

	public List getMencionList(Facultad fc, TpPostgrado tp) {
		// TODO Auto-generated method stub
		Map params = null;
		if (fc != null && tp != null) {
			params = new HashMap();
			params.put("facultad_codigo", prepareStringSafe(fc.getCodigo()));
			params.put("tpPostgrado_codigo", prepareStringSafe(tp.getCodigo()));
			return queryForList("estudioPostgradoSqlMap.getMencionList", params);
		}
		return null;
	}

//	public EstudioPostgrado getEstudioPostgrado(Facultad fc, TpPostgrado tp) {
//		// TODO Auto-generated method stub
//		Map params = new HashMap();
//		params.put("facultad_codigo", fc.getCodigo());
//		params.put("tpPostgrado_codigo", tp.getCodigo());
//		return (EstudioPostgrado) queryForObject("estudioPostgradoSqlMap.getEstudioPostgradoList", params);
//	}
}
