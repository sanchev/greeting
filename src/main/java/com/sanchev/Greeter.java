package com.sanchev;

import java.util.Calendar;
import java.util.ResourceBundle;

public class Greeter {

    enum DayPart {MORNING, DAY, EVENING, NIGHT}

    DayPart getDayPart(Calendar calendar) {
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        if ((hh >= 6) && (hh < 9))
            return DayPart.MORNING;
        else if ((hh >= 9) && (hh < 19))
            return DayPart.DAY;
        else if ((hh >= 19) && (hh < 23))
            return DayPart.EVENING;
        else
            return DayPart.NIGHT;
    }

    String getMessage(DayPart dayPart) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
        return resourceBundle.getString(dayPart.toString());
    }

}