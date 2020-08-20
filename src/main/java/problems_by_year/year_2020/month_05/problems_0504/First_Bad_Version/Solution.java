package problems_by_year.year_2020.month_05.problems_0504.First_Bad_Version;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 数据量大的时候，会溢出。
        solution.firstBadVersion_A1(5);
        // 2126753390
        // 2147483647
        System.out.println(Integer.MAX_VALUE);
    }

    // 2126753390
    // 1702766719
    // 1,2,3,4,5
    // f f f f t
    public int firstBadVersion(int n) {
        long start = 1;
        long end = n;
        long mid = (end + start) / 2;
        while (mid > 0) {
            if (isBadVersion((int) mid) ) {
                if (!isBadVersion((int)mid-1)) {
                    return (int) mid;
                } else {
                    end = mid;
                    mid = (end+start) /2;
                }
            } else {
                if (isBadVersion((int) mid+1)) {
                    return (int) mid+1;
                } else {
                    start = mid;
                    mid = (end + start) / 2;
                }
            }
        }
        return 0;
    }

    public int firstBadVersion_A1(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int firstBadVersion_recursive(int n) {

        return 0;
    }

    private int helper(int start, int end) {
        int mid = (start + end) / 2;
        if (mid == 0) return mid;

        if (isBadVersion(mid) ) {
            if (!isBadVersion(mid-1)) {
                return mid;
            } else {
                helper(1, mid);
            }
        }
        return 0;
    }


    public boolean isBadVersion(int n) {
        if (n >= 4) {
            return true;
        } else {
            return false;
        }
    }

}
