package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dominio.negocio.GradoTitulo;
import persistencia.DaoConfig;
import persistencia.iface.GradoTituloDao;
import junit.framework.TestCase;

public class GradoTituloImpDaoTest extends TestCase {
	private GradoTituloDao gtDao = (GradoTituloDao) DaoConfig.getDaomanager().getDao(GradoTituloDao.class);
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(GradoTituloImpDaoTest.class);
	}

	/*
	 * Test method for 'persistencia.imp.GradoTituloImpDao.getGradoTitutloList(Map)'
	 */
	public void testGetGradoTitutloList() {
		Map params = new HashMap();
		params.put("idAlumnoEgresado", new Integer(2));
		List l = gtDao.getGradoTitutloList(params);
		
		assertNotNull(l);
		
		for (int i = 0; i < l.size(); i++) {
			GradoTitulo gt = (GradoTitulo) l.get(i);
			System.out.println(gt.getId()+","+gt.getIdAlumnoEgresado());
		}

	}

	/*
	 * Test method for 'persistencia.imp.GradoTituloImpDao.getGradoTitulo(int)'
	 */
	public void testGetGradoTitulo() {

	}

	/*
	 * Test method for 'persistencia.imp.GradoTituloImpDao.insertGradoTitulo(GradoTitulo)'
	 */
	public void testInsertGradoTitulo() {

	}

	/*
	 * Test method for 'persistencia.imp.GradoTituloImpDao.updateGradoTitulo(GradoTitulo, GradoTitulo)'
	 */
	public void testUpdateGradoTitulo() {

	}

	/*
	 * Test method for 'persistencia.imp.GradoTituloImpDao.deleteGradoTitulo(int)'
	 */
	public void testDeleteGradoTituloInt() {

	}

	/*
	 * Test method for 'persistencia.imp.GradoTituloImpDao.deleteGradoTitulo(GradoTitulo)'
	 */
	public void testDeleteGradoTituloGradoTitulo() {

	}

}
