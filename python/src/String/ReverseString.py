#!/usr/bin/env python
# -*- coding: utf-8 -*-

# http://stackoverflow.com/questions/931092/reverse-a-string-in-python
class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        return s[::-1]


# 第二种方法：哪种更简便？
# return ''.join(reversed(list(s)))