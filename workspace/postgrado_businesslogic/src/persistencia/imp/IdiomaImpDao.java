package persistencia.imp;

import java.util.List;
import java.util.Map;
import com.ibatis.dao.client.DaoManager;
import dominio.negocio.TpIdioma;
import persistencia.iface.IdiomaDao;

public class IdiomaImpDao extends BaseSqlMapDao implements IdiomaDao {

	public IdiomaImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getIdiomaList(Map params) {
		// TODO Auto-generated method stub
		String nomIdioma = prepareForSearh((String) params.get("nombreIdioma"));
		Integer idAE = (Integer) params.get("idAlumnoEgresado");
		
		params.put("nombreIdioma", nomIdioma);
		params.put("idAlumnoEgresado", idAE);
		return queryForList("tpIdiomaSqlMap.getTpIdiomaLists", params);
	}

	public TpIdioma getIdioma(int id) {
		// TODO Auto-generated method stub
		return (TpIdioma) queryForObject("tpIdiomaSqlMap.getTpIdioma", new Integer(id));
	}

	public void insertIdioma(TpIdioma idm) {
		// TODO Auto-generated method stub
		insert("tpIdiomaSqlMap.insertTpIdioma", idm);
	}

	public void deleteIdioma(int id) {
		// TODO Auto-generated method stub
		delete("tpIdiomaSqlMap.deleteTpIdioma", new Integer(id));
	}

	public void deleteIdioma(TpIdioma idm) {
		// TODO Auto-generated method stub
		deleteIdioma(idm.getId());
	}
}