import java.util.*;
import java.util.PriorityQueue;

/**
 * Created by udingji on 5/11/17.
 */
public class MeetingRoomsII {

    private class Interval {

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

    // Problem: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    // Example:
    // Given [[0, 30],[5, 10],[15, 20]],
    // return 2.

    // Idea: sort the intervals base on start time. Add the end time of the first interval to the queue
    // Iterate through the intervals, if the start time is before the earliest ending in the queue, we need a new meeting room.
    public int minMeetingRooms(Interval[] intervals) {

        // If the interval array is null, or the length of the interval array is 0
        // We need no meeting room
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the interval array base on the starting time
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        // For the first interval, we need one meeting room
        int result = 1;
        // Create a priority queue to keep track of the end time of each meeting room.
        // It will return the earliest end time of all meeting rooms currently in use
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].end);

        // Iterate through all other intervals
        for (int i = 1; i < intervals.length; i++){
            Interval current = intervals[i];
            // If the start time of the current interval is greater than the earliest ending meeting room
            // We can just use that meeting room! no more meeting room is needed in this case
            // Poll the old ending time from the queue and update with the new ending time for that meeting room
            // Otherwise, we need a new meeting room to host this interval.
            // Increment the room counter and add the ending time of this interval to the queue
            if (current.start >= queue.peek()){
                queue.poll();
            } else {
                result++;
            }
            queue.offer(current.end);
        }
        return result;
    }
}
