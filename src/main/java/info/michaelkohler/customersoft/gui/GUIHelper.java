package info.michaelkohler.customersoft.gui;

/*
 * CustomerSoft
 * Copyright (C) 2012  Michael Kohler <michaelkohler@linux.com>

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import info.michaelkohler.helpertools.logging.Debugger;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 * GUI Helper for the project. It makes different helper methods available
 * to the other classes.
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
public class GUIHelper {

    /**
     * makes the component visible.
     * 
     * @param aComponent which component should be visible
     */
    public static void showComponent(Component aComponent) {
        aComponent.setVisible(true);
    }

    /**
     * makes the component invisible.
     * 
     * @param aComponent which component should be invisible
     */
    public static void hideComponent(Component aComponent) {
        aComponent.setVisible(false);
    }
    
    /**
     * makes the application pretty using the standard OS design.
     * 
     */
    public static void prettify() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Debugger.logMessage(ex);
        }
    }

    /**
     * sizes the JFrame
     * 
     * @param aFrame which needs to be sized
     * @param aWidth defining the width of the window
     * @param aHeight defining the height of the window
     */
    public static void sizeAndCenterFrame(JFrame aFrame, int aWidth, int aHeight) {
        aFrame.setSize(aWidth, aHeight);
        aFrame.setLocationRelativeTo(null);
    }

    /**
     * makes the JFrame closeable with ESC key.
     * 
     * @param aFrame which needs to be closeable with the ESC key
     */
    @SuppressWarnings("serial")
    public static void setESCCloseable(final JFrame aFrame) {
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0,
                                                                                  false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                aFrame.dispose();
            }
        }; 
        aFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                  .put(escapeKeyStroke, "ESCAPE");
        aFrame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
    }

}
