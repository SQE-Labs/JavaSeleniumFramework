package org.automation.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateGenerator {

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }
    public static  String dateTimeGenerator(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println("generated Date is ======   " + date1);
        return date1;
    }

    public static String getDateWithDays(String format, int dayToAdd) {

        LocalDate todayDate = LocalDate.now();
        LocalDate date = LocalDate.parse(todayDate.toString());
        LocalDate date2 = date.plusDays(dayToAdd);
        System.out.println("Date generated  " + date2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date2);
    }
    public static boolean isDateWithinRange(LocalDate startDate, LocalDate endDate, LocalDate dateToCheck) {
        return (dateToCheck.isAfter(startDate) || dateToCheck.isBefore(endDate));
    }

    public static String getCurrentDateTime(String format) {


        Date date = new Date();
        DateFormat pstFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        TimeZone timeZone = TimeZone.getTimeZone("Australia/Canberra");
        pstFormat.setTimeZone(timeZone);
        String current_date_time = pstFormat.format(date);
        System.out.println("Australia/Canberra-" + current_date_time);
        return current_date_time;


    }


}