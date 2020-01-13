//
// Created by admin on 2019/8/13.
//

#ifndef LEETCODE_TOPKFREQUENTWORDS_H
#define LEETCODE_TOPKFREQUENTWORDS_H

#endif //LEETCODE_TOPKFREQUENTWORDS_H


class Solution {
public:

    struct Comp {
        bool operator()(pair<string, int> &lhs, pair<string, int> &rhs) {
            if (lhs.second > rhs.second) {
                return true;
            } else if (lhs.second < rhs.second) {
                return false;
            }
            return lhs.first < rhs.first;
        }
    };

    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> count;
        for (auto &word: words) {
            ++count[word];
        }
        priority_queue<pair<string, int>, vector<pair<string,int>>, Comp> pq;
        auto it = count.begin();
        for (int i=0; i<count.size();++i, ++it) {
            pq.push(*it);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<string> result;
        while(!pq.empty()) {
            result.push_back(pq.top().first); // 只取字符。
            pq.pop();
        }
        reverse(result.begin(),result.end());
        return result;
    }
};
