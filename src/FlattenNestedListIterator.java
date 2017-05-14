import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by udingji on 5/13/17.
 */
public class FlattenNestedListIterator {


      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      private interface NestedInteger {

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
      }

    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        // Add the list into a stack in reverse order
        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--){
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.empty()){
                NestedInteger ni = stack.peek();
                // If the current nested integer is an integer, return true
                // While the stack is not empty, the loop won't break until we find an integer.
                // It is guaranteed that there are at least one integer in the nest integer
                if (ni.isInteger()){
                    return true;
                }
                // Otherwise, it is a list.
                // Pop it from the stack. Get the list and push each element to the stack in reverse order
                stack.pop();
                List<NestedInteger> list = ni.getList();
                for (int i = list.size() - 1; i >= 0; i--){
                    stack.push(list.get(i));
                }
            }
            return false;
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
