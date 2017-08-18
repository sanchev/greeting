import com.sanchev.Greeter;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.Assert.*;

public class GreeterTest {

    public Greeter.DayPart testGetDayPart(int hh, int mm) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, hh);
        calendar.set(Calendar.MINUTE, mm);

        Greeter greeter = new Greeter();
        return greeter.getDayPart(calendar);
    }

    @Test
    public void testGetDayPart_MORNING() {
        //Time 5:59
        assertNotEquals(Greeter.DayPart.MORNING, testGetDayPart(5, 59));
        //Time 06:00
        assertEquals(Greeter.DayPart.MORNING, testGetDayPart(6, 0));
        //Time 8:59
        assertEquals(Greeter.DayPart.MORNING, testGetDayPart(8, 59));
        //Time 9:00
        assertNotEquals(Greeter.DayPart.MORNING, testGetDayPart(9, 0));
    }

    @Test
    public void testGetDayPart_DAY() {
        //Time 09:00
        assertEquals(Greeter.DayPart.DAY, testGetDayPart(9, 0));
        //Time 18:59
        assertEquals(Greeter.DayPart.DAY, testGetDayPart(18, 59));
    }

    @Test
    public void testGetDayPart_EVENING() {
        //Time 18:59
        assertNotEquals(Greeter.DayPart.EVENING, testGetDayPart(18, 59));
        //Time 19:00
        assertEquals(Greeter.DayPart.EVENING, testGetDayPart(19, 0));
        //Time 22:59
        assertEquals(Greeter.DayPart.EVENING, testGetDayPart(22, 59));
        //Time 23:00
        assertNotEquals(Greeter.DayPart.EVENING, testGetDayPart(23, 00));
    }

    @Test
    public void testGetDayPart_NIGHT() {
        //Time 22:59
        assertNotEquals(Greeter.DayPart.NIGHT, testGetDayPart(22, 59));
        //Time 23:00
        assertEquals(Greeter.DayPart.NIGHT, testGetDayPart(23, 0));
        //Time 5:59
        assertEquals(Greeter.DayPart.NIGHT, testGetDayPart(5, 59));
        //Time 6:00
        assertNotEquals(Greeter.DayPart.NIGHT, testGetDayPart(6, 0));
    }

    @Test
    public void testGetMessage_RU() {
        Locale locale = new Locale("ru", "RU");
        Locale.setDefault(locale);

        Greeter greeter = new Greeter();
        String message = greeter.getMessage(Greeter.DayPart.MORNING);

        assertEquals("Доброе утро, Мир!", message);
    }

    @Test
    public void testGetMessage_US() {
        Locale locale = new Locale("en", "US");
        Locale.setDefault(locale);

        Greeter greeter = new Greeter();
        String message = greeter.getMessage(Greeter.DayPart.MORNING);

        assertEquals("Good morning, World!", message);
    }

}