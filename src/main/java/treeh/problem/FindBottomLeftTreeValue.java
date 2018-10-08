package treeh.problem;

import treeh.common.TreeNode;

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

    /**
     * 右先进右先出
     * @param root
     * @return
     */
    public int findBottomLeftValue_A1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }

    /**
     * 递归方式
     */
    int res;
    int count=0;
    public int findBottomLeftValue_A2(TreeNode root) {
        // List<Integer> list = new ArrayList<>();
        helper(root,0);
        return res;
    }

    public void helper(TreeNode root , int depth){
        if(root == null) return;
        if(depth==count){
            count++;
            res=root.val;
        }
        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }

    //int ans = 0, h = 0;
    public int findBottomLeftValue_A3(TreeNode root) {
        return helper(root,1,new int[]{0,0});
        //return ans;
    }

    private int helper(TreeNode root,int depth,int[] res){
        if(res[0] < depth) {
            res[1] = root.val;
            res[0] = depth;
        }
        if(root.left != null) helper(root.left,depth+1,res);
        if(root.right != null) helper(root.right, depth+1,res);
        return res[1];
    }


}
