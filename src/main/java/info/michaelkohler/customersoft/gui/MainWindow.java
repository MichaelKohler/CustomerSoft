package info.michaelkohler.customersoft.gui;

import javax.swing.JFrame;

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

/**
 * Main Window of the project. It is responsible to provide a home
 * screen for the application.
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    public MainWindow() {
        super();
    }

    public void createMainWindowGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("CustomerSoft - Main (History)");
        GUIHelper.setESCCloseable(this);
        GUIHelper.sizeAndCenterFrame(this, 650, 450);
        
        createContent();
        this.setJMenuBar(new StandardMenuBar());
    }

    /**
     * Creates the content of the Main Window.
     */
    private void createContent() {
        // TODO Auto-generated method stub
        
    }

}
