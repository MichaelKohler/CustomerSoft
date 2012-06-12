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
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ParameterWindow which provides a simple way to configure the
 * application.
 * 
 * TODO:
 *   * Get Data
 *   * Observer to see when the selectedIndex changed -> Update TextFields
 *   * Actions on the buttons
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
@SuppressWarnings("serial")
public class ParameterWindow extends JFrame {
    /**
     * Constructor which assembles the shortcut window
     * 
     * @param aWindowFactory which delivers instances of the windows
     */
    public ParameterWindow() {
        super();
    }
    
    /**
     * creates the ParameterWindow
     */
    public void initAndShowWindow() {
        this.setTitle("Parameters");
        GUIHelper.sizeAndCenterFrame(this, 650, 520);
        GUIHelper.setESCCloseable(this);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(createParameterTable(), BorderLayout.NORTH);
        this.add(createInputPanel("bla", "blubb"), BorderLayout.CENTER);
        GUIHelper.showComponent(this);
    }
    
    /**
     * creates the JTable where all the values of the parameters
     * are shown.
     */
    private ScrollableTable createParameterTable() {
        String[] names = getColumnNames();
        String[][] data = getData();
        return new ScrollableTable(data, names);
    }
    
    /**
     * gets the column names for the table
     * 
     * @return names which should be displayed
     */
    private String[] getColumnNames() {
        String[] names = { "Test1", "Test2", "Test3", "Test4" };
        return names;
    }
    
    /**
     * gets the data for the table
     * 
     * @return data which needs to be shown inside the table
     */
    private String[][] getData() {
        String[][] data = {
                { "foo1", "foo2", "foo3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" },
                { "bar1", "bar2", "bar3", "blubb" }
        };
        return data;
    }
    
    /**
     * creates the input fields where the user can enter a new value
     */
    private JPanel createInputPanel(String aKey, String aValue) {
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JLabel keyLabel = new JLabel("Key:");
        panel.add(keyLabel);
        JTextField keyField = new JTextField(aKey);
        keyField.setEditable(false);
        panel.add(keyField);
        JLabel valueLabel = new JLabel("Value:");
        panel.add(valueLabel);
        JTextField valueField = new JTextField(aValue);
        panel.add(valueField);
        JButton saveButton = new JButton("Save");
        panel.add(saveButton);
        JButton restoreButton = new JButton("Restore to default");
        panel.add(restoreButton);
        return panel;
    }
}
