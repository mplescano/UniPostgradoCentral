package persistencia.iface;

import java.util.List;
import java.util.Map;
import dominio.negocio.TpIdioma;

public interface IdiomaDao {
	/**
	 * @param params parametros de:idAlumnoEgresado,nombreIdioma
	 * @return REtorna una lista de objetos TpIdioma
	 */
	List getIdiomaList (Map params);
	
	TpIdioma getIdioma (int id);
	
	void insertIdioma (TpIdioma idm);
	
	void deleteIdioma (int id);
	
	void deleteIdioma (TpIdioma idm);
}