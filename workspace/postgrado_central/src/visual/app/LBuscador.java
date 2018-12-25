package visual.app;

import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import visual.util.PanelUtils;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class LBuscador extends JDialog {
	JComboBox lstCbCriterio01;
	JComboBox lstCbCriterio02;
	JComboBox lstCbCriterio03;
	
	JTextField lstTfCriterio01;
	JTextField lstTfCriterio02;
	JTextField lstTfCriterio03;
	
	JTable lstTbListado;
	JButton lstBtAdd;
	JButton lstBtEdit;
	JButton lstBtDel;
	JButton lstBtImp;
	JButton lstBtClose;
	JButton lstBtAll;
	JButton lstBtBuscar;
	JButton lstBtShow;
	
	private JPanel jContentPane = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LBuscador().setVisible(true);
	}

	/**
	 * This is the default constructor
	 */
	public LBuscador() {
		super();
		initialize();
	}
	
	public LBuscador(Frame f) {
		super(f, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 290);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Listado");
		this.setContentPane(getJContentPane());
		//System.out.println("listado");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = createPanel();
			//jContentPane = new JPanel();
			//jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	public JButton getLstBtAdd() {
		if (lstBtAdd == null) {
			lstBtAdd = new JButton();
			lstBtAdd.setActionCommand("Adicionar");
			lstBtAdd.setName("BtAdd");
			lstBtAdd.setText("Adicionar");
		}
		return lstBtAdd;
	}
	

	public JButton getLstBtAll() {
		if (lstBtAll == null) {
			lstBtAll = new JButton();
			lstBtAll.setActionCommand("Todos los Registros");
			lstBtAll.setName("BtAll");
			lstBtAll.setText("Todos los Registros");
		}
		return lstBtAll;
	}
	

	public JButton getLstBtBuscar() {
		if (lstBtBuscar == null) {
			lstBtBuscar = new JButton();
			lstBtBuscar.setActionCommand("Buscar");
			lstBtBuscar.setName("BtBuscar");
			lstBtBuscar.setText("Buscar");
		}
		return lstBtBuscar;
	}
	

	public JButton getLstBtClose() {
		if (lstBtClose == null) {
			lstBtClose = new JButton();
			lstBtClose.setActionCommand("Cerrar");
			lstBtClose.setName("BtClose");
			lstBtClose.setText("Cerrar");
		}
		return lstBtClose;
	}
	

	public JButton getLstBtDel() {
		if (lstBtDel == null) {
			lstBtDel = new JButton();
			lstBtDel.setActionCommand("Borrar");
			lstBtDel.setName("BtDel");
			lstBtDel.setText("Borrar");
		}
		return lstBtDel;
	}
	

	public JButton getLstBtEdit() {
		if (lstBtEdit == null) {
			lstBtEdit = new JButton();
			lstBtEdit.setActionCommand("Editar");
			lstBtEdit.setName("BtEdit");
			lstBtEdit.setText("Editar");
		}
		return lstBtEdit;
	}
	

	public JButton getLstBtImp() {
		if (lstBtImp == null) {
			lstBtImp = new JButton();
			lstBtImp.setActionCommand("Imprimir");
			lstBtImp.setName("BtImp");
			lstBtImp.setText("Imprimir");
		}
		return lstBtImp;
	}
	

	public JComboBox getLstCbCriterio01() {
		if (lstCbCriterio01 == null) {
			lstCbCriterio01 = new JComboBox();
			lstCbCriterio01.setName("CbCriterio01");
		}
		return lstCbCriterio01;
	}
	

	public JComboBox getLstCbCriterio02() {
		if (lstCbCriterio02 == null) {
			lstCbCriterio02 = new JComboBox();
			lstCbCriterio02.setName("CbCriterio02");
		}
		return lstCbCriterio02;
	}
	

	public JComboBox getLstCbCriterio03() {
		if (lstCbCriterio03 == null) {
			lstCbCriterio03 = new JComboBox();
			lstCbCriterio03.setName("CbCriterio03");
		}
		return lstCbCriterio03;
	}
	

	public JTable getLstTbListado() {
		if (lstTbListado == null) {
			lstTbListado = new JTable();
			lstTbListado.setName("TbListado");
			lstTbListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			lstTbListado.addPropertyChangeListener("model", new PropertyChangeListener () {
				public void propertyChange(PropertyChangeEvent evt) {
					// TODO Auto-generated method stub
					//System.out.println("pro:" + evt.getPropertyName());
					PanelUtils.packColumns(lstTbListado, 2);
				}
			});
			//lstTbListado.setRequestFocusEnabled(false);
			//lstTbListado.setFocusCycleRoot(false);
			//lstTbListado.setFocusTraversalKeysEnabled(false);
			//lstTbListado.setFocusTraversalPolicyProvider(false);
			//lstTbListado.setFocusable(false);
		}
		return lstTbListado;
	}
	

	public JTextField getLstTfCriterio01() {
		if (lstTfCriterio01 == null) {
			lstTfCriterio01 = new JTextField();
			lstTfCriterio01.setColumns(10);
			lstTfCriterio01.setName("TfCriterio01");
		}
		return lstTfCriterio01;
	}
	

	public JTextField getLstTfCriterio02() {
		if (lstTfCriterio02 == null) {
			lstTfCriterio02 = new JTextField();
			lstTfCriterio02.setColumns(10);
			lstTfCriterio02.setName("TfCriterio02");
		}
		return lstTfCriterio02;
	}
	

	public JTextField getLstTfCriterio03() {
		if (lstTfCriterio03 == null) {
			lstTfCriterio03 = new JTextField();
			lstTfCriterio03.setColumns(10);
			lstTfCriterio03.setName("TfCriterio02");
		}
		return lstTfCriterio03;
	}
	
	   public JPanel createPanel() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.7),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);

	      JLabel jlabel1 = new JLabel();
	      jlabel1.setText("Buscar Por:");
	      jpanel1.add(jlabel1,cc.xy(2,2));

	      
	      jpanel1.add(getLstCbCriterio01(),cc.xy(4,2));

	      
	      jpanel1.add(getLstCbCriterio02(),cc.xy(4,4));

	      
	      jpanel1.add(getLstCbCriterio03(),cc.xy(4,6));


	      jpanel1.add(getLstTfCriterio01(),cc.xy(6,2));


	      jpanel1.add(getLstTfCriterio02(),cc.xy(6,4));


	      jpanel1.add(getLstTfCriterio03(),cc.xy(6,6));

	      
	      JScrollPane jscrollpane1 = new JScrollPane();
	      jscrollpane1.setViewportView(getLstTbListado());
	      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      jpanel1.add(jscrollpane1,cc.xywh(2,8,5,1));

	      jpanel1.add(createPanel1(),new CellConstraints(2,10,5,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
	      PanelUtils.addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11 });
	      return jpanel1;
	   }

	   public JButton getLstBtShow () {
		   if (lstBtShow == null) {
			   lstBtShow = new JButton();
			      lstBtShow.setActionCommand("Mostrar");
			      lstBtShow.setName("BtShow");
			      lstBtShow.setText("Mostrar Det.");
		   }
		   return lstBtShow;
	   }
	   
	   public JPanel createPanel1() {
		      JPanel jpanel1 = new JPanel();
		      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
		      CellConstraints cc = new CellConstraints();
		      jpanel1.setLayout(formlayout1);

	      jpanel1.add(getLstBtAdd(),cc.xy(1,1));

	      jpanel1.add(getLstBtEdit(),cc.xy(3,1));

	      jpanel1.add(getLstBtDel(),cc.xy(5,1));

	      jpanel1.add(getLstBtImp(),cc.xy(7,1));

	      jpanel1.add(getLstBtClose(),cc.xy(15,1));

	      jpanel1.add(getLstBtAll(),cc.xy(13,1));

	      jpanel1.add(getLstBtBuscar(),cc.xy(11,1));
	      
	      jpanel1.add(getLstBtShow(),cc.xy(9,1));

	      PanelUtils.addFillComponents(jpanel1,new int[]{ 2,4,6,8,10,12,14 },new int[0]);
	      return jpanel1;
	   }
}  //  @jve:decl-index=0:visual-constraint="10,10"