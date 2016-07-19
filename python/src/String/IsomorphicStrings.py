#!/usr/bin/env python
# -*- coding: utf-8 -*-

# 参考答案：https://leetcode.com/discuss/48674/python-different-solutions-dictionary-etc
class Solution(object):
    def isIsomorphic(self, s, t):
        """
        print sorted(d1.values()):
        [[0, 2], [1], [3], [4, 5]]
        print sorted(d2.values()):
        [[0, 2], [1], [3], [4, 5]]
        """
        d1, d2 = {}, {}
        for i, val in enumerate(s):
            d1[val] = d1.get(val, []) + [i] # 获取键对应值并且以列表形式返回如——p:[0]+[2]==【0,2】
            print d1.get(val, [])
        for i, val in enumerate(t):
            d2[val] = d2.get(val, []) + [i]

        return sorted(d1.values()) == sorted(d2.values())

    def isIsomorphic2(self, s, t):
        d1, d2 = [[] for _ in xrange(256)], [[] for _ in xrange(256)] # 生成256个ASCii码放入两个字典，值是256个空的list
        for i, val in enumerate(s):
            d1[ord(val)].append(i) # ord()是将字符转换成对应的ASCII码，并将其索引保存在对应键的list中
        for i, val in enumerate(t):
            d2[ord(val)].append(i)
        return sorted(d1) == sorted(d2)
    
    def isIsomorphic3(self, s, t):
        """
        zip(s, t):  
        [('p', 't'), ('e', 'k'), ('p', 't'), ('k', 'x'), ('a', 'b'), ('a', 'b')]
        set(zip(s, t)):
        set([('p', 't'), ('a', 'b'), ('k', 'x'), ('e', 'k')])
        set(s):
        set(['a', 'p', 'k', 'e'])
        set(t)
        set(['x', 'k', 'b', 't'])
        """
        return len(set(zip(s, t))) == len(set(s)) == len(set(t))
    
    def isIsomorphic4(self, s, t): 
        """
        关于find()方法的解释
        https://docs.python.org/2/library/string.html
        
        如果同构的话，其获得的索引字符串必定相同
        [0, 1, 0, 3, 4, 4]
        [0, 1, 0, 3, 4, 4]
        """
        return [s.find(i) for i in s] == [t.find(j) for j in t]
    
    def isIsomorphic5(self, s, t):
        """
        类似于上一个方法
        [0, 1, 0, 3, 4, 4]
        [0, 1, 0, 3, 4, 4]
        """
        return map(s.find, s) == map(t.find, t)
    
    def isIsomorphic6(self, s, t):
        d1, d2 = [0 for _ in xrange(256)], [0 for _ in xrange(256)]
        for i in xrange(len(s)):
            if d1[ord(s[i])] != d2[ord(t[i])]:
                return False
            d1[ord(s[i])] = i+1
            d2[ord(t[i])] = i+1
        return True
        
if __name__ == '__main__':
    test = Solution()
    s, t = 'pepkaa', 'tktxbb'
    print test.isIsomorphic(s,t)
    
print [1]+[2]