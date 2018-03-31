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


    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> largestValues_A1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }
    private void helper(TreeNode root, int depth, List<Integer> res){
        if(root == null) return;
        if(depth == res.size()){
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        helper(root.left, depth + 1, res);
        helper(root.right, depth + 1, res);
    }



}
