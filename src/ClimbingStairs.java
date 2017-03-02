/**
 * Created by udingji on 3/2/17.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        // If there is no step, there is no way to reach the top
        if(n <= 0) return 0;
        // If there is one step, there is one way to reach the top (one single step)
        if(n == 1) return 1;
        // If there are two steps, there are two ways to reach the top
        // (two single steps, or one step of two steps)
        if(n == 2) return 2;

        // Number of steps to reach the previous step
        int one_step_before = 2;
        // Number of steps to reach two steps before
        int two_steps_before = 1;
        // Number of ways to reach the current position
        int all_ways = 0;

        // Starting from the third step, climbing to the top
        for(int i=2; i<n; i++){
            // The number of ways to reach the current step is the number of ways to reach the previous step, plus the number of ways to reach two steps before
            // (we cannot step on the previous step when calculate number of steps from two steps before,
            // that scenario is already included in the calculation from the previous step,
            // so there is only one way to get to the current position from two steps before)
            all_ways = one_step_before + two_steps_before;
            // To get prepared for the next step, two steps before the next step is one step before the current step
            two_steps_before = one_step_before;
            // One step before the next step is the current step
            one_step_before = all_ways;
        }
        return all_ways;
    }

}
