package persistencia.imp;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class BaseSqlMapDao extends SqlMapDaoTemplate {

  protected static final int PAGE_SIZE = 4;

  public BaseSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }
  
	protected String prepareStringSafe (String s) {
		//%
		//trim
		if (s != null) {
			s = s.trim();
			//s = s.replaceAll("[%\\/]{1,}|[']", " ");
			s = s.replaceAll("'", "''").trim();
			s = s.replaceAll("\\[", "[[]");
			s = s.replaceAll("%", " ");
			s = s.replaceAll("_", "[_]");
			s = s.replaceAll(";", " ");
			s = s.replaceAll("--", " ");
			s = s.replaceAll("/\\*", " ");
			s = s.replaceAll("\\*/", " ");
			return s;			
		}
		return null;
	}
	
	protected String prepareForSearh (String s) {
		if (s != null) {
			String temp = new String(prepareStringSafe(s));
			temp = temp.trim();
			temp.replaceAll("[ ]{1,}", "%");
			temp = "%" + temp.trim() + "%";
			return temp;
		}
		return null;
	}
}