package de.s3ncha4all.trm.view.overviewwindow;

import de.s3ncha4all.trm.model.TimeRange;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class TreeTaskRecord {

    private String name;

    private TimeRange range;
    private Map<String, String> attributes;

    @Override
    public String toString() {
        return name;
    }
}
