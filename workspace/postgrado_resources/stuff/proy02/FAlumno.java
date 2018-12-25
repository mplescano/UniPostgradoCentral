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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class MyForm extends JPanel
{
   JLabel dp_lb_codigo_docente = new JLabel();
   JTextField dp_tf_codigo_docente = new JTextField();
   JLabel dp_lb_fecha_registro = new JLabel();
   JTextField dp_tf_fecha_registro = new JTextField();
   JLabel dp_lb_codigo_alumno = new JLabel();
   JTextField dp_tf_codigo_alumno = new JTextField();
   JLabel dp_lb_ap_paterno = new JLabel();
   JLabel dp_lb_ap_materno = new JLabel();
   JLabel dp_lb_nombres = new JLabel();
   JTextField dp_tf_ap_paterno = new JTextField();
   JTextField dp_tf_ap_materno = new JTextField();
   JTextField dp_tf_nombres = new JTextField();
   JLabel dp_lb_nacionalidad = new JLabel();
   JLabel dp_lb_tp_doc = new JLabel();
   JLabel dp_lb_nro_doc = new JLabel();
   JLabel dp_lb_fecha_nac = new JLabel();
   JTextField dp_tf_nacionalidad = new JTextField();
   JComboBox dp_cb_tp_doc = new JComboBox();
   JTextField dp_tf_nro_doc = new JTextField();
   JTextField dp_tf_fecha_nac = new JTextField();
   JLabel dp_lb_direccion = new JLabel();
   JTextField dp_tf_direccion = new JTextField();
   JComboBox dp_cb_ubigeo_domi = new JComboBox();
   JLabel dp_lb_estado_civil = new JLabel();
   JComboBox dp_cb_estado_civil = new JComboBox();
   JLabel dp_lb_telefono = new JLabel();
   JTextField dp_tf_telefono = new JTextField();
   JComboBox dp_cb_genero = new JComboBox();
   JLabel dp_lb_genero = new JLabel();
   JLabel dp_lb_domicilio = new JLabel();
   JLabel dp_lb_cell = new JLabel();
   JTextField dp_tf_cell = new JTextField();
   JLabel dp_lb_correo = new JLabel();
   JTextField dp_tf_correo = new JTextField();
   JComboBox dp_cb_ubigeo_nac = new JComboBox();
   JLabel dp_lb_nacimiento = new JLabel();
   JTable dp_tb_grado_titulo = new JTable();
   JLabel dp_lb_grado_titulo = new JLabel();
   JButton dp_bt_add_grado_titulo = new JButton();
   JButton dp_bt_del_grado_titulo = new JButton();
   JTable dp_tb_idioma = new JTable();
   JLabel dp_lb_idioma = new JLabel();
   JButton dp_bt_add_idioma = new JButton();
   JButton dp_bt_del_idioma = new JButton();
   JLabel dp_lb_cargo_ocupacion = new JLabel();
   JLabel dp_lb_empresa_trabajo = new JLabel();
   JLabel dp_lb_telefono_trabajo = new JLabel();
   JTextField dp_tf_cargo_ocupacion = new JTextField();
   JTextField dp_tf_empresa_trabajo = new JTextField();
   JTextField dp_tf_telefono_trabajo = new JTextField();

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
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:GROW(0.3),FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:GROW(0.5),CENTER:DEFAULT:NONE,CENTER:DEFAULT:GROW(0.5),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_lb_codigo_docente.setName("lb_codigo_docente");
      dp_lb_codigo_docente.setText("Código Docente");
      jpanel1.add(dp_lb_codigo_docente,new CellConstraints(6,2,1,1,CellConstraints.CENTER,CellConstraints.DEFAULT));

      dp_tf_codigo_docente.setColumns(10);
      dp_tf_codigo_docente.setName("tf_codigo_docente");
      jpanel1.add(dp_tf_codigo_docente,cc.xy(6,4));

      dp_lb_fecha_registro.setName("lb_fecha_registro");
      dp_lb_fecha_registro.setText("Fecha de Registro");
      jpanel1.add(dp_lb_fecha_registro,new CellConstraints(8,2,1,1,CellConstraints.CENTER,CellConstraints.DEFAULT));

      dp_tf_fecha_registro.setColumns(10);
      dp_tf_fecha_registro.setName("tf_fecha_registro");
      jpanel1.add(dp_tf_fecha_registro,cc.xy(8,4));

      dp_lb_codigo_alumno.setName("lb_codigo_alumno");
      dp_lb_codigo_alumno.setText("Codigo Alumno");
      dp_lb_codigo_alumno.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(dp_lb_codigo_alumno,cc.xy(4,2));

      dp_tf_codigo_alumno.setColumns(10);
      dp_tf_codigo_alumno.setName("tf_codigo_alumno");
      jpanel1.add(dp_tf_codigo_alumno,cc.xy(4,4));

      jpanel1.add(createPanel1(),cc.xywh(2,6,9,1));
      jpanel1.add(createPanel2(),new CellConstraints(2,10,9,1,CellConstraints.DEFAULT,CellConstraints.FILL));
      jpanel1.add(createPanel4(),new CellConstraints(2,12,9,1,CellConstraints.DEFAULT,CellConstraints.FILL));
      jpanel1.add(createPanel6(),cc.xywh(2,8,9,1));
      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7,8,9,10,11 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13 });
      return jpanel1;
   }

   public JPanel createPanel1()
   {
      JPanel jpanel1 = new JPanel();
      EtchedBorder etchedborder1 = new EtchedBorder(EtchedBorder.RAISED,null,null);
      Border border1 = BorderFactory.createTitledBorder(etchedborder1,"Datos Personales",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,new Color(49,106,196));
      jpanel1.setBorder(border1);
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2),FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(0.2)","CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,BOTTOM:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_lb_ap_paterno.setName("lb_ap_paterno");
      dp_lb_ap_paterno.setText("Ap. Paterno");
      jpanel1.add(dp_lb_ap_paterno,cc.xy(1,1));

      dp_lb_ap_materno.setName("lb_ap_materno");
      dp_lb_ap_materno.setText("Ap. Materno");
      jpanel1.add(dp_lb_ap_materno,cc.xy(3,1));

      dp_lb_nombres.setName("lb_nombres");
      dp_lb_nombres.setText("Nombres");
      jpanel1.add(dp_lb_nombres,cc.xy(5,1));

      dp_tf_ap_paterno.setName("tf_ap_paterno");
      jpanel1.add(dp_tf_ap_paterno,cc.xy(1,3));

      dp_tf_ap_materno.setName("tf_ap_materno");
      jpanel1.add(dp_tf_ap_materno,cc.xy(3,3));

      dp_tf_nombres.setName("tf_nombres");
      jpanel1.add(dp_tf_nombres,cc.xy(5,3));

      dp_lb_nacionalidad.setName("lb_nacionalidad");
      dp_lb_nacionalidad.setText("Nacionalidad");
      jpanel1.add(dp_lb_nacionalidad,cc.xy(1,5));

      dp_lb_tp_doc.setName("lb_tp_doc");
      dp_lb_tp_doc.setText("Tipo Doc.");
      jpanel1.add(dp_lb_tp_doc,cc.xy(3,5));

      dp_lb_nro_doc.setName("lb_nro_doc");
      dp_lb_nro_doc.setText("Nro. Doc.");
      jpanel1.add(dp_lb_nro_doc,cc.xy(5,5));

      dp_lb_fecha_nac.setName("lb_fecha_nac");
      dp_lb_fecha_nac.setText("<html><body>Fecha Nac.<br>(dd/mm/yyyy)</body></html>");
      jpanel1.add(dp_lb_fecha_nac,cc.xy(7,5));

      dp_tf_nacionalidad.setName("tf_nacionalidad");
      jpanel1.add(dp_tf_nacionalidad,cc.xy(1,7));

      dp_cb_tp_doc.setName("cb_tp_doc");
      jpanel1.add(dp_cb_tp_doc,cc.xy(3,7));

      dp_tf_nro_doc.setName("tf_nro_doc");
      jpanel1.add(dp_tf_nro_doc,cc.xy(5,7));

      dp_tf_fecha_nac.setName("tf_fecha_nac");
      jpanel1.add(dp_tf_fecha_nac,cc.xy(7,7));

      dp_lb_direccion.setName("lb_direccion");
      dp_lb_direccion.setText("Dirección");
      jpanel1.add(dp_lb_direccion,cc.xywh(1,9,7,1));

      dp_tf_direccion.setName("tf_direccion");
      jpanel1.add(dp_tf_direccion,cc.xywh(1,11,7,1));

      dp_cb_ubigeo_domi.setName("cb_ubigeo_domi");
      dp_cb_ubigeo_domi.setToolTipText("hola");
      jpanel1.add(dp_cb_ubigeo_domi,cc.xy(9,11));

      dp_lb_estado_civil.setName("lb_estado_civil");
      dp_lb_estado_civil.setText("Estado Civil");
      jpanel1.add(dp_lb_estado_civil,cc.xy(7,1));

      dp_cb_estado_civil.setName("cb_estado_civil");
      jpanel1.add(dp_cb_estado_civil,cc.xy(7,3));

      dp_lb_telefono.setName("lb_telefono");
      dp_lb_telefono.setText("Telef.");
      jpanel1.add(dp_lb_telefono,cc.xy(9,1));

      dp_tf_telefono.setName("tf_telefono");
      jpanel1.add(dp_tf_telefono,cc.xy(9,3));

      dp_cb_genero.setName("cb_genero");
      jpanel1.add(dp_cb_genero,cc.xy(9,7));

      dp_lb_genero.setName("lb_genero");
      dp_lb_genero.setText("Genero");
      jpanel1.add(dp_lb_genero,cc.xy(9,5));

      dp_lb_domicilio.setName("lb_domicilio");
      dp_lb_domicilio.setText("Distrito Domic.");
      jpanel1.add(dp_lb_domicilio,cc.xy(9,9));

      dp_lb_cell.setName("lb_cell");
      dp_lb_cell.setText("Celular");
      jpanel1.add(dp_lb_cell,cc.xy(11,1));

      dp_tf_cell.setName("tf_cell");
      jpanel1.add(dp_tf_cell,cc.xy(11,3));

      dp_lb_correo.setName("lb_correo");
      dp_lb_correo.setText("Correo");
      jpanel1.add(dp_lb_correo,cc.xy(11,5));

      dp_tf_correo.setName("tf_correo");
      jpanel1.add(dp_tf_correo,cc.xy(11,7));

      dp_cb_ubigeo_nac.setName("cb_ubigeo_nac");
      jpanel1.add(dp_cb_ubigeo_nac,cc.xy(11,11));

      dp_lb_nacimiento.setName("lb_nacimiento");
      dp_lb_nacimiento.setText("Ciudad Nac.");
      jpanel1.add(dp_lb_nacimiento,cc.xy(11,9));

      addFillComponents(jpanel1,new int[]{ 2,4,6,8,10 },new int[]{ 2,4,6,8,10 });
      return jpanel1;
   }

   public JPanel createPanel2()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_tb_grado_titulo.setName("tb_grado_titulo");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(dp_tb_grado_titulo);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xy(3,3));

      dp_lb_grado_titulo.setName("lb_grado_titulo");
      dp_lb_grado_titulo.setText("Grados y Títulos Actuales");
      dp_lb_grado_titulo.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(dp_lb_grado_titulo,cc.xywh(1,1,3,1));

      jpanel1.add(createPanel3(),cc.xy(1,3));
      addFillComponents(jpanel1,new int[]{ 2,3 },new int[]{ 2,3,4 });
      return jpanel1;
   }

   public JPanel createPanel3()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_bt_add_grado_titulo.setActionCommand("Agregar");
      dp_bt_add_grado_titulo.setName("bt_add_grado_titulo");
      dp_bt_add_grado_titulo.setText("Agregar");
      jpanel1.add(dp_bt_add_grado_titulo,cc.xy(1,1));

      dp_bt_del_grado_titulo.setActionCommand("Borrar");
      dp_bt_del_grado_titulo.setName("bt_del_grado_titulo");
      dp_bt_del_grado_titulo.setText("Borrar");
      jpanel1.add(dp_bt_del_grado_titulo,cc.xy(1,3));

      addFillComponents(jpanel1,new int[0],new int[]{ 2 });
      return jpanel1;
   }

   public JPanel createPanel4()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0)","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_tb_idioma.setName("tb_idioma");
      JScrollPane jscrollpane1 = new JScrollPane();
      jscrollpane1.setViewportView(dp_tb_idioma);
      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      jpanel1.add(jscrollpane1,cc.xy(3,3));

      dp_lb_idioma.setName("lb_idioma");
      dp_lb_idioma.setText("Idiomas");
      dp_lb_idioma.setHorizontalAlignment(JLabel.CENTER);
      jpanel1.add(dp_lb_idioma,cc.xywh(1,1,3,1));

      jpanel1.add(createPanel5(),cc.xy(1,3));
      addFillComponents(jpanel1,new int[]{ 2,3 },new int[]{ 2,3,4 });
      return jpanel1;
   }

   public JPanel createPanel5()
   {
      JPanel jpanel1 = new JPanel();
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_bt_add_idioma.setActionCommand("Agregar");
      dp_bt_add_idioma.setName("bt_add_idioma");
      dp_bt_add_idioma.setText("Agregar");
      jpanel1.add(dp_bt_add_idioma,cc.xy(1,1));

      dp_bt_del_idioma.setActionCommand("Borrar");
      dp_bt_del_idioma.setName("bt_del_idioma");
      dp_bt_del_idioma.setText("Borrar");
      jpanel1.add(dp_bt_del_idioma,cc.xy(1,3));

      addFillComponents(jpanel1,new int[0],new int[]{ 2 });
      return jpanel1;
   }

   public JPanel createPanel6()
   {
      JPanel jpanel1 = new JPanel();
      EtchedBorder etchedborder1 = new EtchedBorder(EtchedBorder.RAISED,null,null);
      Border border1 = BorderFactory.createTitledBorder(etchedborder1,"Datos Laborales",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,new Color(49,106,196));
      jpanel1.setBorder(border1);
      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:GROW(0.3),FILL:12DLU:NONE,FILL:DEFAULT:GROW(0.3),FILL:12DLU:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE,CENTER:5DLU:NONE,CENTER:DEFAULT:NONE");
      CellConstraints cc = new CellConstraints();
      jpanel1.setLayout(formlayout1);

      dp_lb_cargo_ocupacion.setName("lb_cargo_ocupacion");
      dp_lb_cargo_ocupacion.setText("Cargo/Ocupación");
      jpanel1.add(dp_lb_cargo_ocupacion,cc.xy(1,1));

      dp_lb_empresa_trabajo.setName("lb_empresa_trabajo");
      dp_lb_empresa_trabajo.setText("Empresa de Trabajo");
      jpanel1.add(dp_lb_empresa_trabajo,cc.xy(3,1));

      dp_lb_telefono_trabajo.setName("lb_telefono_trabajo");
      dp_lb_telefono_trabajo.setText("Telefono de Trabajo");
      jpanel1.add(dp_lb_telefono_trabajo,cc.xy(5,1));

      dp_tf_cargo_ocupacion.setName("tf_cargo_ocupacion");
      jpanel1.add(dp_tf_cargo_ocupacion,cc.xy(1,3));

      dp_tf_empresa_trabajo.setName("tf_empresa_trabajo");
      jpanel1.add(dp_tf_empresa_trabajo,cc.xy(3,3));

      dp_tf_telefono_trabajo.setColumns(10);
      dp_tf_telefono_trabajo.setName("tf_telefono_trabajo");
      jpanel1.add(dp_tf_telefono_trabajo,cc.xy(5,3));

      addFillComponents(jpanel1,new int[]{ 2,4 },new int[]{ 2 });
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
