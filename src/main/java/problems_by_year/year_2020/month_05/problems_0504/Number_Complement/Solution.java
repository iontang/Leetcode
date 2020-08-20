package problems_by_year.year_2020.month_05.problems_0504.Number_Complement;

public class Solution {

    public static void main(String[] args) {
        System.out.println(2 << 1);
        int num = 5;
        System.out.println(num >>= 1);

        Solution so  = new Solution();
        so.findComplement_A2(5);
    }

    public int findComplement(int num) {
        String numStr = Integer.toBinaryString(num);
        int len = numStr.length();
        StringBuilder sb = new StringBuilder();
        while (len > 0) {
            len--;
            sb.append("1");
        }
        return num ^ Integer.valueOf(sb.toString(), 2) ;
    }

    public int findComplement_A1(int num) {
        int cp = num;
        int sum = 0;
        while(num > 0){
            // 计算二进制长度位为n的最大数，比如101，最大数是 ： 111
            sum = (sum << 1) + 1;
            // 统计int有多少二进制
            num >>= 1;
        }
        return sum - cp;
    }

    public int findComplement_A2(int num) {
        int onesMask = 1;
        int numberOfBits = Integer.toBinaryString(num).length();
        for(int i = 1; i < numberOfBits; i++) {
            onesMask += 1 << i;
        }
        return onesMask^num;
    }


}
