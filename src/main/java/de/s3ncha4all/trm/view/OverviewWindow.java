package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.view.overviewwindow.TimeTreeModel;

import javax.swing.*;
import java.awt.*;

public class OverviewWindow extends JFrame {

    public OverviewWindow(Core core) {
        super("Aufgabenplanung - Übersicht");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JMenuBar bar = new JMenuBar();
        JMenu start = new JMenu("Start");
        bar.add(start);
        JMenu edit = new JMenu("Bearbeiten");
        bar.add(edit);
        JMenu settings = new JMenu("Einstellungen");
        bar.add(settings);
        JMenu help = new JMenu("Hilfe");
        bar.add(help);
        setJMenuBar(bar);

        setSize(400, 400);
        setLocation(200, 200);

        TimeTreeModel ttm = core.getReader().createTimeTreeModel();
        JTree tree = new JTree(ttm);
        JScrollPane pane = new JScrollPane(tree);
        setContentPane(pane);

        setVisible(true);
        validate();
        repaint();
    }
}
