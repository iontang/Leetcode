//
// Created by admin on 2019/8/22.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

#endif //LEETCODE_SOLUTION_H


class Solution {
public:
    int majorityElement(vector<int>& nums) {
        auto cnt = 0, pre = 0;
        for (auto i : nums) {
            if (cnt == 0) {
                pre = i; //赋值
            }
            if (pre == i) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return pre;
    }
};