package problems_by_year.year_2020.month_03.problems_20200302.Predict_the_Winner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.PredictTheWinner_A1(new int[]{1,5,8,4});
    }



    public boolean PredictTheWinner_A1(int[] nums) {
        return winner(nums, 0, nums.length - 1, 1) >= 0;
    }
    public int winner(int[] nums, int s, int e, int turn) {
        if (s == e)
            return turn * nums[s];
        int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
        int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
    }

    public boolean PredictTheWinner_A2(int[] nums) {
        return getMaxScore(nums,0,nums.length-1) >= 0;
    }
    // minMax的思想就是，每一个玩家都应该保证每一轮他与另外一个玩家的差值都应该是损失最小或者获利最大的
    private int getMaxScore(int[] nums, int s, int e){
        if (s == e)
            return nums[s];

        // 如果选取第一个，那么对于下一个玩家，他希望的就是自己能在剩下的范围内得到MaxScore

        int first = nums[s] - getMaxScore(nums,s+1,e);
        int last = nums[e] - getMaxScore(nums,s,e-1);

        return Math.max(first,last);
    }


    /**
     * Calculate the maximum value of player-1 by backtracking,
     * The value of player-2 is the total array minus the value of player-1
     * can't write the code.
     * @return
     */
    public boolean PredictTheWinner_W2(int[] nums) {
        int maxPlay1 = Integer.MIN_VALUE;

        int result = calPlay1(0, 0, maxPlay1, nums);
        System.out.println(result);

        return true;
    }

    int calPlay1(int i, int cnt, int maxPlay1, int[] nums) {
        if (i > nums.length-1) {
            if (cnt > maxPlay1) maxPlay1 = cnt;
            return maxPlay1;
        }
        int fisrtResult = calPlay1(i+1, cnt, maxPlay1, nums);
        int secondResult = calPlay1(i+1, cnt+nums[i], maxPlay1, nums);
//        int thri = calPlay1(i+1, cnt+nums[i+1], maxPlay1, nums);
        if (fisrtResult > secondResult) {
            maxPlay1 = fisrtResult;
        } else {
            maxPlay1 = secondResult;
        }

        return maxPlay1;
    }

    /**
     * wrong: Input: [1, 5, 233, 7]
     * I assume all the two players choose current max,
     * but player's choose must be final max, not current max. [题意：player1先选， 要达到最终的结果最大值。]
     * @param nums
     * @return
     */
    public boolean PredictTheWinner_W1(int[] nums) {
        int playerFirst = 0;
        int playerSecond = 0;
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        int i = 0;
        while (leftPointer < rightPointer) {
            if (i % 2 == 0) { // player1
                if (nums[leftPointer] > nums[rightPointer]) {
                    playerFirst += nums[leftPointer];
                    ++leftPointer;
                } else {
                    playerFirst += nums[rightPointer];
                    --rightPointer;
                }
            } else {
                if (nums[leftPointer] > nums[rightPointer]) {
                    playerSecond += nums[leftPointer];
                    ++leftPointer;
                } else {
                    playerSecond += nums[rightPointer];
                    --rightPointer;
                }
            }
            ++i;
        }

        if (i % 2 == 0) {
            playerFirst += nums[leftPointer];
        } else {
            playerSecond += nums[leftPointer];
        }

        return playerFirst >= playerSecond;
    }

}
