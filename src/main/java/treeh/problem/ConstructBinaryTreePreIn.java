package treeh.problem;

import treeh.common.TreeNode;

import java.util.List;

public class ConstructBinaryTreePreIn {


//    /**
//     * 根据前序遍历和中序遍历重建二叉树：所有二叉树的点必须满足不能够重复
//     * @param preorder
//     * @param inorder
//     * @return
//     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int rootVal = preorder[0];
//        TreeNode root = new TreeNode(rootVal);
//        // 找到中序遍历根节点的索引
//        int rootIndex = 0;
//        for (int j =0;j<inorder.length;j++) {
//            if (rootVal == inorder[j])  {
//                rootIndex = j;
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] preorder = {7,10,4,3,1,2,8,11};
        int[] inorder = {4,10,3,1,7,11,8,2};

        ConstructBinaryTreePreIn cbtp = new ConstructBinaryTreePreIn();
        TreeNode tn  = cbtp.buildTree(preorder, inorder);
        BinaryTreePostorder btp = new BinaryTreePostorder();
        List<Integer> lst = btp.postorderTraversal(tn);

        for(Integer ii : lst) {
            System.out.println(ii);
        }
    }


    // http://wiki.jikexueyuan.com/project/for-offer/question-six.html
    // 递归构建当前根结点的左子树，左子树的元素个数：rootIndex-is个
    // 左子树对应的前序遍历的位置在[ps+1, ps+rootIndex-is]
    // 左子树对应的中序遍历的位置在[is, rootIndex-1]

    // 递归构建当前根结点的右子树，右子树的元素个数：ie-rootIndex个
    // 右子树对应的前序遍历的位置在[ps+rootIndex-is+1, pe]
    // 右子树对应的中序遍历的位置在[index+1, ie]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder,0, inorder.length-1, preorder, 0);
    }
    /**
     * @param preStart  preOrder数组下表
     * @param inStart
     * @param inEnd
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart) {
        // 递归终止条件：
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 找到中序遍历根节点的下标
        int rootIndex = 0;
        for (int j =0; j <= inEnd; j++) {
            if (rootVal == inorder[j])  {
                rootIndex = j;
            }
        }
        root.left = helper(inorder, inStart, rootIndex-1, preorder,preStart+1);
        // 前序遍历结果中右子树起始位置的计算方式：preStart + (rootIndex - inStart + 1)————包括根节点在内的左子树个数
        root.right = helper(inorder, rootIndex+1, inEnd,  preorder, preStart + (rootIndex - inStart + 1));
        return root;
    }

    /**
     * 遍历的方法
     * @param preorder
     * @param inorder
     * @return
     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(preorder == null || preorder.length == 0) return null;
//        Stack<TreeNode> stack = new Stack();
//        TreeNode root = new TreeNode(preorder[0]), p = root;
//        for(int i = 1, j = 0; i < preorder.length; i++){
//            if(p.val != inorder[j]){
//                p.left = new TreeNode(preorder[i]);
//                stack.push(p);
//                p = p.left;
//            }
//            else{
//                j++;
//                while(!stack.isEmpty() && inorder[j] == stack.peek().val){
//                    p = stack.pop();
//                    j++;
//                }
//                p.right = new TreeNode(preorder[i]);
//                p = p.right;
//            }
//        }
//        return root;
//    }



}
