package design.problems.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName LRUCacheV2
 * 范型版本
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2021/2/26 5:00 下午
 */
public class LRUCacheV2<K, V> {
    private final int capacity;

    private final Map<K, DoubleLinkedNode> map;

    private final DoubleLinkedNode head = new DoubleLinkedNode(-1, -1);
    private final DoubleLinkedNode tail = new DoubleLinkedNode(-1, -1);

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            DoubleLinkedNode node = map.get(key);
            moveNode2End(node);
            return (V) map.get(key).nodeValue;
        }
        return null;
    }

    public void put(K key, V value) {
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

    class DoubleLinkedNode<K, V> {
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        K nodeKey;
        V nodeValue;

        DoubleLinkedNode(K key, V value) {
            this.nodeKey = key;
            this.nodeValue = value;
        }

    }

}
