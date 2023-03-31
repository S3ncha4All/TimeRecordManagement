package de.s3ncha4all.trm.view.TaskDialog;

import lombok.AllArgsConstructor;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class AttributeCellHandler extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private final ActionListener listener;

    private final DefaultCellEditor editor;

    public AttributeCellHandler(ActionListener listener, String[] comboOptions) {
        this.listener = listener;
        JComboBox<String> box = new JComboBox<String>(comboOptions);
        box.setEditable(true);
        editor = new DefaultCellEditor(box);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        switch (column) {
            case 0:
                if(row > 0 && row >= table.getRowCount()-1) {
                    return new JButton("+");
                } else {
                    return new JLabel(value.toString());
                }
            case 1:
                if(row < table.getRowCount()-1) {
                    String s = "";
                    if(value != null)
                        s = value.toString();
                    JComboBox<String> comboBox = new JComboBox<String>(new String[] {s});
                    comboBox.setEditable(true);
                    return comboBox;
                }
                break;
            case 3:
                if(row > 0 && row < table.getRowCount()-1) {
                    return new JButton("X");
                }
                break;
        }
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        switch (column) {
            case 0:
                if(row == table.getRowCount()-1) {
                    JButton b = new JButton("+");
                    b.setActionCommand("add");
                    b.addActionListener(listener);
                    return b;
                }
                break;
            case 1:
                if(row < table.getRowCount()-1) {
                    return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
                }
                break;
            case 3:
                if(row > 0 && row < table.getRowCount()-1) {
                    JButton b = new JButton("X");
                    b.setActionCommand(""+row);
                    b.addActionListener(listener);
                    return b;
                }
                break;
        }
        return null;
    }

    @Override
    public Object getCellEditorValue() {
        return editor.getCellEditorValue();
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return editor.isCellEditable(anEvent);
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return editor.shouldSelectCell(anEvent);
    }

    @Override
    public boolean stopCellEditing() {
        return editor.stopCellEditing();
    }

    @Override
    public void cancelCellEditing() {
        editor.cancelCellEditing();
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        editor.addCellEditorListener(l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        editor.removeCellEditorListener(l);
    }
}
