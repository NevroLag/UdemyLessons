package PetProject_1.one.T2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

public class WorkReminder {
    private static final long DAYS_IN_WEEK = 7;
    private static final long WEEKS_BETWEEN_NOTIFICATIONS = 3;
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate nextWorkDay = today.plus(WEEKS_BETWEEN_NOTIFICATIONS, ChronoUnit.WEEKS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        long daysToWork = ChronoUnit.DAYS.between(today, nextWorkDay);

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("It's time to go to work! Next work day is on " + nextWorkDay.format(formatter));
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, daysToWork * 24 * 60 * 60 * 1000);
    }
}

