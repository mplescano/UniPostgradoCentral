/**
 * 
 */
package visual.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dominio.negocio.Alumno;
import dominio.negocio.PlanEstudio;
import visual.app.tableModel.TableModelListPlanEstudio;
import visual.iface.ControllerLIface;
import visual.util.WindowUtils;

/**
 * Constrolador del formulario-listado de plan de estudios
 * @author Jaime
 *
 */
public class ControllerLPlanEstudio implements ControllerLIface {
	/** Formulario listado del plan de estudios */
	private LPlanEstudio lPlanEstudio = null;
	/** List de plan de estudios*/
	private List lPE = null;
	private String nombresAlumnoEgresado;
	/**
	 * Constructor, guarda el formulario-listado de plan de estudios
	 * @param lPlanEstudio
	 */
	public ControllerLPlanEstudio(LPlanEstudio lPlanEstudio, Alumno ae) {
		super();
		this.lPlanEstudio = lPlanEstudio;
//		if (this.lPlanEstudio == null)
//			this.lPlanEstudio = new LPlanEstudio();
		if (ae!=null)
			this.lPE = ae.getPlanDeEstudios();
		this.nombresAlumnoEgresado = ae.getApellidoPaterno() + " " + ae.getApellidoMaterno() + ", " + ae.getNombres();
		initialize();
		// TODO Auto-generated constructor stub
	}

	/** Carga el plan de estudios del egresado
	 * @see visual.iface.ControllerLIface#loadData()
	 */
	public void loadData() {
		// TODO Auto-generated method stub
		lPlanEstudio.getJTablePlanEstudio().setModel(new TableModelListPlanEstudio(lPE));
	}

	/* (non-Javadoc)
	 * @see visual.iface.ControllerLIface#initialize()
	 */
	public void initialize() {
		// TODO Auto-generated method stub
		loadData();
		addListeners();
		lPlanEstudio.getJTextFieldNombresAlumnoEgresado().setText(nombresAlumnoEgresado);
		WindowUtils.centerDialogInParent(this.lPlanEstudio);
		lPlanEstudio.setVisible(true);
	}
	
	/**Carga listeners*/
	public void addListeners() {
		lPlanEstudio.getJButtonCerrar().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				lPlanEstudio.dispose();
			}
		});	 
		
		lPlanEstudio.getJButtonBorrar().addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = lPlanEstudio.getJTablePlanEstudio().getSelectedRow();
				((TableModelListPlanEstudio)lPlanEstudio.getJTablePlanEstudio().getModel()).remover(row);
			}
		});
		
		lPlanEstudio.getJButtonNuevo().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				((TableModelListPlanEstudio)lPlanEstudio.getJTablePlanEstudio().getModel()).agregar(new PlanEstudio());
				
			}
		});	 		
	}
	
}
