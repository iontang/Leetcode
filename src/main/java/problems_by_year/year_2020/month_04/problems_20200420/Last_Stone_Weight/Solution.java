package problems_by_year.year_2020.month_04.problems_20200420.Last_Stone_Weight;

import java.util.PriorityQueue;

public class Solution {

    /**
     * We have a collection of stones, each stone has a positive integer weight.
     *
     * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
     *
     * If x == y, both stones are totally destroyed;
     * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
     * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
     */

    /**
     * Input: [2,7,4,1,8,1]
     * Output: 1
     * Explanation:
     * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
     * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
     * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
     * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
     */

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i : stones) {
            maxQueue.offer(i);
        }

        Integer maxStone, secondStone, diff;
        while (maxQueue.size() > 1) {
            maxStone = maxQueue.poll();
            secondStone = maxQueue.poll();
            diff = maxStone-secondStone;
            if (diff > 0) {
                maxQueue.offer(diff);
            }
        }
        return maxQueue.isEmpty() ? 0 : maxQueue.poll();

    }

    public static void main(String[] args) {
        Integer i = null;
        System.out.println(10 - i);
    }
}
