package problems_by_year.year_2020.month_05.problems_0504.Majority_Element;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {7, 7, 5, 7, 5, 1 , 5, 7 , 5, 5, 7, 7 , 5, 5, 5, 5};
        Solution solution = new Solution();
        solution.majorityElement(nums);
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
