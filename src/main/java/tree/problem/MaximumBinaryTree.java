package tree.problem;


import tree.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumBinaryTree {
    /**
     * 递归写法：
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = resurseNode(0, nums.length-1, nums);
        return root;
    }

    private TreeNode resurseNode(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = -1;
        for (int i=start;i<=end;i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        TreeNode rootNode = new TreeNode(maxValue);
        rootNode.left = resurseNode(start, maxValueIndex-1, nums);
        rootNode.right = resurseNode(maxValueIndex+1, end, nums);

        return rootNode;
    }


    /**
     * leetcode answer
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree_A1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        Deque<TreeNode> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            TreeNode curNode = new TreeNode(nums[i]);
            while (!dq.isEmpty() && dq.peek().val < nums[i]) {
                curNode.left = dq.peek();
                dq.pop();
            }

            if (!dq.isEmpty()) {
                dq.peek().right = curNode;
            }
            dq.push(curNode);
        }
        return dq.peekLast();
    }

    public static void main(String[] args) {
//        int[] arr = {3,2,1,6,0,5};
//        int[] arr = {5,3,2,1,0,6};
        int[] arr = {0,1,2,3,4,6};
        constructMaximumBinaryTree_A1(arr);
    }


}
