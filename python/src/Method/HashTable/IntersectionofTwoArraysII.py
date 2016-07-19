from collections import Counter


class Solution(object):
    """
    遗留下来需要探究的三个问题：其中第一个和一道二分法题目相似，即找到一个数组中某个数的起始和终点位置的下标并返回
    Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    """
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        d1, d2, l = {}, {}, []
        for val in nums1:
            d1[val] = d1.get(val, 0)+1
        for val in nums2:
            d2[val] = d2.get(val, 0)+1
        for i in d1.keys():
            if d2.has_key(i):
                l += [i]*min(d1.get(i),d2.get(i))
        return l
    
    # 参考答案：
    def intersect2(self, nums1, nums2):
        """
        更加简介的表达，哪个更快一些？
        a, b = map(collections.Counter, (nums1, nums2))
        return list((a & b).elements())
        """
        c1, c2 = Counter(nums1), Counter(nums2) # 统计字典键出现的次数，和我的答案一样，他只是引入了第三方库，此处总结
        return sum([[num] * min(c1[num], c2[num]) for num in c1 & c2], [])
    
    # 这个方法需要的空间只有一个字典，而时间复杂度和第一个是一样的
    def intersect3(self, nums1, nums2):
        dict1 = dict()
        for i in nums1:
            if i not in dict1:
                dict1[i] = 1
            else:
                dict1[i] += 1
        ret = []
        for i in nums2:
            if i in dict1 and dict1[i]>0:
                ret.append(i)
                dict1[i] -= 1
        return ret
    
    # 排好序的解决办法：
    def intersect4(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        res = []
        a = 0
        b = 0
        while a < len(nums1) and b < len(nums2):
            if nums1[a] == nums2[b]:
                res.append(nums1[a])
                a += 1
                b += 1
            elif nums1[a] < nums2[b]:
                a += 1
            else:
                b += 1
        return res
    
    def intersect5(self, nums1, nums2):
        result = []
        for i in range(len(nums1)):
            if nums1[i] in nums2:
                nums2.remove(nums1[i])
                result.append(nums1[i])
        return result
if __name__ == '__main__':
    nums1 = [1,2,2,1]
    nums2 = [1,3,3,1]
    ts = Solution()
    print ts.intersect(nums1, nums2)