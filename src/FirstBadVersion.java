/**
 * Created by udingji on 5/11/17.
 */
public class FirstBadVersion {

    // Idea: use divide and conquer. Time complexity O(logn)
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version){
        return true;
    }
}
