package com.sanchev;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {

	public static void main(String[] args) {
        System.out.printf("Good %s, World!", getDayPart(new GregorianCalendar()));
	}

    static private String getDayPart(Calendar calendar) {
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        if ((hh >= 6) && (hh < 9))
            return "morning";
        else if ((hh >= 9) && (hh < 19))
            return "day";
        else if ((hh >= 19) && (hh < 23))
            return "evening";
        else if ((hh == 23) || ((hh >= 0) && (hh < 6)))
            return "night";
        return null;
    }

}