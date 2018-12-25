package visual.util;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import org.apache.commons.beanutils.PropertyUtils;

public class ComboBoxUtils {
	
	public static void addItems (List items, JComboBox cb) {
		if (items == null) {
			return;
		}
		for (Iterator it = items.iterator(); it.hasNext();) {
			cb.addItem(it.next());
		}
	}
	
	public static DefaultListCellRenderer getTextRenderer (final String property) {
		return new DefaultListCellRenderer () {

			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				// TODO Auto-generated method stub
				Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value != null) {
					String texto = null;
					try {
						texto = (String) PropertyUtils.getProperty(value, property);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						texto = "IllegalAccessException";
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						texto = "InvocationTargetException";
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						texto = "NoSuchMethodException";
					}
					setText(texto);
				}
				else {
					setText("[SELECIONE...]");
				}
				return comp;
			}
		};
	}
	
	public static void setKeyStrokeToNullComboBoxRow (final JComboBox cmb) {
		cmb.addKeyListener(new KeyAdapter () {
			public void keyPressed(KeyEvent k) {
				// TODO Auto-generated method stub
				if (k.getKeyCode() == KeyEvent.VK_DELETE && k.getModifiers() == 0) {
					cmb.setSelectedIndex(-1);
					k.consume();
				}
			}
		});
	}






	
	public class SimpleComboRow {
		String label;
		Object value;
		
		public SimpleComboRow () {
			
		}
		
		public SimpleComboRow (String label, Object value) {
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}
		

		public void setLabel(String label) {
			this.label = label;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}
}
