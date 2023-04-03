package de.s3ncha4all.trm.view.overviewwindow;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TreeDay {

    private LocalDate date;

    private List<TreeTaskRecord> tasks;

    public TreeDay(LocalDate date) {
        this.date = date;
        tasks = new ArrayList<TreeTaskRecord>();
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
