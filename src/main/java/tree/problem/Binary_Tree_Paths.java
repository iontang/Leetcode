package treeh.problem;

import treeh.common.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.
 For example, given the following binary tree:
 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 * 257. Binary Tree Paths
 * 题意：打印到最后一个子节点的所有树
 * 树的路径题目；
 */
public class Binary_Tree_Paths {

    /**
     * wrong: 还是String和StringBUffer之间的区别
     * Output: ["1->2->5","1->2->5->3"]
     * Expected: ["1->2->5","1->3"]
     * @param root
     * @return
     */
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> lst = new ArrayList<String>();
//        if (root == null) return lst;
//        StringBuffer str = new StringBuffer();
//        str.append(root.val+"");
//        helper(root, lst, str);
//        return lst;
//    }
//    public void helper(TreeNode root, List<String> lst, StringBuffer str) {
//        if (root == null) return;
//        if (root.left == null && root.right == null) {
//            lst.add(str.toString());
//            return;
//        }
//        if (root.left != null) {
//            helper(root.left, lst, str.append("->"+root.left.val));
//        }
//        if (root.right != null ) {
//            helper(root.right, lst, str.append("->"+root.right.val));
//        }
//    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<String>();
        if (root == null) return lst;
        helper(root, lst, root.val+"");
        return lst;
    }
    public void helper(TreeNode root, List<String> lst, String str) {
//        if (root == null) return;
        if (root.left == null && root.right == null) {
            lst.add(str.toString());
            return;
        }
        if (root.left != null) {
            helper(root.left, lst, str + "->"+root.left.val);
        }
        if (root.right != null ) {
            helper(root.right, lst, str + "->"+root.right.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        Binary_Tree_Paths btp = new Binary_Tree_Paths();
        btp.binaryTreePaths(root);
    }


    /**
     * 参考：
     * @param root
     * @return
     */
    //BFS - Queue
    public List<String> binaryTreePaths_A1(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Queue<TreeNode> qNode=new LinkedList<TreeNode>();
        Queue<String> qStr=new LinkedList<String>();

        if (root==null) return list;
        qNode.add(root);
        qStr.add("");
        while(!qNode.isEmpty()) {
            TreeNode curNode=qNode.remove();
            String curStr=qStr.remove();

            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.val+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.val+"->");
            }
        }
        return list;
    }


    //DFS - Stack
    public List<String> binaryTreePaths_A2(TreeNode root) {
        List<String> list = new ArrayList<String>();
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<String> sStr = new Stack<String>();
        if (root == null) return list;
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()) {
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();
            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.val);
            if (curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return list;
    }


}
