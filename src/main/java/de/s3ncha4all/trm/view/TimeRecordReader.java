package de.s3ncha4all.trm.view;

import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.model.TimeRange;
import de.s3ncha4all.trm.model.TimeRecord;
import de.s3ncha4all.trm.view.overviewwindow.model.tree.TimeTreeModel;
import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeDay;
import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeTaskRecord;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
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
            System.out.println("Name: "+name);
            TaskRecord tr = record.getRecord().get(name);
            if((tr.getPastRecords().size() == 0 && tr.getActiveTimeRecord() == null)
                    || (tr.getActiveTimeRecord() != null && tr.getActiveTimeRecord().getEnd() == null)) {
                // Zu aktiven Tasks hinzufügen
                TreeTaskRecord ttr = new TreeTaskRecord(name, tr.getActiveTimeRecord(), tr.getAttributes());
                ttm.addActiveTaskRecord(ttr);
            }
            for(TimeRange range : tr.getPastRecords()) {
                Timestamp ts = range.getBegin();
                System.out.println("Begin: "+ts);
                int year = getYear(ts);
                System.out.println("Jahr: "+year);
                int week = getWeekNumber(ts);
                System.out.println("Woche: "+week);
                TreeDay td = ttm.getDay(year, week, ts);
                td.getTasks().add(new TreeTaskRecord(name, range, tr.getAttributes()));
            }
        }
        return ttm;
    }

    private Calendar getTimestampCalendar(Timestamp ts) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ts);
        return calendar;
    }

    private int getYear(Timestamp ts) {
        Calendar calendar = getTimestampCalendar(ts);
        return calendar.get(Calendar.YEAR);
    }

    private int getWeekNumber(Timestamp ts) {
        Calendar calendar = getTimestampCalendar(ts);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }


}
