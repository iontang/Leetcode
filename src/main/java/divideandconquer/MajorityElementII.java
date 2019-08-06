package divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 229.
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * 题目是对时间和空间复杂度有要求：
 *
 *
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int candidate = 0;
        int count = 0;
        int len = nums.length/3;

        for (Integer i : nums) {
            if (count == 0) {
                candidate = i;
            }

            if (count > len) {
                lst.add(i);
                count=0;
                candidate =0;
            }
            if (candidate == i) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return lst;
    }

    // 无论怎么样，满足条件的至多为两个元素
    public List<Integer> majorityElement_A1(int[] nums) {
        int k = nums.length/3 + 1;
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)return res;
        int num1 = nums[0], num2 = nums[0];
        int count1 = 0, count2 = 0;
        for(int i : nums)
        {
            if(i == num1) {
                count1++;
            } else if(i == num2) {
                count2++;
            } else if(count1 == 0) {
                num1 = i;
                count1 = 1;
            }else if(count2 == 0) {
                num2 = i;
                count2 = 1;
            }else{
                count1 -- ;
                count2 -- ;
            }
        }
        //when nums only contain 2 elements.
        if(count1 >=k && count2 >= k)
        {
            res.add(num1);
            res.add(num2);

        }
        //nums containing more than 2 elements.
        // 第一次遍历是找到候选的两个数，第二次是确认满足条件的数
        else{
            count1 = 0; count2 = 0;
            for(int i : nums){
                if(i == num1)count1++;
                else if(i == num2)count2++;
            }
            if(count1 >= k)res.add(num1);
            if(count2 >= k)res.add(num2);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,3};
        System.out.println(8/3);

        int[] nums = {1,1,1,1,3,2,2,2,2,4};

        MajorityElementII majorityElementII = new MajorityElementII();
        majorityElementII.majorityElement_A1(nums);

    }


}
