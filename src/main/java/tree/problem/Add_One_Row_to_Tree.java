package tree.problem;


import tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623.
 *
 * 要求：
 *
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 *
 */
public class Add_One_Row_to_Tree {

    /**
     * 迭代
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode t = new TreeNode(v);
            t.left = root;
            return t;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;// 从1开始
        while (!queue.isEmpty()) {
            depth+=1;
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (depth == d) {
                    TreeNode t = new TreeNode(v);
                    t.left = cur.left;
                    cur.left = t;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);

                }
                if (depth == d) {
                    TreeNode t = new TreeNode(v);
                    t.right = cur.right;
                    cur.right = t;
                }

            }

        }
        return root;
    }

    /**
     * 递归暂略
     */

}
