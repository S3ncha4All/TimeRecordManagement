package de.s3ncha4all.trm.control;

import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.view.TRMTrayMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Core class to control the whole thing.
 */
public class Core implements ActionListener{

    private TRMTrayMenu trayMenu;

    public Core() {
        
    }

    public void init() {
        TimeRecord record = new TimeRecord();
        TimeRecordWorker trw = new TimeRecordWorker(record);

//        TaskRecord t = trw.createTask();
//        TimeRange range = trw.createTimeRangeNow();
//        trw.addTask("Task1", t);
//        TimeRecordLoader.saveFile("target/test.record.json", record);

//        TimeRecord tr = TimeRecordLoader.loadFile("target/test.record.json");
//        tr.getRecord().get("Task1");
    }

    public void start() {
        trayMenu = new TRMTrayMenu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(cmd);
        tasks.remove(cmd);
        trayMenu.setActiveTasks(tasks);
    }

    private List<String> tasks;
    public void change() {
        if(tasks == null) {
            tasks = new ArrayList<String>();
        }
        tasks.add("Task"+tasks.size());
        trayMenu.setActiveTasks(tasks);
    }

    public void exit() {
        System.exit(0);
    }
}
