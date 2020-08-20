package problems_by_year.year_2020.month_05.problems_0511.Odd_Even_Linked_List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Example 1:
     * Input: 1->2->3->4->5->NULL
     *        0  1  2  3  4
     *        1->3->2->
     * Output:1->3->5->2->4->NULL
     *        0  2  4  1  3
     *
     * Example 2:
     * Input: 2->1->3->5->6->4->7->NULL
     *        0  1  2  3  4  5  6
     * Output:2->3->6->7->1->5->4->NULL
     *        0  2  4  6  1  3  5
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // oddHead一直不变
        ListNode evenTail = head;
        ListNode oddHead = head.next;
        ListNode oddTail = oddHead;
        while (oddTail != null && oddTail.next != null) {
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
            oddTail.next = evenTail.next;
            // even tail指向 odd head
            evenTail.next = oddHead;
            oddTail = oddTail.next;
        }
        evenTail.next = oddHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        solution.oddEvenList(head);
    }

}