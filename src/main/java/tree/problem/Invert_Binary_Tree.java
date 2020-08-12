package treeh.problem;

import treeh.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree {

    /**
     * 和Symmetric Tree这道题目类似
     * 题意：不可能是满二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        return helper(root, root.left, root.right);
    }

    public TreeNode helper(TreeNode root, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return root;
        root.left = t2;
        root.right = t1;
        if (null == t1) {
            helper(t2, t2.left, t2.right);
            // helper(root.left, , null);
        } else if (null == t2) {
            helper(t1, t1.left,t1.right);
            // helper(root.right, null, );
        } else {
            helper(root.left, t2.left, t2.right);
            helper(root.right, t1.left, t1.right);
        }
        return root;
    }

    /**
     * 错误版本的helper：
     * @param root
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode helper_wrong(TreeNode root, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        root.left = t2;
        root.right = t1;
        if (null == t1) {
            helper(root.left, null, t2.right);
            helper(root.right, null, t2.left);
        } else if (null == t2) {
            helper(root.left, t1.left,null);
            helper(root.right, t1.right,null);
        } else {
            helper(root.left, t1.left, t2.right);
            helper(root.right, t1.right, t2.left);
        }
        return root;
    }


    public TreeNode invertTree_A1(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        TreeNode tmp = root.left;
        root.left = invertTree_A1(root.right);
        root.right = invertTree_A1(tmp);
        return root;
    }

    public TreeNode invertTree_A2(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        Invert_Binary_Tree ibt = new Invert_Binary_Tree();
        ibt.invertTree(root);
    }




}
