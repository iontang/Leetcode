package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.*;

/**
 * 606.
 * 题意：把一个输出转化为包括回文括号在内的字符串，比如："1(2()(4))(3)"
 */
public class Construct_String_from_Binary_Tree {

    /**
     * 声明“String”，然后使用“+”累加结果无法得到前序遍历的输出，必须要使用“StringBuffer”：因为“String”是不可变的对象，每次都会创建新的对象实例。
     * wrong：可修改
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        StringBuffer result = new StringBuffer();
        helper(t,result);
        System.out.println(result.toString());
        return  result.toString();
    }
    public void helper(TreeNode t, StringBuffer result) {
        if (t == null)
            return ;
        result.append(t.val);
        helper(t.left, result);
        helper(t.right, result);
    }

    /**
     * 参考：时间复杂度——O(n)
     * @param t
     * @return
     */
    public String tree2str_A1(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }

    /**
     * 参考
     * @param t
     * @return
     */
    public String tree2str_A2(TreeNode t) {
        if (t == null)
            return "";
        Stack < TreeNode > stack = new Stack < > ();
        stack.push(t);
        Set< TreeNode > visited = new HashSet< >();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Construct_String_from_Binary_Tree c = new Construct_String_from_Binary_Tree();

        System.out.println("###" + c.tree2str(root));
    }


}
