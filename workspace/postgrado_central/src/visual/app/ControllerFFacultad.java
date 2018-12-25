package visual.app;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import servicio.AppServicio;
import visual.app.tableModel.TableModelListFacultad;
import visual.iface.ControllerFIface;
import visual.util.PanelUtils;
import visual.util.WindowUtils;

public class ControllerFFacultad implements ControllerFIface {
	FFacultad m_d_vista;
	
	public ControllerFFacultad (Frame f) {
		m_d_vista = new FFacultad(f);
		initialize();
	}
	
	public void settingComponents() {
		// TODO Auto-generated method stub
		m_d_vista.getFac_tb_facultad().addPropertyChangeListener("model", new PropertyChangeListener () {
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				PanelUtils.packColumns(m_d_vista.getFac_tb_facultad(), 4);
			}
		});
		m_d_vista.getFac_tb_facultad().setModel(new TableModelListFacultad(AppServicio.getInstance().getFacultadList()));
		m_d_vista.getFac_bt_close().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				m_d_vista.dispose();
			}
		});
	}

	public void loadData() {
		// TODO Auto-generated method stub
		
	}

	public void initialize() {
		// TODO Auto-generated method stub
		settingComponents();
		WindowUtils.centerDialogInParent(m_d_vista);
		m_d_vista.setVisible(true);
	}

	public void executeData() {
		// TODO Auto-generated method stub
		
	}

	public boolean checkData() {
		// TODO Auto-generated method stub
		return false;
	}

	public void recopileData() {
		// TODO Auto-generated method stub
		
	}

	public void undoData() {
		// TODO Auto-generated method stub
		
	}

	public void addListeners() {
		// TODO Auto-generated method stub
		
	}

	public boolean isInsertOk() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUpdateOk() {
		// TODO Auto-generated method stub
		return false;
	}

}
