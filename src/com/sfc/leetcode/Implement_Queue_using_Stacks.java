package com.sfc.leetcode;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Created by Prophet on 2017/8/2.
 */
public class Implement_Queue_using_Stacks {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    /** Initialize your data structure here. */
    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public Implement_Queue_using_Stacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 将 popStack 中数据导入 pushStack
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        // 压入 x
        pushStack.push(x);
        // 将数据导回 popStack
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty();
    }
}
