package visual.app.tableModel;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.beanutils.PropertyUtils;

import dominio.negocio.Facultad;

import visual.util.ColumnInfo;

public class TableModelListFacultad extends AbstractTableModel implements
TableModel {
	
	static final ColumnInfo[] columns = {
		new ColumnInfo("CODIGO", "codigo"),
		new ColumnInfo("NOMBRE", "nombre")
	};
	
	
	private List l;
	
	/**
	 * @param l, lista de objectos Facultad
	 */
	public TableModelListFacultad (List l) {
		this.l = l;
		if (this.l == null) {
			this.l = new ArrayList();
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.l.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Facultad f = (Facultad) this.l.get(rowIndex);
		Object o = null;
		try {
			o = PropertyUtils.getProperty(f, columns[columnIndex].getPropertyName());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			o = e.getMessage();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			o = e.getMessage();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			o = e.getMessage();
		}
		return o;
	}
	
	public String getColumnName(int column) {
		return columns[column].getColumnName();
	}
}
