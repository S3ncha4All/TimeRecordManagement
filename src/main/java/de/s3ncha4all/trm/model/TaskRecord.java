package de.s3ncha4all.trm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class TaskRecord {

    @Setter
    private TimeRange activeTimeRecord;
    @NonNull
    private List<TimeRange> pastRecords;

    private String addAttribute;

}
