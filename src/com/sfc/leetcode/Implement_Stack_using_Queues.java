package com.sfc.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * 队列实现栈
 * 思路一：两个队列倒腾，需要 pop 的时候从一个队列倒腾到另一队列，最后一个元素就是要 pop 的
 * 思路二：当有元素需要插入时，将插入的元素插入到空的队列中，并将另一非空队列的元素转移到该队列中，于是插入的元素添加到了队列头中
 *
 * Created by Prophet on 2017/8/2.
 */
public class Implement_Stack_using_Queues {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    /** Initialize your data structure here. */
    // 两个队列倒腾
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int top;
    public Implement_Stack_using_Queues() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 任何时刻有一个非空的，offer 给非空的队列
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 将非空的队列除了最后一个都导入空队列，最后那个即为要 pop 的元素
        if (queue1.isEmpty()) {
            offerAtoB(queue2, queue1);
            return queue2.poll();
        } else {
            offerAtoB(queue1, queue2);
            return queue1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty()) {
            offerAtoB(queue2, queue1);
            top = queue2.poll();
            queue1.offer(top);
            return top;
        } else {
            offerAtoB(queue1, queue2);
            top = queue1.poll();
            queue2.offer(top);
            return top;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    private void offerAtoB (Queue<Integer> a, Queue<Integer> b) {
        while (a.size() > 1) {
            b.offer(a.poll());
        }
//        return a.poll();
    }
}
