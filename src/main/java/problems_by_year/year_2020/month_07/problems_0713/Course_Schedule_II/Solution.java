package problems_by_year.year_2020.month_07.problems_0713.Course_Schedule_II;

import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/19 12:34 上午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int numCourses = 3;
//        int[][] prerequisites = new int[][]{{0,2},{1,2},{2,0}};
        int numCourses = 3;
        int[][] prerequisites = new int[][]{{2,0},{2,1}};

        solution.findOrder(numCourses, prerequisites);
    }

    /**
     * 6
     * [[4,0],[4,1],[3,1],[3,2],[5,4],[5,3]]
     * input:
     * 0->4->5
     * 1->4->5
     * 1->3->5
     * 2->3->5
     * output:
     * [2,1,3,0,4,5]
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int rowLen = prerequisites.length;
        int[] outDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < rowLen; i++) {
            // 目标课程
            int toTake = prerequisites[i][0];
            // 被依赖课程
            int preRequisite = prerequisites[i][1];
            // 出度：
            outDegree[preRequisite]++;
            graph.computeIfAbsent(toTake,
                    k -> new ArrayList<Integer>()).add(preRequisite);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            List<Integer> preReqList = graph.get(cur);
            if (preReqList != null) {
                for (Integer i : preReqList) {
                    outDegree[i]--;
                    if (outDegree[i]==0) {
                        queue.add(i);
                    }
                }
            }
        }
        // 处理有循环的节点。
        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] != 0) {
                return new int[]{};
            }
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
