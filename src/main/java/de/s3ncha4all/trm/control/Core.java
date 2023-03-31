package de.s3ncha4all.trm.control;

import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.model.TimeRange;
import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.view.TaskDialog.CreateTaskDialog;
import de.s3ncha4all.trm.view.TRMTrayMenu;
import de.s3ncha4all.trm.view.TaskDialog.NewTaskRecordEvent;
import de.s3ncha4all.trm.view.eventmanagement.GenericEvent;
import de.s3ncha4all.trm.view.eventmanagement.IGenericEventListener;


/**
 * Core class to control the whole thing.
 */
public class Core implements IGenericEventListener {

    private TRMTrayMenu trayMenu;

    public Core() {

    }

    public void init() {
        //TODO: Load System Settings
        //TODO: Load defaults
        TimeRecord record = new TimeRecord();
        TimeRecordWorker trw = new TimeRecordWorker(record);

        TaskRecord t = trw.createTask();
        TimeRange range = trw.createTimeRangeNow();
        trw.addTask("Task1", t);
        TimeRecordLoader.saveFile("target/test.record.json", record);

        TimeRecord tr = TimeRecordLoader.loadFile("target/test.record.json");
        tr.getRecord().get("Task1");
    }

    public void start() {
        trayMenu = new TRMTrayMenu(this);
    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public void genericEventFired(GenericEvent e) {
        NewTaskRecordEvent nte = (NewTaskRecordEvent) e;
        //TODO: ADD Task from Event via Worker to Current Record
    }
}
