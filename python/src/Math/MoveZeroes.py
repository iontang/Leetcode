#!/usr/bin/env python
# -*- coding: utf-8 -*-

# 不用考虑交换，在原来的数组上面直接替换，然后
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        # python中没有自增自减
        p = 0
        for i in nums:
            if i!=0:
                nums[p] = i
                p=p+1
                
        while p < len(nums):
            nums[p]=0
            p=p+1
            
        return nums # 不需要返回任何值
    
        # 这个方法写的代码更少
#         last0=0
#         for i in range(0,len(nums)):
#             if (nums[i]!=0):
#                 nums[i],nums[last0] = nums[last0],nums[i]
#                 last0+=1

# 测试代码
nums=[3,0,2,19,20]
test=Solution()
print test.moveZeroes(nums)

# 第二种做法：标记1或0然后排序
# class Solution(object):
#     def moveZeroes(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: void Do not return anything, modify nums in-place instead.
#         """
#         nums.sort(key= lambda x: 1 if x == 0 else 0)
# 
# nums=[3,0,2,0,20]
# test=Solution()
# print test.moveZeroes(nums)