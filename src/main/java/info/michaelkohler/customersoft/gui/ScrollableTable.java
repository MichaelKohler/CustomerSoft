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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * The ScrollableTable is responsible to produce a scrollable table with
 * the given data input. It automatically adds a JTable to a JScrollPane
 * which then can be used further.
 * 
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */

@SuppressWarnings("serial")
public class ScrollableTable extends JScrollPane {

    /**
     * Constructor which initializes the component.
     * 
     * @param aData specifying the data which should be displayed in the table
     * @param aColumnNames specifying the column names
     */
    public ScrollableTable(String[][] aData, String[] aColumnNames) {
        super();

        TableModel model = getTableModel(aData, aColumnNames);
        JTable overviewTable = new JTable(model);
        overviewTable.setGridColor(new Color(240, 240, 240));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        overviewTable.setRowSorter(sorter);

        this.setViewportView(overviewTable);
    }
    
    /**
     * Produces the TableModel which is used by the table. This is a standard
     * model.
     * 
     * @param aData specifying the data which should be displayed in the table
     * @param aColumnNames specifying the column names
     * @return model which was produced
     */
    private TableModel getTableModel(String[][] aData, String[] aColumnNames) {
        TableModel model = new DefaultTableModel(aData, aColumnNames) {
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        return model;
    }
}
