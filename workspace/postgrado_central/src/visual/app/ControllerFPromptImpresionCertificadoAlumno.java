package visual.app;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ibatis.dao.client.DaoException;
import dominio.negocio.ImpresionCertificadoAlumno;

import servicio.AppServicio;
import util.Utilities;
import visual.iface.ControllerFIface;
import visual.util.Mensaje;
import visual.util.WindowUtils;

public class ControllerFPromptImpresionCertificadoAlumno implements ControllerFIface {
	FPromptImpresionCertificadoAlumno m_d_vista;
	ImpresionCertificadoAlumno imp;
	boolean insertOk = false;
	
	ControllerFPromptImpresionCertificadoAlumno (Dialog d, int idAlumno) {
		m_d_vista = new FPromptImpresionCertificadoAlumno(d);
		imp = new ImpresionCertificadoAlumno();
		imp.setIdAlumno(idAlumno);
		initialize();
	}

	public void settingComponents() {
		// TODO Auto-generated method stub
		
	}

	public void loadData() {
		// TODO Auto-generated method stub

	}

	public void initialize() {
		// TODO Auto-generated method stub
		settingComponents();
		loadData();
		addListeners();
		WindowUtils.centerDialogInParent(m_d_vista);
		m_d_vista.setVisible(true);
	}

	public void executeData() {
		// TODO Auto-generated method stub
		if (checkData()) {
			recopileData();
			try {
				AppServicio.getInstance().insertImpresionCertificadoAlumno(imp);
				insertOk = true;
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Mensaje.error(m_d_vista, e.getLocalizedMessage(), "Error");
				insertOk = false;
			}
		}
	}

	public boolean checkData() {
		// TODO Auto-generated method stub
		if (Utilities.isEmpty(m_d_vista.getTfCodigo().getText())) {
			Mensaje.error(m_d_vista, "Falta completar el codigo", "Error");
			return false;
		}
		if (Utilities.isEmpty(m_d_vista.getTfObs().getText())) {
			//Mensaje.error(m_d_vista, "Falta completar el codigo", "Error");
			//return false;
		}
		return true;
	}

	public void recopileData() {
		// TODO Auto-generated method stub
		imp.setCodigo(m_d_vista.getTfCodigo().getText());
		imp.setObservacion(m_d_vista.getTfObs().getText());
	}

	public void undoData() {
		// TODO Auto-generated method stub

	}

	public void addListeners() {
		// TODO Auto-generated method stub
		m_d_vista.getBtAceptar().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				executeData();
				m_d_vista.dispose();
			}
		});
		m_d_vista.getBtCancelar().addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				m_d_vista.dispose();
			}
		});
	}

	public boolean isInsertOk() {
		// TODO Auto-generated method stub
		return insertOk;
	}

	public boolean isUpdateOk() {
		// TODO Auto-generated method stub
		return false;
	}

	public ImpresionCertificadoAlumno getImp() {
		return imp;
	}
}