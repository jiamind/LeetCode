import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 2/23/17.
 */
public class MergeIntervals {

    // Given a collection of intervals, merge all overlapping intervals.

    // For example,
    // Given [1,3],[2,6],[8,10],[15,18],
    // return [1,6],[8,10],[15,18].

    private static class Interval {
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


    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<>();
        // If the intervals is null or the size of the intervals is 1, return the intervals
        if (intervals == null || intervals.size() <= 1) return intervals;

        // Sort intervals base on start value (quick sort, O(nlogn)
        intervals.sort((interval1,interval2) -> Integer.compare(interval1.start, interval2.start));

        // The start and end of the first interval
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        // Iterate through the intervals
        for (Interval i : intervals){
            // If the previous end is greater than the current start, there is a overlap
            if(end >= i.start){
                // The end will be the max end, start is the previous start since previous start is smaller
                end = Math.max(end, i.end);
            }else{
                // The two intervals don't overlap, add the previous one to the result list.
                // Set the current start and end as the new start and end to compare with the next interval
                result.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
        }
        result.add(new Interval(start,end));

        return result;
    }

}
