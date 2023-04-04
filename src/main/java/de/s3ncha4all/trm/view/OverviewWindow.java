package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.view.overviewwindow.model.tree.TimeTreeModel;
import de.s3ncha4all.trm.view.overviewwindow.model.TimeTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.TreeSelectionModel;

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

        JSplitPane split = new JSplitPane();

        JTable table = new JTable();
        JScrollPane rightScrollPane = new JScrollPane(table);
        split.setRightComponent(rightScrollPane);

        TimeTreeModel ttm = core.getReader().createTimeTreeModel();
        JTree tree = new JTree(ttm);
        tree.addTreeSelectionListener(new TimeTreeSelectionListener(table));
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        JScrollPane leftScrollPane = new JScrollPane(tree);
        split.setLeftComponent(leftScrollPane);

        setContentPane(split);

        setVisible(true);
        validate();
        repaint();
    }
}
