package com.sanchev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

class Greeter {
    private static final Logger LOGGER = LogManager.getLogger(Greeter.class.getName());

    enum DayPart {MORNING, DAY, EVENING, NIGHT}

    DayPart getDayPart(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        LOGGER.info(String.format("Time: %s", simpleDateFormat.format(calendar.getTime())));
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        DayPart dayPart;
        if ((hh >= 6) && (hh < 9))
            dayPart = DayPart.MORNING;
        else if ((hh >= 9) && (hh < 19))
            dayPart = DayPart.DAY;
        else if ((hh >= 19) && (hh < 23))
            dayPart = DayPart.EVENING;
        else
            dayPart = DayPart.NIGHT;
        LOGGER.info(String.format("Part of day: %s", dayPart));
        return dayPart;
    }

    String getMessage(DayPart dayPart) {
        LOGGER.info(String.format("Locale: %s", Locale.getDefault()));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
        String message = resourceBundle.getString(dayPart.toString());
        LOGGER.info(String.format("Message: %s", message));
        return message;
    }

}