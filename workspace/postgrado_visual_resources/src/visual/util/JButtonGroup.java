package visual.util;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

public class JButtonGroup extends ButtonGroup {
	private Map values = new HashMap();
	
	/**
	 *	Stores a reference to the currently selected button in the group
	 */
	private AbstractButton selectedButton;
	
	/** 
	 *	Creates an empty <code>JButtonGroup</code>
	 */
	public JButtonGroup() {
			super();
	}
	
	/** 
	 *	Creates a <code>JButtonGroup</code> object from an array of buttons and adds the buttons to the group
	 *	No button will be selected initially.
	 *	@param buttons an array of <code>AbstractButton</code>s
	 */
	public JButtonGroup(AbstractButton[] buttons) {
			add(buttons);
	}
	
	/**	
	 *	Adds a button to the group
	 *	@param button an <code>AbstractButton</code> reference
	 */
	public void add(AbstractButton button) {
		if (button == null || buttons.contains(button)) return;
		super.add(button);
		if (getSelection() == button.getModel()) {
			selectedButton = button;
		}
	}
	
	public void add(AbstractButton button, Object value) {
		add(button);
		if (!values.containsValue(value)) {
			values.put(button, value);
		}
		else {
			throw new IllegalArgumentException("Valor de clave ya repetido");
		}
	}
	
	/** 
	 *	Adds an array of buttons to the group
	 *	@param buttons an array of <code>AbstractButton</code>s
	 */
	public void add(AbstractButton[] buttons) {
		if (buttons == null) return;
		for (int i=0; i<buttons.length; i++) {
				add(buttons[i]);
		}
	}

	/**	
	 *	Removes a button from the group
	 *	@param button the button to be removed
	 */
	public void remove(AbstractButton button) {
		if (button != null) {
				if (selectedButton == button) selectedButton = null;
				super.remove(button);
				values.remove(button);
		}
	}
	
	/**	
	 *	Removes all the buttons in the array from the group
	 *	@param buttons an array of <code>AbstractButton</code>s
	 */
	public void remove(AbstractButton[] buttons) {
		if (buttons == null) return;
		for (int i=0; i<buttons.length; i++) {
				remove(buttons[i]);
				values.remove(buttons[i]);
		}
	}
	
	/** 
	 *	Sets the selected button in the group
	 *	Only one button in the group can be selected
	 *	@param button an <code>AbstractButton</code> reference
	 *	@param selected an <code>boolean</code> representing the selection state of the button
	 */
	public void setSelected(AbstractButton button, boolean selected) {
		if (button != null && buttons.contains(button)) {
				setSelected(button.getModel(), selected);
				/*
				if (getSelection() == button.getModel()) {
					selectedButton = button;
				}
				if (getSelection() == null) {
					selectedButton = null;
				}*/
		}
	}

	public void setSelectedByValue(Object value, boolean selected) {
		Set keys = values.keySet();
		AbstractButton button = null;
		for (Iterator it = keys.iterator(); it.hasNext();) {
			Object obValue = values.get(it);
			if (obValue == value || obValue.equals(value)) {
				button = (AbstractButton) it;
				break;
			}
		}
		setSelected(button, selected);
	}
	
	/** 
	 *	Sets the selected button model in the group
	 *	@param model a <code>ButtonModel</code> reference
	 *	@param selected an <code>boolean</code> representing the selection state of the button
	 */
	public void setSelected(ButtonModel model, boolean selected) {
		AbstractButton button = getButton(model);
		if (buttons.contains(button)) {
			super.setSelected(model, selected);
			if (getSelection() == button.getModel()) {
				selectedButton = button;
			}
			if (getSelection() == null) {
				selectedButton = null;
			}
			/*
			if (!selected && getSelection() == model) {
				button.setSelected(false);
			}*/
		}
	}
	
	/** 
	 *	Returns the <code>AbstractButton</code> whose <code>ButtonModel</code> is given.
	 *	If the model does not belong to a button in the group, returns null.
	 *	@param model a <code>ButtonModel</code> that should belong to a button in the group
	 *	@return an <code>AbstractButton</code> reference whose model is <code>model</code> if the button belongs to the group, <code>null</code>otherwise
	 */
	public AbstractButton getButton(ButtonModel model) {
		Iterator it = buttons.iterator();
		while (it.hasNext()) {
				AbstractButton ab = (AbstractButton)it.next();
				if (ab.getModel() == model) return ab;
		}
		return null;
	}
	
	public AbstractButton getButtonByValue (Object value) {
		Iterator it = buttons.iterator();
		while (it.hasNext()) {
				AbstractButton ab = (AbstractButton)it.next();
				//if (ab.getModel() == model) return ab;
				Object ob = values.get(ab);
				if (ob == value || ob.equals(value)) return ab;
		}
		return null;
	}

	/** 
	 *	Returns the selected button in the group.
	 *	@return a reference to the currently selected button in the group or <code>null</code> if no button is selected
	 */
	public AbstractButton getSelected() {
		return selectedButton;
	}
	
	public Object getSelectedByValue() {
		return values.get(selectedButton);
	}
	
	/** 
	 *	Returns whether the button is selected
	 *	@param button an <code>AbstractButton</code> reference
	 *	@return <code>true</code> if the button is selected, <code>false</code> otherwise
	 */
	public boolean isSelected(AbstractButton button) {
		return button == selectedButton;
	}
	
	public boolean isSelectedByValue(Object value) {
		Set keys = values.keySet();
		AbstractButton button = null;
		for (Iterator it = keys.iterator(); it.hasNext();) {
			Object obValue = values.get(it);
			if (obValue == value || obValue.equals(value)) {
				button = (AbstractButton) it;
				break;
			}
		}
		return isSelected(button);
	}
	
	/** 
	 *	Returns the buttons in the group as a <code>List</code>
	 *	@return a <code>List</code> containing the buttons in the group, in the order they were added to the group
	 */
	public List getButtons() {
		return Collections.unmodifiableList(buttons);
	}
	
	public Collection getValues () {
		return Collections.unmodifiableCollection(values.values());
	}
	
	/**
	 *	Checks whether the group contains the given button
	 *	@return <code>true</code> if the button is contained in the group, <code>false</code> otherwise
	 */
	public boolean contains(AbstractButton button) {
		return buttons.contains(button);
	}
	
	public void addActionListener (ActionListener al) {
		Iterator it = buttons.iterator();
		while (it.hasNext()) {
			AbstractButton ab = (AbstractButton)it.next();
			ab.addActionListener(al);
		}
	}
	
	public void addChangeListener (ChangeListener cl) {
		Iterator it = buttons.iterator();
		while (it.hasNext()) {
			AbstractButton ab = (AbstractButton)it.next();
			ab.addChangeListener(cl);
		}
	}
	
	public void addItemListener (ItemListener il) {
		Iterator it = buttons.iterator();
		while (it.hasNext()) {
			AbstractButton ab = (AbstractButton)it.next();
			ab.addItemListener(il);
		}
	}
	
	public void setEnabled (boolean enabled) {
		Iterator it = buttons.iterator();
		while (it.hasNext()) {
			AbstractButton ab = (AbstractButton)it.next();
			ab.setEnabled(enabled);
			if (!enabled) {
				ab.setSelected(false);
			}
		}
	}
}