package de.s3ncha4all.trm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TaskRecord {

    @Setter
    private TimeRange activeTimeRecord;

    private List<TimeRange> pastRecords;

    private Map<String, String> attributes;

    public TaskRecord() {
        pastRecords = new ArrayList<TimeRange>();
        attributes = new HashMap<String, String>();
    }

    public TaskRecord(Map<String, String> attributes) {
        pastRecords = new ArrayList<TimeRange>();
        this.attributes = attributes;
    }
}
