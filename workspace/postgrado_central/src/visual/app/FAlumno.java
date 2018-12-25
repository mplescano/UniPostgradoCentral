package visual.app;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import servicio.AppServicio;
import visual.app.tableModel.TableModelListPlanEstudio;
import visual.util.JButtonGroup;
import visual.util.PanelUtils;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import dominio.negocio.Facultad;
import dominio.negocio.Ubigeo;
import java.awt.GridBagLayout;

public class FAlumno extends JDialog {
	private JPanel jContentPane = null;
	private JTabbedPane tp_alumno_egresado = null;
	private JPanel pe_pn_plan_estudio = null;
	   JTextField ae_tf_pa;
	   JTextField ae_tf_observaciones;
	   JTextField ae_tf_ap_paterno;
	   JTextField ae_tf_ap_materno;
	   JTextField ae_tf_nombres;
	   JTextField ae_tf_nacionalidad;
	   JTextField ae_tf_nro_doc;
	   
	   private JFormattedTextField ae_tf_fecha_nac;
	   private JFormattedTextField ae_tf_fecha_incrip;
	   private JFormattedTextField pe_tf_fecha_sustentacion;
	   
	   JTextField ae_tf_direccion;
	   JTextField ae_tf_codigo_docente;
	   JTextField ae_tf_codigo_alumno;
	   JTextField ae_tf_telefono;
	   JTextField ae_tf_cell;
	   JTextField ae_tf_correo;
	   
	   JRadioButton ae_rb_maestria;
	   JRadioButton ae_rb_2espc;
	   JRadioButton ae_rb_doctorado;
	   
	   JComboBox ae_cb_facu;
	   JComboBox ae_cb_tp_doc;
	   JComboBox ae_cb_genero;
	   JComboBox ae_cb_ubigeo;
	   JComboBox ae_cb_estado_civil;
	   JComboBox ae_cb_ubigeo_nac;
	   JComboBox ae_cb_mencion;
	   
	   JTable ae_tb_grado_titulo;
	   JTable ae_tb_idioma;
	   
	   JButton ae_bt_add_grado_titulo;
	   JButton ae_bt_del_grado_titulo;
	   JButton ae_bt_add_idioma;
	   JButton ae_bt_del_idioma;
	   
	   JButton ae_bt_buscar_ubigeo;
	   JButton ae_bt_save;
	   JButton ae_bt_plan_estudio;
	   JButton ae_bt_reset;
	   JButton ae_bt_cancel;
	   JButton ae_bt_imp_certif_final;
	   JButton ae_bt_imp_certif;

	   JLabel mi_lb_ex_admision = null;
	   JRadioButton mi_rb_ingresado = null;
	   JRadioButton mi_rb_no_ingresado = null;
	   
	   JButtonGroup ae_bg_tp_maestria = null;
	   JButtonGroup mi_bg_ingreso = null;
	   JButtonGroup mi_bg_modalidad = null;
	   
	   JTextField mi_tf_traslado = null;
	   JTextField mi_tf_exonerado = null;
	   JLabel mi_lb_modalidad = null;
	   
	   JRadioButton mi_rb_examen = null;
	   JRadioButton mi_rb_pre_maestria = null;
	   JRadioButton mi_rb_5to_superior = null;
	   JRadioButton mi_rb_docente_uni = null;
	   JRadioButton mi_rb_traslado = null;
	   JRadioButton mi_rb_exonerado = null;
	   
	private JLabel pe_lb_periodo_termino;
	private JLabel pe_lb_fecha_sustentacion;
	private JLabel pe_lb_tesis;
	private JTextField pe_tf_periodo_termino;
	private JTextField pe_tf_tesis01;
	private JTextField pe_tf_tesis02;
	
	private JScrollPane pe_sp_plan_estudio = null;
	private JButton pe_bt_curso_nuevo = null;
	private JButton pe_bt_curso_borrar = null;
	private JTextField pe_tf_nombre_alumno_egresado;
	private JTable pe_tb_plan_estudio = null;
	private JComboBox ae_cb_estudio;
	JLabel ae_lb_estudio;
	
	
	   JTable hm_tb_movi;
	   JButton hm_bt_add;
	   JButton hm_bt_edit;
	   JButton hm_bt_del;
	   JButton hm_bt_first;
	   JButton hm_bt_prev;
	   JButton hm_bt_next;
	   JButton hm_bt_last;
	   
	   JPanel hm_pn_nav;
	   JPanel hm_pn_exe;
	
		
	public JButtonGroup getAe_bg_tp_maestria () {
		if (ae_bg_tp_maestria == null) {
			ae_bg_tp_maestria = new JButtonGroup();
		}
		return ae_bg_tp_maestria;
	}
	
	public JTabbedPane getTp_alumno_egresado() {
		if (tp_alumno_egresado == null) {
			tp_alumno_egresado = new JTabbedPane();
			tp_alumno_egresado.addTab("Datos Personales", null, getAe_pn_datos_personales(), null);
			tp_alumno_egresado.addTab("Modalidad de Ingreso", null, getMi_pn_modalidad(), null);
			tp_alumno_egresado.addTab("Plan de Estudio", null, getPe_pn_plan_estudio (), null);
			tp_alumno_egresado.addTab("Historial de Movi.", null, getHm_pn_historial_mov(), null);
		}
		return tp_alumno_egresado;
	}
	
	private JPanel getPe_pn_plan_estudio () {
		if (pe_pn_plan_estudio == null) {
			  pe_pn_plan_estudio = new JPanel();			
			/**/
			  JLabel pe_lb_nombres = new JLabel();
		      FormLayout formlayout1 = new FormLayout(
		    		  new ColumnSpec[] {
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
    						  new ColumnSpec("FILL:DEFAULT:NONE"),
    						  new ColumnSpec("FILL:DEFAULT:NONE"),
    						  new ColumnSpec("FILL:DEFAULT:GROW(1.0)"),
    						  new ColumnSpec("FILL:DEFAULT:NONE")
		    				  },
		    		  new RowSpec[] {
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
    						  new RowSpec("CENTER:DEFAULT:NONE"),
    						  new RowSpec("CENTER:DEFAULT:NONE"),
    						  new RowSpec("FILL:DEFAULT:GROW(1.0)"),
    						  new RowSpec("CENTER:DEFAULT:NONE"),
    						  new RowSpec("CENTER:DEFAULT:NONE"),
    						  new RowSpec("CENTER:DEFAULT:NONE")
		    				  });
		      CellConstraints cc = new CellConstraints();
		      pe_pn_plan_estudio.setLayout(formlayout1);
		      pe_pn_plan_estudio.add(getPe_sp_plan_estudio(),cc.xy(4,4));

		      pe_pn_plan_estudio.add(getPe_pn_botones_curso (),cc.xy(2,4));
		      pe_pn_plan_estudio.add(getPe_pn_tesis (),cc.xywh(2,6,3,1));

		      pe_pn_plan_estudio.add(getPe_tf_nombre_alumno_egresado(),cc.xy(4,2));

		      pe_lb_nombres.setName("lb_nombres");
		      pe_lb_nombres.setText("Nombres:");
		      pe_pn_plan_estudio.add(pe_lb_nombres,cc.xy(2,2));

		      PanelUtils.addFillComponents(pe_pn_plan_estudio,new int[]{ 1,2,3,4,5 },new int[]{ 1,2,3,4,5,6,7 });
			/**/
		}
		return pe_pn_plan_estudio;
	}
	JPanel pe_pn_botones_curso;
	public JPanel getPe_pn_botones_curso () {
	      if (pe_pn_botones_curso == null) {
	    	  pe_pn_botones_curso = new JPanel();
		      FormLayout formlayout1 = new FormLayout(
		    		  new ColumnSpec[]{
		    				  new ColumnSpec("FILL:DEFAULT:NONE")
		    		  },
		    		  new RowSpec[]{
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE")
		    		  });
		      CellConstraints cc = new CellConstraints();
		      pe_pn_botones_curso.setLayout(formlayout1);
		      pe_pn_botones_curso.add(getPe_bt_curso_nuevo(),cc.xy(1,1));
		      pe_pn_botones_curso.add(getPe_bt_curso_borrar(),cc.xy(1,3));
		      PanelUtils.addFillComponents(pe_pn_botones_curso,new int[0],new int[]{ 2 });
	      }
	      return pe_pn_botones_curso;
	}
	JPanel pe_pn_tesis;
	public JPanel getPe_pn_tesis () {
	      if (pe_pn_tesis == null) {
	    	  pe_pn_tesis = new JPanel();
		      FormLayout formlayout1 = new FormLayout(
		    		  new ColumnSpec[]{
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:GROW(1.0)")
		    		  },
		    		  new RowSpec[]{
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE")
		    		  });
		      CellConstraints cc = new CellConstraints();
		      pe_pn_tesis.setLayout(formlayout1);


		      pe_pn_tesis.add(getPe_lb_periodo_termino(),cc.xy(1,1));


		      pe_pn_tesis.add(getPe_tf_periodo_termino(),cc.xy(3,1));

		      pe_pn_tesis.add(getPe_lb_fecha_sustentacion(),cc.xy(1,3));

		      pe_pn_tesis.add(getPe_tf_fecha_sustentacion(),cc.xy(3,3));

		      pe_pn_tesis.add(getPe_lb_tesis(),cc.xy(5,1));


		      pe_pn_tesis.add(getPe_tf_tesis01(),cc.xy(7,1));

		      pe_pn_tesis.add(getPe_tf_tesis02(),cc.xy(7,3));

		      PanelUtils.addFillComponents(pe_pn_tesis,new int[]{ 2,4,6 },new int[]{ 2,4 });
	      }
	      return pe_pn_tesis;
	}
	
	JPanel mi_pn_modalidad;
	private JPanel getMi_pn_modalidad () {
		if (mi_pn_modalidad == null) {
			mi_pn_modalidad = new JPanel();
		      FormLayout formlayout1 = new FormLayout(
		    		  new ColumnSpec[]{
		    				  new ColumnSpec("FILL:DEFAULT:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:GROW(0.3)"),
		    				  new ColumnSpec("FILL:5DLU:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:GROW(0.3)"),
		    				  new ColumnSpec("FILL:5DLU:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:GROW(0.3)"),
		    				  new ColumnSpec("FILL:DEFAULT:NONE")
		    		  },
		    		  new RowSpec[]{
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("TOP:DEFAULT:GROW(1.0)"),
		    				  new RowSpec("CENTER:DEFAULT:NONE")
		    		  });
		      CellConstraints cc = new CellConstraints();
		      mi_pn_modalidad.setLayout(formlayout1);
		      
		      mi_lb_ex_admision = new JLabel();
		      mi_lb_ex_admision.setName("lb_ex_admision");
		      mi_lb_ex_admision.setText("Examen de Admisión:");
		      mi_pn_modalidad.add(mi_lb_ex_admision,cc.xy(2,2));
		      
		      getMi_bg_ingreso().add(getMi_rb_ingresado());
		      mi_pn_modalidad.add(getMi_rb_ingresado(),cc.xy(4,2));
		      
		      getMi_bg_ingreso().add(getMi_rb_no_ingresado());
		      mi_pn_modalidad.add(getMi_rb_no_ingresado(),cc.xy(6,2));

		      mi_pn_modalidad.add(getMi_pn_datos_modalidad(),cc.xywh(2,4,5,1));
		      PanelUtils.addFillComponents(mi_pn_modalidad,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,2,3,4,5 });
		}
	      return mi_pn_modalidad;
	}
	JPanel mi_pn_datos_modalidad;
	   public JPanel getMi_pn_datos_modalidad() {
		   if (mi_pn_datos_modalidad == null) {
			   mi_pn_datos_modalidad = new JPanel();
		   }
	      FormLayout formlayout1 = new FormLayout(
	    		  new ColumnSpec[] {
	    				  new ColumnSpec("FILL:DEFAULT:NONE"),
	    				  new ColumnSpec("FILL:5DLU:NONE"),
	    				  new ColumnSpec("FILL:DEFAULT:NONE"),
	    				  new ColumnSpec("FILL:DEFAULT:GROW(0.9)")
	    		  },
	    		  new RowSpec[]{
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE")
	    		  });
	      CellConstraints cc = new CellConstraints();
	      mi_pn_datos_modalidad.setLayout(formlayout1);

	      mi_pn_datos_modalidad.add(getMi_tf_traslado(),cc.xy(4,5));
	      
	      mi_pn_datos_modalidad.add(getMi_tf_exonerado(),cc.xy(4,6));
	      
	      mi_lb_modalidad = new JLabel();
	      mi_lb_modalidad.setName("lb_modalidad");
	      mi_lb_modalidad.setText("Modalidad:");
	      mi_pn_datos_modalidad.add(mi_lb_modalidad,cc.xy(1,1));

	      getMi_bg_modalidad().add(getMi_rb_examen());
	      mi_pn_datos_modalidad.add(getMi_rb_examen(),cc.xy(3,1));

	      getMi_bg_modalidad().add(getMi_rb_pre_maestria());
	      mi_pn_datos_modalidad.add(getMi_rb_pre_maestria(),cc.xy(3,2));

	      getMi_bg_modalidad().add(getMi_rb_5to_superior());
	      mi_pn_datos_modalidad.add(getMi_rb_5to_superior(),cc.xy(3,3));

	      getMi_bg_modalidad().add(getMi_rb_docente_uni());
	      mi_pn_datos_modalidad.add(getMi_rb_docente_uni(),cc.xy(3,4));

	      getMi_bg_modalidad().add(getMi_rb_traslado());
	      mi_pn_datos_modalidad.add(getMi_rb_traslado(),cc.xy(3,5));

	      getMi_bg_modalidad().add(getMi_rb_exonerado());
	      mi_pn_datos_modalidad.add(getMi_rb_exonerado(),cc.xy(3,6));
	      
	      PanelUtils.addFillComponents(mi_pn_datos_modalidad,new int[]{ 2,4 },new int[]{ 2,3,4,5,6,7 });
	      return mi_pn_datos_modalidad;
	   }
	
	private JScrollPane getPe_sp_plan_estudio() {
		if (pe_sp_plan_estudio == null) {
			pe_sp_plan_estudio = new JScrollPane();
			pe_sp_plan_estudio.setBounds(new java.awt.Rectangle(6,40,580,293));
			pe_sp_plan_estudio.setViewportView(getPe_tb_plan_estudio ());
		}
		return pe_sp_plan_estudio;
	}
	
	public JButton getPe_bt_curso_nuevo() {
		if (pe_bt_curso_nuevo == null) {
			pe_bt_curso_nuevo = new JButton();
			pe_bt_curso_nuevo.setBounds(new java.awt.Rectangle(5,340,100,20));
			pe_bt_curso_nuevo.setText("Adicionar");
		}
		return pe_bt_curso_nuevo;
	}

	public JButton getPe_bt_curso_borrar () {
		if (pe_bt_curso_borrar == null) {
			pe_bt_curso_borrar = new JButton();
			pe_bt_curso_borrar.setBounds(new java.awt.Rectangle(112,340,100,20));
			pe_bt_curso_borrar.setText("Borrar");
		}
		return pe_bt_curso_borrar;
	}

	public JTextField getPe_tf_nombre_alumno_egresado () {
		if (pe_tf_nombre_alumno_egresado == null) {
			pe_tf_nombre_alumno_egresado = new JTextField();
			pe_tf_nombre_alumno_egresado.setBounds(new java.awt.Rectangle(90,10,291,21));
			pe_tf_nombre_alumno_egresado.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
			pe_tf_nombre_alumno_egresado.setEditable(false);
		}
		return pe_tf_nombre_alumno_egresado;
	}
	
	public JTable getPe_tb_plan_estudio() {
		if (pe_tb_plan_estudio == null) {
			pe_tb_plan_estudio = new JTable();
			pe_tb_plan_estudio.setName("TbPlanEstudio");
			
			// Usando scroll 
			pe_tb_plan_estudio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			// Asignando el listener que reajuste las columnas al texto 
			pe_tb_plan_estudio.addPropertyChangeListener("model", new PropertyChangeListener () {
				public void propertyChange(PropertyChangeEvent evt) {
					PanelUtils.packColumns(pe_tb_plan_estudio, 2);
				}
			});
			
			//Asignando el Modelo  
			pe_tb_plan_estudio.setModel(new TableModelListPlanEstudio(null));
		}
		return pe_tb_plan_estudio;
	}
	
	public JTable getHm_tb_movi () {
		if (hm_tb_movi == null) {
			hm_tb_movi = new JTable();
		      hm_tb_movi.setName("tb_movi");
		}
		return hm_tb_movi;
	}
	JScrollPane hm_sp_movi;
	public JScrollPane getHm_sp_movi () {
		if (hm_sp_movi == null) {
			hm_sp_movi = new JScrollPane();
		      hm_sp_movi.setViewportView(getHm_tb_movi());
		      hm_sp_movi.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		      hm_sp_movi.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		}
		return hm_sp_movi;
	}

	/**
	 * This method initializes hm_pn_historial_mov	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getHm_pn_historial_mov() {
		if (hm_pn_historial_mov == null) {
			hm_pn_historial_mov = new JPanel();
		      FormLayout formlayout1 = new FormLayout(
		    		  new ColumnSpec[] {
		    				  new ColumnSpec("FILL:5DLU:NONE"),
		    				  new ColumnSpec("FILL:DEFAULT:GROW(1.0)"),
		    				  new ColumnSpec("FILL:5DLU:NONE")
		    		  },
		    		  new RowSpec[]{
		    				  new RowSpec("CENTER:5DLU:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:5DLU:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:GROW(1.0)"),
		    				  new RowSpec("CENTER:5DLU:NONE"),
		    				  new RowSpec("CENTER:DEFAULT:NONE"),
		    				  new RowSpec("CENTER:5DLU:NONE")
		    		  });
		      CellConstraints cc = new CellConstraints();
			hm_pn_historial_mov.setLayout(formlayout1);

		      hm_pn_historial_mov.add(getHm_sp_movi(),new CellConstraints(2,4,1,1,CellConstraints.DEFAULT,CellConstraints.FILL));

		      hm_pn_historial_mov.add(getHm_pn_exe(),new CellConstraints(2,6,1,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
		      hm_pn_historial_mov.add(getHm_pn_nav(),new CellConstraints(2,2,1,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
		      PanelUtils.addFillComponents(hm_pn_historial_mov,new int[]{ 1,2,3 },new int[]{ 1,2,3,4,5,6,7 });
		}
		return hm_pn_historial_mov;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FAlumno().setVisible(true);
	}

	/**
	 * This is the default constructor
	 */
	public FAlumno() {
		super();
		initialize();
	}

	public FAlumno(Dialog parent) {
		super(parent, true);
		initialize();
	}
	
	public FAlumno(Frame parent) {
		super(parent, true);
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 750);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Formulario del Alumno Egresado");
		this.setContentPane(getJContentPane());
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getTp_alumno_egresado(), BorderLayout.CENTER);
			jContentPane.add(getPn_botones_control(), java.awt.BorderLayout.SOUTH);
		}
		return jContentPane;
	}
	
	public JTextField getAe_tf_ap_materno() {
		if (ae_tf_ap_materno == null) {
			ae_tf_ap_materno = new JTextField();
		      ae_tf_ap_materno.setName("tf_ap_materno");
		      ae_tf_ap_materno.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_ap_materno;
	}
	
	public JTextField getAe_tf_ap_paterno() {
		if (ae_tf_ap_paterno == null) {
			ae_tf_ap_paterno = new JTextField();
		      ae_tf_ap_paterno.setName("tf_ap_paterno");
		      ae_tf_ap_paterno.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_ap_paterno;
	}
	
	public JTextField getAe_tf_codigo_alumno() {
		if (ae_tf_codigo_alumno == null) {
			ae_tf_codigo_alumno = new JTextField();
		      ae_tf_codigo_alumno.setColumns(10);
		      ae_tf_codigo_alumno.setName("tf_codigo_alumno");
		      ae_tf_codigo_alumno.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_codigo_alumno;
	}
	
	public JTextField getAe_tf_codigo_docente() {
		if (ae_tf_codigo_docente == null) {
			ae_tf_codigo_docente = new JTextField();
			ae_tf_codigo_docente.setName("tf_codigo_docente");
			ae_tf_codigo_docente.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_codigo_docente;
	}
	
	public JTextField getAe_tf_direccion() {
		if (ae_tf_direccion == null) {
			ae_tf_direccion = new JTextField();
			ae_tf_direccion.setName("tf_direccion");
			ae_tf_direccion.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_direccion;
	}
	
	public JFormattedTextField getAe_tf_fecha_nac() {
		if (ae_tf_fecha_nac == null) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			df.setLenient(false);
			ae_tf_fecha_nac = new JFormattedTextField(df);
			//ae_tf_fecha_nac.setColumns(8);
			ae_tf_fecha_nac.setName("tf_fecha_nac");
			ae_tf_fecha_nac.setInputVerifier(PanelUtils.getInputVerifier());
		}
		return ae_tf_fecha_nac;
	}
	
	public JTextField getAe_tf_observaciones() {
		if (ae_tf_observaciones == null) {
			ae_tf_observaciones = new JTextField();
		      ae_tf_observaciones.setName("tf_observaciones");
		      ae_tf_observaciones.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_observaciones;
	}
	
	public JTextField getAe_tf_nacionalidad() {
		if (ae_tf_nacionalidad == null) {
			ae_tf_nacionalidad = new JTextField();
		      ae_tf_nacionalidad.setName("tf_nacionalidad");
		      ae_tf_nacionalidad.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_nacionalidad;
	}
	
	public JTextField getAe_tf_nombres() {
		if (ae_tf_nombres == null) {
			ae_tf_nombres = new JTextField();
		      ae_tf_nombres.setName("tf_nombres");
		      ae_tf_nombres.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_nombres;
	}
	

	public JTextField getAe_tf_nro_doc() {
		if (ae_tf_nro_doc == null) {
			ae_tf_nro_doc = new JTextField();
		      ae_tf_nro_doc.setName("tf_nro_doc");
		}
		return ae_tf_nro_doc;
	}
	

	public JTextField getAe_tf_pa() {
		if (ae_tf_pa == null) {
			ae_tf_pa = new JTextField();
		      ae_tf_pa.setColumns(7);
		      ae_tf_pa.setName("tf_pa");
		      ae_tf_pa.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return ae_tf_pa;
	}

	public JButton getAe_bt_add_grado_titulo() {
		if (ae_bt_add_grado_titulo == null) {
			ae_bt_add_grado_titulo = new JButton();
		      ae_bt_add_grado_titulo.setActionCommand("Agregar");
		      ae_bt_add_grado_titulo.setName("bt_add_grado_titulo");
		      ae_bt_add_grado_titulo.setText("Agregar");
		}
		return ae_bt_add_grado_titulo;
	}
	
	public JButton getAe_bt_add_idioma() {
		if (ae_bt_add_idioma == null) {
			ae_bt_add_idioma = new JButton();
		      ae_bt_add_idioma.setActionCommand("Agregar");
		      ae_bt_add_idioma.setName("bt_add_idioma");
		      ae_bt_add_idioma.setText("Agregar");
		}
		return ae_bt_add_idioma;
	}
	

	public JButton getAe_bt_imp_certif_final() {
		if (ae_bt_imp_certif_final == null) {
			ae_bt_imp_certif_final = new JButton();
		      ae_bt_imp_certif_final.setActionCommand("Imp. Certif. Final");
		      ae_bt_imp_certif_final.setName("bt_imp_certif_final");
		      ae_bt_imp_certif_final.setText("Imp. Certif. Final");
		}
		return ae_bt_imp_certif_final;
	}
	

	public JButton getAe_bt_buscar_ubigeo() {
		if (ae_bt_buscar_ubigeo == null) {
			ae_bt_buscar_ubigeo = new JButton();
		      ae_bt_buscar_ubigeo.setActionCommand("Buscar");
		      ae_bt_buscar_ubigeo.setName("bt_buscar_ubigeo");
		      ae_bt_buscar_ubigeo.setText("Buscar");
		}
		return ae_bt_buscar_ubigeo;
	}
	

	public JButton getAe_bt_cancel() {
		if (ae_bt_cancel == null) {
			ae_bt_cancel = new JButton();
		      ae_bt_cancel.setActionCommand("Cerrar");
		      ae_bt_cancel.setName("bt_cancel");
		      ae_bt_cancel.setText("Cerrar");
		}
		return ae_bt_cancel;
	}
	

	public JButton getAe_bt_del_grado_titulo() {
		if (ae_bt_del_grado_titulo == null) {
			ae_bt_del_grado_titulo = new JButton();
		      ae_bt_del_grado_titulo.setActionCommand("Borrar");
		      ae_bt_del_grado_titulo.setName("bt_del_grado_titulo");
		      ae_bt_del_grado_titulo.setText("Borrar");
		}
		return ae_bt_del_grado_titulo;
	}
	
	public JButton getAe_bt_del_idioma() {
		if (ae_bt_del_idioma == null) {
			ae_bt_del_idioma = new JButton();
		      ae_bt_del_idioma.setActionCommand("Borrar");
		      ae_bt_del_idioma.setName("bt_del_idioma");
		      ae_bt_del_idioma.setText("Borrar");
		}
		return ae_bt_del_idioma;
	}
	
	public JButton getAe_bt_plan_estudio() {
		if (ae_bt_plan_estudio == null) {
			ae_bt_plan_estudio = new JButton();
		      ae_bt_plan_estudio.setActionCommand("Pasar al Plan de Estudios");
		      ae_bt_plan_estudio.setName("bt_plan_estudio");
		      ae_bt_plan_estudio.setText("Pasar al Plan de Estudios");
		}
		return ae_bt_plan_estudio;
	}
	

	public JButton getAe_bt_reset() {
		if (ae_bt_reset == null) {
			ae_bt_reset = new JButton();
		      ae_bt_reset.setActionCommand("Limpiar/Reiniciar");
		      ae_bt_reset.setName("bt_reset");
		      ae_bt_reset.setText("Limpiar/Reiniciar");

		}
		return ae_bt_reset;
	}
	
	public JButton getAe_bt_save() {
		if (ae_bt_save == null) {
			ae_bt_save = new JButton();
		      ae_bt_save.setActionCommand("Grabar");
		      ae_bt_save.setName("bt_save");
		      ae_bt_save.setText("Grabar");
		}
		return ae_bt_save;
	}
	
	public JComboBox getAe_cb_facu() {
		if (ae_cb_facu == null) {
			ae_cb_facu = new JComboBox(AppServicio.getInstance().getFacultadList().toArray());
			ae_cb_facu.setName("cb_facu");
			ae_cb_facu.setRenderer(new DefaultListCellRenderer () {

				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value != null) {
						Facultad f = (Facultad) value;
						setText(f.getCodigo());
						setToolTipText(f.getNombre());
					}
					else {
						setText("[NINGUNO]");
					}
					return comp;
				}
				
			});
			ae_cb_facu.setSelectedIndex(-1);
		}
		return ae_cb_facu;
	}
	
	public JComboBox getAe_cb_genero() {
		if (ae_cb_genero == null) {
			ae_cb_genero = new JComboBox(new String[]{"HB", "MJ"});
			ae_cb_genero.setName("cb_genero");
			ae_cb_genero.setRenderer(new DefaultListCellRenderer () {
				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					String op = (String) value;
					if (op.equals("HB")) setText("HOMBRE");
					if (op.equals("MJ")) setText("MUJER");
					return comp;
				}
			});
		}
		return ae_cb_genero;
	}
	

	public JRadioButton getAe_rb_2espc() {
		if (ae_rb_2espc == null) {
			ae_rb_2espc = new JRadioButton();
		      ae_rb_2espc.setActionCommand("2da Especialización");
		      ae_rb_2espc.setName("rb_2espc");
		      ae_rb_2espc.setText("2da Especialización");
		}
		return ae_rb_2espc;
	}
	
	public JRadioButton getAe_rb_doctorado() {
		if (ae_rb_doctorado == null) {
			ae_rb_doctorado = new JRadioButton();
		      ae_rb_doctorado.setActionCommand("Doctorado");
		      ae_rb_doctorado.setName("rb_doctorado");
		      ae_rb_doctorado.setText("Doctorado");
		}
		return ae_rb_doctorado;
	}
	
	public JRadioButton getAe_rb_maestria() {
		if (ae_rb_maestria == null) {
			ae_rb_maestria = new JRadioButton();
		      ae_rb_maestria.setActionCommand("Maestría");
		      ae_rb_maestria.setName("rb_maestria");
		      ae_rb_maestria.setText("Maestría");
		      
		      
		}
		return ae_rb_maestria;
	}
	
	/**
	 * DNI DNI
	   LMI LIB. MIL.
	   PTN PART. NAC.
	   PST PASAPORTE
	 * @return
	 */
	public JComboBox getAe_cb_tp_doc() {
		if (ae_cb_tp_doc == null) {
			ae_cb_tp_doc = new JComboBox(new String[]{"DNI", "LMI", "PTN", "PST"});
		      ae_cb_tp_doc.setName("cb_tp_doc");
		      ae_cb_tp_doc.setRenderer(new DefaultListCellRenderer () {
				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					String op = (String) value;
					if (op.equals("DNI")) setText("DNI");
					if (op.equals("LMI")) setText("LIB. MIL.");
					if (op.equals("PTN")) setText("PART. NAC.");
					if (op.equals("PST")) setText("PASAPORTE");
					return comp;
				}
		      });
		}
		return ae_cb_tp_doc;
	}
	
	public JComboBox getAe_cb_ubigeo() {
		if (ae_cb_ubigeo == null) {
			ae_cb_ubigeo = new JComboBox();
			ae_cb_ubigeo.setName("cb_ubigeo");
			ae_cb_ubigeo.setRenderer(new DefaultListCellRenderer () {
				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value != null) {
						Ubigeo ub = (Ubigeo) value;
						setText(ub.getNombre());
					}
					return comp;
				}
			});
		}
		return ae_cb_ubigeo;
	}
	
	public JTable getAe_tb_grado_titulo() {
		if (ae_tb_grado_titulo == null) {
			ae_tb_grado_titulo = new JTable();
		      ae_tb_grado_titulo.setName("tb_grado_titulo");
		}
		return ae_tb_grado_titulo;
	}
	

	public JTable getAe_tb_idioma() {
		if (ae_tb_idioma == null) {
			ae_tb_idioma = new JTable();
			ae_tb_idioma.setName("tb_idioma");
		}
		return ae_tb_idioma;
	}
	
	   JPanel ae_pn_datos_personales;
	   public JPanel getAe_pn_datos_personales() {
		   if (ae_pn_datos_personales == null) {
			   ae_pn_datos_personales = new JPanel();
			      FormLayout formlayout1 = new FormLayout(
			    		  new ColumnSpec[] {
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.1)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.1)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.1)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.1)"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.1)"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.1)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE")
			    		  },
			    		  new RowSpec[] {
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:5DLU:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:GROW(0.5)"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:GROW(0.5)"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE")
			    		  });
			      CellConstraints cc = new CellConstraints();
			      ae_pn_datos_personales.setLayout(formlayout1);

		      JLabel jlabel1 = new JLabel();
		      jlabel1.setText("Periodo Academico");
		      jlabel1.setHorizontalAlignment(JLabel.CENTER);
		      ae_pn_datos_personales.add(jlabel1,cc.xy(2,2));

		      ae_pn_datos_personales.add(getAe_tf_pa(),new CellConstraints(2,4,1,1,CellConstraints.CENTER,CellConstraints.DEFAULT));

		      JLabel jlabel2 = new JLabel();
		      jlabel2.setText("Facultad");
		      jlabel2.setHorizontalAlignment(JLabel.CENTER);
		      ae_pn_datos_personales.add(jlabel2,cc.xy(4,2));
		      
		      ae_pn_datos_personales.add(getAe_cb_facu(),cc.xy(4,4));

		      ae_pn_datos_personales.add(getAe_pn_datos_postgrado(),cc.xywh(2,6,10,1));
		      ae_pn_datos_personales.add(getAe_pn_datos_comunes(),cc.xywh(2,8,10,1));
		      ae_pn_datos_personales.add(createPanel3(),new CellConstraints(2,10,10,1,CellConstraints.DEFAULT,CellConstraints.FILL));
		      ae_pn_datos_personales.add(createPanel5(),new CellConstraints(2,12,10,1,CellConstraints.DEFAULT,CellConstraints.FILL));
		      //ae_pn_datos_personales.add(createPanel7(),new CellConstraints(2,14,10,1,CellConstraints.CENTER,CellConstraints.DEFAULT));
		      
		      JLabel jlabel3 = new JLabel();
		      jlabel3.setText("Código Docente");
		      ae_pn_datos_personales.add(jlabel3,cc.xy(8,2));

		      ae_pn_datos_personales.add(getAe_tf_codigo_docente(),cc.xy(8,4));

		      JLabel jlabel4 = new JLabel();
		      jlabel4.setText("Codigo Alumno");
		      jlabel4.setHorizontalAlignment(JLabel.CENTER);
		      ae_pn_datos_personales.add(jlabel4,cc.xy(6,2));

		      ae_pn_datos_personales.add(getAe_tf_codigo_alumno(),cc.xy(6,4));

		      JLabel jlabel5 = new JLabel();
		      jlabel5.setText("Fecha de Incrip.");
		      ae_pn_datos_personales.add(jlabel5,cc.xy(10,2));

		      
		      ae_pn_datos_personales.add(getAe_tf_fecha_incrip(),cc.xy(10,4));

		      //PanelUtils.addFillComponents(ae_pn_datos_personales,new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15 });
		      PanelUtils.addFillComponents(ae_pn_datos_personales,new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12 },new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,13 });
		   }
	      return ae_pn_datos_personales;
	   }

	   public JFormattedTextField getAe_tf_fecha_incrip () {
		   if (ae_tf_fecha_incrip == null) {
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);
				ae_tf_fecha_incrip = new JFormattedTextField(df);
				ae_tf_fecha_incrip.setName("tf_fecha_incrip");
				ae_tf_fecha_incrip.setInputVerifier(PanelUtils.getInputVerifier());
		   }
		   return ae_tf_fecha_incrip;
	   }

	   public JLabel getAe_lb_estudio () {
		   if (ae_lb_estudio == null) {
			   ae_lb_estudio = new JLabel();
			      ae_lb_estudio.setName("lb_estudio");
			      ae_lb_estudio.setText("Maestrias:[Modificable]");
		   }
		   return ae_lb_estudio;
	   }
	   
	   
	   JPanel ae_pn_datos_postgrado;
	   public JPanel getAe_pn_datos_postgrado() {
		   if (ae_pn_datos_postgrado == null) {
			   ae_pn_datos_postgrado = new JPanel();
			      EtchedBorder etchedborder1 = new EtchedBorder(EtchedBorder.RAISED,null,null);
			      Border border1 = BorderFactory.createTitledBorder(etchedborder1,"Tipo de Especialidad",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,new Color(49,106,196));
			      ae_pn_datos_postgrado.setBorder(border1);
			      FormLayout formlayout1 = new FormLayout(
			    		  new ColumnSpec[] {
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.3)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.3)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.3)")
			    		  },
			    		  new RowSpec[] {
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:5DLU:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE")
			    		  });
			      CellConstraints cc = new CellConstraints();
			      ae_pn_datos_postgrado.setLayout(formlayout1);

		      getAe_bg_tp_maestria().add(getAe_rb_doctorado());
		      ae_pn_datos_postgrado.add(getAe_rb_doctorado(),cc.xy(1,1));

		      getAe_bg_tp_maestria().add(getAe_rb_maestria());
		      ae_pn_datos_postgrado.add(getAe_rb_maestria(),cc.xy(3,1));

		      getAe_bg_tp_maestria().add(getAe_rb_2espc());
		      ae_pn_datos_postgrado.add(getAe_rb_2espc(),cc.xy(5,1));
		      
		      JLabel jlabel1 = new JLabel();
		      jlabel1.setText("Observaciones");
		      ae_pn_datos_postgrado.add(jlabel1,cc.xy(5,3));

		      ae_pn_datos_postgrado.add(getAe_tf_observaciones(),cc.xy(5,5));
		      
		      JLabel jlabel2 = new JLabel();
		      jlabel2.setText("Mención en");
		      ae_pn_datos_postgrado.add(jlabel2,cc.xy(3,3));
		      
		      ae_pn_datos_postgrado.add(getAe_lb_estudio(),cc.xy(1,3));
		      
		      ae_pn_datos_postgrado.add(getAe_cb_mencion(),cc.xy(3,5));
		      
		      ae_pn_datos_postgrado.add(getAe_cb_estudio(),cc.xy(1,5));	      

		      PanelUtils.addFillComponents(ae_pn_datos_postgrado,new int[]{ 2,4 },new int[]{ 2,4 });
		   }
	      return ae_pn_datos_postgrado;
	   }

	   JPanel ae_pn_datos_comunes;
	   public JPanel getAe_pn_datos_comunes() {
		   if (ae_pn_datos_comunes == null) {
			   ae_pn_datos_comunes = new JPanel();
			      EtchedBorder etchedborder1 = new EtchedBorder(EtchedBorder.RAISED,null,null);
			      Border border1 = BorderFactory.createTitledBorder(etchedborder1,"Datos Personales",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION,null,new Color(49,106,196));
			      ae_pn_datos_comunes.setBorder(border1);
			      FormLayout formlayout1 = new FormLayout(
			    		  new ColumnSpec[] {
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.2)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.2)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.2)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.2)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.2)"),
			    				  new ColumnSpec("FILL:DEFAULT:NONE"),
			    				  new ColumnSpec("FILL:DEFAULT:GROW(0.2)")
			    		  },
			    		  new RowSpec[] {
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:5DLU:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("BOTTOM:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:5DLU:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE"),
			    				  new RowSpec("CENTER:5DLU:NONE"),
			    				  new RowSpec("CENTER:DEFAULT:NONE")
			    		  });
			      CellConstraints cc = new CellConstraints();
			      ae_pn_datos_comunes.setLayout(formlayout1);

		      JLabel jlabel1 = new JLabel();
		      jlabel1.setText("Ap. Paterno");
		      ae_pn_datos_comunes.add(jlabel1,cc.xy(1,1));

		      JLabel jlabel2 = new JLabel();
		      jlabel2.setText("Ap. Materno");
		      ae_pn_datos_comunes.add(jlabel2,cc.xy(3,1));

		      JLabel jlabel3 = new JLabel();
		      jlabel3.setText("Nombres");
		      ae_pn_datos_comunes.add(jlabel3,cc.xy(5,1));

		      ae_pn_datos_comunes.add(getAe_tf_ap_paterno(),cc.xy(1,3));

		      ae_pn_datos_comunes.add(getAe_tf_ap_materno(),cc.xy(3,3));

		      ae_pn_datos_comunes.add(getAe_tf_nombres(),cc.xy(5,3));

		      JLabel jlabel4 = new JLabel();
		      jlabel4.setText("Nacionalidad");
		      ae_pn_datos_comunes.add(jlabel4,cc.xy(1,5));

		      JLabel jlabel5 = new JLabel();
		      jlabel5.setText("Tipo Doc.");
		      ae_pn_datos_comunes.add(jlabel5,cc.xy(3,5));

		      JLabel jlabel6 = new JLabel();
		      jlabel6.setText("Nro. Doc.");
		      ae_pn_datos_comunes.add(jlabel6,cc.xy(5,5));

		      JLabel jlabel7 = new JLabel();
		      jlabel7.setText("<html><body>Fecha Nac.<br>(dd/mm/yyyy)</body></html>");
		      ae_pn_datos_comunes.add(jlabel7,cc.xy(7,5));

		      
		      ae_pn_datos_comunes.add(getAe_tf_nacionalidad(),cc.xy(1,7));	      
		      
		      ae_pn_datos_comunes.add(getAe_cb_tp_doc(),cc.xy(3,7));
		      
		      ae_pn_datos_comunes.add(getAe_tf_nro_doc(),cc.xy(5,7));
		      
		      ae_pn_datos_comunes.add(getAe_tf_fecha_nac(),cc.xy(7,7));
		      
		      JLabel jlabel8 = new JLabel();
		      jlabel8.setText("Dirección de Domicilio");
		      ae_pn_datos_comunes.add(jlabel8,cc.xywh(1,9,7,1));

		      ae_pn_datos_comunes.add(getAe_tf_direccion(),cc.xywh(1,11,7,1));
		      
		      ae_pn_datos_comunes.add(getAe_cb_ubigeo(),cc.xy(9,11));
		      
		      JLabel jlabel9 = new JLabel();
		      jlabel9.setText("Estado Civil");
		      ae_pn_datos_comunes.add(jlabel9,cc.xy(7,1));
		
		      ae_pn_datos_comunes.add(getAe_cb_estado_civil(),cc.xy(7,3));

		      JLabel jlabel10 = new JLabel();
		      jlabel10.setText("Telef.");
		      ae_pn_datos_comunes.add(jlabel10,cc.xy(9,1));
		      
		      
		      ae_pn_datos_comunes.add(getAe_tf_telefono(),cc.xy(9,3));
		      
		      ae_pn_datos_comunes.add(getAe_cb_genero(),cc.xy(9,7));

		      JLabel jlabel11 = new JLabel();
		      jlabel11.setText("Genero");
		      ae_pn_datos_comunes.add(jlabel11,cc.xy(9,5));
		      
		      JLabel jlabel12 = new JLabel();
		      jlabel12.setText("Distrito Domic.");
		      ae_pn_datos_comunes.add(jlabel12,cc.xy(9,9));
		      
		      JLabel jlabel13 = new JLabel();
		      jlabel13.setText("Celular");
		      ae_pn_datos_comunes.add(jlabel13,cc.xy(11,1));
		      

		      
		      ae_pn_datos_comunes.add(getAe_tf_cell(),cc.xy(11,3));
		      
		      JLabel jlabel14 = new JLabel();
		      jlabel14.setText("Correo");
		      ae_pn_datos_comunes.add(jlabel14,cc.xy(11,5));
		      
		      ae_pn_datos_comunes.add(getAe_tf_correo(),cc.xy(11,7));
		      
		      
		      ae_pn_datos_comunes.add(getAe_cb_ubigeo_nac(),cc.xy(11,11));
		      
		      JLabel jlabel15 = new JLabel();
		      jlabel15.setText("Ciudad Nac.");
		      ae_pn_datos_comunes.add(jlabel15,cc.xy(11,9));
		      
		      PanelUtils.addFillComponents(ae_pn_datos_comunes,new int[]{ 2,4,6,8,10 },new int[]{ 2,4,6,8,10 });

		   }
	      return ae_pn_datos_comunes;
	   }

	   public JPanel createPanel3() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout(
	    		  new ColumnSpec[] {
	    				new ColumnSpec("FILL:DEFAULT:NONE"),
	    				new ColumnSpec("FILL:DEFAULT:NONE"),
	    				new ColumnSpec("FILL:DEFAULT:GROW(1.0)")
	    		  },
	    		  new RowSpec[] {
	    				new RowSpec("CENTER:DEFAULT:NONE"),
	    				new RowSpec("CENTER:DEFAULT:NONE"),
	    				new RowSpec("FILL:DEFAULT:GROW(1.0)"),
	    				new RowSpec("CENTER:DEFAULT:NONE")
	    		  });
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);


	      JScrollPane jscrollpane1 = new JScrollPane();
	      jscrollpane1.setViewportView(getAe_tb_grado_titulo());
	      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      jpanel1.add(jscrollpane1,cc.xy(3,3));

	      jpanel1.add(createPanel4(),cc.xy(1,3));
	      JLabel jlabel1 = new JLabel();
	      jlabel1.setText("Grados Y Títulos");
	      jlabel1.setHorizontalAlignment(JLabel.CENTER);
	      jpanel1.add(jlabel1,cc.xywh(1,1,3,1));

	      PanelUtils.addFillComponents(jpanel1,new int[]{ 2,3 },new int[]{ 2,3,4 });
	      return jpanel1;
	   }

	   public JPanel createPanel4() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout(
	    		  new ColumnSpec[] {
	    				  new ColumnSpec("FILL:DEFAULT:NONE")
	    		  },
	    		  new RowSpec[] {
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE"),
	    				  new RowSpec("CENTER:DEFAULT:NONE")
	    		  });
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);


	      jpanel1.add(getAe_bt_add_grado_titulo(),cc.xy(1,1));


	      jpanel1.add(getAe_bt_del_grado_titulo(),cc.xy(1,3));

	      PanelUtils.addFillComponents(jpanel1,new int[0],new int[]{ 2 });
	      return jpanel1;
	   }

	   public JPanel createPanel5() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout(
	    		  "FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0)",
	    		  "CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,FILL:DEFAULT:GROW(1.0),CENTER:DEFAULT:NONE");
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);

	      
	      JScrollPane jscrollpane1 = new JScrollPane();
	      jscrollpane1.setViewportView(getAe_tb_idioma());
	      jscrollpane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	      jscrollpane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	      jpanel1.add(jscrollpane1,cc.xy(3,3));

	      jpanel1.add(createPanel6(),cc.xy(1,3));
	      JLabel jlabel1 = new JLabel();
	      jlabel1.setText("Idiomas");
	      jlabel1.setHorizontalAlignment(JLabel.CENTER);
	      jpanel1.add(jlabel1,cc.xywh(1,1,3,1));

	      PanelUtils.addFillComponents(jpanel1,new int[]{ 2,3 },new int[]{ 2,3,4 });
	      return jpanel1;
	   }

	   public JPanel createPanel6() {
	      JPanel jpanel1 = new JPanel();
	      FormLayout formlayout1 = new FormLayout(
	    		  "FILL:DEFAULT:NONE",
	    		  "CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE");
	      CellConstraints cc = new CellConstraints();
	      jpanel1.setLayout(formlayout1);


	      jpanel1.add(getAe_bt_add_idioma(),cc.xy(1,1));


	      jpanel1.add(getAe_bt_del_idioma(),cc.xy(1,3));

	      PanelUtils.addFillComponents(jpanel1,new int[0],new int[]{ 2 });
	      return jpanel1;
	   }

	   JPanel pn_botones_control;
	private JPanel hm_pn_historial_mov = null;
	   public JPanel getPn_botones_control() {
	      /*
	      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
	      CellConstraints cc = new CellConstraints();
	      ae_pn_datos_personales.setLayout(formlayout1);

	      ae_pn_datos_personales.add(getAe_bt_save(),cc.xy(1,1));

	      ae_pn_datos_personales.add(getAe_bt_plan_estudio(),cc.xy(3,1));

	      ae_pn_datos_personales.add(getAe_bt_reset(),cc.xy(5,1));

	      ae_pn_datos_personales.add(getAe_bt_cancel(),cc.xy(7,1));

	      PanelUtils.addFillComponents(ae_pn_datos_personales,new int[]{ 2,4,6 },new int[0]);*/
		   if (pn_botones_control == null) {
			   pn_botones_control = new JPanel();
			   pn_botones_control.add(getAe_bt_save(), null);
			   pn_botones_control.add(getAe_bt_reset(), null);
			   pn_botones_control.add(getAe_bt_imp_certif_final(), null);
			   pn_botones_control.add(getAe_bt_imp_certif(), null);
			   pn_botones_control.add(getAe_bt_cancel(),null);
		   }
		   return pn_botones_control;
	   }

	/**
	 * SL SOLTERO CS casado, VD viudo, DV divorciado, SP separado
	 * @return
	 */
	public JComboBox getAe_cb_estado_civil() {
		if (ae_cb_estado_civil == null) {
			ae_cb_estado_civil = new JComboBox(new String[]{"SL", "CS", "VD", "DV", "SP"});
			ae_cb_estado_civil.setName("cb_estado_civil");
			ae_cb_estado_civil.setRenderer(new DefaultListCellRenderer () {
				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					String op = (String) value;
					if (op.equals("SL")) setText("SOLTERO");
					if (op.equals("CS")) setText("CASADO");
					if (op.equals("VD")) setText("VIUDO");
					if (op.equals("DV")) setText("DIVORCIADO");
					if (op.equals("SP")) setText("SEPARADO");
					return comp;
				}
			});
		}
		return ae_cb_estado_civil;
	}

	public JTextField getAe_tf_telefono() {
		if (ae_tf_telefono == null) {
			ae_tf_telefono = new JTextField();
			ae_tf_telefono.setName("tf_telefono");
		}
		return ae_tf_telefono;
	}

	public JTextField getAe_tf_cell() {
		if (ae_tf_cell == null) {
			ae_tf_cell = new JTextField();
			ae_tf_cell.setName("tf_cell");
		}
		return ae_tf_cell;
	}

	public JTextField getAe_tf_correo() {
		if (ae_tf_correo == null) {
			ae_tf_correo = new JTextField();
			ae_tf_correo.setName("tf_correo");
		}
		return ae_tf_correo;
	}

	public JComboBox getAe_cb_ubigeo_nac() {
		if (ae_cb_ubigeo_nac == null) {
			ae_cb_ubigeo_nac = new JComboBox();
			ae_cb_ubigeo_nac.setName("cb_ubigeo_nac");
			ae_cb_ubigeo_nac.setRenderer(new DefaultListCellRenderer () {

				public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
					// TODO Auto-generated method stub
					Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value != null) {
						Ubigeo ub = (Ubigeo) value;
						setText(ub.getNombre());
					}
					return comp;
				}
			});
		}
		return ae_cb_ubigeo_nac;
	}

	public JRadioButton getMi_rb_5to_superior() {
		if (mi_rb_5to_superior == null) {
			mi_rb_5to_superior = new JRadioButton();
		      mi_rb_5to_superior.setActionCommand("5to SUPERIOR");
		      mi_rb_5to_superior.setName("rb_5to_superior");
		      mi_rb_5to_superior.setText("5to SUPERIOR");
		}
		return mi_rb_5to_superior;
	}
	

	public JRadioButton getMi_rb_docente_uni() {
		if (mi_rb_docente_uni == null) {
			mi_rb_docente_uni = new JRadioButton();
		      mi_rb_docente_uni.setActionCommand("DOCENTE UNI");
		      mi_rb_docente_uni.setName("rb_docente_uni");
		      mi_rb_docente_uni.setText("DOCENTE UNI");
		}
		return mi_rb_docente_uni;
	}
	

	public JRadioButton getMi_rb_examen() {
		if (mi_rb_examen == null) {
			mi_rb_examen = new JRadioButton();
		      mi_rb_examen.setActionCommand("EXAMEN");
		      mi_rb_examen.setName("rb_examen");
		      mi_rb_examen.setText("EXAMEN");
		}
		return mi_rb_examen;
	}
	

	public JRadioButton getMi_rb_exonerado() {
		if (mi_rb_exonerado == null) {
			mi_rb_exonerado = new JRadioButton();
		      mi_rb_exonerado.setActionCommand("EXONERADO");
		      mi_rb_exonerado.setName("rb_exonerado");
		      mi_rb_exonerado.setText("EXONERADO");
		      //mi_rb_exonerado.addItemListener(RadioButtonUtils.addTexComponentListener(getMi_tf_exonerado()));
		}
		return mi_rb_exonerado;
	}
	

	public JRadioButton getMi_rb_ingresado() {
		if (mi_rb_ingresado == null) {
			mi_rb_ingresado = new JRadioButton();
		      mi_rb_ingresado.setActionCommand("Ingresó");
		      mi_rb_ingresado.setName("rb_ingresado");
		      mi_rb_ingresado.setText("Ingresó");
		}
		return mi_rb_ingresado;
	}
	

	public JRadioButton getMi_rb_no_ingresado() {
		if (mi_rb_no_ingresado == null) {
			mi_rb_no_ingresado = new JRadioButton();
		      mi_rb_no_ingresado.setActionCommand("No Ingresó");
		      mi_rb_no_ingresado.setName("rb_no_ingresado");
		      mi_rb_no_ingresado.setText("No Ingresó");
		}
		return mi_rb_no_ingresado;
	}
	

	public JRadioButton getMi_rb_pre_maestria() {
		if (mi_rb_pre_maestria == null) {
			mi_rb_pre_maestria = new JRadioButton();
		      mi_rb_pre_maestria.setActionCommand("PRE-MAESTRÍA");
		      mi_rb_pre_maestria.setName("rb_pre_maestria");
		      mi_rb_pre_maestria.setText("PRE-MAESTRÍA");
		}
		return mi_rb_pre_maestria;
	}
	

	public JRadioButton getMi_rb_traslado() {
		if (mi_rb_traslado == null) {
			mi_rb_traslado = new JRadioButton();
		      mi_rb_traslado.setActionCommand("TRASLADO");
		      mi_rb_traslado.setName("rb_traslado");
		      mi_rb_traslado.setText("TRASLADO");
		}
		return mi_rb_traslado;
	}
	

	public JTextField getMi_tf_exonerado() {
		if (mi_tf_exonerado == null) {
			mi_tf_exonerado = new JTextField();
			mi_tf_exonerado.setName("tf_exonerado");
			mi_tf_exonerado.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return mi_tf_exonerado;
	}
	

	public JTextField getMi_tf_traslado() {
		if (mi_tf_traslado == null) {
			mi_tf_traslado = new JTextField();
			mi_tf_traslado.setName("tf_traslado");
			mi_tf_traslado.addKeyListener(PanelUtils.toUpperCaseKeyTyped());
		}
		return mi_tf_traslado;
	}

	public JButtonGroup getMi_bg_modalidad() {
		if (mi_bg_modalidad == null) {
			mi_bg_modalidad = new JButtonGroup();
		}
		return mi_bg_modalidad;
	}

	public JButtonGroup getMi_bg_ingreso() {
		if (mi_bg_ingreso == null) {
			mi_bg_ingreso = new JButtonGroup();
		}
		return mi_bg_ingreso;
	}

	public JComboBox getAe_cb_mencion() {
		if (ae_cb_mencion == null) {
			ae_cb_mencion = new JComboBox();
			 ae_cb_mencion.setName("cb_mencion");
		}
		return ae_cb_mencion;
	}

	public JLabel getPe_lb_fecha_sustentacion() {
		if (pe_lb_fecha_sustentacion == null) {
			pe_lb_fecha_sustentacion = new JLabel();
		      pe_lb_fecha_sustentacion.setName("lb_fecha_sustentacion");
		      pe_lb_fecha_sustentacion.setText("Fecha de Sustentación:");
		}
		return pe_lb_fecha_sustentacion;
	}
	
	public JLabel getPe_lb_periodo_termino() {
		if (pe_lb_periodo_termino == null) {
			pe_lb_periodo_termino = new JLabel();
		      pe_lb_periodo_termino.setName("lb_periodo_termino");
		      pe_lb_periodo_termino.setText("Periodo de Término:");
		}
		return pe_lb_periodo_termino;
	}

	public JLabel getPe_lb_tesis() {
		if (pe_lb_tesis == null) {
			pe_lb_tesis = new JLabel();
		      pe_lb_tesis.setName("lb_tesis");
		      pe_lb_tesis.setText("Tesis:");
		}
		return pe_lb_tesis;
	}
	
	public JFormattedTextField getPe_tf_fecha_sustentacion() {
		if (pe_tf_fecha_sustentacion == null) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			df.setLenient(false);
			pe_tf_fecha_sustentacion = new JFormattedTextField(df);
		      pe_tf_fecha_sustentacion.setColumns(10);
		      pe_tf_fecha_sustentacion.setName("tf_fecha_sustentacion");
		      pe_tf_fecha_sustentacion.setInputVerifier(PanelUtils.getInputVerifier());
		}
		return pe_tf_fecha_sustentacion;
	}
	

	public JTextField getPe_tf_periodo_termino() {
		if (pe_tf_periodo_termino == null) {
			pe_tf_periodo_termino = new JTextField();
		    pe_tf_periodo_termino.setColumns(10);
		    pe_tf_periodo_termino.setName("tf_periodo_termino");
		}
		return pe_tf_periodo_termino;
	}
	

	public JTextField getPe_tf_tesis01() {
		if (pe_tf_tesis01 == null) {
			pe_tf_tesis01 = new JTextField();
		    pe_tf_tesis01.setName("tf_tesis01");
		}
		return pe_tf_tesis01;
	}
	

	public JTextField getPe_tf_tesis02() {
		if (pe_tf_tesis02 == null) {
			pe_tf_tesis02 = new JTextField();
		    pe_tf_tesis02.setName("tf_tesis01");
		}
		return pe_tf_tesis02;
	}

	public JButton getAe_bt_imp_certif() {
		if (ae_bt_imp_certif == null) {
			ae_bt_imp_certif = new JButton();
			ae_bt_imp_certif.setText("Imp. Certif.");
		    ae_bt_imp_certif.setActionCommand("Imp. Certif.");
		    ae_bt_imp_certif.setName("bt_imp_certif");
		}
		return ae_bt_imp_certif;
	}

	public JComboBox getAe_cb_estudio() {
		if (ae_cb_estudio == null) {
			ae_cb_estudio = new JComboBox();
			ae_cb_estudio.setName("cb_estudio");
		}
		return ae_cb_estudio;
	}
	
	   public JPanel getHm_pn_exe() {
		   if (hm_pn_exe == null) {
			   hm_pn_exe = new JPanel();
			      hm_pn_exe.setName("pn_exe");
			      FormLayout formlayout1 = new FormLayout(
			    		  "FILL:DEFAULT:NONE,FILL:5DLU:NONE,FILL:DEFAULT:NONE,FILL:5DLU:NONE,FILL:DEFAULT:NONE",
			    		  "CENTER:DEFAULT:NONE");
			      CellConstraints cc = new CellConstraints();
			      hm_pn_exe.setLayout(formlayout1);


			      hm_pn_exe.add(getHm_bt_add(),cc.xy(1,1));


			      hm_pn_exe.add(getHm_bt_edit(),cc.xy(3,1));


			      hm_pn_exe.add(getHm_bt_del(),cc.xy(5,1));

			      PanelUtils.addFillComponents(hm_pn_exe,new int[]{ 2,4 },new int[0]);
		   }
	      return hm_pn_exe;
	   }
	   
	   

	   public JButton getHm_bt_add() {
		   if (hm_bt_add == null) {
			   hm_bt_add = new JButton();
			      hm_bt_add.setActionCommand("Agregar");
			      hm_bt_add.setName("bt_add");
			      hm_bt_add.setText("Agregar");
		   }
		return hm_bt_add;
	}

	public JButton getHm_bt_del() {
		if (hm_bt_del == null) {
			hm_bt_del = new JButton();
		      hm_bt_del.setActionCommand("Borrar");
		      hm_bt_del.setName("bt_del");
		      hm_bt_del.setText("Borrar");
		}
		return hm_bt_del;
	}

	public JButton getHm_bt_edit() {
		if (hm_bt_edit == null) {
			hm_bt_edit = new JButton();
		      hm_bt_edit.setActionCommand("Editar");
		      hm_bt_edit.setName("bt_edit");
		      hm_bt_edit.setText("Editar");
		}
		return hm_bt_edit;
	}

	public JButton getHm_bt_first() {
		if (hm_bt_first == null) {
			hm_bt_first = new JButton();
		      hm_bt_first.setActionCommand("<<");
		      hm_bt_first.setName("bt_first");
		      hm_bt_first.setText("<<");
		}
		return hm_bt_first;
	}

	public JButton getHm_bt_last() {
		if (hm_bt_last == null) {
			hm_bt_last = new JButton();
		      hm_bt_last.setActionCommand(">>");
		      hm_bt_last.setName("bt_last");
		      hm_bt_last.setText(">>");
		}
		return hm_bt_last;
	}

	public JButton getHm_bt_next() {
		if (hm_bt_next == null) {
			hm_bt_next = new JButton();
		      hm_bt_next.setActionCommand(">");
		      hm_bt_next.setName("bt_next");
		      hm_bt_next.setText(">");
		}
		return hm_bt_next;
	}

	public JButton getHm_bt_prev() {
		if (hm_bt_prev == null) {
			hm_bt_prev = new JButton();
		      hm_bt_prev.setActionCommand("<");
		      hm_bt_prev.setName("bt_prev");
		      hm_bt_prev.setText("<");
		}
		return hm_bt_prev;
	}

	public JPanel getHm_pn_nav() {
		   if (hm_pn_nav == null) {
			   hm_pn_nav = new JPanel();
			      hm_pn_nav.setName("pn_nav");
			      FormLayout formlayout1 = new FormLayout(
			    		  "FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE",
			    		  "CENTER:DEFAULT:NONE");
			      CellConstraints cc = new CellConstraints();
			      hm_pn_nav.setLayout(formlayout1);

			      hm_pn_nav.add(getHm_bt_first(),cc.xy(1,1));
			      hm_pn_nav.add(getHm_bt_prev(),cc.xy(2,1));
			      hm_pn_nav.add(getHm_bt_next(),cc.xy(3,1));
			      hm_pn_nav.add(getHm_bt_last(),cc.xy(4,1));

			      PanelUtils.addFillComponents(hm_pn_nav,new int[0],new int[0]);
		   }
	      return hm_pn_nav;
	   }
	
}
