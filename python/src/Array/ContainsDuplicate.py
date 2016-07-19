#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        return True if len(set(nums)) < len(nums) else False # 更简单的表达：return len(nums) > len(set(nums))。 下面这句好像更快 ：return len(set(nums)) != len(nums)
        
if __name__ == '__main__':
    
    l1 = [1,2,3,1]
    print list(set(l1)) & l1