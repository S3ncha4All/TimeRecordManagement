package de.s3ncha4all.trm.view.overviewwindow.model;

import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeTaskRecord;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TreeTaskRecordTableModel extends AbstractTableModel {

    private TreeTaskRecord task;

    private final String[] hardcodedAttributeNames = new String[]{"Name", "Start", "Ende"};

    List<String> keys;

    public TreeTaskRecordTableModel(TreeTaskRecord task) {
        this.task = task;
        keys = task.getAttributes().keySet().stream().toList();
        keys.forEach(System.out::println);
    }

    @Override
    public int getRowCount() {
        return hardcodedAttributeNames.length + keys.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> {
                if(rowIndex < hardcodedAttributeNames.length) {
                    yield hardcodedAttributeNames[rowIndex];
                } else {
                    int shift = rowIndex - hardcodedAttributeNames.length;
                    if(shift < keys.size()) {
                       yield keys.get(shift);
                    }
                    yield null;
                }
            }
            case 1 -> {
                switch (rowIndex) {
                    case 0 -> {yield task.getName();}
                    case 1 -> {yield task.getRange() != null ? task.getRange().getBegin():null;}
                    case 2 -> {yield task.getRange() != null ? task.getRange().getEnd():null;}
                    default -> {
                        int shift = rowIndex - hardcodedAttributeNames.length;
                        if(shift < keys.size()) {
                            yield task.getAttributes().get(keys.get(shift));
                        }
                        yield null;
                    }
                }
            }
            default -> null;
        };
    }
}
