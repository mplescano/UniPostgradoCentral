package visual.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JRootPane;

//CONTENT  : CLASS SwingUtil
//AUTHOR   : Manfred Duchrow
//VERSION  : 1.3 - 03/07/2004
//HISTORY  :
//31/05/2002  duma  CREATED
//	08/06/2002	duma	added		->	setSystemLookAndFeel()
//	06/06/2004	mdu		added		->	findComponent(..)
//	19/06/2004	mdu		added		->	centerWindow()
//	03/07/2004	mdu		changed	->  Support menus in findComponent(..)
//
//Copyright (c) 2002-2004, by Manfred Duchrow. All rights reserved.
//===========================================================================

/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 * 
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, 
 * USA.  
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 * 
 * ----------------------
 * RefineryUtilities.java
 * ----------------------
 * (C) Copyright 2000-2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   Jon Iles;
*/

public class WindowUtils {

	
    /**
     * Positions the specified frame in the middle of the screen.
     *
     * @param frame  the frame to be centered on the screen.
     */
    public static void centerFrameOnScreen(final Window frame) {
        positionFrameOnScreen(frame, 0.5, 0.5);
    }
	
    /**
     * Positions the specified frame at a relative position in the screen, where 50% is considered
     * to be the center of the screen.
     *
     * @param frame  the frame.
     * @param horizontalPercent  the relative horizontal position of the frame (0.0 to 1.0,
     *                           where 0.5 is the center of the screen).
     * @param verticalPercent  the relative vertical position of the frame (0.0 to 1.0, where
     *                         0.5 is the center of the screen).
     */
    public static void positionFrameOnScreen(final Window frame,
                                             final double horizontalPercent,
                                             final double verticalPercent) {

        final Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension f = frame.getSize();
        final int w = Math.max(s.width - f.width, 0);
        final int h = Math.max(s.height - f.height, 0);
        final int x = (int) (horizontalPercent * w);
        final int y = (int) (verticalPercent * h);
        frame.setBounds(x, y, f.width, f.height);

    }
    
    /**
     * Positions the specified frame at a random location on the screen while ensuring that the
     * entire frame is visible (provided that the frame is smaller than the screen).
     *
     * @param frame  the frame.
     */
    public static void positionFrameRandomly(final Window frame) {
        positionFrameOnScreen(frame, Math.random(), Math.random());
    }
    
    /**
     * Positions the specified dialog within its parent.
     *
     * @param dialog  the dialog to be positioned on the screen.
     */
    public static void centerDialogInParent(final Dialog dialog) {
        positionDialogRelativeToParent(dialog, 0.5, 0.5);
    }
    
    /**
     * Positions the specified dialog at a position relative to its parent.
     *
     * @param dialog  the dialog to be positioned.
     * @param horizontalPercent  the relative location.
     * @param verticalPercent  the relative location.
     */
    public static void positionDialogRelativeToParent(final Dialog dialog,
                                                      final double horizontalPercent,
                                                      final double verticalPercent) {
        final Dimension d = dialog.getSize();
        final Container parent = dialog.getParent();
        final Dimension p = parent.getSize();

        final int baseX = parent.getX() - d.width;
        final int baseY = parent.getY() - d.height;
        final int w = d.width + p.width;
        final int h = d.height + p.height;
        int x = baseX + (int) (horizontalPercent * w);
        int y = baseY + (int) (verticalPercent * h);

        // make sure the dialog fits completely on the screen...
        final Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
        x = Math.min(x, (s.width - d.width));
        x = Math.max(x, 0);
        y = Math.min(y, (s.height - d.height));
        y = Math.max(y, 0);

        dialog.setBounds(x, y, d.width, d.height);
    }
    
	/**
	 * Change the given window's upper left corner coordinates, so that it will be
	 * shown in the center of the screen according to the specified width
	 * and height.
	 * 
	 * @param window The window that must be centered
	 * @param width The width of the window
	 * @param height The height of the window
	 */
	public static void centerWindow( Window window, int width, int height ) {
		Dimension screenSize = null;
		int xpos = 1;
		int ypos = 1;

		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		xpos = (screenSize.width - width) / 2;
		ypos = (screenSize.height - height) / 2;

		window.setBounds(xpos, ypos, width, height);
	} // centerWindow()
	
	/**
	 * Change the given window's upper left corner coordinates, so that it will be
	 * shown in the center of the screen.
	 * 
	 * @param window The window that must be centered
	 */
	public static void centerWindow( Window window ) {
		centerWindow( window, window.getWidth(), window.getHeight() ) ;
	} // centerWindow() 
	
	/**
	 * Change the given frame's upper left corner coordinates, so that it will be
	 * shown in the center of the screen according to the specified width
	 * and height.
	 * 
	 * @param frame The frame that must be centered
	 * @param width The width of the frame
	 * @param height The height of the frame
	 */
	public static void centerFrame( JFrame frame, int width, int height ) {
		centerWindow( frame, width, height ) ;
	} // centerFrame() 
	
	/**
	 * Change the given frames upper left corner coordinates, so that it will be
	 * shown in the center of the screen.
	 * 
	 * @param frame The frame that must be centered
	 */
	public static void centerFrame( JFrame frame ) {
		centerWindow( frame ) ;
	} // centerFrame() 
}
