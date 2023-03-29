package de.s3ncha4all.trm.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class TRMTrayMenu {

    private ActionListener actionListener;
    private List<String> activeTasks;
    private final TrayIcon icon;

    public TRMTrayMenu(ActionListener listener) {
        this.actionListener = listener;
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
                MenuItem mi = new MenuItem("Task1 abschließen");
                mi.addActionListener(actionListener);
                menu.add(mi);
            }
            if(activeTasks.size() > 0) {
                menu.addSeparator();
            }
        }
        MenuItem item;
        item = new MenuItem("Neuen Task");
        item.addActionListener(actionListener);
        menu.add(item);
        menu.addSeparator();
        item = new MenuItem("Übersicht");
        item.addActionListener(actionListener);
        menu.add(item);
        item = new MenuItem("Einstellungen");
        item.addActionListener(actionListener);
        menu.add(item);
        item = new MenuItem("Beenden");
        item.addActionListener(actionListener);
        menu.add(item);
    }
}
