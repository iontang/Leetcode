package problems_by_year.year_2020.month_08.problems_0810.Critical_Connections_in_a_Network;

import tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/13 11:48 下午
 */
public class Solution {

    private int verticesLen;
    /** preorder number counter **/
    private int preCount;
    /** low number of v **/
    private int[] low;
    /** to check if v is visited **/
    private boolean[] visited;
    /** to store given graph **/
    private List<List<Integer>> graph;
    /** to store all scc **/
    private List<List<Integer>> sccComp;
    private Stack<Integer> stack;

    /**
     * @param n
     * @param connections 邻接表 表示的图，此处的写法不用转成邻接矩阵
     * @return
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        verticesLen = n;
        this.graph = connections;
        low = new int[n];
        visited = new boolean[n];
        stack = new Stack<Integer>();
        sccComp = new ArrayList<>();
        stack = new Stack<Integer>();
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
        return sccComp;
    }

    public void dfs(int v) {
        low[v] = preCount++;
        visited[v] = true;
        stack.push(v);
        int min = low[v];
        for (int w : graph.get(v)) {
            if (!visited[w]) {
                dfs(w);
            }
            if (low[w] < min) {
                min = low[w];
            }
        }
        if (min < low[v])
        {
            low[v] = min;
            return;
        }
        List<Integer> component = new ArrayList<Integer>();
        int w;
        do
        {
            w = stack.pop();
            component.add(w);
            low[w] = verticesLen;
        } while (w != v);
        sccComp.add(component);
    }
}
