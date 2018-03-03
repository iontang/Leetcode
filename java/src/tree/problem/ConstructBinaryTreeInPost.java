package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.List;

/**
 *
 */
public class ConstructBinaryTreeInPost {

    public static void main(String[] args) {
    ConstructBinaryTreeInPost cb = new ConstructBinaryTreeInPost();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode tn = cb.buildTree(inorder, postorder);
        BinaryTreePreorder btp = new BinaryTreePreorder();
        List<Integer> lst = btp.preorderTraversal(tn);
        for (Integer i : lst) {
            System.out.println(i);
        }
    }


    /**
     * 错误
     * @param inorder
     * @param postorder
     * @return
     */
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        return  helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
//    }
//    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
//        if (postStart > postEnd)
//            return null;
//        int rootVal = postorder[postEnd];
//        int rootIndex = 0;
//        for (int i =0;i<=inEnd;i++) {
//            if (rootVal == inorder[i]) {
//                rootIndex = i;
//            }
//        }
//        TreeNode root = new TreeNode(rootVal);
//        root.left = helper(inorder, inStart, rootIndex-1, postorder, postStart, rootIndex-1);
//        root.right = helper(inorder,rootIndex+1, inEnd, postorder, rootIndex, postEnd-1);
//
//        return root;
//    }


    /**
     * 处理方式和“前序遍历+中序遍历重建二叉树”相似
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (postStart < 0 || inStart < inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                rIndex = i;
                break;
            }
        }
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
        root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
        return root;
    }


}
