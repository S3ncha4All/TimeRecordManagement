package de.s3ncha4all.trm.view.overviewwindow;

import com.sun.source.tree.Tree;
import de.s3ncha4all.trm.model.TaskRecord;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimeTreeModel implements TreeModel {

    public static final String TASKS = "Aufgaben";
    public static final String ACTIVE_TASKS = "Laufende Aufgaben";
    public static final String HISTORY = "Historie";
    private List<TreeTaskRecord> activeTasks;
    private List<TreeYear> years;


    public TimeTreeModel() {
        years = new ArrayList<TreeYear>();
        activeTasks = new ArrayList<TreeTaskRecord>();
    }

    public void addYear(TreeYear year) {
        years.add(year);
    }

    public TreeYear getTreeYear(int year) {
        for(TreeYear ty : years) {
            if(ty.getYear() == year) {
                return ty;
            }
        }
        TreeYear ty = new TreeYear(year);
        years.add(ty);
        return ty;
    }

    public void addWeek(int year, TreeWeek week) {
        TreeYear ty = getTreeYear(year);
        ty.getWeeks().add(week);
    }

    public TreeWeek getTreeWeek(int year, int week) {
        TreeYear ty = getTreeYear(year);
        for(TreeWeek tw : ty.getWeeks()) {
            if(tw.getWeekNumber() == week) {
                return tw;
            }
        }
        TreeWeek tw = new TreeWeek(week);
        ty.getWeeks().add(tw);
        return tw;
    }

    public void addDay(int year, int week, TreeDay day) {
        TreeWeek tw = getTreeWeek(year, week);
        tw.getDays().add(day);
    }

    public TreeDay getDay(int year, int week, LocalDate date) {
        TreeWeek tw = getTreeWeek(year, week);
        for(TreeDay td : tw.getDays()) {
            if(date.equals(td.getDate())) {
                return td;
            }
        }
        TreeDay td = new TreeDay(date);
        tw.getDays().add(td);
        return td;
    }

    @Override
    public Object getRoot() {
        return TASKS;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if(parent instanceof TreeWeek) {
            TreeWeek tw = (TreeWeek) parent;
            return tw.getDays().get(index);
        }
        if(parent instanceof TreeYear) {
            TreeYear ty = (TreeYear) parent;
            return ty.getWeeks().get(index);
        }
        if(parent instanceof String) {
            String s = parent.toString();
            if(TASKS.equals(s)) {
               return switch (index){
                    case 0 -> ACTIVE_TASKS;
                    case 1 -> HISTORY;
                   default -> null;
                };
            } else if(ACTIVE_TASKS.equals(s)) {
                return activeTasks.get(index);
            } else if(HISTORY.equals(s)) {
                years.get(index);
            }
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        if(parent instanceof TreeWeek) {
            TreeWeek tw = (TreeWeek) parent;
            return tw.getDays().size();
        }
        if(parent instanceof TreeYear) {
            TreeYear ty = (TreeYear) parent;
            return ty.getWeeks().size();
        }
        if(parent instanceof String) {
            String s = parent.toString();
            if(TASKS.equals(s)) {
                return 2;
            } else if(ACTIVE_TASKS.equals(s)) {
                return activeTasks.size();
            } else if(HISTORY.equals(s)) {
                years.size();
            }
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return node instanceof TreeDay || node instanceof TreeTaskRecord;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}
