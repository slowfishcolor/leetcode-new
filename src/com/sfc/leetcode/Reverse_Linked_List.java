package com.sfc.leetcode;

/**
 * Reverse a singly linked list.
 *
 * Created by Prophet on 2017/7/31.
 */
public class Reverse_Linked_List {

    private class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public ListNode reverseList (ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode p = head;
        ListNode n = head.next;
        ListNode t = null;

        while (n.next != null) {
            t = n.next; // 保护第三个
            n.next = p; // 调转 p 与 n
            p = n;      // 向前移动 n、p
            n = t;
        }
        // head
        n.next = p;
        // tail
        head.next = null;

        return n;
    }

    // 前插法
    public ListNode reverseList_1 (ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode t, p = head;
        while (p != null) {
            t = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = t;
        }
        return dummy.next;
    }



}
