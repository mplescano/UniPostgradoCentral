package persistencia.imp;

import java.util.HashMap;
import java.util.Map;
import com.ibatis.dao.client.DaoManager;
import dominio.Secuencia;
import persistencia.iface.SecuenciaDao;

public class SecuenciaImpDao extends BaseSqlMapDao implements SecuenciaDao {

	public SecuenciaImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public int getNextId(String tabla) {
		// TODO Auto-generated method stub
		if (tabla != null && (
			!tabla.equals(Secuencia.ALUMNO) &&
			!tabla.equals(Secuencia.GRADOTITULO) &&
			!tabla.equals(Secuencia.IDIOMA) &&
			!tabla.equals(Secuencia.PLANESTUDIO)
		)) {
			//botar una excepcion;
			return 0;
		}
		else if (tabla != null) {
			Map params = new HashMap(); 
			params.put("tabla", tabla);
			if (tabla.equals(Secuencia.ALUMNO)) {
				params.put("campo", Secuencia.ALUMNOEGRESADO_CAMPO);
			}
			if (tabla.equals(Secuencia.GRADOTITULO)) {
				params.put("campo", Secuencia.GRADOTITULO_CAMPO);
			}
			if (tabla.equals(Secuencia.IDIOMA)) {
				params.put("campo", Secuencia.IDIOMA_CAMPO);
			}
			if (tabla.equals(Secuencia.PLANESTUDIO)) {
				params.put("campo", Secuencia.PLANESTUDIO_CAMPO);
			}
			Integer seq = (Integer) queryForObject("secuenciaSqlMap.getNextId", params);
			if (seq == null) {
				return 1;
			}
			else {
				return seq.intValue();
			}
		}
		else {
			return 0;
		}
	}

}