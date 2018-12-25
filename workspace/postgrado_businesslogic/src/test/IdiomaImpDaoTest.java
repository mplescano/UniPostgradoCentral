package test;

import dominio.Secuencia;
import dominio.negocio.TpIdioma;
import persistencia.DaoConfig;
import persistencia.iface.IdiomaDao;
import persistencia.iface.SecuenciaDao;
import junit.framework.TestCase;

public class IdiomaImpDaoTest extends TestCase {
	private IdiomaDao idmDao = (IdiomaDao) DaoConfig.getDaomanager().getDao(IdiomaDao.class);
	private SecuenciaDao sDao = (SecuenciaDao) DaoConfig.getDaomanager().getDao(SecuenciaDao.class);
	public static void main(String[] args) {
		junit.textui.TestRunner.run(IdiomaImpDaoTest.class);
	}

	/*
	 * Test method for 'persistencia.imp.IdiomaImpDao.getIdiomaList(Map)'
	 */
	public void testGetIdiomaList() {

	}

	/*
	 * Test method for 'persistencia.imp.IdiomaImpDao.getIdioma(int)'
	 */
	public void testGetIdioma() {

	}

	/*
	 * Test method for 'persistencia.imp.IdiomaImpDao.insertIdioma(TpIdioma)'
	 */
	public void testInsertIdioma() {
		TpIdioma idm = new TpIdioma();
		idm.setId(sDao.getNextId(Secuencia.IDIOMA));
		idm.setIdAlumnoEgresado(2);
		idm.setNivelIdioma("BASICO");
		idm.setNombreIdioma("NOMBRE PRUEBA");
		idmDao.insertIdioma(idm);
	}

	/*
	 * Test method for 'persistencia.imp.IdiomaImpDao.deleteIdioma(int)'
	 */
	public void testDeleteIdiomaInt() {
		idmDao.deleteIdioma(14);
	}

	/*
	 * Test method for 'persistencia.imp.IdiomaImpDao.deleteIdioma(TpIdioma)'
	 */
	public void testDeleteIdiomaTpIdioma() {

	}

}
