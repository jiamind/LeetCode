/**
 * Created by udingji on 5/12/17.
 */
public class FindCelebrity {


    boolean knows(int a, int b){
        return true;
    }

    // Idea: Take the first person as celebrity candidate. Iterate through all people.
    // If the candidate knows any one, the candidate cannot be the celebrity. update the candidate to the current person
    // Iterate through all people again. when i is less than the candidate, if candidate knows i or i doesn't know the candidate, the candidate cannot be the celebrity
    // When i is greater than the candidate, we only need to check if i knows the candidate,
    // since we already checked whether candidate knows all i after itself in the first iteration
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++){
            if (knows(candidate,i))
                candidate = i;
        }
        for (int i = 0; i < n; i++){
            if (i > candidate && (knows(candidate,i) || !knows(i,candidate)))
                return -1;
            if (i < candidate && !knows(i,candidate))
                return -1;
        }
        return candidate;
    }
}
