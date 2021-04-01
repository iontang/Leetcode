package design.problems.LRUCache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class LRUCache {

    // ["LRUCache","put","put","get","put","get","get"]
    // [[2],[2,1],[1,1],[2],[4,1],[1],[2]]
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        // 第一个版本测试：
//        lruCache.put(2,1);
//        lruCache.put(1,1);
//        lruCache.get(2);
//        lruCache.put(4,1);
//        lruCache.get(1);
//        lruCache.get(2);

        // 第二个版本测试：
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }

    /**
     * 第一个版本，不明白key和value不同，以为key和value的值一定相等，两者实则不等；
     * 如果就只有value这个值，可以用双向链表实现，删除和添加都是O(1)；
     * 但是现在是key=value形式的，要想实现添加删除更新的key=value对，以及针对每一个key=value对，获取key对应的value值，就需要双向链表加上哈希表的这种数据结构的组合。
     *
     */
//    LinkedList<Integer> linkedList;
//    int capacity;
//
//    public LRUCache(int capacity) {
//        linkedList = new LinkedList<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (linkedList.contains(key)) {
//            return key;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (linkedList.contains(key)) {
//            linkedList.remove(value);
//            linkedList.addFirst(value);
//        } else {
//            if (linkedList.size() < capacity) {
//                linkedList.addFirst(value);
//            } else {
//                linkedList.removeLast();
//                linkedList.addFirst(value);
//            }
//        }
//    }


    /**
     * 此版本无法实现最近最少，测试例子中，1是最开始进入的，但是后来取出来一次，这个时候再添加3的时候，应该删除2，而不是删除1。
     */
//    LinkedHashMap<Integer, Integer> hashMap;
//    public LRUCache(int capacity) {
//        // 重写这个链表移除最后一个元素的方法。
//        hashMap = new LinkedHashMap<Integer, Integer> () {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
//                return size() > capacity;
//            }
//        };
//    }
//    public int get(int key) {
//        if (hashMap.containsKey(key)) {
//            return hashMap.get(key);
//        }
//        return -1;
//    }
//    public void put(int key, int value) {
//        if (hashMap.containsKey(key)) {
//            hashMap.remove(key);
//        }
//        hashMap.put(key,value);
//    }


    /**
     * 第三个版本：正确，为了避免第二个版本的错误，每次get的时候，如果缓存中存在值，都需要把这个值提取到链表头；
     * 这种做法的效率是多少？
     */
//    LinkedHashMap<Integer, Integer> hashMap;
//    public LRUCache(int capacity) {
//        // 重写这个链表移除最后一个元素的方法。
//        hashMap = new LinkedHashMap<Integer, Integer> () {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
//                return size() > capacity;
//            }
//        };
//    }
//    public int get(int key) {
//        if (hashMap.containsKey(key)) {
//            int value = hashMap.get(key);
//            hashMap.remove(key);
//            hashMap.put(key,value);
//            return value;
//        }
//        return -1;
//    }
//    public void put(int key, int value) {
//        if (hashMap.containsKey(key)) {
//            hashMap.remove(key);
//        }
//        hashMap.put(key,value);
//    }


    /**
     * 第三个版本的升级版：主要差别是在accessOrder这个值上
     * https://www.cnblogs.com/lzrabbit/p/3734850.html 解释如下：
     *
     * LinkedHashMap的一个构造函数，当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
     */
    LinkedHashMap<Integer, Integer> hashMap;
    public LRUCache(int capacity) {
        // 重写这个链表移除最后一个元素的方法。
        hashMap = new LinkedHashMap<Integer, Integer>(16,0.75f,true) {

            //anonymous inner class to override removeEldestEntry behaivor.
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return  hashMap.size() > capacity;
            }
        };
    }
    public int get(int key) {
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        return -1;
    }
    public void put(int key, int value) {
        hashMap.put(key, value);
    }


}