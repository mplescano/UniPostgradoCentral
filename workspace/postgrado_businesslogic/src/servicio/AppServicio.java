package servicio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import persistencia.DaoConfig;
import persistencia.iface.AlumnoDao;
import persistencia.iface.EstudioPostgradoDao;
import persistencia.iface.GradoTituloDao;
import persistencia.iface.IdiomaDao;
import persistencia.iface.PlanEstudioDao;
import persistencia.iface.SecuenciaDao;
import persistencia.iface.UbigeoDao;
import dominio.Secuencia;
import dominio.negocio.Alumno;
import dominio.negocio.EstudioPostgrado;
import dominio.negocio.Facultad;
import dominio.negocio.GradoTitulo;
import dominio.negocio.ImpresionCertificadoAlumno;
import dominio.negocio.PlanEstudio;
import dominio.negocio.TpIdioma;
import dominio.negocio.TpModalidadIngreso;
import dominio.negocio.TpPostgrado;
import dominio.negocio.Ubigeo;

public class AppServicio {
	private AlumnoDao aeDao = (AlumnoDao) DaoConfig.getDaomanager().getDao(AlumnoDao.class);
	private GradoTituloDao gtDao = (GradoTituloDao) DaoConfig.getDaomanager().getDao(GradoTituloDao.class);
	private IdiomaDao idmDao = (IdiomaDao) DaoConfig.getDaomanager().getDao(IdiomaDao.class);
	private PlanEstudioDao peDao = (PlanEstudioDao) DaoConfig.getDaomanager().getDao(PlanEstudioDao.class);
	private UbigeoDao ubDao = (UbigeoDao) DaoConfig.getDaomanager().getDao(UbigeoDao.class);
	private SecuenciaDao sDao = (SecuenciaDao) DaoConfig.getDaomanager().getDao(SecuenciaDao.class);
	private EstudioPostgradoDao epDao = (EstudioPostgradoDao) DaoConfig.getDaomanager().getDao(EstudioPostgradoDao.class);
	
	private static final AppServicio instance = new AppServicio(); 
	
	private AppServicio () {
		
	}
	
	public static AppServicio getInstance () {
		return instance;
	}

	public List getAlumnoList(Map params) {
		return aeDao.getAlumnoList(params);
	}
	
	public Alumno getAlumno(int id) {
		return aeDao.getAlumno(id);
	}
	
	public void insertAlumno(Alumno a) {
		try {
			DaoConfig.getDaomanager().startTransaction();
			a.setId(sDao.getNextId(Secuencia.ALUMNO));
			aeDao.insertAlumno(a);
			
			if (a.getGradosYTitulos() != null) {
				for (Iterator it = a.getGradosYTitulos().iterator(); it.hasNext();) {
					GradoTitulo gt = (GradoTitulo) it.next();
					gt.setId(sDao.getNextId(Secuencia.GRADOTITULO));
					gtDao.insertGradoTitulo(gt);
				}
			}
			
			if (a.getIdiomas() != null) {
				
				for (Iterator it = a.getIdiomas().iterator(); it.hasNext();) {
					TpIdioma idm = (TpIdioma) it.next();
					idm.setId(sDao.getNextId(Secuencia.IDIOMA));
					idmDao.insertIdioma(idm);
				}
			}
			if (a.getPlanDeEstudios() != null) {
				for (Iterator it = a.getPlanDeEstudios().iterator(); it.hasNext();) {
					PlanEstudio pe = (PlanEstudio) it.next();
					pe.setId(sDao.getNextId(Secuencia.PLANESTUDIO));
					peDao.insertPlanEstudio(pe);
				}
			}
		
			
			DaoConfig.getDaomanager().commitTransaction();
		} 
		finally {
			DaoConfig.getDaomanager().endTransaction();
		}
	}
	
	public void updateAlumno(Alumno aNew, Alumno aOld) {
		try {
			DaoConfig.getDaomanager().startTransaction();
			aeDao.updateAlumno(aNew, aOld);
			
			for(int i = 0; i < aOld.getGradosYTitulos().size(); i++ ) {
				GradoTitulo gt = (GradoTitulo) aOld.getGradosYTitulos().get(i);
				gtDao.deleteGradoTitulo(gt);
			}
			for(int i = 0; i < aOld.getIdiomas().size(); i++ ) {
				TpIdioma idm = (TpIdioma) aOld.getIdiomas().get(i);
				idmDao.deleteIdioma(idm);
			}
			for(int i = 0; i < aOld.getPlanDeEstudios().size(); i++ ) {
				PlanEstudio pe = (PlanEstudio) aOld.getPlanDeEstudios().get(i);
				peDao.deletePlanEstudio(pe);
			}		
			
			if (aNew.getGradosYTitulos() != null) {

				for (Iterator it = aNew.getGradosYTitulos().iterator(); it.hasNext();) {
					GradoTitulo gt = (GradoTitulo) it.next();
					gt.setId(sDao.getNextId(Secuencia.GRADOTITULO));
					gt.setIdAlumnoEgresado(aNew.getId());
					gtDao.insertGradoTitulo(gt);
				}
			}
			
			if (aNew.getIdiomas() != null) {
				for (Iterator it = aNew.getIdiomas().iterator(); it.hasNext();) {
					TpIdioma idm = (TpIdioma) it.next();
					idm.setId(sDao.getNextId(Secuencia.IDIOMA));
					idm.setIdAlumnoEgresado(aNew.getId());					
					idmDao.insertIdioma(idm);
				}
			}
			if (aNew.getPlanDeEstudios() != null) {
				for (Iterator it = aNew.getPlanDeEstudios().iterator(); it.hasNext();) {
					PlanEstudio pe = (PlanEstudio) it.next();
					pe.setId(sDao.getNextId(Secuencia.PLANESTUDIO));
					pe.setIdAlumnoEgresado(aNew.getId());					
					peDao.insertPlanEstudio(pe);
				}
			}
			DaoConfig.getDaomanager().commitTransaction();
		} 
		finally {
			DaoConfig.getDaomanager().endTransaction();
		}
	}
	
	public void deleteAlumno(int id) {
		try {
			DaoConfig.getDaomanager().startTransaction();
			Alumno a = aeDao.getAlumno(id);
			for(int i = 0; i < a.getGradosYTitulos().size(); i++ ) {
				GradoTitulo gt = (GradoTitulo) a.getGradosYTitulos().get(i);
				gtDao.deleteGradoTitulo(gt);
			}
			for(int i = 0; i < a.getIdiomas().size(); i++ ) {
				TpIdioma idm = (TpIdioma) a.getIdiomas().get(i);
				idmDao.deleteIdioma(idm);
			}
			for(int i = 0; i < a.getPlanDeEstudios().size(); i++ ) {
				PlanEstudio pe = (PlanEstudio) a.getPlanDeEstudios().get(i);
				peDao.deletePlanEstudio(pe);
			}
			aeDao.deleteAlumno(id);
			DaoConfig.getDaomanager().commitTransaction();
		} 
		finally {
			DaoConfig.getDaomanager().endTransaction();
		}
	}
	
	public void deleteAlumno(Alumno a) {
		try {
			DaoConfig.getDaomanager().startTransaction();
			if (a.getGradosYTitulos() != null) {
				for(int i = 0; i < a.getGradosYTitulos().size(); i++ ) {
					GradoTitulo gt = (GradoTitulo) a.getGradosYTitulos().get(i);
					gtDao.deleteGradoTitulo(gt);
				}
			}
			if (a.getIdiomas() != null) {
				for(int i = 0; i < a.getIdiomas().size(); i++ ) {
					TpIdioma idm = (TpIdioma) a.getIdiomas().get(i);
					idmDao.deleteIdioma(idm);
				}
			}
			if (a.getPlanDeEstudios() != null) {
				for(int i = 0; i < a.getPlanDeEstudios().size(); i++ ) {
					PlanEstudio pe = (PlanEstudio) a.getPlanDeEstudios().get(i);
					peDao.deletePlanEstudio(pe);
				}
			}
			aeDao.deleteAlumno(a);
			DaoConfig.getDaomanager().commitTransaction();
		} 
		finally {
			DaoConfig.getDaomanager().endTransaction();
		}
	}
	
	
	public List getGradoTitutloList(Map params) {
		return gtDao.getGradoTitutloList(params);
	}
	
	public GradoTitulo getGradoTitulo(int id) {
		return gtDao.getGradoTitulo(id);
	}
	
	public void insertGradoTitulo(GradoTitulo gt) {
		gtDao.insertGradoTitulo(gt);
	}
	
	public void updateGradoTitulo(GradoTitulo gtNew, GradoTitulo gtOld) {
		gtDao.updateGradoTitulo(gtNew, gtOld);
	}
	
	public void deleteGradoTitulo(int id) {
		gtDao.deleteGradoTitulo(id);
	}
	
	public void deleteGradoTitulo(GradoTitulo gt) {
		gtDao.deleteGradoTitulo(gt);
	}
	
	public List getIdiomaList(Map params) {
		return idmDao.getIdiomaList(params);
	}
	
	public TpIdioma getIdioma(int id) {
		return idmDao.getIdioma(id);
	}
	
	public void insertIdioma(TpIdioma idm) {
		idmDao.insertIdioma(idm);
	}
	
	public void deleteIdioma(int id) {
		idmDao.deleteIdioma(id);
	}
	
	public void deleteIdioma(TpIdioma idm) {
		idmDao.deleteIdioma(idm);
	}
	
	public List getPlanEstudioList(Map params) {
		return peDao.getPlanEstudioList(params);
	}
	
	public PlanEstudio getPlanEstudio(int id) {
		return peDao.getPlanEstudio(id);
	}
	
	public void insertPlanEstudio(PlanEstudio pe) {
		peDao.insertPlanEstudio(pe);
	}
	
	public void updatePlanEstudio(PlanEstudio peNew, PlanEstudio peOld) {
		peDao.updatePlanEstudio(peNew, peOld);
	}
	
	public void deletePlanEstudio(int id) {
		peDao.deletePlanEstudio(id);
	}
	
	public void deletePlanEstudio(PlanEstudio pe) {
		peDao.deletePlanEstudio(pe);
	}
	
	/**
	 * @return lista de objetos Ubigeo
	 */
	public List getUbigeoList() {
		return ubDao.getUbigeoList();
	}
	
	/**
	 * @param params, lista de objetos UbigeoView
	 * @return
	 */
	public List getUbigeoViewList(Map params) {
		return ubDao.getUbigeoViewList(params);
	}
	
	public List getUbigeoListPorNombre(String nombre) {
		return ubDao.getUbigeoListPorNombre(nombre);
	}
	
	public Ubigeo getUbigeo(String id) {
		return ubDao.getUbigeo(id);
	}
	
	public List getUbigeoListPorDst(String codPais, String codDpt, String codPrv) {
		return ubDao.getUbigeoListPorDst(codPais, codDpt, codPrv);
	}
	
	public List getUbigeoListPorDpt(String codPais) {
		return ubDao.getUbigeoListPorDpt(codPais);
	}
	
	public Facultad getFacultad (String codigo) {
		return aeDao.getFacultad(codigo);
	}
	
	public List getFacultadList() {
		return aeDao.getFacultadList();
	}
	
	public TpModalidadIngreso getModalidadIngreso (String codigo) {
		return aeDao.getTpModalidadIngreso(codigo);
	}
	
	public List getModalidadIngresoList() {
		return aeDao.getTpModalidadIngresoList();
	}
	
	public TpPostgrado getTpPostgrado (String codigo) {
		return aeDao.getTpPostgrado(codigo);
	}
	
	public List getMencionList (Map params) {
		return epDao.getMencionList(params);
	}

	
//	public List getMencionList(Facultad fc, TpPostgrado tp) {
//		return epDao.getMencionList(fc, tp);
//	}
	
	public List getEstudioPostgradoList (Facultad fc, TpPostgrado tp) {
		Map params = null;
		if (fc != null && tp != null) {
			params = new HashMap();
			params.put("facultad_codigo", fc.getCodigo());
			params.put("tpPostgrado_codigo", tp.getCodigo());
		}
		else if (fc != null) {
			params = new HashMap();
			params.put("facultad_codigo", fc.getCodigo());
		}
		else if (tp != null) {
			params = new HashMap();
			params.put("tpPostgrado_codigo", tp.getCodigo());
		}
		return epDao.getEstudioPostgradoList(params);
	}
	
	public EstudioPostgrado getEstudioPostgrado (int id) {
		return epDao.getEstudioPostgrado(id);
	}
	
	public void insertImpresionCertificadoAlumno(ImpresionCertificadoAlumno ica) {
		aeDao.insertImpresionCertificadoAlumno(ica);
	}
	
}