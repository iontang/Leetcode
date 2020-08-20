package problems_by_year.year_2020.month_04.problems_20200427.Diameter_of_Binary_Tree;

import tree.common.TreeNode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {

    public int diameterOfBinaryTree_W1(TreeNode root) {
        int len = 0;
        BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return 0;
    }

    public int diameterOfBinaryTree_W2(TreeNode root) {
        if (root == null) return 0;
        int left = 0;
        if (root.left != null) {
            left = loopTree(root.left, 1, 0);
        }
        int right = 0;
        if (root.right != null) {
            right = loopTree(root.right, 0, 1);
        }
        return left + right;
    }

    private int loopTree(TreeNode node, int left, int right) {
        if (node == null) {
            return Math.max(left, right);
        }
        if (node.left != null) {
            left += 1;
        }
        int t1 = loopTree(node.left, left, right);

        if (node.right != null) {
            right += 1;
        }
        int t2 = loopTree(node.right, left, right);
        ;
        return Math.max(t1, t2);
    }


    public int diameterOfBinaryTree(TreeNode root) {

        return 0;
    }

}
