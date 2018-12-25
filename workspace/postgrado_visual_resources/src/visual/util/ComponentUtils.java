package visual.util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JRootPane;

public class ComponentUtils {
	/**
	 * Searches for the component with the specified name in the given 
	 * container and all sub containers.
	 * Returns null if the component cannot be found, otherwise the found 
	 * component.
	 * 
	 * @param container The container in which to search
	 * @param componentName The name of the component 
	 */
	public Component findComponent( Container container, String componentName ) {
		return this.findComponent( container, null, componentName ) ;
	} // findComponent() 
	
	// -------------------------------------------------------------------------
	
	/**
	 * Searches for the component with the specified type and name in the given 
	 * container and all sub containers.
	 * Returns null if the component cannot be found, otherwise the found 
	 * component.
	 * 
	 * @param container The container in which to search
	 * @param componentType The type of the component (may be null)
	 * @param componentName The name of the component (may be null)
	 */
	public Component findComponent( Container container, Class componentType, String componentName ) {
		Component component = null;
		Component[] components;
		
	  components = this.componentsOf( container ) ;
	  if ( components != null ) {
			for (int i = 0; i < components.length; i++ ) {
				if ( componentType != null ) {
					if ( componentType.isInstance( components[i] ) ) {
						if ( componentName != null ) {
							if ( componentName.equals( components[i].getName() ) ) {
								component = components[i] ;
							}
						}
						else {
							component = components[i] ;
						}
					}
				}
				else {
					if ( componentName != null ) {
						if ( componentName.equals( components[i].getName() ) ) {
							component = components[i] ;
						}
					}
				}
				if ( ( component == null ) && ( components[i] instanceof Container ) ) {
					component = this.findComponent( (Container)components[i], componentType, componentName ) ;
				}
				if ( component != null ) {
					return component ;
				}
			}
	  }
	  if ( container instanceof JRootPane ) {
	  	JRootPane pane = (JRootPane)container ;
			return this.findComponent( pane.getJMenuBar(), componentType, componentName ) ;
		}
	  return null;
	} // findComponent() 

  // -------------------------------------------------------------------------
	
	
  // =========================================================================
  // PROTECTED INSTANCE METHODS
  // =========================================================================
	protected Component[] componentsOf( Container container ) {
	  if ( container instanceof JMenu ) {
	  	JMenu menu = (JMenu)container;
			return menu.getMenuComponents();
		}
		return container.getComponents() ;
	} // componentsOf()

}