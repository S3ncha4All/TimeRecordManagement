package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.view.TaskDialog.CreateTaskDialog;

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
    private List<String> activeTasks;
    private List<String> inactiveTasks;

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
    }

    public void setInactiveTasks(List<String> inactiveTasks) {
        this.inactiveTasks = inactiveTasks;
    }

    public void refreshMenu() {
        PopupMenu menu = new PopupMenu();
        addMenuItems(menu);
        icon.setPopupMenu(menu);
    }

    private void addMenuItems(PopupMenu menu) {
        MenuItem item;
        Menu submenu;
        submenu = new Menu("Task beenden");
        addActiveTasks(submenu);
        menu.add(submenu);
        menu.addSeparator();
        item = new MenuItem("Neuen Task beginnen");
//        item.setActionCommand(NEWTASK_COMMAND);
//        item.addActionListener(this);
        menu.add(item);
        item = new MenuItem("Neuen Task");
        item.setActionCommand(NEWTASK_COMMAND);
        item.addActionListener(this);
        menu.add(item);
        submenu = new Menu("Task beginnen");
        addInactiveTasks(submenu);
        menu.add(submenu);
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

    private void addInactiveTasks(Menu menu) {
        if(inactiveTasks != null) {
            for(String s : inactiveTasks) {
                System.out.println(s);
                MenuItem mi = new MenuItem(s+" beginnen");
                mi.setActionCommand(s);
                mi.addActionListener(this);
                menu.add(mi);
            }
        }
    }

    private void addActiveTasks(Menu menu) {
        if(activeTasks != null) {
            for(String s : activeTasks) {
                MenuItem mi = new MenuItem(s+" abschließen");
                mi.setActionCommand(s);
                mi.addActionListener(this);
                menu.add(mi);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd) {
            case NEWTASK_COMMAND:
                new CreateTaskDialog(core);
                break;
            case OVERVIEW_COMMAND:
                //TODO: TBD
                break;
            case SETTINGS_COMMAND:
                //TODO: TBD
                break;
            case EXIT_COMMAND:
                core.exit();
                break;
            default:
                if(!cmd.isBlank() && !cmd.isEmpty()) {
                    System.out.println(cmd);
                }
        }
    }
}
