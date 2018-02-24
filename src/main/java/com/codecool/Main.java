package com.codecool;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MMTimerContext.xml");

        Controller controller = (Controller) context.getBean("controller");
        controller.startController();
    }
}
