package model;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private Date date;
    private String email;
    private List<Entry> entries;

    // EFFECTS: constructs a new calendar with current date and associated email, with empty entries
    public Calendar(Date date, String email) {
        this.date = date;
        this.email = email;
        this.entries = new ArrayList<>();
    }

    // EFFECTS: returns date
    public Date getDate() {
        return date;
    }

    // EFFECTS: returns email
    public String getEmail() {
        return email;
    }

    // EFFECTS: returns list of all entries
    public List<Entry> getEntries() {
        return entries;
    }

    // REQUIRES: entry is not in this.entries
    // MODIFIES: this
    // EFFECTS: adds entry to this.entries
    public void addEntry(Entry entry) {
        // stub
    }

    // REQUIRES: entry is already in this.entries
    // MODIFIES: this
    // EFFECTS: removes entry from this.entries
    public void removeEntry(Entry entry) {
        // stub
    }

    // EFFECTS: returns list of all meetings
    public List<Entry> getMeetings() {
        return null; // stub
    }

    // EFFECTS: returns entry with given label
    public Entry getEntry(String label) {
        return null; // stub
    }

    // EFFECTS: prints out dates, times, labels, whether repeating of all entries
    public void printEntries() {
        // stub
    }

    // EFFECTS: prints out dates, time, labels, and special notes of all reminders for events
    public void printEventReminders() {
        // stub
    }

    // EFFECTS: sends invitations for all meetings
    public void inviteMeetings() {
        // stub
    }
}
