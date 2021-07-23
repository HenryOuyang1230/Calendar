package model;

public class Date {

    private static String[] months =
            {"January", "February", "March", "April", "May", "June", "July",
                    "August", "September", "October", "November", "December"};

    private int month;
    private int day;
    private int year;

    // REQUIRES: month, day, year are all valid;
    //           i.e. 1 <= month <= 12
    //                1 <= day <= 31
    //                0 <= year
    // EFFECTS: constructs a new date with month, day, and year
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // EFFECTS: returns month
    public int getMonth() {
        return month;
    }

    // EFFECTS: returns day
    public int getDay() {
        return day;
    }

    // EFFECTS: returns year
    public int getYear() {
        return year;
    }

    // EFFECTS: returns a string of date in format "MM/DD/YYYY"
    public String getShortFormat() {
        return getMonthShortString() + "/" + getDayShortString() + "/" + getYearString();
    }

    // EFFECTS: returns a string of date in format like "January 1, 2017"
    public String getLongFormat() {
        return getMonthLongString() + " " + getDayLongString() + ", " + getYearString();
    }

    // EFFECTS: returns a string of month in format "MM"
    private String getMonthShortString() {
        return String.format("%02d", month);
    }

    // EFFECTS: returns a string of month in english, e.g. "January"
    private String getMonthLongString() {
        return months[month - 1];
    }

    // EFFECTS: returns a string of day in format "DD"
    private String getDayShortString() {
        return String.format("%02d", day);
    }

    // EFFECTS: returns a string of day in format "1st", "2nd", etc.
    private String getDayLongString() {
        String dayStr = String.valueOf(day);
        switch (dayStr.substring(1)) {
            case "1":
                dayStr += "st";
                break;
            case "2":
                dayStr += "nd";
                break;
            case "3":
                dayStr += "rd";
                break;
            default:
                dayStr += "th";
                break;
        }
        return dayStr;
    }

    // EFFECTS: returns a string of year in format "YYYY"
    private String getYearString() {
        return String.format("%04d", year);
    }
}
