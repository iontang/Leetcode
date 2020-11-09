package tree.problem;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 655.
 * 题目要求： 将一个二叉树转化为m*n的二维数组，然后输出
 * 题目类似于：“Find Bottom Left Tree Value”
 */
public class Print_Binary_Tree {

    /**
     * 1、求树的最大深度m；
     * 2、n的值为最大深度对应满二叉数的节点数；
     * 备注：从下向上的遍历不能直接解决问题；
     *
     * 关于声明：1、指定数组长度，初始化值为：“”
     *
     * 需要强调：
     * 1、计算幂要想获得整数，可用位运算；或者使用(int)Math.pow(a,b)强转
     * 2、List的初始化是通过遍历的方式解决的;
     * 3、修改List的值，可以使用list.set()方法，list.add（index, value）是往list中添加新元素；
     *
     * wrong:主要问题在于节点位置的下标计算错误。
     *
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int m = getMaxDepth(root);
        System.out.println("m=" + m);
        int n = (1<<m)-1;
        System.out.println("n=" + n);
        List<List<String>> lst = new ArrayList<>();
        helper(root, 1, lst, n, n);
        return lst;
    }

    public int getMaxDepth(TreeNode t) {
        if (t == null) return 0;
        int leftValue = getMaxDepth(t.left);
        int rightValue = getMaxDepth(t.right);
        return Math.max(leftValue,rightValue)+1;
    }

    public void helper(TreeNode root, int depth, List<List<String>> lst, int subListLen, int valueInd) {
        if (root == null) return;
        List<String> sub = null;
        System.out.println("#####start#####");
        System.out.println("depth = "+ depth + " " +  " lst.size()= " + lst.size()) ;

        if (lst.size()<depth) {
            sub = new ArrayList<>(subListLen);
            for (int i=0;i<subListLen;i++) {
                sub.add("");
            }
            lst.add(sub);
        } else {
            sub = lst.get(depth-1);
        }
        int mid = valueInd/2;
        System.out.println("valueInd=" + valueInd +" "+ "mid=" + mid + " root.val=" + root.val);
        sub.set(mid, root.val+"");

        System.out.println("#####end#####");
        System.out.println();
        helper(root.left,depth+1, lst, subListLen, mid);

        helper(root.right,depth+1, lst, subListLen, mid+valueInd);
    }

    /**
     * accept:修改之后
     * 时间复杂度：
     * 空间复杂度：
     * @param args
     */
//    public List<List<String>> printTree(TreeNode root) {
//        int m = getMaxDepth(root);
//        System.out.println("m=" + m);
//        int n = (1<<m)-1;
//        System.out.println("n=" + n);
//        List<List<String>> lst = new ArrayList<>();
//        helper(root, 1, lst, n, 0, n);
//        return lst;
//    }
//
//    public int getMaxDepth(TreeNode t) {
//        if (t == null) return 0;
//        int leftValue = getMaxDepth(t.left);
//        int rightValue = getMaxDepth(t.right);
//        return Math.max(leftValue,rightValue)+1;
//    }
//
//    public void helper(TreeNode root, int depth, List<List<String>> lst, int subListLen, int left,int right) {
//        if (root == null) return;
//        List<String> sub = null;
//        System.out.println("#####start#####");
//        System.out.println("depth = "+ depth + " " +  " lst.size()= " + lst.size()) ;
//
//        if (lst.size()<depth) {
//            sub = new ArrayList<>(subListLen);
//            for (int i=0;i<subListLen;i++) {
//                sub.add("");
//            }
//            lst.add(sub);
//        } else {
//            sub = lst.get(depth-1);
//        }
//        int mid = (left+right)/2;
//        System.out.println("left=" + left + "right=" + right +" "+ "mid=" + mid + " root.val=" + root.val);
//        sub.set(mid, root.val+"");
//
//        System.out.println("#####end#####");
//        System.out.println();
//        helper(root.left,depth+1, lst, subListLen, left, mid);
//
//        helper(root.right,depth+1, lst, subListLen, mid+1, right);
//    }


    public static void main(String[] args) {
        System.out.println(1<<3);
    }

}
