package model;

public abstract class Entry {

    protected Date date;
    protected Time time;
    protected String label;
    protected boolean repeating;
    protected String interval;

    // EFFECTS: constructs a new entry of calendar, not repeating
    public Entry(Date date, Time time, String label) {
        this.date = date;
        this.time = time;
        this.label = label;
        this.repeating = false;
        this.interval = null;
    }

    // EFFECTS: returns date
    public Date getDate() {
        return date;
    }

    // EFFECTS: returns time
    public Time getTime() {
        return time;
    }

    // EFFECTS: returns label
    public String getLabel() {
        return label;
    }

    // EFFECTS: returns true if the entry is repeating
    public boolean isRepeating() {
        return repeating;
    }

    // MODIFIES: this
    // EFFECTS: sets this.repeating to repeating
    public void setRepeating(boolean repeating) {
        this.repeating = repeating;
    }

    // EFFECTS: returns interval of repetition
    public String getInterval() {
        return interval;
    }

    // MODIFIES: this
    // EFFECT: sets interval of repetition to interval
    public void setInterval(String interval) {
        this.interval = interval;
    }
}
