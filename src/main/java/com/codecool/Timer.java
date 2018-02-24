package com.codecool;

public class Timer extends Thread {

    private String timerName;
    private int secondsFromStart = 0;
    private boolean isCounting = false;

    public Timer(String name) {
        this.timerName = name;
    }

    @Override
    public void run() {
        this.isCounting = true;
        while (true) {
            try {
                Thread.sleep(1000);
                if(isCounting) secondsFromStart++;
            } catch (InterruptedException e) {
                isCounting = false;

            }
        }
    }

    public void continueTimer() {
        this.isCounting = true;
    }

    public int getSecondsFromStart() {
        return secondsFromStart;
    }

    public String getTimerName() {
        return timerName;
    }
}
