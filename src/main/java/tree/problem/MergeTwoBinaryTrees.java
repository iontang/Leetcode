package tree.problem;

import tree.common.TreeNode;

public class MergeTwoBinaryTrees {

    /**
     * 三种方式思路一样，写法不同。
     * 时间复杂度：
     * 空间复杂度：
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        TreeNode root = null;
        if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val+t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right,t2.right);
        } else if (t1 == null && t2 != null) {
            root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null,t2.right);
        } else  {
            root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }
        return root;
    }

    public TreeNode mergeTrees_A1(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        else if(t1 == null && t2 != null)
            return t2;
        else if(t1 != null && t2 == null)
            return t1;
        else {
            TreeNode result = new TreeNode(t1.val + t2.val);
            result.left = mergeTrees(t1.left, t2.left);
            result.right = mergeTrees(t1.right, t2.right);
            return result;
        }
    }

    public TreeNode mergeTrees_A3(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }

}
