package visual.app;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;

import java.awt.Dialog;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

public class FPromptImpresionCertificadoAlumno extends JDialog {

	private JPanel jContentPane = null;
	private JPanel pnCentro = null;
	private JLabel lbCodigo = null;
	private JTextField tfCodigo = null;
	private JLabel lbObs = null;
	private JTextField tfObs = null;
	private JButton btAceptar = null;
	private JButton btCancelar = null;
	private JPanel pnBotones = null;
	private JLabel lbTitulo = null;
	/**
	 * This method initializes pnCentro	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridwidth = 4;
			gridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints4.insets = new java.awt.Insets(10,0,10,0);
			gridBagConstraints4.gridy = 0;
			lbTitulo = new JLabel();
			lbTitulo.setText("Ingrese el Codigo de Impresión del Certificado");
			lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridwidth = 3;
			gridBagConstraints6.ipady = 0;
			gridBagConstraints6.ipadx = 0;
			gridBagConstraints6.weighty = 0.0D;
			gridBagConstraints6.weightx = 0.0D;
			gridBagConstraints6.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints6.insets = new java.awt.Insets(10,0,0,0);
			gridBagConstraints6.gridy = 4;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.ipadx = 0;
			gridBagConstraints3.ipady = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new java.awt.Insets(1,1,1,1);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new java.awt.Insets(1,5,1,1);
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.ipady = 0;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.ipady = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new java.awt.Insets(0,1,1,1);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new java.awt.Insets(0,5,1,1);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
			gridBagConstraints.gridx = 0;
			lbObs = new JLabel();
			lbObs.setText("Observaciones:");
			lbCodigo = new JLabel();
			lbCodigo.setText("Codigo de la Imp.:");
			pnCentro = new JPanel();
			pnCentro.setLayout(new GridBagLayout());
			pnCentro.add(lbCodigo, gridBagConstraints);
			pnCentro.add(getTfCodigo(), gridBagConstraints1);
			pnCentro.add(lbObs, gridBagConstraints2);
			pnCentro.add(getTfObs(), gridBagConstraints3);
			pnCentro.add(getPnBotones(), gridBagConstraints6);
			pnCentro.add(lbTitulo, gridBagConstraints4);
		}
		return pnCentro;
	}

	/**
	 * This method initializes tfCodigo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getTfCodigo() {
		if (tfCodigo == null) {
			tfCodigo = new JTextField();
		}
		return tfCodigo;
	}

	/**
	 * This method initializes tfObs	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getTfObs() {
		if (tfObs == null) {
			tfObs = new JTextField();
		}
		return tfObs;
	}

	/**
	 * This method initializes btAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton();
			btAceptar.setText("Aceptar");
		}
		return btAceptar;
	}

	/**
	 * This method initializes btCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton();
			btCancelar.setText("Cancelar");
		}
		return btCancelar;
	}

	/**
	 * This method initializes pnBotones	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(15);
			pnBotones = new JPanel();
			pnBotones.setLayout(flowLayout);
			pnBotones.add(getBtAceptar(), null);
			pnBotones.add(getBtCancelar(), null);
		}
		return pnBotones;
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
	public FPromptImpresionCertificadoAlumno(Dialog d) {
		super(d, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(329, 156);
		this.setTitle("Impresion de Certificado");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPnCentro(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
