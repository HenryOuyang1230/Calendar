package test;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalendarTest {

    Date currentDate = new Date(7, 23, 2021);
    Date testDate = new Date(7, 28, 2021);
    Time testTime = new Time(9, 0);
    Reminder testReminder = new Reminder(testDate, testTime, "Reminder Label");
    Event testEvent = new Event(testDate, testTime, "Event Label");
    Meeting testMeeting = new Meeting(testDate, testTime, "Meeting Label");
    Calendar testCalendar = new Calendar(currentDate, "admin@test-calendar.com");

    @BeforeEach
    public void init() {
        
    }

    @Test
    public void testConstructor() {

    }
}
