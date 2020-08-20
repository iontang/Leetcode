package problems_by_year.year_2020.month_04.problems_20200420.Middle_of_the_Linked_List;

import linkedlist.common.ListNode;

public class Solution {

    public static void main(String[] args) {
        System.out.println(1/2);
    }
    public ListNode middleNode(ListNode head) {
        ListNode fakeHead = head;
        int len = 1;
        while (fakeHead.next != null) {
            fakeHead = fakeHead.next;
            ++len;
        }
        int cnt = 0;
        int middle = len/2;
        while (head != null) {
            if (cnt == middle) {
                return head;
            }
            head = head.next;
            ++cnt;
        }
        return null;
    }

    public ListNode middleNode_A1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
