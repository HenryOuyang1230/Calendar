package model;

public class Time {

    private int hours;
    private int minutes;

    // REQUIRES: hours and minutes should both be valid in 24-hour format;
    //           i.e. 0 <= hours <= 24
    //                0 <= minutes <= 60
    // EFFECTS: constructs a new time with hours and minutes
    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    // EFFECTS: returns hours
    public int getHours() {
        return hours;
    }

    // EFFECTS: returns minutes
    public int getMinutes() {
        return minutes;
    }

    // returns a string of time in format "HH:MM"
    public String getTime() {
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes);
    }
}
