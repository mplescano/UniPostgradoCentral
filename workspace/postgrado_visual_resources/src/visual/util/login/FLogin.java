package visual.util.login;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import visual.util.PanelUtils;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class FLogin extends JDialog {
	JTextField lgn_tfUsuario;
	JButton lgn_btAceptar;
	JButton lgn_btSalir;
	JPasswordField lgn_tfClave;

	private JPanel jContentPane = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new FLogin().setVisible(true);
	}

	/**
	 * This is the default constructor
	 */
	public FLogin(Frame frame, boolean modal) {
		super(frame, modal);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 190);
		//this.setContentPane(getJContentPane());
		this.setTitle("INGRESO AL SISTEMA");
		this.setResizable(false);
		this.setContentPane(createPanel());
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
		}
		return jContentPane;
	}

	public JButton getLgn_btAceptar() {
		if (lgn_btAceptar == null) {
			lgn_btAceptar = new JButton();
		    lgn_btAceptar.setActionCommand("Aceptar");
		    lgn_btAceptar.setName("btAceptar");
		    lgn_btAceptar.setText("Aceptar");
		}
		return lgn_btAceptar;
	}
	

	public JButton getLgn_btSalir() {
		if (lgn_btSalir == null) {
			lgn_btSalir = new JButton();
		      lgn_btSalir.setActionCommand("Salir");
		      lgn_btSalir.setName("btSalir");
		      lgn_btSalir.setText("Salir");
		}
		return lgn_btSalir;
	}
	

	public JPasswordField getLgn_tfClave() {
		if (lgn_tfClave == null) {
			lgn_tfClave = new JPasswordField();
			lgn_tfClave.setColumns(15);
			lgn_tfClave.setName("tfClave");
		}
		return lgn_tfClave;
	}
	

	public JTextField getLgn_tfUsuario() {
		if (lgn_tfUsuario == null) {
			lgn_tfUsuario = new JTextField();
		      lgn_tfUsuario.setColumns(15);
		      lgn_tfUsuario.setName("tfUsuario");
		}
		return lgn_tfUsuario;
	}
	


	
	   public JPanel createPanel() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);


	      jpanel1.add(getLgn_tfUsuario(),cc.xy(5,6));

	      JLabel jlabel1 = new JLabel();
	      jlabel1.setText("Usuario:");
	      jpanel1.add(jlabel1,cc.xy(3,6));

	      JLabel jlabel2 = new JLabel();
	      jlabel2.setText("Clave:");
	      jpanel1.add(jlabel2,cc.xy(3,8));

	      jpanel1.add(createPanel1(),new CellConstraints(3,10,3,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
	      JLabel jlabel3 = new JLabel();
	      jlabel3.setText("POSTGRADO CENTRAL");
	      jlabel3.setHorizontalAlignment(JLabel.CENTER);
	      jpanel1.add(jlabel3,cc.xywh(3,2,3,1));

	      JLabel jlabel4 = new JLabel();
	      jlabel4.setText("INGRESO AL SISTEMA");
	      jlabel4.setHorizontalAlignment(JLabel.CENTER);
	      jpanel1.add(jlabel4,cc.xywh(3,4,3,1));

	      
	      jpanel1.add(getLgn_tfClave(),cc.xy(5,8));

	      PanelUtils.addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11 });
	      return jpanel1;
	   }

	   public JPanel createPanel1() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);


	      jpanel1.add(getLgn_btAceptar(),cc.xy(1,1));


	      jpanel1.add(getLgn_btSalir(),cc.xy(3,1));

	      PanelUtils.addFillComponents(jpanel1,new int[]{ 2 },new int[0]);
	      return jpanel1;
	   }

}  //  @jve:decl-index=0:visual-constraint="10,10"
