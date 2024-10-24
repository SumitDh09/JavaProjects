package LeetcodeProblems;

 import java.util.ArrayList;
 import java.util.List;

class MyCalendar {
    private final List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

     public static void main(String[] args) {
         MyCalendar myCalendar = new MyCalendar();
         System.out.println(myCalendar.book(10, 20)); // returns true
         System.out.println(myCalendar.book(15, 25)); // returns false
         System.out.println(myCalendar.book(20, 30)); // returns true
     }

    public boolean book(int start, int end) {
        for (int[] event : calendar) {
            if (Math.max(event[0], start) < Math.min(event[1], end)) {
                // There is an overlap
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}