package test;

import exception.AttendeeAlreadyExists;
import exception.AttendeeNotFound;
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

        try {
            testMeeting.addAttendees("attendee1@test.org");
            testMeeting.addAttendees("attendee2@test.org");
        } catch (AttendeeAlreadyExists e) {
            fail();
        }
        assertEquals(testMeeting.getAttendees().size(), 2);

        try {
            testMeeting.addAttendees("attendee1@test.org");
            fail();
        } catch (AttendeeAlreadyExists e) {

        }
        assertEquals(testMeeting.getAttendees().size(), 2);

        try {
            testMeeting.removeAttendee("attendee3@test.org");
            fail();
        } catch (AttendeeNotFound e) {

        }
        assertEquals(testMeeting.getAttendees().size(), 2);

        try {
            testMeeting.removeAttendee("attendee2@test.org");
        } catch (AttendeeNotFound e) {
            fail();
        }
        assertEquals(testMeeting.getAttendees().size(), 1);
    }

    @Test
    public void testSendInvites() {
        assertFalse(testMeeting.sendInvites());
        testMeeting.addAttendees("attendee1@test.org");
        assertTrue(testMeeting.sendInvites());
    }
}
