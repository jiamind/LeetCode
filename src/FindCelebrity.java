/**
 * Created by udingji on 5/12/17.
 */
public class FindCelebrity {


    boolean knows(int a, int b){
        return true;
    }

    // Question:
    // Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
    // Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
    // You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
    // Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

    // Idea: Take the first person as celebrity candidate. Iterate through all people.
    // If the candidate knows any one, the candidate cannot be the celebrity. update the candidate to the current person
    // Iterate through all people again. when i is less than the candidate, if candidate knows i or i doesn't know the candidate, the candidate cannot be the celebrity
    // When i is greater than the candidate, we only need to check if i knows the candidate,
    // since we already checked whether candidate knows all i after itself in the first iteration
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++){
            // In the meantime, if candidate does not know i, i also cannot be the candidate (celebrity) since everyone should know the celebrity
            // Therefore we only set candidate to growing i, those passed i cannot be the celebrity
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
