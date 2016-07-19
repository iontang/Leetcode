#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    """
    相对于Contains Duplicate，这题多了一个要求：需要找到相同的两个元素，并且比较他们之间的距离，如果中间含有的元素个素小于k，才能返回True
    """
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        d = {}
        for i, v in enumerate(nums):
            if v in d and (i-d[v]-1) < k:
                return True
            d[v] = i
        return False
                    
        
if __name__ == '__main__':
    l1 = [1,2,3,1]
    print min(l1)