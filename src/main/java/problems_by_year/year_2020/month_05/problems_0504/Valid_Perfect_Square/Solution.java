package problems_by_year.year_2020.month_05.problems_0504.Valid_Perfect_Square;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPerfectSquare_R1(Integer.MAX_VALUE);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483647);
    }

    public boolean isPerfectSquare(int num) {
        for (int i = 1; num > 0; i+=2) {
            num -= i;
        }
        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isPerfectSquare_R1(int num) {
        int start = 1, end = num;
        while (start <= end) {
            int mid = start + (end - start)/2;
            // 必须转成long型，否则相乘会溢出。
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare_A1(int num) {
        long l = 1;
        long r = num;

        while (l <= r) {
            long mid = l - (l - r) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

}
