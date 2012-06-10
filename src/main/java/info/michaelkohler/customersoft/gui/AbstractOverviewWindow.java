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
    
    private String _title;
    private int _width;
    private int _height;
    
    /**
     * Constructor (should not used except by subclasses)
     * 
     * @param aWidth defining the width of the window
     * @param aHeight defining the height of the window
     */
    protected AbstractOverviewWindow(String aTitle, int aWidth, int aHeight) {
        _title = aTitle;
        _width = aWidth;
        _height = aHeight;
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
        GUIHelper.showComponent(this);
    }
    
    /**
     * adds the standard menu bar which is used by every window with a menu bar.
     */
    private void addStandardMenubar() {
        this.setJMenuBar(new StandardMenuBar());
    }
    
    /**
     * abstract method which creates the content (delegated to the subclass)
     */
    protected abstract JPanel createContentPanel();
}
