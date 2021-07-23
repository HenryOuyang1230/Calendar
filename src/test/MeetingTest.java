package test;

import model.Meeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest extends EventTest {

    private Meeting testMeeting;

    @BeforeEach
    @Override
    public void init() {
        super.init();
        testEvent = new Meeting(testDate, testTime, testLabel);
        testMeeting = (Meeting) testEvent;
    }

    @Test
    @Override
    public void testConstructor() {
        super.testConstructor();
        assertEquals(testMeeting.getAttendees().size(), 0);
    }

    @Test
    public void testAddRemoveAttendees() {
        assertEquals(testMeeting.getAttendees().size(), 0);
        testMeeting.addAttendees("attendee1@test.org");
        testMeeting.addAttendees("attendee2@test.org");
        assertEquals(testMeeting.getAttendees().size(), 2);
        testMeeting.removeAttendee("attendee2@test.org");
        assertEquals(testMeeting.getAttendees().size(), 1);
    }

    @Test
    public void testSendInvites() {
        assertFalse(testMeeting.sendInvites());
        testMeeting.addAttendees("attendee1@test.org");
        assertTrue(testMeeting.sendInvites());
    }
}
