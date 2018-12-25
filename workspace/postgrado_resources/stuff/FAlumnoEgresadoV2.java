package visual.app;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTabbedPane;

public class FAlumnoEgresadoV2 extends JDialog {

	private JTabbedPane tp_alumno_egresado = null;
	private JPanel pn01 = null;
	private JPanel pn02 = null;

	/**
	 * This method initializes tp_alumno_egresado	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getTp_alumno_egresado() {
		if (tp_alumno_egresado == null) {
			tp_alumno_egresado = new JTabbedPane();
			tp_alumno_egresado.addTab(null, null, getPn01(), null);
			tp_alumno_egresado.addTab(null, null, getPn02(), null);
		}
		return tp_alumno_egresado;
	}

	/**
	 * This method initializes pn01	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPn01() {
		if (pn01 == null) {
			pn01 = new JPanel();
		}
		return pn01;
	}

	/**
	 * This method initializes pn02	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPn02() {
		if (pn02 == null) {
			pn02 = new JPanel();
		}
		return pn02;
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
	public FAlumnoEgresadoV2() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 750);
		this.setContentPane(getTp_alumno_egresado());
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Formulario del Alumno Egresado");
	}

}
