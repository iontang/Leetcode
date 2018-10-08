package treeh.problem;

import treeh.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorder {


    /**
    * 遍历版本
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
        while(root != null || !stack.isEmpty() ) {
            while (null != root) { // 找到最后一个左节点，同时把每个根节点存在栈中
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            lst.add(root.val); // 最后一个左节点
            root = root.right;

        }
        return lst;
    }


    /**
    * 递归版本
    */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> lst = new ArrayList<Integer>();
//        helper(root, lst);
//        return lst;
//    }
//
//    public void helper(TreeNode node, List<Integer> lst) {
//        if(node == null)
//            return;
//        helper(node.left, lst);
//        lst.add(node.val);
//        helper(node.right, lst);
//    }

}
