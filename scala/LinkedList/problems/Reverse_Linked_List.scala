package LinkedList.problems

import LinkedList.common.ListNode

/**
  * 反转遍历链表，分两种情况，链表改变和不改变
  * 反转遍历本质是递归
  *
  */
object Reverse_Linked_List {
  def main(args: Array[String]): Unit = {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(3)
    node1.next = node2
    node2.next = node3

    // 顺序遍历：
    var temp = node1
    while (temp != null) {
      println(temp.x)
      temp = temp.next
    }


    val result = reverseList(node1)

    var temp2 = result
    while (temp2 != null) {
      println(temp2.x)
      temp2 = temp2.next
    }
  }

  /**
    * 递归的方法
    * @param head
    * @return
    */
  def reverseList(head: ListNode): ListNode = {
    return reverse(head, null)
  }

  def reverse(head: ListNode, preNode : ListNode): ListNode = {
    if (head == null)
      // 递归停止的条件：如果最新的头节点head为null，那么返回该头节点的上一个节点
      return preNode
    val newHead = head.next // 下一个节点作为head节点
    head.next = preNode // 最新的头节点head指向前面的节点
    return reverse(newHead,head)
  }

  /**
    * 迭代的方法：
    */
  def reverseListByIm(head: ListNode): ListNode = {
    var preHead:ListNode = null // 此处不能写成var preHead = null
    var cruHead = head
    while(cruHead != null) {
      val tmpHead = cruHead.next
      cruHead.next = preHead
      preHead = cruHead
      cruHead = tmpHead
    }
    return head
  }

}
