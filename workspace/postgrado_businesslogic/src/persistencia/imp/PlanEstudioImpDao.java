package persistencia.imp;

import java.util.List;
import java.util.Map;
import persistencia.iface.PlanEstudioDao;
import com.ibatis.dao.client.DaoManager;
import dominio.negocio.PlanEstudio;

public class PlanEstudioImpDao extends BaseSqlMapDao implements PlanEstudioDao {

	public PlanEstudioImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getPlanEstudioList(Map params) {
		// TODO Auto-generated method stub
		String codCurso = prepareForSearh((String) params.get("codigoCurso"));
		String nomCurso = prepareForSearh((String) params.get("nombreCurso"));
		String profCurso = prepareForSearh((String) params.get("docenteCurso"));
		String perdCurso = prepareForSearh((String) params.get("periodoCurso"));
		
		params.put("codigoCurso", codCurso);
		params.put("nombreCurso", nomCurso);
		params.put("docenteCurso", profCurso);
		params.put("periodoCurso", perdCurso);
		return queryForList("planEstudioSqlMap.getPlanEstudioList", params);
	}

	public PlanEstudio getPlanEstudio(int id) {
		// TODO Auto-generated method stub
		return (PlanEstudio) queryForObject("planEstudioSqlMap.getPlanEstudio", new Integer(id));
	}

	public void insertPlanEstudio(PlanEstudio pe) {
		// TODO Auto-generated method stub
		insert("planEstudioSqlMap.insertPlanEstudio", pe);
	}

	public void updatePlanEstudio(PlanEstudio peNew, PlanEstudio peOld) {
		// TODO Auto-generated method stub
		update("planEstudioSqlMap.updatePlanEstudio", peNew);
	}

	public void deletePlanEstudio(int id) {
		// TODO Auto-generated method stub
		delete("planEstudioSqlMap.deletePlanEstudio", new Integer(id));
	}

	public void deletePlanEstudio(PlanEstudio pe) {
		// TODO Auto-generated method stub
		deletePlanEstudio(pe.getId());
	}
}