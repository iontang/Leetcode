package tree.problem;

import tree.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 563.
 * 题意：求一棵树的斜坡；斜坡的定义是这个树的所有左节点和所有右节点的绝对值，不只是只有一个左节点和一个右节点这种情况
 */
public class Binary_Tree_Tilt {

    public int findTilt(TreeNode root) {
        int[] result = new int[1];
//        int level = 1;
//        helper(root, result, level); // wrong
        helper(root, result);
        return result[0];
    }

    /**
     * wrong： 只解决了 计算一个左节点和一个右节点之差的这种情况；
     * @param root
     * @param result
     * @param level
     */
    public void helper(TreeNode root, int[] result, int level) {
        if (root == null) return;

        if (root.left == null && root.right != null) {
            result[0] += root.right.val;
        }
        if (root.left != null && root.right == null) {
            result[0] += root.left.val;
        }
        if (root.left != null && root.right != null) {
            result[0] += Math.abs(root.left.val-root.right.val);
        }
        helper(root.left, result, level +1);
        helper(root.right, result , level+1);
    }

    /**
     * Time complexity : O(n). where nnn is the number of nodes. Each node is visited once.
     * Space complexity : O(n). In worst case when the tree is skewed depth of tree will be nnn.
     * In average case depth will be logn.
     * @param root
     * @param result
     * @return
     */
    public int helper(TreeNode root, int[] result) {
        if (root == null) return 0; // return 0就不需要处理null值的情况；
        int leftValue = helper(root.left, result);
        int rightValue = helper(root.right, result);

        result[0] += Math.abs(leftValue-rightValue);
        return leftValue+rightValue+root.val; // 汇总
    }


    /**
     * 参考：迭代
     * @param root
     * @return
     */
    public int findTilt_A1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tilt = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if ((node.left == null || map.containsKey(node.left)) &&
                    (node.right == null || map.containsKey(node.right))) {
                stack.pop();
                int left = map.containsKey(node.left) ? map.get(node.left) : 0;
                int right = map.containsKey(node.right) ? map.get(node.right) : 0;
                tilt += Math.abs(left - right);
                map.put(node, left + right + node.val);
            } else {
                if (node.left != null && !map.containsKey(node.left)) {
                    stack.push(node.left);
                }

                if (node.right != null && !map.containsKey(node.right)) {
                    stack.push(node.right);
                }
            }
        }
        return tilt;
    }

}
