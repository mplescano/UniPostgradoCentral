package persistencia;
 
import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;
import java.io.Reader;
import java.net.URL;

import org.apache.log4j.PropertyConfigurator;

/**
 * <p/>
 * Date: Mar 6, 2004 11:24:18 PM
 * 
 * @author Clinton Begin
 */
public class DaoConfig {

  private static final DaoManager daoManager;

  static {
		try {
		  String resource = "persistencia/dao.xml";
		  Reader reader = Resources.getResourceAsReader(resource);
		  daoManager = DaoManagerBuilder.buildDaoManager(reader);
		  

		}
		catch (Exception e) {
		  throw new RuntimeException("No se pudo inicializar DaoConfig.  Causa: " + e);
		}
  }

  private DaoConfig () {
	  
  }
  
  public static DaoManager getDaomanager() {
    return daoManager;
  }
  
  public static void main (String arg[]) {
	  DaoManager daoManagerTest = DaoConfig.getDaomanager();
  }
}
