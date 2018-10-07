package src.tree.problem;

import src.tree.common.TreeNode;


/**
 * 508. Most Frequent Subtree Sum
 *
 * 题意：找到子树之和出现次数最多的结果；
 *
 *
 */
public class Most_Frequent_Subtree_Sum {


    /**
     * 遍历求得子树的结果，再比较
     * 1、此处如何声明、初始化数组：
     */
    int t = 0;
    public int[] findFrequentTreeSum(TreeNode root) {

        helper(root);

        System.out.println(t);

        return null;
    }



    public void helper(TreeNode root) {
        if (root == null) return;

        t += root.val;
        System.out.println(t);

        helper(root.left);
        helper(root.right);
    }


    public static void main(String[] args) {

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(2);
//
//        root.right = new TreeNode(5);

        Most_Frequent_Subtree_Sum mfss = new Most_Frequent_Subtree_Sum();



        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        mfss.findFrequentTreeSum(t);

//        int[] result = new int[10];

    }

}
