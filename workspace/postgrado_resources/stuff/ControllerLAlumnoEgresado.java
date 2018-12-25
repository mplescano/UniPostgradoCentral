package visual.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ibatis.dao.client.DaoException;

import dominio.negocio.Alumno;
import servicio.AppServicio;
import util.Mensaje;
import visual.app.tableModel.TableModelListAlumnoEgresado;
import visual.iface.ControllerLIface;
import visual.util.PanelUtils;

public class ControllerLAlumnoEgresado implements ControllerLIface {
	LBuscador m_d_vista;
/**
 * Constructores
 */
	public ControllerLAlumnoEgresado() {
		m_d_vista = new LBuscador();
		initialize();
		// TODO Auto-generated constructor stub
	}

	public ControllerLAlumnoEgresado(LBuscador m_d_vista) {
		this.m_d_vista = m_d_vista;
		initialize();
		// TODO Auto-generated constructor stub
	}
	
	public void loadData() {
		// TODO Auto-generated method stub
		m_d_vista.getLstTbListado().setModel(new TableModelListAlumnoEgresado(AppServicio.getInstance().getAlumnoList(null)));
		
	}
	
/**
 * Carga los listeners
 */
	public void initialize() {
		// TODO Auto-generated method stub
		//adicionar action listener
		//adicionara los items al combobox
		loadData();
		System.out.println("data cargada");
		addListeners();
		m_d_vista.setVisible(true);		
	}
	
	public static void main (String args[]) {
		new ControllerLAlumnoEgresado();
	}

	public void addListeners() {
		// TODO Auto-generated method stub
		m_d_vista.getLstBtAdd().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				boolean ok = (new ControllerFAlumnoEgresado(new FAlumnoEgresado(m_d_vista))).isInsertOk();
				loadData();
				if (ok) {
					
				}
			}
		});
		
		m_d_vista.getLstBtEdit().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = m_d_vista.getLstTbListado().getSelectedRow();
				Alumno ae = (Alumno) ((TableModelListAlumnoEgresado) m_d_vista.getLstTbListado().getModel()).getSelectedRow(row);
				if (ae != null) {
					ae = AppServicio.getInstance().getAlumno(ae.getId());
					boolean ok = (new ControllerFAlumnoEgresado(new FAlumnoEgresado(m_d_vista), ae)).isUpdateOk();
					loadData();
					if (ok) {
					}
				}
			}
		});
		
		m_d_vista.getLstBtClose().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				m_d_vista.dispose();
			}
		});
		
		
		class OnDelRow implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = Mensaje.confirmar(m_d_vista,"Está Seguro de Borrar las filas seleccionadas?", "Borrar");
				try {
					if (option == JOptionPane.YES_OPTION) {
						for (int row = 0, rowCount = m_d_vista.getLstTbListado().getRowCount(); row < rowCount; row++) {
							Boolean b;
							b = (Boolean) m_d_vista.getLstTbListado().getValueAt(row,0);
							if (b.booleanValue()) {
								Alumno a;
								a = (Alumno) ((TableModelListAlumnoEgresado) m_d_vista.getLstTbListado().getModel()).getSelectedRow(row);
								AppServicio.getInstance().deleteAlumno(a);
							}
						}
					}
				} catch (DaoException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					Mensaje.error(m_d_vista,e1.getMessage(),"Error al Borrar");
				}
				loadData();
			}
		}
		
		m_d_vista.getLstBtDel().addActionListener(new OnDelRow());
		
		PanelUtils.addBindingKeyTable(m_d_vista.getJContentPane(),m_d_vista.getLstTbListado());

		PanelUtils.addActionKeyStroke(m_d_vista.getJContentPane(),JComponent.WHEN_IN_FOCUSED_WINDOW, KeyStroke.getKeyStroke("INSERT"), "insertar", new AbstractAction () {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m_d_vista.getLstBtAdd().doClick();
			}
			
		});
		
		PanelUtils.addActionKeyStroke(m_d_vista.getJContentPane(),JComponent.WHEN_IN_FOCUSED_WINDOW, KeyStroke.getKeyStroke("ENTER"), "editar", new AbstractAction () {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m_d_vista.getLstBtEdit().doClick();
			}
			
		});
		
		PanelUtils.addActionKeyStroke(m_d_vista.getJContentPane(),JComponent.WHEN_IN_FOCUSED_WINDOW, KeyStroke.getKeyStroke("DELETE"), "borrar", new AbstractAction () {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m_d_vista.getLstBtDel().doClick();
			}
		});
		
		m_d_vista.getLstTbListado().addKeyListener(new KeyAdapter () {
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == 0) {
					m_d_vista.getLstBtEdit().doClick();
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_INSERT && e.getModifiers() == 0) {
					m_d_vista.getLstBtAdd().doClick();
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_DELETE && e.getModifiers() == 0) {
					m_d_vista.getLstBtDel().doClick();
					e.consume();
				}
			}
		});
		m_d_vista.getLstBtShow().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = m_d_vista.getLstTbListado().getSelectedRow();
				Alumno ae = (Alumno) ((TableModelListAlumnoEgresado) m_d_vista.getLstTbListado().getModel()).getSelectedRow(row);
				if (ae != null) {
					ae = AppServicio.getInstance().getAlumno(ae.getId());
					Alumno aeClon;
					try {
						aeClon = (Alumno) ae.clone();
						new ControllerLPlanEstudio(new LPlanEstudio(m_d_vista,true),aeClon);
						AppServicio.getInstance().updateAlumno(aeClon,ae);
						//Mensaje.info(m_d_vista,"Actualizado exitoso", "Exito");
					} 
					catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					catch (DaoException d) {
						Mensaje.error(m_d_vista,d.getMessage(),"Error");
					}
				}
			}
		});
		PanelUtils.setMnemonicCustomize(m_d_vista.getJContentPane(),KeyStroke.getKeyStroke("M"), m_d_vista.getLstBtShow());
	}
}
