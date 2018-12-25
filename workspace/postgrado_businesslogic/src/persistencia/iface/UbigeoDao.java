package persistencia.iface;

import java.util.List;
import java.util.Map;

import dominio.negocio.Ubigeo;

public interface UbigeoDao {

	/**
	 * @return lista de objetos Ubigeo
	 */
	public List getUbigeoList ();
	
	public List getUbigeoListPorDpt (String codPais);
	public List getUbigeoListPorDst (String codPais, String codDpt, String codPrv);
	
	public List getUbigeoListPorNombre (String nombre);
	
	public Ubigeo getUbigeo (String id);
	
	public void insertUbigeo (Ubigeo a);
	public void updateUbigeo (Ubigeo aNew, Ubigeo aOld);
	public void deleteUbigeo (Ubigeo a);
	
	/**
	 * @param params parametros de:cod_pais, cod_departamento, cod_provincia, nombre
	 * @return lista de objetos UbigeoView
	 */
	public List getUbigeoViewList (Map params);
	
}
