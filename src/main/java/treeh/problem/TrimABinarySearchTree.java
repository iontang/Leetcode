package treeh.problem;

import treeh.common.TreeNode;

/**
 * 题意：这道题让我们修剪一棵二叉搜索树，给了个边界范围[L, R], 所有不在这个范围内的结点应该被移除掉，但是仍需要保留二叉搜索树的性质，即左<根<右，有时候是小于等于。
 * 二叉搜索数的性质：即左<根<右，有时候是小于等于。
 */
public class TrimABinarySearchTree {

    /**
     * 未完成
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) return null;

        if (root.left != null)

        trimBST(root.left, L, R);
        trimBST(root.right, L, R);

        return root;

    }

    /**
     * iterative version
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST_A2(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        //Find a valid root which is used to return.
        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            }
            if (root.val > R) {
                root = root.left;
            }
        }
        TreeNode dummy = root;
        // Remove the invalid nodes from left subtree.
        while (dummy != null) {
            while (dummy.left != null && dummy.left.val < L) {
                dummy.left = dummy.left.right;
                // If the left child is smaller than L, then we just keep the right subtree of it.
            }
            dummy = dummy.left;
        }
        dummy = root;
        // Remove the invalid nodes from right subtree
        while (dummy != null) {
            while (dummy.right != null && dummy.right.val > R) {
                dummy.right = dummy.right.left;
                // If the right child is biggrt than R, then we just keep the left subtree of it.
            }
            dummy = dummy.right;
        }
        return root;
    }

    /**
     * 参考: 时间复杂度和空间复杂度都是O(n)
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static TreeNode trimBST_A1(TreeNode root, int L, int R) {
        if (root==null){
            return null;
        }
        if ((L<=root.val && root.val<=R)) {
            root.left= trimBST_A1(root.left, L, R);
            root.right=trimBST_A1(root.right,  L,  R);
        } // 根据二叉搜索数的性质： 左<根<右
        else if(root.val<L){ // 根节点的值小于下界，抛弃左子树,右子树的点顶替根节点
            root = trimBST_A1(root.right,L,R);
        }else if (root.val>R){ // 根节点的值大于上届，抛弃右子树，左子树的点顶替根节点
            root=trimBST_A1(root.left,L,R);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);

        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        trimBST_A1(root, 1,3);

    }



}
