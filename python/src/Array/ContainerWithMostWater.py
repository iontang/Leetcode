#!/usr/bin/env python
# -*- coding: utf-8 -*-

# 暴力求解，时间复杂度为O(n^2)
# class Solution(object):
#     def maxArea(self, height):
#         """
#         :type height: List[int]
#         :rtype: int
#         """
#         temp = 0
#         # 如何设置j从1开始
#         # 将for j in range(len(height)):改为下面的
#         for i in range(len(height)-1):
#             for j in range(i+1, len(height)):
#                 if (j-i) * min(height[i], height[j]) > temp:
#                     temp = (j-i) * min(height[i], height[j])
#         return temp
    
    
# 以空间替代时间的方法：时间 O(N) 空间 O(N)。两者的区别——暴力求解法是逐渐改变纵坐标的长度，这个方法是逐渐改变横坐标的长度。因为有两个变量，所以必须考虑控制其中一个变量，让另外一个进行改变。
# 参考方法:
# http://bangbingsyb.blogspot.jp/2014/11/leetcode-container-with-most-water.html
# http://blog.csdn.net/ljiabin/article/details/41673753
# http://www.cnblogs.com/yuzhangcmu/p/4057252.html

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height)==0:
            return 0
        temp = 0
        L = 0
        R = len(height)-1
        while L < R:
            if temp < (R-L)*min(height[L], height[R]):
                temp = (R-L)*min(height[L], height[R])
            if height[L] < height[R]:
                L += 1
            elif height[L] > height[R]:
                R -= 1
            else:
                L += 1
                R -= 1 
        return temp
    
print (0+1)/2
# 参考答案，时间快，为什么？
# class Solution(object):
#     def maxArea(self, height):
#         """
#         :type height: List[int]
#         :rtype: int
#         """
#         maxVal= 0
#         # Use two pointer: head pointer and tail pointer
#         i = 0;j = len(height)-1
#         while i != j:
#             currVal = j-i
#             if height[i] < height[j]:
#                 currVal, i, j = currVal * height[i], i+1, j 
#             else :
#                 currVal, i, j = currVal * height[j], i, j-1 
#             maxVal = currVal if currVal > maxVal else maxVal
#         return maxVal;
