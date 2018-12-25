package visual.util;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import servicio.AppServicio;
import visual.app.tableModel.TableModelListUbigeo;
import javax.swing.JScrollPane;

public class LBuscadorUbigeo extends JDialog {
	private Object objectRow = null;	
	private JPanel jContentPane = null;
	private JTextField ub_tf_criterio = null;
	private JButton ub_bt_buscar = null;
	private JComboBox ub_cb_criterio = null;
	private JButton ub_bt_todo = null;
	private JButton ub_bt_cerrar = null;
	private JLabel ub_lb_criterio = null;
	private JScrollPane ub_sp_list_ubigeos = null;
	private JTable ub_tb_list_ubigeos = null;
	private JButton ub_bt_aceptar = null;

	/**
	 * This method initializes eb_tf_criterio	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUb_tf_criterio() {
		if (ub_tf_criterio == null) {
			ub_tf_criterio = new JTextField();
			ub_tf_criterio.setBounds(new java.awt.Rectangle(235,25,236,21));
		}
		return ub_tf_criterio;
	}

	/**
	 * This method initializes ub_bt_buscar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUb_bt_buscar() {
		if (ub_bt_buscar == null) {
			ub_bt_buscar = new JButton();
			ub_bt_buscar.setBounds(new java.awt.Rectangle(485,25,76,21));
			ub_bt_buscar.setText("Buscar");
			ub_bt_buscar.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Map params = new HashMap();
					String keyStr = (String) getUb_tf_criterio().getText();
					//params.put("cod_pais", Ubigeo.PERU);
					//params.put("cod_departamento", Ubigeo.DPT_LIMA);
					//params.put("cod_provincia", Ubigeo.PRV_LIMA); 
					params.put("nombre", keyStr);
					getUb_tb_list_ubigeos().setModel(new TableModelListUbigeo(AppServicio.getInstance().getUbigeoViewList(params)));
				}
			});
		}
		return ub_bt_buscar;
	}

	/**
	 * This method initializes ub_cb_criterio	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getUb_cb_criterio() {
		if (ub_cb_criterio == null) {
			//new String[]{"DISTRITO","PROVINCIA","DEPARTAMENTO"}
			ub_cb_criterio = new JComboBox(new String[]{"NOMBRE"});
			ub_cb_criterio.setBounds(new java.awt.Rectangle(115,25,106,21));
		}
		return ub_cb_criterio;
	}

	/**
	 * This method initializes ub_bt_aceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUb_bt_todo() {
		if (ub_bt_todo == null) {
			ub_bt_todo = new JButton();
			ub_bt_todo.setBounds(new java.awt.Rectangle(160,150,81,21));
			//ub_bt_todo.setMnemonic(java.awt.event.KeyEvent.VK_ENTER);
			ub_bt_todo.addActionListener(new ActionListener () {

				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Map params = new HashMap();
					getUb_tb_list_ubigeos().setModel(new TableModelListUbigeo(AppServicio.getInstance().getUbigeoViewList(params)));
				}
			});
			ub_bt_todo.setToolTipText("ALT ENTER");
			ub_bt_todo.setText("Todos");
		}
		return ub_bt_todo;
	}

	/**
	 * This method initializes ub_bt_cerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUb_bt_cerrar() {
		if (ub_bt_cerrar == null) {
			ub_bt_cerrar = new JButton();
			ub_bt_cerrar.setBounds(new java.awt.Rectangle(360,150,76,21));
			ub_bt_cerrar.setToolTipText("ESC");
			ub_bt_cerrar.setText("Cerrar");
		}
		return ub_bt_cerrar;
	}

	/**
	 * This method initializes ub_sp_list_ubigeos	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getUb_sp_list_ubigeos() {
		if (ub_sp_list_ubigeos == null) {
			ub_sp_list_ubigeos = new JScrollPane();
			ub_sp_list_ubigeos.setBounds(new java.awt.Rectangle(9,55,558,84));
			ub_sp_list_ubigeos.setViewportView(getUb_tb_list_ubigeos());
		}
		return ub_sp_list_ubigeos;
	}

	/**
	 * This method initializes ub_tb_list_ubigeos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getUb_tb_list_ubigeos() {
		if (ub_tb_list_ubigeos == null) {
			ub_tb_list_ubigeos = new JTable();
			ub_tb_list_ubigeos.addPropertyChangeListener("model", new PropertyChangeListener () {
				public void propertyChange(PropertyChangeEvent arg0) {
					// TODO Auto-generated method stub
					PanelUtils.packColumns(ub_tb_list_ubigeos, 3);
				}
			});
			Map params = new HashMap();
			//params.put("cod_pais", Ubigeo.PERU);
			//params.put("cod_departamento", Ubigeo.DPT_LIMA);
			//params.put("cod_provincia", Ubigeo.PRV_LIMA); 
			ub_tb_list_ubigeos.setModel(new TableModelListUbigeo(AppServicio.getInstance().getUbigeoViewList(params)));
		}
		return ub_tb_list_ubigeos;
	}

	/**
	 * This method initializes ub_bt_aceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getUb_bt_aceptar() {
		if (ub_bt_aceptar == null) {
			ub_bt_aceptar = new JButton();
			ub_bt_aceptar.setBounds(new java.awt.Rectangle(260,150,81,21));
			//ub_bt_aceptar.setMnemonic(java.awt.event.KeyEvent.VK_A);
			ub_bt_aceptar.setText("Aceptar");
			ub_bt_aceptar.addActionListener(new ActionListener () {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int row = getUb_tb_list_ubigeos().getSelectedRow();
					if (row >= 0) {
						LBuscadorUbigeo.this.dispose();
					}
				}
			});
		}
		return ub_bt_aceptar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LBuscadorUbigeo();
	}

	/**
	 * This is the default constructor
	 */
	public LBuscadorUbigeo() {
		super();
		initialize();
	}

	/**
	 * This is the default constructor
	 */
	public LBuscadorUbigeo(Dialog d) {
		super(d, true);
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(585, 206);
		this.setResizable(false);
		this.setTitle("Selección de Ubic. Geog.");
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		PanelUtils.setComponentFocus(this, getUb_tf_criterio());
		PanelUtils.addBindingKeyTable(this.getJContentPane(), this.getUb_tb_list_ubigeos());
		PanelUtils.addActionKeyEnter(this.getUb_tf_criterio(), new AbstractAction () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getUb_bt_buscar().doClick();
			}
		});
		
		Action doClickBtTodos = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ub_bt_todo.doClick();
			}
			
		};
		PanelUtils.setMnemonicCustomize(getJContentPane(), KeyStroke.getKeyStroke("ENTER"), doClickBtTodos);
		
		Action doClickBtAceptar = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getUb_bt_aceptar().doClick();
			}
		};
		PanelUtils.setMnemonicCustomize(getJContentPane(), KeyStroke.getKeyStroke("A"), doClickBtAceptar);
		WindowUtils.centerDialogInParent(this);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			ub_lb_criterio = new JLabel();
			ub_lb_criterio.setBounds(new java.awt.Rectangle(20,25,81,21));
			ub_lb_criterio.setText("Buscar Por:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getUb_tf_criterio(), null);
			jContentPane.add(getUb_bt_buscar(), null);
			jContentPane.add(getUb_cb_criterio(), null);
			jContentPane.add(getUb_bt_todo(), null);
			jContentPane.add(getUb_bt_cerrar(), null);
			jContentPane.add(ub_lb_criterio, null);
			jContentPane.add(getUb_sp_list_ubigeos(), null);
			jContentPane.add(getUb_bt_aceptar(), null);
		}
		return jContentPane;
	}
	
	public Object getSelectedRow () {
		int row = getUb_tb_list_ubigeos().getSelectedRow();
		if (row >= 0) {
			objectRow = ((TableModelListUbigeo) getUb_tb_list_ubigeos().getModel()).getSelectedRow(row);
		}
		return objectRow;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"