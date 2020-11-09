package problems_by_year.year_2020.month_09.problems_0901.Copy_List_with_Random_Pointer;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/2 11:46 上午
 */
// 138:
// Copy List with Random Pointer
// copy-list-with-random-pointer

//A linked list is given such that each node contains an additional random point
//er which could point to any node in the list or null.
//
// Return a deep copy of the list.
//
// The Linked List is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where:
//
//
// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) where random pointe
//r points to, or null if it does not point to any node.
//
//
//
// Example 1:
//
//
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// Example 2:
//
//
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
//
//
// Example 3:
//
//
//
//
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
//
//
// Example 4:
//
//
//Input: head = []
//Output: []
//Explanation: Given linked list is empty (null pointer), so return null.
//
//
//
// Constraints:
//
//
// -10000 <= Node.val <= 10000
// Node.random is null or pointing to a node in the linked list.
// Number of Nodes will not exceed 1000.
//
// Related Topics Hash Table Linked List
// 👍 3624 👎 703


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {

    public static void main(String[] args) {
        // []
//        int[][] grid = {{3, -1},{3,0},{3, -1}};
        int[][] grid = {{7,-1},{13,0},{11,4},{10,2},{1,0}};
        int m = grid.length;

        Node head = new Node(grid[0][0]);
        Node[] nodes = new Node[m];
        nodes[0] = head;
        for (int i = 1; i < m; i++) {
            Node cur = new Node(grid[i][0]);
            nodes[i-1].next = cur;
            nodes[i] = cur;
        }

        for (int i = 0; i < m; i++) {
            int random = grid[i][1];
            if (random != -1) {
                nodes[i].random = nodes[random];
            }
        }
        Solution solution = new Solution();
        solution.copyRandomList(head);
        System.out.println("haha");
    }

    /**
     * 不同节点之间的值可能重复，所以无法通过记录节点值的方式找到随机指针指向的位置。
     * 问题的关键在于：如何把随机指针对应的值转化为节点的位置索引。
     * @param head
     * @return
     */
    public Node copyRandomList_W1(Node head) {
        if (head == null) {
            return null;
        }
        Node temp1 = head;
        List<Node> lst = new ArrayList<>();

        // 随机指针的位置 --> 随机指针指向值
        Map<Integer, Integer> map = new HashMap<>();
        // node节点的值-->node的位置
        Map<Integer, Integer> map2 = new HashMap<>();
        int cnt = 0;
        while (temp1 != null) {
            lst.add(new Node(temp1.val));
            map2.put(temp1.val, cnt);
            if (temp1.random != null) {
                map.put(cnt, temp1.random.val);
            } else {
                map.put(cnt, -1);
            }
            temp1 = temp1.next;
            cnt++;
        }
        Node newHead = lst.size() > 0 ? lst.get(0) : null;
        for (int i = 0; i < lst.size(); i++) {
            newHead.next = i < lst.size()-1 ? lst.get(i+1) : null;
            Integer position = map.get(i);
            if (position != -1) {
                newHead.random = lst.get(map2.get(position));
            } else {
                newHead.random = null;
            }
            newHead = newHead.next;
        }
        return lst.size() > 0 ? lst.get(0) : null;
    }

    public Node copyRandomList_R1(Node head) {
        if (head == null) {
            return null;
        }
        Node temp1 = head;
        // 建立old linked -> new linked的关系；
        Map<Node, Node> map = new HashMap<>();
        while (temp1 != null) {
            map.put(temp1, new Node(temp1.val));
            temp1 = temp1.next;
        }

        temp1 = head;
        while (temp1 != null) {
            if (temp1.next != null) {
                map.get(temp1).next = map.get(temp1.next);
            }
            if (temp1.random != null) {
                map.get(temp1).random = map.get(temp1.random);
            }
            temp1 = temp1.next;
        }
        return map.get(head);
    }
    public long houseRobber(int[] A) {
        long[] dp = new long[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i > 1 ) {
                dp[i] = Math.max(dp[i-1], dp[i]+dp[i-1]);
            } else {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }
        return dp[A.length];
        // write your code here
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            Node cur = temp.next;
            temp.next = newNode;
            newNode.next = cur;
            temp = temp.next.next;
        }
        temp = head;

        while (temp != null) {
            // temp.random.next随机指针的下一个位置
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node res = temp.next;
        while (temp !=null) {
            Node copy = temp.next;
            temp.next = copy.next;
            temp = temp.next;
            if (temp != null) {
                copy.next = temp.next;
            } else {
                copy.next = null;
            }
//            Node cur = temp.next.next;
//            if (cur != null) {
//                temp.next.next = cur.next;
//            } else {
//                temp.next.next =null;
//            }
//            temp = cur;

        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
