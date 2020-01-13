//
// Created by admin on 2019/8/23.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

#endif //LEETCODE_SOLUTION_H


class Solution {
public:


    int maxProfit(vector<int>& prices) {

        if (prices.size() == 0) return 0;
        int result = 0;
        int minEle = INT_MAX;
        for (int i=0;i<prices.size();i++) {
            if (prices[i] < minEle ) {
                minEle = prices[i];
            } else {
                if (prices[i] - minEle > result) {
                    result = prices[i] -minEle;
                }
            }
        }
        return result;
    }

    // O(n^2)
//    int maxProfit(vector<int>& prices) {
//        int result = 0;
//        if (prices.size() == 0) return result;
//        for (int i=0;i<prices.size()-1;i++) {
//            for (int j =i+1;j<prices.size();j++) {
//                if (prices[j]-prices[i] > result) {
//                    result = prices[j]-prices[i];
//                }
//            }
//        }
//        return result;
//    }

};