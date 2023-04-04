package de.s3ncha4all.trm.view.overviewwindow.model.tree;

import de.s3ncha4all.trm.view.overviewwindow.model.tree.TreeWeek;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TreeYear {

    private int year;

    private List<TreeWeek> weeks;

    public TreeYear(int year) {
        this.year = year;
        weeks = new ArrayList<TreeWeek>();
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }
}
