package com.codecool;

import java.util.Scanner;

public class View {

    private Scanner in;

    public View() {
        this.in = new Scanner(System.in);
    }

    public void printPrompt() {
        System.out.println("Command? ");
    }

    public String[] getParsedCommand() {
        String command = in.nextLine();
        return command.split(" ");
    }


    public void printTimer(Timer timer) {
        System.out.printf("Name: %s, Seconds: %d%n", timer.getTimerName(), timer.getSecondsFromStart());
    }
}
