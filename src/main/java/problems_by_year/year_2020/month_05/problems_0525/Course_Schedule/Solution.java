package problems_by_year.year_2020.month_05.problems_0525.Course_Schedule;

import java.util.*;

/**
 * ClassName Course_Schedule
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/5/31 10:03 下午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canFinish(3, new int[][]{{1,0},{2,1}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int toTake = prerequisites[i][0];
            inDegree[toTake]++;
            int preRequisite = prerequisites[i][1];
            graph.computeIfAbsent(preRequisite,
                    k -> new ArrayList<Integer>()).add(toTake);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            List<Integer> toTake = graph.get(cur);
            if (toTake != null) {
                for (Integer i : toTake) {
                    int res = inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        for (int i : inDegree) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
