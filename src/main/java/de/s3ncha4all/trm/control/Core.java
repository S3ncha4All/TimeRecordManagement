package de.s3ncha4all.trm.control;

import de.s3ncha4all.trm.control.events.BeginTaskTimeRangeEvent;
import de.s3ncha4all.trm.control.events.EndTaskTimeRangeEvent;
import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.shared.GlobalConstants;
import de.s3ncha4all.trm.view.OverviewWindow;
import de.s3ncha4all.trm.view.TRMTrayMenu;
import de.s3ncha4all.trm.control.events.NewTaskRecordEvent;
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

    public void overview() {
        new OverviewWindow(this);
    }

    public void settings() {

    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public void genericEventFired(GenericEvent ge) {
        String name = ge.getName();
        System.out.println(name);
        switch(name) {
            case GlobalConstants.NEW_TASK_EVENT:
                NewTaskRecordEvent ntr = (NewTaskRecordEvent) ge;
                worker.addTask(ntr.getTaskName(), ntr.getTaskRecord());
                break;
            case GlobalConstants.BEGIN_TASK_EVENT:
                BeginTaskTimeRangeEvent btt = (BeginTaskTimeRangeEvent) ge;
                worker.startActiveTimeRange(btt.getTaskName());
                break;
            case GlobalConstants.END_TASK_EVENT:
                EndTaskTimeRangeEvent ett = (EndTaskTimeRangeEvent) ge;
                worker.closeActiveTimeRange(ett.getTaskName());
                break;

        }
        onChange();
    }
}
