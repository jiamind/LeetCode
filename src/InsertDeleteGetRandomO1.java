import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by udingji on 5/15/17.
 */
public class InsertDeleteGetRandomO1 {

    public class RandomizedSet {

        // Create a hashmap to put each number and its index in the list
        // Also for O(1) access when check for existence
        HashMap<Integer,Integer> hashMap;
        // Create a list to store each number. O(1) when add a number.
        // When we get the index of the number from the hashmap, we have O(1) in removing a number
        List<Integer> list;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.hashMap = new HashMap<>();
            this.list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (hashMap.containsKey(val))
                return false;
            hashMap.put(val,list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!hashMap.containsKey(val)){
                return false;
            }
            int index = hashMap.get(val);
            // If the number to be removed is not the last one in the list, change its value to the last one in the list
            // Then remove the last one in the list
            if (index < list.size()-1){
                hashMap.put(list.get(list.size()-1),index);
                list.set(index,list.get(list.size()-1));
            }
            hashMap.remove(val);
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
