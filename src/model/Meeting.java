package model;

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

    // REQUIRES: attendee is not in this.attendees
    // MODIFIES: this
    // EFFECTS: adds attendee to this.attendees
    public void addAttendees(String attendee) {
        attendees.add(attendee);
    }

    // REQUIRES: attendee is already in this.attendees
    // MODIFIES: this
    // EFFECTS: removes attendee from this.attendees
    public void removeAttendee(String attendee) {
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
