package de.s3ncha4all.trm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Getter
@NoArgsConstructor
public class TaskRecord {

    private TimeRange activeTimeRecord;
    @NonNull
    private List<TimeRange> pastRecords;

}
