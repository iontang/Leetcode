//
// Created by admin on 2019/8/12.
//

#ifndef LEETCODE_KTHLARGESTELEMENTINASTREAM_H
#define LEETCODE_KTHLARGESTELEMENTINASTREAM_H

#endif //LEETCODE_KTHLARGESTELEMENTINASTREAM_H


#include <queue>

using namespace std;

class KthLargest {
    priority_queue<int, vector<int>, greater<int>> pq;
    int topK;
public:
    KthLargest(int k, vector<int>& nums): {
        topK = k;
        for (auto& i : nums) {
            pq.push(i);
        }
    }

    int add(int val) {
        pq.push(val);
        if (pq.size() > topK) {
            pq.pop();
        }
        return pq.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */