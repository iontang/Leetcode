#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Solution(object):
    """
    http://bangbingsyb.blogspot.jp/2014/11/leetcode-longest-substring-without.html
    http://fisherlei.blogspot.jp/2012/12/leetcode-longest-substring-without.html
    """
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        d, l, pre = {}, 0, 0
        for i, val in enumerate(s):
            if val in d and pre <= d[val]: # 字典的键是唯一的，所以只需要写：in d，而不是in d.values()，如何写后者，是错误的。为什么？
                pre = d[val]+1
            else:
                l = max(l, i-pre+1)
            d[val] = i
        return l
    
    # 参考答案：这种比较大小的写法速度好像更快。
    def lengthOfLongestSubstring4(self, s):
        word_offset, max_pat, last_dup = {}, 0, -1
        # word_offset: dictionary for word and its last position
        # max_pat: max pattern
        # last_dup: last position for duplicate word
        for idx, ch in enumerate(s):
            if ch in word_offset and word_offset[ch] > last_dup:
                last_dup = word_offset[ch]
            pat = idx - last_dup
            if pat > max_pat:
                max_pat = pat
            word_offset[ch] = idx

        return max_pat
    
    # 自己写的不知道如何排除多余无效子字符串的代码。
    def lengthOfLongestSubstring3(self, s):
        """
        :type s: str
        :rtype: int
        """
        d, l, pre = {}, 0, 0
        for i, val in enumerate(s):
            if val not in d.values():
                d[val] = i
                if l < (i-pre+1):
                    l = i-pre+1
            else:
                if l < (i-pre):
                    l = i-pre
                pre = d[val]+1
                d[val] = i
        return l
    
    def lengthOfLongestSubstring2(self, s):
        if len(s)==1 or not len(s):
            return s
        pre, last, l = 0, 1, 1
        for i in range(len(s)):
            if s[pre] != s[last] and s[last-1] != s[last]:
                if l < (last-pre):
                    l = last-pre
                last+=1
            else:
                pre+=1
                last+=1
                
if __name__ == '__main__':
    s = 'qpxrjx'
    d = dict()
    for i, val in enumerate(s):
        d[val] = i
    print d.items()
    print d.get("p")+1
        