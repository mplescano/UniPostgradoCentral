package visual.app;

import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import visual.app.tableModel.TableModelListPlanEstudio;

//Utilitarios
import visual.util.PanelUtils;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Formulario Listado del plan de estudios
 * @author Jaime
 * @since 23/04/2006
 */
public class LPlanEstudio extends JDialog {

	private JPanel jContentPane = null;
	private JScrollPane jScrollPanePlanEstudio = null;
	private JTable jTablePlanEstudio = null;
	private JButton jButtonNuevo = null;
	private JButton jButtonBorrar = null;
	private JButton jButtonCerrar = null;
	
	/** Table Model Asociado */
	private TableModelListPlanEstudio tableModelListPlanEstudio = null;  //  @jve:decl-index=0:visual-constraint=""
	private JLabel jLabelNombres = null;
	private JTextField jTextFieldNombresAlumnoEgresado = null;
	
	
	/**
	 * @throws HeadlessException
	 */
	public LPlanEstudio() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Dialog owner) throws HeadlessException {
		super(owner);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param modal
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Dialog owner, boolean modal) throws HeadlessException {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Frame owner) throws HeadlessException {
		super(owner);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param modal
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Frame owner, boolean modal) throws HeadlessException {
		super(owner, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Dialog owner, String title) throws HeadlessException {
		super(owner, title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Dialog owner, String title, boolean modal)
			throws HeadlessException {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Frame owner, String title) throws HeadlessException {
		super(owner, title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Frame owner, String title, boolean modal)
			throws HeadlessException {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @param gc
	 * @throws HeadlessException
	 */
	public LPlanEstudio(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc) throws HeadlessException {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param owner
	 * @param title
	 * @param modal
	 * @param gc
	 */
	public LPlanEstudio(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 400);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Plan de Estudios");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNombres = new JLabel();
			jLabelNombres.setBounds(new java.awt.Rectangle(10,10,76,21));
			jLabelNombres.setText("Nombres:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPanePlanEstudio(), null);
			jContentPane.add(getJButtonNuevo(), null);
			jContentPane.add(getJButtonBorrar(), null);
			jContentPane.add(getJButtonCerrar(), null);
			jContentPane.add(jLabelNombres, null);
			jContentPane.add(getJTextFieldNombresAlumnoEgresado(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPanePlanEstudio	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPanePlanEstudio() {
		if (jScrollPanePlanEstudio == null) {
			jScrollPanePlanEstudio = new JScrollPane();
			jScrollPanePlanEstudio.setBounds(new java.awt.Rectangle(6,40,580,293));
			jScrollPanePlanEstudio.setViewportView(getJTablePlanEstudio());
		}
		return jScrollPanePlanEstudio;
	}

	/**
	 * This method initializes jTablePlanEstudio	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTablePlanEstudio() {
		if (jTablePlanEstudio == null) {
			jTablePlanEstudio = new JTable();
			jTablePlanEstudio.setName("TbPlanEstudio");
			
			// Usando scroll 
			jTablePlanEstudio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			// Asignando el listener que reajuste las columnas al texto 
			jTablePlanEstudio.addPropertyChangeListener("model", new PropertyChangeListener () {
				public void propertyChange(PropertyChangeEvent evt) {
					PanelUtils.packColumns(jTablePlanEstudio, 2);
				}
			});
			
			//Asignando el Modelo  
			jTablePlanEstudio.setModel(new TableModelListPlanEstudio(null));
		}
		return jTablePlanEstudio;
	}

	/**
	 * This method initializes jButtonNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonNuevo() {
		if (jButtonNuevo == null) {
			jButtonNuevo = new JButton();
			jButtonNuevo.setBounds(new java.awt.Rectangle(5,340,100,20));
			jButtonNuevo.setText("Adicionar");
		}
		return jButtonNuevo;
	}

	/**
	 * This method initializes jButtonBorrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonBorrar() {
		if (jButtonBorrar == null) {
			jButtonBorrar = new JButton();
			jButtonBorrar.setBounds(new java.awt.Rectangle(112,340,100,20));
			jButtonBorrar.setText("Borrar");
		}
		return jButtonBorrar;
	}

	/**
	 * This method initializes jButtonCerrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonCerrar() {
		if (jButtonCerrar == null) {
			jButtonCerrar = new JButton();
			jButtonCerrar.setBounds(new java.awt.Rectangle(216,340,100,20));
			jButtonCerrar.setText("Cerrar");
		}
		return jButtonCerrar;
	}

	
	
/**
	 * This method initializes jTextFieldNombresAlumnoEgresado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextFieldNombresAlumnoEgresado() {
		if (jTextFieldNombresAlumnoEgresado == null) {
			jTextFieldNombresAlumnoEgresado = new JTextField();
			jTextFieldNombresAlumnoEgresado.setBounds(new java.awt.Rectangle(90,10,291,21));
			jTextFieldNombresAlumnoEgresado.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
			jTextFieldNombresAlumnoEgresado.setEditable(false);
		}
		return jTextFieldNombresAlumnoEgresado;
	}

	//	/**
//	 * This method initializes tableModelListPlanEstudio	
//	 * 	
//	 * @return visual.app.tableModel.TableModelListPlanEstudio	
//	 */
//	private TableModelListPlanEstudio getTableModelListPlanEstudio() {
//		if (tableModelListPlanEstudio == null) {
//			tableModelListPlanEstudio = new TableModelListPlanEstudio();
//		}
//		return tableModelListPlanEstudio;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LPlanEstudio().setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
