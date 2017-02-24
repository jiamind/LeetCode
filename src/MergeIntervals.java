import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 2/23/17.
 */
public class MergeIntervals {

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
        if (intervals == null || intervals.size() <= 1) return intervals;

        intervals.sort((interval1,interval2) -> Integer.compare(interval1.start, interval2.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals){
            if(end >= i.start){
                end = Math.max(end, i.end);
            }else{
                result.add(new Interval(start,end));
                start = i.start;
                end = i.end;
            }
        }
        result.add(new Interval(start,end));

        return result;
    }

}
