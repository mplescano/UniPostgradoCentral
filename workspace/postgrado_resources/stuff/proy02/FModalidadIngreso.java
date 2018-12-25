import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MyForm extends JPanel
{
   JLabel mi_lb_ex_admision = new JLabel();
   JRadioButton mi_rb_ingresado = new JRadioButton();
   ButtonGroup mi_buttongroup1 = new ButtonGroup();
   JRadioButton mi_rb_no_ingresado = new JRadioButton();
   JTextField mi_tf_traslado = new JTextField();
   JTextField mi_tf_exonerado = new JTextField();
   JLabel mi_lb_modalidad = new JLabel();
   JRadioButton mi_rb_examen = new JRadioButton();
   JRadioButton mi_rb_pre_maestria = new JRadioButton();
   JRadioButton mi_rb_5to_superior = new JRadioButton();
   JRadioButton mi_rb_docente_uni = new JRadioButton();
   JRadioButton mi_rb_traslado = new JRadioButton();
   JRadioButton mi_rb_exonerado = new JRadioButton();

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
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.3),FILL:5DLU:NONE,FILL:DEFAULT:GROW(0.3),FILL:5DLU:NONE,FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,TOP:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      mi_lb_ex_admision.setName("lb_ex_admision");
      mi_lb_ex_admision.setText("Examen de Admisión:");
      jpanel1.add(mi_lb_ex_admision,cc.xy(2,2));

      mi_rb_ingresado.setActionCommand("Ingresó");
      mi_rb_ingresado.setName("rb_ingresado");
      mi_rb_ingresado.setText("Ingresó");
      mi_buttongroup1.add(mi_rb_ingresado);
      jpanel1.add(mi_rb_ingresado,cc.xy(4,2));

      mi_rb_no_ingresado.setActionCommand("No Ingresó");
      mi_rb_no_ingresado.setName("rb_no_ingresado");
      mi_rb_no_ingresado.setText("No Ingresó");
      mi_buttongroup1.add(mi_rb_no_ingresado);
      jpanel1.add(mi_rb_no_ingresado,cc.xy(6,2));

      jpanel1.add(createPanel1(),cc.xywh(2,4,5,1));
      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,2,3,4,5 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:5DLU:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.9)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      mi_tf_traslado.setName("tf_traslado");
      jpanel1.add(mi_tf_traslado,cc.xy(4,5));

      mi_tf_exonerado.setName("tf_exonerado");
      jpanel1.add(mi_tf_exonerado,cc.xy(4,6));

      mi_lb_modalidad.setName("lb_modalidad");
      mi_lb_modalidad.setText("Modalidad:");
      jpanel1.add(mi_lb_modalidad,cc.xy(1,1));

      mi_rb_examen.setActionCommand("EXAMEN");
      mi_rb_examen.setName("rb_examen");
      mi_rb_examen.setText("EXAMEN");
      mi_buttongroup1.add(mi_rb_examen);
      jpanel1.add(mi_rb_examen,cc.xy(3,1));

      mi_rb_pre_maestria.setActionCommand("PRE-MAESTRÍA");
      mi_rb_pre_maestria.setName("rb_pre_maestria");
      mi_rb_pre_maestria.setText("PRE-MAESTRÍA");
      mi_buttongroup1.add(mi_rb_pre_maestria);
      jpanel1.add(mi_rb_pre_maestria,cc.xy(3,2));

      mi_rb_5to_superior.setActionCommand("5to SUPERIOR");
      mi_rb_5to_superior.setName("rb_5to_superior");
      mi_rb_5to_superior.setText("5to SUPERIOR");
      mi_buttongroup1.add(mi_rb_5to_superior);
      jpanel1.add(mi_rb_5to_superior,cc.xy(3,3));

      mi_rb_docente_uni.setActionCommand("DOCENTE UNI");
      mi_rb_docente_uni.setName("rb_docente_uni");
      mi_rb_docente_uni.setText("DOCENTE UNI");
      mi_buttongroup1.add(mi_rb_docente_uni);
      jpanel1.add(mi_rb_docente_uni,cc.xy(3,4));

      mi_rb_traslado.setActionCommand("TRASLADO");
      mi_rb_traslado.setName("rb_traslado");
      mi_rb_traslado.setText("TRASLADO");
      mi_buttongroup1.add(mi_rb_traslado);
      jpanel1.add(mi_rb_traslado,cc.xy(3,5));

      mi_rb_exonerado.setActionCommand("EXONERADO");
      mi_rb_exonerado.setName("rb_exonerado");
      mi_rb_exonerado.setText("EXONERADO");
      mi_buttongroup1.add(mi_rb_exonerado);
      jpanel1.add(mi_rb_exonerado,cc.xy(3,6));

      addFillComponents(jpanel1,new int[]{ 2,4 },new int[]{ 2,3,4,5,6,7 });
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
