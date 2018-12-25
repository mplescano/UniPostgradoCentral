package visual.app.tableModel;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.apache.commons.beanutils.PropertyUtils;

import visual.util.ColumnInfo;

import dominio.negocio.Ubigeo;
import dominio.negocio.UbigeoView;

public class TableModelListUbigeo extends AbstractTableModel implements
TableModel {
	
	private List l;

	public static final ColumnInfo columns[] = {
		new ColumnInfo("ID", "id"),
		new ColumnInfo("PAIS", "nombre_pais"),
		new ColumnInfo("DEPARTAMENTO", "nombre_departamento"),
		new ColumnInfo("PROVINCIA", "nombre_provincia"),
		new ColumnInfo("DISTRITO", "nombre_distrito")
	};
	
	/**
	 * @param l, lista de objetos UbigeoView
	 */
	public TableModelListUbigeo (List l) {
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

	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		UbigeoView ub = (UbigeoView) this.l.get(row);
		Object o = null;
		try {
			o = PropertyUtils.getProperty(ub, columns[col].getPropertyName());
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

	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return columns[col].getColumnName();
	}
	
	public Object getSelectedRow (int row) {
		Ubigeo ub = new Ubigeo();
		if (row >= 0) {
			UbigeoView ubV = (UbigeoView) this.l.get(row);
			try {
				PropertyUtils.copyProperties(ub, ubV);
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
		}
		return ub;
	}
}