package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 层次遍历一棵二叉树， 返回值中要求每一层的所有点在一个List中
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        int[] preorder = {7,10,4,3,1,2,8,11};
        int[] inorder = {4,10,3,1,7,11,8,2};

        ConstructBinaryTreePreIn cbtp = new ConstructBinaryTreePreIn();
        TreeNode tn  = cbtp.buildTree(preorder, inorder);
        BinaryTreePreorder btp = new BinaryTreePreorder();
        List<Integer> lst = btp.preorderTraversal(tn);

//        for(Integer ii : lst) {
//            System.out.println(ii);
//        }

        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        b.levelOrder(tn);
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (null==root) return new ArrayList<>();
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        List<List<Integer>> lst = new ArrayList<>();
//
//        List<Integer> r = new ArrayList<>();
//        r.add(root.val);
//        lst.add(r);
//
//        queue.offer(root);
//        TreeNode cur = root;
//        while (cur != null || !queue.isEmpty()) {
//            cur = queue.poll();
//            if (cur != null) {
//                List<Integer> sameLevel = new ArrayList<>();
//                queue.offer(cur.left);
//                queue.offer(cur.right);
//                if (cur.left != null) {
//                    sameLevel.add(cur.left.val);
//                }
//                if (cur.right != null) {
//                    sameLevel.add(cur.right.val);
//                }
//                if (!sameLevel.isEmpty()) {
//                    lst.add(sameLevel);
//                }
//
//            } else {
//                cur = queue.poll();
//            }
//        }
//        for (List<Integer> i : lst) {
//            for (Integer ii : i) {
//                System.out.println(ii);
//            }
////            System.out.println();
//        }
//        return lst;
//    }


    /**参考
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    /**
     * 递归实现
     */

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        levelTraverse(root, 0, res);
//        return res;
//    }
//    private void levelTraverse(TreeNode root, int depth, List<List<Integer>> res) {
//        if (root == null) {
//            return;
//        }
//        if (res.size() == depth) {
//            res.add(new ArrayList<Integer>());
//        }
//        res.get(depth).add(root.val);
//        levelTraverse(root.left, depth+1, res);
//        levelTraverse(root.right, depth+1, res);
//    }


}
