//
// Created by admin on 2019/9/9.
//

#ifndef LEETCODE_69SQRT_X_H
#define LEETCODE_69SQRT_X_H

#endif //LEETCODE_69SQRT_X_H

// 二分法： 1 < result < (x/2+1)，
// 有了这个条件，还不足够，还需要一个计算公式以及跳出循环的条件。

// https://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html

class Solution {
public:
    int mySqrt(int x) {

        long left = 0;
        long right = x/2 +1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sq = mid * mid;
            if (sq == x)
                return mid;
            else if (sq < x) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return right; // 此题只需要一个简单的取整结果，如果需要精确的值，可采用牛顿迭代法。
    }

    //牛顿法：
//    int mySqrt(int x) {
//
//        if (x == 0) return 0;
//        double last = 0.0;
//        double res = 1.0;
//        while (res != last)
//        {
//            last = res;
//            res = (res + x / res) / 2;
//        }
//        return res;
//    }
};
