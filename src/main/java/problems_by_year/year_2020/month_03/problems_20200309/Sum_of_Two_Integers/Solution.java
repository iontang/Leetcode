package problems_by_year.year_2020.month_03.problems_20200309.Sum_of_Two_Integers;

public class Solution {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Solution solution = new Solution();
        solution.transform2Binary(10, stringBuilder);
//        System.out.println(stringBuilder.toString());
        solution.getSum(20,17);

    }



    public int getSum(int a, int b) {
        int sum = a;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        while (b != 0) {
            sum = a ^ b;
            System.out.println("binary sum=" + Integer.toBinaryString(sum));
            System.out.println("sum=" + sum);
            b = (a & b) << 1;

            System.out.println("binary b=" + Integer.toBinaryString(b));
            System.out.println("b=" + b);
            a = sum;
        }
        return sum;
    }


    private void transform2Binary(int decimalNum, StringBuilder stringBuilder) {
        if (decimalNum == 0)
            return ;
        else {
            transform2Binary(decimalNum/2, stringBuilder);
            String result = String.valueOf(decimalNum % 2);
            stringBuilder.append(result);
        }
    }

    private void transform2Binary(int decimal) {
        for (int i = 31; i >= 0; i--)
            System.out.print(decimal >>> i & 1);
    }
}
