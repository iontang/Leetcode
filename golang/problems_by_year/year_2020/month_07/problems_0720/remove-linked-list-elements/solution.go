package main

func main() {
}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	fakeHead := &ListNode{-1, head}
	resNode := fakeHead
	for nil != head {
		if head.Val == val {
			fakeHead.Next = head.Next
		} else {
			fakeHead = head
		}
		head = head.Next
	}
	return resNode.Next
}

func removeElements_A1(head *ListNode, val int) *ListNode {
	if head == nil {
		return head
	}
	var p1 *ListNode
	p2 := head
	for p2 != nil {
		if p2.Val == val {
			if p2 == head {
				head = head.Next
				p2 = head
			} else {
				p1.Next, p2 = p2.Next, p2.Next
			}
		} else {
			p1 = p2
			p2 = p2.Next
		}
	}
	return head
}
