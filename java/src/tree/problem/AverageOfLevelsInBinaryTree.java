package src.tree.problem;

import src.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历的应用：求一棵二叉树每一层节点的平均值
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lst = new ArrayList<Double>();
        if (root == null) {
            return lst;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i=0;i<levelSize;i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                levelSum+=queue.poll().val;
            }
            lst.add(levelSum/levelSize);
        }
        return lst;
    }

}
