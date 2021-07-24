package ui;

import model.*;

public class CalendarDemo {

    public static void main(String[] args) {
        // setting up reminders
        Reminder reminderForEvent = new Reminder(new Date(7, 23, 2021),
                new Time(0, 30), "Reminder for My Event");
        reminderForEvent.setRepeating(true); // this reminder is repeating
        reminderForEvent.setInterval("This is the interval of Reminder for My Event.");
        reminderForEvent.setNote("This is the reminder for My Event.");

        Reminder reminderForMeeting = new Reminder(new Date(7, 23, 2021),
                new Time(0, 30), "Reminder for My Meeting");
        reminderForMeeting.setRepeating(false); // this reminder is NOT repeating
        reminderForMeeting.setNote("This is the reminder for My meeting.");

        // setting up entry 1 (event)
        Event myEvent = new Event(new Date(7, 23, 2021),
                new Time(0, 30), "My Event");
        myEvent.setRepeating(true); // this event is repeating
        myEvent.setInterval("This is the interval of My Event.");
        myEvent.setReminder(reminderForEvent);

        // setting up entry 2 (meeting)
        Meeting myMeeting = new Meeting(new Date(7, 24, 2021),
                new Time(6, 30), "My Meeting");
        myMeeting.setRepeating(false); // this meeting is NOT repeating
        myMeeting.setReminder(reminderForMeeting);
        myMeeting.addAttendee("attendee1@example.com");
        myMeeting.addAttendee("attendee2@example.com");

        // setting up calendar
        Calendar myCalendar = new Calendar(new Date(7, 22, 2021),
                "myemailaddress@example.com");
        myCalendar.addEntry(myEvent);
        myCalendar.addEntry(myMeeting);

        // testing calendar
        System.out.println("### Entries ###");
        myCalendar.printEntries();
        System.out.println();

        System.out.println("### Reminders ###");
        myCalendar.printEventReminders();
        System.out.println();

        System.out.println("### Invitations ###");
        myCalendar.inviteMeetings();
        System.out.println();
    }
}
