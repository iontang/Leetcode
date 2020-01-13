#include <iostream>
#include "ReverseLinkedList.h"

// another method to create ListNode.
ListNode *create_linkedlist(std::initializer_list<int> lst)
{
    auto iter = lst.begin();
    ListNode *head = lst.size() ? new ListNode(*iter++) : NULL;
    for (ListNode *cur=head; iter != lst.end(); cur=cur->next)
        cur->next = new ListNode(*iter++);
    return head;
}

int main() {

    ListNode node1(1);
    ListNode node2(2);
    ListNode node3(3);
    ListNode node4(4);
    ListNode node5(5);
    ListNode node6(6);
    node1.next = &node2;
    node2.next = &node3;
    node3.next = &node4;
    node4.next = &node5;
    node5.next = &node6;
    Solution s;
    for (ListNode *cur=s.reverseList(&node1); cur; cur=cur->next)
        std::cout << cur->val << "->";
    std::cout << "\b\b  " << std::endl;


//    ListNode *head = create_linkedlist({1,2,3,4,5});
//    Solution s;
//    for (ListNode *cur=s.reverseList(head); cur; cur=cur->next)
//        std::cout << cur->val << "->";
//    std::cout << "\n\n  " << std::endl;

	return 0;
}
