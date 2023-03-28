package de.s3ncha4all.trm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashMap;

/**
 * Represents a File in JSON with all "local" settings, Tasks, and Records.
 */
@Getter
public class TimeRecord {

    private HashMap<String, TaskRecord> record;

    public TimeRecord() {
        this.record = new HashMap<String, TaskRecord>();
    }
}
