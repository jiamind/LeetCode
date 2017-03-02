import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jmding on 2/23/17.
 */
public class InsertInterval {


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


//    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//
//        List<Interval> result = new ArrayList<>();
//        if (intervals == null){
//            result.add(newInterval);
//            return result;
//        }
//        if (intervals.size() == 0){
//            intervals.add(newInterval);
//            return intervals;
//        }
//
//        if (newInterval.end < intervals.get(0).start){
//            result.add(newInterval);
//            result.addAll(intervals);
//            return result;
//        }
//        if (newInterval.start > intervals.get(intervals.size()-1).end){
//            intervals.add(newInterval);
//            return intervals;
//        }
//
//        int left = 0, right = intervals.size(), start = 0;
//
//        while (left < right){
//            int mid = (left + right) / 2;
//            if (intervals.get(mid).start < newInterval.start){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
//        }
//        start = left;
//
//        if (newInterval.start < intervals.get(0).start) {
//            intervals.add(0, newInterval);
//        } else {
//            intervals.add(start, newInterval);
//        }
//
//        Interval cur = intervals.get(start-1 < 0 ? 0 : start - 1);
//        for (int i = start - 1 < 0 ? 1 : start; i < intervals.size(); i++){
//            Interval next = intervals.get(i);
//            if (cur.end >= next.start){
//                cur.end = Math.max(cur.end,next.end);
//                intervals.remove(i);
//                i--;
//            }else {
//                cur = next;
//            }
//        }
//
//        return intervals;
//    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        // Pointer points to the current index we're looking at
        int i = 0;
        // Add all intervals that end before new interval starts to the result list. No change needed for these non-overlapping intervals
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));

        // Merge all intervals that start before new interval ends by taking the min start as new start and max end as new end
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        // Add merged new interval to the result list
        result.add(newInterval);
        // Add the rest of the non-overlapping intervals.
        while (i < intervals.size()) result.add(intervals.get(i++));

        return result;

    }

    public static void main(String[] args) {
//        Interval i1 = new Interval(1,2);
//        Interval i2 = new Interval(3,5);
//        Interval i3 = new Interval(6,7);
//        Interval i4 = new Interval(8,10);
//        Interval i5 = new Interval(12,16);
//
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(i1);
//        intervals.add(i2);
//        intervals.add(i3);
//        intervals.add(i4);
//        intervals.add(i5);

//        Interval i1 = new Interval(0,2);
//        Interval i2 = new Interval(3,9);
//
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(i1);
//        intervals.add(i2);

        Interval i1 = new Interval(1,5);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);

        Interval newInterval = new Interval(1,7);

        List<Interval> result = insert(intervals,newInterval);

        for (Interval i : intervals){
            System.out.print("[" + i.start + "," + i.end + "] ");
        }
    }
}