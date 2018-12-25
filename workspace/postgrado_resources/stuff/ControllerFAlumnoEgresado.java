package visual.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;

import com.ibatis.dao.client.DaoException;
import dominio.negocio.Alumno;
import dominio.negocio.Facultad;
import dominio.negocio.TpPostgrado;
import dominio.negocio.Ubigeo;
import servicio.AppServicio;
import util.Mensaje;
import visual.app.tableModel.TableModelListGradoYTitutlo;
import visual.app.tableModel.TableModelListIdioma;
import visual.iface.ControllerFIface;
import visual.util.LBuscadorUbigeo;
import visual.util.PanelUtils;

public class ControllerFAlumnoEgresado implements ControllerFIface {
	private FAlumnoEgresado m_d_vista;
	private Alumno aeNew;
	private Alumno aeOld;
	private boolean updateOk = false;
	private boolean insertOk = false;
	private boolean modoEdit = false;
	
	
	public static void main (String args[]) {
		new ControllerFAlumnoEgresado();
	}
	
	public ControllerFAlumnoEgresado () {
		m_d_vista = new FAlumnoEgresado();
		initialize();
	}
	
	public ControllerFAlumnoEgresado (FAlumnoEgresado m_d_vista) {
		this.m_d_vista = m_d_vista;
		initialize();
	}

	public ControllerFAlumnoEgresado (FAlumnoEgresado m_d_vista, Alumno ae) {
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
			
			try {
				m_d_vista.getAe_tf_fecha_nac().commitEdit();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m_d_vista.getAe_tf_mencion_especialidad().setText(aeNew.getObservaciones());
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
			}else if (aeNew.getTpPostgrado().getCodigo().equals("2E")) {
				m_d_vista.getAe_rb_2espc().setSelected(true);
			}
			
			m_d_vista.getAe_tb_grado_titulo().setModel(new TableModelListGradoYTitutlo(aeNew.getGradosYTitulos()));
			System.out.println(aeNew.getGradosYTitulos());
			m_d_vista.getAe_tb_idioma().setModel(new TableModelListIdioma(aeNew.getIdiomas()));
			System.out.println(aeNew.getIdiomas());

		}
		else {
			m_d_vista.getAe_tb_grado_titulo().setModel(new TableModelListGradoYTitutlo(null));
			m_d_vista.getAe_tb_idioma().setModel(new TableModelListIdioma(null));
		}
	}

	public void initialize() {
		// TODO Auto-generated method stub
		aeNew = new Alumno();
		aeOld = new Alumno();
		aeNew.setPlanDeEstudios(new ArrayList());
		loadData();
		addListeners();
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
		loadData();
		addListeners();
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
				} catch (DaoException e) {
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
			Mensaje.error(m_d_vista, "Falta Seleccionar el distrito en donde vive", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_ap_materno().getText() == null && m_d_vista.getAe_tf_ap_materno().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Apellido Materno", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_ap_paterno().getText() == null && m_d_vista.getAe_tf_ap_paterno().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Apellido Paterno", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_nombres().getText() == null && m_d_vista.getAe_tf_nombres().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Nombre", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_codigo_alumno().getText() == null && m_d_vista.getAe_tf_codigo_alumno().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar Codigo del Alumno", "Error");
			return false;
		}
		
		if (m_d_vista.getAe_tf_codigo_docente().getText() == null && m_d_vista.getAe_tf_codigo_docente().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el codigo del docente", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_direccion().getText() == null && m_d_vista.getAe_tf_direccion().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar la direccion", "Error");
			return false;
		}
		if (m_d_vista.getAe_cb_estado_civil().getSelectedItem() == null) {
			Mensaje.error(m_d_vista, "Falta ingresar el estado civil", "Error");
			return false;
		}
		if (m_d_vista.getAe_cb_ubigeo_nac().getSelectedItem() == null) {
			Mensaje.error(m_d_vista, "Falta el lugar de Nac.", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_telefono().getText() == null && m_d_vista.getAe_tf_telefono().getText().trim().length() > 0) {
			Mensaje.error(m_d_vista, "Falta ingresar telefono", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_cell().getText() == null && m_d_vista.getAe_tf_cell().getText().trim().length() > 0) {
			Mensaje.error(m_d_vista, "Falta ingresar el celular", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_correo().getText() == null && m_d_vista.getAe_tf_correo().getText().trim().length() > 0) {
			Mensaje.error(m_d_vista, "Falta ingresar el correo", "Error");
			return false;
		}
	
		try {
			m_d_vista.getAe_tf_fecha_nac().commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m_d_vista.getAe_tf_fecha_nac().getValue() == null) {
			Mensaje.error(m_d_vista, "Falta Ingresar o Corregir la Fecha de Nacimiento", "Error");
			return false;
		}
		
		if (m_d_vista.getAe_tf_mencion_especialidad().getText() == null && m_d_vista.getAe_tf_mencion_especialidad().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar la mención de su especialidad", "Error");
			return false;	
		}
		if (m_d_vista.getAe_tf_nacionalidad().getText() == null && m_d_vista.getAe_tf_nacionalidad().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar la nacionalidad", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_nro_doc().getText() == null && m_d_vista.getAe_tf_nro_doc().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Nro de Documento", "Error");
			return false;
		}
		if (m_d_vista.getAe_tf_pa().getText() == null && m_d_vista.getAe_tf_pa().getText().trim().length() <= 0) {
			Mensaje.error(m_d_vista, "Falta Ingresar el Periodo Academico", "Error");
			return false;
		}
		if (!m_d_vista.getAe_rb_maestria().isSelected()) {
			if (!m_d_vista.getAe_rb_doctorado().isSelected()) {
				if (!m_d_vista.getAe_rb_2espc().isSelected()) {
					Mensaje.error(m_d_vista, "Falta Elegir el tipo de estudio de postgrado", "Error");
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m_d_vista.getAe_tf_fecha_nac().getValue() != null) {
			aeNew.setFechaNac((Date) m_d_vista.getAe_tf_fecha_nac().getValue());
		}
		aeNew.setObservaciones(m_d_vista.getAe_tf_mencion_especialidad().getText());
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
		
		PanelUtils.addActionKeyEnter(m_d_vista.getAe_cb_ubigeo(), new AbstractAction () {
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
		});
		
		PanelUtils.addActionKeyEnter(m_d_vista.getAe_cb_ubigeo_nac(), new AbstractAction () {
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
}