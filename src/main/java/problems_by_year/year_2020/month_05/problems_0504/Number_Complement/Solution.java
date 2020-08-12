package year.year_2020.month_05.problems_0504.Number_Complement;

public class Solution {

    public static void main(String[] args) {

        Solution so  = new Solution();
        so.findComplement(1024);
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
            sum = (sum << 1) + 1;
            num >>= 1;
        }
        return sum - cp;

    }
}
