package problems_by_year.year_2020.month_08.problems_0824.Fizz_Buzz;


// 412:
// Fizz Buzz
// fizz-buzz

//Write a program that outputs the string representation of numbers from 1 to n.
//
//
// But for multiples of three it should output “Fizz” instead of the number and
//for the multiples of five output “Buzz”. For numbers which are multiples of both
// three and five output “FizzBuzz”.
//
// Example:
//
//n = 15,
//
//Return:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
//
// 👍 971 👎 1311

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/8/28 11:05 上午
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(1%3);
        System.out.println(15%3);
        System.out.println(15%5);
        String buzz = "Buzz";
        String fizz = "Fizz";
        System.out.println(String.format("%s%s", fizz, buzz));;
        Solution solution = new Solution();
        solution.fizzBuzz(15);
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        String buzz = "Buzz";
        String fizz = "Fizz";
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add(String.format("%s%s", fizz, buzz));
            } else if (i % 3 == 0) {
                res.add(fizz);
            } else if (i % 5 == 0) {
                res.add(buzz);
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

