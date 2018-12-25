package persistencia.iface;

import java.util.List;
import java.util.Map;
import dominio.negocio.PlanEstudio;

public interface PlanEstudioDao {
	/**
	 * @param params parametros de:idAlumnoEgresado,codigoCurso,nombreCurso,docenteCurso,periodoCurso
	 * @return Retorno una lista de objetos PlanEstudio
	 */
	List getPlanEstudioList (Map params);
	
	PlanEstudio getPlanEstudio (int id);
	
	void insertPlanEstudio (PlanEstudio pe);
	
	void updatePlanEstudio (PlanEstudio peNew, PlanEstudio peOld);
	
	void deletePlanEstudio (int id);
	
	void deletePlanEstudio (PlanEstudio pe);

}
