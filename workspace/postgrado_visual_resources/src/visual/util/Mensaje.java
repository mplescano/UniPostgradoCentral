package visual.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public final class Mensaje {
	
	public static void error (Component c, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(c, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static void warning (Component c, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(c, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}
	
	public static void info (Component c, String mensaje, String titulo) {
		JOptionPane.showMessageDialog(c, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int confirmar (Component c, String mensaje, String titulo) {
		return JOptionPane.showConfirmDialog(c,mensaje,titulo,JOptionPane.YES_NO_OPTION);
	}
	
	
}
