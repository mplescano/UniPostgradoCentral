package persistencia.iface;

import dominio.seguridad.GrupoUsuarios;
import dominio.seguridad.Usuario;

public interface UsuarioDao {
	
	Usuario getUsuario (int id);
	
	Usuario getUsuario (String username);
	
	boolean isPermitido (Usuario user, String moduloToken, String tpOperacion);
	
	boolean isPermitido (GrupoUsuarios grupo, String moduloToken, String tpOperacion);
	
	/**
	 * @param user
	 * @param clave, la clave está en hash md5
	 * @return
	 */
	boolean validar (Usuario user, String clave);
	
	/**
	 * @param user
	 * @param claveNew, la clave está en hash md5
	 * @param claveOld, la clave está en hash md5
	 */
	void updateClave (Usuario user, String claveNew, String claveOld);
	
}