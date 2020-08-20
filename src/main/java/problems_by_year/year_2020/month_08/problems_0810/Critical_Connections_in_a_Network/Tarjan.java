package problems_by_year.year_2020.month_08.problems_0810.Critical_Connections_in_a_Network;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName Tarjan
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/14 1:59 下午
 */
public class Tarjan {

    /** number of vertices **/
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
    // 判断割点和桥不需要栈这个数据结构
    private Stack<Integer> stack;

    /**
     * 参考：
     * https://www.sanfoundry.com/java-program-tarjan-algorithm/
     *
     * function to get all strongly connected components：
     * Tarjan算法是找到并返回所有的强连通分量
     * @param n
     * @param connections 邻接矩阵 表示的图。
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

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<List<Integer>>(){{
            add(new ArrayList<Integer>(){{ add(0);add(1); }});
            add(new ArrayList<Integer>(){{ add(1);add(2); }});
            add(new ArrayList<Integer>(){{ add(2);add(0); }});
            add(new ArrayList<Integer>(){{ add(1);add(3); }});
        }};
        Tarjan tarjan = new Tarjan();
        List<List<Integer>> res = tarjan.criticalConnections(n, connections);
        System.out.println("###");
    }

}
