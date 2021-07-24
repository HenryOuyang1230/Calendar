package test;

import exception.EntryAlreadyExists;
import exception.EntryNotFound;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarTest {

    Date testDate, currentDate;
    Time testTime;
    Reminder testReminder;
    Event testEvent;
    Meeting testMeeting;
    Calendar testCalendar;

    @BeforeEach
    public void init() {
        currentDate = new Date(7, 23, 2021);
        testDate = new Date(7, 28, 2021);
        testTime = new Time(9, 0);
        testReminder = new Reminder(testDate, testTime, "Reminder");
        testEvent = new Event(testDate, testTime, "Event");
        testMeeting = new Meeting(testDate, testTime, "Meeting with Reminder");
        testMeeting.setReminder(testReminder);
        testCalendar = new Calendar(currentDate, "admin@test-calendar.com");
    }

    @Test
    public void testConstructor() {
        assertEquals(testCalendar.getDate().getMonth(), currentDate.getMonth());
        assertEquals(testCalendar.getDate().getDay(), currentDate.getDay());
        assertEquals(testCalendar.getDate().getYear(), currentDate.getYear());
        assertEquals(testCalendar.getEmail(), "admin@test-calendar.com");
        assertEquals(testCalendar.getEntries().size(), 0);
    }

    @Test
    public void testAddRemoveEntry() {
        assertEquals(testCalendar.getEntries().size(), 0);

        try {
            testCalendar.addEntry(testEvent);
            testCalendar.addEntry(testMeeting);
        } catch (EntryAlreadyExists e) {
            fail();
        }
        assertEquals(testCalendar.getEntries().size(), 2);
        assertTrue(testCalendar.getEntries().contains(testEvent));
        assertTrue(testCalendar.getEntries().contains(testMeeting));

        try {
            testCalendar.addEntry(testEvent);
            fail();
        } catch (EntryAlreadyExists e) {

        }
        assertEquals(testCalendar.getEntries().size(), 2);
        assertTrue(testCalendar.getEntries().contains(testEvent));
        assertTrue(testCalendar.getEntries().contains(testMeeting));

        try {
            testCalendar.removeEntry(new Event(testDate, testTime, "Non-existed event"));
            fail();
        } catch (EntryNotFound e) {

        }
        assertEquals(testCalendar.getEntries().size(), 2);
        assertTrue(testCalendar.getEntries().contains(testEvent));
        assertTrue(testCalendar.getEntries().contains(testMeeting));

        try {
            testCalendar.removeEntry(testMeeting);
        } catch (EntryNotFound e) {
            fail();
        }
        assertEquals(testCalendar.getEntries().size(), 1);
        assertTrue(testCalendar.getEntries().contains(testEvent));
        assertFalse(testCalendar.getEntries().contains(testMeeting));
    }

    @Test
    public void testGetMeetings() {
        assertEquals(testCalendar.getEntries().size(), 0);
        assertEquals(testCalendar.getMeetings().size(), 0);

        testCalendar.addEntry(testEvent);
        testCalendar.addEntry(testMeeting);
        testCalendar.addEntry(testReminder);

        assertEquals(testCalendar.getEntries().size(), 3);
        assertEquals(testCalendar.getMeetings().size(), 1);
    }

    @Test
    public void testGetEntry() {
        assertEquals(testCalendar.getEntries().size(), 0);

        testCalendar.addEntry(testEvent);
        testCalendar.addEntry(testMeeting);
        testCalendar.addEntry(testReminder);
        assertEquals(testCalendar.getEntries().size(), 3);

        try {
            assertSame(testCalendar.getEntry("Reminder"), testReminder);
            assertSame(testCalendar.getEntry("Event"), testEvent);
            assertSame(testCalendar.getEntry("Meeting with Reminder"), testMeeting);
        } catch (EntryNotFound e) {
            fail();
        }

        try {
            testCalendar.getEntry("Non-existed Entry");
            fail();
        } catch (EntryNotFound e) {

        }
    }

    @Test
    public void testInviteMeetings() {
        assertEquals(testCalendar.getEntries().size(), 0);

        testCalendar.addEntry(testEvent);
        testCalendar.addEntry(testMeeting);
        testCalendar.addEntry(testReminder);

        for (Meeting m : testCalendar.getMeetings()) {
            if (m.getAttendees().isEmpty()) {
                assertFalse(m.sendInvites());
            } else {
                assertTrue(m.sendInvites());
            }
        }
    }
}
