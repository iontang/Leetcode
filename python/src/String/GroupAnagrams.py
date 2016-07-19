#!/usr/bin/env python
# -*- coding: utf-8 -*-
import collections

class Solution(object):
    """
    其他的参考答案：
    https://leetcode.com/discuss/10965/line-python-solution-ac-with-350ms-some-useful-python-tricks
    https://leetcode.com/discuss/28695/map-lambda-list-comprehension-3-lines-of-python  ————这个可以
    """
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        d = {}
        for val in strs:
            d["".join(sorted(val))] = d.get("".join(sorted(val)), []) + [val]
        return d.values() # 不用这样写：[i for i in d.values()]
    
    # 参考答案的另外一种写法：
    def groupAnagrams1(self, strs):
        dic = {}
        for item in sorted(strs):
            sortedItem = ''.join(sorted(item))
            dic[sortedItem] = dic.get(sortedItem, []) + [item]
        return dic.values()
    

if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    s = 'tae'
    print collections.defaultdict(s) 
    print sorted(s)
    d = dict([(k, v) for k, v in enumerate(strs)])
    print d