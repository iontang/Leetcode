package problems_by_year.year_2020.month_04.problems_20200420.Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // brute：暴力搜索
    // [1,2,1,2,1] 3
    public int subarraySum_R1(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (k == sum) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int len = 10;
//        long[] nums = new long[len+1];
//        nums[0] = 1;
//        for (int i = 1; i <= len; ++i) {
//            for (int j = i; j <= len; ++j) {
//                nums[j] += nums[j-i];
//            }
//        }
//
//        for (int i = 0; i <= len; i++) {
//            System.out.println(nums[i]);
//        }
        int i = 1;
        Solution solution = new Solution();
//        int[] nums = {28,54,7,-70,22,65,-6};
//        int[] nums = {1,1,1};
//        int[] nums = {-1,-1,1};
        int[] nums = {-1, -1, 1};

        solution.subarraySum_A1(nums, 0);
    }

    /**
     * the problem is the same as Contiguous Array.
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_W1(int[] nums, int k) {
        if (nums.length == 1 ) {
            return nums[0] == k ? 1 : 0;
        }
        int cnt = 0;
        int move = 1;
        int curr = 0;
        int sum = nums[curr];
        while (curr < nums.length ) {
            if (sum < k && move < nums.length) { // 如果只有正数的话，这个条件没有错，但是数组中也有负数
                sum += nums[move++];
            } else if (sum == k) {
                ++curr;
                if (curr < nums.length) {
                    sum = nums[curr];
                }
                move = curr + 1;
                ++cnt;
            } else {
                ++curr;
                if (curr < nums.length) {
                    sum = nums[curr];
                }
                move = curr + 1;
            }
        }
        return cnt;
    }



    // int[] nums = {28,54,7,-70,22,65,-6};
    // sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j.
    // Can we use this property to optimize it.
    // 28->0, 82->1, 89->2, 19->3
    // 19 - 82 = -63 : k=-63 ==> sum(1,3)=sum(0,3)-sum(0,1)
    // k = 61 -> 89-28:
    // k= sum(0,j) - sum(0,i)
    // sum(0,i) = sum(0,j) - k
    // k + sum(0,i) = sum(0,j)

    // {1,1,1} 2
    public int subarraySum_W2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int diff = entry.getKey() - k;
            int total = entry.getValue() + k;
            if (k == entry.getKey()) {
                ++cnt;
            } else if (map.containsKey(diff) && entry.getValue() > map.get(diff)) {
                ++cnt;
            } else if (map.containsKey(total) && map.get(total) > entry.getValue()) {
                ++cnt;
            }
        }
        return cnt;
    }

    // [-1, -1, 1] 0
    // sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int diff = entry.getValue() - k;
            if (k == entry.getValue()) {
                ++cnt;
            } else if (map.containsValue(diff) && entry.getValue() > map.get(diff)) {
                ++cnt;
            }
        }
        return cnt;
    }


    public int subarraySum_A1(int[] nums, int k) {
        // Edge cases
        if(nums.length == 0)    return 0;
        // Sliding window -- No, contains negative number
        // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
                  for example: [-1, -1, 1] 0
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, 1);
        for(int cur : nums) {
            sum += cur;
            // there exist a key, that [hashmap-key  =  sum - k]
            if(map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

}
