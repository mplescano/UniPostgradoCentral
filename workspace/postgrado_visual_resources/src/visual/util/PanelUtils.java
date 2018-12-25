package visual.util;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class PanelUtils {

	public static void setMnemonicCustomize (JPanel p, KeyStroke key, final JButton bt) {
		PanelUtils.setMnemonicCustomize(p, key, new AbstractAction () {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bt.doClick();
			}
		});
	}
	
	public static void setMnemonicCustomize (JPanel p, KeyStroke key, final Action action) {
		KeyStroke keyMnemonic = KeyStroke.getKeyStroke(key.getKeyCode(), KeyEvent.ALT_MASK);
		String actionName = KeyEvent.getKeyModifiersText(KeyEvent.ALT_MASK)+" "+KeyEvent.getKeyText(key.getKeyCode());
		PanelUtils.addActionKeyStroke (p, JComponent.WHEN_IN_FOCUSED_WINDOW, keyMnemonic, actionName, action);
	}
	
	
	public static void addActionKeyEnter (JComponent tc, final Action action) {
		tc.addKeyListener(new KeyAdapter () {
/*
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
*/
			public void keyPressed(KeyEvent k) {
				// TODO Auto-generated method stub
				if (k.getKeyCode() == KeyEvent.VK_ENTER && k.getModifiers() == 0) {
					ActionEvent ae = new ActionEvent(k.getComponent(), k.getID(), KeyEvent.getKeyText(k.getKeyCode()), k.getWhen(), k.getModifiers());
					action.actionPerformed(ae);
				}
			}
/*
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
*/		
		});
	}
	
	
	public static void addBindingKeyTable (JPanel p, final JTable table) {
		final Action actionToDownRow = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelUtils.nextRowTable(table);
			}
		};
		final Action actionToUpRow = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PanelUtils.previousRowTable(table);
			}
		};
		
		String nameDown = table.getName() + "." + table.getLocation().x + "." + table.getLocation().y + "_down";
		String nameUp =   table.getName() + "." + table.getLocation().x + "." + table.getLocation().y + "_up";
		
		PanelUtils.addActionKeyStroke(p, JComponent.WHEN_IN_FOCUSED_WINDOW, KeyStroke.getKeyStroke("DOWN"), nameDown, actionToDownRow);
		PanelUtils.addActionKeyStroke(p, JComponent.WHEN_IN_FOCUSED_WINDOW, KeyStroke.getKeyStroke("UP"), nameUp, actionToUpRow);
		//PanelUtils.addActionKeyStroke(table, JComponent.WHEN_IN_FOCUSED_WINDOW,KeyStroke.getKeyStroke("DOWN"), nameDown, actionToDownRow);
		//PanelUtils.addActionKeyStroke(table, JComponent.WHEN_IN_FOCUSED_WINDOW,KeyStroke.getKeyStroke("UP"), nameUp, actionToUpRow);
		table.setRequestFocusEnabled(false);
		//table.setFocusable(false);
		table.addKeyListener(new KeyAdapter () {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_UP && e.getModifiers() == 0) {
					//System.out.println("hola up");
					actionToUpRow.actionPerformed(null);
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN && e.getModifiers() == 0) {
					actionToDownRow.actionPerformed(null);
					//System.out.println("hola down");
					e.consume();
				}
			}
		});
	}
	
	
	
	/**
	 * 
	 * @param c
	 * @param constante JComponent.WHEN_FOCUSED, JComponent.WHEN_IN_FOCUSED_WINDOW
	 * @param keyStroke
	 * KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.SHIFT_MASK)
	 * KeyStroke.getKeyStroke("control Y"), "Redo"
	 * KeyStroke.getKeyStroke("control Z"), "Undo"
	 * KeyStroke.getKeyStroke("F11")
	 * ActionEvent
	 * KeyEvent
	 * KeyStroke.getKeyStroke(int keyCode, int modifiers):
		Returns an instance of KeyStroke built using the provided parameters. 
		The key code can be given as one of the constants defined in KeyEvent class. 
		
		The modifiers are a combination of masks:
		
		KeyEvent.SHIFT_MASK (1) 
		KeyEvent.CTRL_MASK (2) 
		KeyEvent.META_MASK (4) 
		KeyEvent.ALT_MASK (8) 
		Those constants can be combined using bitwise OR
	 *
	 * KeyStroke getKeyStroke(String keyStroke)
		Returns an instance of KeyStroke built using the provided parameters. 
		The string must have the following syntax to be parsed succesfully: 
	    "<modifiers>* <key>"
	    modifiers := shift | control | meta | alt
	    key := KeyEvent keycode name, i.e. the name following "VK_".
	 * 
	 * @param actionName Nombre de la Accion
	 * @param action Objeto que implementa AbstractAction
	 * @link http://java.sun.com/products/jfc/tsc/special_report/kestrel/keybindings.html
	 */
	public static void addActionKeyStroke (JComponent c, int constante, KeyStroke keyStroke, String actionName, Action action) {
		c.getInputMap(constante).put(keyStroke, actionName);
		c.getActionMap().put(actionName, action);
	}
	
	public static void nextRowTable (JTable tabla) {
		int row = tabla.getSelectedRow();
		int tamanio = tabla.getRowCount();
		if (row >= 0) {
			if (! (row + 2 > tamanio)) {
				tabla.setRowSelectionInterval(row + 1, row + 1);
				Rectangle cellRect = tabla.getCellRect(row + 1, 0, false);
				if (cellRect != null) {
					tabla.scrollRectToVisible(cellRect);
				} 
			}
		}
		else if (tamanio > 0) {
			tabla.getSelectionModel().setSelectionInterval(0, 0);
			//tabla.setRowSelectionInterval(0, 0);
		}
	}
	
	public static void previousRowTable (JTable tabla) {
		int row = tabla.getSelectedRow();
		int tamanio = tabla.getRowCount();
		if (row >= 0) {
			if (row != 0) {
				tabla.setRowSelectionInterval(row - 1, row - 1);
				Rectangle cellRect = tabla.getCellRect(row - 1, 0, false);
				if (cellRect != null) {
					tabla.scrollRectToVisible(cellRect);
				}
			}
		}
		else if (tamanio > 0) {
			tabla.setRowSelectionInterval(0, 0);
		}
	}

	/**
	 * Inicia un foco en el componente c para la ventana w, en el momento en que se abre
	 * @param w
	 * @param c
	 */
	public static void setComponentFocus (Window w, final JComponent c) {
		
		w.addWindowListener(new WindowAdapter () {
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				c.requestFocus();
			}
/*
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}*/
			
		});
	}
	
	
	public static KeyListener toUpperCaseKeyTyped () {
		return new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (Character.isLetter(e.getKeyChar())) {
					//System.out.println(e.getKeyChar());
					//e.setModifiers(Event.SHIFT_MASK);
					e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
					//m_tf_codigo.setText(m_tf_codigo.getText().toUpperCase());
				}
			}
		};
	}
	
    public static void packColumns(JTable table, int margin) {
        for (int c = 0; c < table.getColumnCount(); c++) {
            packColumn(table, c, margin);
        }
    }
    
    // Sets the preferred width of the visible column specified by vColIndex. The column
    // will be just wide enough to show the column head and the widest cell in the column.
    // margin pixels are added to the left and right
    // (resulting in an additional width of 2*margin pixels).
    public static void packColumn(JTable table, int vColIndex, int margin) {
        //TableModel model = table.getModel();
        DefaultTableColumnModel colModel = (DefaultTableColumnModel)table.getColumnModel();
        TableColumn col = colModel.getColumn(vColIndex);
        int width = 0;
    
        // Get width of column header
        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(
            table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
    
        // Get maximum width of column data
        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, vColIndex);
            comp = renderer.getTableCellRendererComponent(
                table, table.getValueAt(r, vColIndex), false, false, r, vColIndex);
            width = Math.max(width, comp.getPreferredSize().width);
            //width = Math.max(width, col.getWidth());
        }
    
        // Add margin
        width += 2*margin;
    
        // Set the width
        col.setPreferredWidth(width);
    }	
	
	   public static void addFillComponents( Container panel, int[] cols, int[] rows ) {
		      Dimension filler = new Dimension(10,10);

		      boolean filled_cell_11 = false;
		      CellConstraints cc = new CellConstraints();
		      if ( cols.length > 0 && rows.length > 0 ) {
		         if ( cols[0] == 1 && rows[0] == 1 ) {
		            /** add a rigid area  */
		            panel.add( Box.createRigidArea( filler ), cc.xy(1,1) );
		            filled_cell_11 = true;
		         }
		      }

		      for( int index = 0; index < cols.length; index++ ) {
		         if ( cols[index] == 1 && filled_cell_11 ) {
		            continue;
		         }
		         panel.add( Box.createRigidArea( filler ), cc.xy(cols[index],1) );
		      }

		      for( int index = 0; index < rows.length; index++ ) {
		         if ( rows[index] == 1 && filled_cell_11 ) {
		            continue;
		         }
		         panel.add( Box.createRigidArea( filler ), cc.xy(1,rows[index]) );
		      }
	   }
	   

	   public static JPanel mkPnBuscador (JComboBox cb_tp_busqueda, JTextField tf_buscado, JButton bt_buscar, JButton bt_todos) {
		      JPanel jpanel1 = new JPanel();
		      FormLayout formlayout1 = new FormLayout("FILL:50DLU:NONE,FILL:5DLU:NONE,FILL:DEFAULT:GROW(1.0),FILL:5DLU:NONE,FILL:50DLU:NONE,FILL:5DLU:NONE,FILL:50DLU:NONE","CENTER:5DLU:NONE,CENTER:DEFAULT:NONE,CENTER:DEFAULT:NONE,CENTER:5DLU:NONE");
		      CellConstraints cc = new CellConstraints();
		      jpanel1.setLayout(formlayout1);

		      jpanel1.add(cb_tp_busqueda,cc.xy(1,3));

		      jpanel1.add(tf_buscado, cc.xy(3,3));

		      bt_buscar.setActionCommand("Buscar");
		      bt_buscar.setText("Buscar");
		      jpanel1.add(bt_buscar,cc.xy(5,3));

		      bt_todos.setActionCommand("Todos");
		      bt_todos.setText("Todos");
		      jpanel1.add(bt_todos,cc.xy(7,3));

		      JLabel jlabel1 = new JLabel();
		      jlabel1.setText("Buscar por:");
		      jpanel1.add(jlabel1,cc.xy(1,2));

		      addFillComponents(jpanel1,new int[]{ 1,2,3,4,5,6,7 },new int[]{ 1,4 });
		      return jpanel1;
	   }
	   
	   public static JPanel mkPnBotonesDeListado(JButton bt_add, JButton bt_edit, JButton bt_del, JButton bt_imp, JButton bt_close) {
		      JPanel jpanel1 = new JPanel();
		      FormLayout formlayout1 = new FormLayout("FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE,FILL:DEFAULT:NONE","CENTER:DEFAULT:NONE");
		      CellConstraints cc = new CellConstraints();
		      jpanel1.setLayout(formlayout1);

		      bt_add.setActionCommand("Adicionar");
		      bt_add.setText("Adicionar");
		      jpanel1.add(bt_add,cc.xy(1,1));

		      bt_edit.setActionCommand("Editar");
		      bt_edit.setText("Editar");
		      jpanel1.add(bt_edit,cc.xy(3,1));

		      bt_del.setActionCommand("Eliminar");
		      bt_del.setText("Eliminar");
		      jpanel1.add(bt_del,cc.xy(5,1));

		      bt_imp.setActionCommand("Imprimir");
		      bt_imp.setText("Imprimir");
		      jpanel1.add(bt_imp,cc.xy(7,1));

		      bt_close.setActionCommand("Cerrar");
		      bt_close.setText("Cerrar");
		      jpanel1.add(bt_close,cc.xy(9,1));

		      addFillComponents(jpanel1,new int[]{ 2,4,6,8 },new int[0]);
		      return jpanel1;
	   }
	   
	   public static InputVerifier getInputVerifier () {
		   class VerificadorEntrada extends InputVerifier {
				public boolean verify(JComponent input) {
					// TODO Auto-generated method stub
					if (input instanceof JFormattedTextField ) {
						JFormattedTextField ftf = (JFormattedTextField) input;
						AbstractFormatter formatter = ftf.getFormatter();
						if (formatter != null) {
							String text = ftf.getText();
							if (text == null || text.trim().equals("")) {
								return true;
							}
							try {
								formatter.stringToValue(text);
								return true;
							}
							catch (ParseException e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
								Mensaje.info(input, "La Fecha que ha ingresado es incorrecta, vuelva a editarlo, el formato es dd/mm/yyyy", "Fecha Incorrecta");
								return false;
							}
						}
					}
					return false;
				}
			}
		   return new VerificadorEntrada();
	   }

	   public static InputVerifier getInputVerifier (final int strLength) {
		   class VerificadorEntrada extends InputVerifier {
				public boolean verify(JComponent input) {
					// TODO Auto-generated method stub
					if (input instanceof JFormattedTextField ) {
						JFormattedTextField ftf = (JFormattedTextField) input;
						AbstractFormatter formatter = ftf.getFormatter();
						if (formatter != null) {
							String text = ftf.getText();
							try {
								formatter.stringToValue(text);
								if (text != null && text.trim().length() < strLength) {
									return false;
								}
								return true;
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
								return false;
							}
						}
					}
					return false;
				}
			}
		   return new VerificadorEntrada();
	   }
	   
	   
	   public static NumberFormatter getIntegerFormatter () {
			DecimalFormat df = new DecimalFormat("#####");
			NumberFormatter nf = new NumberFormatter(df) {
			    public String valueToString(Object iv) throws ParseException {
			        if ((iv == null) || (((Integer)iv).intValue() == -1)) {
			            return "";
			        }
			        else {
			            return super.valueToString(iv);
			        }
			    }
			    public Object stringToValue(String text) throws ParseException {
			        if ("".equals(text)) {
			            return null;
			        }
			        return super.stringToValue(text);
			    }
			};
			nf.setValueClass(Integer.class);
			return nf;
	   }
	   
		public static int getVisibleRowTopTable (JScrollPane scp, JTable tbl) {
			if (scp != null && tbl != null) {
				Point pPosicionViewPortTop = scp.getViewport().getViewPosition();
				return tbl.rowAtPoint(pPosicionViewPortTop);			
			}
			else {
				return -1;
			}
		}

		public static int getVisibleRowBottomTable (JScrollPane scp, JTable tbl) {
			if (scp != null && tbl != null) {
				Point pPosicionViewPortTop = scp.getViewport().getViewPosition();
				Dimension pTamanioViewPort = scp.getViewport().getExtentSize();
				Point pPosicionViewPortBottom = new Point(0, pTamanioViewPort.height + pPosicionViewPortTop.y);
				return tbl.rowAtPoint(pPosicionViewPortBottom);
			}
			else {
				return -1;
			}
		}
		
		
		
		// copied from BasicTableHeader.MouseInputHandler.getResizingColumn 
		private static TableColumn getResizingColumn(JTableHeader header, Point p){ 
			return PanelUtils.getResizingColumn(header, p, header.columnAtPoint(p)); 
		} 

		// copied from BasicTableHeader.MouseInputHandler.getResizingColumn 
		private static TableColumn getResizingColumn(JTableHeader header, Point p, int column){ 
			if(column == -1) { 
				return null;
			} 
			Rectangle r = header.getHeaderRect(column); 
			r.grow(-3, 0); 
			if(r.contains(p)) {
				return null;			
			}
			int midPoint = r.x+r.width/2; 
			int columnIndex; 
			if(header.getComponentOrientation().isLeftToRight()) {
				columnIndex = (p.x<midPoint) ? column-1 : column; 
			}
			else { 
	           columnIndex = (p.x<midPoint) ? column : column-1;
			}
	       if(columnIndex == -1) {
	           return null;
	       }
	       return header.getColumnModel().getColumn(columnIndex); 
		} 
		
		/*
		 * table.getTableHeader().addMouseListener(new ColumnFitAdapter()); 
		 * 
		 */
		public static MouseAdapter getColumnFitClickedAdapter (final boolean isAllRows) {
			return new MouseAdapter () {
				public void mouseClicked(MouseEvent e){
					if(e.getClickCount()==2){ 
						JTableHeader header = (JTableHeader) e.getSource(); 
						TableColumn tableColumn = getResizingColumn(header, e.getPoint()); 
						if(tableColumn == null) { 
							return;
						}
						int col = header.getColumnModel().getColumnIndex(tableColumn.getIdentifier()); 
						JTable table = header.getTable();
						int rowIni;
						int rowCount;
						if (isAllRows) {
							rowIni = 0;
							rowCount = table.getRowCount();
						}
						else {
							rowIni = 0; 
							rowCount = Math.round((float) Math.sqrt(table.getRowCount()/1.00)); 
						}
						 
						int width = (int) header.getDefaultRenderer().getTableCellRendererComponent(
								table, tableColumn.getIdentifier(), false, false, -1, col)
								.getPreferredSize().getWidth(); 
						for(int row = rowIni; row < rowCount; row++) {
							int preferedWidth = (int)table.getCellRenderer(row, col).getTableCellRendererComponent(
									table, table.getValueAt(row, col), false, false, row, col)
									.getPreferredSize().getWidth();
							width = Math.max(width, preferedWidth);
						}
						header.setResizingColumn(tableColumn); // this line is very important 
						tableColumn.setWidth(width + table.getIntercellSpacing().width); 
					}
				}
			};
		}


		/**
		 *JTextField tf = new JTextField(); 
		 tf.setBorder(BorderFactory.createEmptyBorder()); 
		 table.setDefaultEditor(Object.class, new DefaultCellEditor(tf)); 
		 * 
		 * JComboBox combo = new JComboBox(new String[]{"item1", "item2", "item3"}); 
		 combo.setBorder(BorderFactory.createEmptyBorder()); 
		 table.getColumn("B").setCellEditor(new DefaultCellEditor(combo));
		 * 
		 * @return
		 */
		public static Border getEmptyBorder () {
			return BorderFactory.createEmptyBorder();
		}
		
		/*
	    public static void main(String[] args){ 
	        Toolkit.getDefaultToolkit().getSystemEventQueue().push(new MyEventQueue()); 
	        
	        .....
	    } 
		 * */
		public static EventQueue getMyEventQueue () {
			//@author Santhosh Kumar T - santhosh@in.fiorano.com 
			return new MyEventQueue();
		}
		
		
		public static JList getRowHeaderRenderer (final JTable tbl) {
			ListModel lm = new AbstractListModel() {

				public int getSize() {
					// TODO Auto-generated method stub
					return tbl.getRowCount();
				}

				public Object getElementAt(int i) {
					// TODO Auto-generated method stub
					return (i + 1) + "";
				}
			};

			JList rowHeader = new JList(lm);
			rowHeader.setFixedCellWidth(50);
			
			rowHeader.setFixedCellHeight(tbl.getRowHeight()
//						   + tbl.getRowMargin()
					);
//						   + table.getIntercellSpacing().height);
			
			rowHeader.setCellRenderer(new RowHeaderRenderer(tbl));
			
			rowHeader.setDragEnabled(false);

			return rowHeader;
		}
		
}

//@author Santhosh Kumar T - santhosh@in.fiorano.com 
class CutAction extends AbstractAction{ 
    JTextComponent comp; 
 
    public CutAction(JTextComponent comp){ 
        super("Cortar"); 
        this.comp = comp; 
    } 
 
    public void actionPerformed(ActionEvent e){ 
        comp.cut();
    } 
 
    public boolean isEnabled(){ 
        return comp.isEditable() 
                && comp.isEnabled() 
                && comp.getSelectedText()!=null; 
    } 
} 
 
// @author Santhosh Kumar T - santhosh@in.fiorano.com 
class PasteAction extends AbstractAction{ 
    JTextComponent comp; 
 
    public PasteAction(JTextComponent comp){ 
        super("Pegar"); 
        this.comp = comp; 
    } 
 
    public void actionPerformed(ActionEvent e){ 
        comp.paste(); 
    } 
 
    public boolean isEnabled(){ 
        if (comp.isEditable() && comp.isEnabled()){ 
            Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(this);
            return contents.isDataFlavorSupported(DataFlavor.stringFlavor); 
        }else 
            return false; 
    } 
} 
 
// @author Santhosh Kumar T - santhosh@in.fiorano.com 
class DeleteAction extends AbstractAction{ 
    JTextComponent comp; 
 
    public DeleteAction(JTextComponent comp){ 
        super("Borrar"); 
        this.comp = comp; 
    } 
 
    public void actionPerformed(ActionEvent e){ 
        comp.replaceSelection(null); 
    } 
 
    public boolean isEnabled(){ 
        return comp.isEditable() 
                && comp.isEnabled() 
                && comp.getSelectedText()!=null; 
    } 
} 
 
// @author Santhosh Kumar T - santhosh@in.fiorano.com 
class CopyAction extends AbstractAction{ 
    JTextComponent comp; 
 
    public CopyAction(JTextComponent comp){ 
        super("Copiar"); 
        this.comp = comp; 
    } 
 
    public void actionPerformed(ActionEvent e){ 
        comp.copy(); 
    } 
 
    public boolean isEnabled(){ 
        return comp.isEnabled() 
                && comp.getSelectedText()!=null; 
    } 
} 
 
// @author Santhosh Kumar T - santhosh@in.fiorano.com 
class SelectAllAction extends AbstractAction{ 
    JTextComponent comp; 
 
    public SelectAllAction(JTextComponent comp){ 
        super("Seleccionar Todo"); 
        this.comp = comp;
    }
 
    public void actionPerformed(ActionEvent e){ 
        comp.selectAll(); 
    } 
 
    public boolean isEnabled(){ 
        return comp.isEnabled() 
                && comp.getText().length()>0; 
    } 
}

class MyEventQueue extends EventQueue {
    protected void dispatchEvent(AWTEvent event){ 
        super.dispatchEvent(event); 
 
        // interested only in mouseevents 
        if(!(event instanceof MouseEvent)) {
            return;		        	
        }
 
        MouseEvent me = (MouseEvent) event; 
 
        // interested only in popuptriggers 
        if(!me.isPopupTrigger()) {
            return;		        	
        }
	 
        // me.getComponent(...) retunrs the heavy weight component on which event occured 
        Component comp = SwingUtilities.getDeepestComponentAt(me.getComponent(), me.getX(), me.getY()); 
 
        // interested only in textcomponents 
        if(!(comp instanceof JTextComponent)) {
            return;
        }

 
        // no popup shown by user code 
        if(MenuSelectionManager.defaultManager().getSelectedPath().length > 0) {
            return;
        }

        // create popup menu and show 
        JTextComponent tc = (JTextComponent) comp; 
        JPopupMenu menu = new JPopupMenu();
        menu.add(new CutAction(tc));
        menu.add(new CopyAction(tc));
        menu.add(new PasteAction(tc));
        menu.add(new DeleteAction(tc));
        menu.addSeparator();
        menu.add(new SelectAllAction(tc));
        
        Point pt = SwingUtilities.convertPoint(me.getComponent(), me.getPoint(), tc);
        menu.show(tc, pt.x, pt.y);
    } 
}

class RowHeaderRenderer extends JLabel implements ListCellRenderer {
	  RowHeaderRenderer(JTable table) {
		JTableHeader header = table.getTableHeader();
		setOpaque(true);
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		setHorizontalAlignment(CENTER);
		setForeground(header.getForeground());
		setBackground(header.getBackground());
		setFont(header.getFont());
	  }
	  
	  public Component getListCellRendererComponent( JList list, 
		     Object value, int index, boolean isSelected, boolean cellHasFocus) {
		setText((value == null) ? "" : value.toString());
		return this;
	  }
	  
}
