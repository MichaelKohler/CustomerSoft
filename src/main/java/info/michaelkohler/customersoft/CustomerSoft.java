package info.michaelkohler.customersoft;

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

import info.michaelkohler.customersoft.gui.GUIHelper;
import info.michaelkohler.customersoft.gui.MainWindow;

/**
 * Main Class of the project. It is responsible to run the application.
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
public class CustomerSoft {

    /**
     * Main method responsible to open the main window.
     * 
     * @param args
     */
    public static void main(String[] args) {
        GUIHelper.prettify();
        createMainWindow();
    }

    /**
     * creates the main window.
     */
    private static void createMainWindow() {
        MainWindow mainWindow = new MainWindow();
        GUIHelper.hideComponent(mainWindow);
        mainWindow.createMainWindowGUI();
        GUIHelper.showComponent(mainWindow);
    }

}
