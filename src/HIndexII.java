/**
 * Created by udingji on 5/18/17.
 */
public class HIndexII {

    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0)
            return 0;

        int left = 0, right = citations.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return citations.length - (right + 1);
    }

}
