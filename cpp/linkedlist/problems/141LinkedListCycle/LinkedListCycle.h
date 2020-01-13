//
// Created by admin on 2019/8/9.
//

#ifndef LEETCODE_LINKEDLISTCYCLE_H
#define LEETCODE_LINKEDLISTCYCLE_H

#endif //LEETCODE_LINKEDLISTCYCLE_H


// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast != nullptr && fast->next != nullptr && fast->next->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow->val == fast->val) {
                return true;
            }
        }
        return false;
    }
};