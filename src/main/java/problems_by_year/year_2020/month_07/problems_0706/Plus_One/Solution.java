package problems_by_year.year_2020.month_07.problems_0706.Plus_One;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/6 4:52 下午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.plusOne(new int[]{1,0,0,0,0});
        solution.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
    }

    /**
     * 需要考虑溢出的情况
     * @param digits
     * @return
     */
    public int[] plusOne_W1(int[] digits) {
        int digitsLen = digits.length;
        long cnt = 0;
        long pow = 0;
        for (int i = digitsLen - 1; i >= 0; i--) {
            cnt += digits[i] * Math.pow(10, pow);
            pow++;
        }
        cnt += 1;
        int resLen = Long.toString(cnt).length();
        int[] res = new int[resLen];
        int index = 0;
        long sub = (int) Math.pow(10, resLen-1);
        while (index < resLen) {
            res[index] = (int) (cnt / sub);
            cnt %= sub;
            sub /= 10;
            index++;
        }
        return res;
    }

    public int[] plusOne(int[] digits) {
        int digitsLen = digits.length;
        int lastIndex = digitsLen - 1;
        if (digits[lastIndex] + 1 < 10) {
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }
        int temp = 1;
        for (int i = digitsLen - 1; i >= 0; i--) {
            if (digits[i] + temp > 9) {
                temp = 1;
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + temp;
                temp = 0;
            }
        }

        if (temp == 1) {
            int[] res = new int[digitsLen +1];
            res[0] = 1;
            for (int i = 0; i< digitsLen; i++) {
                res[i+1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }

    public int[] plusOne_A1(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}
