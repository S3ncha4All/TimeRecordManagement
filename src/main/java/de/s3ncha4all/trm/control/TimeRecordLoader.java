package de.s3ncha4all.trm.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.s3ncha4all.trm.model.TimeRecord;

import java.io.File;
import java.io.IOException;


public class TimeRecordLoader {

    public static TimeRecord loadFile(String file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TimeRecord record = mapper.readValue(new File(file), TimeRecord.class);
            return record;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveFile(String file, TimeRecord record) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(file), record);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
