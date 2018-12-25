package visual.util.process_blocker.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DlgView extends JDialog {



	  JLabel lblMessage = new JLabel();
	  private JLabel lblEspere = new JLabel();

	  public DlgView() {
	    this(null, "", false);
	  }

	  public DlgView(Frame parent, String title, boolean modal) {
	    super(parent, title, modal);
	    try {
	      jbInit();
	    } catch(Exception e) {
	      e.printStackTrace();
	    }
	  }

	  private void jbInit() throws Exception {
	    this.setSize(new Dimension(385, 113));
	    this.getContentPane().setLayout(null);
	    this.setFont(new Font("Arial", 0, 12));
	    this.setTitle("[Programa de Gestión de Alumno] Por favor espere.");
	    this.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
	    lblMessage.setText("ooo");
	    lblMessage.setBounds(new Rectangle(15, 15, 345, 30));
	    lblEspere.setText("Por favor espere.");
	    lblEspere.setBounds(new Rectangle(260, 50, 110, 20));
	    this.getContentPane().add(lblEspere, null);
	    this.getContentPane().add(lblMessage, null);
	  }

	    public JLabel getLblMessage() {
	        return lblMessage;
	    }


	    public static void main(String a[]){
	        new DlgView().show();
	    }
}
