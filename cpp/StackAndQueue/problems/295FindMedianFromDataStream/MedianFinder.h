//
// Created by admin on 2019/8/15.
//

#ifndef LEETCODE_FINDMEDIANFROMDATASTREAM_H
#define LEETCODE_FINDMEDIANFROMDATASTREAM_H

#endif //LEETCODE_FINDMEDIANFROMDATASTREAM_H


class MedianFinder {
    priority_queue<int> maxHeap;
    priority_queue<int, vector<int>, greater<int>> minHeap;

public:
    /** initialize your data structure here. */
    MedianFinder() {

    }

    void addNum(int num) {
        maxHeap.push(num);
        minHeap.push(maxHeap.top());
        maxHeap.pop();
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }

    double findMedian() {
        return maxHeap.size() > minHeap.size() ? (double) maxHeap.top() : (maxHeap.top() + minHeap.top()) * 0.5;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */