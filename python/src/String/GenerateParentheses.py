#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if not n: # mean True
            return []
        left, right, ans = n, n, []
        self.dfs(left, right, ans, "")
        return ans
    
    def dfs(self, left, right, ans, string):
        if not left and not right: # mean: if left==0 and right==0
            ans.append(string)
            return
        if left:
            self.dfs(left-1, right, ans, string +"(")
        if right > left:
            self.dfs(left, right-1, ans, string + ")")
            
    def dfsCannotBack(self, left, right, ans, string): # 不能回溯的情况，即只能得到一个结果
        if not left and not right: # mean: if left==0 and right==0
            ans.append(string)
            return
        else:
            if left:
                self.dfs(left-1, right, ans, string +"(")
            elif right > left:
                self.dfs(left, right-1, ans, string + ")")