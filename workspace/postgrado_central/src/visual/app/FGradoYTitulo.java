package visual.app;

import java.awt.Dialog;

import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import visual.util.PanelUtils;
import visual.util.WindowUtils;

import dominio.negocio.GradoTitulo;

public class FGradoYTitulo extends JDialog {

	private JPanel jContentPane = null;
	private JTextField ae_tf_nombre_grado = null;
	private JTextField ae_tf_nombre_org = null;
	private JTextField ae_tf_pa_egreso = null;
	private JLabel jLabel01 = null;
	private JLabel jLabel02 = null;
	private JLabel jLabel03 = null;
	private JButton ae_bt_aceptar = null;
	
	GradoTitulo value;

	/**
	 * This method initializes ae_tf_nombre_grado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAe_tf_nombre_grado() {
		if (ae_tf_nombre_grado == null) {
			ae_tf_nombre_grado = new JTextField();
			ae_tf_nombre_grado.setBounds(new java.awt.Rectangle(135,15,196,21));
			ae_tf_nombre_grado.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_nombre_grado;
	}

	/**
	 * This method initializes ae_tf_nombre_org	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAe_tf_nombre_org() {
		if (ae_tf_nombre_org == null) {
			ae_tf_nombre_org = new JTextField();
			ae_tf_nombre_org.setBounds(new java.awt.Rectangle(135,45,196,21));
			ae_tf_nombre_org.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_nombre_org;
	}

	/**
	 * This method initializes ae_tf_pa_egreso	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAe_tf_pa_egreso() {
		if (ae_tf_pa_egreso == null) {
			ae_tf_pa_egreso = new JTextField();
			ae_tf_pa_egreso.setBounds(new java.awt.Rectangle(135,75,96,21));
			ae_tf_pa_egreso.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_pa_egreso;
	}

	/**
	 * This method initializes ae_bt_aceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAe_bt_aceptar() {
		if (ae_bt_aceptar == null) {
			ae_bt_aceptar = new JButton();
			ae_bt_aceptar.setBounds(new java.awt.Rectangle(130,110,86,26));
			ae_bt_aceptar.setText("Aceptar");
			ae_bt_aceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (getAe_tf_nombre_grado().getText() != null && getAe_tf_nombre_grado().getText().length() > 0) {
						if (getAe_tf_nombre_org().getText() != null && getAe_tf_nombre_org().getText().length() > 0) {
							if (getAe_tf_pa_egreso().getText() != null && getAe_tf_pa_egreso().getText().length() > 0) {
								value = new GradoTitulo();
								value.setNombreGradoTitulo(getAe_tf_nombre_grado().getText());
								value.setOrgProcedencia(getAe_tf_nombre_org().getText());
								value.setPeriodoEgreso(getAe_tf_pa_egreso().getText());
								dispose();
							}
						}
					}
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ae_bt_aceptar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the default constructor
	 */
	public FGradoYTitulo(Dialog parent) {
		super(parent, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(352, 175);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Ingreso de Grado y Título");
		this.setContentPane(getJContentPane());
		this.setResizable(false);
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
			jLabel03 = new JLabel();
			jLabel03.setBounds(new java.awt.Rectangle(5,75,126,21));
			jLabel03.setText("Periodo de Egreso:");
			jLabel02 = new JLabel();
			jLabel02.setBounds(new java.awt.Rectangle(5,45,126,21));
			jLabel02.setText("Org. de Procedencia:");
			jLabel01 = new JLabel();
			jLabel01.setBounds(new java.awt.Rectangle(5,15,86,21));
			jLabel01.setText("Grado o Título:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getAe_tf_nombre_grado(), null);
			jContentPane.add(getAe_tf_nombre_org(), null);
			jContentPane.add(getAe_tf_pa_egreso(), null);
			jContentPane.add(jLabel01, null);
			jContentPane.add(jLabel02, null);
			jContentPane.add(jLabel03, null);
			jContentPane.add(getAe_bt_aceptar(), null);
		}
		return jContentPane;
	}
	
	public Object getObject () {
		return value;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"