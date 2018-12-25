package visual.util.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dominio.seguridad.Usuario;
import servicio.UsuarioServicio;
import visual.iface.ControllerFIface;
import visual.util.Mensaje;
import visual.util.WindowUtils;

public class ControllerFLogin implements ControllerFIface {
	private FLogin m_d_vista;
	private boolean validate = false;
	Usuario user;
	
	public ControllerFLogin (FLogin m_d_vista) {
		// TODO Auto-generated constructor stub
		if (m_d_vista == null) {
			throw new IllegalArgumentException("No se ingresa valores nulos");
		}
		this.m_d_vista = m_d_vista;
		initialize();
	}

	public void loadData() {
		// TODO Auto-generated method stub
	}

	public void initialize() {
		// TODO Auto-generated method stub
		user = new Usuario();
		addListeners();
		WindowUtils.centerDialogInParent(m_d_vista);
		m_d_vista.setVisible(true);
	}

	public void executeData() {
		// TODO Auto-generated method stub
		if (checkData()) {
			recopileData();
			String clave = new String(m_d_vista.getLgn_tfClave().getPassword());
			try {
				if (UsuarioServicio.getInstance().validar(user,clave)) {
					validate = true;
					this.m_d_vista.dispose();
				}
				else {
					Mensaje.error(this.m_d_vista, "No existe el usuario o la clave no es la correcta, intente de nuevo", "Error");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Mensaje.error(this.m_d_vista, e.getMessage(), "Error");
			}
		}
		else {
			Mensaje.error(this.m_d_vista, "Revise los campos, no deben estar vacios", "Error");
		}

	}

	public boolean checkData() {
		// TODO Auto-generated method stub
		if (m_d_vista.getLgn_tfUsuario().getText() != null && m_d_vista.getLgn_tfUsuario().getText().trim().length() > 0) {
			String clave = new String(m_d_vista.getLgn_tfClave().getPassword());
			if (clave != null && clave.length() > 0) {
				return true;
			}
		}
		return false;
	}

	public void recopileData() {
		// TODO Auto-generated method stub
		user.setUsuario(m_d_vista.getLgn_tfUsuario().getText());
	}

	public void undoData() {
		// TODO Auto-generated method stub

	}

	public void addListeners() {
		// TODO Auto-generated method stub
		m_d_vista.getLgn_btAceptar().addActionListener(new OnValidate());
		m_d_vista.getLgn_btSalir().addActionListener(new OnClose());
	}

	public boolean isInsertOk() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUpdateOk() {
		// TODO Auto-generated method stub
		return false;
	}
	
	class OnValidate implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			executeData();
		}
		
	}
	
	class OnClose implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			m_d_vista.dispose();
		}
		
	}

	public boolean isValidate() {
		return validate;
	}

	public void settingComponents() {
		// TODO Auto-generated method stub
		
	}
}
