package info.michaelkohler.customersoft.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
 * The CustomerOverviewWindow is responsible for displaying the customer overview.
 * One window means details of one customer.
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
@SuppressWarnings("serial")
public class CustomerOverviewWindow extends AbstractOverviewWindow {

    /**
     * Constructor which calls the superclass' constructor with the desired
     * window size.
     */
    public CustomerOverviewWindow(String aTitle, int aWidth, int aHeight) {
        super(aTitle, aWidth, aHeight);
    }

    @Override
    protected JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        String[] columnNames = { "Test1", "Test2", "Test3" };
        String[][] data = {
                { "foo1", "foo2", "foo3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" }
        };
        
        JTable overviewTable = new JTable(data, columnNames);
        overviewTable.setGridColor(new Color(230, 230, 230));
        JScrollPane scrollPane = new JScrollPane(overviewTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }

}
