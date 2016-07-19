#!/usr/bin/env python
# -*- coding: utf-8 -*-
import operator

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        d = {}
        for i in nums.sort():
            if i not in d:
                d[i] = 1
            else:
                del d[i]
        return d.keys()[0]
            
    # 参考答案：
    def singleNumber1(self, nums):
        dic = {}
        for num in nums:
            dic[num] = dic.get(num, 0)+1
        for key, val in dic.items():
            if val == 1:
                return key

    def singleNumber2(self, nums): # 也是以两个相同就抵消的凡方式
        res = 0
        for num in nums:
            res ^= num
        return res
    
    def singleNumber3(self, nums):
        return 2*sum(set(nums))-sum(nums)
    
    def singleNumber4(self, nums):
        return reduce(lambda x, y: x ^ y, nums)
    
    def singleNumber5(self, nums): # 内建函数operator,
        return reduce(operator.xor, nums)
            
        
if __name__ == '__main__':
    nums = [2,2,3]
    d = {}
    for i in nums:
        if i not in d:
            d[i] = 1
        else:
            del d[i]
    print d.keys()[0]