package com.sfc.leetcode;

import java.util.Stack;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by Prophet on 2017/7/27.
 */
public class Valid_Parentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] datas = s.toCharArray();

        for (char c : datas) {
            boolean flag = true;
            switch (c) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.pop() == '(') ; else flag = false;
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop() == '{') ; else flag = false;
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.pop() == '[') ; else flag = false;
                    break;

            }
            if (!flag) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[()]{}"));
    }

}
