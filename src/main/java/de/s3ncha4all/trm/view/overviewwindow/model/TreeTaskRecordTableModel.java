package de.s3ncha4all.trm.view.overviewwindow.model;

import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeTaskRecord;

import javax.swing.table.AbstractTableModel;

public class TreeTaskRecordTableModel extends AbstractTableModel {

    private TreeTaskRecord task;

    public TreeTaskRecordTableModel(TreeTaskRecord task) {
        this.task = task;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
