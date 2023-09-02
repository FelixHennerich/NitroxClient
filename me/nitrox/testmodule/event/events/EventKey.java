package me.nitrox.testmodule.event.events;

import me.nitrox.testmodule.event.Event;

public class EventKey extends Event {
    private int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
