package year.year_2020.month_03.problems_20200323.Merge_Two_Sorted_Lists;

public class Solution {

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/submissions/
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_R1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return tmp;

    }



    /**
     *    [1,2,4]
     * -1 [1,3,4]
     * Output
     * [1,1,3,4]
     * Expected
     * [1,1,2,3,4,4]
     * @param l1
     * @param l2
     * @return
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



    /**
     * mainList/n1:     1 -> 3 -> 7 -> 8
     *                      pre  last
     * tmpL2/ n2: -1 -> 1 -> 2 -> 5 -> 6
     * tmpL2/ n2: -1 -> 1 -> 2 -> 9 -> 10
     *                head  move
     */
    public ListNode mergeTwoLists_W1(ListNode l1, ListNode l2) {
        ListNode minPre;
        minPre = l1.val > l2.val ? l2 : l1;
        ListNode minLast = minPre.next;

        ListNode n2Move = new ListNode(-1);
        n2Move.next = l1.val > l2.val ? l1 : l2;
        ListNode n2Head = n2Move.next;
        while (minLast != null && n2Move.next !=null) {
            if (minLast.val > n2Move.next.val) {
                n2Move = n2Move.next;
            } else
//                if (minLast.next != null && minLast.next.val < n2Move.next.val) { // for main
//                minPre = minLast;
//                minLast = minLast.next;
//            } else
                {

                minPre.next = n2Head;
                n2Head = n2Move.next;
                n2Move.next = minLast;

                minPre = minLast;
                minLast = minLast.next;

            }
        }
        if (minLast == null && n2Move.next != null) {
            minPre.next = n2Head;
        }
        return l1.val > l2.val ? l2 : l1;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode head = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1.next;
                l1 = l1.next;
            } else {
                head.next = l2.next;
                l2 = l2.next;
            }

            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return fakeHead.next;
    }

    public ListNode mergeTwoLists_A1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode pre;
        ListNode head;
        if(l1.val <= l2.val) {
            head = l1;
            pre = l1;
            l1 = l1.next;

        } else {
            head = l2;
            pre = l2;
            l2 = l2.next;
        }

        while(l1 != null || l2 != null) {
            ListNode temp;
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    pre.next = l1;
                    pre = l1;
                    l1 = l1.next;

                } else {
                    pre.next = l2;
                    pre = l2;
                    l2 = l2.next;
                }
            } else if (l1 == null) {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(8);
        Solution solution = new Solution();
        solution.mergeTwoLists(l1, l2);
    }


}




