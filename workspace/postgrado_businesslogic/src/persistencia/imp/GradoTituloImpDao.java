package persistencia.imp;

import java.util.List;
import java.util.Map;

import persistencia.iface.GradoTituloDao;

import com.ibatis.dao.client.DaoManager;

import dominio.negocio.GradoTitulo;


public class GradoTituloImpDao extends BaseSqlMapDao implements GradoTituloDao {

	public GradoTituloImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getGradoTitutloList(Map params) {
		// TODO Auto-generated method stub
		if (params != null) {
			String nombre = prepareForSearh((String) params.get("nombreGradoTitulo"));
			String org = prepareForSearh((String) params.get("orgProcedencia"));
			String egreso = prepareForSearh((String) params.get("periodoEgreso"));
			
			params.put("nombreGradoTitulo", nombre);
			params.put("orgProcedencia", org);
			params.put("periodoEgreso", egreso);
		}
		return queryForList("gradoTituloSqlMap.getGradoTituloList", params);
	}

	public GradoTitulo getGradoTitulo(int id) {
		// TODO Auto-generated method stub
		return (GradoTitulo) queryForObject("gradoTituloSqlMap.getGradoTitulo", new Integer(id));
	}

	public void insertGradoTitulo(GradoTitulo gt) {
		// TODO Auto-generated method stub
		insert("gradoTituloSqlMap.insertGradoTitulo", gt);
	}

	public void updateGradoTitulo(GradoTitulo gtNew, GradoTitulo gtOld) {
		// TODO Auto-generated method stub
		update("gradoTituloSqlMap.updateGradoTitulo", gtNew);
	}

	public void deleteGradoTitulo(int id) {
		// TODO Auto-generated method stub
		delete("gradoTituloSqlMap.deleteGradoTitulo", new Integer(id));
	}

	public void deleteGradoTitulo(GradoTitulo gt) {
		// TODO Auto-generated method stub
		deleteGradoTitulo(gt.getId());
	}

}
