package problems_by_year.year_2020.month_07.problems_0706.Subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/12 12:21 上午
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        Solution solution = new Solution();
        solution.subsets_A2(arr);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> sub = new ArrayList<>();
            for (List<Integer> eleList : res) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(eleList);
                newList.add(nums[i]);
                sub.add(newList);
            }
            for (List<Integer> lst : sub) {
                res.add(lst);
            }
        }
        return res;
    }

    /**
     * 二进制的方法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_A1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);
            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            output.add(curr);
        }
        return output;
    }

    List<List<Integer>> output = new ArrayList();
    int n, k;
    // 回溯
    public List<List<Integer>> subsets_A2(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
        }
        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    /**
     * nums = [1,2,3]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_W1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[i]);
            res.add(subList);
            List<Integer> secondSubList = subList.stream().map(val -> new Integer(val)).collect(Collectors.toList());
            for (int j = i+1; j < nums.length; j++) {
                secondSubList.add(nums[j]);
                res.add(secondSubList);
                secondSubList = subList.stream().map(val -> new Integer(val)).collect(Collectors.toList());
            }
        }
        return res;
    }
}
