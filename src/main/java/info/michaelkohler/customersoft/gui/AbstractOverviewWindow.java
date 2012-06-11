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
        addButtons();
        GUIHelper.showComponent(this);
    }
    
    /**
     * adds the standard menu bar which is used by every window with a menu bar.
     */
    private void addStandardMenubar() {
        this.setJMenuBar(new StandardMenuBar());
    }
    
    /**
     * adds the desired buttons to the window (lower right corner)
     */
    private void addButtons() {
        if (_layout != ButtonLayout.NO_BUTTONS) {
            JPanel lowerPanel = new JPanel(new BorderLayout());
            lowerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            JPanel buttonPanel = new JPanel(new BorderLayout());
            
            switch (_layout) {
                case OK_BUTTON:
                    JButton okButton = new JButton("OK");
                    buttonPanel.add(okButton, BorderLayout.EAST);
                    break;
                case CANCEL_BUTTON:
                    JButton cancelButton = new JButton("Cancel");
                    buttonPanel.add(cancelButton, BorderLayout.EAST);
                    break;
                case OK_CANCEL_BUTTONS:
                    JButton okButtonBoth = new JButton("OK");
                    buttonPanel.add(okButtonBoth, BorderLayout.WEST);
                    JButton cancelButtonBoth = new JButton("Cancel");
                    buttonPanel.add(cancelButtonBoth, BorderLayout.EAST);
                    break;
            }
            
            lowerPanel.add(buttonPanel, BorderLayout.EAST);
            this.add(lowerPanel, BorderLayout.SOUTH);
        }
    }
    
    /**
     * abstract method which creates the content (delegated to the subclass)
     */
    protected abstract JPanel createContentPanel();
}
