package test;

import model.Reminder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReminderTest extends EntryTest {

    private Reminder testReminder;

    @BeforeEach
    @Override
    public void init() {
        super.init();
        testEntry = new Reminder(testDate, testTime, testLabel);
        testReminder = (Reminder) testEntry;
    }

    @Test
    @Override
    public void testConstructor() {
        super.testConstructor();
        assertEquals(testReminder.getNote(), null);
    }

    @Test
    @Override
    public void testSetRepeating() {
        super.testSetRepeating();
    }

    @Test
    @Override
    public void testSetInterval() {
        super.testSetInterval();
    }

    @Test
    public void testSetNote() {
        assertEquals(testReminder.getNote(), null);
        testReminder.setNote("Test Reminder");
        assertEquals(testReminder.getNote(), "Test Reminder");
    }
}
