package ui;

import model.*;

public class CalendarDemo {

    public static void main(String[] args) {
        System.out.println("Loading demo of this calendar app...");
        System.out.println();

        // setting up reminders
        System.out.println("Setting up reminders (1/2)...");
        Reminder reminderForEvent = new Reminder(new Date(7, 23, 2021),
                new Time(0, 30), "Reminder for My Event");
        reminderForEvent.setRepeating(true); // this reminder is repeating
        reminderForEvent.setInterval("This is the interval of Reminder for My Event.");
        reminderForEvent.setNote("This is the reinder for My Event.");
        System.out.println("Done.");

        System.out.println("Setting up reminders (2/2)...");
        Reminder reminderForMeeting = new Reminder(new Date(7, 23, 2021),
                new Time(0, 30), "Reminder for My Meeting");
        reminderForMeeting.setRepeating(false); // this reminder is NOT repeating
        reminderForMeeting.setNote("This is the reminder for My meeting.");
        System.out.println("Done.");

        // setting up entry 1 (event)
        System.out.println("Setting up entries (1/2)...");
        Event myEvent = new Event(new Date(7, 23, 2021),
                new Time(0, 30), "My Event");
        myEvent.setRepeating(true); // this event is repeating
        myEvent.setInterval("This is the interval of My Event.");
        myEvent.setReminder(reminderForEvent);
        System.out.println("Done.");

        // setting up entry 2 (meeting)
        System.out.println("Setting up entries (2/2)...");
        Meeting myMeeting = new Meeting(new Date(7, 24, 2021),
                new Time(6, 30), "My Meeting");
        myMeeting.setRepeating(false); // this meeting is NOT repeating
        myMeeting.setReminder(reminderForMeeting);
        myMeeting.addAttendees("attendee1@example.com");
        myMeeting.addAttendees("attendee2@example.com");
        System.out.println("Done.");

        // setting up calendar
        System.out.println("Setting up calendar...");
        Calendar myCalendar = new Calendar(new Date(7, 22, 2021),
                "myemailaddress@example.com");
        myCalendar.addEntry(myEvent);
        myCalendar.addEntry(myMeeting);
        System.out.println("Done.");

        System.out.println("All set!");
        System.out.println("- Calendar(s): 1");
        System.out.println("\t- Entry(s): " + myCalendar.getEntries().size());
        System.out.println("\t\t- Reminder(s): 2");
        System.out.println("\t\t- Event(s): 1");
        System.out.println("\t\t- Meeting(s): 1");
        System.out.println();

        // testing calendar
        System.out.println("Printing entries...");
        myCalendar.printEntries();
        System.out.println();

        System.out.println("Printing event reminders...");
        myCalendar.printEventReminders();
        System.out.println();

        System.out.println("Sending invitations for all meetings...");
        myCalendar.inviteMeetings();
        System.out.println();
    }
}
