package problems_by_year.year_2020.month_07.problems_0720;

import linkedlist.common.ListNode;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/20 11:57 下午
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        Solution solution = new Solution();
        solution.removeElements(node1, 1);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode resNode = fakeHead;
        while (head != null ) {
            if (head.val == val) {
                fakeHead.next = head.next;
            } else {
                fakeHead = head;
            }
            head = head.next;
        }
        return resNode.next;
    }

    public ListNode removeElements_A1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            }
            else {
                ptr = ptr.next;
            }
        }
        return head;
    }

    public ListNode removeElements_A2(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode prev = null, current = head;
        while(current != null){
            if(current.val == val){
                if(prev == null) {
                    head = current.next;
                }
                else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * [1,2,6,3,4,5,6]
     * 6
     * Output
     * []
     * Expected
     * [1,2,3,4,5]
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_W2(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode preNode = fakeHead;
        while (head != null ) {
            if (head.val == val) {
                preNode.next = head.next;
            } else {
                preNode.next = head;
            }
            head = head.next;
        }
        return fakeHead.next;
    }

    /**
     * Input
     * [1,2,6,3,4,5,6]
     * 6
     * Output
     * [1,2,6,3,4,5,6]
     * Expected
     * [1,2,3,4,5]
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_W1(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curNode = head;
        while (curNode != null ) {
            if (curNode.val == val) {
                fakeHead.next = curNode.next;
            } else {
                fakeHead.next = curNode;
            }
            curNode = curNode.next;
        }
        // 不能直接返回head，因为head指向的链表是原始的链表，上面的操作对原始链表没有影响
        return head;
    }


}
