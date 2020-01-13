//
// Created by admin on 2019/8/16.
//

#ifndef LEETCODE_UGLYNUMBERII_H
#define LEETCODE_UGLYNUMBERII_H

#endif //LEETCODE_UGLYNUMBERII_H


class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> r(1,1);
        int i2=0,i3=0,i5=0;
        while (r.size()<n) {
            int m2=r[i2]*2,m3=r[i3]*3, m5=r[i5]*5;
            int mn = min(m2, min(m3,m5));
            if (mn == m2) ++i2;
            if (mn == m3) ++i3;
            if (mn == m5) ++i5;
            r.push_back(mn);
        }
        return r.back();
    }
};
