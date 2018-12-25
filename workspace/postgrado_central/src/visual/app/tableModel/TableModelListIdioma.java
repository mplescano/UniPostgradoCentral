package visual.app.tableModel;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.beanutils.PropertyUtils;

import dominio.negocio.GradoTitulo;
import dominio.negocio.TpIdioma;

import visual.util.ColumnInfo;

public class TableModelListIdioma extends AbstractTableModel implements
TableModel {
	private List l;
	public static final ColumnInfo columns[] = {
		new ColumnInfo("IDIOMA", "nombreIdioma"),
		new ColumnInfo("NIVEL", "nivelIdioma"),
	};
	
	/**
	 * @param l: Lista de objetos TpIdioma
	 */
	public TableModelListIdioma (List l) {
		this.l = l;
		if (this.l == null) {
			this.l = new ArrayList();
		}
	}
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return l.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		TpIdioma idm = (TpIdioma) l.get(rowIndex);
		Object o = null;
		try {
			o = PropertyUtils.getProperty(idm, columns[columnIndex].getPropertyName());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public String getColumnName(int column) {
		return columns[column].getColumnName();
	}
	
	public void addObject (Object o) {
		if (o != null && o instanceof TpIdioma && !this.l.contains(o)) {
			this.l.add(o);
			fireTableStructureChanged();
		}
	}
	
	public List getList () {
		return l;
	}
	
	public void removeRow (int row) {
		if (row >= 0) {
			this.l.remove(row);
			fireTableStructureChanged();
		}
	}
}
