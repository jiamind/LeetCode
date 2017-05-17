import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by udingji on 5/16/17.
 */
public class CourseScheduleII {

    // Similar idea as alien dictionary
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0)
            return new int[]{0};

        Hashtable<Integer,Set<Integer>> coursesComesAfter = new Hashtable<>();
        Hashtable<Integer,Integer> numOfCoursesToTake = new Hashtable<>();

        for (int i = 0; i < prerequisites.length; i++){
            if (!coursesComesAfter.containsKey(prerequisites[i][1])){
                Set<Integer> set = new HashSet<>();
                set.add(prerequisites[i][0]);
                coursesComesAfter.put(prerequisites[i][1],set);
            } else {
                coursesComesAfter.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            if (!numOfCoursesToTake.containsKey(prerequisites[i][1]))
                numOfCoursesToTake.put(prerequisites[i][1],0);

            if (!numOfCoursesToTake.containsKey(prerequisites[i][0])){
                numOfCoursesToTake.put(prerequisites[i][0],1);
            } else {
                numOfCoursesToTake.put(prerequisites[i][0],numOfCoursesToTake.get(prerequisites[i][0]) + 1);
            }
        }

        int firstCourse = -1;
        int[] result = new int[numCourses];
        int index = 0;

        for (int i : numOfCoursesToTake.keySet()){
            if (numOfCoursesToTake.get(i) == 0)
                firstCourse = i;
        }

        if (firstCourse == -1)
            return new int[]{0};

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(firstCourse);
        while (!queue.isEmpty()){
            int currentCourse = queue.poll();
            result[index++] = currentCourse;
            Set<Integer> nextCourses = coursesComesAfter.get(currentCourse);
            if (nextCourses != null) {
                for (int course : nextCourses) {
                    numOfCoursesToTake.put(course, numOfCoursesToTake.get(course) - 1);
                    if (numOfCoursesToTake.get(course) == 0) {
                        queue.offer(course);
                    }
                }
            }
        }

        return index == numCourses ? result : new int[]{0};
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[1][];
        prerequisites[0] = new int[]{1,0};
        System.out.println(findOrder(numCourses,prerequisites));
    }
}
