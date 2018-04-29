package src.tree.problem;


import src.tree.common.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 题目要求：求树的直径[两个节点间的路径长度是计算的两个节点间连线的个数（也就是边的个数）]。直径的定义是：这个直径不一定需要经过根节点
 https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73035
 https://blog.csdn.net/u012814856/article/details/76212141
 *
 */
public class Diameter_of_Binar_Tree {


    /**
     * 算法：根节点作为圆心，左右子树最大深度之和再加上1
     * 备注：是计算节点之间边的长度，不是计算节点的数量，而且根节点是不确定的
     * wrong
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        System.out.println(helper(root.left));
        System.out.println(">>>>>>> helper(root.right)=" + helper(root.right));
        return helper(root.left) + helper(root.right);
    }
    public int helper(TreeNode t) {
        if (t == null) return 0;
        int leftValue = helper(t.left);
        int rightValue = helper(t.right);
        int value = Math.max(leftValue, rightValue)+1;
        return value;
    }

    /**
     * 参考:
     */
    int ans;
    public int diameterOfBinaryTree_A1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        int ans[] = new int[]{Integer.MIN_VALUE};
//        diameter(root, ans);
//        return ans[0] - 1;
//    }
//
//    private int diameter(TreeNode root, int[] ans) {
//        if (root == null) return 0;
//        int left = diameter(root.left, ans);
//        int right = diameter(root.right, ans);
//        ans[0] = Math.max(ans[0], left + right + 1);
//        return Math.max(left, right) + 1;
//    }

}
