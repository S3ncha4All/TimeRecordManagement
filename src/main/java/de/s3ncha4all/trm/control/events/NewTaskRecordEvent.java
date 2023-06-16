package de.s3ncha4all.trm.control.events;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.model.TaskRecord;
import de.s3ncha4all.trm.shared.GlobalConstants;
import de.s3ncha4all.trm.view.eventmanagement.GenericEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class NewTaskRecordEvent extends GenericEvent {

    private String taskName;
    private TaskRecord taskRecord;

    public NewTaskRecordEvent(Object source, String taskName, TaskRecord task) {
        super(source, GlobalConstants.NEW_TASK_EVENT);
        this.taskName = taskName;
        this.taskRecord = task;
    }
}
