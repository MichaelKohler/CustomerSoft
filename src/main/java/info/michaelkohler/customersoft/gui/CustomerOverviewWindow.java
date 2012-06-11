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

import javax.swing.JPanel;

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
    public CustomerOverviewWindow(String aTitle, int aWidth, int aHeight,
                                                  ButtonLayout aLayout) {
        super(aTitle, aWidth, aHeight, aLayout);
    }

    @Override
    protected JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        final String[] columnNames = { "Test1", "Test2", "Test3" };
        final String[][] data = {
                { "foo1", "foo2", "foo3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" },
                { "bar1", "bar2", "bar3" }
        };
        
        ScrollableTable scrollableTablePane = new ScrollableTable(data, columnNames);
        panel.add(scrollableTablePane, BorderLayout.CENTER);
        return panel;
    }

}
