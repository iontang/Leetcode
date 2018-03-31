package src.tree.problem;

import java.util.LinkedList;
import java.util.List;
import src.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.Queue;

/**
 * same as the problem of 'BinaryTree Level Order Traversal'
 * a binary tree is that it's child node can be null
 */
public class FindLargesValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if (null == root) return lst;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // add a node to the queue
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i =0; i<levelNum; i++) {
                if (null != queue.peek().left) {
                    queue.offer(queue.peek().left);
                }
                if (null != queue.peek().right) {
                    queue.offer(queue.peek().right);
                }
                int temp = queue.poll().val;
                if (temp > maxValue) {
                    maxValue = temp;
                }
            }
            lst.add(maxValue);
        }
        return lst;
    }

}
