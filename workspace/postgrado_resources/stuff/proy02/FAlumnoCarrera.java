import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyForm extends JPanel
{
   JTextField dc_tf_tesis02 = new JTextField();
   JTextField dc_tf_tesis01 = new JTextField();
   JLabel dc_lb_tesis = new JLabel();
   JLabel dc_lb_fecha_sustentacion = new JLabel();
   JTextField dc_tf_fecha_sustentacion = new JTextField();
   JLabel dc_lb_periodo_egreso = new JLabel();
   JTextField dc_tf_periodo_egreso = new JTextField();
   JLabel dc_lb_carrera = new JLabel();
   JComboBox dc_cb_carrera = new JComboBox();
   JLabel dc_lb_periodo_ingreso = new JLabel();
   JTextField dc_tf_periodo_ingreso = new JTextField();
   JLabel dc_lb_modalidad_ingreso = new JLabel();
   JComboBox dc_cb_modalidad_ingreso = new JComboBox();
   JTextField dc_tf_modalidad_ingreso = new JTextField();
   JLabel dc_lb_ingreso_carrera = new JLabel();
   JLabel dc_lb_egreso_carrera = new JLabel();

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
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.8),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dc_tf_tesis02.setName("tf_tesis02");
      jpanel1.add(dc_tf_tesis02,cc.xywh(4,18,11,1));

      dc_tf_tesis01.setName("tf_tesis01");
      jpanel1.add(dc_tf_tesis01,cc.xywh(4,16,11,1));

      dc_lb_tesis.setName("lb_tesis");
      dc_lb_tesis.setText("Tesis:");
      jpanel1.add(dc_lb_tesis,cc.xy(2,16));

      dc_lb_fecha_sustentacion.setName("lb_fecha_sustentacion");
      dc_lb_fecha_sustentacion.setText("Fecha de Sustentacion:");
      jpanel1.add(dc_lb_fecha_sustentacion,cc.xy(2,14));

      dc_tf_fecha_sustentacion.setName("tf_fecha_sustentacion");
      jpanel1.add(dc_tf_fecha_sustentacion,cc.xywh(4,14,8,1));

      dc_lb_periodo_egreso.setName("lb_periodo_egreso");
      dc_lb_periodo_egreso.setText("Periodo de Egreso:");
      jpanel1.add(dc_lb_periodo_egreso,cc.xy(2,12));

      dc_tf_periodo_egreso.setName("tf_periodo_egreso");
      jpanel1.add(dc_tf_periodo_egreso,cc.xywh(4,12,8,1));

      dc_lb_carrera.setName("lb_carrera");
      dc_lb_carrera.setText("Carrera:");
      jpanel1.add(dc_lb_carrera,cc.xy(2,4));

      dc_cb_carrera.setName("cb_carrera");
      jpanel1.add(dc_cb_carrera,cc.xywh(4,4,11,1));

      dc_lb_periodo_ingreso.setName("lb_periodo_ingreso");
      dc_lb_periodo_ingreso.setText("Periodo de Ingreso:");
      jpanel1.add(dc_lb_periodo_ingreso,cc.xy(2,6));

      dc_tf_periodo_ingreso.setName("tf_periodo_ingreso");
      jpanel1.add(dc_tf_periodo_ingreso,cc.xywh(4,6,8,1));

      dc_lb_modalidad_ingreso.setName("lb_modalidad_ingreso");
      dc_lb_modalidad_ingreso.setText("Modalidad de Ingreso:");
      jpanel1.add(dc_lb_modalidad_ingreso,cc.xy(2,8));

      dc_cb_modalidad_ingreso.setName("cb_modalidad_ingreso");
      jpanel1.add(dc_cb_modalidad_ingreso,cc.xywh(4,8,9,1));

      dc_tf_modalidad_ingreso.setColumns(10);
      dc_tf_modalidad_ingreso.setName("tf_modalidad_ingreso");
      jpanel1.add(dc_tf_modalidad_ingreso,cc.xy(14,8));

      dc_lb_ingreso_carrera.setBackground(new Color(255,255,254));
      dc_lb_ingreso_carrera.setFont(new Font("Dialog",Font.BOLD,12));
      dc_lb_ingreso_carrera.setName("lb_ingreso_carrera");
      dc_lb_ingreso_carrera.setText("Datos de Ingreso a la Carrera");
      jpanel1.add(dc_lb_ingreso_carrera,cc.xywh(2,2,13,1));

      dc_lb_egreso_carrera.setFont(new Font("Dialog",Font.BOLD,12));
      dc_lb_egreso_carrera.setName("lb_egreso_carrera");
      dc_lb_egreso_carrera.setText("Datos de Egreso de la Carrera");
      jpanel1.add(dc_lb_egreso_carrera,cc.xywh(2,10,13,1));

      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19 });
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
