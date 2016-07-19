#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    
    # 用hashtable试试：
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        d, l = {}, []
        for i, val in enumerate(set(nums1)):
            d[i] = val
        for i, vali in enumerate(set(nums2)):
            if vali in d.values():
                l.append(vali)
        return l
    
    # 复杂度太高
    def intersection2(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        com = []
        for i, val in enumerate(set(nums1)):
            for j,valj in enumerate(set(nums2)):
                if val == valj:
                    com.append(val)
        return com
    
    # 其他方法：
    def intersection3(self, nums1, nums2):
        """
        unsupported operand type(s) for &: 'list' and 'list'：逻辑运算符&不支持list运算，只支持集合。
        return list(nums1&nums2)
        """
        return list(set(nums1) & set(nums2))
    

    def intersection4(self, nums1, nums2):
        res = []
        for i in nums1:
            if i not in res and i in nums2:
                res.append(i)
        return res
    
if __name__ == '__main__':
    s = [1,2,2,1]
    t = [1]
    ts = Solution()
    print ts.intersection(s, t)
#     print set([1,2,2,1])
#     print zip([1,3], [4,2,3])