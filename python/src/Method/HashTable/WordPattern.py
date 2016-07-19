#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        d1, d2 = {}, {}
        slist = str.split(" ")
        for i, val in enumerate(pattern):
            d1[val] = d1.get(val, []) + [i]
        for i, val in enumerate(slist):
            d2[val] = d2.get(val, []) + [i]
        return sorted(d1.values()) == sorted(d2.values())
            
    
    def wordPattern2(self, pattern, str):
        """
        this way can't work of the example:
        "aaa"
        "aa aa aa aa"
        """
        slist = str.split(" ")
        print zip(pattern, slist)
        return len(set(zip(pattern, slist))) == len(set(pattern)) == len(set(slist))
    
    # 方法2的改进：
    def wordPattern3(self, pattern, str):
        """
        在return后面加上一个条件
        """
        slist = str.split(" ")
        return len(set(zip(pattern, slist))) == len(set(pattern)) == len(set(slist)) and len(pattern)==len(slist)

    def wordPattern4(self, pattern, str):
        s = pattern
        t = str.split() # 这里转变成为一个list，所以下面只能用index读取索引，而字符串可以使用find，index
        return map(s.find, s) == map(t.index, t)
    
    def wordPattern5(self, pattern, str):
        f = lambda s: map({}.setdefault, s, range(len(s)))
        return f(pattern) == f(str.split())
    
if __name__ == '__main__':
    p, str = "abba", "dog cat cat dog"
    test = Solution()
    print test.wordPattern(p, str)
    # 关于分割符：http://blog.csdn.net/doiido/article/details/43204675
    print str.split(" ")
    print str.split()