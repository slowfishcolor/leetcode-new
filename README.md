# LeetCode Solutions

This is my solutions for LeetCode.
 
## Arrays
  
* [Rotate Array](/src/com/sfc/leetcode/Rotate_Array.java)
旋转数组，三次旋转。  
* [Merge Intervals](/src/com/sfc/leetcode/Merge_Intervals.java)
合并区间，先实现 comparator，进行排序，之后判断重复区间进行合并。
* [Insert Intervals](/src/com/sfc/leetcode/Insert_Interval.java)
插入有序区间，三段处理。  

## Dynamic Programming 
 
* [Climbing Stairs](/src/com/sfc/leetcode/Climbing_Stairs.java)
上台阶问题  
* [Minimum Path Sum](/src/com/sfc/leetcode/Minimum_Path_Sum.java)
二维数组最小路径和  

## Stacks

* [Valid Parentheses](/src/com/sfc/leetcode/Valid_Parentheses.java)
判断成对括号
* [Min Stack](/src/com/sfc/leetcode/Min_Stack.java)
构造可查最小值的栈
* [Implement Queue using Stacks](/src/com/sfc/leetcode/Implement_Queue_using_Stacks.java)
双栈表示队列
* [Implement Stacks using Queue](/src/com/sfc/leetcode/Implement_Stack_using_Queues.java)
队列表示栈

## Linked List

* [Reverse Linked List](/src/com/sfc/leetcode/Reverse_Linked_List.java)
翻转链表，保存头，双指针遍历
* [Reorder List](/src/com/sfc/leetcode/Reorder_List.java)
链表重排，快慢指针找中点，链表倒序
* [Linked List Cycle](/src/com/sfc/leetcode/Linked_List_Cycle.java)
判断单链表是否有环，快慢指针
* [Linked List Cycle](/src/com/sfc/leetcode/Linked_List_Cycle_II.java)
单链表有环的情况下，找到环中的第一个节点
* [Merge Two Sorted Lists](/src/com/sfc/leetcode/MergeTwoSortedLists.java)
合并两个有序链表，保证新的链表也是有序的，递归或者迭代
* [Merge k Sorted Lists](/src/com/sfc/leetcode/MergeKSortedList.java)
合并K个有序链表，先写合并2个，然后逐个合并
* [Sort List](/src/com/sfc/leetcode/Sort_List.java)
链表排序，涉及归并排序、快慢指针求链表中点、链表合并


## Binary Search

* [Find Minimum in Rotated Sorted Array](/src/com/sfc/leetcode/Find_Minimum_in_Rotated_Sorted_Array.java)
找旋转数组中的最小值，用二分查找的思想实现
* [Search Insert Position](/src/com/sfc/leetcode/Search_Insert_Position.java)
二分查找

## Binary Tree

* [Binary Tree Zigzag Level Order Traversal](/src/com/sfc/leetcode/Binary_Tree_Zigzag_Level_Order_Traversal.java)
二叉树的 Z 字遍历，使用两个 `stack`，分别存放当前处理层与下一层，放入时的顺序每换一层改变一次
* [Binary Tree Level Order Traversal](/src/com/sfc/leetcode/Binary_Tree_Level_Order_Traversal.java)
按层遍历二叉树，使用 `queue`，`poll()` 的时候遍历，使用 `last` 记录当前层最后一个节点，`nlast` 记录下一层的最后一个节点，遍历时不断更新 `nlast`
* [Path Sum](/src/com/sfc/leetcode/Path_Sum.java)
求 `root` 到 `leaf` 的路径和是否等于给定值，递归遍历，相加求和，到达叶子节点时比较
* [Path Sum II](/src/com/sfc/leetcode/Path_Sum_II.java)
同上，但要记录下符合的路径，方法是传递一个 `path list` 来存储遍历的节点，重点是该层递归遍历结束后移除该层的节点，添加 `path` 到 `result list` 时需要 `new ArrayList<>(path)` 来复制当前 `path`

## Permutations

* [Permutations](/src/com/sfc/leetcode/Permutations.java)
求无重复元素的全排列，交换 + DFS