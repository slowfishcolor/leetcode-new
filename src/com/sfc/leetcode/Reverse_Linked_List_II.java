package com.sfc.leetcode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:1 ? m ? n ? length of list.
 *
 * Created by Prophet on 2017/7/31.
 */
public class Reverse_Linked_List_II {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n || head.next == null) return head;

        ListNode p = head;
        // 记录翻转的 tail
        ListNode tail = head;
        // 定位到第 m 个 node
        for (int i = 1; i < m; i++) {
            tail = p;
            p = p.next;
        }

        ListNode ne = p.next;
        ListNode t = null;
        ListNode newHead = p;
        // 开始翻转 m 到 n
        for (int i = m; i <= n; i++) {
            t = ne.next;
            ne.next = p;
            p = ne;
            ne = t;
        }
        // 处理翻转的首尾 node
        tail.next.next = ne;
        tail.next = p;

        return head;
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode p = reverseBetween(node1, 1,2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }


}
