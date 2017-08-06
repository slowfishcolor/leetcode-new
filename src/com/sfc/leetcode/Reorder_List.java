package com.sfc.leetcode;

/**
 *
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * You must do this in-place without altering the nodes' values.
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Created by Prophet on 2017/7/31.
 */
public class Reorder_List {

    private class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public void reorderList (ListNode head) {

        if (head == null || head.next == null) return;

        // 1. 快慢指针找中点
        ListNode fast = head;
        ListNode slow = head;
        // 把整个链表划分成2个等长的子链表，如果原链表长度为奇数，那么第一个子链表的长度多1
        while (fast.next != null) {
            fast = fast.next;
            // 偶数链表长度的情况下，slow 要少移动一次
            if (fast.next != null) fast = fast.next;
            else break;
            slow = slow.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        // 设置第一个链表的尾巴为 null
        slow.next = null;

        // 2. 翻转第二个链表
        head2 = reverseList (head2);

        // 3. 合并两个链表
        ListNode l1 = head1;
        ListNode l2 = head2;

        while (l2 != null) {
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }


    }

    private ListNode reverseList (ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode p = head;
        ListNode n = head.next;
        ListNode t = null;

        while (n.next != null) {
            t = n.next; // 保护 next
            n.next = p; // 反转 n p
            p = n;      // 移动指针
            n = t;
        }
        // head
        n.next = p;
        // tail
        head.next = null;
        return n;
    }

}
