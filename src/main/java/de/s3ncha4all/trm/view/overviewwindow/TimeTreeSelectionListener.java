package de.s3ncha4all.trm.view.overviewwindow;

import de.s3ncha4all.trm.view.overviewwindow.model.TreeDayTableModel;
import de.s3ncha4all.trm.view.overviewwindow.model.TreeTaskRecordTableModel;
import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeDay;
import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeTaskRecord;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class TimeTreeSelectionListener implements TreeSelectionListener {

    private final JTable table;

    public TimeTreeSelectionListener(JTable table) {
        this.table = table;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object source = e.getSource();
        if(source instanceof JTree tree) {
            Object node = tree.getLastSelectedPathComponent();
            if (node instanceof TreeTaskRecord record) {
                table.setModel(new TreeTaskRecordTableModel(record));
            } else if (node instanceof TreeDay day) {
                table.setModel(new TreeDayTableModel(day));
            }
        }
    }
}
