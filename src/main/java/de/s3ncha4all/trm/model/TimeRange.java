package de.s3ncha4all.trm.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Represents a Range in Time.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class TimeRange {

    @NonNull
    private Timestamp begin;
    private Timestamp end;

}
