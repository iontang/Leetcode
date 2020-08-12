package treeh.problem;

import treeh.common.TreeNode;

import java.util.Stack;

/**
 * 404.
 * 题目要求：求所有最底层的左子节点的合
 */
public class Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int[] leftSum = new int[1];
        helper(root, leftSum);
        return leftSum[0];
    }

    public void helper(TreeNode root, int[] result) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) { // 后面两个条件判断是否为最底层。
            result[0] +=root.left.val;
        }
        helper(root.left, result);
        helper(root.right, result);
    }

    /**
     * 参考：迭代算法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves_A1(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }

}
