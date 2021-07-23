package test;

import model.Event;
import model.Reminder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest extends EntryTest {

    protected Event testEvent;

    @BeforeEach
    @Override
    public void init() {
        super.init();
        testEntry = new Event(testDate, testTime, testLabel);
        testEvent = (Event) testEntry;
    }

    @Test
    @Override
    public void testConstructor() {
        super.testConstructor();
        assertEquals(testEvent.getReminder(), null);

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
    public void testSetReinder() {
        Reminder testReminder = new Reminder(testDate, testTime, "Test Reminder");
        assertEquals(testEvent.getReminder(), null);
        testEvent.setReminder(testReminder);
        assertEquals(testEvent.getReminder().getLabel(), "Test Reminder");
    }
}
