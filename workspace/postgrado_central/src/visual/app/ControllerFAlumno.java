package visual.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.ibatis.dao.client.DaoException;
import dominio.negocio.Alumno;
import dominio.negocio.EstudioPostgrado;
import dominio.negocio.Facultad;
import dominio.negocio.ImpresionCertificadoAlumno;
import dominio.negocio.Mencion;
import dominio.negocio.PlanEstudio;
import dominio.negocio.TpModalidadIngreso;
import dominio.negocio.TpPostgrado;
import dominio.negocio.Ubigeo;
import servicio.AppServicio;
import visual.app.tableModel.TableModelListGradoYTitutlo;
import visual.app.tableModel.TableModelListIdioma;
import visual.app.tableModel.TableModelListPlanEstudio;
import visual.iface.ControllerFIface;
import visual.util.ComboBoxUtils;
import visual.util.DReportPrint;
import visual.util.LBuscadorUbigeo;
import visual.util.Mensaje;
import visual.util.PanelUtils;
import visual.util.RadioButtonUtils;
import visual.util.WindowUtils;

public class ControllerFAlumno implements ControllerFIface {
	
    private static final String REPORTE_MAESTRIA_CERTIFICADO_FINAL_CON_MENCION = "reportes/CERTIFICADO_FINALIZACION_ESTUDIOS_ALUMNO_CON_MENCION_draft.jasper";
    private static final String REPORTE_MAESTRIA_CERTIFICADO_CON_MENCION = "reportes/CERTIFICADO_ESTUDIOS_ALUMNO_CON_MENCION_draft.jasper";
    private static final String REPORTE_MAESTRIA_CERTIFICADO_FINAL_SIN_MENCION = "reportes/CERTIFICADO_FINALIZACION_ESTUDIOS_ALUMNO_SIN_MENCION_draft.jasper";
    private static final String REPORTE_MAESTRIA_CERTIFICADO_SIN_MENCION = "reportes/CERTIFICADO_ESTUDIOS_ALUMNO_SIN_MENCION_draft.jasper";
        private static final String REPORTE_DOCTOR_CERTIFICADO_FINAL = "reportes/CERTIFICADO_FINALIZACION_ESTUDIOS_DOCTORADO_ALUMNO_CON_MENCION_draft.jasper";
        private static final String REPORTE_2E_CERTIFICADO_FINAL = "reportes/CERTIFICADO_FINALIZACION_ESTUDIOS_SEGUNDA_ESP_ALUMNO_draft.jasper";
	private FAlumno m_d_vista;
	private Alumno aeNew;
	private Alumno aeOld;
	private boolean updateOk = false;
	private boolean insertOk = false;
	private boolean modoEdit = false;
	
	public static void main (String args[]) {
		new ControllerFAlumno();
	}
	
	public ControllerFAlumno () {
		m_d_vista = new FAlumno();
		initialize();
	}
	
	public ControllerFAlumno (FAlumno m_d_vista) {
		this.m_d_vista = m_d_vista;
		initialize();
	}

	public ControllerFAlumno (FAlumno m_d_vista, Alumno ae) {
		this.m_d_vista = m_d_vista;
		initialize(ae);
	}
	
	public void loadData() {
		// TODO Auto-generated method stub
		if (modoEdit) {
			m_d_vista.getAe_cb_facu().setSelectedItem(aeNew.getFacultad());
			m_d_vista.getAe_cb_genero().setSelectedItem(aeNew.getTpSexo());
			m_d_vista.getAe_cb_tp_doc().setSelectedItem(aeNew.getTpDoc());
			//m_d_vista.getAe_cb_ubigeo().setSelectedItem(aeNew.getUbigeoDomicilio());
			m_d_vista.getAe_cb_ubigeo().removeAllItems();
			m_d_vista.getAe_cb_ubigeo().addItem(aeNew.getUbigeoDomicilio());
			
			m_d_vista.getAe_cb_estado_civil().setSelectedItem(aeNew.getTpEstadoCivil());
			//m_d_vista.getAe_cb_ubigeo_nac().setSelectedItem(aeNew.getUbigeoNac());
			m_d_vista.getAe_cb_ubigeo_nac().removeAllItems();
			m_d_vista.getAe_cb_ubigeo_nac().addItem(aeNew.getUbigeoNac());			
			
			m_d_vista.getAe_tf_ap_materno().setText(aeNew.getApellidoMaterno());
			m_d_vista.getAe_tf_ap_paterno().setText(aeNew.getApellidoPaterno());
			m_d_vista.getAe_tf_nombres().setText(aeNew.getNombres());
			m_d_vista.getAe_tf_codigo_alumno().setText(aeNew.getCodigoAlumno());
			m_d_vista.getAe_tf_codigo_docente().setText(aeNew.getCodigoDocente());
			m_d_vista.getAe_tf_direccion().setText(aeNew.getDireccion());
			
			m_d_vista.getAe_tf_fecha_nac().setValue(aeNew.getFechaNac());
			m_d_vista.getAe_tf_fecha_incrip().setValue(aeNew.getFechaInscripcion());
			try {
				m_d_vista.getAe_tf_fecha_nac().commitEdit();
				m_d_vista.getAe_tf_fecha_incrip().commitEdit();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			m_d_vista.getAe_tf_observaciones().setText(aeNew.getObservaciones());
			m_d_vista.getAe_tf_nacionalidad().setText(aeNew.getNacionalidad());
			m_d_vista.getAe_tf_nro_doc().setText(aeNew.getNroDoc());
			m_d_vista.getAe_tf_pa().setText(aeNew.getPeriodoAcademico());
			
			m_d_vista.getAe_tf_telefono().setText(aeNew.getTelefono());
			m_d_vista.getAe_tf_cell().setText(aeNew.getCell());
			m_d_vista.getAe_tf_correo().setText(aeNew.getEmail());
			
			// cargando titulos e idioma
			m_d_vista.getAe_tb_grado_titulo().setModel(new TableModelListGradoYTitutlo(aeNew.getGradosYTitulos()));
			m_d_vista.getAe_tb_idioma().setModel(new TableModelListIdioma(aeNew.getIdiomas()));
			
			if (aeNew.getTpPostgrado().getCodigo().equals("MA")) {
				m_d_vista.getAe_rb_maestria().setSelected(true);
			}
			else if (aeNew.getTpPostgrado().getCodigo().equals("DC")) {
				m_d_vista.getAe_rb_doctorado().setSelected(true);
			}
			else if (aeNew.getTpPostgrado().getCodigo().equals("2E")) {
				m_d_vista.getAe_rb_2espc().setSelected(true);
			}
			
			m_d_vista.getAe_tb_grado_titulo().setModel(new TableModelListGradoYTitutlo(aeNew.getGradosYTitulos()));
			//System.out.println(aeNew.getGradosYTitulos());
			m_d_vista.getAe_tb_idioma().setModel(new TableModelListIdioma(aeNew.getIdiomas()));
			//System.out.println(aeNew.getIdiomas());
			
			//cargando data del plan de estudios
			m_d_vista.getPe_tb_plan_estudio().setModel(new TableModelListPlanEstudio(aeNew.getPlanDeEstudios()));
			
			//cargar datos del alumno
			m_d_vista.getPe_tf_nombre_alumno_egresado().setText(aeNew.getApellidoPaterno() + " " + aeNew.getApellidoMaterno() + ", " + aeNew.getNombres());
			
			//modalidad de ingreso
			if (aeNew.isEsIngreso()) {
				m_d_vista.getMi_rb_ingresado().setSelected(true);
				//System.out.println(aeOld.getTpModalidadIngreso());
				if (aeNew.getTpModalidadIngreso() != null) {
					if (aeNew.getTpModalidadIngreso().getCodigo().equals("5T")) {
						m_d_vista.getMi_rb_5to_superior().setSelected(true);
					}
					if (aeNew.getTpModalidadIngreso().getCodigo().equals("PR")) {
						m_d_vista.getMi_rb_pre_maestria().setSelected(true);
					}
					if (aeNew.getTpModalidadIngreso().getCodigo().equals("DC")) {
						m_d_vista.getMi_rb_docente_uni().setSelected(true);
					}
					if (aeNew.getTpModalidadIngreso().getCodigo().equals("EX")) {
						m_d_vista.getMi_rb_examen().setSelected(true);
					}
					if (aeNew.getTpModalidadIngreso().getCodigo().equals("EO")) {
						m_d_vista.getMi_rb_exonerado().setSelected(true);
						m_d_vista.getMi_tf_exonerado().setText(aeNew.getDescripcionModalidadIngreso());
					}
					if (aeNew.getTpModalidadIngreso().getCodigo().equals("TR")) {
						m_d_vista.getMi_rb_traslado().setSelected(true);
						m_d_vista.getMi_tf_traslado().setText(aeNew.getDescripcionModalidadIngreso());
					}
				}
			}
			else {
				m_d_vista.getMi_rb_no_ingresado().setSelected(true);
				m_d_vista.getMi_bg_modalidad().setEnabled(false);
				m_d_vista.getMi_tf_exonerado().setEditable(false);
				m_d_vista.getMi_tf_traslado().setEditable(false);
			}
			//cargar primero los datos de facultad y tipo de carrera (o tipo de postgrado?)
			(new LoadEstudioPostgradoList()).doAction();
			m_d_vista.getAe_cb_estudio().setSelectedItem(AppServicio.getInstance().getEstudioPostgrado(aeNew.getEstudioPostgrado()));
			(new LoadMencionList()).actionPerformed(null);//cargar las menciones si hay estudio de postgrado seleccionado
			m_d_vista.getAe_cb_mencion().setSelectedItem(aeNew.getMencion());
			
			m_d_vista.getPe_tf_periodo_termino().setText(aeNew.getPeriodoEgreso());
			
			m_d_vista.getPe_tf_fecha_sustentacion().setValue(aeNew.getFechaSustentacion());
			
			try {
				m_d_vista.getPe_tf_fecha_sustentacion().commitEdit();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			m_d_vista.getPe_tf_tesis01().setText(aeNew.getTesis01());
			m_d_vista.getPe_tf_tesis02().setText(aeNew.getTesis02());
		}
		else {
			m_d_vista.getAe_tb_grado_titulo().setModel(new TableModelListGradoYTitutlo(null));
			m_d_vista.getAe_tb_idioma().setModel(new TableModelListIdioma(null));
			m_d_vista.getPe_tb_plan_estudio().setModel(new TableModelListPlanEstudio(aeNew.getPlanDeEstudios()));
			m_d_vista.getMi_bg_modalidad().setEnabled(false);
			m_d_vista.getMi_tf_exonerado().setEditable(false);
			m_d_vista.getMi_tf_traslado().setEditable(false);
			//m_d_vista.getPe_tb_plan_estudio().setModel(new TableModelListPlanEstudio(null));			
		}
	}

	public void initialize() {
		// TODO Auto-generated method stub
		aeNew = new Alumno();
		aeOld = new Alumno();
		aeNew.setPlanDeEstudios(new ArrayList());
		settingComponents();
		loadData();
		addListeners();
		WindowUtils.centerDialogInParent(m_d_vista);
		m_d_vista.setTitle(m_d_vista.getTitle() + " - " + "Ingreso Nuevo");
		m_d_vista.setVisible(true);
	}

	public void initialize(Alumno ae) {
		aeOld = ae;
		try {
			aeNew = (Alumno) aeOld.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			aeNew = new Alumno();
		}
		modoEdit = true;
		settingComponents();
		loadData();
		addListeners();
		WindowUtils.centerDialogInParent(m_d_vista);
		m_d_vista.setTitle(m_d_vista.getTitle() + " - " + "Actualizando");
		m_d_vista.setVisible(true);
	}

	public void executeData() {
		// TODO Auto-generated method stub
		if (checkData()) {
			recopileData();
			if (modoEdit) {
				//update
				try {
					AppServicio.getInstance().updateAlumno(aeNew, aeOld);
					updateOk = true;
					Mensaje.info(m_d_vista, "Actualizado Exitoso", "Exito");
					try {
						aeOld = (Alumno) aeNew.clone();
					} 
					catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						m_d_vista.dispose();
					}
				} 
				catch (DaoException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					Mensaje.error(m_d_vista, e.getMessage(),"Error");
					updateOk = false;
				}
			}
			else {
				//insert
				try {
					AppServicio.getInstance().insertAlumno(aeNew);
					insertOk = true;
					Mensaje.info(m_d_vista, "Ingreso Exitoso", "Exito");
					m_d_vista.dispose();
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					Mensaje.error(m_d_vista, e.getMessage(), "Error");
					insertOk = false;
				}
			}
		}
	}

	public boolean checkData() {
		// TODO Auto-generated method stub
		if (m_d_vista.getAe_cb_facu().getSelectedItem() == null) {
			Mensaje.error(m_d_vista, "Falta Seleccionar la Facultad", "Error");
			return false;
		}
		if (m_d_vista.getAe_cb_ubigeo().getSelectedItem() == null) {
			//Mensaje.error(m_d_vista, "Falta Seleccionar el distrito en donde vive", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_ap_materno().getText() == null || m_d_vista.getAe_tf_ap_materno().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar el Apellido Materno", "Error");
			//return true;
		}
		if (m_d_vista.getAe_tf_ap_paterno().getText() == null || m_d_vista.getAe_tf_ap_paterno().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Apellido Paterno", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_nombres().getText() == null || m_d_vista.getAe_tf_nombres().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Nombre", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_codigo_alumno().getText() == null || m_d_vista.getAe_tf_codigo_alumno().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar Codigo del Alumno", "Error");
			//return false;
		}
		
		if (m_d_vista.getAe_tf_codigo_docente().getText() == null || m_d_vista.getAe_tf_codigo_docente().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar el codigo del docente", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_direccion().getText() == null || m_d_vista.getAe_tf_direccion().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar la direccion", "Error");
			//return false;
		}
		if (m_d_vista.getAe_cb_estado_civil().getSelectedItem() == null) {
			Mensaje.error(m_d_vista, "Falta ingresar el estado civil", "Error");
			return false;
		}
		if (m_d_vista.getAe_cb_ubigeo_nac().getSelectedItem() == null) {
			//Mensaje.error(m_d_vista, "Falta el lugar de Nac.", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_telefono().getText() == null || m_d_vista.getAe_tf_telefono().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta ingresar telefono", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_cell().getText() == null || m_d_vista.getAe_tf_cell().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta ingresar el celular", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_correo().getText() == null || m_d_vista.getAe_tf_correo().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta ingresar el correo", "Error");
			//return false;
		}
	
		try {
			m_d_vista.getAe_tf_fecha_nac().commitEdit();
			m_d_vista.getAe_tf_fecha_incrip().commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (m_d_vista.getAe_tf_fecha_nac().getValue() == null) {
			//Mensaje.error(m_d_vista, "Falta Ingresar o Corregir la Fecha de Nacimiento", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_fecha_incrip() == null) {
			//Mensaje.error(m_d_vista, "Falta Ingresar o Corregir la Fecha de Inscripcion", "Error");
			//return false;
		}
		
		if (m_d_vista.getAe_tf_observaciones().getText() == null || m_d_vista.getAe_tf_observaciones().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar la mención de su especialidad", "Error");
			//return true;	
		}
		if (m_d_vista.getAe_tf_nacionalidad().getText() == null || m_d_vista.getAe_tf_nacionalidad().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar la nacionalidad", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_nro_doc().getText() == null || m_d_vista.getAe_tf_nro_doc().getText().trim().length() <= 0) {
			//Mensaje.error(m_d_vista, "Falta Ingresar el Nro de Documento", "Error");
			//return false;
		}
		if (m_d_vista.getAe_tf_pa().getText() == null || m_d_vista.getAe_tf_pa().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Periodo Academico", "Error");
			return false;
		}
		if (!m_d_vista.getAe_rb_maestria().isSelected()) {
			if (!m_d_vista.getAe_rb_doctorado().isSelected()) {
				if (!m_d_vista.getAe_rb_2espc().isSelected()) {
					Mensaje.error(m_d_vista, "Falta Elegir el tipo de estudio de tpPostgrado", "Error");
					return false;
				}
			}
		}
		return true;
	}

	public void recopileData() {
		// TODO Auto-generated method stub
		if (m_d_vista.getAe_cb_facu().getSelectedItem() != null) {
			aeNew.setFacultad((Facultad) m_d_vista.getAe_cb_facu().getSelectedItem());
		}
		aeNew.setTpSexo((String) m_d_vista.getAe_cb_genero().getSelectedItem());
		aeNew.setTpDoc((String) m_d_vista.getAe_cb_tp_doc().getSelectedItem());
		
		if (m_d_vista.getAe_cb_ubigeo().getSelectedItem() != null) {
			aeNew.setUbigeoDomicilio((Ubigeo) m_d_vista.getAe_cb_ubigeo().getSelectedItem());	
		}
		aeNew.setApellidoMaterno(m_d_vista.getAe_tf_ap_materno().getText());
		aeNew.setApellidoPaterno(m_d_vista.getAe_tf_ap_paterno().getText());
		aeNew.setNombres(m_d_vista.getAe_tf_nombres().getText());
		aeNew.setCodigoAlumno(m_d_vista.getAe_tf_codigo_alumno().getText());
		aeNew.setCodigoDocente(m_d_vista.getAe_tf_codigo_docente().getText());
		aeNew.setDireccion(m_d_vista.getAe_tf_direccion().getText());
		
		try {
			m_d_vista.getAe_tf_fecha_nac().commitEdit();
			m_d_vista.getAe_tf_fecha_incrip().commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		if (m_d_vista.getAe_tf_fecha_nac().getValue() != null) {
			aeNew.setFechaNac((Date) m_d_vista.getAe_tf_fecha_nac().getValue());
		}
		if (m_d_vista.getAe_tf_fecha_nac().getValue() != null) {
			aeNew.setFechaInscripcion((Date) m_d_vista.getAe_tf_fecha_incrip().getValue());
		}
		aeNew.setObservaciones(m_d_vista.getAe_tf_observaciones().getText());
		aeNew.setNacionalidad(m_d_vista.getAe_tf_nacionalidad().getText());
		aeNew.setNroDoc(m_d_vista.getAe_tf_nro_doc().getText());
		aeNew.setPeriodoAcademico(m_d_vista.getAe_tf_pa().getText());
		aeNew.setGradosYTitulos( ((TableModelListGradoYTitutlo) m_d_vista.getAe_tb_grado_titulo().getModel()).getList());
		aeNew.setIdiomas( ((TableModelListIdioma) m_d_vista.getAe_tb_idioma().getModel()).getList() );
		
		if (m_d_vista.getAe_rb_maestria().isSelected()) {
			TpPostgrado tp = AppServicio.getInstance().getTpPostgrado("MA");
			aeNew.setTpPostgrado(tp);
		}
		if (m_d_vista.getAe_rb_doctorado().isSelected()) {
			TpPostgrado tp = AppServicio.getInstance().getTpPostgrado("DC");
			aeNew.setTpPostgrado(tp);
		}
		if (m_d_vista.getAe_rb_2espc().isSelected()) {
			TpPostgrado tp = AppServicio.getInstance().getTpPostgrado("2E");
			aeNew.setTpPostgrado(tp);
		}

		aeNew.setTpEstadoCivil((String) m_d_vista.getAe_cb_estado_civil().getSelectedItem());
		aeNew.setUbigeoNac((Ubigeo) m_d_vista.getAe_cb_ubigeo_nac().getSelectedItem());
		aeNew.setTelefono(m_d_vista.getAe_tf_telefono().getText());
		aeNew.setCell(m_d_vista.getAe_tf_cell().getText());
		aeNew.setEmail(m_d_vista.getAe_tf_correo().getText());
		
		if (m_d_vista.getMi_bg_ingreso().getSelectedByValue() != null) {
			aeNew.setEsIngreso(((Boolean) m_d_vista.getMi_bg_ingreso().getSelectedByValue()).booleanValue());
			aeNew.setTpModalidadIngreso(((TpModalidadIngreso)m_d_vista.getMi_bg_modalidad().getSelectedByValue()));
			String strTemp = (m_d_vista.getMi_tf_traslado().getText().equals("")?(m_d_vista.getMi_tf_exonerado().getText().equals("")?null:m_d_vista.getMi_tf_exonerado().getText()):m_d_vista.getMi_tf_traslado().getText());
			aeNew.setDescripcionModalidadIngreso(strTemp);			
		}
		if (!aeNew.isEsIngreso()) {
			if (aeNew.getPlanDeEstudios() != null) {
				aeNew.getPlanDeEstudios().clear();
			}
			aeNew.setTpModalidadIngreso(null);
			aeNew.setDescripcionModalidadIngreso(null);
		}
		
		
		if (m_d_vista.getAe_cb_estudio().getSelectedItem() != null) {
			aeNew.setEstudioPostgrado(((EstudioPostgrado)m_d_vista.getAe_cb_estudio().getSelectedItem()).getId());
		}
		else {
			aeNew.setEstudioPostgrado(0);
		}

		aeNew.setMencion((Mencion)m_d_vista.getAe_cb_mencion().getSelectedItem());

		
		aeNew.setPeriodoEgreso(m_d_vista.getPe_tf_periodo_termino().getText());
		aeNew.setTesis01(m_d_vista.getPe_tf_tesis01().getText());
		aeNew.setTesis02(m_d_vista.getPe_tf_tesis02().getText());
		
		try {
			m_d_vista.getPe_tf_fecha_sustentacion().commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		aeNew.setFechaSustentacion((Date) m_d_vista.getPe_tf_fecha_sustentacion().getValue());
		
		//aeNew.setGradosYTitulos(((TableModelListGradoYTitutlo) m_d_vista.getAe_tb_grado_titulo().getModel()).getList());
		//aeNew.setIdiomas(((TableModelListIdioma)m_d_vista.getAe_tb_idioma().getModel()).getList());
	}

	public void undoData() {
		// TODO Auto-generated method stub
		try {
			aeNew = (Alumno) aeOld.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			aeNew = new Alumno();
			//e.printStackTrace();
		}
		loadData();
	}

	public void addListeners() {
		// TODO Auto-generated method stub
		m_d_vista.getAe_bt_add_grado_titulo().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object o = (new FGradoYTitulo(m_d_vista)).getObject();
				if (o != null) {
					((TableModelListGradoYTitutlo) m_d_vista.getAe_tb_grado_titulo().getModel()).addObject(o);
				}
			}
		});
		
		m_d_vista.getAe_bt_del_grado_titulo().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = m_d_vista.getAe_tb_grado_titulo().getSelectedRow();
				((TableModelListGradoYTitutlo) m_d_vista.getAe_tb_grado_titulo().getModel()).removeRow(row);
			}
		});
		
		m_d_vista.getAe_bt_add_idioma().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object o = (new FIdioma(m_d_vista)).getObject();
				if (o != null) {
					((TableModelListIdioma) m_d_vista.getAe_tb_idioma().getModel()).addObject(o);
				}
			}
			
		});
		
		m_d_vista.getAe_bt_del_idioma().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = m_d_vista.getAe_tb_idioma().getSelectedRow();
				((TableModelListIdioma)m_d_vista.getAe_tb_idioma().getModel()).removeRow(row);
			}
		});
		
		m_d_vista.getAe_bt_save().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				executeData();
			}
		});
		
		m_d_vista.getAe_bt_reset().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				undoData();
			}
		});
		
		m_d_vista.getAe_bt_cancel().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				m_d_vista.dispose();
			}
		});
		
		// Carga listado de plan de estudios
		m_d_vista.getAe_bt_plan_estudio().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ControllerLPlanEstudio(new LPlanEstudio(m_d_vista,true),aeNew);
				
			}
		});		
		
		
		final Action onCbUbigeoDom = new AbstractAction () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Mensaje.info(m_d_vista, "busqueda de ubigeo", "info");
				Ubigeo ub;
				ub = (Ubigeo) (new LBuscadorUbigeo(m_d_vista)).getSelectedRow();
				if (ub != null) {
					m_d_vista.getAe_cb_ubigeo().removeAllItems();
					m_d_vista.getAe_cb_ubigeo().addItem(ub);
				}
			}
		};
		
		PanelUtils.addActionKeyEnter(m_d_vista.getAe_cb_ubigeo(), onCbUbigeoDom);
		
		final Action onCbUbigeoNac =  new AbstractAction () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Mensaje.info(m_d_vista, "busqueda de ubigeo", "info");
				Ubigeo ub;
				ub = (Ubigeo) (new LBuscadorUbigeo(m_d_vista)).getSelectedRow();
				if (ub != null) {
					m_d_vista.getAe_cb_ubigeo_nac().removeAllItems();
					m_d_vista.getAe_cb_ubigeo_nac().addItem(ub);
				}
			}
		};
		
		PanelUtils.addActionKeyEnter(m_d_vista.getAe_cb_ubigeo_nac(), onCbUbigeoNac);
		
		// listener para el boton agregar del plan de estudios
		m_d_vista.getPe_bt_curso_nuevo().addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				((TableModelListPlanEstudio)m_d_vista.getPe_tb_plan_estudio().getModel()).agregar(new PlanEstudio());
			}
		});

		// listener para el boton eliminar del plan de estudios 
		m_d_vista.getPe_bt_curso_borrar().addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				int row = m_d_vista.getPe_tb_plan_estudio().getSelectedRow();				
				((TableModelListPlanEstudio)m_d_vista.getPe_tb_plan_estudio().getModel()).remover(row);
			}
		});
		
		m_d_vista.getMi_bg_ingreso().addItemListener(new ItemListener () {
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				JRadioButton rbEvent = (JRadioButton) e.getItem();
				if (rbEvent == m_d_vista.getMi_rb_ingresado()) {
					m_d_vista.getMi_bg_modalidad().setEnabled(true);
				}
				else if (rbEvent == m_d_vista.getMi_rb_no_ingresado()) {
					m_d_vista.getMi_bg_modalidad().setSelected(m_d_vista.getMi_bg_modalidad().getSelected(), false);
					m_d_vista.getMi_bg_modalidad().setEnabled(false);
					m_d_vista.getMi_tf_exonerado().setText("");
					m_d_vista.getMi_tf_traslado().setText("");
					m_d_vista.getMi_tf_exonerado().setEditable(false);
					m_d_vista.getMi_tf_traslado().setEditable(false);
				}
			}
		});
		
		m_d_vista.getMi_bg_modalidad().addItemListener(RadioButtonUtils.addTexComponentListener(m_d_vista.getMi_rb_exonerado(), m_d_vista.getMi_tf_exonerado()));
		m_d_vista.getMi_bg_modalidad().addItemListener(RadioButtonUtils.addTexComponentListener(m_d_vista.getMi_rb_traslado(), m_d_vista.getMi_tf_traslado()));
		
		m_d_vista.getTp_alumno_egresado().addChangeListener(new ChangeListener () {
			public void stateChanged(ChangeEvent ce) {
				// TODO Auto-generated method stub
				JTabbedPane tpe = (JTabbedPane) ce.getSource();
				boolean ingresado = false;
				Boolean objIngresado = (Boolean)m_d_vista.getMi_bg_ingreso().getSelectedByValue();
				if (objIngresado != null) {
					ingresado = objIngresado.booleanValue();
				}
				if (tpe != null && tpe.getSelectedIndex() == 2 && !ingresado) {
					Mensaje.error(m_d_vista, "Debe de elegir al alumno como ingresado para agregar sus cursos respectivos:"+objIngresado, "Error");
					tpe.setSelectedIndex(1);
				}
			}
		});
		
		m_d_vista.getAe_cb_ubigeo().addMouseListener(new MouseAdapter () {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					onCbUbigeoDom.actionPerformed(null);
				}
			}
		});
		
		m_d_vista.getAe_cb_ubigeo_nac().addMouseListener(new MouseAdapter () {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					onCbUbigeoNac.actionPerformed(null);
				}
			}
		});
		
		LoadEstudioPostgradoList onLoadEstudioPostgrado = new LoadEstudioPostgradoList();
		m_d_vista.getAe_cb_facu().addActionListener(onLoadEstudioPostgrado);
		m_d_vista.getAe_bg_tp_maestria().addItemListener(onLoadEstudioPostgrado);
		LoadMencionList onLoadMencion = new LoadMencionList();
		m_d_vista.getAe_cb_estudio().addActionListener(onLoadMencion);
		
		m_d_vista.getAe_bt_imp_certif_final().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				if (modoEdit && aeNew != null) {
					Alumno aImp = AppServicio.getInstance().getAlumno(aeNew.getId());
					EstudioPostgrado ep = AppServicio.getInstance().getEstudioPostgrado(aImp.getEstudioPostgrado());
					ControllerFPromptImpresionCertificadoAlumno impPrmpView = new ControllerFPromptImpresionCertificadoAlumno(m_d_vista, aImp.getId());
					Map params = new HashMap ();
					params.put("alumno", aImp);
					params.put("estudio", ep);
					if (impPrmpView.isInsertOk()) {
						ImpresionCertificadoAlumno impCod = impPrmpView.getImp();
						params.put("nro_impr", impCod.getCodigo());
					}
					else {
						return;
					}
                    if(aImp.getTpPostgrado().getCodigo().equals("MA"))
                    {
					if (aImp.getMencion() != null) {
						try {
							new DReportPrint(m_d_vista, true, REPORTE_MAESTRIA_CERTIFICADO_FINAL_CON_MENCION, aImp.getPlanDeEstudios(), params).setVisible(true);
						} catch (RuntimeException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							Mensaje.error(m_d_vista, e.toString()+" \n "+ e.getLocalizedMessage(), "Error");
						}						
					}
					else {
						try {
							new DReportPrint(m_d_vista, true, REPORTE_MAESTRIA_CERTIFICADO_FINAL_SIN_MENCION, aImp.getPlanDeEstudios(), params).setVisible(true);
						} catch (RuntimeException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							Mensaje.error(m_d_vista, e.toString()+" \n "+ e.getLocalizedMessage(), "Error");
						}
					}
                    } else
                    if(aImp.getTpPostgrado().getCodigo().equals("DC"))
                        try
                        {
                            (new DReportPrint(m_d_vista, true, "reportes/CERTIFICADO_FINALIZACION_ESTUDIOS_DOCTORADO_ALUMNO_CON_MENCION_draft.jasper", aImp.getPlanDeEstudios(), params)).setVisible(true);
                        }
                        catch(RuntimeException e)
                        {
                            Mensaje.error(m_d_vista, (new StringBuilder(String.valueOf(e.toString()))).append(" \n ").append(e.getLocalizedMessage()).toString(), "Error");
                        }
                    else
                    if(aImp.getTpPostgrado().getCodigo().equals("2E"))
                        try
                        {
                            (new DReportPrint(m_d_vista, true, "reportes/CERTIFICADO_FINALIZACION_ESTUDIOS_SEGUNDA_ESP_ALUMNO_draft.jasper", aImp.getPlanDeEstudios(), params)).setVisible(true);
                        }
                        catch(RuntimeException e)
                        {
                            Mensaje.error(m_d_vista, (new StringBuilder(String.valueOf(e.toString()))).append(" \n ").append(e.getLocalizedMessage()).toString(), "Error");
                        }

				}
			}
		});
		
		m_d_vista.getAe_bt_imp_certif().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				if (modoEdit && aeNew != null) {
					Alumno aImp = AppServicio.getInstance().getAlumno(aeNew.getId());
					EstudioPostgrado ep = AppServicio.getInstance().getEstudioPostgrado(aImp.getEstudioPostgrado());
					ControllerFPromptImpresionCertificadoAlumno impPrmpView = new ControllerFPromptImpresionCertificadoAlumno(m_d_vista, aImp.getId());
					Map params = new HashMap ();
					params.put("alumno", aImp);
					params.put("estudio", ep);
					if (impPrmpView.isInsertOk()) {
						ImpresionCertificadoAlumno impCod = impPrmpView.getImp();
						params.put("nro_impr", impCod.getCodigo());
					}
					else {
						return;
					}
					if (aImp.getMencion() != null) {
						try {
							new DReportPrint(m_d_vista, true, REPORTE_MAESTRIA_CERTIFICADO_CON_MENCION, aImp.getPlanDeEstudios(), params).setVisible(true);
						} catch (RuntimeException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							Mensaje.error(m_d_vista, e.toString()+" \n "+ e.getLocalizedMessage(), "Error");
						}
					}
					else {
						try {
							new DReportPrint(m_d_vista, true, REPORTE_MAESTRIA_CERTIFICADO_SIN_MENCION, aImp.getPlanDeEstudios(), params).setVisible(true);
						} catch (RuntimeException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							Mensaje.error(m_d_vista, e.toString()+" \n "+ e.getLocalizedMessage(), "Error");
						}
					}
				}
			}
		});
	}

	public boolean isInsertOk() {
		// TODO Auto-generated method stub
		return insertOk;
	}

	public boolean isUpdateOk() {
		// TODO Auto-generated method stub
		return updateOk;
	}

	public void settingComponents() {
		// TODO Auto-generated method stub
		
		m_d_vista.getAe_bg_tp_maestria().add(m_d_vista.getAe_rb_maestria(), AppServicio.getInstance().getTpPostgrado("MA"));
		m_d_vista.getAe_bg_tp_maestria().add(m_d_vista.getAe_rb_doctorado(), AppServicio.getInstance().getTpPostgrado("DC"));
		m_d_vista.getAe_bg_tp_maestria().add(m_d_vista.getAe_rb_2espc(), AppServicio.getInstance().getTpPostgrado("2E"));
		
		m_d_vista.getMi_bg_ingreso().add(m_d_vista.getMi_rb_ingresado(), new Boolean(true));
		m_d_vista.getMi_bg_ingreso().add(m_d_vista.getMi_rb_no_ingresado(), new Boolean(false));
		
		m_d_vista.getMi_bg_modalidad().add(m_d_vista.getMi_rb_5to_superior(), AppServicio.getInstance().getModalidadIngreso("5T"));
		m_d_vista.getMi_bg_modalidad().add(m_d_vista.getMi_rb_docente_uni(),AppServicio.getInstance().getModalidadIngreso("DC"));
		m_d_vista.getMi_bg_modalidad().add(m_d_vista.getMi_rb_examen(),AppServicio.getInstance().getModalidadIngreso("EX"));
		m_d_vista.getMi_bg_modalidad().add(m_d_vista.getMi_rb_exonerado(),AppServicio.getInstance().getModalidadIngreso("EO"));
		m_d_vista.getMi_bg_modalidad().add(m_d_vista.getMi_rb_pre_maestria(),AppServicio.getInstance().getModalidadIngreso("PR"));
		m_d_vista.getMi_bg_modalidad().add(m_d_vista.getMi_rb_traslado(), AppServicio.getInstance().getModalidadIngreso("TR"));
		
		m_d_vista.getAe_cb_estudio().setRenderer(ComboBoxUtils.getTextRenderer("especialidad"));
		m_d_vista.getAe_cb_mencion().setRenderer(ComboBoxUtils.getTextRenderer("nombre"));
		ComboBoxUtils.setKeyStrokeToNullComboBoxRow(m_d_vista.getAe_cb_estudio());
		ComboBoxUtils.setKeyStrokeToNullComboBoxRow(m_d_vista.getAe_cb_mencion());
		ComboBoxUtils.setKeyStrokeToNullComboBoxRow(m_d_vista.getAe_cb_facu());
	}
	
	class LoadEstudioPostgradoList implements ActionListener, ItemListener {
		
		void doAction () {
			Map params = new HashMap();
			Facultad fc = (Facultad) m_d_vista.getAe_cb_facu().getSelectedItem();
			TpPostgrado tp = (TpPostgrado) m_d_vista.getAe_bg_tp_maestria().getSelectedByValue();
			m_d_vista.getAe_cb_estudio().removeAllItems();
			m_d_vista.getAe_cb_mencion().removeAllItems();
			if (fc != null && tp != null && (tp.getCodigo().equals("MA") || tp.getCodigo().equals("2E") || tp.getCodigo().equals("DC"))) {
				ComboBoxUtils.addItems(AppServicio.getInstance().getEstudioPostgradoList(fc, tp), m_d_vista.getAe_cb_estudio());
				m_d_vista.getAe_lb_estudio().setText(tp.getNombre()+":");
			}
//			else if (tp != null && tp.getCodigo().equals("DC")) {
//				m_d_vista.getAe_lb_estudio().setText(tp.getNombre()+":");
//				ComboBoxUtils.addItems(AppServicio.getInstance().getEstudioPostgradoList(null, tp), m_d_vista.getAe_cb_estudio());
//			}
		}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			doAction();
		}

		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			doAction();
		}
	}
	
	class LoadMencionList implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			Map params = new HashMap();
			EstudioPostgrado ep = (EstudioPostgrado) m_d_vista.getAe_cb_estudio().getSelectedItem();
			if (ep != null) {
				params.put("idEstudioPostgrado", ep.getId()+"");
				m_d_vista.getAe_cb_mencion().removeAllItems();
				ComboBoxUtils.addItems(AppServicio.getInstance().getMencionList(params), m_d_vista.getAe_cb_mencion());
			}
		}
		
	}
}