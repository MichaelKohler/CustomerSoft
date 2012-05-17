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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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

    private final int MENUITEM_WIDTH = 200;
    private final int MENUITEM_HEIGHT = 20;
    private final Color BORDER_COLOR = new Color(160, 160, 160);

    public MainWindow() {
        super();
    }

    public void createMainWindowGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("CustomerSoft - Main (History)");
        GUIHelper.setESCCloseable(this);
        GUIHelper.centerFrame(this);
        GUIHelper.sizeFrame(this);
        
        createContent();
        createMenuBar();
    }

    /**
     * Creates the content of the Main Window.
     */
    private void createContent() {
        // TODO Auto-generated method stub
        
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMI = createFileMenu();
        menuBar.add(fileMI);
        JMenu subsystemMI = createSubsystemsMenu();
        menuBar.add(subsystemMI);
        JMenu helpMI = createHelpMenu();
        menuBar.add(helpMI);
        this.setJMenuBar(menuBar);
    }

    /**
     * Creates the file menu.
     * 
     * @return menu which needs to be added to the bar
     */
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");
        menu.setMnemonic('F');
        menu.getPopupMenu().setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        
        JMenuItem exitItem = new JMenuItem("Exit", 'E');
        exitItem.setPreferredSize(new Dimension(MENUITEM_WIDTH, MENUITEM_HEIGHT));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menu.add(exitItem);
        
        return menu;
    }

    /**
     * Creates the extras menu.
     * 
     * @return menu which needs to be added to the bar
     */
    private JMenu createSubsystemsMenu() {
        JMenu menu = new JMenu("Subsystems");
        menu.setMnemonic('S');
        menu.getPopupMenu().setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        
        JMenuItem settingsItem = new JMenuItem("Settings", 'S');
        settingsItem.setPreferredSize(new Dimension(MENUITEM_WIDTH, MENUITEM_HEIGHT));
        settingsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Settings called");
            }
        });
        menu.add(settingsItem);
        
        return menu;
    }

    /**
     * Creates the help menu.
     * 
     * @return menu which needs to be added to the bar
     */
    private JMenu createHelpMenu() {
        JMenu menu = new JMenu("Help");
        menu.setMnemonic('H');
        menu.getPopupMenu().setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        
        JMenuItem helpItem = new JMenuItem("Help", 'H');
        helpItem.setPreferredSize(new Dimension(MENUITEM_WIDTH, MENUITEM_HEIGHT));
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Help called!");
            }
        });
        menu.add(helpItem);
        JMenuItem aboutItem = new JMenuItem("About", 'A');
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("About called");
            }
        });
        menu.add(aboutItem);
        
        return menu;
    }

}
