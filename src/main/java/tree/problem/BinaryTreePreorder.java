package tree.problem;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreorder {

    public static void main(String[] args) {




    }

    /**
     * 前序遍历的迭代解法，使用到栈：把同一个根节点所有左节点取完，再取右节点
     * @param node
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> lst = new ArrayList<Integer>();
        // 把右节点存储
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while (node != null) {
            lst.add(node.val);// 根节点
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left; // 左节点，如果左节点为空，则考虑右节点
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return  lst;
    }


    /**
     * 递归版本：
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> pre = new main.scala.LinkedList<Integer>();
//        helper(root, pre);
//        return pre;
//    }
//
//    public void helper(TreeNode root, List<Integer> pre) {
//        if (root == null)
//            return;
//        pre.add(root.val);
//        helper(root.left, pre);
//        helper(root.right, pre);
//    }



}
