package com.sfc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Created by Prophet on 2017/8/1.
 */
public class Linked_List_Cycle_II {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) return head;
            nodes.add(head);
            head = head.next;
        }

        return null;
    }

    // 第一次碰撞点Pos到连接点Join的距离=头指针到连接点Join的距离，因此，分别从第一次碰撞点Pos、头指针head开始走，相遇的那个点就是连接点
    // http://www.cnblogs.com/xudong-bupt/p/3667729.html
    // 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }


}
