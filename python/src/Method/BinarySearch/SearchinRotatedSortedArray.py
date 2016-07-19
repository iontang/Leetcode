#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l, h = 0, len(nums)-1
        while l<=h:
            m = (l+h)/2
            if nums[l] < nums[h]:
                if target < nums[m]:
                    h = m-1
                elif target > nums[m]:
                    l = m+1
                else:
                    return m
            else:
                if nums[l] < nums[m]:
                    if target < nums[m]:
                        h = m-1
                    else:
                        l = m+1
                elif nums[l] > nums[m]:
                    if target > nums[m]:
                        l = m+1
                    else:
                        h = h-1
                else:
                    return m
        return -1                    
# 时间复杂度我线性的
# class Solution(object):
#     def search(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: int
#         """
#         for i, v in enumerate(nums):
#             if v == target:
#                 return i
#         return -1

# 参考答案:http://www.cnblogs.com/higerzhang/p/4046693.html
# class Solution(object):
#     def search(self, nums, target):
#         left, right = 0, len(nums)-1
#         while left <= right:
#             mid = (left + right) / 2
#             if nums[mid] == target:
#                 return mid
#             if nums[mid] < nums[right]:
#                 if nums[mid] < target and target <= nums[right]:
#                     left = mid + 1
#                 else:
#                     right = mid -1
#             else:
#                 if nums[mid] > target and target >= nums[left]:
#                     right = mid - 1
#                 else:
#                     left = mid + 1
#         return -1