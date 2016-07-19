#!/usr/bin/env python
# -*- coding: utf-8 -*-
import collections

class Solution(object):
    def isAnagram(self, s, t):
        """
        特殊情况：如果利用dict先将一个s存储起来，那么相同的字符只会存在一个，所以应该同时循环两个。
        "aacc"
        "ccac"
        最后返回的时候不能通过值相加为0判断是否同构。即：return True if sum(d.values())==0 else False
        http://stackoverflow.com/questions/35253971/how-to-check-if-all-values-of-a-dictionary-are-0-in-python
        """
        if len(s) != len(t):
            return False
        d = {}
        for val in s:
            d[val] = d.get(val,0) + 1
        for ch in t:
            if ch in d:
                d[ch] = d.get(ch) - 1
        return not any(d.itervalues())
            
    # 参考方法
    def isAnagram1(self, s, t):
        dic1, dic2 = {}, {}
        for item in s:
            dic1[item] = dic1.get(item, 0) + 1
        for item in t:
            dic2[item] = dic2.get(item, 0) + 1
        return dic1 == dic2

    def isAnagram2(self, s, t):
        dic1, dic2 = [0]*26, [0]*26
        for item in s:
            dic1[ord(item)-ord('a')] += 1
        for item in t:
            dic2[ord(item)-ord('a')] += 1
        return dic1 == dic2
    
    def isAnagram3(self, s, t):
        return sorted(s) == sorted(t)
    
    def isAnagram4(self, s, t):
        return collections.Counter(s) == collections.Counter(t)
        
if __name__ == '__main__':
    s, t = 'aacc', 'ccac'
    print hex(id(s))
    print hex(id(sorted(s)))
    test = Solution()
    print test.isAnagram(s, t)