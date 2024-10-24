package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

class Date {
    List<int[]> ranges = new ArrayList<>();
    List<int[]> overlaps = new ArrayList<>();

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps)
            if (Math.max(start, overlap[0]) < Math.min(end, overlap[1]))
                return false;
//        Brute force approach

        for (int[] range : ranges) {
            final int maxStart = Math.max(start, range[0]);
            final int minEnd = Math.min(end, range[1]);
            if (maxStart < minEnd)
                overlaps.add(new int[] {maxStart, minEnd});
        }

        ranges.add(new int[] {start, end});
        return true;
    }
}

public class MyCalendertwo {
    public static void main(String[] args) {
        Date myCalendar = new Date();

        System.out.println(myCalendar.book(10, 20)); // true
        System.out.println(myCalendar.book(50, 60)); // true
        System.out.println(myCalendar.book(10, 40)); // true
        System.out.println(myCalendar.book(5, 15));  // false
        System.out.println(myCalendar.book(5, 10));  // true
        System.out.println(myCalendar.book(25, 55)); // true
    }
}

