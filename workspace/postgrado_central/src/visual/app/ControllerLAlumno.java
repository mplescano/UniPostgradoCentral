package visual.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.ibatis.dao.client.DaoException;
import dominio.negocio.Alumno;
import servicio.AppServicio;
import visual.app.tableModel.TableModelListAlumno;
import visual.iface.ControllerLIface;
import visual.util.ComboBoxUtils;
import visual.util.DReportPrint;
import visual.util.Mensaje;
import visual.util.PanelUtils;
import visual.util.WindowUtils;

public class ControllerLAlumno implements ControllerLIface {
	LBuscador m_d_vista;
	final static String REPORTE = "reportes/REPORTE_ALUMNO_POSTGRADO_EGRESADO.jasper";
	Map params = new HashMap();
/**
 * Constructores
 */
	public ControllerLAlumno() {
		m_d_vista = new LBuscador();
		initialize();
		// TODO Auto-generated constructor stub
	}

	public ControllerLAlumno(LBuscador m_d_vista) {
		this.m_d_vista = m_d_vista;
		initialize();
		// TODO Auto-generated constructor stub
	}
	
	public void loadData() {
		//AppServicio.getInstance().getAlumnoList(null)
		m_d_vista.getLstTbListado().setModel(new TableModelListAlumno(null));
	}
	
/**
 * Carga los listeners
 */
	public void initialize() {
		// TODO Auto-generated method stub
		List listCriterios = new ArrayList();
		
		Map hmVacio = new HashMap();
		hmVacio.put("label", "[SELECCIONE]");
		hmVacio.put("value", "");
		
		Map hmNombre = new HashMap();
		hmNombre.put("label", "Nombres");
		hmNombre.put("value", "nombres");
		
		Map hmAppPat = new HashMap();
		hmAppPat.put("label", "Apellido Pat.");
		hmAppPat.put("value", "apellidoPaterno");
		
		Map hmAppMat = new HashMap();
		hmAppMat.put("label", "Apellido Mat.");
		hmAppMat.put("value", "apellidoMaterno");
		
		Map hmFac = new HashMap();
		hmFac.put("label", "Facultad (Abrv.)");
		hmFac.put("value", "facultad_codigo");

		Map hmTpPost = new HashMap();
		hmTpPost.put("label", "Tipo de Carrera (DC, MA, 2E)");
		hmTpPost.put("value", "tpPostgrado_codigo");
		
		Map hmMencion = new HashMap();
		hmMencion.put("label", "Mención en:");
		hmMencion.put("value", "mencion_nombre");
		
		Map hmPa = new HashMap();
		hmPa.put("label", "Per. Acad.");
		hmPa.put("value", "periodoAcademico");
		
		listCriterios.add(hmVacio);
		listCriterios.add(hmNombre);
		listCriterios.add(hmAppPat);
		listCriterios.add(hmAppMat);
		listCriterios.add(hmFac);
		listCriterios.add(hmTpPost);
		listCriterios.add(hmMencion);
		listCriterios.add(hmPa);
		
		ComboBoxUtils.addItems(listCriterios, m_d_vista.getLstCbCriterio01());
		ComboBoxUtils.addItems(listCriterios, m_d_vista.getLstCbCriterio02());
		ComboBoxUtils.addItems(listCriterios, m_d_vista.getLstCbCriterio03());
		
		m_d_vista.getLstCbCriterio01().setRenderer(ComboBoxUtils.getTextRenderer("label"));
		m_d_vista.getLstCbCriterio02().setRenderer(ComboBoxUtils.getTextRenderer("label"));
		m_d_vista.getLstCbCriterio03().setRenderer(ComboBoxUtils.getTextRenderer("label"));
		//adicionar action listener
		//adicionara los items al combobox
		loadData();
		//System.out.println("data cargada");
		addListeners();
		m_d_vista.setSize(800, 600);
		WindowUtils.centerWindow(m_d_vista);
		m_d_vista.setVisible(true);		
	}
	
	public static void main (String args[]) {
		new ControllerLAlumno();
	}

	public void addListeners() {
		// TODO Auto-generated method stub
		m_d_vista.getLstBtAdd().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				boolean ok = (new ControllerFAlumno(new FAlumno(m_d_vista))).isInsertOk();
				loadData();
				if (ok) {
					
				}
			}
		});
		
		m_d_vista.getLstBtEdit().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = m_d_vista.getLstTbListado().getSelectedRow();
				Alumno ae = (Alumno) ((TableModelListAlumno) m_d_vista.getLstTbListado().getModel()).getSelectedRow(row);
				if (ae != null) {
					ae = AppServicio.getInstance().getAlumno(ae.getId());
					boolean ok = (new ControllerFAlumno(new FAlumno(m_d_vista), ae)).isUpdateOk();
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
								a = (Alumno) ((TableModelListAlumno) m_d_vista.getLstTbListado().getModel()).getSelectedRow(row);
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
				Alumno ae = (Alumno) ((TableModelListAlumno) m_d_vista.getLstTbListado().getModel()).getSelectedRow(row);
				if (ae != null) {
					ae = AppServicio.getInstance().getAlumno(ae.getId());
					if (ae.isEsIngreso()) {
						Alumno aeClon;
						try {
							aeClon = (Alumno) ae.clone();
							new ControllerLPlanEstudio(new LPlanEstudio(m_d_vista,true),aeClon);
							AppServicio.getInstance().updateAlumno(aeClon, ae);
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
					else {
						Mensaje.error(m_d_vista, "Este alumno no ha ingresado", "Error");
					}
				}
			}
		});
		
		PanelUtils.setMnemonicCustomize(m_d_vista.getJContentPane(),KeyStroke.getKeyStroke("M"), m_d_vista.getLstBtShow());
		
		m_d_vista.getLstBtBuscar().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				params = new HashMap();
				String key;
				String value;
				
				key = (String)((HashMap) m_d_vista.getLstCbCriterio01().getSelectedItem()).get("value");
				value = m_d_vista.getLstTfCriterio01().getText().trim();
				
				if (key != null && value != null && key.length() > 0 && value.length() > 1) {
					params.put(key, value);
				}
				
				key = (String)((HashMap) m_d_vista.getLstCbCriterio02().getSelectedItem()).get("value");
				value = m_d_vista.getLstTfCriterio02().getText().trim();
				//System.out.println(params+",key="+key+",value:"+value);
				if (key != null && value != null && key.length() > 0 && value.length() > 1) {
					params.put(key, value);
				}
									
				key = (String)((HashMap) m_d_vista.getLstCbCriterio03().getSelectedItem()).get("value");
				value = m_d_vista.getLstTfCriterio03().getText().trim();
				
				if (key != null && value != null && key.length() > 0 && value.length() > 1) {
					params.put(key, value);
				}
				m_d_vista.getLstTbListado().setModel(new TableModelListAlumno(AppServicio.getInstance().getAlumnoList(params)));
			}
		});
		
		m_d_vista.getLstBtAll().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m_d_vista.getLstTbListado().setModel(new TableModelListAlumno(AppServicio.getInstance().getAlumnoList(null)));
			}
		});
		
		m_d_vista.getLstBtImp().addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					new DReportPrint(m_d_vista, true, REPORTE, ((TableModelListAlumno)m_d_vista.getLstTbListado().getModel()).getList()).setVisible(true);
				} catch (RuntimeException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					Mensaje.error(m_d_vista, e.toString()+" \n "+ e.getLocalizedMessage(), "Error");
				}
			}
			
		});
	}
}