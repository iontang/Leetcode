package tree.problem;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        if (root ==  null) {
            return lst;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            height++; // count from first level;
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i=0;i<level;i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (height%2 == 0) {
                    levelList.add(0,queue.poll().val);
                } else {
                    levelList.add(queue.poll().val);
                }
            }

            lst.add(levelList);
        }
        return lst;
    }


    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        if (queue.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
