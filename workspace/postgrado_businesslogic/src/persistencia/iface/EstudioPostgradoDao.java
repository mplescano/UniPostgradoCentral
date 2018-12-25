package persistencia.iface;

import java.util.List;
import java.util.Map;
import dominio.negocio.EstudioPostgrado;
import dominio.negocio.Facultad;
import dominio.negocio.Mencion;
import dominio.negocio.TpPostgrado;

public interface EstudioPostgradoDao {
	List getEstudioPostgradoList (Map params);
	
	EstudioPostgrado getEstudioPostgrado (int codigo);
	
	//EstudioPostgrado getEstudioPostgrado (Facultad fc, TpPostgrado tp);
	
	/**
	 * @param params, parametros son: idEstudioPostgrado, facultad_codigo, tpPostgrado_codigo
	 * @return lista de objectos dominio.Mencion
	 */
	List getMencionList (Map params);
	
	List getMencionList (Facultad fc, TpPostgrado tp);
	
	Mencion getMencion (String codigo);
}
