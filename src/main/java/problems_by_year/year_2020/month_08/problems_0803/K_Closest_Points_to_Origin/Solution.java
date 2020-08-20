package problems_by_year.year_2020.month_08.problems_0803.K_Closest_Points_to_Origin;

import java.util.*;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/4 5:46 下午
 */
public class Solution {


    /**
     * Example 1:
     *
     * Input: points = [[1,3],[-2,2]], K = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
     *
     * Example 2:
     *
     * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
     * Output: [[3,3],[-2,4]]
     * (The answer [[-2,4],[3,3]] would also be accepted.)
     */

    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            priorityQueue.offer(distance);
            map.computeIfAbsent(distance, k -> new ArrayList<>()).add(i);
        }
        int[][] res = new int[K][2];
        int cnt = 0;
        while (cnt < K) {
            int distance = priorityQueue.poll();
            List<Integer> lst = map.get(distance);
            for (int i = 0; i < lst.size() && i < K; i++) {
                res[cnt] = points[lst.get(i)];
                cnt++;
            }
        }
        return res;
    }

    /**
     * 快排——更简洁的写法
     */
    public int[][] kClosest_A2(int[][] points, int K) {
        // 在 `Java` 里面，可以利用优先队列：PriorityQueue 来处理，其内部实现是堆。
        Queue<int[]> priorityQueue = new PriorityQueue<>(K, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        for (int[] point : points) {
            priorityQueue.add(point);
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }


    /**
     * quick sort
     */
    public int[][] kClosest_A1(int[][] points, int K) {
        quickSelect(points, K, 0, points.length-1);
        return Arrays.copyOfRange(points, 0, K);
    }
    public void quickSelect(int[][] points, int k, int start, int end) {
        if (start == end) {
            return;
        }
        int p = dist(points[(start+end)/2]);
        int i = start;
        int j = end;
        while (i <= j) {
            while (i <= j && dist(points[i]) < p) {
                i++;
            }
            while (i <= j && dist(points[j]) > p) {
                j--;
            }
            if (i <= j) {
                int[] tmp = points[j];
                points[j] = points[i];
                points[i] = tmp;
                i++;
                j--;
            }
        }
        if (k <= j+1) {
            quickSelect(points, k, start, j);
        }
        if (k >= i+1) {
            quickSelect(points, k, i, end);
        }
        return;
    }
    public int dist(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

}
