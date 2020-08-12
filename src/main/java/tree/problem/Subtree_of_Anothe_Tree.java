package treeh.problem;

import treeh.common.TreeNode;

/**
 * 2018/05/20
 *
 * 572.
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * 判断树t是否为树s的子树：子树的意思是指两棵树具有相同的后代
 *
 * 与100题：判断两棵树是否为同一棵树相似
 */
public class Subtree_of_Anothe_Tree {


//    public boolean isSubtree(TreeNode s, TreeNode t) {
//
//    }
//    public void helper(TreeNode s, TreeNode t) {
//        if (t == null) return;
//        if (t.val == s.val && t.left.val == s.left.val && t.right.val == s.right.val) {
//            helper(s.left, t.left);
//            helper(s.right, t.right);
//        } else {
//            helper(s.left, t);
//            helper(s.right, t);
//        }
//
//    }


    /**
     * 参考：
     * example:[备注：如果第一个数一样，再比较左右节点是否一样，如果不一样，重新开始递归循环。]
     *
     * [3,4,5,4,2,null,null,1,2]
     * [4,1,2]
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //给定均不为空的二叉树s和t，判定t是否是s的子树
        //思路：利用前面是否已经判断过标志位进行递归
        return backtrace(s,t,false);
    }
    public boolean backtrace(TreeNode s,TreeNode t,boolean flag){
        //非空判断
        if(s==null&&t==null)return true;
        if(s==null||t==null) return false;
        if(flag&&s.val!=t.val){
            //之前节点相等，当前节点不相等，返回false
            return false;
        }
        if(s.val==t.val&&backtrace(s.left,t.left,true)&&backtrace(s.right,t.right,true)){
            return true;
        }else{
            //节点不相等，flag置为false,递归判断左右子树
            return backtrace(s.left,t,false)||backtrace(s.right,t,false);
        }

    }


    /**
     *
     1.First when we get this question, the easiest idea coming up is using recursive to compare 2 trees. So I make a simple code like below which beat 99.5% submissions.
     2.The first step to compare 2 trees check their root nodes. If both of them a null, means empty trees, then fine and they are same; Otherwise, we need to compare the root node value. There is a small tricky here: the tree node val may be duplicate and not unique, so the code should be able to traversal in next layer if not match.
     3.If node val same, then we need to compare the left/right node val is same then can we continue the comparition for s.left-t.left and s.right-t.right,otherwise exist.
     4.If node val not same, we just need to continue the recursive to check the left & right subtree with t.

     代码无法通过下面的demo
     [3,4,5,1,2,null,null,1,null,null,null,1,null,3]
     [4,1,2,3]
     */
    public boolean isSubtree_A1(TreeNode s, TreeNode t) {
        // 停止条件是两棵树的节点都为null
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val == t.val) {
            // 如果根节点的值相同，取出左右子树的值
            int s_l = -1, s_r=-1, t_l=-1, t_r=-1;
            if (s.left != null) s_l = s.left.val;
            if (s.right != null) s_r = s.right.val;
            if (t.left != null) t_l = t.left.val;
            if (t.right != null) t_r = t.right.val;

            if ((s_l == t_l && s_r == t_r) && isSubtree(s.left, t.left) && isSubtree(s.right, t.right) ) {
                return true;
            }
        }
        return (isSubtree(s.left, t) || isSubtree(s.right, t));

    }

    /**
     * 这种解法能够解决上面问题：
     * [3,4,5,1,2,null,null,1,null,null,null,1,null,3]
     * [4,1,2,3]
     * @param s
     * @param t
     * @return
     */

    public boolean isSubtree_A2(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }

    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(5);


        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        Subtree_of_Anothe_Tree so = new Subtree_of_Anothe_Tree();

        so.isSubtree(root, t);
    }



}
