package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TimerContainer {
    private Map<String, Timer> timers;

    public TimerContainer(Map<String, Timer> timers) {
        this.timers = timers;
    }

    public void startTimer(String name) {
        Timer newTimer = new Timer(name);
        newTimer.start();
        this.timers.put(name, newTimer);
    }

    public void stopTimer(String name) {
        if(this.timers.containsKey(name)) {
            this.timers.get(name).interrupt();
        }
    }

    public int getTime(String name) throws IllegalAccessException {
        if(timers.containsKey(name)) {
            return timers.get(name).getSecondsFromStart();
        } else {
            throw new IllegalAccessException("No such timer!");
        }
    }

    public Optional<Timer> getTimer(String name) {
        return Optional.ofNullable(timers.get(name));
    }

    public List<Timer> getAll() {
        return new ArrayList<>(timers.values());
    }

    public void continueTimer(String parameter) {
        if(timers.containsKey(parameter)) {
            timers.get(parameter).continueTimer();
        }
    }
}
