package linkedlist.SwapNodesinPairs;

import linkedlist.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        System.out.println("===");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        Solution solution = new Solution();
        solution.swapPairs(node1);
    }

    //-1 1 2 3 4 5 6 c=2
    //-1 2 1 3 4 5 6
    //-1 2 1 4 3 5 6
    //-1 2 1 4 3 6 5
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode tmp1 = curr.next.next;
            pre.next = curr.next;
            curr.next.next = curr;
            curr.next = tmp1;
            pre = curr;
            curr = curr.next;
        }
        return newHead.next;
    }



}
