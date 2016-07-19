#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        """
        Last executed input:下面这段代码测试时候为什么会陷入无限循环？
        [1,2,2,3,4,4,4]
        4
        """
        l, r = 0, len(nums)-1
        while l<r:
            mid = (1+r)/2
            if nums[mid] == target:
                start = end = mid
#                 while end<=r:
#                     m1 = (end+r)/2
#                     if nums[m1] == target:
#                         end = m1
#                     elif nums[m1] > target:
#                         r = m1-1
#                     break
#                 while l<=start:
#                     m2 = (l+start)/2
#                     if nums[m2] == target:
#                         start = m2
#                     elif nums[m2] < target:
#                         l = m2+1
#                     break
                for i,x in enumerate(nums[mid+1:len(nums)]):
                    if nums[end]==x:
                        end = i
                for x in enumerate(nums[:mid+1]):
                    if nums[start] == x:
                        start = i
                return [start,end]
            elif nums[mid] > target:
                r = mid-1
            else:
                l = mid+1
        return [-1,-1]

# 线性时间复杂度的写法：    
class Solution22(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        start = end = -1;j = 0
        for i, v in enumerate(nums):
            if target == v:
                end = i
                j +=1
            start = end-j+1
        return [start,end]