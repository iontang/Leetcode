#!/usr/bin/env python
# -*- coding: utf-8 -*-

# s='abcde'

# print hex(id(s))
# print reversed(s)
# print id(s)
# print hex(id(s))

# aString = 'Hello World!'
# print hex(id(aString))
# # print aString
# # 
# aString = aString[:3] + aString[4:]
# print hex(id(aString))
# # print aString
# 
# aString = aString[:6] + 'Python!'
# print hex(id(aString))
# print aString
# 
# print aString*2
# print hex(id(aString*2)) 
# for i in [None] + range(-1, -len(s), -1):
#     print s[:i]

a = 'Hello'
s = list(a)
print len(s)

# 思路：先转换为列表才能实现操作，因为字符串是不可变对象。，如果直接交换s[l],s[r] = s[r],s[l]，会出错：TypeError: 'unicode' object does not support item assignment
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        l, r =0, len(s)-1
        s = list(s)
        while l <= r:
            if s[l] in 'aeiouAEIOU' and s[r] in 'aeiouAEIOU':
                s[l],s[r] = s[r],s[l]
                l += 1
                r -= 1
            elif s[l] not in 'aeiouAEIOU':
                l += 1
            elif s[r] not in 'aeiouAEIOU':
                r -=1
        return ''.join(list(s))
    
# 参考代码速度更快，
class Solution22(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels='aeiouAEIOU'
        vpos=[i for i,j in enumerate(s) if j in vowels] #先遍历找到所有的元音
        svrev=list(s) # 将字符串转换成数组
        i,j=0,len(vpos)-1
        while i<j:
            svrev[vpos[i]],svrev[vpos[j]]=svrev[vpos[j]],svrev[vpos[i]]
            i+=1
            j-=1
        return ''.join(svrev)