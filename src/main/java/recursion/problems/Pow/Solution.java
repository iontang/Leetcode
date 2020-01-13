package recursion.problems.Pow;

class Solution {
    public double myPow(double x, int n) {
        if (n > 230 || n < -231) return 0.0;
        if (n == 0) {
            return 1.0;
        }
        if (n > 0) {
            return x*myPow(x, n-1);
        } else {
            return (1/x) * myPow(x, n+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myPow(0.00001, 2147483647);
    }
}