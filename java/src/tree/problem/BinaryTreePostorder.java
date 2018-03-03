package src.tree.problem;


import src.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorder {

    /**
     * 后序遍历在考虑是否输出该节点的时候，需要确认是否还有左右子节点
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode lastVisit = null;
        TreeNode peekNode = null;
        while (root !=null || !stack.isEmpty()) {
            if (null != root) { // 找到左节点为null
                stack.push(root);
                root = root.left;
            } else {
                peekNode = stack.peek(); // 取出栈中第一个元素，即左节点为null的根节点
                if (null != peekNode.right && peekNode.right != lastVisit) {
                    root = peekNode.right; // 根节点的右子节点
                } else {
                    lst.add(peekNode.val);
                    lastVisit = stack.pop();
                }
            }
        }
        return lst;
    }



    /**
     * 递归遍历
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> lst = new ArrayList<Integer>();
//        helper(root, lst);
//        return lst;
//    }
//
//    public void helper(TreeNode root, List<Integer> lst) {
//        if (null == root)
//            return;
//        helper(root.left, lst);
//        helper(root.right, lst);
//        lst.add(root.val);
//    }

}
