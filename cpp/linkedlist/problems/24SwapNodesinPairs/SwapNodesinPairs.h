//
// Created by admin on 2019/8/7.
//

#ifndef LEETCODE_SWAPNODESINPAIRS_H
#define LEETCODE_SWAPNODESINPAIRS_H

#endif //LEETCODE_SWAPNODESINPAIRS_H



struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    ListNode* swapPairs(ListNode* head) {

        ListNode newHead(-1);
        newHead.next = head;
        ListNode *pre = &newHead;
        ListNode *curr = head;
        while( curr!= nullptr && curr->next != nullptr) { // current node is not null
           ListNode *tmp1 = curr->next->next;
           pre->next = curr->next;
           curr->next->next = curr;
           curr->next = tmp1;

           pre = curr;
           curr = curr->next;
        }
        return newHead.next;
    }
};