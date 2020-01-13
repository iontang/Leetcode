//
// Created by admin on 2019/8/19.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

#endif //LEETCODE_SOLUTION_H

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size())
            return false;
        vector<char> vs(s.begin(), s.end());
        unordered_map<char, int> ms;
        for (const char &c :vs) {
            ++ms[c];
        }

        vector<char> vt(t.begin(),t.end());
        for (const char &tc : vt) {
            if(ms.find(tc) != ms.end()){
                --ms[tc];
            }
        }

        auto iter = ms.begin();

        while (iter != ms.end()) {
            if (iter->second > 0) {
                return false;
            }
            iter++;
        }
        return true;
    }
};