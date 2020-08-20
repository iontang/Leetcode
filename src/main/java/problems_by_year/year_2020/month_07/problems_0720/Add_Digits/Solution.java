package problems_by_year.year_2020.month_07.problems_0720.Add_Digits;

/**
 * ClassName Solutin
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/7/26 7:08 下午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addDigits(58);
    }

    public int addDigits(int num) {
        int sum = 0;
        while (String.valueOf(num).length() > 1) {
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
            sum = 0;
        }
        return num;
    }

    public int addDigits_A1(int num) {
        int sum=0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
            // 如果不符合条件，继续当前循环；否则，开始下一次循环。
            if(num == 0 && sum / 10 != 0) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }
}
