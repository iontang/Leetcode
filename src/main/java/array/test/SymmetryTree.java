package array.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName SymmetryTree
 * PayPal
 * @version 1.0
 * @Author: ion
 * @Date: 2021/3/2 4:26 下午
 */
public class SymmetryTree {

    class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }

    }

    public boolean isSymmetry(Node root) {
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null && root.left.val == root.right.val) {
            return isSymmetry(root.left) && isSymmetry(root.right);
        }
        return false;
    }

}
