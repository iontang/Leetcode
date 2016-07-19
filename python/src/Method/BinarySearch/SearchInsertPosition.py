#!/usr/bin/env python
# -*- coding: utf-8 -*-

# class Solution(object):
#     def searchInsert(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: int
#         """
# #         l=0
# #         r=len(nums)-1
#         l, r = 0, len(nums)-1
#         while l<=r:
#             mid = (l+r)/2
#             if nums[mid] < target:
#                 l = mid+1
#                 if l<=r and target < nums[l]:
#                     return l
#             elif nums[mid] > target:
#                 r = mid-1
#                 if r>=0 and target > nums[r] :
#                     return mid
#             else:
#                 return mid
#         return 0 if target<nums[0] else 1
    


# 参考答案：时间复杂度比前面的大。相当于重新复制了一个list
# class Solution(object):
#     def searchInsert(self, nums, target):
#         return len([x for x in nums if x<target])


# 精度小而且简洁的：这个代码从时间复杂度和特殊情况  两方面来处理，使得时间是最快的。
class Solution(object):
    def searchInsert(self, nums, target):
        if target > nums[len(nums) - 1]:
            return len(nums)
        if target < nums[0]:
            return 0
        l, r = 0, len(nums)-1
        while l<=r:
            mid = (l+r)/2
            if nums[mid] < target:
                l = mid+1
            elif nums[mid] > target:
                r = mid-1
            else:
                return mid
        return l
    
temp = [1,3]
tar = 0
ss = Solution()
print ss.searchInsert(temp, tar)