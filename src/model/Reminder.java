package model;

public class Reminder extends Entry {

    private String note;

    // EFFECTS: constructs a new reminder, without note
    public Reminder(Date date, Time time, String label) {
        super(date, time, label);
        note = null;
    }

    // EFFECTS: returns note
    public String getNote() {
        return note;
    }

    // MODIFIES: this
    // EFFECTS: sets this.note to note
    public void setNote(String note) {
        this.note = note;
    }
}
