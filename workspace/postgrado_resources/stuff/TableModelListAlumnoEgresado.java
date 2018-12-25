package visual.app.tableModel;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.apache.commons.beanutils.PropertyUtils;
import dominio.negocio.Alumno;
import util.ColumnInfo;

public class TableModelListAlumnoEgresado extends AbstractTableModel implements
		TableModel {
	List l;
	List b;
	public static final ColumnInfo columns[] = {
						new ColumnInfo("...", ""),
						new ColumnInfo("ID", "id"),
						new ColumnInfo("FACULTAD", "facultad.nombre"),
						new ColumnInfo("TIPO DE POSTGRADO", "tpPostgrado.nombre"),
						new ColumnInfo("PER. ACAD.", "periodoAcademico"),
						new ColumnInfo("COD. ALUMNO", "codigoAlumno"),
						new ColumnInfo("COD. DOCENTE", "codigoDocente"),
						new ColumnInfo("NOMBRES", "nombres"),
						new ColumnInfo("APP. PATERNO", "apellidoPaterno"),
						new ColumnInfo("APP MATERNO", "apellidoMaterno"),
						new ColumnInfo("TELEFONO", "telefono"),
	}; 
	
	/**
	 * @param l: Lista de objectos de tipo Alumno
	 */
	public TableModelListAlumnoEgresado (List l) {
		if (l == null) {
			l = new ArrayList();
		}
		this.l = l;
		b = new ArrayList(this.l.size());
		for (int i = 0; i < l.size(); i++) {
			b.add(new Boolean(false));
		}
	}
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		int i = 0;
		if (this.l != null) {
			i = l.size();
		}
		return i;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Object o = null;
		switch (columnIndex) {
			case 0:
				o = b.get(rowIndex);
			break;
			
			default:
				try {
					o = PropertyUtils.getProperty( (Alumno) this.l.get(rowIndex), columns[columnIndex].getPropertyName());
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
			break;
		}
		return o;
	}
	
	public Object getSelectedRow (int row) {
		if (row >= 0) {
			return (Alumno) this.l.get(row);
		}
		return null;
	}
	
	public List getList () {
		return this.l;
	}
	
	public Class getColumnClass(int col) {
		// TODO Auto-generated method stub
		if (col == 0) {
			return Boolean.class;
		}
		return super.getColumnClass(col);
	}

	public boolean isCellEditable(int row, int col) {
		// TODO Auto-generated method stub
		if (col == 0) {
			return true;
		}
		return super.isCellEditable(row, col);
	}
	
	public void setValueAt(Object arg0, int row, int col) {
		// TODO Auto-generated method stub
		Object o = null;
		switch (col) {
			case 0:
				//o = hTemp.get("check");
				b.add(row, arg0);
				boolean flag = ((Boolean) arg0).booleanValue();
			break;
		}
	}

	//@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column].getColumnName();
	}
}
