package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));

    }

    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parseDateTimeString() {
        int year, month, date, hour, minute;
        HashMap<String, Integer> dateMap = new HashMap<String, Integer>();

        year = this.parse(0, 4, "Year", 2000, 2012);
        month = this.parse(5, 7, "Month", 1, 12);
        date = this.parse(8, 10, "Date", 1, 31);
        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = this.parse(11, 13, "Hour", 0, 23);

            minute = this.parse(14, 16, "Minute", 0, 59);

        }

        dateMap.put("Year", year);
        dateMap.put("Month", month);
        dateMap.put("Date", date);
        dateMap.put("Hour", hour);
        dateMap.put("Minute", minute);

        return this.parse(dateMap);
    }

    private Date parse(HashMap<String, Integer> dateMap) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(dateMap.get("Year"), dateMap.get("Month") - 1, dateMap.get("Date"), dateMap.get("Hour"), dateMap.get("Minute"), 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    private int parse(int startIndex, int endIndex, String unitName, int lowerBound, int upperBound) {
        int result = 0;
        try {
            String resultString = dateAndTimeString.substring(startIndex, endIndex);
            result = Integer.parseInt(resultString);

        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(unitName + " string is less than " + (endIndex - startIndex) + " characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(unitName + " is not an integer");
        }

        if (result < lowerBound || result > upperBound)
            throw new IllegalArgumentException(unitName + " cannot be less than " + lowerBound + " or more than " + upperBound);

        return result;
    }
}
