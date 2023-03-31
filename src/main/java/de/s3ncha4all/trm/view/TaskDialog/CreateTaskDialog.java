package de.s3ncha4all.trm.view.TaskDialog;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.model.TaskRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;

public class CreateTaskDialog extends JDialog implements ActionListener {

    private final JPanel panel;
    private final JTextField textField;
    private final JTable table;
    private final DefaultTableModel model;
    private final Core core;

    public CreateTaskDialog(Core core) {
        setTitle("Neue Aufgabe");
        this.core = core;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocation(200, 200);
        setMinimumSize(new Dimension(400, 200));

        panel = new JPanel(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        north.add(new JLabel("Name:"));
        textField = new JTextField(20);
        north.add(textField);
        panel.add(north, BorderLayout.NORTH);

        table = new JTable();
        table.setTableHeader(null);
        model = (DefaultTableModel) table.getModel();
        model.setColumnCount(4);
        AttributeCellHandler handler = new AttributeCellHandler(this, getAttributeNames());
        table.getColumnModel().getColumn(0).setCellRenderer(handler);
        table.getColumnModel().getColumn(0).setCellEditor(handler);
        table.getColumnModel().getColumn(1).setCellRenderer(handler);
        table.getColumnModel().getColumn(1).setCellEditor(handler);
        table.getColumnModel().getColumn(3).setCellRenderer(handler);
        table.getColumnModel().getColumn(3).setCellEditor(handler);
        setTableDimensions();
        model.addRow(new String[]{"Attribute:", "", "", ""});
        model.addRow(new String[]{"", "", "", ""});

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setTableDimensions();
            }
        });

        JScrollPane pane = new JScrollPane(table);
        panel.add(pane, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton submit = new JButton("Hinzufügen");
        submit.setActionCommand(Core.NEWTASK_ADD);
        submit.addActionListener(core);
        south.add(submit);
        JButton cancel = new JButton("Abbrechen");
        cancel.setActionCommand(Core.NEWTASK_CANCEL);
        cancel.addActionListener(core);
        south.add(cancel);
        panel.add(south, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);
    }

    private String[] getAttributeNames() {
        return new String[] {"73gwb", "efwecfwe", "hsdsd"};
    }

    public void setTableDimensions() {
        table.setRowHeight(22);
        int c0 = 70;
        int c1 = 150;
        int c3 = 50;
        int c2 = getWidth()-c0-c1-c3;
        table.getColumnModel().getColumn(0).setPreferredWidth(c0);
        table.getColumnModel().getColumn(1).setPreferredWidth(c1);
        table.getColumnModel().getColumn(2).setPreferredWidth(c2);
        table.getColumnModel().getColumn(3).setPreferredWidth(c3);
    }

    public String getTaskRecordName() {
        return textField.getText();
    }

    public TaskRecord getTaskRecord() {
        Map<String, String> map = new HashMap<String, String>();
        String key, value;
        for(int i = 0; i<table.getRowCount()-1; i++) {
            key = table.getValueAt(i, 1).toString();
            value = table.getValueAt(i, 2).toString();
            if(!key.isEmpty() && !key.isBlank() && !value.isEmpty() && !value.isBlank()) {
                map.put(key, value);
            }
        }
        return new TaskRecord(map);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        table.getCellEditor().cancelCellEditing();
        if("add".equals(cmd)) {
            model.addRow(new String[] {"", "", "", ""});
        } else {
            int index = Integer.parseInt(cmd);
            if (index > 0)
                model.removeRow(index);
        }
    }
}
