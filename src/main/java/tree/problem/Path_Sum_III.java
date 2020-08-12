package treeh.problem;

import treeh.common.TreeNode;

/**

 * 437. Path Sum III
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1
 Return 3. The paths that sum to 8 are:
 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 *
 * 题目要求：1、左根右之和不包括在内
 * example：[5,4,8,11,null,13,4,7,2,null,null,5,1] 22
 */
public class Path_Sum_III {

    /**
     * wrong :
     * 1、存在负数的情况
     * 2、如何解决跨根节点的情况，比如demo中：
     *     5
     *    / \
     *   3   2
     * @param root
     * @param sum
     * @return
     */

    int pathSum = 0;
    int temp =0;
    public int pathSum_my_wrong(TreeNode root, int sum) {
        // 一维数组
        int[] arr = new int[]{0,0};
//        temp = sum;
        arr[0] = sum;
        helper(root, sum, arr);
        return arr[1];
    }
    public void helper(TreeNode t, int sum, int[] arr) {
        if (t == null) return;
//        if (temp - t.val == 0) {
//            System.out.println("###if");
//            temp = sum;
//            pathSum = pathSum + 1;
//        } else if (temp - t.val > 0){
//            System.out.println("###else if");
//            temp = temp - t.val;
//        } else {
//            System.out.println("###else");
//            temp = sum;
//        }
        if (arr[0] - t.val == 0) {
            System.out.println("###if");
            arr[1] += 1;
        } else if (arr[0] - t.val > 0 && (t.left != null || t.right != null)){
            System.out.println("###else if");
            arr[0] = arr[0] - t.val;
        } else {
            arr[0] = sum;
        }
        helper(t.left, sum, arr);
        if (arr[0] - sum < 0) {
            arr[0] = sum;
        }
        helper(t.right, sum,arr);
    }


    /**
     * 参考
     */
    int count;
    public int pathSum(TreeNode root, int sum) {
        count = 0;
        int[] A = new int[1000];
        findSum(root, sum, A, 0);
        return count;
    }
    void findSum(TreeNode root, int sum, int[] A, int i) {
        if (root == null) {
            return;
        }
        A[i] = root.val; // i表示层的元素，这种处理避免了“左中右”节点出现在数组A中，要么左中节点、要么右中节点
        count += findSumFromArray(A,i,sum); // 每作一次递归，都要统计一次，因为一个路基可能会有多个满足条件的情况。

        findSum(root.left, sum, A, i+1);
        findSum(root.right, sum,A, i+1);
    }
    int findSumFromArray(int[] A, int endIndex, int sum) {
        int total = 0;
        int sumCount = 0;
        for(int i = endIndex;i >= 0; i--) { // 从最底层开始作sum统计
            total += A[i];
            if (total == sum) {
                sumCount++;
            }
        }
        return sumCount;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.left = null;
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.left = null;
        root.right.right = new TreeNode(11);

        Path_Sum_III p = new Path_Sum_III();
        p.pathSum(root, 8);
    }


}
