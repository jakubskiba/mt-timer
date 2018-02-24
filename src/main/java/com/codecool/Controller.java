package com.codecool;

import java.util.*;

public class Controller {
    private TimerContainer timers;
    private View view;

    public Controller(TimerContainer timers, View view) {
        this.timers = timers;
        this.view = view;
    }

    public void startController() {
        String[] command = {""};
        while (command[0] != "quit") {
            view.printPrompt();
            command = view.getParsedCommand();

            String mainCommand = command.length >=1 ? command[0] : "";
            String parameter = command.length >= 2 ? command[1] : "";

            handleCommand(mainCommand, parameter);
        }
    }

    private void handleCommand(String command, String parameter) {
        switch (command) {
            case "start":
                startTimer(parameter);
                break;
            case "stop":
                stopTimer(parameter);
                break;

            case "check":
                checkTimer(parameter);
                break;

            case "continue":
                continueTimer(parameter);
                break;
        }
    }

    private void continueTimer(String parameter) {
        if(!parameter.isEmpty()) {
            timers.continueTimer(parameter);
        }
    }

    private void startTimer(String name) {
        if(!name.isEmpty()) {
            timers.startTimer(name);
        }
    }

    private void stopTimer(String name) {
        if(!name.isEmpty()) {
            timers.stopTimer(name);
        }
    }

    private void checkTimer(String parameter) {
        if(!parameter.isEmpty()) {
            printOneTimer(parameter);
        } else {
            printAllTimers();
        }
    }

    private void printAllTimers() {
        for(Timer timer : timers.getAll()) {
            view.printTimer(timer);
        }
    }

    private void printOneTimer(String name) {
        Optional<Timer> timer = timers.getTimer(name);
        if(timer.isPresent()) {
            view.printTimer(timer.get());
        }
    }

}
