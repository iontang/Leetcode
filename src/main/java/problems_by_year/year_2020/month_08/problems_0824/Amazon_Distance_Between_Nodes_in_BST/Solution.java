package problems_by_year.year_2020.month_08.problems_0824.Amazon_Distance_Between_Nodes_in_BST;


/**
 * Given a list of unique integers nums, construct a BST from it (you need to insert nodes one-by-one with the given order to get the BST) and find the distance between two nodes node1 and node2. Distance is the number of edges between two nodes. If any of the given nodes does not appear in the BST, return -1.
 *
 * Example 1:
 *
 * Input: nums = [2, 1, 3], node1 = 1, node2 = 3
 * Output: 2
 * Explanation:
 *      2
 *    /   \
 *   1     3
 */

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/28 10:01 上午
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3};
        Solution solution = new Solution();
        solution.bstDistance(nums, 1,3);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int bstDistance(int[] nums, int node1, int node2) {
        TreeNode root = buildBST(nums, node1, node2);
        if (root == null) {
            return -1;
        }
        // 找到最近公共祖先
        TreeNode lca = lca(root, node1, node2);
        // 从最近公共祖先开始计算距离
        return getDistance(lca, node1) + getDistance(lca, node2);
    }

    private int getDistance(TreeNode src, int dest) {
        if (src.val == dest) {
            return 0;
        }
        TreeNode node = src.left;
        if (src.val < dest) {
            node = src.right;
        }
        return 1 + getDistance(node, dest);
    }

    private TreeNode lca(TreeNode root, int node1, int node2) {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    private TreeNode buildBST(int[] nums, int node1, int node2) {
        TreeNode root = null;
        boolean found1 = false;
        boolean found2 = false;
        for (int val : nums) {
            if (val == node1) {
                found1 = true;
            }
            if (val == node2) {
                found2 = true;
            }

            TreeNode node = new TreeNode(val);
            if (root == null) {
                root = node;
                continue;
            }
            addToBST(root, node);
        }
        if (!found1 || !found2) {
            return null;
        }
        return root;
    }

    private void addToBST(TreeNode root, TreeNode node) {
        for (TreeNode curr = root; true; ) {
            if (curr.val > node.val) {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = node;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

}
