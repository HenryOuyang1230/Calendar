package test;

import model.Date;
import model.Entry;
import model.Time;

import static org.junit.jupiter.api.Assertions.*;

public abstract class EntryTest {

    protected Entry testEntry;
    protected Date testDate;
    protected Time testTime;
    protected String testLabel;

    protected void init() {
        testDate = new Date(7, 23, 2021);
        testTime = new Time(0, 30);
        testLabel = "Test Entry";
    }

    protected void testConstructor() {
        assertEquals(testEntry.getDate().getMonth(), 7);
        assertEquals(testEntry.getDate().getDay(), 23);
        assertEquals(testEntry.getDate().getYear(), 2021);
        assertEquals(testEntry.getTime().getHours(), 0);
        assertEquals(testEntry.getTime().getMinutes(), 30);
        assertEquals(testEntry.getLabel(), "Test Entry");
        assertFalse(testEntry.isRepeating());
        assertEquals(testEntry.getInterval(), null);
    }

    protected void testSetRepeating() {
        assertFalse(testEntry.isRepeating());
        testEntry.setRepeating(true);
        assertTrue(testEntry.isRepeating());
        testEntry.setRepeating(false);
        assertFalse(testEntry.isRepeating());
    }

    protected void testSetInterval() {
        assertEquals(testEntry.getInterval(), null);
        testEntry.setInterval("Test Interval");
        assertEquals(testEntry.getInterval(), "Test Interval");
    }
}
