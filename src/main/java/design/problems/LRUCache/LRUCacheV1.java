package design.problems.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName LRUCacheV1
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/2/26 10:18 上午
 */
public class LRUCacheV1 {

    private final int capacity;
    private final Map<Integer, DoubleLinkedNode> map;
    private final DoubleLinkedNode head = new DoubleLinkedNode(-1, -1);
    private final DoubleLinkedNode tail = new DoubleLinkedNode(-1, -1);

    public LRUCacheV1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCacheV1 lruCacheV1 = new LRUCacheV1(2);
//        lruCacheV1.get(2);
//        lruCacheV1.put(1,1);
//        lruCacheV1.put(2,2);
//        lruCacheV1.get(1);
//        lruCacheV1.put(3,3);
//        lruCacheV1.get(2);
//        lruCacheV1.put(4,4);
//        lruCacheV1.get(1);
//        lruCacheV1.get(3);
//        lruCacheV1.get(4);

        lruCacheV1.get(2);
        lruCacheV1.put(2, 1);
        lruCacheV1.put(2, 2);
        lruCacheV1.get(2);
        lruCacheV1.put(1, 1);
        lruCacheV1.put(4, 1);
        lruCacheV1.get(2);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedNode node = map.get(key);
            moveNode2End(node);
            return map.get(key).nodeValue;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = new DoubleLinkedNode(key, value);
        if (map.size() == 0) {
            // 第一个节点，插入到head指针和tail指针之间
            node.next = head;
            node.pre = tail;
            head.pre = node;
            tail.next = node;
        } else {
            if (map.containsKey(key)) {
                // 如果已经存在这个节点，删除该节点
                DoubleLinkedNode existNode = map.get(key);
                this.deleteNode(existNode);
            }
            if (map.size() >= capacity) {
                // 超过容量，删除尾节点
                this.deleteNode(tail.next);
            }
            node.next = head;
            node.pre = head.pre;
            head.pre.next = node;
            head.pre = node;
        }
        map.put(key, node);
    }

    /**
     * 节点移到队列首部
     *
     * @param node
     */
    private void moveNode2End(DoubleLinkedNode node) {
        // 先删除该节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 将节点放到头部
        node.pre = head.pre;
        head.pre.next = node;
        // 节点和head指针互指
        node.next = head;
        head.pre = node;
    }

    /**
     * 删除尾部节点
     */
    private void deleteNode(DoubleLinkedNode node) {
        // 插入尾部，移除map对应的键值对
        map.remove(node.nodeKey);
        // 删除节点
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    class DoubleLinkedNode {
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        int nodeKey;
        int nodeValue;

        DoubleLinkedNode(int key, int value) {
            this.nodeKey = key;
            this.nodeValue = value;
        }

    }

}