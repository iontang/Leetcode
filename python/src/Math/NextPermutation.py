#!/usr/bin/env python
# -*- coding: utf-8 -*-

# http://bangbingsyb.blogspot.jp/2014/11/leetcode-next-permutation.html
class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        for i in enumerate(nums[::-1]):
            while i < (len(nums)-1):
                if nums[i] > nums[i+1]:
                    nums[i],nums[i+1] = nums[i+1],nums[i]
                    
                    
                

# y = [2,1,4,5,6,7,8]     
# for i, v in enumerate(y[::-1]):
#     print i
#     if i < (len(y)-1):
#         print i