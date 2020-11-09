package problems_by_year.year_2020.month_08.problems_0824.Insert_into_a_Binary_Search_Tree;

// 701:
// Insert into a Binary Search Tree
// insert-into-a-binary-search-tree

//Given the root node of a binary search tree (BST) and a value to be inserted i
//nto the tree, insert the value into the BST. Return the root node of the BST aft
//er the insertion. It is guaranteed that the new value does not exist in the orig
//inal BST.
//
// Note that there may exist multiple valid ways for the insertion, as long as t
//he tree remains a BST after insertion. You can return any of them.
//
// For example,
//
//
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//And the value to insert: 5
//
//
// You can return this binary search tree:
//
//
//         4
//       /   \
//      2     7
//     / \   /
//    1   3 5
//
//
// This tree is also valid:
//
//
//         5
//       /   \
//      2     7
//     / \
//    1   3
//         \
//          4
//
//
//
// Constraints:
//
//
// The number of nodes in the given tree will be between 0 and 10^4.
// Each node will have a unique integer value from 0 to -10^8, inclusive.
// -10^8 <= val <= 10^8
// It's guaranteed that val does not exist in the original BST.
//
// Related Topics Tree
// 👍 948 👎 80


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/26 10:23 下午
 */
class Solution {

    public static void main(String[] args) {
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(3);

        TreeNode l = new TreeNode(2, ll, lr);
        TreeNode r = new TreeNode(7);
        TreeNode root = new TreeNode(4, l, r);


        Solution solution = new Solution();
        solution.insertIntoBST(root, 5);
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        return insertVal(root, root.val > val ? root.left: root.right, val);
    }

    public TreeNode insertVal(TreeNode root,TreeNode sub, int val) {
        if (sub == null) {
            if (root.val > val) {
                root.left = new TreeNode(val);
            } else {
                root.right = new TreeNode(val);
            }
            return root;
        }

        if (sub.val > val) {
            insertVal(sub, sub.left, val);
        } else {
            insertVal(sub, sub.right, val);
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode insertIntoBST_A1(TreeNode root, int val) {
        return insert(root, val);
    }
    public TreeNode insert(TreeNode root, int val){
        if(root==null) {
            TreeNode n =new TreeNode(val);
            return n;
        }
        if (root.val>val) {
            root.left=insert(root.left,val);
        }
        if (root.val<val) {
            root.right=insert(root.right,val);
        }
        return root;
    }

    public TreeNode insertIntoBST_A2(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            // insert into the right subtree
            if (val > node.val) {
                // insert right now
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                }
            }
            // insert into the left subtree
            else {
                // insert right now
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node = node.left;
                }
            }
        }
        return new TreeNode(val);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

