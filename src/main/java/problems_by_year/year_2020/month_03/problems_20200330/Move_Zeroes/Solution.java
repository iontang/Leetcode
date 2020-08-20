package problems_by_year.year_2020.month_03.problems_20200330.Move_Zeroes;

public class Solution {

    private static final int COUNT_BITS = Integer.SIZE - 3;

    public static void main(String[] args) {
        System.out.println(COUNT_BITS);
        System.out.println(        Integer.toBinaryString(-1 << COUNT_BITS));

    }


    public void moveZeroes(int[] nums) {
        if (nums.length == 0 && nums.length==1) return;
        int i=0, j = 1;
        // [0,1,0,3,12]

        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                ++i;
                ++j;
            } else if (nums[i] ==0 && nums[j] ==0) {
                ++j;
            } else if (nums[i] != 0 && nums[j] != 0) {
                i = ++j;
            } else {
                ++i;
                ++j;
            }
        }

    }

    public void moveZeroes_A1(int[] nums) {
        int nonzeroNumIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonzeroNumIndex] = nums[i];
                nonzeroNumIndex++;
            }
        }

        for(int i = nonzeroNumIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }



}
