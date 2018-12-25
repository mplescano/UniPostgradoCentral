package persistencia.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.dao.client.DaoManager;
import dominio.negocio.Ubigeo;
import persistencia.iface.UbigeoDao;

public class UbigeoImpDao extends BaseSqlMapDao implements UbigeoDao {

	public UbigeoImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public List getUbigeoList() {
		// TODO Auto-generated method stub
		return queryForList("ubigeoSqlMap.getUbigeoList", null);
	}

	public List getUbigeoListPorNombre(String nombre) {
		// TODO Auto-generated method stub
		nombre = prepareStringSafe(nombre);
		if (nombre.length() > 0) {
			return queryForList("ubigeoSqlMap.getUbigeoListPorNombre", nombre);			
		}
		return null;
	}

	public Ubigeo getUbigeo(String id) {
		// TODO Auto-generated method stub
		return (Ubigeo) queryForObject("ubigeoSqlMap.getUbigeo", id);
	}

	public void insertUbigeo(Ubigeo a) {
		// TODO Auto-generated method stub

	}

	public void updateUbigeo(Ubigeo aNew, Ubigeo aOld) {
		// TODO Auto-generated method stub

	}

	public void deleteUbigeo(Ubigeo a) {
		// TODO Auto-generated method stub

	}

	public List getUbigeoListPorDst(String codPais, String codDpt, String codPrv) {
		// TODO Auto-generated method stub
		codPais = prepareStringSafe(codPais);
		codDpt = prepareStringSafe(codDpt);
		codPrv = prepareStringSafe(codPrv);
		if (codPais.length() > 0 && codDpt.length() > 0 && codPrv.length() > 0) {
			Map param = new HashMap(3);
			param.put("pais", codPais);
			param.put("dpt", codDpt);
			param.put("prv", codPrv);
			return queryForList("ubigeoSqlMap.getUbigeoListPorDst", param);			
		}
		return null;
	}

	public List getUbigeoListPorDpt(String codPais) {
		// TODO Auto-generated method stub
		codPais = prepareStringSafe(codPais);
		if (codPais.length() > 0) {
			return queryForList("ubigeoSqlMap.getUbigeoListPorDpt", codPais);
		}
		return null;
	}

	public List getUbigeoViewList(Map params) {
		// TODO Auto-generated method stub
		if (params != null) {
			String codPais = prepareStringSafe((String) params.get("cod_pais"));
			String codDpt = prepareStringSafe((String) params.get("cod_departamento"));
			String codPrv = prepareStringSafe((String) params.get("cod_provincia"));
			String nombre = prepareForSearh(prepareStringSafe((String) params.get("nombre")));
			params.put("cod_pais", codPais);
			params.put("cod_departamento", codDpt);
			params.put("cod_provincia", codPrv);
			params.put("nombre", nombre);
		}
		return queryForList("ubigeoSqlMap.getUbigeoViewListPorDst", params);
	}
}