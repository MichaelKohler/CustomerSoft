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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An abstract window which provides a simple overview window. This has nothing
 * to do with the content of a window, it's just the window itself.
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */

@SuppressWarnings("serial")
public abstract class AbstractOverviewWindow extends JFrame {
    
    public enum ButtonLayout {
        OK_BUTTON, CANCEL_BUTTON, OK_CANCEL_BUTTONS,
        NO_BUTTONS
    }
    
    private String _title;
    private int _width;
    private int _height;
    private ButtonLayout _layout;
    
    /**
     * Constructor (should not used except by subclasses)
     * 
     * @param aWidth defining the width of the window
     * @param aHeight defining the height of the window
     */
    protected AbstractOverviewWindow(String aTitle, int aWidth, int aHeight,
                                                     ButtonLayout aLayout) {
        _title = aTitle;
        _width = aWidth;
        _height = aHeight;
        _layout = aLayout;
    }
    
    /**
     * Creates and shows the window
     */
    public void createAndShowWindow() {
        this.setTitle(_title);
        GUIHelper.sizeAndCenterFrame(this, _width, _height);
        GUIHelper.setESCCloseable(this);
        addStandardMenubar();
        this.add(createContentPanel());
        
        if (_layout != ButtonLayout.NO_BUTTONS) {
            this.add(createLowerPanel(), BorderLayout.SOUTH);
        }
        
        GUIHelper.showComponent(this);
    }
    
    /**
     * adds the standard menu bar which is used by every window with a menu bar.
     */
    private void addStandardMenubar() {
        this.setJMenuBar(new StandardMenuBar());
    }
    
    /**
     * creates the lower panel for the functions and buttons.
     * 
     * @return lowerPanel which needs to be added to the window
     */
    private JPanel createLowerPanel() {
        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        lowerPanel.add(addButtonPanel(), BorderLayout.EAST);
        return lowerPanel;
    }
    
    /**
     * adds the desired buttons to the window (lower right corner)
     * 
     * TODO: clean up -> there should be a way to make this cleaner
     * 
     * @return buttonPanel which needs to be added to the lower part
     *                              of the window
     */
    private JPanel addButtonPanel() {
            JPanel buttonPanel = new JPanel(new BorderLayout());
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    processClickOnOK();
                }
            });
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    processClickOnCancel();
                }
            });
            
            switch (_layout) {
                case OK_BUTTON:
                    buttonPanel.add(okButton, BorderLayout.EAST);
                    break;
                case CANCEL_BUTTON:
                    buttonPanel.add(cancelButton, BorderLayout.EAST);
                    break;
                case OK_CANCEL_BUTTONS:
                    buttonPanel.add(okButton, BorderLayout.WEST);
                    buttonPanel.add(cancelButton, BorderLayout.EAST);
                    break;
            }
            
            return buttonPanel;
    }
    
    /**
     * abstract method which creates the content (delegated to the subclass)
     */
    protected abstract JPanel createContentPanel();
    
    /**
     * abstract method which processes the click on the OK button (delegated
     * to the subclass)
     */
    protected abstract void processClickOnOK();
    
    /**
     * Handles the click on the Cancel button. This can be overwritten by the sub-
     * class if just closing the window is not enough.
     */
    protected void processClickOnCancel() {
        this.dispose();
    }
}
