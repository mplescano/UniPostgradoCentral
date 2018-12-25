import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;


public class MyForm extends JPanel
{
   JTable pe_tb_plan_estudio = new JTable();
   JButton pe_bt_curso_nuevo = new JButton();
   JButton pe_bt_curso_borrar = new JButton();
   
   JLabel pe_lb_periodo_termino = new JLabel();
   JTextField pe_tf_periodo_termino = new JTextField();
   JLabel pe_lb_fecha_sustentacion = new JLabel();
   JTextField pe_tf_fecha_sustentacion = new JTextField();
   JLabel pe_lb_tesis = new JLabel();
   JTextField pe_tf_tesis01 = new JTextField();
   JTextField pe_tf_tesis02 = new JTextField();
   
   JTextField pe_tf_nombre_alumno_egresado = new JTextField();
   JLabel pe_lb_nombres = new JLabel();

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
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      pe_tb_plan_estudio.setName("tb_plan_estudio");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(pe_tb_plan_estudio);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xy(4,4));

      jpanel1.add(createPanel1(),cc.xy(2,4));
      jpanel1.add(createPanel2(),cc.xywh(2,6,3,1));
      pe_tf_nombre_alumno_egresado.setBackground(new Color(236,233,216));
      pe_tf_nombre_alumno_egresado.setEditable(false);
      pe_tf_nombre_alumno_egresado.setName("tf_nombre_alumno_egresado");
      jpanel1.add(pe_tf_nombre_alumno_egresado,cc.xy(4,2));

      pe_lb_nombres.setName("lb_nombres");
      pe_lb_nombres.setText("Nombres:");
      jpanel1.add(pe_lb_nombres,cc.xy(2,2));

      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5 },new int[]{ 1,2,3,4,5,6,7 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      pe_bt_curso_nuevo.setActionCommand("JButton");
      pe_bt_curso_nuevo.setName("bt_curso_nuevo");
      pe_bt_curso_nuevo.setText("Adicionar");
      jpanel1.add(pe_bt_curso_nuevo,cc.xy(1,1));

      pe_bt_curso_borrar.setActionCommand("JButton");
      pe_bt_curso_borrar.setName("bt_curso_borrar");
      pe_bt_curso_borrar.setText("Borrar");
      jpanel1.add(pe_bt_curso_borrar,cc.xy(1,3));

      addFillComponents(jpanel1,new int[0],new int[]{ 2 });
      return jpanel1;
   }

   public JPanel createPanel2()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      pe_lb_periodo_termino.setName("lb_periodo_termino");
      pe_lb_periodo_termino.setText("Periodo de Término:");
      jpanel1.add(pe_lb_periodo_termino,cc.xy(1,1));

      pe_tf_periodo_termino.setColumns(10);
      pe_tf_periodo_termino.setName("tf_periodo_termino");
      jpanel1.add(pe_tf_periodo_termino,cc.xy(3,1));

      pe_lb_fecha_sustentacion.setName("lb_fecha_sustentacion");
      pe_lb_fecha_sustentacion.setText("Fecha de Sustentación:");
      jpanel1.add(pe_lb_fecha_sustentacion,cc.xy(1,3));

      pe_tf_fecha_sustentacion.setColumns(10);
      pe_tf_fecha_sustentacion.setName("tf_fecha_sustentacion");
      jpanel1.add(pe_tf_fecha_sustentacion,cc.xy(3,3));

      pe_lb_tesis.setName("lb_tesis");
      pe_lb_tesis.setText("Tesis:");
      jpanel1.add(pe_lb_tesis,cc.xy(5,1));

      pe_tf_tesis01.setName("tf_tesis01");
      jpanel1.add(pe_tf_tesis01,cc.xy(7,1));

      pe_tf_tesis011.setName("tf_tesis01");
      jpanel1.add(pe_tf_tesis011,cc.xy(7,3));

      addFillComponents(jpanel1,new int[]{ 2,4,6 },new int[]{ 2,4 });
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
