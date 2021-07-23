package test;

import model.Time;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {

    private Time testTime;

    @Test
    public void testConstructor() {
        testTime = new Time(14, 33);
        assertEquals(testTime.getHours(), 14);
        assertEquals(testTime.getMinutes(), 33);
    }

    @Test
    public void testGetTimeAM() {
        testTime = new Time(7, 6);
        assertEquals(testTime.getTime(), "07:06");
    }

    @Test
    public void testGetTimePM() {
        testTime = new Time(14, 33);
        assertEquals(testTime.getTime(), "14:33");
    }
}
