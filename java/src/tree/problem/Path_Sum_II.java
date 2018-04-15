package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 * 113. Path Sum II
 * 题意：给定一棵树和一个值，返回从根节点到最底节点之和等于这棵树的路径；
 */
public class Path_Sum_II {

    /**
     * wrong：这种写法，subList元素一直向后追加，需要代码实现删除 倒数 n-1个数据
//     * @param root
//     * @param sum
     * @return
     */
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> lst = new ArrayList<>();
//        if (root == null) return lst;
//        List<Integer> subList = new ArrayList<>();
//        subList.add(root.val);
//        helper(root, lst, sum, subList);
//        return lst;
//    }
//
//    public void helper(TreeNode root, List<List<Integer>> lst, int sum, List<Integer> subList) {
//        if (root.left == null && root.right == null) {
//            int total = 0;
//            for (Integer ele : subList) {
//                total += ele;
//            }
//            if (total == sum) {
//                lst.add(subList);
//            }
//            return;
//        }
//        if (root.left != null) {
//            subList.add(root.left.val);
//            helper(root.left, lst, sum, subList);
//        }
//        if (root.right != null) {
//            subList.add(root.right.val);
//            helper(root.right, lst, sum, subList);
//        }
//    }


//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> lst = new ArrayList<>();
//        if (root == null) return lst;
//        List<Integer> subList = new ArrayList<>();
//        subList.add(root.val);
//        helper(root, lst, sum, subList);
//        return lst;
//    }
//    public void helper(TreeNode root, List<List<Integer>> lst, int sum, List<Integer> subList) {
//
//        if (root.left == null && root.right == null) {
//            int total = 0;
//            for (Integer ele : subList) {
//                total += ele;
//            }
//            if (total == sum) {
//                lst.add(subList);
//            }
//            subList.remove(subList.size()-1);
//            return;
//        }
//        if (root.left != null) {
//            subList.add(root.left.val);
//            helper(root.left, lst, sum, subList);
//        }
//        if (root.right != null) {
//            subList.add(root.right.val);
//            helper(root.right, lst, sum, subList);
//        }
//        subList.remove(subList.size()-1);
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        Path_Sum_II p = new Path_Sum_II();
        p.pathSum(root,8);
    }


    /**
     * 备注：
     * 1、LinkedList和ArrayList都能够实现
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lst = new LinkedList<>();
        if (root == null) return lst;
        List<Integer> subList = new LinkedList<>();
        subList.add(root.val);
        helper(root, lst, sum, subList);
        return lst;
    }
    public void helper(TreeNode root, List<List<Integer>> lst, int sum, List<Integer> subList) {

        if (root.left == null && root.right == null) {
            int total = 0;
            for (Integer ele : subList) {
                total += ele;
            }
            // 此处为关键步骤，如果是注释的写法，返回的全部是长度为0的list
            if (total == sum) {
//                lst.add(subList);
                lst.add(new LinkedList<>(subList));
            }

            if (total == sum) {
                lst.add(subList);
            }
            subList.remove(subList.size()-1);
            return;
        }
        if (root.left != null) {
            subList.add(root.left.val);
            helper(root.left, lst, sum, subList);
        }
        if (root.right != null) {
            subList.add(root.right.val);
            helper(root.right, lst, sum, subList);
        }
        // 向上递归的过程中，删除subList元素
        subList.remove(subList.size()-1);
    }


    /**
     * 优化写法：
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum_A1(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        pathSumHelper(root, res, new LinkedList<>(), 0, sum);
        return res;
    }
    private void pathSumHelper(TreeNode node, List<List<Integer>> res, List<Integer> curList, int curSum, int sum) {
        if(node == null) return;
        curList.add(node.val);
        curSum += node.val;
        if(curSum == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(curList));
        }
        pathSumHelper(node.left, res, curList, curSum, sum);
        pathSumHelper(node.right, res, curList, curSum, sum);
        curSum -= node.val;
        curList.remove(curList.size()-1);
    }

    //1. iterative: Using a stack to implement DFS
    //2. Recursive:
    public List<List<Integer>> pathSum_A3(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            }
            if(cur.left==null && cur.right==null && SUM==sum)
                res.add(new ArrayList<Integer>(path));

            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;

        }
        return res;
    }





}
