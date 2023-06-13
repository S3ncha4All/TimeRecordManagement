package de.s3ncha4all.trm.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;

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


    public double getDifference() {
        long minutes = ChronoUnit.MINUTES.between(begin.toLocalDateTime(), end.toLocalDateTime());
        return getHours(minutes);
    }

    private double getHours(long minutes) {

        return 0.0;
    }

}
