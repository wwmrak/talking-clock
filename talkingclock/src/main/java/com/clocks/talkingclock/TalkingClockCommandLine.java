package com.clocks.talkingclock;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TalkingClockCommandLine {
    private static final Map<Integer, String> timeMap = new HashMap<>();
    private static final String O_CLOCK = "o'clock";
    private static final String PAST = "past";
    private static final String HALF = "half";
    private static final String SPACE = " ";
    private static final String TO = "to";

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        int hours = dateTime.getHour();
        int minutes = dateTime.getMinute();

        if (hours > 12) hours = hours - 12;

        if (minutes == 0)
            System.out.println(timeMap.get(hours) + O_CLOCK);
        else if (minutes > 0 && minutes < 30) {
            System.out.println(timeMap.get(minutes) + SPACE + PAST + SPACE + timeMap.get(hours));
        }
        else if (minutes == 30) {
            System.out.println(HALF + SPACE + PAST + SPACE + timeMap.get(hours));
        }
        else if (minutes > 30 && minutes < 60) {
            int minutesToHour = 60 - minutes;

            if (hours == 12)
                hours = 1;
            else
                hours = hours + 1;

            System.out.println(timeMap.get(minutesToHour) + SPACE + TO + SPACE + timeMap.get(hours));
        }
    }

    static {
        timeMap.put(0, "twelve");
        timeMap.put(1, "one");
        timeMap.put(2, "two");
        timeMap.put(3, "three");
        timeMap.put(4, "four");
        timeMap.put(5, "five");
        timeMap.put(6, "six") ;
        timeMap.put(7, "seven");
        timeMap.put(8, "eight") ;
        timeMap.put(9, "nine");
        timeMap.put(10, "ten");
        timeMap.put(11, "eleven");
        timeMap.put(12, "twelve");
        timeMap.put(13, "thirteen");
        timeMap.put(14, "fourteen");
        timeMap.put(15, "fifteen");
        timeMap.put(16, "sixteen");
        timeMap.put(17, "seventeen");
        timeMap.put(18, "eighteen");
        timeMap.put(19, "nineteen") ;
        timeMap.put(20, "twenty") ;
        timeMap.put(21, "twenty one");
        timeMap.put(22, "twenty two") ;
        timeMap.put(23, "twenty three");
        timeMap.put(24, "twenty four");
        timeMap.put(25, "twenty five");
        timeMap.put(26, "twenty six");
        timeMap.put(27, "twenty seven");
        timeMap.put(28, "twenty eight");
        timeMap.put(29, "twenty nine");
    }
}


