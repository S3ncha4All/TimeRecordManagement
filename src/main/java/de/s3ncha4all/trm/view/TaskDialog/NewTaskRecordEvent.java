package de.s3ncha4all.trm.view.TaskDialog;

import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.view.eventmanagement.GenericEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class NewTaskRecordEvent extends GenericEvent {

    private String taskName;
    private TaskRecord taskRecord;

    public NewTaskRecordEvent(Object source, String name, String taskName, TaskRecord task) {
        super(source, name);
    }
}
