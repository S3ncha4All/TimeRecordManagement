package de.s3ncha4all.trm.control.events;

import de.s3ncha4all.trm.control.Core;
import de.s3ncha4all.trm.shared.GlobalConstants;
import de.s3ncha4all.trm.view.eventmanagement.GenericEvent;
import lombok.Getter;

@Getter
public class BeginTaskTimeRangeEvent extends GenericEvent {
    private String taskName;
    public BeginTaskTimeRangeEvent(Object source, String taskName) {
        super(source, GlobalConstants.BEGIN_TASK_EVENT);
        this.taskName = taskName;
    }
}
