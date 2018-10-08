package treeh.problem;

import treeh.common.TreeNode;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {

    /**
     * try to traverse, but fail.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depthNum = 1;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
//                depthNum++;
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
//                    depthNum--;
            } else {
                depthNum++;
            }

        }
        return depthNum;
    }


    /**
     * 递归实现，每次统计子树下有多少层，
     * @param root
     * @return
     */
    public static int maxDepth_A1(TreeNode root) {
        if(root == null) return 0;
        int leftValue = maxDepth_A1(root.left);
        int rightValue= maxDepth_A1(root.right);
        int value = Math.max(leftValue, rightValue)+1;
        return value;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.left = new TreeNode(7);

        maxDepth_A1(root);
    }



}
