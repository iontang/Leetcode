package tree.problem;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从下往上的层序遍历二叉树：
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * 利用java自带的数据结构，从上到下遍历，将每一层的数据按照索引0的位置进行插入
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();
        if(root == null) return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(0,subList);
        }
        return wrapList;
    }


    /**
     * recurion
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom_A1(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        layerProcess(root,result,0);
        return result;
    }
    private void layerProcess(TreeNode node,LinkedList<List<Integer>> result,int level){
        if(node == null){
            return ;
        }
        if(result.size()<level+1){
            result.addFirst(new LinkedList<Integer>());
        }
        result.get(result.size()-1-level).add(node.val);
        layerProcess(node.left,result,level+1);
        layerProcess(node.right,result,level+1);
    }

}
