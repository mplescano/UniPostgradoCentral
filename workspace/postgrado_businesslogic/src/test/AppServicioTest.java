package test;

import java.util.Iterator;
import java.util.List;
import dominio.negocio.Alumno;
import dominio.negocio.EstudioPostgrado;
import dominio.negocio.Mencion;
import dominio.negocio.Ubigeo;
import servicio.AppServicio;
import junit.framework.TestCase;

public class AppServicioTest extends TestCase {
	AppServicio app = AppServicio.getInstance();
	public static void main(String[] args) {
		junit.textui.TestRunner.run(AppServicioTest.class);
	}

	/*
	 * Test method for 'servicio.AppServicio.getAlumnoEgresadoList(Map)'
	 */
	public void testGetAlumnoEgresadoList() {
		/*
		List l = app.getAlumnoList(null);
		for (int i=0; i<l.size();i++) {
			Alumno ae = (Alumno)l.get(i);
			Alumno aeclon = null;
			try {
				aeclon = (Alumno) ae.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(ae.getId() > 0);
			assertNotNull(ae.getGradosYTitulos());
			assertNotNull(ae.getIdiomas());
			
			assertTrue(ae.getGradosYTitulos().size() > 0);
			assertTrue(ae.getIdiomas().size() > 0);
			
			assertNotNull(aeclon.getGradosYTitulos());
			assertTrue(aeclon.getGradosYTitulos().size() > 0);
			assertTrue(aeclon.getIdiomas().size() > 0);
		}*/
	}

	/*
	 * Test method for 'servicio.AppServicio.getAlumnoEgresado(int)'
	 */
	public void testGetAlumnoEgresado() {
		Alumno ae = app.getAlumno(17);
		assertNotNull(ae.getTpModalidadIngreso());
	}

	/*
	 * Test method for 'servicio.AppServicio.insertAlumnoEgresado(Alumno)'
	 */
	public void testInsertAlumnoEgresado() {
		/*
		 * 
		 * 
		 * 		Facultad f = app.getFacultad("FIIS");
		TpPostgrado tp = app.getTpPostgrado("MA");
		assertNotNull(f);
		assertNotNull(f.getNombre());
		assertNotNull(f.getCodigo());
		
		assertNotNull(tp);
		assertNotNull(tp.getNombre());
		assertNotNull(tp.getCodigo());
		
		Alumno ae = new Alumno();
		
		ae.setTpPostgrado(tp);
		ae.setFacultad(f);
		
		ae.setApellidoMaterno("Blanco");
		ae.setApellidoPaterno("Lescano");
		ae.setCell("98007064");
		ae.setCodigoAlumno("19971042E");
		
		//ae.setCodigoDocente("NULL");
		
		//ae.setObservaciones("NULL");
		
		//ae.setUbigeoDomicilio("NULL");
		//ae.setUbigeoNac("NULL");
		
		ae.setDireccion("Av. tupac");
		ae.setEmail("mplaescano@");
		ae.setFechaNac(new Date());
		ae.setFechaRegistro(new Date());
		ae.setId(5);
		ae.setNacionalidad("peruano");
		ae.setNombres("Paul");
		ae.setNroDoc("4801070");
		ae.setPeriodoAcademico("2005-II");
		ae.setTelefono("4811070");
		ae.setTpDoc("DNI");
		ae.setTpEstadoCivil("soltero");
		ae.setTpSexo("HB");
		
		app.insertAlumnoEgresado(ae);
		
		Alumno aeTemp = app.getAlumnoEgresado(ae.getId());
		
		assertNotNull(aeTemp);
		
		List l = app.getAlumnoEgresadoList(null);
		assertNotNull(l);
		
		assertTrue(l.size() > 0);
		
		aeTemp = (Alumno) l.get(0);
		assertNotNull(aeTemp);
		assertNotNull(aeTemp.getFacultad());
		assertNotNull(aeTemp.getTpPostgrado());
		
		app.deleteAlumnoEgresado(ae);
		
		aeTemp = app.getAlumnoEgresado(ae.getId());
		
		assertNull(aeTemp);

		Facultad f = app.getFacultad("FIIS");
		TpPostgrado tp = app.getTpPostgrado("MA");
		assertNotNull(f);
		assertNotNull(f.getNombre());
		assertNotNull(f.getCodigo());
		
		assertNotNull(tp);
		assertNotNull(tp.getNombre());
		assertNotNull(tp.getCodigo());

		Alumno ae = new Alumno();
		
		ae.setTpPostgrado(tp);
		ae.setFacultad(f);
		
		ae.setApellidoMaterno("Blanco");
		ae.setApellidoPaterno("Lescano");
		ae.setCell("98007064");
		ae.setCodigoAlumno("19971042E");
		
		//ae.setCodigoDocente("NULL");
		
		//ae.setObservaciones("NULL");
		
		//ae.setUbigeoDomicilio("NULL");
		//ae.setUbigeoNac("NULL");
		
		ae.setDireccion("Av. tupac");
		ae.setEmail("mplaescano@");
		ae.setFechaNac(new Date());
		ae.setFechaRegistro(new Date());
		ae.setId(5);
		ae.setNacionalidad("peruano");
		ae.setNombres("Paul");
		ae.setNroDoc("4801070");
		ae.setPeriodoAcademico("2005-II");
		ae.setTelefono("4811070");
		ae.setTpDoc("DNI");
		ae.setTpEstadoCivil("soltero");
		ae.setTpSexo("HB");
		
		app.insertAlumnoEgresado(ae);
		
		Alumno aeTemp = app.getAlumnoEgresado(ae.getId());
		
		assertNotNull(aeTemp);
		
		app.deleteAlumnoEgresado(ae);
		
		aeTemp = app.getAlumnoEgresado(ae.getId());
		
		assertNull(aeTemp);
				 * 
		 * */
	}

	/*
	 * Test method for 'servicio.AppServicio.updateAlumnoEgresado(Alumno, Alumno)'
	 */
	public void testUpdateAlumnoEgresado() {
		/**
		Facultad f = app.getFacultad("FIIS");
		TpPostgrado tp = app.getTpPostgrado("MA");
		assertNotNull(f);
		assertNotNull(f.getNombre());
		assertNotNull(f.getCodigo());
		
		assertNotNull(tp);
		assertNotNull(tp.getNombre());
		assertNotNull(tp.getCodigo());
		
		
		Alumno ae = new Alumno();
		
		ae.setTpPostgrado(tp);
		ae.setFacultad(f);
		
		ae.setApellidoMaterno("Blanco");
		ae.setApellidoPaterno("Lescano");
		ae.setCell("98007064");
		ae.setCodigoAlumno("19971042E");
		
		//ae.setCodigoDocente("NULL");
		
		//ae.setObservaciones("NULL");
		
		//ae.setUbigeoDomicilio("NULL");
		//ae.setUbigeoNac("NULL");
		
		ae.setDireccion("Av. Tupac");
		ae.setEmail("mplaescano@");
		ae.setFechaNac(new Date());
		ae.setFechaRegistro(new Date());
		ae.setId(5);
		ae.setNacionalidad("peruano");
		ae.setNombres("Paul");
		ae.setNroDoc("4801070");
		ae.setPeriodoAcademico("2005-II");
		ae.setTelefono("4811070");
		ae.setTpDoc("DNI");
		ae.setTpEstadoCivil("soltero");
		ae.setTpSexo("HB");
		
		app.insertAlumnoEgresado(ae);
		
		Alumno aeTemp = app.getAlumnoEgresado(ae.getId());
		assertNotNull(aeTemp);
		**/
		/***************************/
		/**
		Alumno aeTempUpd = aeTemp;
		
		aeTempUpd.setTpEstadoCivil("viudo");
		aeTempUpd.setPeriodoAcademico("2006-I");
		aeTempUpd.setTpDoc("PST");
		aeTempUpd.setNroDoc("1234567891");
		aeTempUpd.setNacionalidad("Peruano-americano");
		aeTempUpd.setEmail("mplescano2000@");
		
		app.updateAlumnoEgresado(aeTempUpd, aeTemp);
		aeTemp = app.getAlumnoEgresado(ae.getId());
		
		assertEquals(aeTempUpd.getTpEstadoCivil(), aeTemp.getTpEstadoCivil());
		assertEquals(aeTempUpd.getPeriodoAcademico(), aeTemp.getPeriodoAcademico());
		assertEquals(aeTempUpd.getTpDoc(), aeTemp.getTpDoc());
		assertEquals(aeTempUpd.getNroDoc(), aeTemp.getNroDoc());
		assertEquals(aeTempUpd.getNacionalidad(), aeTemp.getNacionalidad());
		assertEquals(aeTempUpd.getEmail(), aeTemp.getEmail());
		**/
		/***************************/
		/**
		app.deleteAlumnoEgresado(ae);
		
		aeTemp = app.getAlumnoEgresado(ae.getId());
		
		assertNull(aeTemp);
		
		**/
	}

	/*
	 * Test method for 'servicio.AppServicio.deleteAlumnoEgresado(int)'
	 */
	public void testDeleteAlumnoEgresadoInt() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deleteAlumnoEgresado(Alumno)'
	 */
	public void testDeleteAlumnoEgresadoAlumnoEgresado() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getGradoTitutloList(Map)'
	 */
	public void testGetGradoTitutloList() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getGradoTitulo(int)'
	 */
	public void testGetGradoTitulo() {

	}

	/*
	 * Test method for 'servicio.AppServicio.insertGradoTitulo(GradoTitulo)'
	 */
	public void testInsertGradoTitulo() {

	}

	/*
	 * Test method for 'servicio.AppServicio.updateGradoTitulo(GradoTitulo, GradoTitulo)'
	 */
	public void testUpdateGradoTitulo() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deleteGradoTitulo(int)'
	 */
	public void testDeleteGradoTituloInt() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deleteGradoTitulo(GradoTitulo)'
	 */
	public void testDeleteGradoTituloGradoTitulo() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getIdiomaList(Map)'
	 */
	public void testGetIdiomaList() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getIdioma(int)'
	 */
	public void testGetIdioma() {

	}

	/*
	 * Test method for 'servicio.AppServicio.insertIdioma(TpIdioma)'
	 */
	public void testInsertIdioma() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deleteIdioma(int)'
	 */
	public void testDeleteIdiomaInt() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deleteIdioma(TpIdioma)'
	 */
	public void testDeleteIdiomaTpIdioma() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getPlanEstudioList(Map)'
	 */
	public void testGetPlanEstudioList() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getPlanEstudio(int)'
	 */
	public void testGetPlanEstudio() {

	}

	/*
	 * Test method for 'servicio.AppServicio.insertPlanEstudio(PlanEstudio)'
	 */
	public void testInsertPlanEstudio() {

	}

	/*
	 * Test method for 'servicio.AppServicio.updatePlanEstudio(PlanEstudio, PlanEstudio)'
	 */
	public void testUpdatePlanEstudio() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deletePlanEstudio(int)'
	 */
	public void testDeletePlanEstudioInt() {

	}

	/*
	 * Test method for 'servicio.AppServicio.deletePlanEstudio(PlanEstudio)'
	 */
	public void testDeletePlanEstudioPlanEstudio() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getUbigeoList()'
	 */
	public void testGetUbigeoList() {
		List l = app.getUbigeoList();
		assertNotNull(l);
		assertTrue(l.size() > 0);
		for (Iterator it = l.iterator(); it.hasNext();) {
			Ubigeo ub = (Ubigeo) it.next();
			assertNotNull(ub);
			assertNotNull(ub.getId());
			assertNotNull(ub.getNombre());
		}
	}

	/*
	 * Test method for 'servicio.AppServicio.getUbigeoListPorNombre(String)'
	 */
	public void testGetUbigeoListPorNombre() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getUbigeo(String)'
	 */
	public void testGetUbigeo() {
		Ubigeo ub = (Ubigeo) app.getUbigeo("51010202");
		//assertNotNull(ub);
		//assertNotNull(ub.getId());
		//assertNotNull(ub.getNombre());
	}

	/*
	 * Test method for 'servicio.AppServicio.getUbigeoListPorDst(String, String, String)'
	 */
	public void testGetUbigeoListPorDst() {

	}

	/*
	 * Test method for 'servicio.AppServicio.getUbigeoListPorDpt(String)'
	 */
	public void testGetUbigeoListPorDpt() {

	}
	
	public void testGetMencionList () {
		List menciones = AppServicio.getInstance().getMencionList(null);
		assertNotNull(menciones);
		assertTrue(menciones.size() > 0);
		for (int i = 0; i < menciones.size(); i++) {
			Mencion m = (Mencion) menciones.get(i);
			System.out.println("co:"+m.getCodigo()+","+m.getNombre()+",ep:"+m.getIdEstudioPostgrado());
		}
	}
	
	public void testGetEstudioPostgradoList () {
		List esL = AppServicio.getInstance().getEstudioPostgradoList(null, null);
		assertNotNull(esL);
		assertTrue(esL.size() > 0);
		for (int i = 0; i<esL.size(); i++) {
			EstudioPostgrado ep = (EstudioPostgrado) esL.get(i);
			System.out.println("co:"+ep.getId()+","+ep.getEspecialidad()+",ep:"+ep.getDescripcion());
		}
	}
}