package de.s3ncha4all.trm.view.overviewwindow.model.tree;

import lombok.Getter;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TreeDay {

    private Timestamp date;

    private List<TreeTaskRecord> tasks;

    public TreeDay(Timestamp date) {
        this.date = date;
        tasks = new ArrayList<TreeTaskRecord>();
    }

    @Override
    public String toString() {
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EE");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("d.MMMM");
        String day = date.toLocalDateTime().format(dayFormatter);
        String month = date.toLocalDateTime().format(monthFormatter);
        return day+" [ "+month+" ]";
    }
}
