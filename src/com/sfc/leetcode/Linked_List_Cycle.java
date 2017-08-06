package com.sfc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * 快慢指针的经典应用。
 * 设两个指针，一个每次走一步的慢指针和一个每次走两步的快指针，如果链表里有环的话，两个指针最终肯定会相遇。
 *
 * Created by Prophet on 2017/8/1.
 */
public class Linked_List_Cycle {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    // 快慢指针，如果有环，快指针一定能追上慢指针
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) return true;
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

}
