import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MyForm extends JPanel
{
   JComboBox lstCbCriterio01 = new JComboBox();
   JComboBox lstCbCriterio02 = new JComboBox();
   JComboBox lstCbCriterio03 = new JComboBox();
   JTextField lstTfCriterio01 = new JTextField();
   JTextField lstTfCriterio02 = new JTextField();
   JTextField lstTfCriterio021 = new JTextField();
   JTable lstTbListado = new JTable();
   JButton lstBtAdd = new JButton();
   JButton lstBtEdit = new JButton();
   JButton lstBtDel = new JButton();
   JButton lstBtImp = new JButton();
   JButton lstBtClose = new JButton();
   JButton lstBtAll = new JButton();
   JButton lstBtBuscar = new JButton();
   JButton lstBtShow = new JButton();

   /**
    * Default constructor
    */
   public MyForm()
   {
      initializePanel();
   }

   /**
    * Main method for panel
    */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(600, 400);
      frame.setLocation(100, 100);
      frame.getContentPane().add(new MyForm());
      frame.setVisible(true);

      frame.addWindowListener( new WindowAdapter()
      {
         public void windowClosing( WindowEvent evt )
         {
            System.exit(0);
         }
      });
   }

   /**
    * Adds fill components to empty cells in the first row and first column of the grid.
    * This ensures that the grid spacing will be the same as shown in the designer.
    * @param cols an array of column indices in the first row where fill components should be added.
    * @param rows an array of row indices in the first column where fill components should be added.
    */
   void addFillComponents( Container panel, int[] cols, int[] rows )
   {
      Dimension filler = new Dimension(10,10);

      boolean filled_cell_11 = false;
      CellConstraints cc = new CellConstraints();
      if ( cols.length > 0 && rows.length > 0 )
      {
         if ( cols[0] == 1 && rows[0] == 1 )
         {
            /** add a rigid area  */
            panel.add( Box.createRigidArea( filler ), cc.xy(1,1) );
            filled_cell_11 = true;
         }
      }

      for( int index = 0; index < cols.length; index++ )
      {
         if ( cols[index] == 1 && filled_cell_11 )
         {
            continue;
         }
         panel.add( Box.createRigidArea( filler ), cc.xy(cols[index],1) );
      }

      for( int index = 0; index < rows.length; index++ )
      {
         if ( rows[index] == 1 && filled_cell_11 )
         {
            continue;
         }
         panel.add( Box.createRigidArea( filler ), cc.xy(1,rows[index]) );
      }

   }

   /**
    * Helper method to load an image file from the CLASSPATH
    * @param imageName the package and name of the file to load relative to the CLASSPATH
    * @return an ImageIcon instance with the specified image file
    * @throws IllegalArgumentException if the image resource cannot be loaded.
    */
   public ImageIcon loadImage( String imageName )
   {
      try
      {
         ClassLoader classloader = getClass().getClassLoader();
         java.net.URL url = classloader.getResource( imageName );
         if ( url != null )
         {
            ImageIcon icon = new ImageIcon( url );
            return icon;
         }
      }
      catch( Exception e )
      {
         e.printStackTrace();
      }
      throw new IllegalArgumentException( "Unable to load image: " + imageName );
   }

   public JPanel createPanel()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.7),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      JLabel jlabel1 = new JLabel();
      jlabel1.setText("Buscar Por:");
      jpanel1.add(jlabel1,cc.xy(2,2));

      lstCbCriterio01.setName("CbCriterio01");
      jpanel1.add(lstCbCriterio01,cc.xy(4,2));

      lstCbCriterio02.setName("CbCriterio02");
      jpanel1.add(lstCbCriterio02,cc.xy(4,4));

      lstCbCriterio03.setName("CbCriterio03");
      jpanel1.add(lstCbCriterio03,cc.xy(4,6));

      lstTfCriterio01.setColumns(10);
      lstTfCriterio01.setName("TfCriterio01");
      jpanel1.add(lstTfCriterio01,cc.xy(6,2));

      lstTfCriterio02.setColumns(10);
      lstTfCriterio02.setName("TfCriterio02");
      jpanel1.add(lstTfCriterio02,cc.xy(6,4));

      lstTfCriterio021.setColumns(10);
      lstTfCriterio021.setName("TfCriterio02");
      jpanel1.add(lstTfCriterio021,cc.xy(6,6));

      lstTbListado.setName("TbListado");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(lstTbListado);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xywh(2,8,5,1));

      jpanel1.add(createPanel1(),new CellConstraints(2,10,5,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      lstBtAdd.setActionCommand("Adicionar");
      lstBtAdd.setName("BtAdd");
      lstBtAdd.setText("Adicionar");
      jpanel1.add(lstBtAdd,cc.xy(1,1));

      lstBtEdit.setActionCommand("Editar");
      lstBtEdit.setName("BtEdit");
      lstBtEdit.setText("Editar");
      jpanel1.add(lstBtEdit,cc.xy(3,1));

      lstBtDel.setActionCommand("Borrar");
      lstBtDel.setName("BtDel");
      lstBtDel.setText("Borrar");
      jpanel1.add(lstBtDel,cc.xy(5,1));

      lstBtImp.setActionCommand("Imprimir");
      lstBtImp.setName("BtImp");
      lstBtImp.setText("Imprimir");
      jpanel1.add(lstBtImp,cc.xy(7,1));

      lstBtClose.setActionCommand("Cerrar");
      lstBtClose.setName("BtClose");
      lstBtClose.setText("Cerrar");
      jpanel1.add(lstBtClose,cc.xy(15,1));

      lstBtAll.setActionCommand("Todos los Registros");
      lstBtAll.setName("BtAll");
      lstBtAll.setText("Todos los Registros");
      jpanel1.add(lstBtAll,cc.xy(13,1));

      lstBtBuscar.setActionCommand("JButton");
      lstBtBuscar.setName("BtBuscar");
      lstBtBuscar.setText("Buscar");
      jpanel1.add(lstBtBuscar,cc.xy(11,1));

      lstBtShow.setActionCommand("Mostrar");
      lstBtShow.setName("BtShow");
      lstBtShow.setText("Mostrar");
      jpanel1.add(lstBtShow,cc.xy(9,1));

      addFillComponents(jpanel1,new int[]{ 2,4,6,8,10,12,14 },new int[0]);
      return jpanel1;
   }

   /**
    * Initializer
    */
   protected void initializePanel()
   {
      setLayout(new BorderLayout());
      add(createPanel(), BorderLayout.CENTER);
   }


}
