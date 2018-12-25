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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MyForm extends JPanel
{
   JButton aep_bt_add_ep = new JButton();
   JButton aep_bt_del_ep = new JButton();
   JTable aep_tb_estudio_postgrado = new JTable();
   JLabel aep_lbl_relacion_estudio_postgrado = new JLabel();
   JLabel aep_lbl_estudio_postgrado = new JLabel();
   JLabel aep_lb_menciones = new JLabel();
   JTable aep_tb_menciones = new JTable();
   JButton aep_bt_add_menciones = new JButton();
   JButton aep_bt_del_menciones = new JButton();
   JButton aep_bt_save = new JButton();
   JButton aep_bt_close = new JButton();

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
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),FILL:DEFAULT:NONE,FILL:5DLU:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(0.5),CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(0.5),CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      aep_bt_add_ep.setActionCommand("Agregar");
      aep_bt_add_ep.setName("bt_add_ep");
      aep_bt_add_ep.setText("Agregar");
      jpanel1.add(aep_bt_add_ep,cc.xy(4,4));

      aep_bt_del_ep.setActionCommand("Borrar");
      aep_bt_del_ep.setName("bt_del_ep");
      aep_bt_del_ep.setText("Borrar");
      jpanel1.add(aep_bt_del_ep,cc.xy(6,4));

      aep_tb_estudio_postgrado.setName("tb_estudio_postgrado");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(aep_tb_estudio_postgrado);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xywh(2,5,5,1));

      aep_lbl_relacion_estudio_postgrado.setName("lbl_relacion_estudio_postgrado");
      aep_lbl_relacion_estudio_postgrado.setText("Relacion de Estudio de Postgrado");
      jpanel1.add(aep_lbl_relacion_estudio_postgrado,cc.xy(2,2));

      aep_lbl_estudio_postgrado.setName("lbl_estudio_postgrado");
      aep_lbl_estudio_postgrado.setText("Estudios de Postgrado:");
      jpanel1.add(aep_lbl_estudio_postgrado,cc.xy(2,4));

      aep_lb_menciones.setName("lb_menciones");
      aep_lb_menciones.setText("Menciones:");
      jpanel1.add(aep_lb_menciones,cc.xy(2,7));

      aep_tb_menciones.setName("tb_menciones");
      JScrollPane jscrollpane2 = new JScrollPane();
      jscrollpane2.setViewportView(aep_tb_menciones);
      jscrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane2,cc.xywh(2,8,5,1));

      aep_bt_add_menciones.setActionCommand("Agregar");
      aep_bt_add_menciones.setName("bt_add_menciones");
      aep_bt_add_menciones.setText("Agregar");
      jpanel1.add(aep_bt_add_menciones,cc.xy(4,7));

      aep_bt_del_menciones.setActionCommand("Borrar");
      aep_bt_del_menciones.setName("bt_del_menciones");
      aep_bt_del_menciones.setText("Borrar");
      jpanel1.add(aep_bt_del_menciones,cc.xy(6,7));

      jpanel1.add(createPanel1(),new CellConstraints(2,10,5,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      aep_bt_save.setActionCommand("Grabar");
      aep_bt_save.setName("bt_save");
      aep_bt_save.setText("Grabar");
      jpanel1.add(aep_bt_save,cc.xy(1,1));

      aep_bt_close.setActionCommand("Cerrar");
      aep_bt_close.setName("bt_close");
      aep_bt_close.setText("Cerrar");
      jpanel1.add(aep_bt_close,cc.xy(3,1));

      addFillComponents(jpanel1,new int[]{ 2 },new int[0]);
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
