package model;

public class Event extends Entry {

    private Reminder reminder;

    // EFFECTS: constructs a new event, not repeating, without reminder
    public Event(Date date, Time time, String label) {
        super(date, time, label);
        reminder = null;
    }

    // EFFECTS: returns reminder
    public Reminder getReminder() {
        return reminder;
    }

    // MODIFIES: this
    // EFFECTS: sets this.reminder to reminder
    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
}
