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

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * ShortcutWindow which provides easy access to different windows
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
@SuppressWarnings("serial")
public class ShortcutWindow extends JFrame {

    public ShortcutWindow() {
        super();
    }
    
    /**
     * creates the ShortcutWindow
     */
    public void createShortcutWindow() {
        this.setTitle("Shortcut");
        GUIHelper.sizeAndCenterFrame(this, 250, 50);
        GUIHelper.setESCCloseable(this);
        this.setLayout(new BorderLayout());
        this.add(createInputField(), BorderLayout.NORTH);
    }
    
    /**
     * creates the input field where the user can enter a shortcut. The field
     * doesn't need a button since pressing ENTER is enough.
     */
    private JTextField createInputField() {
        final JTextField input = new JTextField();
        input.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    processShortcut(input.getText());
                    closeShortcutWindow();
                }
            }
        });
        return input;
    }
    
    /**
     * processes the shortcut and calls the appropriate window
     * 
     * TODO: use enums for types?
     * 
     * @param aShortcut text of the input field
     */
    private void processShortcut(String aShortcut) {
        if (aShortcut.equals("CUST_OVER")) {
            new CustomerOverviewWindow(750, 450).createAndShowWindow();
        }
    }
    
    /**
     * shows the ShortcutWindow
     */
    public void showShortcutWindow() {
        GUIHelper.showComponent(this);
    }
    
    /**
     * closes the ShortcutWindow
     */
    public void closeShortcutWindow() {
        this.dispose();
    }

}
