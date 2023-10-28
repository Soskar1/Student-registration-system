package com.project.studentregistrationsystem;

import java.util.ArrayList;

public class Observer {
    private final ArrayList<EventListener> listeners = new ArrayList<>();

    public void subscribe(EventListener eventListener) {
        listeners.add(eventListener);
    }

    public void unsubscribe(EventListener eventListener) {
        listeners.remove(eventListener);
    }

    public void notifyListeners() {
        for (EventListener eventListener : listeners) {
            eventListener.update();
        }
    }
}
