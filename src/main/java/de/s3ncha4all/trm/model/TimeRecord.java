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
@NoArgsConstructor
public class TimeRecord {

    @NonNull
    private HashMap<String, TaskRecord> record;

}
