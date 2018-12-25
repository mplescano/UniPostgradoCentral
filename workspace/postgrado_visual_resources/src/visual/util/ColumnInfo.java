package visual.util;

public class ColumnInfo {
	private String columnName;
	private String propertyName;
	private boolean isBean;
	private String javaDataType;
	
	public ColumnInfo (String columnName, String propertyName) {
		this.columnName = columnName;
		this.propertyName = propertyName;
	}
	
	public ColumnInfo () {
		
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
