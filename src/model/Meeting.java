package model;

import exception.AttendeeAlreadyExists;
import exception.AttendeeNotFound;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event {

    private List<String> attendees;

    // EFFECTS: constructs a new meeting, with no attendees
    public Meeting(Date date, Time time, String label) {
        super(date, time, label);
        attendees = new ArrayList<>();
    }

    // EFFECTS: returns list of attendees
    public List<String> getAttendees() {
        return attendees;
    }

    // MODIFIES: this
    // EFFECTS: if attendee is not in this.attendees, adds it to this.attendees;
    //          otherwise, throws AttendeeAlreadyExists
    public void addAttendee(String attendee) {
        if (attendees.contains(attendee)) {
            throw new AttendeeAlreadyExists();
        }
        attendees.add(attendee);
    }

    // MODIFIES: this
    // EFFECTS: if attendee is already in this.attendees, removes it from this.attendees
    //          otherwise, throws AttendeeNotFound
    public void removeAttendee(String attendee) {
        if (!attendees.contains(attendee)) {
            throw new AttendeeNotFound();
        }
        attendees.remove(attendee);
    }

    // EFFECTS: if there are no attendees, returns false;
    //          otherwise, sends invitations to all attendees and returns true
    public boolean sendInvites() {
        if (attendees.isEmpty()) {
            return false;
        }
        for (String a : attendees) {
            System.out.println("Inviting: " + a);
        }
        return true;
    }
}
