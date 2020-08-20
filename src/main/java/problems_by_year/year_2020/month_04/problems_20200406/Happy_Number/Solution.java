package problems_by_year.year_2020.month_04.problems_20200406.Happy_Number;

public class Solution {

    public static void main(String[] args) {

        int n = 1234;
        while (n != 0) {
            System.out.println(n%10);
            n /= 10;
        }
        Solution solution = new Solution();
        solution.isHappy_W1(1111111);
    }

    /**
     * Last executed input
     * 输入2会出现循环其他几个数
     * @param n
     * @return
     */
    public boolean isHappy_W1(int n) {
        int tmp = 0;
        int originNum = n;
        boolean isHappy = false;
        while (true) {
            tmp += Math.pow(n%10, 2);
            if (n==0 && tmp==1) {
                isHappy = true;
                break;
            } else if (n==0 && (tmp==originNum) ) {
                break;
            } else if (n==0) {
                System.out.println(tmp);
                n = tmp;
                tmp = 0;
            } else {
                n /= 10;
            }
        }
        return isHappy;
    }


    /**
     * 有4就不是happy number；
     *
     * https://www.jianshu.com/p/ba4a7508b1ad 快指针 慢指针解法。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        int tmp = 0;
        boolean isHappy = false;
        while (true) {
            tmp += Math.pow(n%10, 2);
            if (n==0 && tmp==1) {
                isHappy = true;
                break;
            } else if (n==0 && ( tmp == 4) ) {
                break;
            } else if (n==0) {
                System.out.println(tmp);
                n = tmp;
                tmp = 0;
            } else {
                n /= 10;
            }
        }
        return isHappy;
    }
}
