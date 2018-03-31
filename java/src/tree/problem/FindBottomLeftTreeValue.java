package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目要求：找到最后一层最左边的子树
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        Integer result = null;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();

            for (int i =0; i<levelNum; i++) {
                if (null != queue.peek().left) {
                    queue.offer(queue.peek().left);
                }
                if (null != queue.peek().right) {
                    queue.offer(queue.peek().right);
                }

                if (i == 0) { // 每一层取最左边的点
                    result = queue.peek().val;
                }
                queue.poll();
            }
        }
        return result;
    }


}
