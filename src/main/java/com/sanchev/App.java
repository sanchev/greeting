package com.sanchev;

import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        System.out.println(greeter.getMessage(greeter.getDayPart(new GregorianCalendar())));
    }

}