package com.sfc.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Created by Prophet on 2017/8/30.
 */
public class MergeTwoSortedLists {

     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     // 递归的方式
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         // 当一个链表已经处理完时，把没处理完的那个直接拼到最后面
         if (l1 == null) return l2;
         if (l2 == null) return l1;
         if (l1.val < l2.val) {
             l1.next = mergeTwoLists(l1.next, l2);
             return l1;
         } else {
             l2.next = mergeTwoLists(l1, l2.next);
             return l2;
         }
     }

     // 迭代的方式
    public ListNode mergeTwoLists_I(ListNode l1, ListNode l2) {
        // new 一个头节点来存一开始的引用
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        // 把没处理完的链表连到最后
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return head.next;
    }


}
