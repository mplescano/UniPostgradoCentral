package persistencia.iface;

import java.util.List;
import java.util.Map;
import dominio.negocio.GradoTitulo;

public interface GradoTituloDao {
	/**
	 * @param params parametros de:idAlumnoEgresado,nombreGradoTitulo,orgProcedencia,periodoEgreso
	 * @return Retorna un listado de objetos GradoTitulo
	 */
	List getGradoTitutloList (Map params);
	
	GradoTitulo getGradoTitulo (int id);
	
	void insertGradoTitulo (GradoTitulo gt);
	
	void updateGradoTitulo (GradoTitulo gtNew, GradoTitulo gtOld);
	
	void deleteGradoTitulo (int id);
	
	void deleteGradoTitulo (GradoTitulo gt);

}
