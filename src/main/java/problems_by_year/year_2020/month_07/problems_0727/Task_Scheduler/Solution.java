package problems_by_year.year_2020.month_07.problems_0727.Task_Scheduler;

import java.util.Arrays;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/28 3:39 下午
 */
public class Solution {


    /**
     * Example 1:
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation:
     * A -> B -> idle -> A -> B -> idle -> A -> B
     * There is at least 2 units of time between any two same tasks.
     *
     * Example 2:
     * Input: tasks = ["A","A","A","B","B","B"], n = 0
     * Output: 6
     * Explanation: On this case any permutation of size 6 would work since n = 0.
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * And so on.
     *
     * Example 3:
     * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * Output: 16
     * Explanation:
     * One possible solution is
     * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
     * (p-1) * (n+1) + k
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];
        for (char c : tasks) {
            charCount[c-'A']++;
        }
        Arrays.sort(charCount);
        int maxVal = charCount[25] - 1;
        int idleTotal = maxVal * n;
        for (int i = 24; i >= 0; i--) {
            idleTotal -= Math.min(charCount[i], maxVal);
        }
        return idleTotal > 0 ? idleTotal + tasks.length : tasks.length;
    }



}
