package visual.util;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;
import javax.swing.text.JTextComponent;

public class RadioButtonUtils {
	public static ItemListener addTexComponentListener (final JRadioButton rb, final JTextComponent tf) {
		return new ItemListener () {
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getItem() instanceof JRadioButton) {
					JRadioButton rbItem = (JRadioButton) e.getItem();
					if (rbItem == rb) {
						if (!rb.isSelected()) {
							tf.setText("");
							tf.setEditable(false);
						}
						else {
							tf.setEditable(true);
						}
					}
					else {
						tf.setEditable(false);
					}
				}
			}
	    };
	}
}