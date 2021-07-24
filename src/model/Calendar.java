package model;

import exception.EntryAlreadyExists;
import exception.EntryNotFound;

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

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: if entry is not in this.entries, adds it to this.entries;
    //          otherwise, throws EntryAlreadyExists
    public void addEntry(Entry entry) {
        if (entries.contains(entry)) {
            throw new EntryAlreadyExists();
        }
        entries.add(entry);
    }

    // MODIFIES: this
    // EFFECTS: if entry is in this.entries, removes it from this.entries;
    //          otherwise, throws EntryNotFound and continues
    public void removeEntry(Entry entry) {
        if (!entries.contains(entry)) {
            throw new EntryNotFound();
        }
        entries.remove(entry);
    }

    // EFFECTS: returns list of all meetings
    public List<Meeting> getMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        for (Entry e : entries) {
            if (e instanceof Meeting) {
                meetings.add((Meeting) e);
            }
        }
        return meetings;
    }

    // EFFECTS: if an entry with label is in this.entries, returns it;
    //          otherwise, throws EntryNotFound
    public Entry getEntry(String label) {
        for (Entry e : entries) {
            if (e.getLabel().equals(label)) {
                return e;
            }
        }
        throw new EntryNotFound();
    }

    // EFFECTS: prints out dates, times, labels, whether repeating of all entries
    public void printEntries() {
        for (Entry e : entries) {
            String repLabel;
            if (e.isRepeating()) {
                repLabel = "Yes";
            } else {
                repLabel = "No";
            }
            System.out.println(e.getLabel() + "\t" + e.getDate().getShortFormat() + " " +
                    e.getTime().getTime() + "\tRepeating: " + repLabel);
        }
    }

    // EFFECTS: prints out dates, time, labels, and special notes of all reminders for events
    public void printEventReminders() {
        for (Entry e : entries) {
            if (e instanceof Reminder) {
                System.out.println("!!!Reminder: " + e.getDate().getShortFormat() + " " +
                        e.getTime().getTime() + " " + ((Reminder) e).getNote());
            } else if (e instanceof Event) {
                if (((Event) e).getReminder() != null) {
                    System.out.println("!!!Reminder: " + e.getDate().getShortFormat() + " " +
                            e.getTime().getTime() + " " + ((Event) e).getReminder().getNote());
                }
            }
        }
    }

    // EFFECTS: sends invitations for all meetings
    public void inviteMeetings() {
        for (Meeting m : getMeetings()) {
            m.sendInvites();
        }
    }
}
