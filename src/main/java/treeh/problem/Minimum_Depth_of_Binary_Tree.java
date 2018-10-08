package treeh.problem;

import treeh.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree {

    /**
     * 一开始的做题思路： 通过判断每一层是否满足2^（n-1）个节点判断最小深度，n是指层数 ： 这种判断方法是把线性树和对称树包括进去， [做题思路：这种思路是错误的]
     *
     * 一共有四种情况：
     *      一般情况：[1,2,3,4,5]
     * 下面三种是同一种情况:
     *      单节点树，无论对称与否：[1,2,3,4,null,null,5]
     *      线性数：[1,2]
     *      只有根节点：[1]
     *
     * @param root
     * @return
     */
    // fail答案
    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0; // 层数
        int nodeTotal = 0; // 总节点数
        while (!queue.isEmpty()) {
            level++;
            int cruLevelNodeNum = queue.size(); // 当前层
            nodeTotal = nodeTotal+cruLevelNodeNum;
            // 不是线性树 且 下一层子节点不满，返回n-1
            if (cruLevelNodeNum != nodeTotal && Math.pow(2,level-1) != cruLevelNodeNum) {
                return level-1;
            }
            for (int i=0; i<cruLevelNodeNum;i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            // 下一层的子节点都为null
            if (queue.size() == 0) {
                return level;
            }
        }
        return 0;
    }

    /**
     * 修改之后
     * @param root
     * @return
     */
    public int minDepth_A1(TreeNode root) {
        if (null == root) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0; // 层数
        while (!queue.isEmpty()) {
            level++;
            int cruLevelNodeNum = queue.size(); // 当前
            for (int i=0; i<cruLevelNodeNum;i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left == null && tempNode.right == null) {
                    return level;
                }
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }

        }
        return 0;
    }

    /**
     * recursion
     * @param root
     * @return
     */
    public int minDepth_A2(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth_A2(root.left);
        int right = minDepth_A2(root.right);
        return (left==0||right==0)? left+right+1:Math.min(left,right)+1;
    }

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            if (i == 5) {
                System.out.println(i);
                break;
            }
        }
        System.out.println("end");
    }

}
