package de.s3ncha4all.trm.view.eventmanagement;

import java.util.ArrayList;
import java.util.List;

public class GenericEventRegistrar implements IGenericEventRegistrar {

    private List<IGenericEventListener> listeners;

    public GenericEventRegistrar() {
        listeners = new ArrayList<IGenericEventListener>();
    }

    public void addGenericEventListener(IGenericEventListener listener) {
        listeners.add(listener);
    }

    public void removeGenericListener(IGenericEventListener listener) {
        listeners.remove(listener);
    }

    public void fireGenericEvent(GenericEvent e) {
        for(IGenericEventListener l : listeners) {
            l.genericEventFired(e);
        }
    }
}
