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

import info.michaelkohler.helpertools.Debugger;
import java.awt.Component;
import java.awt.Dimension;
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
    
    private static final int BOUND_WIDTH = 150;
    private static final int BOUND_HEIGHT = 150;

    /**
     * makes the component visible.
     * 
     * @param component which component should be visible
     */
    public static void showComponent(Component component) {
        component.setVisible(true);
    }

    /**
     * makes the component invisible.
     * 
     * @param component which component should be invisible
     */
    public static void hideComponent(Component component) {
        component.setVisible(false);
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
     * @param frame which needs to be sized
     */
    public static void sizeFrame(JFrame frame) {
        Dimension dim = frame.getToolkit().getScreenSize();
        frame.setSize(dim.width / 2 + BOUND_WIDTH, dim.height / 2 + BOUND_HEIGHT);
    }

    /**
     * centers the JFrame
     * 
     * @param frame which needs to be centered
     */
    public static void centerFrame(JFrame frame) {
        Dimension dim = frame.getToolkit().getScreenSize();
        frame.setLocation(dim.width / 4 - BOUND_WIDTH / 2, dim.height / 4 - BOUND_HEIGHT / 2);
    }

    /**
     * makes the JFrame closeable with ESC key.
     * 
     * @param component which needs to be closeable with the ESC key
     */
    @SuppressWarnings("serial")
    public static void setESCCloseable(final JFrame frame) {
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        }; 
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        frame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
    }

}
