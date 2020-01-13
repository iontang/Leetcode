//
// Created by admin on 2019/8/9.
//

#ifndef LEETCODE_BACKSPACESTRINGCOMPARE_H
#define LEETCODE_BACKSPACESTRINGCOMPARE_H

#endif //LEETCODE_BACKSPACESTRINGCOMPARE_H

#include <stack>
#include <string>

class Solution {
public:
    bool backspaceCompare(string S, string T) {
        std::stack <int> s1;
        for (std::string::size_type i = 0; i < S.length(); i++)
        {
            if (S[i] == '#') {
                s1.pop();
            } else {
                s1.push(S[i]);
            }
        }
        std::stack <int> s2;
        for (std::string::size_type i = 0; i < T.length(); i++)
        {
            if (T[i] == '#') {
                s1.pop();
            } else {
                s1.push(T[i]);
            }
        }
        if (s1.size() != s2.size()) {
            return false;
        }
        while (!s1.empty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return true;
    }
};