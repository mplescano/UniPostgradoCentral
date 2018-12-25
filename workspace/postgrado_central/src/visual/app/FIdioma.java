package visual.app;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import visual.util.PanelUtils;
import visual.util.WindowUtils;
import dominio.negocio.TpIdioma;

public class FIdioma extends JDialog {

	private JPanel jContentPane = null;
	private JTextField ae_tf_idioma = null;
	private JComboBox ae_cb_nivel_idioma = null;
	private JLabel jLabel01 = null;
	private JLabel jLabel02 = null;
	private JButton ae_bt_aceptar = null;
	
	TpIdioma value;

	/**
	 * This method initializes ae_tf_idioma	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAe_tf_idioma() {
		if (ae_tf_idioma == null) {
			ae_tf_idioma = new JTextField();
			ae_tf_idioma.setBounds(new java.awt.Rectangle(105,15,251,21));
			ae_tf_idioma.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_idioma;
	}

	/**
	 * This method initializes ae_cb_nivel_idioma	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getAe_cb_nivel_idioma() {
		if (ae_cb_nivel_idioma == null) {
			ae_cb_nivel_idioma = new JComboBox();
			ae_cb_nivel_idioma.setBounds(new java.awt.Rectangle(105,50,191,21));
			ae_cb_nivel_idioma.addItem("BASICO");
			ae_cb_nivel_idioma.addItem("INTERMEDIO");
			ae_cb_nivel_idioma.addItem("AVANZADO");
		}
		return ae_cb_nivel_idioma;
	}

	/**
	 * This method initializes ae_bt_aceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAe_bt_aceptar() {
		if (ae_bt_aceptar == null) {
			ae_bt_aceptar = new JButton();
			ae_bt_aceptar.setBounds(new java.awt.Rectangle(135,85,106,26));
			ae_bt_aceptar.setText("ACEPTAR");
			ae_bt_aceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getAe_tf_idioma().getText() != null && getAe_tf_idioma().getText().length() > 0) {
						if (getAe_cb_nivel_idioma().getSelectedItem() != null) {
							value = new TpIdioma();
							value.setNivelIdioma(getAe_cb_nivel_idioma().getSelectedItem().toString());
							value.setNombreIdioma(getAe_tf_idioma().getText());
							dispose();
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
	public FIdioma(Dialog parent) {
		super(parent, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(389, 150);
		this.setTitle("Ingreso de Idioma");
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
			jLabel02 = new JLabel();
			jLabel02.setBounds(new java.awt.Rectangle(20,50,76,21));
			jLabel02.setText("NIVEL:");
			jLabel01 = new JLabel();
			jLabel01.setBounds(new java.awt.Rectangle(20,15,66,21));
			jLabel01.setText("IDIOMA");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getAe_tf_idioma(), null);
			jContentPane.add(getAe_cb_nivel_idioma(), null);
			jContentPane.add(jLabel01, null);
			jContentPane.add(jLabel02, null);
			jContentPane.add(getAe_bt_aceptar(), null);
		}
		return jContentPane;
	}
	
	public Object getObject() {
		return value;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
