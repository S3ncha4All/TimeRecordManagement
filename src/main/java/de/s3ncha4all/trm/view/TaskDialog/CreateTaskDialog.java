package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.model.TaskRecord;

import javax.swing.*;
import java.awt.*;

public class CreateTaskDialog extends JDialog {

    private final JPanel panel;
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
        JTextField textField = new JTextField(20);
        north.add(textField);
        panel.add(north, BorderLayout.NORTH);

//        addInputPanel();
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel("Attribute:");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        center.add(label);
        JList<String> l = new JList<String>();
        l.setListData(new String[] {
                "ohw", "pjsdp", "psjd", "psj", "ohw", "pjsdp", "psjd", "psj", "ohw", "pjsdp", "psjd", "psj"
        });
        JScrollPane pane = new JScrollPane(l);
        center.add(pane);
        panel.add(center, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton submit = new JButton("Hinzufügen");
        south.add(submit);
        JButton cancel = new JButton("Abbrechen");
        south.add(cancel);
        panel.add(south, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);
    }

    private void addInputPanel() {
        JPanel center = new JPanel();
        JScrollPane pane = new JScrollPane(center);
        center.setLayout(new GridBagLayout());
        center.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5,5 ,5, 5);
        gbc.ipadx = 10;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        center.add(new JLabel("Attribute:"), gbc);
        JComboBox<String> c;
        JTextField tf;
        int i = 0;
        for (; i < 1; i++) {
            c = new JComboBox<String>(new String[]{"", "Attr1", "Attr2", "Attr558", "Attr20923874508",});
            c.setEditable(true);
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridy = i;
            gbc.weightx = 0;
            gbc.gridx = 1;
            center.add(c, gbc);
            tf = new JTextField();
            gbc.weightx = 0.4;
            gbc.gridx = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            center.add(tf, gbc);
        }
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridy = i+1;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.insets = new Insets(0,5,0,0);
        center.add(new JButton("+"), gbc);
        panel.add(pane, BorderLayout.CENTER);
    }

    public TaskRecord getTask() {
        return null;
    }
}
