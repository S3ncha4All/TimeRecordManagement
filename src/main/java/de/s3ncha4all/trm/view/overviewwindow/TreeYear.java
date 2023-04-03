package de.s3ncha4all.trm.view.overviewwindow;

import lombok.Getter;

import java.util.List;

@Getter
public class TreeYear {

    private int year;

    private List<TreeWeek> weeks;

    public TreeYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return ""+year;
    }
}
