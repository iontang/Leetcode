package tree.problem;

import tree.common.TreeNode;

import java.util.ArrayList;

import java.util.List;

/**
 * 653
 * 给定一个整数和一个二叉搜素树，判断树中是否存在两个节点，使得它们的值之和等于给定的这个数
 */
public class Two_Sum_IV_Input_is_a_BST {

    /**
     * 中序遍历得到有序数组，暴力求解法能够实现，有序数组使用双指针：时间和空间复杂度都是O(n)
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        convertToArray(root, lst);
        int start = 0;
        int end = lst.size()-1;
        while (start <end ) {
            if (lst.get(start) + lst.get(end) == k) return true;
            if (lst.get(start) + lst.get(end) > k) end--;
            if (lst.get(start) + lst.get(end) < k) end++;
        }
        return false;

    }
    public void convertToArray(TreeNode root, List<Integer> lst) {
        if (root == null ) return;
        convertToArray(root.left, lst);
        lst.add(root.val);
        convertToArray(root.right, lst);
    }


    /**
     * 参考：O(nlogn), Space Complexity: O(h). h is the height of the tree, which is logn at best case, and n at worst case.
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget_A1(TreeNode root, int k) {
        return dfs(root, root,  k);
    }

    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur)
                || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

//        root.right.right.right = new TreeNode(9);
        Two_Sum_IV_Input_is_a_BST t = new Two_Sum_IV_Input_is_a_BST();
        t.findTarget(root,9);

    }


}
