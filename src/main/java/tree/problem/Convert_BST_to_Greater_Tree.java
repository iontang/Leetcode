package tree.problem;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 538.
 * 题意：给定一棵二叉查找数（左<=根<=右），转化成一个节点更大的二叉树
 */
public class Convert_BST_to_Greater_Tree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);
        int rootIndex = 0; // 此题节点不会重复，如果二叉查找树节点重复怎么办？看参考答案。
        for (int i=0; i<list.size(); i++) {
            System.out.println("list.get(i).val=" + list.get(i).val + " " +"root.val=" + root.val);
            if (list.get(i).val == root.val) {
                rootIndex = i;
                break;
            }
        }
        System.out.println("rootIndex=" + rootIndex);
        for (int i=0; i<list.size()-1; i++) {
            TreeNode cru = list.get(i+1);
            cru.val=list.get(i).val+cru.val;
            list.set(i+1, cru);
        }
        return list.get(rootIndex);
    }

    public void helper(TreeNode root, List<TreeNode> list) {
        if (root ==null) {
            return;
        }
        helper(root.right, list);
        list.add(root);
        helper(root.left, list);
    }

    /**
     * 参考答案：不需要遍历查找根节点
     */
    int sum = 0;// 类变量
    public TreeNode convertBST_A1(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum; // 最大值那个节点对应的sum=0；
        sum = cur.val;
        convert(cur.left);
    }


//    public TreeNode convertBST(TreeNode root) {
//        int[] result = new int[1];
//        convert(root, result);
//        return root;
//    }
//    private void convert(TreeNode root, int[] result) {
//        if (root == null) {
//            return;
//        }
//        convert(root.right, result);
//        result[0] += root.val;
//        root.val = result[0];
//        convert(root.left, result);
//    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        Convert_BST_to_Greater_Tree c = new Convert_BST_to_Greater_Tree();
        c.convertBST(root);
    }

}
