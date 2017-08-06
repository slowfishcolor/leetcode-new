package com.sfc.leetcode;

import java.util.Stack;

/**
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Created by Prophet on 2017/8/2.
 */
public class Min_Stack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    /** initialize your data structure here. */
    // 存放数据
    private Stack<Integer> dataStack = new Stack<>();
    // 存放对应的最小值
    private Stack<Integer> minStack = new Stack<>();
    // 当前最小值
    private int curMin = Integer.MAX_VALUE;

    public Min_Stack() {

    }

    public void push(int x) {
        dataStack.push(x);
        // 只有当 curMim >= x 时才压入 minStack
        if (curMin >= x) {
            curMin = x;
            minStack.push(x);
        }

    }

    public void pop() {
        // 若当前 pop 出的数值 <= curMin，则 pop minStack
        if (dataStack.pop() == curMin) {
            minStack.pop();
            if (minStack.isEmpty()) {
                curMin = Integer.MAX_VALUE;
            } else {
                curMin = minStack.peek();
            }

        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return curMin;
    }
}
