package problems_by_year.year_2020.month_03.problems_20200323.Merge_k_Sorted_Lists;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode(0);
        for (int i=0; i<lists.length; i++) {
            ListNode tmp = lists[i];
            priorityQueue.offer(tmp);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode curr = priorityQueue.poll();
            head.next = curr;
            head = head.next;
            if (null != curr.next) {
                priorityQueue.offer(curr.next);
            }

        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
