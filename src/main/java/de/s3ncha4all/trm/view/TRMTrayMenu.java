package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.control.events.BeginTaskTimeRangeEvent;
import de.s3ncha4all.trm.control.events.EndTaskTimeRangeEvent;
import de.s3ncha4all.trm.view.TaskDialog.CreateTaskDialog;
import de.s3ncha4all.trm.view.eventmanagement.GenericEventRegistrar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class TRMTrayMenu implements ActionListener {

    public static final String NEWTASK_COMMAND = "newtask";
    public static final String BEGIN_NEWTASK_COMMAND = "begin_newtask";
    public static final String BEGINTASK_COMMAND = "BEGIN#";
    public static final String ENDTASK_COMMAND = "END#";
    public static final String OVERVIEW_COMMAND = "overview";
    public static final String SETTINGS_COMMAND = "settings";
    public static final String EXIT_COMMAND = "exit";

    private final Core core;
    private GenericEventRegistrar eventRegistrar;
    private final TrayIcon icon;
    private List<String> activeTasks;
    private List<String> inactiveTasks;

    public TRMTrayMenu(Core core) {
        this.core = core;
        eventRegistrar = new GenericEventRegistrar();
        eventRegistrar.addGenericEventListener(this.core);
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
        item.setActionCommand(BEGIN_NEWTASK_COMMAND);
        item.addActionListener(this);
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
                MenuItem mi = new MenuItem(s+" beginnen");
                mi.setActionCommand(BEGINTASK_COMMAND+s);
                mi.addActionListener(this);
                menu.add(mi);
            }
        }
    }

    private void addActiveTasks(Menu menu) {
        if(activeTasks != null) {
            for(String s : activeTasks) {
                MenuItem mi = new MenuItem(s+" abschließen");
                mi.setActionCommand(ENDTASK_COMMAND+s);
                mi.addActionListener(this);
                menu.add(mi);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.startsWith(BEGINTASK_COMMAND)) {
            String taskName = cmd.replace(BEGINTASK_COMMAND, "");
            eventRegistrar.fireGenericEvent(new BeginTaskTimeRangeEvent(this, taskName));
        } else if (cmd.startsWith(ENDTASK_COMMAND)) {
            String taskName = cmd.replace(ENDTASK_COMMAND, "");
            eventRegistrar.fireGenericEvent(new EndTaskTimeRangeEvent(this, taskName));
        } else {
            switch(cmd) {
                case NEWTASK_COMMAND:
                    new CreateTaskDialog(core);
                    break;
                case BEGIN_NEWTASK_COMMAND:
                    new CreateTaskDialog(core, true);
                    break;
                case OVERVIEW_COMMAND:
                    core.overview();
                    break;
                case SETTINGS_COMMAND:
                    core.settings();
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
}
