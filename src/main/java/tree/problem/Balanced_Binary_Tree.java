package tree.problem;

import tree.common.TreeNode;

/**
 * tree problem by 20180513
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * 110. Balanced Binary Tree
 * 题意：判断一棵树是否为平衡二叉树：
 * 关于平衡数的定义是：每个节点的左右子树高度差值都不能超过1，不是只有根节点。
 * example ： [1,2,2,3,null,null,3,4,null,null,4]
 *
 * 这道题和  543. Diameter of Binary Tree类似
 *
 */
public class Balanced_Binary_Tree {

    /**
     * 遍历每个节点，找到左、右子节点最大深度，相减如果不小于1，那么就是平衡树
     * @param root
     * @return
     */
    boolean ret = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        helper(root);
        return ret;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int leftValue = helper(root.left);
        int rightValue = helper(root.right);
        if (Math.abs(leftValue-rightValue) > 1) {
            ret = false;
        }
        int value = Math.max(leftValue, rightValue) + 1;
        return value;
    }



}
