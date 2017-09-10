package com.sfc.leetcode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Created by Prophet on 2017/9/10.
 */
public class Sort_List {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    /**
     * 通过递归来分治
     * @param head
     * @return      排序后的 List 的 head
     */
    public ListNode sortList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));
    }

    // use the fast and slow pointer to get the middle of a ListNode
    private ListNode getMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // merge two sorted list
    private ListNode merge (ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }
        return dummy.next;
    }

}
