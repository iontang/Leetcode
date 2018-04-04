package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (null == root) {
            return lst;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0;i<levelSize;i++) {
                if (queue.peek().left!= null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right!=null) {
                    queue.offer(queue.peek().right);
                }
                root = queue.poll();
            }
            lst.add(root.val);
        }
        return lst;
    }

}
