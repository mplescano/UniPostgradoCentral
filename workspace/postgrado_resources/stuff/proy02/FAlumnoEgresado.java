import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class MyForm extends JPanel
{
   JTextField ae_tf_pa = new JTextField();
   JComboBox ae_cb_facu = new JComboBox();
   JTextField ae_tf_codigo_docente = new JTextField();
   JTextField ae_tf_codigo_alumno = new JTextField();
   JTextField ae_tf_fecha_incrip = new JTextField();
   JRadioButton ae_rb_doctorado = new JRadioButton();
   ButtonGroup ae_buttongroup1 = new ButtonGroup();
   JRadioButton ae_rb_maestria = new JRadioButton();
   JRadioButton ae_rb_2espc = new JRadioButton();
   JLabel ae_lb_observacion = new JLabel();
   JTextField ae_tf_observacion = new JTextField();
   JLabel ae_lb_mencion = new JLabel();
   JComboBox ae_cb_mencion = new JComboBox();
   JLabel ae_lb_estudio = new JLabel();
   JComboBox ae_cb_estudio = new JComboBox();
   JTextField ae_tf_ap_paterno = new JTextField();
   JTextField ae_tf_ap_materno = new JTextField();
   JTextField ae_tf_nombres = new JTextField();
   JTextField ae_tf_nacionalidad = new JTextField();
   JComboBox ae_cb_tp_doc = new JComboBox();
   JTextField ae_tf_nro_doc = new JTextField();
   JTextField ae_tf_fecha_nac = new JTextField();
   JTextField ae_tf_direccion = new JTextField();
   JComboBox ae_cb_ubigeo_domi = new JComboBox();
   JComboBox ae_cb_estado_civil = new JComboBox();
   JTextField ae_tf_telefono = new JTextField();
   JComboBox ae_cb_genero = new JComboBox();
   JTextField ae_tf_cell = new JTextField();
   JTextField ae_tf_correo = new JTextField();
   JComboBox ae_cb_ubigeo_nac = new JComboBox();
   JTable ae_tb_grado_titulo = new JTable();
   JButton ae_bt_add_grado_titulo = new JButton();
   JButton ae_bt_del_grado_titulo = new JButton();
   JTable ae_tb_idioma = new JTable();
   JButton ae_bt_add_idioma = new JButton();
   JButton ae_bt_del_idioma = new JButton();

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
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.1),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.1),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.1),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.1),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.1),FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:GROW(0.5),CENTER:DEFAULT:NONE,CENTER:DEFAULT:GROW(0.5),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      JLabel jlabel1 = new JLabel();
      jlabel1.setText("Periodo Academico");
      jlabel1.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(jlabel1,cc.xy(2,2));

      ae_tf_pa.setColumns(7);
      ae_tf_pa.setName("tf_pa");
      jpanel1.add(ae_tf_pa,new CellConstraints(2,4,1,1,CellConstraints.CENTER,CellConstraints.DEFAULT));

      JLabel jlabel2 = new JLabel();
      jlabel2.setText("Facultad");
      jlabel2.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(jlabel2,cc.xy(4,2));

      ae_cb_facu.setName("cb_facu");
      jpanel1.add(ae_cb_facu,cc.xy(4,4));

      JLabel jlabel3 = new JLabel();
      jlabel3.setText("Código Docente");
      jpanel1.add(jlabel3,cc.xy(8,2));

      ae_tf_codigo_docente.setName("tf_codigo_docente");
      jpanel1.add(ae_tf_codigo_docente,cc.xy(8,4));

      JLabel jlabel4 = new JLabel();
      jlabel4.setText("Codigo Alumno");
      jlabel4.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(jlabel4,cc.xy(6,2));

      ae_tf_codigo_alumno.setColumns(10);
      ae_tf_codigo_alumno.setName("tf_codigo_alumno");
      jpanel1.add(ae_tf_codigo_alumno,cc.xy(6,4));

      JLabel jlabel5 = new JLabel();
      jlabel5.setText("Fecha de Incrip.");
      jpanel1.add(jlabel5,cc.xy(10,2));

      ae_tf_fecha_incrip.setName("tf_fecha_incrip");
      jpanel1.add(ae_tf_fecha_incrip,cc.xy(10,4));

      jpanel1.add(createPanel1(),cc.xywh(2,6,10,1));
      jpanel1.add(createPanel2(),cc.xywh(2,8,10,1));
      jpanel1.add(createPanel3(),new CellConstraints(2,10,10,1,CellConstraints.DEFAULT,CellConstraints.FILL));
      jpanel1.add(createPanel5(),new CellConstraints(2,12,10,1,CellConstraints.DEFAULT,CellConstraints.FILL));
      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      EtchedBorder etchedborder1 = new EtchedBorder(EtchedBorder.RAISED,null,null);
      Border border1 = BorderFactory.createTitledBorder(etchedborder1,"Tipo de Especialidad",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,new Color(49,106,196));
      jpanel1.setBorder(border1);
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.3)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      ae_rb_doctorado.setActionCommand("Doctorado");
      ae_rb_doctorado.setName("rb_doctorado");
      ae_rb_doctorado.setText("Doctorado");
      ae_buttongroup1.add(ae_rb_doctorado);
      jpanel1.add(ae_rb_doctorado,cc.xy(1,1));

      ae_rb_maestria.setActionCommand("Maestría");
      ae_rb_maestria.setName("rb_maestria");
      ae_rb_maestria.setText("Maestría");
      ae_buttongroup1.add(ae_rb_maestria);
      jpanel1.add(ae_rb_maestria,cc.xy(3,1));

      ae_rb_2espc.setActionCommand("2da Especialización");
      ae_rb_2espc.setName("rb_2espc");
      ae_rb_2espc.setText("2da Especialización");
      ae_buttongroup1.add(ae_rb_2espc);
      jpanel1.add(ae_rb_2espc,cc.xy(5,1));

      ae_lb_observacion.setName("lb_observacion");
      ae_lb_observacion.setText("Observaciones:");
      jpanel1.add(ae_lb_observacion,cc.xy(5,3));

      ae_tf_observacion.setName("tf_observacion");
      jpanel1.add(ae_tf_observacion,cc.xy(5,5));

      ae_lb_mencion.setName("lb_mencion");
      ae_lb_mencion.setText("Mención en:");
      jpanel1.add(ae_lb_mencion,cc.xy(3,3));

      ae_cb_mencion.setName("cb_mencion");
      jpanel1.add(ae_cb_mencion,cc.xy(3,5));

      ae_lb_estudio.setName("lb_estudio");
      ae_lb_estudio.setText("Maestrias:[Modificable]");
      jpanel1.add(ae_lb_estudio,cc.xy(1,3));

      ae_cb_estudio.setName("cb_estudio");
      jpanel1.add(ae_cb_estudio,cc.xy(1,5));

      addFillComponents(jpanel1,new int[]{ 2,4 },new int[]{ 2,4 });
      return jpanel1;
   }

   public JPanel createPanel2()
   {
      JPanel jpanel1 = new JPanel();
      EtchedBorder etchedborder1 = new EtchedBorder(EtchedBorder.RAISED,null,null);
      Border border1 = BorderFactory.createTitledBorder(etchedborder1,"Datos Personales",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,new Color(49,106,196));
      jpanel1.setBorder(border1);
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2)","CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,BOTTOM:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      JLabel jlabel1 = new JLabel();
      jlabel1.setText("Ap. Paterno");
      jpanel1.add(jlabel1,cc.xy(1,1));

      JLabel jlabel2 = new JLabel();
      jlabel2.setText("Ap. Materno");
      jpanel1.add(jlabel2,cc.xy(3,1));

      JLabel jlabel3 = new JLabel();
      jlabel3.setText("Nombres");
      jpanel1.add(jlabel3,cc.xy(5,1));

      ae_tf_ap_paterno.setName("tf_ap_paterno");
      jpanel1.add(ae_tf_ap_paterno,cc.xy(1,3));

      ae_tf_ap_materno.setName("tf_ap_materno");
      jpanel1.add(ae_tf_ap_materno,cc.xy(3,3));

      ae_tf_nombres.setName("tf_nombres");
      jpanel1.add(ae_tf_nombres,cc.xy(5,3));

      JLabel jlabel4 = new JLabel();
      jlabel4.setText("Nacionalidad");
      jpanel1.add(jlabel4,cc.xy(1,5));

      JLabel jlabel5 = new JLabel();
      jlabel5.setText("Tipo Doc.");
      jpanel1.add(jlabel5,cc.xy(3,5));

      JLabel jlabel6 = new JLabel();
      jlabel6.setText("Nro. Doc.");
      jpanel1.add(jlabel6,cc.xy(5,5));

      JLabel jlabel7 = new JLabel();
      jlabel7.setText("<html><body>Fecha Nac.<br>(dd/mm/yyyy)</body></html>");
      jpanel1.add(jlabel7,cc.xy(7,5));

      ae_tf_nacionalidad.setName("tf_nacionalidad");
      jpanel1.add(ae_tf_nacionalidad,cc.xy(1,7));

      ae_cb_tp_doc.setName("cb_tp_doc");
      jpanel1.add(ae_cb_tp_doc,cc.xy(3,7));

      ae_tf_nro_doc.setName("tf_nro_doc");
      jpanel1.add(ae_tf_nro_doc,cc.xy(5,7));

      ae_tf_fecha_nac.setName("tf_fecha_nac");
      jpanel1.add(ae_tf_fecha_nac,cc.xy(7,7));

      JLabel jlabel8 = new JLabel();
      jlabel8.setText("Dirección");
      jpanel1.add(jlabel8,cc.xywh(1,9,7,1));

      ae_tf_direccion.setName("tf_direccion");
      jpanel1.add(ae_tf_direccion,cc.xywh(1,11,7,1));

      ae_cb_ubigeo_domi.setName("cb_ubigeo_domi");
      ae_cb_ubigeo_domi.setToolTipText("hola");
      jpanel1.add(ae_cb_ubigeo_domi,cc.xy(9,11));

      JLabel jlabel9 = new JLabel();
      jlabel9.setText("Estado Civil");
      jpanel1.add(jlabel9,cc.xy(7,1));

      ae_cb_estado_civil.setName("cb_estado_civil");
      jpanel1.add(ae_cb_estado_civil,cc.xy(7,3));

      JLabel jlabel10 = new JLabel();
      jlabel10.setText("Telef.");
      jpanel1.add(jlabel10,cc.xy(9,1));

      ae_tf_telefono.setName("tf_telefono");
      jpanel1.add(ae_tf_telefono,cc.xy(9,3));

      ae_cb_genero.setName("cb_genero");
      jpanel1.add(ae_cb_genero,cc.xy(9,7));

      JLabel jlabel11 = new JLabel();
      jlabel11.setText("Genero");
      jpanel1.add(jlabel11,cc.xy(9,5));

      JLabel jlabel12 = new JLabel();
      jlabel12.setText("Distrito Domic.");
      jpanel1.add(jlabel12,cc.xy(9,9));

      JLabel jlabel13 = new JLabel();
      jlabel13.setText("Celular");
      jpanel1.add(jlabel13,cc.xy(11,1));

      ae_tf_cell.setName("tf_cell");
      jpanel1.add(ae_tf_cell,cc.xy(11,3));

      JLabel jlabel14 = new JLabel();
      jlabel14.setText("Correo");
      jpanel1.add(jlabel14,cc.xy(11,5));

      ae_tf_correo.setName("tf_correo");
      jpanel1.add(ae_tf_correo,cc.xy(11,7));

      ae_cb_ubigeo_nac.setName("cb_ubigeo_nac");
      jpanel1.add(ae_cb_ubigeo_nac,cc.xy(11,11));

      JLabel jlabel15 = new JLabel();
      jlabel15.setText("Ciudad Nac.");
      jpanel1.add(jlabel15,cc.xy(11,9));

      addFillComponents(jpanel1,new int[]{ 2,4,6,8,10 },new int[]{ 2,4,6,8,10 });
      return jpanel1;
   }

   public JPanel createPanel3()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      ae_tb_grado_titulo.setName("tb_grado_titulo");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(ae_tb_grado_titulo);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xy(3,3));

      JLabel jlabel1 = new JLabel();
      jlabel1.setText("Grados Y Títulos");
      jlabel1.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(jlabel1,cc.xywh(1,1,3,1));

      jpanel1.add(createPanel4(),cc.xy(1,3));
      addFillComponents(jpanel1,new int[]{ 2,3 },new int[]{ 2,3,4 });
      return jpanel1;
   }

   public JPanel createPanel4()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      ae_bt_add_grado_titulo.setActionCommand("Agregar");
      ae_bt_add_grado_titulo.setName("bt_add_grado_titulo");
      ae_bt_add_grado_titulo.setText("Agregar");
      jpanel1.add(ae_bt_add_grado_titulo,cc.xy(1,1));

      ae_bt_del_grado_titulo.setActionCommand("Borrar");
      ae_bt_del_grado_titulo.setName("bt_del_grado_titulo");
      ae_bt_del_grado_titulo.setText("Borrar");
      jpanel1.add(ae_bt_del_grado_titulo,cc.xy(1,3));

      addFillComponents(jpanel1,new int[0],new int[]{ 2 });
      return jpanel1;
   }

   public JPanel createPanel5()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      ae_tb_idioma.setName("tb_idioma");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(ae_tb_idioma);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xy(3,3));

      JLabel jlabel1 = new JLabel();
      jlabel1.setText("Idiomas");
      jlabel1.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(jlabel1,cc.xywh(1,1,3,1));

      jpanel1.add(createPanel6(),cc.xy(1,3));
      addFillComponents(jpanel1,new int[]{ 2,3 },new int[]{ 2,3,4 });
      return jpanel1;
   }

   public JPanel createPanel6()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      ae_bt_add_idioma.setActionCommand("Agregar");
      ae_bt_add_idioma.setName("bt_add_idioma");
      ae_bt_add_idioma.setText("Agregar");
      jpanel1.add(ae_bt_add_idioma,cc.xy(1,1));

      ae_bt_del_idioma.setActionCommand("Borrar");
      ae_bt_del_idioma.setName("bt_del_idioma");
      ae_bt_del_idioma.setText("Borrar");
      jpanel1.add(ae_bt_del_idioma,cc.xy(1,3));

      addFillComponents(jpanel1,new int[0],new int[]{ 2 });
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
