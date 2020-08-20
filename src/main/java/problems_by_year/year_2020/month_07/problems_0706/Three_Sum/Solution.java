package problems_by_year.year_2020.month_07.problems_0706.Three_Sum;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/10 12:00 上午
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        int[] nums = new int[]{1,2,-2,-1};
//        int[] nums = new int[]{0,0,0};
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        Solution solution = new Solution();
        solution.threeSum_W1(nums);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        if (nums.length < 3) {
            return lst;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                List<Integer> subList = new ArrayList<>();
                int sum = - (nums[i] + nums[j]);
                // 相对与_W1，主要变化是map.get(sum) > j ： sum的值，必须是在j之后
                if (map.containsKey(sum) && map.get(sum) > j ) {
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(sum);
                    // {-1,0,1,2,-1,-4}
                    // {-4,-1,-1,0,1,2}
                    lst.add(subList);
                    while ((j < nums.length - 1) && (nums[j] == nums[j + 1])) {
                        j++;
                    }
                }
                while ((i < nums.length - 1) && (nums[i] == nums[i + 1])) {
                    i ++;
                }
            }
        }
        return lst;
    }


    public List<List<Integer>> threeSum_A1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n-2; i++){
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];
            int lo = i + 1, hi = n - 1;
            while(lo < hi){
                int temp = nums[lo] + nums[hi];
                if(temp == target){
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[lo], nums[hi]}));
                    lo++;
                    while(lo < hi && nums[lo] == nums[lo-1]) {
                        lo++;
                    }
                    hi--;
                    while(lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                }else if(temp < target){
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        return res;
    }

    /**
     * Time Limit Exceeded
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_W2(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        if (nums.length < 3) {
            return lst;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                List<Integer> subList = new ArrayList<>();
                int sum = - (nums[i] + nums[j]);
                // 相对与_W1，主要变化是map.get(sum) > j ： sum的值，必须是在j之后
                if (map.containsKey(sum) && map.get(sum) > j ) {
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(sum);
                    Collections.sort(subList);
                    if (!lst.contains(subList)) {
                        lst.add(subList);
                    }
                }
            }
        }
        return lst;
    }


    /**
     * Input:
     * [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
     * Output:
     * [[-4,1,3],[-4,0,4],[-2,-2,4],[-5,1,4],[-2,1,1]]
     * Expected:
     * [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_W1(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        if (nums.length < 3) {
            return lst;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                List<Integer> subList = new ArrayList<>();
                int sum = - (nums[i] + nums[j]);
                if (map.containsKey(sum) && map.get(sum) != 0 ) {
                    if ((nums[i] == sum || nums[j] == sum) && map.get(sum) == 1) {
                        continue;
                    }
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(sum);
                    Collections.sort(subList);
                    if (!lst.contains(subList)) {
                        lst.add(subList);
                    }
                    // 错就错在，用sum作key
                    map.put(sum, map.get(sum)-1);
                }
            }
        }
        return lst;
    }


}
