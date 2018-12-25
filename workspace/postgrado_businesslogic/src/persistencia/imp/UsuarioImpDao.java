package persistencia.imp;

import java.util.HashMap;
import java.util.Map;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import dominio.seguridad.GrupoUsuarios;
import dominio.seguridad.Usuario;
import persistencia.iface.UsuarioDao;

public class UsuarioImpDao extends BaseSqlMapDao implements UsuarioDao {

	public UsuarioImpDao(DaoManager daoManager) {
		super(daoManager);
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario(int id) {
		// TODO Auto-generated method stub
		Map param = new HashMap();
		param.put("id", new Integer(id));
		Usuario user = (Usuario) queryForObject("usuariosSqlMap.getUsuario", param);
		if (user == null) {
			throw new DaoException("El usuario " + id + "no existe o no tiene clave correcta");
		}
		return user; 
	}

	public Usuario getUsuario(String username) {
		// TODO Auto-generated method stub
		username = prepareStringSafe(username);
		Map param = new HashMap();
		param.put("usuario", username);
		Usuario user = (Usuario) queryForObject("usuariosSqlMap.getUsuario", param);
		if (user == null) {
			throw new DaoException("El usuario " + username + "no existe o no tiene clave correcta");
		}
		return user;
	}

	public boolean isPermitido(Usuario user, String moduloToken,
			String tpOperacion) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPermitido(GrupoUsuarios grupo, String moduloToken,
			String tpOperacion) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validar(Usuario user, String clave) {
		// TODO Auto-generated method stub
		boolean check = false;
		String nombreusuario = prepareStringSafe(user.getUsuario());
		clave = prepareStringSafe(clave);
		Map param = new HashMap();
		param.put("usuario", nombreusuario);
		param.put("clave", clave);
		Integer checkInteger = (Integer) queryForObject("usuariosSqlMap.checkClave", param);
		if (checkInteger != null) {
			int checkInt = checkInteger.intValue();
			if (checkInt == 1) {
				check = true;
			}
		}
		return check;
	}

	public void updateClave(Usuario user, String claveNew, String claveOld) {
		// TODO Auto-generated method stub
		if (validar(user, claveOld) && !claveOld.equals(claveNew)) {
			claveNew = prepareStringSafe(claveNew);
			claveOld = prepareStringSafe(claveOld);
			Map params = new HashMap();
			params.put("claveNew", claveNew);
			params.put("id", new Integer(user.getId()));
			params.put("username", user.getUsuario());
			params.put("claveOld", claveOld);
			int checkUpdate = update("usuariosSqlMap.updateClave", params);
			if (checkUpdate == 0) {
				throw new DaoException("Falló la actualización de su clave");
			}
		}
		else {
			throw new DaoException("El usuario " + user.getUsuario() + " no existe o la clave antigua no es correcta o que son iguales las claves la cual no se permite");
		}
	}
}