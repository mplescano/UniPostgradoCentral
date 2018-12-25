/**
 * 
 */
package visual.app.tableModel;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.apache.commons.beanutils.PropertyUtils;

import dominio.negocio.Alumno;
import dominio.negocio.PlanEstudio;

import visual.util.ColumnInfo;

/**
 * @author Jaime
 *
 */
public class TableModelListPlanEstudio extends AbstractTableModel implements TableModel {

	/** List del plan de estudios */
	List lPlanEstudio = null;

	/** Columnas de la tabla plan_estudio */
	public static final ColumnInfo columns[] = {
		//new ColumnInfo("...", ""),
		new ColumnInfo("ID", "id"),
		new ColumnInfo("CODIGO CURSO", "codigoCurso"),
		new ColumnInfo("NOMBRE CURSO", "nombreCurso"),
		new ColumnInfo("CREDITO CURSO", "creditoCurso"),
		new ColumnInfo("NOTA CURSO", "notaCurso"),
		new ColumnInfo("DOCENTE CURSO", "docenteCurso"),
		new ColumnInfo("PERIODO CURSO", "periodoCurso"),
		new ColumnInfo("FEC. INI. CURSO", "fechaIniCurso"),
	}; 	
	
	/** Constructor
	 * Guarda el list de plan de estudios
	 * Asigna la lista de los flags de seleccion a falso
	 * @param lPlanEstudio
	 */
	public TableModelListPlanEstudio(List lPlanEstudio) {
		super();
		this.lPlanEstudio = lPlanEstudio;
		if (lPlanEstudio==null)
			this.lPlanEstudio = new ArrayList();

	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return columns.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		return lPlanEstudio.size();
	}

	/** Retorna si la columna es  editable 
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex){
		case 0  :return false;
		default : return true;
		}
	}

	/** Retorna los tipos de datos de columna del TableModel
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	public Class getColumnClass(int columnIndex) {
		switch (columnIndex){
		case 1 :  return String.class;
		case 2 :  return String.class;
		case 3 :  return Integer.class;
		case 4 :  return BigDecimal.class;		
		case 5 :  return String.class;		
		case 6 :  return String.class;		
		case 7 :  return String.class;
		//case 7 :  return java.util.Date.class;
		}
		return super.getColumnClass(columnIndex);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object o = null;
				try {
					o = PropertyUtils.getProperty( (PlanEstudio) this.lPlanEstudio.get(rowIndex), columns[columnIndex].getPropertyName());
					if (columnIndex == 7 && o!=null){
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					    return (formato.format((java.util.Date)o)).toString();
					}
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

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		PlanEstudio npe = (PlanEstudio)lPlanEstudio.get(rowIndex);
		switch (columnIndex) {
			case 1:
				npe.setCodigoCurso((String)aValue);
				break;
			case 2:
				npe.setNombreCurso((String)aValue);
				break;
			case 3:
				npe.setCreditoCurso(((Integer)aValue).intValue());
				break;
			case 4:
				npe.setNotaCurso((BigDecimal)aValue);
				break;				
			case 5:
				npe.setDocenteCurso((String)aValue);
				break;				
			case 6:
				npe.setPeriodoCurso((String)aValue);
				break;
			case 7:
				   String fecha = (String)aValue;
				   SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				   try {
					   Date fechanueva = sd.parse(fecha);
					   npe.setFechaIniCurso(fechanueva);
				   } catch (ParseException e) {
					   // mantiene fecha original
				   }
				   break;				
		}	
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return columns[columnIndex].getColumnName();
	}
	
	public void agregar(PlanEstudio pe){
		lPlanEstudio.add(pe);
		fireTableStructureChanged();
	}
	
	public void remover(int row){
		if (row >= 0) {
			lPlanEstudio.remove(row);
		}
		fireTableStructureChanged();
	}
}
