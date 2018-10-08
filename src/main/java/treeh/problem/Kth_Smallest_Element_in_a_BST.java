package treeh.problem;

import treeh.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 230.
 * 题意：在二叉树中寻找第k小的元素
 * 思考：Follow up What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 *      How would you optimize the kthSmallest routine?
 */
public class Kth_Smallest_Element_in_a_BST {

    /**
     * 问题：如何使用计数器实现？
     * @param root
     * @param k
     * @return
     */
//    public int kthSmallest(TreeNode root, int k) {
//        int[] count = new int[1];
//        count[0] = 1;
//        helper(root, count, k);
//        return count[0];
//    }
//
//    public void helper(TreeNode root, int[] count, int k) {
//        if (root == null) return;
//        count[0] += 1;
//        System.out.println(count[0]);
//        helper(root.left, count, k);
//        if (count[0] == k) {
//            count[0] = root.val;
//            return;
//        }
//        helper(root.right, count, k);
//    }

    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> lst = new ArrayList<>();
        helper(root, lst);
        int result = 0;
        for (int i =0;i<lst.size();i++) {
            if (i+1 == k) {
                result = lst.get(i);
            }
        }
        return result;
    }
    public void helper(TreeNode root, List list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    /**
     * 参考
     * 类变量可用int[]{0,0}的内部变量代替
     */
    int count=0;
    int result=0;
    public int kthSmallest_A1(TreeNode root, int k) {
        traverse(root,k);
        return result;
    }

    private void traverse(TreeNode root,int k){
        if(root==null)
            return;
        traverse(root.left,k);
        count++;
        if(count==k)
            result=root.val;
        traverse(root.right,k);
    }

    /**
     * 用栈递归的方法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_A2(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1; // never hit if k is valid
    }


}
