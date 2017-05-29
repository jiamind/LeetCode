/**
 * Created by udingji on 5/18/17.
 */
public class HIndexII {

    // Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0)
            return 0;

        int left = 0, right = citations.length;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid)
                return citations.length - mid;

            if (citations[mid] < citations.length - mid)
                left = mid + 1;
            else
                right = mid;
        }

        return citations.length - left;
    }

}
