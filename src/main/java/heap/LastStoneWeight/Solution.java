package heap.LastStoneWeight;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : stones) {
            maxHeap.offer(i);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (x < y) {
                maxHeap.offer(y-x);
            }
        }
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }


    /**
     * submit-1
     * @param stones
     * @return
     */
    public int lastStoneWeight_A1(int[] stones) {
        int i = stones.length - 1;
        while (i > 0) {
            // order every time.
            Arrays.sort(stones);
            int smash = stones[i] - stones[i - 1];
            i -= 1;
            stones[i] = smash;
        }
        return stones[0];
    }


    public  static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {2,7,4,1,8,1};
        solution.lastStoneWeight(stones);
    }

}
