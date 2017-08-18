package com.sanchev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.GregorianCalendar;

public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.info("App started");
        Greeter greeter = new Greeter();
        System.out.println(greeter.getMessage(greeter.getDayPart(new GregorianCalendar())));
        LOGGER.info("App finished");
    }

}