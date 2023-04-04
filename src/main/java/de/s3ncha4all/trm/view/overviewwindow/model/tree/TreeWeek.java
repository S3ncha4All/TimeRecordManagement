package de.s3ncha4all.trm.view.overviewwindow.model.tree;

import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeDay;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TreeWeek {

    private int weekNumber;

    private List<TreeDay> days;

    public TreeWeek(int weekNumber) {
        this.weekNumber = weekNumber;
        days = new ArrayList<TreeDay>();
    }

    @Override
    public String toString() {
        return "Kalenderwoche "+weekNumber;
    }
}
