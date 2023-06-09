package de.s3ncha4all.trm.view.overviewwindow.model;

import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeDay;

import javax.swing.table.AbstractTableModel;

public class TreeDayTableModel extends AbstractTableModel {

    private TreeDay day;

    public TreeDayTableModel(TreeDay day) {
        this.day = day;
    }

    @Override
    public int getRowCount() {
        return day.getTasks().size();
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "";
    }
}
