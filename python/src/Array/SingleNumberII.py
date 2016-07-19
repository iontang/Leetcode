#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    """
    考查异或操作的题目
    http://bangbingsyb.blogspot.jp/2014/11/leetcode-single-number-i-ii.html
    http://www.acmerblog.com/leetcode-single-number-ii-5394.html
    """
    # 这种解法需要额外的空间。
    def singleNumber2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return (sum(set(nums))*3 - sum(nums))/2
        
if __name__ == '__main__':
    nums = [2,2,2,3,3,3,1]
    print hex(id(set(nums)))
    print hex((id(nums)))
    print (sum(set(nums))*3 - sum(nums))/2