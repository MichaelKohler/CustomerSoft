package info.michaelkohler.customersoft.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class StandardMenuBar extends JMenuBar {
    private static final int MENUITEM_WIDTH = 150;
    private static final int MENUITEM_HEIGHT = 20;
    private static final Color BORDER_COLOR = new Color(160, 160, 160);
    
    public StandardMenuBar() {
        this.add(createFileMenu());
        this.add(createSubsystemsMenu());
        this.add(createHelpMenu());
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
        
        JMenu newItem = new JMenu("New");
        newItem.setMnemonic('N');
        JMenuItem customerItem = new JMenuItem("Customer...", 'C');
        customerItem.setPreferredSize(new Dimension(MENUITEM_WIDTH, MENUITEM_HEIGHT));
        customerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        customerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Customer called");
            }
        });
        newItem.add(customerItem);
        JMenuItem productItem = new JMenuItem("Product...", 'P');
        productItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Product called");
            }
        });
        newItem.add(productItem);
        menu.add(newItem);
        
        JMenuItem shortcutItem = new JMenuItem("Jump...", 'J');
        shortcutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
        shortcutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Shortcut called");
            }
        });
        menu.add(shortcutItem);
        JMenuItem importItem = new JMenuItem("Import...", 'I');
        importItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Import called");
            }
        });
        menu.add(importItem);
        JMenuItem exportItem = new JMenuItem("Export...", 'X');
        exportItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Export called");
            }
        });
        menu.add(exportItem);
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
        
        JMenu customerItem = new JMenu("Customer");
        JMenuItem searchItem = new JMenuItem("Search...", 'S');
        searchItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
        searchItem.setPreferredSize(new Dimension(MENUITEM_WIDTH, MENUITEM_HEIGHT));
        searchItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Search called");
            }
        });
        customerItem.add(searchItem);
        JMenuItem ratingItem = new JMenuItem("Rating...", 'R');
        ratingItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Rating called");
            }
        });
        customerItem.add(ratingItem);
        JMenuItem tasksItem = new JMenuItem("Tasks...", 'T');
        tasksItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Tasks called");
            }
        });
        customerItem.add(tasksItem);
        menu.add(customerItem);
        
     // Permission!
        JMenuItem productsItem = new JMenuItem("Products...", 'P');
        productsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Products called");
            }
        });
        menu.add(productsItem);
        
        // Permission!
        JMenuItem paramItem = new JMenuItem("Parameter", 'a');
        paramItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Params called");
            }
        });
        menu.add(paramItem);
        // Permission!
        JMenuItem usersItem = new JMenuItem("User Management", 'U');
        usersItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Users called");
            }
        });
        menu.add(usersItem);
        // Permission!
        JMenuItem backupItem = new JMenuItem("Backups", 'B');
        backupItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Users called");
            }
        });
        menu.add(backupItem);
        JMenuItem settingsItem = new JMenuItem("Settings", 'S');
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
        JMenuItem updatesItem = new JMenuItem("Updates", 'U');
        updatesItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("About called");
            }
        });
        menu.add(updatesItem);
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
