package de.s3ncha4all.trm.control;

import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.model.TimeRange;
import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.view.TaskDialog.CreateTaskDialog;
import de.s3ncha4all.trm.view.TRMTrayMenu;
import de.s3ncha4all.trm.view.TaskDialog.NewTaskRecordEvent;
import de.s3ncha4all.trm.view.TimeRecordReader;
import de.s3ncha4all.trm.view.eventmanagement.GenericEvent;
import de.s3ncha4all.trm.view.eventmanagement.IGenericEventListener;
import lombok.Getter;


/**
 * Core class to control the whole thing.
 */
public class Core implements IGenericEventListener {

    @Getter
    private TimeRecordWorker worker;

    @Getter
    private TimeRecordReader reader;

    private TRMTrayMenu trayMenu;

    public Core() {

    }

    public void init() {
        //TODO: Load System Settings
        //TODO: Load defaults
        TimeRecord record = new TimeRecord();
        worker = new TimeRecordWorker(record);
        reader = new TimeRecordReader(record);

    }

    public void start() {
        trayMenu = new TRMTrayMenu(this);
    }

    public void onChange() {
        trayMenu.setActiveTasks(reader.getActiveTaskNames().stream().toList());
        trayMenu.setInactiveTasks(reader.getInactiveTaskNames().stream().toList());
        trayMenu.refreshMenu();
    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public void genericEventFired(GenericEvent e) {
        NewTaskRecordEvent nte = (NewTaskRecordEvent) e;
        worker.addTask(nte.getTaskName(), nte.getTaskRecord());
        onChange();
    }
}
