package servicio;

import com.ibatis.dao.client.DaoException;

import persistencia.DaoConfig;
import persistencia.iface.UsuarioDao;
import util.MD5;
import dominio.seguridad.GrupoUsuarios;
import dominio.seguridad.Usuario;

public class UsuarioServicio {
	private UsuarioDao usDao = (UsuarioDao) DaoConfig.getDaomanager().getDao(UsuarioDao.class);
	
	private static final UsuarioServicio instance = new UsuarioServicio();
	
	private static Usuario userSession;
	
	private UsuarioServicio () {
		
	}
	
	public static UsuarioServicio getInstance () {
		return instance;
	}
	
	public Usuario getUsuario(String username) {
		return usDao.getUsuario(username); 
	}
	
	public boolean isPermitido(Usuario user, String moduloToken, String tpOperacion) {
		return false; 
	}
	
	public boolean isPermitido(GrupoUsuarios grupo, String moduloToken, String tpOperacion) {
		return false; 
	}
	
	public boolean validar(Usuario user, String clave) {
		String claveHash = MD5.digest(clave, "");
		return usDao.validar(user, claveHash); 
	}
	
	public void updateClave(Usuario user, String claveNew, String claveOld) {
		String claveNewHash = MD5.digest(claveNew, "");
		String claveOldHash = MD5.digest(claveOld, "");
		
		usDao.updateClave(user, claveNewHash, claveOldHash);
	}

	public Usuario getUserSession() {
		return userSession;
	}
	

	public void setUserSession(Usuario userSession) {
		if (userSession == null && this.userSession != null) {
			this.userSession = userSession;
		}
		else if (this.userSession == null && userSession != null) {
			this.userSession = userSession;
		}
		else {
			throw new DaoException("Debe salir antes de ingresar con otro nuevo usuario");
		}
	}
}