package visual.app; 

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import visual.util.PanelUtils;
import visual.util.WindowUtils;


public class FFacultad extends JDialog {
	private JPanel jContentPane = null;
	
   JLabel fac_lb_relacion_facultad = new JLabel();
   JTable fac_tb_facultad;
   JScrollPane fac_sp_facultad;
   
   JButton fac_bt_add;
   JButton fac_bt_del;
   JButton fac_bt_save;
   JButton fac_bt_close;

   /**
    * Default constructor
    */
   public FFacultad() {
      //initializePanel();
      initialize();
   }
   
   public FFacultad (Frame f) {
	   super(f, true);
	   initialize();
   }
   
   public JScrollPane getFac_sp_facultad () {
	   if (fac_sp_facultad == null) {
		   fac_sp_facultad = new JScrollPane();
		      fac_sp_facultad.setViewportView(getFac_tb_facultad());
		      fac_sp_facultad.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		      fac_sp_facultad.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   }
	   return fac_sp_facultad;
   }
   
	private void initialize() {
		this.setSize(352, 175);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Relacion de Facultades:");
		this.setContentPane(getJContentPane());
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = createPanel();
		}
		return jContentPane;
	}

   /**
    * Main method for panel
    */
   public static void main(String[] args) {
	   new FFacultad().setVisible(true);
   }

   public JPanel createPanel() {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      fac_lb_relacion_facultad.setName("lb_relacion_facultad");
      fac_lb_relacion_facultad.setText("Relacion de Facultades de la UNI");
      jpanel1.add(fac_lb_relacion_facultad,cc.xy(2,2));

      jpanel1.add(getFac_sp_facultad(),cc.xywh(2,4,2,1));

      jpanel1.add(createPanel1(),new CellConstraints(2,6,2,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
      PanelUtils.addFillComponents(jpanel1,new int[]{ 1,2,3,4 },new int[]{ 1,2,3,4,5,6,7 });
      return jpanel1;
   }

   public JPanel createPanel1() {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);


      jpanel1.add(getFac_bt_add(),cc.xy(1,1));


      jpanel1.add(getFac_bt_del(),cc.xy(3,1));

      jpanel1.add(getFac_bt_save(),cc.xy(5,1));

      jpanel1.add(getFac_bt_close(),cc.xy(7,1));

      PanelUtils.addFillComponents(jpanel1,new int[]{ 2,4,6 },new int[0]);
      return jpanel1;
   }

public JButton getFac_bt_add() {
	if (fac_bt_add == null) {
		fac_bt_add = new JButton();
	      fac_bt_add.setActionCommand("JButton");
	      fac_bt_add.setName("bt_add");
	      fac_bt_add.setText("Adicionar");
	}
	return fac_bt_add;
}

public JButton getFac_bt_close() {
	if (fac_bt_close == null) {
		fac_bt_close = new JButton();
	      fac_bt_close.setActionCommand("Cerrar");
	      fac_bt_close.setName("bt_close");
	      fac_bt_close.setText("Cerrar");
	}
	return fac_bt_close;
}

public JButton getFac_bt_del() {
	if (fac_bt_del == null) {
		fac_bt_del = new JButton();
	      fac_bt_del.setActionCommand("JButton");
	      fac_bt_del.setName("bt_del");
	      fac_bt_del.setText("Borrar");
	}
	return fac_bt_del;
}

public JButton getFac_bt_save() {
	if (fac_bt_save == null) {
		fac_bt_save = new JButton();
	      fac_bt_save.setActionCommand("Grabar");
	      fac_bt_save.setName("bt_save");
	      fac_bt_save.setText("Grabar");
	}
	return fac_bt_save;
}

public JTable getFac_tb_facultad() {
	if (fac_tb_facultad == null) {
		fac_tb_facultad = new JTable();
	    fac_tb_facultad.setName("tb_facultad");
	}
	return fac_tb_facultad;
}
}
