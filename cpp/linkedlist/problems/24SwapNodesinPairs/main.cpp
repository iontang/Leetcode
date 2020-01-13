#include <iostream>
#include "SwapNodesinPairs.h"

//
// Created by admin on 2019/8/7.
//

// another method to create ListNode.
ListNode *create_linkedlist(std::initializer_list<int> lst)
{
    auto iter = lst.begin();
    ListNode *head = lst.size() ? new ListNode(*iter++) : NULL;
    for (ListNode *cur=head; iter != lst.end(); cur=cur->next)
        cur->next = new ListNode(*iter++);
    return head;
}

int main()
{
    ListNode *head = create_linkedlist({1,2,3,4,5});
    Solution s;
    s.swapPairs(head);

}