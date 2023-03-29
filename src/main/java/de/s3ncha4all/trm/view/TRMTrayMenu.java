package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.control.Core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class TRMTrayMenu implements ActionListener {

    public static final String NEWTASK_COMMAND = "newtask";
    public static final String OVERVIEW_COMMAND = "overview";
    public static final String SETTINGS_COMMAND = "settings";
    public static final String EXIT_COMMAND = "exit";

    private final Core core;
    private final TrayIcon icon;
    private ActionListener actionListener;
    private List<String> activeTasks;

    public TRMTrayMenu(Core core) {
        this.core = core;
        try {
            PopupMenu menu = new PopupMenu();
            addMenuItems(menu);
            Image image = ImageIO.read(getClass().getClassLoader().getResource("images/icon.png"));
            icon = new TrayIcon(image);
            icon.setPopupMenu(menu);
            final SystemTray tray = SystemTray.getSystemTray();
            tray.add(icon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void setActiveTasks(List<String> activeTasks) {
        this.activeTasks = activeTasks;
        refreshMenu();
    }

    private void refreshMenu() {
        PopupMenu menu = new PopupMenu();
        addMenuItems(menu);
        icon.setPopupMenu(menu);
    }

    private void addMenuItems(PopupMenu menu) {
        if(activeTasks != null) {
            for(String s : activeTasks) {
                MenuItem mi = new MenuItem(s+" abschließen");
                mi.setActionCommand(s);
                mi.addActionListener(core);
                menu.add(mi);
            }
            if(activeTasks.size() > 0) {
                menu.addSeparator();
            }
        }
        MenuItem item;
        item = new MenuItem("Neuen Task");
        item.setActionCommand(NEWTASK_COMMAND);
        item.addActionListener(this);
        menu.add(item);
        menu.addSeparator();
        item = new MenuItem("Übersicht");
        item.setActionCommand(OVERVIEW_COMMAND);
        item.addActionListener(this);
        menu.add(item);
        item = new MenuItem("Einstellungen");
        item.setActionCommand(SETTINGS_COMMAND);
        item.addActionListener(this);
        menu.add(item);
        item = new MenuItem("Beenden");
        item.setActionCommand(EXIT_COMMAND);
        item.addActionListener(this);
        menu.add(item);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd) {
            case NEWTASK_COMMAND:
                core.change();
                break;
            case OVERVIEW_COMMAND:
                break;
            case SETTINGS_COMMAND:
                break;
            case EXIT_COMMAND:
                core.exit();
                break;
        }
    }
}
