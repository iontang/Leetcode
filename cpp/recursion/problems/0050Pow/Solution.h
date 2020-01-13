//
// Created by admin on 2019/8/21.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

#endif //LEETCODE_SOLUTION_H


// There are sub-equations two if value n classify to positive or negative number.
class Solution {
public:
    // Runtime Error because O(n) solution.
//    double myPow(double x, int n) {
//        if (n == 0)
//            return 1.0;
//        if (n > 0) {
//            return x*myPow(x,n-1);
//        } else {
//            return (1/x)*myPow(x,n+1);
//        }
//    }

    double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n < 0){
            x = 1/x;
            return (n %2 == 0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }
        return (n%2==0)?myPow(x*x, n/2) :x*myPow(x*x, n/2);
    }
};