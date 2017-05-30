import java.util.Stack;

/**
 * Created by jmding on 5/25/17.
 */
public class ImplementQueueUsingStacks {

    // Implement the following operations of a queue using stacks.

    // push(x) -- Push element x to the back of queue.
    // pop() -- Removes the element from in front of queue.
    // peek() -- Get the front element.
    // empty() -- Return whether the queue is empty.

    // Idea: use two stacks. New items are pushed to input stack
    // When peek, peek the output stack if it is not empty,
    // otherwise, pop each item in input stack and push it to output stack, then peek output stack
    // If both input stack and output stack are empty, the queue is empty
    public class MyQueue {

        Stack<Integer> inputStack;
        Stack<Integer> outputStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inputStack  = new Stack<>();
            outputStack  = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inputStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return outputStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (outputStack.empty()){
                while (!inputStack.empty())
                    outputStack.push(inputStack.pop());
            }
            return outputStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inputStack.empty() && outputStack.empty();
        }
    }
}
