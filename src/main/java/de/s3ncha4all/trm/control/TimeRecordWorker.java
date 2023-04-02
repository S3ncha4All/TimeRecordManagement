package de.s3ncha4all.trm.control;


import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.model.TimeRange;
import de.s3ncha4all.trm.model.TimeRecord;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
public class TimeRecordWorker {

    private TimeRecord record;

    public TaskRecord createTask() {
        TaskRecord task = new TaskRecord();
        return task;
    }

    public void addTask(String name, TaskRecord task) {
        record.getRecord().put(name, task);
    }

    public TimeRange createTimeRangeNow() {
        Timestamp ts = getCurrentTimestamp();
        TimeRange range = new TimeRange(ts);
        return range;
    }

    public void addTimeRangeToTask(String name, TimeRange range) {
        record.getRecord().get(name).getPastRecords().add(range);
    }

    public void startActiveTimeRange(String name) {
        record.getRecord().get(name).setActiveTimeRecord(createTimeRangeNow());
    }

    public void closeActiveTimeRange(String name) {
        TaskRecord task = record.getRecord().get(name);
        TimeRange range = task.getActiveTimeRecord();
        Timestamp ts = getCurrentTimestamp();
        range.setEnd(ts);
        task.getPastRecords().add(range);
        task.setActiveTimeRecord(null);
    }

    private Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
