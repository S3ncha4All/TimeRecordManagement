package de.s3ncha4all.trm.view.eventmanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericEvent {

    private Object source;
    private String name;

    @Override
    public String toString() {
        return "Source[ "+source+"] -> Name[ "+name+" ]";
    }
}
