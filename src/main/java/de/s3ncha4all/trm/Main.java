package de.s3ncha4all.trm;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.control.TimeRecordLoader;
import de.s3ncha4all.trm.control.TimeRecordWorker;
import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.model.TimeRange;
import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.view.TRMTrayMenu;

/**
 * Starter.
 */
public class Main {
    public static void main(String[] args) {
        Core c = new Core();
        c.init();
        c.start();
    }
}