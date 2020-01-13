//
// Created by admin on 2019/8/19.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

#endif //LEETCODE_SOLUTION_H


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> v;
        if (nums.size() == 0)
            return v;

        unordered_map<int, int> diffValueMap;
        for (int i=0; i< nums.size();i++) {
            diffValueMap[nums[i]] = i;
        }

        for (int i=0; i< nums.size(); i++) {
            // find key.
            if (diffValueMap.find(target - nums[i]) != diffValueMap.end() && i != diffValueMap[target - nums[i]]) {
                v.emplace_back(i);
                v.emplace_back(diffValueMap[target - nums[i]]);
                break;
            }
        }

        return v;

    }
};