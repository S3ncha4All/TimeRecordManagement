package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.model.TimeRange;
import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.view.overviewwindow.TimeTreeModel;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
public class TimeRecordReader {

    private TimeRecord record;

    public Set<String> getAttributeNames() {
        Set<String> tasks = record.getRecord().keySet();
        Set<String> attributes = new HashSet<String>();
        for(String taskName : tasks) {
            Set<String> as  = record.getRecord().get(taskName).getAttributes().keySet();
            attributes.addAll(as);
        }
        return attributes;
    }

    public Set<String> getActiveTaskNames() {
        Set<String> tasks = record.getRecord().keySet();
        Set<String> activeTasks = new HashSet<String>();
        for(String t : tasks) {
            TimeRange tr = record.getRecord().get(t).getActiveTimeRecord();
            if(tr != null && tr.getEnd() == null) {
                activeTasks.add(t);
            }
        }
        return activeTasks;
    }

    public Set<String> getInactiveTaskNames() {
        Set<String> tasks = record.getRecord().keySet();
        Set<String> inactiveTasks = new HashSet<String>();
        for(String t : tasks) {
            TimeRange tr = record.getRecord().get(t).getActiveTimeRecord();
            if(tr == null || tr.getEnd() != null) {
                inactiveTasks.add(t);
            }
        }
        return inactiveTasks;
    }

    public TimeTreeModel createTimeTreeModel() {
        TimeTreeModel ttm = new TimeTreeModel();
        Set<String> tasks = record.getRecord().keySet();
        for (String name : tasks) {
            TaskRecord tr = record.getRecord().get(name);

        }
        return ttm;
    }
}
