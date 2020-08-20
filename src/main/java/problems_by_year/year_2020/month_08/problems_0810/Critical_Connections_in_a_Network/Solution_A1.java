package problems_by_year.year_2020.month_08.problems_0810.Critical_Connections_in_a_Network;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Solution_A1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/15 10:02 上午
 */
public class Solution_A1 {

    private List<Integer>[] edges;
    private int[] DFN;
    private int[] LOW;
    // 也可以不使用visited这个数组，直接通过DFN判断，如果DFN[v] == 0，就是未visited过。
    private boolean[] visited;
    private List<List<Integer>> ans;
    private int t;

    /**
     * 如果一个边是关键路径，当且仅当该边不在环中。
     *
     * 使用深度优先搜索查找环:
     *    1.首先转换成邻接表
     *    2.深度优先访问
     *    3.对每一个节点记录访问深度
     *    4.如果子节点的深度小于等于当前节点了，说明我们找到环了！去掉该边
     *    5.同时记录返回当前节点的最小深度，以便去掉整个环
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.edges = new ArrayList[n];
        this.DFN = new int[n];
        this.LOW = new int[n];
        this.visited = new boolean[n];
        this.ans = new ArrayList<>();
        this.t = 0;
        for(int i = 0; i < n; i ++) {
            edges[i] = new ArrayList<>();
        }
        // 转换成邻接表
        for (List<Integer> conn : connections) {
            int n1 = conn.get(0), n2 = conn.get(1);
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        tarjan(0, -1);
        return ans;
    }

    public void tarjan(int cur, int pre) {
        t++;
        DFN[cur] = t;
        LOW[cur] = t;
        visited[cur] = true;
        for (int subNode : edges[cur]) {
            if (subNode == pre) {
                continue;
            }
            if (!visited[subNode]) {
                tarjan(subNode, cur);
                LOW[cur] = Math.min(LOW[cur], LOW[subNode]);
                // 子节点的LOW值大于父节点的DFN值，满足桥的条件。
                if (LOW[subNode] > DFN[cur]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(subNode);
                    ans.add(list);
                }
            } else {
                LOW[cur] = Math.min(LOW[cur], DFN[subNode]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<List<Integer>>(){{
            add(new ArrayList<Integer>(){{ add(0);add(1); }});
            add(new ArrayList<Integer>(){{ add(1);add(2); }});
            add(new ArrayList<Integer>(){{ add(2);add(0); }});
            add(new ArrayList<Integer>(){{ add(1);add(3); }});
        }};
        Solution_A1 s = new Solution_A1();
        List<List<Integer>> res = s.criticalConnections(n, connections);
        System.out.println("###");
    }

}
